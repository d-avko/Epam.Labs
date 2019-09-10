package Belavia.DataLayer.Entities;

import java.util.Comparator;

public class Customer implements Comparable<Customer> {
    public Customer(String name, String surname, String phoneNumber){
        this.Name = name;
        this.Surname = surname;
        this.PhoneNumber = phoneNumber;
    }

    private String Name;
    private String Surname;
    private String PhoneNumber;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Customer customer) {
        return Comparator.comparing(Customer::getName)
                .thenComparing(Customer::getSurname)
                .compare(this, customer);
    }
}
