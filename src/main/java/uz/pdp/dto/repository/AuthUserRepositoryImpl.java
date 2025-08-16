package uz.pdp.dto.repository;

import uz.pdp.dto.model.entity.AuthUser;
import uz.pdp.dto.model.entity.Workspace;
import jakarta.persistence.EntityManager;
import uz.pdp.dto.utils.EntityManagerFactoryUtil;

import java.util.List;
import java.util.Optional;

public class AuthUserRepositoryImpl implements  AuthUserRepository{
    @Override
    public Optional<AuthUser> findById(String username) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        AuthUser user = em.find(AuthUser.class, username);
        em.close();
        return Optional.ofNullable(user);
    }

    @Override
    public List<AuthUser> findAll() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        List<AuthUser> users = em.createQuery("SELECT u FROM AuthUser u", AuthUser.class)
                .getResultList();
        em.close();
        return users;
    }

    @Override
    public AuthUser save(AuthUser entity) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        em.close();
        return entity;
    }

    @Override
    public void delete(AuthUser entity) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        AuthUser merged = em.merge(entity);
        em.remove(merged);
        em.getTransaction().commit();

        em.close();
    }
}
