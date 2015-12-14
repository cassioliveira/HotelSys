package com.ambiciousteam.hotelsys.converters;

import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Login;
import com.ambiciousteam.hotelsys.services.LoginServices;
import com.ambiciousteam.hotelsys.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Login.class)
public class LoginConverter implements Converter {

    private final LoginServices loginServices;

    public LoginConverter() throws HotelSysException {
        this.loginServices = CDIServiceLocator.getBean(LoginServices.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Login objectToReturn = null;

        if (value != null) {
            objectToReturn = this.loginServices.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Login) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
