package com.ambiciousteam.hotelsys.converters;

import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Room;
import com.ambiciousteam.hotelsys.services.RoomServices;
import com.ambiciousteam.hotelsys.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Room.class)
public class RoomConverter implements Converter {

    private final RoomServices roomServices;

    public RoomConverter() throws HotelSysException {
        this.roomServices = CDIServiceLocator.getBean(RoomServices.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Object objectToReturn = null;

        if (value != null) {
            objectToReturn = this.roomServices.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Room) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
}
