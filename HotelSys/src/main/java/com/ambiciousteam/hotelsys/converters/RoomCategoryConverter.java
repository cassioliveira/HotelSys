package com.ambiciousteam.hotelsys.converters;

import com.ambiciousteam.hotelsys.services.RoomCategoryServices;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.RoomCategory;
import com.ambiciousteam.hotelsys.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = RoomCategory.class)
public class RoomCategoryConverter implements Converter {

    private final RoomCategoryServices roomCategoryServices;

    public RoomCategoryConverter() throws HotelSysException {
        this.roomCategoryServices = CDIServiceLocator.getBean(RoomCategoryServices.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        RoomCategory objectToReturn = null;

        if (value != null) {
            objectToReturn = this.roomCategoryServices.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((RoomCategory) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
