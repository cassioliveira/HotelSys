package com.ambiciousteam.hotelsys.model;

import com.ambiciousteam.hotelsys.enumerations.Documentation;
import com.ambiciousteam.hotelsys.enumerations.Gender;
import com.ambiciousteam.hotelsys.enumerations.States;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class to modelling the Employee entity.
 *
 * @author Cássio Oliveira
 * @author Wilde Arruda
 */
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "person_name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "person_email", nullable = false, length = 100)
    private String email;

    @Size(min = 0, max = 100)
    @Column(name = "address_street", length = 100)
    private String street;

    @Enumerated(EnumType.STRING)
    @Size(min = 0, max = 100)
    @Column(name = "address_uf", length = 100)
    private States uf;

    @Size(min = 0, max = 50)
    @Column(name = "address_neighborhood", length = 50)
    private String neighborhood;

    @Max(99999)
    @Size(min = 0, max = 7)
    @Column(name = "address_number", length = 7)
    private String number;

    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "address_city", length = 100, nullable = false)
    private String city;

    @Size(min = 0, max = 50)
    @Column(name = "address_country", length = 50)
    private String country;

    @Size(min = 0, max = 10)
    @Column(name = "address_postal_code", length = 10)
    private String postalCode;

    @NotNull
    @Column(name = "person_phone1", nullable = false)
    private String phone1;

    @Column(name = "person_phone2")
    private String phone2;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "employee_date_time")
    private Date dateTime;

    @NotNull
    @Size(min = 0, max = 20, message = "O codigo deve ter no maximo 20 caracteres")
    @Column(name = "emp_code", nullable = false, length = 20)
    private String code;

    @Enumerated(EnumType.STRING)
    @Size(min = 0, max = 20, message = "O sexo deve ter no maximo 20 caracteres")
    @Column(name = "emp_gender", length = 20)
    private Gender gender;

    @NotNull
    @Size(min = 0, max = 14, message = "O CPF deve ter no maximo 14 caracteres, incluindo pontos e traços")
    @Column(name = "emp_cpf", nullable = false, length = 14, unique = true)
    private String cpf;

    @NotNull
    @Size(min = 0, max = 15, message = "O documento deve ter no maximo 15 dígitos")
    @Column(name = "emp_doc_number", nullable = false, length = 15)
    private String docNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Size(min = 0, max = 20, message = "O tipo de documento deve ter no maximo 20 caracteres")
    @Column(name = "emp_doc_type", nullable = false, length = 20)
    private Documentation docType;

    @Size(min = 0, max = 15, message = "O órgão expedidor deve ter no maximo 15 caracteres")
    @Column(name = "emp_issuing_body", length = 15)
    private String issuingBoddy;

    @Temporal(TemporalType.DATE)
    @Column(name = "emp_birthdate")
    private Date birthDate;

    /* Attibutes to relationship of Entities */
    @OneToMany(mappedBy = "employeeFK", targetEntity = Room.class)
    private List<Room> rooms;

//    @OneToMany(mappedBy = "employeeFK", targetEntity = Hosting.class)
//    private List<Hosting> hostings;
//    @OneToMany(mappedBy = "employeeFK", targetEntity = Reservation.class)
//    private List<Reservation> reservations;
//
//    @OneToMany(mappedBy = "employeeFK", targetEntity = Service.class)
//    private List<Service> services;
//
//    @OneToMany(mappedBy = "employeeFK", targetEntity = Person.class)
//    private List<Person> clients;
//
//    @OneToMany(mappedBy = "employeeFK", targetEntity = SystemUser.class)
//    private List<SystemUser> users;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Documentation getDocType() {
        return docType;
    }

    public void setDocType(Documentation docType) {
        this.docType = docType;
    }

    public String getIssuingBoddy() {
        return issuingBoddy;
    }

    public void setIssuingBoddy(String issuingBoddy) {
        this.issuingBoddy = issuingBoddy;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
