package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Bodega;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class BodegaRepoImpl implements IBodegaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void guardar(Bodega bodega) {
		this.entityManager.persist(bodega);
	}

	@Override
	public Bodega buscarPorNumero(String numero) {
		TypedQuery<Bodega> query = this.entityManager.createQuery("select b from Bodega b where b.numero=:numero",
				Bodega.class);
		query.setParameter("numero", numero);
		return query.getResultList().get(0);
	}

}
