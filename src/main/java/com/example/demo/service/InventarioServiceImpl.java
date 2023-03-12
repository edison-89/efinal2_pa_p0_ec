package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.InventarioTmp;
import com.example.demo.modelo.Producto;
import com.example.demo.repository.IBodegaRepo;
import com.example.demo.repository.IInventarioRepo;
import com.example.demo.repository.IProductoRepo;

@Service
public class InventarioServiceImpl implements IInventarioService {

	@Autowired
	private IBodegaRepo bodegaRepo;

	@Autowired
	private IProductoRepo productoRepo;

	@Autowired
	private IInventarioRepo inventarioRepo;

	@Override
	public void ingresar(InventarioTmp inventarioTmp) {
		// TODO Auto-generated method stub
		Bodega bodega = this.bodegaRepo.buscarPorNumero(inventarioTmp.getNumeroBodega());
		Producto producto = this.productoRepo.buscarPorCodigoMaestro(inventarioTmp.getCodigoBarrasMaestro());

		for (int i = 1; i <= inventarioTmp.getCantidad(); i++) {
			Inventario inv = new Inventario();
			inv.setBodega(bodega);
			inv.setProducto(producto);
			String codigoBarrasIndividual = inventarioTmp.getCodigoBarrasMaestro() + i;
			inv.setCodigoBarrasIndividual(codigoBarrasIndividual);
			this.inventarioRepo.ingresar(inv);
		}

		// Actualizamos el stock en el catalogo del producto
		producto.setStock(producto.getStock() + inventarioTmp.getCantidad());
		this.productoRepo.actualizar(producto);

	}

}
