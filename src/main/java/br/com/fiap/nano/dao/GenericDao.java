package br.com.fiap.nano.dao;

import br.com.fiap.nano.exception.CommitException;
import br.com.fiap.nano.exception.EntityNotFoundException;

public interface GenericDao<E, K> {
    void create(E entity);

    E read(K id) throws EntityNotFoundException;

    void update(E entity);

    void delete(K id) throws EntityNotFoundException;

    void commit() throws CommitException;
}
