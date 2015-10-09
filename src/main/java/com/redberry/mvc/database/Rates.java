package com.redberry.mvc.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Lakshan Vithana on 9/10/2015.
 */

@XmlRootElement(name="rates")
@Entity
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double rate;
    private Date startDate;
    private Date endDate;

    public Rates() {
    }

    public Rates(double rate, Date startDate, Date endDate) {
        this.setRate(rate);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }


    public int getId() {
        return id;
    }



    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
