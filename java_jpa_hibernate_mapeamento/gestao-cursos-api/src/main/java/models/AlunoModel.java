package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AlunoModel {
    public void create(Aluno a) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(a);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Aluno a) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Aluno aluno = entityManager.find(Aluno.class, a.getId());
            entityManager.getTransaction().begin();
            aluno.setEmail(a.getEmail());
            aluno.setMatricula(a.getMatricula());
            aluno.setNascimento(a.getNascimento());
            aluno.setNomeCompleto(a.getNomeCompleto());
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Aluno a) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Aluno aluno = entityManager.find(Aluno.class, a.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(aluno);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Aluno findById(Aluno a) {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Aluno Aluno = entityManager.find(Aluno.class, a.getId());

            entityManager.close();
            entityManagerFactory.close();
            return Aluno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Aluno> findAll() {
        try {
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createNativeQuery("SELECT * FROM Aluno", Aluno.class);

            List<Aluno> alunos = query.getResultList();

            entityManager.close();
            entityManagerFactory.close();

            return alunos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
