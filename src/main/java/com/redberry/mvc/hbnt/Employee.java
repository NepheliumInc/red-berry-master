package com.redberry.mvc.hbnt;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

/**
 * Created by Amila on 7/12/15.
 */
@XmlRootElement(name="employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column()
    private Date joiningDate;
    private double salary;
    private String ssn;

    public Employee() {
    }

    public Employee(String name, Date joiningDate, double salary, String ssn) {
        this.name = name;
        this.joiningDate = joiningDate;
        this.salary = salary;
        this.ssn = ssn;
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
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "joining_date", nullable = false, insertable = true, updatable = true)
    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Basic
    @Column(name = "salary", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "ssn", nullable = false, insertable = true, updatable = true, length = 30)
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (Double.compare(employee.salary, salary) != 0) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (joiningDate != null ? !joiningDate.equals(employee.joiningDate) : employee.joiningDate != null)
            return false;
        if (ssn != null ? !ssn.equals(employee.ssn) : employee.ssn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (joiningDate != null ? joiningDate.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        return result;
    }
}
