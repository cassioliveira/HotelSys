package com.ambiciousteam.hotelsys.enumerations;

/**
 *
 * @author cassio
 */
public enum RoomStatus {

    LIVRE("Livre"),
    OCUPADO("Ocupado"),
    MANUTENCAO("Manutenção");

    private final String description;

    RoomStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
