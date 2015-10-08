package com.redberry.mvc.database;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Lakshan Vithana on 9/1/2015.
 */

@XmlRootElement(name="travelAgent")
@Entity
public class TravelAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String address;
    private String phoneNo;
    private String email;
    private String bankName;
    private String accountNo;
    private String accountName;
    private String accountBranch;
    private String imageURL;

    @OneToMany (fetch = FetchType.EAGER)
    private List<Rates> rates;


    public TravelAgent() {
    }

    public TravelAgent(String fullName, String address, String phoneNo, String email, String bankName, String accountNo, String accountName, String accountBranch,String imageURL, List<Rates> rates) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
        this.bankName = bankName;
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.accountBranch = accountBranch;
        this.setImageURL(imageURL);
        this.setRates(rates);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBranch() {
        return accountBranch;
    }

    public void setAccountBranch(String accountBranch) {
        this.accountBranch = accountBranch;
    }


    public List<Rates> getRates() {
        return rates;
    }

    public void setRates(List<Rates> rates) {
        this.rates = rates;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
