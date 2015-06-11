package com.ambiciousteam.hotelsys.enumerations;

/**
 *
 * @author cassio
 */
public enum ReasonTravel {

    FERIAS("Férias"),
    TRABALHO("Trabalho"),
    OUTRO("Outro");

    private final String description;

    ReasonTravel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
