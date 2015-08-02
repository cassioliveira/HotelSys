package com.ambiciousteam.hotelsys.controller;

import com.ambiciousteam.hotelsys.enumerations.UserLevel;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Login;
import com.ambiciousteam.hotelsys.services.LoginServices;
import com.ambiciousteam.hotelsys.services.PersonServices;
import com.ambiciousteam.hotelsys.util.jsf.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.omnifaces.util.Faces;

/**
 *
 * @author cassio
 */
@Model
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private LoginServices loginServices;

    @Inject
    @Getter
    @Setter
    private Login login;

    @Inject
    @Getter
    @Setter
    private Login selectedLogin;

    private List<Login> logins;

    @Getter
    private final List<UserLevel> userLevels;

    public LoginBean() {
        this.userLevels = Arrays.asList(UserLevel.values());
    }

    public void save() throws HotelSysException {
        this.loginServices.save(login);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro de '" + login.getUserName() + "' atualizado com sucesso!");
            FacesUtil.redirectTo("SearchLogin.xhtml");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
            FacesUtil.redirectTo("CadastreLogin.xhtml");
        }
        login = new Login();
    }

    public void remove() throws HotelSysException {
        this.loginServices.delete(selectedLogin);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.login.getId() != null;
    }

    /**
     * @return the logins
     */
    public List<Login> getLogins() {
        this.logins = loginServices.findAll();
        return logins;
    }

    public void submit() throws IOException {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(login.getUserName(), login.getPassword(), null));
            SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
            Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : "/HotelSys/Home.xhtml");
        } catch (UnknownAccountException uae) {
             FacesUtil.errorMessage("Usuário desconhecido, por favor tente novamente.");
        } catch (IncorrectCredentialsException ice) {
             FacesUtil.errorMessage("Dados incorretos, por favor tente novamente.");
        } catch (LockedAccountException lae) {
             FacesUtil.errorMessage("Conta bloqueada. Entre em contato com o administrador do sistema.");
        } catch (ExcessiveAttemptsException eae) {
             FacesUtil.errorMessage("Muitas tentativas de login foram efetuadas e sua conta foi bloqueada.");
        } catch (AuthenticationException e) {
            FacesUtil.errorMessage("Erro desconhecido, entre em contato com o administrador do sistema.");
            e.printStackTrace(); // TODO: logger.
        }
    }
}
