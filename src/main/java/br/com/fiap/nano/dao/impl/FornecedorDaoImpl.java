package br.com.fiap.nano.dao.impl;

import br.com.fiap.nano.dao.FornecedorDao;
import br.com.fiap.nano.entity.Fornecedor;

import javax.persistence.EntityManager;

public class FornecedorDaoImpl extends GenericDaoImpl<Fornecedor, Integer> implements FornecedorDao {
    public FornecedorDaoImpl(EntityManager em) {
        super(em);
    }
}
