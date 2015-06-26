package com.ambiciousteam.hotelsys.converters;

import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Individual;
import com.ambiciousteam.hotelsys.services.IndividualServices;
import com.ambiciousteam.hotelsys.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cassio
 */
@FacesConverter(forClass = Individual.class)
public class IndividualConverter implements Converter {

    private final IndividualServices clientServices;

    public IndividualConverter() throws HotelSysException {
        this.clientServices = CDIServiceLocator.getBean(IndividualServices.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Individual objectToReturn = null;

        if (value != null) {
            objectToReturn = this.clientServices.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Long code = ((Individual) value).getId();
            String objectToReturn = (code == null ? null : code.toString());
            return objectToReturn;
        }
        return "";
    }
}
