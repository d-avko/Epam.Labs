package Belavia.BusinessLogic.Comparators;

import Belavia.DataLayer.Entities.Order;

import java.util.Comparator;

public class FlightsOrderComparator implements Comparator<Order> {
    @Override
    public int compare(Order order, Order t1) {
        if(order == null && t1 == null){
            return 0;
        }

        if(order != null && t1 == null){
            return 1;
        }
        if(order == null && t1 != null){
            return -1;
        }

        var first = order.getFlight();
        var second = t1.getFlight();

        if(first == null && second == null){
            return 0;
        }

        if(first == null && second != null){
            return -1;
        }

        if(first != null && second == null){
            return 1;
        }

        if(first != null && second != null){
            return first.compareTo(second);
        }

        return 0;
    }
}
