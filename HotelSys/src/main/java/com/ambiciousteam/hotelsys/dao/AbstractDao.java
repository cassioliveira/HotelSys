package com.ambiciousteam.hotelsys.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Esta classe representa um DAO genérico e contém todos os métodos básicos para
 * efetuar um CRUD.
 *
 * @author cassio
 * @param <T>
 */
public abstract class AbstractDao<T> implements Serializable {

    @Inject
    private EntityManager entityManager;

    private Class<T> entity;

    /**
     * Construtor da classe que captura a entidade que chamar esta classe.
     *
     * @param entityClass
     */
    public AbstractDao(Class<T> entityClass) {
        this.entity = entityClass;
    }

    /**
     * Método get para a instância do EntityManager
     *
     * @return
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Metodo utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     *
     * @param entity
     */
    public void save(T entity) {
        entityManager.merge(entity);
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados
     *
     * @param entity
     */
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    /**
     * Método utilizado para retornar uma lista com todos os resultados
     * encontrados no banco de dados para a esntidade que a chamar. A consulta é
     * feita através de Criteria
     *
     * @return
     */
    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entity));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     *
     * @param id
     * @return
     */
    public T findById(Long id) {
        return entityManager.find(entity, id);
    }

    /**
     * Método get para a instância da entidade que usar esta classe
     *
     * @return
     */
    public Class<T> getEntity() {
        return entity;
    }

    /**
     * Método set para a instância da entidade que usar esta classe
     *
     * @param entity
     */
    public void setEntity(Class<T> entity) {
        this.entity = entity;
    }

}
