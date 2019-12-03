package belavia.businessLogic;

import belavia.dataLayer.entities.Customer;
import belavia.dataLayer.repositories.CustomersRepository;
import belavia.dataLayer.repositories.OrdersRepository;

public class CustomersService {
    private CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository){
        this.customersRepository = customersRepository;
    }

    public void add(Customer customer) throws IllegalArgumentException {
        customersRepository.add(customer);
    }

    public void remove(Customer customer){
        customersRepository.remove(customer);
    }

    public Customer getById(int id){
        return customersRepository.getById(id);
    }
}
