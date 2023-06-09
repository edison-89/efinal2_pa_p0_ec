package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.repository.IBodegaRepo;

@Service
public class BodegaServiceImpl implements IBodegaService {

	@Autowired
	private IBodegaRepo bodegaRepo;

	@Override
	public void ingresar(Bodega bodega) {
		this.bodegaRepo.guardar(bodega);
	}

}
