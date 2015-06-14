package com.ambiciousteam.hotelsys.exceptions;

import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class BusinessException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

}
