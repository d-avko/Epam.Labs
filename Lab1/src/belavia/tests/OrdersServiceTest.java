package belavia.tests;

import belavia.businessLogic.OrdersService;
import belavia.dataLayer.repositories.OrdersRepository;
import belavia.dataLayer.entities.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrdersServiceTest {
    private Order testOrder1;
    private Order testOrder2;
    private OrdersService ordersService;

    public OrdersServiceTest(){
        var customer1 = new Customer(1, "Vasily", "Pupkin", "+375291111111");
        var customer2 = new Customer(2, "Kirill", "Andreev", "+375292222222");
        var minsk = new AirPort("MSQ", "National Airport Minsk");
        var moscow1 = new AirPort("VNK", "Moscow airport Vnukovo");
        var barcelona = new AirPort("BCN", "Barcelona el-prat airport");

        var flight1 = new Flight(minsk, moscow1,
                Date.from(Instant.parse("2019-09-06T18:00:00.00Z")),
                Date.from(Instant.parse("2019-09-06T20:35:00.00Z")));

        var flight2 = new Flight(minsk, barcelona,
                Date.from(Instant.parse("2019-09-08T22:00:00.00Z")),
                Date.from(Instant.parse("2019-09-09T01:35:00.00Z")));

        var price1 = new FlightPrice(120, 250, 105);

        var price2 = new FlightPrice(500, 1050, 430);

        var baggage = new ArrayList<Cargo>();
        baggage.add(new Cargo(8, "Small brown bag"));
        baggage.add(new Cargo(54, "Big black suitcase"));

        testOrder1 = new Order(1, customer1, flight1, price1, baggage);
        testOrder2 = new Order(2, customer2, flight2, price2, baggage);
        ordersService = new OrdersService(new OrdersRepository(true));
    }

    @org.junit.jupiter.api.Test
    void addOrders() {
        ordersService.removeOrder(1);
        ordersService.removeOrder(2);
        assertDoesNotThrow(() -> ordersService.addOrder(testOrder1), "Failed to add first order.");
        assertDoesNotThrow(() -> ordersService.addOrder(testOrder2), "Failed to add second order.");
    }

    @org.junit.jupiter.api.Test
    void searchByCustomerName() {
        ordersService.removeOrder(1);
        ordersService.removeOrder(2);
        ordersService.addOrder(testOrder1);
        ordersService.addOrder(testOrder2);
        assertNotEquals(ordersService.searchByCustomerName("Kir").size(),  0, "No customers were found");
    }

    @org.junit.jupiter.api.Test
    void removeOrder() {
        assertNotEquals(ordersService.removeOrder(1), false, "Failed to remove the order.");
    }

    @org.junit.jupiter.api.Test
    void updateOrder(){
        ordersService.removeOrder(1);
        ordersService.addOrder(testOrder1);
        testOrder1.setPrice(new FlightPrice(12, 23, 20));

        assertDoesNotThrow(() -> ordersService.update(testOrder1), "Failed to update first order.");
    }

    @org.junit.jupiter.api.Test
    void sortByCustomer(){
        ordersService.removeOrder(1);
        ordersService.removeOrder(2);
        ordersService.addOrder(testOrder1);
        ordersService.addOrder(testOrder2);
        var orders = ordersService.getSortedByCustomer();
        assertTrue(orders.get(0).getId() < orders.get(1).getId());
    }

}