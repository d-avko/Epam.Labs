package belavia.BusinessLogic.Comparators;

import belavia.DataLayer.Entities.Order;

import java.util.Comparator;

public class CustomerOrderComparator implements Comparator<Order> {
    @Override
    public int compare(Order order, Order t1) {
        var customerFirst = order.getCustomer();
        var customerOther = t1.getCustomer();

        if (customerFirst == null && customerOther == null) {
            return 0;
        }

        if (customerFirst == null && customerOther != null) {
            return -1;
        }

        if (customerFirst != null && customerOther == null) {
            return 1;
        }

        if (customerFirst != null && customerOther != null) {
            return customerFirst.compareTo(customerOther);
        }

        return 0;
    }
}
