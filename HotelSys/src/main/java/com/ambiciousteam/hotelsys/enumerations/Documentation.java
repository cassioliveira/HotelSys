package com.ambiciousteam.hotelsys.enumerations;

/**
 *
 * @author cassio
 */
public enum Documentation {

    RG("Carteira de Identidade"),
    CTPS("Carteira de Trabalho"),
    PASSAPORTE("Passaporte"),
    HABILITACAO("Carteira de motorista"),
    RESERVISTA("Reservista"),
    TITULO("Titulo eleitoral"),
    OUTRO("Outro");

    private final String description;

    Documentation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
