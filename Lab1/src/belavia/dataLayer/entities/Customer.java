package belavia.dataLayer.entities;

import belavia.dataLayer.IPrintable;

import java.io.Serializable;
import java.util.Comparator;

public class Customer implements Comparable<Customer>, IPrintable, Serializable {
    public Customer(){

    }

    public Customer(int id){
            this.id = id;
    }

    public Customer(int id, String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    private int id;
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
        return Comparator.comparing(Customer::getId)
                .thenComparing(Customer::getId)
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

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(!(obj instanceof Customer)){
            return false;
        }

        return ((Customer)obj).id == id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
