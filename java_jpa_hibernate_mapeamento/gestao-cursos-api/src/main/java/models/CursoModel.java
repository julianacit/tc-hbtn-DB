package models;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CursoModel {
    public void create(Curso c) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(c);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Curso c) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Curso curso = entityManager.find(Curso.class, c.getId());
            entityManager.getTransaction().begin();
            curso.setNome(c.getNome());
            curso.setSigla(c.getSigla());
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Curso c) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Curso curso = entityManager.find(Curso.class, c.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(curso);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Curso findById(Curso c) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Curso curso = entityManager.find(Curso.class, c.getId());

            entityManager.close();
            entityManagerFactory.close();
            return curso;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Curso> findAll() {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createNativeQuery("SELECT * FROM Curso", Curso.class);

            List<Curso> cursos = query.getResultList();

            entityManager.close();
            entityManagerFactory.close();

            return cursos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
