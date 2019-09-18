package belavia.DataLayer.Entities;

import belavia.BusinessLogic.IPrintable;

import java.io.Serializable;
import java.util.Comparator;

public class Customer implements Comparable<Customer>, IPrintable, Serializable {
    public Customer(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    private String name;
    private String surname = null;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Customer customer) {
        return Comparator.comparing(Customer::getName)
                .thenComparing(Customer::getSurname)
                .compare(this, customer);
    }

    @Override
    public String getPrintableMetadata() {
        return " Name: " + name + (surname == null ? (" Surname: " + surname) : "") + " Phone number: " + phoneNumber;
    }

    @Override
    public String toString() {
        return getPrintableMetadata();
    }
}
