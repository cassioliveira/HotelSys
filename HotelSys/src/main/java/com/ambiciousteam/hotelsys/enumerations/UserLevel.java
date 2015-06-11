package com.ambiciousteam.hotelsys.enumerations;

/**
 * Contains a list with Gender, represented by a letter.
 *
 * @author cassio
 */
public enum UserLevel {

    ADMINISTRADOR("Administrador"),
    CAMAREIRA("Camareira"),
    GERENTE("Gerente"),
    RECEPCIONISTA("Recepcionista");

    private final String description;

    UserLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
