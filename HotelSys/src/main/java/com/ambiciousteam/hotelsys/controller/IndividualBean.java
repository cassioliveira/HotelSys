package com.ambiciousteam.hotelsys.controller;

import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.Individual;
import com.ambiciousteam.hotelsys.services.IndividualServices;
import com.ambiciousteam.hotelsys.services.PersonServices;
import com.ambiciousteam.hotelsys.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author cassio
 */
@Model
public class IndividualBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private IndividualServices individualServices;

    @Inject
    private PersonServices personServices;

    @Inject
    @Getter
    @Setter
    private Individual individual;

    @Inject
    @Getter
    @Setter
    private Individual selectedIndividual;

    private List<Individual> individuals;

    public void save() throws HotelSysException {
        this.individualServices.save(individual);
        if (getEditing()) {
            FacesUtil.sucessMessage("Cadastro de '" + individual.getName() + "' atualizado com sucesso!");
            FacesUtil.redirectTo("SearchIndividual.xhtml");
        } else {
            FacesUtil.sucessMessage("Cadastro efetuado com sucesso!");
            FacesUtil.redirectTo("CadastreIndividual.xhtml");
        }
        individual = new Individual();
    }

    public void remove() throws HotelSysException {
        this.individualServices.delete(selectedIndividual);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
    }

    public void loadCities() {
        PersonBean.cities.clear();
        if (individual.getUf() != null) {
            for (String filteredCities : personServices.returnCities(individual.getUf().getCode())) {
                PersonBean.cities.add(filteredCities);
            }
        }
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditing() {
        return this.individual.getId() != null;
    }

    /**
     * @return the individuals
     */
    public List<Individual> getIndividuals() {
        this.individuals = individualServices.findAll();
        return individuals;
    }
}
