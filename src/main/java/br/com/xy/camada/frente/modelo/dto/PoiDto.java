package br.com.xy.camada.frente.modelo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.xy.camada.dados.entidades.PoiEnt;

public class PoiDto {

	private String nome;
	private Integer coordenadaX;
	private Integer coordenadaY;
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public PoiDto(PoiEnt ent) {
	
		this.nome= ent.getNome();
		this.coordenadaX= ent.getCoordenadaX();
		this.coordenadaY = ent.getCoordenadaY();
	}

	public static List<PoiDto> converter(List<PoiEnt> ent){
		
		return ent.stream().map(PoiDto::new).collect(Collectors.toList());
		
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
