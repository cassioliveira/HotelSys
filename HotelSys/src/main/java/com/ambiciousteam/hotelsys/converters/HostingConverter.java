package com.ambiciousteam.hotelsys.converters;

import com.ambiciousteam.hotelsys.services.HostingServices;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Hosting;
import com.ambiciousteam.hotelsys.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Hosting.class)
public class HostingConverter implements Converter {

    private final HostingServices hostingServices;

    public HostingConverter() throws HotelSysException {
        this.hostingServices = CDIServiceLocator.getBean(HostingServices.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Hosting objectToReturn = null;

        if (value != null) {
            objectToReturn = this.hostingServices.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Hosting) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
