package br.com.fiap.nano.dao.impl;

import br.com.fiap.nano.dao.ProdutoDao;
import br.com.fiap.nano.entity.Produto;

import javax.persistence.EntityManager;

public class ProdutoDaoImpl extends GenericDaoImpl<Produto, Integer> implements ProdutoDao {
    public ProdutoDaoImpl(EntityManager em) {
        super(em);
    }
}
