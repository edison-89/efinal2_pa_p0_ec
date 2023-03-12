package com.example.demo.modelo;

//Clase temporal que sirve como modelo para enviar los datos desde la vista
public class InventarioTmp {
	private String numeroBodega;
	private String codigoBarrasMaestro;
	private Integer cantidad;

	// Metodos SET y GET

	public String getNumeroBodega() {
		return numeroBodega;
	}

	public void setNumeroBodega(String numeroBodega) {
		this.numeroBodega = numeroBodega;
	}

	public String getCodigoBarrasMaestro() {
		return codigoBarrasMaestro;
	}

	public void setCodigoBarrasMaestro(String codigoBarrasMaestro) {
		this.codigoBarrasMaestro = codigoBarrasMaestro;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
