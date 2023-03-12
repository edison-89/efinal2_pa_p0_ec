package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void guardar(Producto producto) {
		this.entityManager.persist(producto);
	}

	@Override
	public Producto buscarPorCodigoMaestro(String codigoMaestro) {
		TypedQuery<Producto> query = this.entityManager
				.createQuery("select p from Producto p where p.codigoBarrasMaestro=:codigoMaestro", Producto.class);
		query.setParameter("codigoMaestro", codigoMaestro);
		return query.getResultList().get(0);
	}

	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);
	}

}
