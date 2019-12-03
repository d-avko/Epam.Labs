package belavia.view;

import belavia.businessLogic.OrdersService;

import java.io.OutputStream;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    private OrdersService ordersService;

    public ConsoleView(OrdersService ordersService){
        this.ordersService = ordersService;
        scanner = new Scanner(System.in);
    }

    public void printOrdersData(){
        for(var order: this.ordersService.getOrders()){
            System.out.println(order.getPrintableMetadata());
        }
    }


    public String inputString(){
        return scanner.next();
    }

    public int inputInt(){
        return scanner.nextInt();
    }
}
