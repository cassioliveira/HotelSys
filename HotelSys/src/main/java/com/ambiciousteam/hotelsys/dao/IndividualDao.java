package com.ambiciousteam.hotelsys.dao;

import com.ambiciousteam.hotelsys.model.Individual;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class IndividualDao extends AbstractDao<Individual> implements Serializable {

    public IndividualDao() {
        super(Individual.class);
    }
    
    public List<Individual> hostedNames(){
        Query createQuery;

        createQuery = getEntityManager().createQuery("SELECT i.name FROM Individual AS i, Hosting AS h WHERE h.individualFK=i.id");
        return createQuery.getResultList();
    }

    public List<Individual> findByNameLike(String query) {

        Query createQuery;

//        if (StringUtils.isNotBlank(query)) {
        createQuery = getEntityManager().createQuery("from Individual c where c.name like :name");
        createQuery.setParameter("name", "%" + query + "%");
//        }
        return createQuery.getResultList();
    }
    
    /**
     * Retorna consulta que verifica se CPF já existe no banco
     * @param cpf
     * @return 
     */
//    public String hasCPF(String cpf){
//        return getEntityManager().createNamedQuery("Individual.cpf", Individual.class).setParameter(cpf, cpf).getSingleResult().toString();
    // SELECT i.client_cpf_client FROM individual i WHERE i.client_cpf_client = '01404526480' Consulta sql para busca de cpf
//    }
}
