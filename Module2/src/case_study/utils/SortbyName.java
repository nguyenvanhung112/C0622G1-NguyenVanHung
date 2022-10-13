package case_study.utils;

import case_study.model.person.Customer;

import java.util.Comparator;

public class SortbyName implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        int comparison;
        comparison = o1.getName().compareTo(o2.getName());
        if (comparison == 0) {
            comparison = o1.getCustomerID().compareTo(o2.getCustomerID());
        }
        return comparison;
    }
}
