/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tiendavirtual.backend.models.service;

import java.util.List;
import java.util.Optional;

import tiendavirtual.backend.entity.Productos;
public interface ProductosService {

	public List<Productos> findAll();
	public Optional<Productos> findById(Integer codigoproducto);
	public Productos save(Productos productos);
	public void deleteById(Integer codigoproducto);
	public List<Productos> ProductoNombre(String nombre);
}
