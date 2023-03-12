package com.example.demo.repository;

import com.example.demo.modelo.Producto;

public interface IProductoRepo {
	public void guardar(Producto producto);

	public Producto buscarPorCodigoMaestro(String codigoMaestro);

	public void actualizar(Producto producto);

}
