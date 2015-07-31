package com.redberry.mvc.database;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Amila on 7/12/15.
 */
@XmlRootElement(name="customer")
@Entity
public class Customer {
    private int id;
    private String name;
    private String email;
    private String telephoneNumber;
    private String address;
    private String country;

    public Customer() {

    }

    public Customer(int id, String name, String email, String telephoneNumber, String address, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.country = country;
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telephone_number", nullable = true, insertable = true, updatable = true, length = 45)
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Basic
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "country", nullable = true, insertable = true, updatable = true, length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (telephoneNumber != null ? !telephoneNumber.equals(customer.telephoneNumber) : customer.telephoneNumber != null)
            return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (country != null ? !country.equals(customer.country) : customer.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telephoneNumber != null ? telephoneNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
