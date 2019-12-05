package br.com.xy.camada.dados.entidades;


		
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="poi")
public class PoiEnt implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private Integer coordenadaX;
	private Integer coordenadaY;
	
	public PoiEnt() {
		
	}
	
	public PoiEnt(String nome, Integer coordenadaX, Integer coordenadaY) {
		super();
		this.nome = nome;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public Integer getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	
	
	
	
}
