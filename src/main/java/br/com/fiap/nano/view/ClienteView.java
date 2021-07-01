package br.com.fiap.nano.view;

import br.com.fiap.nano.dao.ClienteDao;
import br.com.fiap.nano.dao.impl.ClienteDaoImpl;
import br.com.fiap.nano.entity.Cliente;
import br.com.fiap.nano.exception.CommitException;
import br.com.fiap.nano.exception.EntityNotFoundException;
import br.com.fiap.nano.singleton.EntityManagerFactorySingleton;
import javax.persistence.EntityManager;

public class ClienteView {
    public ClienteView() {
    }

    public static void main(String[] args) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        ClienteDao dao = new ClienteDaoImpl(em);
        Cliente cliente = new Cliente("Rodrigo");

        try {
            dao.create(cliente);
            dao.commit();
        } catch (CommitException var8) {
            System.out.println(var8.getMessage());
        }

        try {
            cliente = (Cliente)dao.read(1);
            System.out.println("Nome do cliente" + cliente.getNome());
        } catch (EntityNotFoundException var7) {
            System.out.println(var7.getMessage());
        }

        cliente = new Cliente(1, "Bruna");

        try {
            dao.update(cliente);
            dao.commit();
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