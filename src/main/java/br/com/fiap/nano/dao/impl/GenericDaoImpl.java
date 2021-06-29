package br.com.fiap.nano.dao.impl;

import br.com.fiap.nano.dao.GenericDao;
import br.com.fiap.nano.exception.CommitException;
import br.com.fiap.nano.exception.EntityNotFoundException;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K> {

    private EntityManager em;
    private Class<E> clazz;

    @SuppressWarnings("all")
    public GenericDaoImpl(EntityManager em) {
        this.em = em;
        this.clazz = (Class<E>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void create(E entity) {
        em.persist(entity);
    }

    @Override
    public E read(K id) throws EntityNotFoundException {
        E entity = em.find(clazz, id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }

    @Override
    public void update(E entity) {
        em.merge(entity);

    }

    @Override
    public void delete(K id) throws EntityNotFoundException {
        E entity = read(id);
        em.remove(entity);

    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new CommitException();
        }

    }
}
