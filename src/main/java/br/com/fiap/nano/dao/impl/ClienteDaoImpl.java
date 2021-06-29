package br.com.fiap.nano.dao.impl;

import br.com.fiap.nano.dao.ClienteDao;
import br.com.fiap.nano.entity.Cliente;

import javax.persistence.EntityManager;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao {
    public ClienteDaoImpl(EntityManager em) {
        super(em);
    }
}
