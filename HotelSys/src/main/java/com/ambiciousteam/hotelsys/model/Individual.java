package com.ambiciousteam.hotelsys.model;

import com.ambiciousteam.hotelsys.enumerations.Documentation;
import com.ambiciousteam.hotelsys.enumerations.Gender;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author cassio
 */
@Entity
public class Individual extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Column(name = "client_cpf_client", length = 11, unique = true)
    private String cpfIndividual;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "client_gender")
    private Gender gender;

    @Getter
    @Setter
    @Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
            message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
    @Column(name = "client_doc_travel_number", length = 15)
    private String docTravelNumber;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "client_travel_doc_type", length = 50)
    private Documentation travelDocType;

    @Getter
    @Setter
    @Column(name = "client_issuing_body", length = 15)
    private String issuingBody;

    @Getter
    @Setter
    @Column(name = "client_profession", length = 100)
    private String profession;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "client_birthdate")
    private Date birthDate;

//    @ManyToOne
//    @JoinColumn(name = "hosting_fk", referencedColumnName = "id")
//    private Hosting hostingFK;
    /**
     * Este método anotado com @PostConstruct é executado na inicialização da
     * entidade e seta um valor padrão para o(s) atributo(s).
     */
    @PostConstruct
    public void init() {
        setCountry("Brasil");
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
