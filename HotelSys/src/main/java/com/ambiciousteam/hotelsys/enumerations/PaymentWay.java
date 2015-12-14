package com.ambiciousteam.hotelsys.enumerations;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public enum PaymentWay {

    CARTAOCREDITO("Cartão de crédito"),
    CARTAODEBITO("Cartão de débito"),
    BOLETO("Boleto"),
    CHEQUE("Cheque"),
    AVISTA("À vista");

    private final String description;

    PaymentWay(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
