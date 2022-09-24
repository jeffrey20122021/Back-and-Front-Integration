/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendavirtual.backend.entity;
;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "productos")
public class Productos implements Serializable {
   @Id
    @Column(name = "codigoproducto")
	private int codigoproducto;
    @Column(name = "nombre")
	private String nombre;
    @Column(name = "fecha_de_vencimiento")
	private String fecha_de_vencimiento;
    @Column(name = "existencias")
	private int existencias;
    @Column(name = "costoxunidad")
	private int costoxunidad;
    
	public Productos(int codigoproducto, String nombre, String fecha_de_vencimiento, int existencias,
			int costoxunidad) {
		super();
		this.codigoproducto = codigoproducto;
		this.nombre = nombre;
		this.fecha_de_vencimiento = fecha_de_vencimiento;
		this.existencias = existencias;
		this.costoxunidad = costoxunidad;
	}

	public Productos() {
		super();
	}

	public int getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(int codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_de_vencimiento() {
		return fecha_de_vencimiento;
	}

	public void setFecha_de_vencimiento(String fecha_de_vencimiento) {
		this.fecha_de_vencimiento = fecha_de_vencimiento;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	public int getCostoxunidad() {
		return costoxunidad;
	}

	public void setCostoxunidad(int costoxunidad) {
		this.costoxunidad = costoxunidad;
	}

	@Override
	public String toString() {
		return "Productos [codigoproducto=" + codigoproducto + ", nombre=" + nombre + ", fecha_de_vencimiento="
				+ fecha_de_vencimiento + ", existencias=" + existencias + ", costoxunidad=" + costoxunidad + "]";
	} 
    
}
