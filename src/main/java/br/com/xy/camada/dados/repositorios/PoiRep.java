package br.com.xy.camada.dados.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.xy.camada.dados.entidades.PoiEnt;

public interface PoiRep extends JpaRepository<PoiEnt, Long>{
	
	String queryNative = 
			"select * from poi " + 
			"where sqrt(power(abs(poi.coordenadaX-?1),2) + power(abs(poi.coordenadaY-?2),2) ) <= ?3";
	
	@Query(value = queryNative, nativeQuery = true)
	List<PoiEnt> findByProximidade(int x, int y, int dmax);
}
