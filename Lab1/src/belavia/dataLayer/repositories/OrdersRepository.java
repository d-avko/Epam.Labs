package belavia.dataLayer.repositories;

import belavia.dataLayer.FileDataStore;
import belavia.dataLayer.entities.Order;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdersRepository {

    public OrdersRepository(boolean autoSaveChanges) {
        loader = new FileDataStore<>();
        this.loadOrders();
        this.autoSaveChanges = autoSaveChanges;
    }

    private List<Order> orders;
    private FileDataStore<List<Order>> loader;
    private boolean autoSaveChanges;

    public List<Order> getOrders() {
        return orders;
    }

    /**
     * @param id Id of an order
     * @return Found order or null
     */
    public Order getById(int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findAny()
                .orElse(null);
    }

    /**
     * Method used to get sorted orders.
     *
     * @param comparator comparator to use
     * @return Sorted orders.
     */
    public List<Order> get(Comparator<Order> comparator) {
        return orders.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    /**
     * Method used to add an order.
     *
     * @param order order to add.
     */
    public void addOrder(Order order) throws IllegalArgumentException {
        if (order == null) {
            throw new IllegalArgumentException();
        }

        if (this.orders.indexOf(order) != -1) {
            throw new IllegalArgumentException();
        }

        this.orders.add(order);

        if (this.autoSaveChanges) {
            this.saveChanges();
        }
    }

    /**
     * Method used to remove an order.
     *
     * @param order order to remove.
     */
    public boolean removeOrder(Order order) {
        var successful = this.orders.remove(order);
        if (this.autoSaveChanges) {
            this.saveChanges();
        }
        return successful;
    }

    /**
     * Method used to update an existing order.
     *
     * @param order order to update.
     */
    public void update(Order order) throws InvalidObjectException {
        var index = this.orders.indexOf(order);

        if (index == -1) {
            throw new InvalidObjectException("Entity was not present in data set.");
        }

        this.orders.set(index, order);

        if (this.autoSaveChanges) {
            this.saveChanges();
        }
    }

    /**
     * Searches for orders with specified customer.
     *
     * @param customerName First name of a customer
     * @return found orders
     */
    public List<Order> searchByCustomerName(String customerName) {
        return orders.stream()
                .filter(order -> order.getCustomer() != null && order.getCustomer().getName().contains(customerName))
                .collect(Collectors.toList());
    }

    private void loadOrders() {
        try{
            orders = loader.loadData(null);
        }
        catch (IOException ex){
            System.out.println("Catched IO exception while loading data. Exception class name: "
                    + ex.getClass().getName());
            orders = new ArrayList<>();
        }
        catch (ClassNotFoundException ex){
            System.out.println("Catched ClassNotFoundException while loading data. Exception class name: "
                    + ex.getClass().getName());
            orders = new ArrayList<>();
        }
    }

    /**
     * Updates internal data store.
     */
    public void saveChanges() {
        try {
            loader.updateData(orders,null);
        } catch (IOException e) {
            System.out.println("Failed to save data.");
            e.printStackTrace();
        }
    }
}
