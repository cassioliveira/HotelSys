package com.ambiciousteam.hotelsys.dao;

import com.ambiciousteam.hotelsys.model.Login;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class LoginDao extends AbstractDao<Login> implements Serializable {

    public LoginDao() {
        super(Login.class);
    }
}
