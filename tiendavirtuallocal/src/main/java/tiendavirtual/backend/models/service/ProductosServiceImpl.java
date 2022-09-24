/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendavirtual.backend.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiendavirtual.backend.entity.Productos;
import tiendavirtual.backend.repository.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService{
    @Autowired
	public ProductosRepository productosRepository;
	
	@Override
	public List<Productos> findAll() {
		// TODO Auto-generated method stub
		return productosRepository.findAll();
	}

	@Override
	public Optional<Productos> findById(Integer codigoproducto) {
		// TODO Auto-generated method stub
		return productosRepository.findById(codigoproducto);
	}

	@Override
	public Productos save(Productos productos) {
		// TODO Auto-generated method stub
		return productosRepository.save(productos);
	}

	@Override
	public void deleteById(Integer codigoproducto) {
		// TODO Auto-generated method stub
		productosRepository.deleteById(codigoproducto);
	}

	@Override
	public List<Productos> ProductoNombre(String nombre) {
		// TODO Auto-generated method stub
		return productosRepository.ProductoNombre(nombre);
	}

    
}
