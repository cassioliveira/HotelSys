package com.ambiciousteam.hotelsys.model;

import com.ambiciousteam.hotelsys.enumerations.Documentation;
import com.ambiciousteam.hotelsys.enumerations.Gender;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cassio
 */
@Entity
public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "client_cpf_client", length = 11, unique = true)
    private String cpfEmployee;

    @NotNull
    @Size(min = 0, max = 20, message = "O codigo deve ter no maximo 20 caracteres")
    @Column(name = "emp_code", nullable = false, length = 20)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_gender")
    private Gender gender;

    @Column(name = "client_doc_number", length = 15)
    private String docNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_doc_type", length = 50)
    private Documentation docType;

    @Column(name = "client_issuing_body", length = 15)
    private String issuingBody;

    @Column(name = "client_profession", length = 100)
    private String profession;

    @Temporal(TemporalType.DATE)
    @Column(name = "client_birthdate")
    private Date birthDate;

    /* Attibutes to relationship of Entities */
//    @ManyToOne
//    @JoinColumn(name = "hosting_fk", referencedColumnName = "id")
//    private Hosting hostingFK;
//    @OneToMany(mappedBy = "employeeFK", targetEntity = Room.class)
//    private List<Room> rooms;
//    @OneToMany(mappedBy = "employeeFK", targetEntity = Hosting.class)
//    private List<Hosting> hostings;
//    @OneToMany(mappedBy = "employeeFK", targetEntity = Reservation.class)
//    private List<Reservation> reservations;
//    @OneToMany(mappedBy = "employeeFK", targetEntity = Service.class)
//    private List<Service> services;
//    @OneToMany(mappedBy = "employeeFK", targetEntity = Person.class)
//    private List<Person> clients;
//    @OneToMany(mappedBy = "employeeFK", targetEntity = SystemUser.class)
//    private List<SystemUser> users;
    public String getCpfEmployee() {
        return cpfEmployee;
    }

    public void setCpfEmployee(String cpfEmployee) {
        this.cpfEmployee = cpfEmployee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public String getIssuingBody() {
        return issuingBody;
    }

    public void setIssuingBody(String issuingBody) {
        this.issuingBody = issuingBody;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        int hashEmployee = 3;
        hashEmployee = 59 * hashEmployee + Objects.hashCode(this.cpfEmployee);
        return hashEmployee;
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
        return Objects.equals(this.cpfEmployee, other.cpfEmployee);
    }

}
