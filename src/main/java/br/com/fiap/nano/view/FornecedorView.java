package br.com.fiap.nano.view;

import br.com.fiap.nano.dao.FornecedorDao;
import br.com.fiap.nano.dao.impl.FornecedorDaoImpl;
import br.com.fiap.nano.entity.Fornecedor;
import br.com.fiap.nano.exception.CommitException;
import br.com.fiap.nano.exception.EntityNotFoundException;
import br.com.fiap.nano.singleton.EntityManagerFactorySingleton;
import javax.persistence.EntityManager;

public class FornecedorView {
    public FornecedorView() {
    }

    public static void main(String[] args) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        FornecedorDao dao = new FornecedorDaoImpl(em);
        Fornecedor fornecedor = new Fornecedor("Bruna");

        try {
            dao.create(fornecedor);
            dao.commit();
            System.out.println("Fornecedor cadstrado com sucesso!!");
        } catch (CommitException var8) {
            System.out.println(var8.getMessage());
        }

        try {
            fornecedor = (Fornecedor)dao.read(1);
            System.out.println("Forncedor encontrado com sucesso!!");
            System.out.println("Nome: " + fornecedor.getNome());
        } catch (EntityNotFoundException var7) {
            System.out.println(var7.getMessage());
        }

        fornecedor = new Fornecedor(1, "Alisson");

        try {
            dao.update(fornecedor);
            dao.commit();
            System.out.println("Fornecedor atualizado!!");
        } catch (CommitException var6) {
            System.out.println(var6.getMessage());
        }

        try {
            dao.delete(1);
            dao.commit();
        } catch (EntityNotFoundException | CommitException var5) {
            System.out.println(var5.getMessage());
        }

        em.close();
        EntityManagerFactorySingleton.getInstance().close();
    }
}

