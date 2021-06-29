package br.com.fiap.nano.view;

import br.com.fiap.nano.dao.ClienteDao;
import br.com.fiap.nano.dao.ProdutoDao;
import br.com.fiap.nano.dao.impl.ClienteDaoImpl;
import br.com.fiap.nano.dao.impl.ProdutoDaoImpl;
import br.com.fiap.nano.entity.Cliente;
import br.com.fiap.nano.entity.EstadoProduto;
import br.com.fiap.nano.entity.Produto;
import br.com.fiap.nano.exception.CommitException;
import br.com.fiap.nano.exception.EntityNotFoundException;
import br.com.fiap.nano.singleton.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        ClienteDao dao = new ClienteDaoImpl(em);
        Cliente cliente = new Cliente("Rodrigo");

        //Cadstrar
        try {
            dao.create(cliente);
            dao.commit();
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }

        //Pesquisar
        try {
            cliente = dao.read(1);
            System.out.println("Nome do cliente" + cliente.getNome());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());

        }
        // Atualizar
        cliente = new Cliente(1, "Bruna");
        try {
            dao.update(cliente);
            dao.commit();
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }

        try {
            dao.delete(1);
            dao.commit();
        } catch (CommitException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }


        em.close();
        EntityManagerFactorySingleton.getInstance().close();
    }
}
