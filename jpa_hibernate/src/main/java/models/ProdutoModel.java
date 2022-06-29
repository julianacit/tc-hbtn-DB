package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ProdutoModel {
    public void create(Produto p) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Produto p) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Produto produto = entityManager.find(Produto.class, p.getId());
            entityManager.getTransaction().begin();
            produto.setNome(p.getNome());
            produto.setPreco(p.getPreco());
            produto.setQuantidade(p.getQuantidade());
            produto.setStatus(p.isStatus());
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Produto p) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Produto produto = entityManager.find(Produto.class, p.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(produto);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Produto findById(Produto p) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Produto produto = entityManager.find(Produto.class, p.getId());

            entityManager.close();
            entityManagerFactory.close();
            return produto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Produto> findAll() {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createNativeQuery("SELECT * FROM Produto", Produto.class);

            List<Produto> produtos = query.getResultList();

            entityManager.close();
            entityManagerFactory.close();

            return produtos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
