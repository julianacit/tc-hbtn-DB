package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PessoaModel {
    public void create(Pessoa p) {
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

    public void update(Pessoa p) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Pessoa pessoa = entityManager.find(Pessoa.class, p.getId());
            entityManager.getTransaction().begin();
            pessoa.setNome(p.getNome());
            pessoa.setCpf(p.getCpf());
            pessoa.setEmail(p.getEmail());
            pessoa.setIdade(p.getIdade());
            pessoa.setDataDeNascimento(p.getDataDeNascimento());
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Pessoa p) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Pessoa pessoa = entityManager.find(Pessoa.class, p.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pessoa findById(Pessoa p) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Pessoa pessoa = entityManager.find(Pessoa.class, p.getId());

            entityManager.close();
            entityManagerFactory.close();
            return pessoa;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Pessoa> findAll() {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createNativeQuery("SELECT * FROM Pessoa", Pessoa.class);

            List<Pessoa> pessoas = query.getResultList();

            entityManager.close();
            entityManagerFactory.close();

            return pessoas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
