package com.redberry.mvc.hbnt;

import javax.persistence.*;

/**
 * Created by Amila on 7/12/15.
 */
@Entity
@Table(name = "PACKAGE_MAPPING", schema = "", catalog = "redberry")
public class PackageMapping {
    private int id;
    private Integer packageConfigurationId;
    private Integer travelAgentId;
    private Integer seasonId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "package_configuration_id", nullable = true, insertable = true, updatable = true)
    public Integer getPackageConfigurationId() {
        return packageConfigurationId;
    }

    public void setPackageConfigurationId(Integer packageConfigurationId) {
        this.packageConfigurationId = packageConfigurationId;
    }

    @Basic
    @Column(name = "travel_agent_id", nullable = true, insertable = true, updatable = true)
    public Integer getTravelAgentId() {
        return travelAgentId;
    }

    public void setTravelAgentId(Integer travelAgentId) {
        this.travelAgentId = travelAgentId;
    }

    @Basic
    @Column(name = "season_id", nullable = true, insertable = true, updatable = true)
    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageMapping that = (PackageMapping) o;

        if (id != that.id) return false;
        if (packageConfigurationId != null ? !packageConfigurationId.equals(that.packageConfigurationId) : that.packageConfigurationId != null)
            return false;
        if (travelAgentId != null ? !travelAgentId.equals(that.travelAgentId) : that.travelAgentId != null)
            return false;
        if (seasonId != null ? !seasonId.equals(that.seasonId) : that.seasonId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (packageConfigurationId != null ? packageConfigurationId.hashCode() : 0);
        result = 31 * result + (travelAgentId != null ? travelAgentId.hashCode() : 0);
        result = 31 * result + (seasonId != null ? seasonId.hashCode() : 0);
        return result;
    }
}
