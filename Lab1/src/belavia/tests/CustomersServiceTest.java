package belavia.tests;

import belavia.businessLogic.CustomersService;
import belavia.businessLogic.OrdersService;
import belavia.dataLayer.entities.*;
import belavia.dataLayer.repositories.CustomersRepository;
import belavia.dataLayer.repositories.OrdersRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CustomersServiceTest {
    private Order testOrder1;
    private Order testOrder2;
    private CustomersService customersService;

    public CustomersServiceTest(){
        var customer1 = new Customer(1, "Vasily", "Pupkin", "+375291111111");
        var customer2 = new Customer(2, "Kirill", "Andreev", "+375292222222");
        customersService = new CustomersService(new CustomersRepository(true));
    }

    @org.junit.jupiter.api.Test
    void addCustomer() {
        customersService.remove(new Customer(1));
        customersService.remove(new Customer(2));

        var customer1 = new Customer(1, "Vasily", "Pupkin", "+375291111111");
        var customer2 = new Customer(2, "Kirill", "Andreev", "+375292222222");

        customersService.add(customer1);
    }

    @org.junit.jupiter.api.Test
    void removeCustomer() {
        customersService.remove(new Customer(1));
        customersService.remove(new Customer(2));

        var customer1 = new Customer(1, "Vasily", "Pupkin", "+375291111111");
        var customer2 = new Customer(2, "Kirill", "Andreev", "+375292222222");

        customersService.add(customer1);
        customersService.remove(customer1);
    }

}