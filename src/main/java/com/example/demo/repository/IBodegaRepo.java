package com.example.demo.repository;

import com.example.demo.modelo.Bodega;

public interface IBodegaRepo {
	public void guardar(Bodega bodega);

	public Bodega buscarPorNumero(String numero);

}
