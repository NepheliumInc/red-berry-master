package com.redberry.mvc.hbnt;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


/**
 * Created by Amila on 7/12/15.
 */
@XmlRootElement(name="employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String residentialAddress;
    private String permanentAddress;
    private String residentialPhone;
    private String permanentPhone;
    private String NIC;
    private String email;
    private Date dob;
    private Date joinedDate;
    private String prevExperience;
    private String commentsFromPrevWorkPlace;
    private Double startingSalary;
    private String emergencyContact;
    private String imageURL;


    public Employee() {
    }

    public Employee(String fullName, String residentialAddress, String permanentAddress, String residentialPhone, String permanentPhone, String NIC, String email, Date dob, Date joinedDate, String prevExperience, String commentsFromPrevWorkPlace, Double startingSalary, String emergencyContact, String imageURL) {
        this.fullName = fullName;
        this.residentialAddress = residentialAddress;
        this.permanentAddress = permanentAddress;
        this.residentialPhone = residentialPhone;
        this.permanentPhone = permanentPhone;
        this.NIC = NIC;
        this.email = email;
        this.dob = dob;
        this.joinedDate = joinedDate;
        this.prevExperience = prevExperience;
        this.commentsFromPrevWorkPlace = commentsFromPrevWorkPlace;
        this.startingSalary = startingSalary;
        this.emergencyContact = emergencyContact;
        this.imageURL = imageURL;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getResidentialPhone() {
        return residentialPhone;
    }

    public void setResidentialPhone(String residentialPhone) {
        this.residentialPhone = residentialPhone;
    }

    public String getPermanentPhone() {
        return permanentPhone;
    }

    public void setPermanentPhone(String permanentPhone) {
        this.permanentPhone = permanentPhone;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getPrevExperience() {
        return prevExperience;
    }

    public void setPrevExperience(String prevExperience) {
        this.prevExperience = prevExperience;
    }

    public String getCommentsFromPrevWorkPlace() {
        return commentsFromPrevWorkPlace;
    }

    public void setCommentsFromPrevWorkPlace(String commentsFromPrevWorkPlace) {
        this.commentsFromPrevWorkPlace = commentsFromPrevWorkPlace;
    }

    public Double getStartingSalary() {
        return startingSalary;
    }

    public void setStartingSalary(Double startingSalary) {
        this.startingSalary = startingSalary;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
