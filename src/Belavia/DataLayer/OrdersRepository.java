package Belavia.DataLayer;

import Belavia.BusinessLogic.FileDataLoader;
import Belavia.DataLayer.Entities.Order;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrdersRepository {

    public OrdersRepository(){
        Loader = new FileDataLoader<>();
        this.LoadOrders();
    }

    private List<Order> Orders;
    private FileDataLoader<List<Order>> Loader;

    public List<Order> getOrders() {
        return Orders;
    }

    public Order GetById(int id){
        return Orders.stream()
            .filter(order -> order.getId() == id)
            .findAny()
            .orElse(null);
    }

    public List<Order> Get(Comparator<Order> comparator){
        return Orders.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public void AddOrder(Order order){
        if(order == null){
            throw new IllegalArgumentException();
        }

        if(this.Orders.indexOf(order) != -1){
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

    public List<Order> SearchByCustomerName(String customerName){
         return Orders.stream()
                .filter(order -> order.getCustomer() != null && order.getCustomer().getName().contains(customerName))
                .collect(Collectors.toList());
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
