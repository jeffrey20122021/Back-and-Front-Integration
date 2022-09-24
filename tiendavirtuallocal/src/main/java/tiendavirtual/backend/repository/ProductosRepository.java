/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tiendavirtual.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tiendavirtual.backend.entity.Productos;

/**
 *
 * @author Block
 */
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
  @Query("select p from Productos p where p.nombre = ?1")
  public List<Productos> ProductoNombre(String nombre);
    
}
