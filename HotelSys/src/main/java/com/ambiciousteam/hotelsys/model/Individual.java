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
import javax.validation.constraints.Pattern;

/**
 *
 * @author cassio
 */
@Entity
public class Individual extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "client_cpf_client", length = 11, unique = true)
    private String cpfIndividual;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_gender")
    private Gender gender;

    @Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
            message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
    @Column(name = "client_doc_travel_number", length = 15)
    private String docTravelNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_travel_doc_type", length = 50)
    private Documentation travelDocType;

    @Column(name = "client_issuing_body", length = 15)
    private String issuingBody;

    @Column(name = "client_profession", length = 100)
    private String profession;

    @Temporal(TemporalType.DATE)
    @Column(name = "client_birthdate")
    private Date birthDate;

//    @ManyToOne
//    @JoinColumn(name = "hosting_fk", referencedColumnName = "id")
//    private Hosting hostingFK;

    public String getCpfIndividual() {
        return cpfIndividual;
    }

    public void setCpfIndividual(String cpfIndividual) {
        this.cpfIndividual = cpfIndividual;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDocTravelNumber() {
        return docTravelNumber;
    }

    public void setDocTravelNumber(String docTravelNumber) {
        this.docTravelNumber = docTravelNumber;
    }

    public Documentation getTravelDocType() {
        return travelDocType;
    }

    public void setTravelDocType(Documentation travelDocType) {
        this.travelDocType = travelDocType;
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
        int hashIndividual = 7;
        hashIndividual = 23 * hashIndividual + Objects.hashCode(this.cpfIndividual);
        return hashIndividual;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Individual other = (Individual) obj;
        return Objects.equals(this.cpfIndividual, other.cpfIndividual);
    }
}
