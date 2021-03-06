package com.ambiciousteam.hotelsys.converters;

import com.ambiciousteam.hotelsys.services.HostingCategoryServices;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.HostingCategory;
import com.ambiciousteam.hotelsys.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = HostingCategory.class)
public class HostingCategoryConverter implements Converter {

    private final HostingCategoryServices hostingCategoryServices;

    public HostingCategoryConverter() throws HotelSysException {
        this.hostingCategoryServices = CDIServiceLocator.getBean(HostingCategoryServices.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        HostingCategory objectToReturn = null;

        if (value != null) {
            objectToReturn = this.hostingCategoryServices.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((HostingCategory) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
