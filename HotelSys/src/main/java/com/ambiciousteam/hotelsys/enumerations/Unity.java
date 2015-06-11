package com.ambiciousteam.hotelsys.enumerations;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public enum Unity {

    CAIXA("Caixa"),
    PACOTE("Pacote"),
    GRAMA("g"),
    KILOGRAMA("Kg"),
    LITRO("L"),
    MILILITRO("Ml"),
    UNIDADE("Unidade"),
    DUZIA("Duzia");

    private final String description;

    Unity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
