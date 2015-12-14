package com.ambiciousteam.hotelsys.util.shiro;

import javax.servlet.ServletRequest;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * Classe que monitora por tentativas de login sem sucesso, capturando sua
 * exceção e gerenciando-a.
 *
 * @author cassio
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        String message = ae.getMessage();
        request.setAttribute(getFailureKeyAttribute(), message);
    }

}
