package com.ambiciousteam.hotelsys.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author cassio
 */
@Entity
public class Corporate extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "client_fantasy_name", length = 150)
    private String fantasyName;

    @Column(name = "client_cnpj", length = 14, unique = true)
    private String cnpj;

    @Column(name = "client_state_register", length = 15)
    private String stateRegister;

    @Column(name = "client_municipal_register", length = 15)
    private String municipalRegister;

//    @ManyToOne
//    @JoinColumn(name = "hosting_fk", referencedColumnName = "id")
//    private Hosting hostingFK;

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStateRegister() {
        return stateRegister;
    }

    public void setStateRegister(String stateRegister) {
        this.stateRegister = stateRegister;
    }

    public String getMunicipalRegister() {
        return municipalRegister;
    }

    public void setMunicipalRegister(String municipalRegister) {
        this.municipalRegister = municipalRegister;
    }

    @Override
    public int hashCode() {
        int hashCorporate = 5;
        hashCorporate = 29 * hashCorporate + Objects.hashCode(this.cnpj);
        return hashCorporate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Corporate other = (Corporate) obj;
        return Objects.equals(this.cnpj, other.cnpj);
    }
    
}
