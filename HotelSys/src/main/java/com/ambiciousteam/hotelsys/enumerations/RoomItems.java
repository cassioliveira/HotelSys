package com.ambiciousteam.hotelsys.enumerations;

/**
 *
 * @author cassio
 */
public enum RoomItems {

    TV("TV"),
    TVCABO("Sinal a cabo"),
    FRIGOBAR("Manutenção"),
    BELICHE("Beliche"),
    CAMACASAL("Cama de casal"),
    CAMASOLTEIRO("Cama de solteiro"),
    DVD("DVD"),
    ARCONDICIONADO("Ar-condicionado");

    private final String description;

    RoomItems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
