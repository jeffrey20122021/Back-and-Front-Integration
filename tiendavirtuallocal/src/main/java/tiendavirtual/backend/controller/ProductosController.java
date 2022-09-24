/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendavirtual.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tiendavirtual.backend.models.service.ProductosService;
import tiendavirtual.backend.entity.Productos;


@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
@RestController
//@CrossOrigin(origins = "")
public class ProductosController {
    
    @Autowired
	ProductosService productosService;
	
	@GetMapping("/listar")
	public List<Productos> listar(){
		return productosService.findAll();
	}
	
	@GetMapping("/{codigoproducto}")
	public Optional<Productos> findById(@PathVariable Integer codigoproducto){
		return productosService.findById(codigoproducto);			
	}
	
	@PostMapping
	public Productos save(@RequestBody Productos productos) {
		return productosService.save(productos);
	}
	
	@PutMapping("/{codigoproducto}")
	public Productos update(@RequestBody Productos productos, @PathVariable Integer codigoproducto) {
		Productos productosBD = productosService.findById(codigoproducto).get();
		productosBD.setNombre(productos.getNombre());
		productosBD.setFecha_de_vencimiento(productos.getFecha_de_vencimiento());
		productosBD.setExistencias(productos.getExistencias());
		productosBD.setCostoxunidad(productos.getCostoxunidad());
		return productosService.save(productosBD);	
	}
	@DeleteMapping("/delete/{codigoproducto}")
	public void deleteById(@PathVariable Integer codigoproducto) {
		productosService.deleteById(codigoproducto);
	}
	
	@GetMapping("/nombre/{nombre}")
	public List<Productos> ProductoNombre(@PathVariable String nombre){
		return productosService.ProductoNombre(nombre);	
	}
    
}
