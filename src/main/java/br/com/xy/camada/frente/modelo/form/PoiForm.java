package br.com.xy.camada.frente.modelo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import br.com.xy.camada.dados.entidades.PoiEnt;

public class PoiForm {

	@NotNull @Length(min=3) @NotEmpty
	private String nome;
	@NotNull @PositiveOrZero
	private Integer coordenadaX;
	@NotNull @PositiveOrZero
	private Integer coordenadaY;
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public PoiEnt converter(){
		
		
		PoiEnt ent = new PoiEnt(nome, coordenadaX, coordenadaY);
		
		return ent;
		
		
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

	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////

}
