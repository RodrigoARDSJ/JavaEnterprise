package br.com.fiap.nano.view;

import br.com.fiap.nano.dao.ProdutoDao;
import br.com.fiap.nano.dao.impl.ProdutoDaoImpl;
import br.com.fiap.nano.entity.EstadoProduto;
import br.com.fiap.nano.entity.Produto;
import br.com.fiap.nano.exception.CommitException;
import br.com.fiap.nano.exception.EntityNotFoundException;
import br.com.fiap.nano.singleton.EntityManagerFactorySingleton;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;

public class ProdutoView {
    public ProdutoView() {
    }

    public static void main(String[] args) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        ProdutoDao dao = new ProdutoDaoImpl(em);

        Produto produto = new Produto("Celular", 2000.00, new GregorianCalendar(2020, Calendar.AUGUST, 2020),
                "Descrição teste", EstadoProduto.NOVO);

        try {
            produto = (Produto) dao.read(1);
            PrintStream var10000 = System.out;
            int var10001 = produto.getId();
            var10000.println("Produto encontrado: " + var10001 + " " + produto.getNome());
        } catch (EntityNotFoundException var7) {
            System.out.println(var7.getMessage());
        }

        produto = new Produto(1, "Playstation 5", 5000.00, new GregorianCalendar(2090, 3, 22), "Video game de ultima geração", EstadoProduto.NOVO);

        try {
            dao.update(produto);
            dao.commit();
        } catch (CommitException var6) {
            System.out.println(var6.getMessage());
        }

        try {
            dao.delete(5);
            dao.commit();
        } catch (EntityNotFoundException | CommitException var5) {
            System.out.println(var5.getMessage());
        }

        em.close();
        EntityManagerFactorySingleton.getInstance().close();
    }
}
