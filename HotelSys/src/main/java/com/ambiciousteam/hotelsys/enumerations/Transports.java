package com.ambiciousteam.hotelsys.enumerations;

/**
 *
 * @author cassio
 */
public enum Transports {

    CARRO("Carro próprio"),
    MOTO("Moto"),
    VAN("Van");

    private final String description;

    private Transports(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
