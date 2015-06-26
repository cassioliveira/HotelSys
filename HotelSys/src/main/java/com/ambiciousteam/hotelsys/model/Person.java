package com.ambiciousteam.hotelsys.model;

import com.ambiciousteam.hotelsys.enumerations.States;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author cassio
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "client_name", nullable = false, length = 100)
    private String name;

    @Column(name = "client_nick_name", length = 100)
    private String nickName;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Size(min = 0, max = 100)
    @Column(name = "client_email", length = 100)
    private String email;

    @Size(min = 0, max = 150)
    @Column(name = "client_address_street", length = 150)
    private String street;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_address_uf")
    private States uf;

    @Size(min = 0, max = 70)
    @Column(name = "client_address_neighborhood", length = 70)
    private String neighborhood;

    @Size(min = 0, max = 7)
    @Column(name = "client_address_number", length = 7)
    private String number;

    @Size(min = 0, max = 100)
    @Column(name = "client_address_city", length = 100)
    private String city;

    @Size(min = 0, max = 50)
    @Column(name = "client_address_country", length = 50)
    private String country;

    @Size(min = 0, max = 10)
    @Column(name = "client_address_postal_code", length = 10)
    private String postalCode;

    @NotNull
    @Column(name = "client_phone1", nullable = false)
    private String phone1;

    @Column(name = "client_phone2")
    private String phone2;

    @Column(name = "client_nationality")
    private String nationality;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "client_date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public States getUf() {
        return uf;
    }

    public void setUf(States uf) {
        this.uf = uf;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hashPerson = 7;
        hashPerson = 53 * hashPerson + Objects.hashCode(this.id);
        return hashPerson;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return Objects.equals(this.id, other.id);
    }

}
