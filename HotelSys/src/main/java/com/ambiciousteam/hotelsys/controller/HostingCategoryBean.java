package com.ambiciousteam.hotelsys.controller;

import com.ambiciousteam.hotelsys.services.HostingCategoryServices;
import com.ambiciousteam.hotelsys.exceptions.HotelSysException;
import com.ambiciousteam.hotelsys.model.HostingCategory;
import com.ambiciousteam.hotelsys.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author cassio
 */
@Model
public class HostingCategoryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @Getter
    @Setter
    private HostingCategoryServices hostingCategoryServices;

    @Inject
    @Getter
    @Setter
    private HostingCategory hostingCategory;

    @Inject
    @Getter
    @Setter
    private HostingCategory selectedHostingCategory;

    @Getter
    private List<HostingCategory> hostingCategories;

    public HostingCategoryBean() {
    }

    @PostConstruct
    public void init() {
        this.hostingCategories = hostingCategoryServices.findAll();
    }

    public void save() throws HotelSysException {
        if (getEditing()) {
            this.hostingCategoryServices.save(hostingCategory);
            FacesUtil.sucessMessage("Cadastro da categoria'" + hostingCategory.getName() + "' atualizado com sucesso!");
        } else {
            this.hostingCategoryServices.save(hostingCategory);
            FacesUtil.sucessMessage("Categoria " + hostingCategory.getName() + " cadastrada com sucesso!");
        }
        FacesUtil.redirectTo("SearchHostingCategory.xhtml");
        hostingCategory = new HostingCategory();
    }

    public void remove() throws HotelSysException {
        this.hostingCategoryServices.delete(selectedHostingCategory);
        FacesUtil.sucessMessage("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditing() {
        return this.hostingCategory.getId() != null;
    }
}
