package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Inventario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class InventarioRepoImpl implements IInventarioRepo {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void ingresar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(inventario);
	}

}
