package br.com.fiap.nano.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getInstance() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("smatcities");
        }
        return factory;
    }
    private EntityManagerFactorySingleton() {}
}
