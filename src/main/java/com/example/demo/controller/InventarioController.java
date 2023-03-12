package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.InventarioTmp;
import com.example.demo.service.IInventarioService;

@Controller
@RequestMapping("/inventarios")
public class InventarioController {
	@Autowired
	private IInventarioService inventarioService;

	@GetMapping("/nuevoInventario")
	public String paginaNuevoInventario(InventarioTmp inventarioTmp) {
		return "vistaNuevoInventario";
	}

	@PostMapping("/insertar")
	public String insertarInventario(InventarioTmp inventarioTmp, Model modelo) {
		this.inventarioService.ingresar(inventarioTmp);
		inventarioTmp = new InventarioTmp();
		modelo.addAttribute("inventarioTmp", inventarioTmp);
		return "vistaNuevoInventario";
	}
}
