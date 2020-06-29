package com.init.clientes.entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;




@Entity
@Table(name="clientes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cliente {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	
	@Column(name="apellido1", nullable=false, length=100)
	private String apellido1;
	
	@Column(name="apellido2", nullable=false, length=100)
	private String apellido2;
	
	@Column(name="tipodocu", nullable=false, length=3)
	private String tipoDocumento;
	
	@Column(name="numedocu", nullable=false, length=20)
	private String numeroDocumento;
	
	
	public Cliente (long id, String nombre, String apellido1, String apellido2, String tipoDocumento, String numeroDocumento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}
	
	public Cliente() {
		
	}
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	

}

