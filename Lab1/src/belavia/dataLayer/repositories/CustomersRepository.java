package belavia.dataLayer.repositories;

import belavia.dataLayer.FileDataStore;
import belavia.dataLayer.entities.Customer;
import belavia.dataLayer.entities.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomersRepository {
    public CustomersRepository(boolean autoSaveChanges){
        loader = new FileDataStore<>();
        this.loadCustomers();
        this.autoSaveChanges = autoSaveChanges;
    }

    private List<Customer> customers;
    private FileDataStore<List<Customer>> loader;
    private boolean autoSaveChanges;


    /**
     * @param id Id of an order
     * @return Found customer or null
     */
    public Customer getById(int id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findAny()
                .orElse(null);
    }

    /**
     * Method used to add a customer.
     *
     * @param customer order to add.
     */
    public void add(Customer customer) throws IllegalArgumentException {
        if (customer == null) {
            throw new IllegalArgumentException();
        }

        if (this.customers.indexOf(customer) != -1) {
            throw new IllegalArgumentException();
        }

        this.customers.add(customer);

        if (this.autoSaveChanges) {
            this.saveChanges();
        }
    }

    /**
     * Method used to remove a customer.
     *
     * @param customer customer to remove.
     */
    public boolean remove(Customer customer) {
        var successful = this.customers.remove(customer);
        if (this.autoSaveChanges) {
            this.saveChanges();
        }
        return successful;
    }

    /**
     * Updates internal data store.
     */
    public void saveChanges() {
        try {
            loader.updateData(customers, "Customers.txt");
        } catch (IOException e) {
            System.out.println("Failed to save data.");
            e.printStackTrace();
        }
    }

    private void loadCustomers() {
        try{
            customers = loader.loadData("Customers.txt");
        }
        catch (IOException ex){
            System.out.println("Caught IO exception while loading data. Exception class name: "
                    + ex.getClass().getName());
            customers = new ArrayList<>();
        }
        catch (ClassNotFoundException ex){
            System.out.println("Caught ClassNotFoundException while loading data. Exception class name: "
                    + ex.getClass().getName());
            customers = new ArrayList<>();
        }
    }
}
