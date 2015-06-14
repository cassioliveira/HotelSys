package com.ambiciousteam.hotelsys.converters;

import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Client;
import com.ambiciousteam.hotelsys.services.ClientServices;
import com.ambiciousteam.hotelsys.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Client.class)
public class ClientConverter implements Converter {

    private final ClientServices clientServices;

    public ClientConverter() throws HotelSysException {
        this.clientServices = CDIServiceLocator.getBean(ClientServices.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Client objectToReturn = null;

        if (value != null) {
            objectToReturn = this.clientServices.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Client) value).getId();
            String objectToReturn = (code == null ? null : code.toString());
            return objectToReturn;
        }
        return "";
    }
}
