package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Bodega;
import com.example.demo.service.IBodegaService;

@Controller
@RequestMapping("/bodegas")
public class BodegaController {

	@Autowired
	private IBodegaService bodegaService;

	@GetMapping("/nuevaBodega")
	public String paginaNuevaBodega(Bodega bodega) {
		return "vistaNuevaBodega";
	}

	@PostMapping("/insertar")
	public String insertarBodega(Bodega bodega, Model modelo) {
		this.bodegaService.ingresar(bodega);
		bodega = new Bodega();
		modelo.addAttribute("bodega", bodega);
		return "vistaNuevaBodega";
	}
}
