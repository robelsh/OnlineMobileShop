package com.isen.test.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.isen.test.model.User;

@Repository
public class RepositoryUserImpl implements RepositoryUser {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> searchUser() {
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<User> lCriteriaQuery = lCriteriaBuilder.createQuery(User.class);
        final Root<User> lRoot = lCriteriaQuery.from(User.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<User> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
    }

    public void createUser(User user) {
        entityManager.persist(user);
    }

    public void deleteUser(User userRepository) {
        final User user = entityManager.getReference(User.class, userRepository.getId());
        entityManager.remove(user);
    }

    public void updateUser(User userRepository) {
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaUpdate<User> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(User.class);
        final Root<User> lRoot = lCriteriaUpdate.from(User.class);
        javax.persistence.criteria.Path<Object> lPath = lRoot.get("id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, userRepository.getId());
        lCriteriaUpdate.where(lExpression);
        lCriteriaUpdate.set("age", userRepository.getAge());
        lCriteriaUpdate.set("name", userRepository.getName());
        lCriteriaUpdate.set("surname", userRepository.getSurname());
        javax.persistence.Query lQuery = entityManager.createQuery(lCriteriaUpdate);
        final int lRowCount = lQuery.executeUpdate();

        if (lRowCount != 1) {
            final org.hibernate.Query lHQuery = ((EntityManager) lQuery).unwrap(org.hibernate.Query.class);
            @SuppressWarnings("unused")
            final String lSql = lHQuery.getQueryString();
        }

    }

    public User searchOneUser(User userRepository) {
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<User> lCriteriaQuery = lCriteriaBuilder.createQuery(User.class);
        final Root<User> lRoot = lCriteriaQuery.from(User.class);
        javax.persistence.criteria.Path<Object> lPath = lRoot.get("id");
        final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, userRepository.getId());
        lCriteriaQuery.select(lRoot).where(lExpression);
        final TypedQuery<User> lQuery = entityManager.createQuery(lCriteriaQuery);

        return (User) lQuery.getResultList();

    }
}
