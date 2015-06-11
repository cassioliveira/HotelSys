package com.ambiciousteam.hotelsys.model;

import com.ambiciousteam.hotelsys.controller.DateTimeUtilBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class to modelling the Room entity.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@Entity
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_status", length = 20)
    private String status;

    @Column(name = "room_category", length = 50, nullable = false)
    private String category;

    @Column(name = "room_number", length = 7, unique = true, nullable = false)
    private String number;

    @Column(name = "card_key", length = 50, unique = true)
    private String cardKey;

    @Lob
    @Column(name = "room_description")
    private String description;

    @Column(name = "room_extension_number", length = 6, unique = true)
    private Long extensionNumber;

    @Column(name = "room_tv")
    private boolean tv;

    @Column(name = "room_cable_tv")
    private boolean cableTv;

    @Column(name = "room_fridge")
    private boolean fridge;

    @Column(name = "room_bunk")
    private boolean bunk;

    @Column(name = "room_double_bed")
    private boolean doubleBed;

    @Column(name = "room_single_bed")
    private boolean singleBed;

    @Column(name = "room_dvd")
    private boolean dvd;

    @Column(name = "room_air_conditioning")
    private boolean airConditioning;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "room_date_time")
    private Date dateTime;

    /* Attibutes to relationship of Entities */
    @ManyToOne
    @JoinColumn(name = "employee_fk", referencedColumnName = "id")
    private Employee employeeFK;

    @OneToMany(mappedBy = "roomFK", cascade = CascadeType.ALL)
    private List<Hosting> hostings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCardKey() {
        return cardKey;
    }

    public void setCardKey(String cardKey) {
        this.cardKey = cardKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(Long extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isCableTv() {
        return cableTv;
    }

    public void setCableTv(boolean cableTv) {
        this.cableTv = cableTv;
    }

    public boolean isFridge() {
        return fridge;
    }

    public void setFridge(boolean fridge) {
        this.fridge = fridge;
    }

    public boolean isBunk() {
        return bunk;
    }

    public void setBunk(boolean bunk) {
        this.bunk = bunk;
    }

    public boolean isDoubleBed() {
        return doubleBed;
    }

    public void setDoubleBed(boolean doubleBed) {
        this.doubleBed = doubleBed;
    }

    public boolean isSingleBed() {
        return singleBed;
    }

    public void setSingleBed(boolean singleBed) {
        this.singleBed = singleBed;
    }

    public boolean isDvd() {
        return dvd;
    }

    public void setDvd(boolean dvd) {
        this.dvd = dvd;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = new DateTimeUtilBean().dateHour();
    }

    public Employee getEmployeeFK() {
        return employeeFK;
    }

    public void setEmployeeFK(Employee employeeFK) {
        this.employeeFK = employeeFK;
    }

    public List<Hosting> getHostings() {
        return hostings;
    }

    public void setHostings(List<Hosting> hostings) {
        this.hostings = hostings;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.number);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return true;
    }

}
