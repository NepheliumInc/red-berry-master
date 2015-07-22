package com.redberry.mvc.database;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Amila on 7/12/15.
 */
@Entity
public class Invoice {
    private int id;
    private String filePath;
    private String invoicecol;
    private Integer customerId;
    private Integer packageConfigurationId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "file_path", nullable = false, insertable = true, updatable = true, length = 45)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "invoicecol", nullable = true, insertable = true, updatable = true, length = 45)
    public String getInvoicecol() {
        return invoicecol;
    }

    public void setInvoicecol(String invoicecol) {
        this.invoicecol = invoicecol;
    }

    @Basic
    @Column(name = "customer_id", nullable = true, insertable = true, updatable = true)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "package_configuration_id", nullable = true, insertable = true, updatable = true)
    public Integer getPackageConfigurationId() {
        return packageConfigurationId;
    }

    public void setPackageConfigurationId(Integer packageConfigurationId) {
        this.packageConfigurationId = packageConfigurationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (id != invoice.id) return false;
        if (filePath != null ? !filePath.equals(invoice.filePath) : invoice.filePath != null) return false;
        if (invoicecol != null ? !invoicecol.equals(invoice.invoicecol) : invoice.invoicecol != null) return false;
        if (customerId != null ? !customerId.equals(invoice.customerId) : invoice.customerId != null) return false;
        if (packageConfigurationId != null ? !packageConfigurationId.equals(invoice.packageConfigurationId) : invoice.packageConfigurationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (invoicecol != null ? invoicecol.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (packageConfigurationId != null ? packageConfigurationId.hashCode() : 0);
        return result;
    }
}
