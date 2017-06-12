package com.isen.test.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
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

	public String updateMobile(Mobile mobile) {
		try {
			entityManager.merge(mobile);
			return "200";
		} catch (Exception err) {
			return err.getMessage();
		}
	}

	public Mobile getMobileById(int id) {
		try {
		  final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
	        final CriteriaQuery<Mobile> lCriteriaQuery = lCriteriaBuilder.createQuery(Mobile.class);
	        final Root<Mobile> lRoot = lCriteriaQuery.from(Mobile.class);
	        javax.persistence.criteria.Path<Object> lPath = lRoot.get("id");
	        final Expression<Boolean> lExpession = lCriteriaBuilder.equal(lPath, id);
	        lCriteriaQuery.select(lRoot).where(lExpession);
	        final TypedQuery<Mobile> lQuery = entityManager.createQuery(lCriteriaQuery);
	        return (Mobile) lQuery.getResultList().get(0);
		} catch (Exception err) {
			return new Mobile();
		}
	}

}
