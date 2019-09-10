package Belavia.DataLayer;

import Belavia.BusinessLogic.FileDataLoader;
import Belavia.DataLayer.Entities.Order;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class OrdersRepository {

    public OrdersRepository(){
        this.LoadOrders();
    }

    private ArrayList<Order> Orders;
    private FileDataLoader<ArrayList<Order>> Loader;

    public ArrayList<Order> getOrders() {
        return Orders;
    }

    public Order GetById(int id){
        return Orders.stream()
            .filter(order -> order.getId() == id)
            .findAny()
            .orElse(null);
    }

    public Order[] Get(Comparator<Order> comparator){
        return (Order[]) Orders.stream()
                .sorted(comparator)
                .toArray();
    }

    public void AddOrder(Order order){
        if(order == null){
            throw new IllegalArgumentException();
        }

        this.Orders.add(order);
        this.SaveChanges();
    }

    public boolean RemoveOrder(Order order){
        var successful = this.Orders.remove(order);
        this.SaveChanges();
        return successful;
    }

    public void Update(Order order) throws InvalidObjectException {
        var index = this.Orders.indexOf(order);

        if(index == -1){
            throw new InvalidObjectException("Entity was not present in data set.");
        }

        this.Orders.set(index, order);
        this.SaveChanges();
    }

    public void LoadOrders(){
        if((Orders = Loader.LoadFromDisk()) == null){
            Orders = new ArrayList<>();
        }
    }

    public void SaveChanges(){
        try {
            Loader.UpdateDataOnDisk(Orders);
        } catch (IOException e) {
            System.out.println("Failed to save data.");
            e.printStackTrace();
        }
    }
}
