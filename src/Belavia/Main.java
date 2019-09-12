package Belavia;

import Belavia.DataLayer.Entities.*;
import Belavia.DataLayer.OrdersRepository;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        var repo = new OrdersRepository();
        var customer1 = new Customer("Vasily", "Pupkin", "+375291111111");
        var customer2 = new Customer("Kirill", "Andreev", "+375292222222");
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

        var testOrder1 = new Order(1, customer1, flight1, price1, baggage);
        var testOrder2 = new Order(2, customer2, flight2, price2, baggage);

        try{
            repo.AddOrder(testOrder1);
            repo.AddOrder(testOrder2);
        }
        catch (IllegalArgumentException e){
            System.out.println("Failed to add order, since it exists already.");
        }

        var orders = repo.getOrders();

        for(var order: orders){
            System.out.println(order.GetPrintableMetadata());
        }

        System.out.println("Changing customer of order1 to customer2");
        orders.get(0).setCustomer(customer2);

        try {
            repo.Update(orders.get(0));
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }

        System.out.println("Searching orders with customers containing 'Kir' in name: ");

        var foundOrders = repo.SearchByCustomerName("Kir");

        for(var order: foundOrders){
            System.out.println(order.GetPrintableMetadata());
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
