package com.isen.test.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.isen.test.model.Mobile;

@Repository
public class RepositoryMobileImpl implements RepositoryMobile {

    @PersistenceContext
    private EntityManager entityManager;

	public List<Mobile> getAllMobiles() {
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Mobile> lCriteriaQuery = lCriteriaBuilder.createQuery(Mobile.class);
        final Root<Mobile> lRoot = lCriteriaQuery.from(Mobile.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Mobile> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
        return lTypedQuery.getResultList();
	}

	public void createMobile(Mobile mobile) {
        entityManager.persist(mobile);		
	}

	public void deleteMobile(Mobile mobileRepository) {
        final Mobile mobile = entityManager.getReference(Mobile.class, mobileRepository.getId());
        entityManager.remove(mobile);		
	}

}
