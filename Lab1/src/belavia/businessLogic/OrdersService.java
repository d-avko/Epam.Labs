package belavia.businessLogic;

import belavia.dataLayer.repositories.OrdersRepository;
import belavia.dataLayer.comparators.CustomerOrderComparator;
import belavia.dataLayer.comparators.FlightsOrderComparator;
import belavia.dataLayer.entities.Order;

import java.io.InvalidObjectException;
import java.util.List;

public class OrdersService {
    private OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    public List<Order> searchByCustomerName(String customerName){
        return ordersRepository.searchByCustomerName(customerName);
    }

    public boolean removeOrder(int id){
        var order = ordersRepository.getById(id);

        if(order == null){
            return false;
        }

        return ordersRepository.removeOrder(order);
    }

    public void update(Order order) throws InvalidObjectException {
        ordersRepository.update(order);
    }

    public List<Order> getOrders(){
        return ordersRepository.getOrders();
    }

    public List<Order> getSortedByCustomer(){
        return ordersRepository.get(new CustomerOrderComparator());
    }

    public List<Order> getSortedByFlights(){
        return ordersRepository.get(new FlightsOrderComparator());
    }

    public void addOrder(Order order) throws IllegalArgumentException{
        ordersRepository.addOrder(order);
    }
}
