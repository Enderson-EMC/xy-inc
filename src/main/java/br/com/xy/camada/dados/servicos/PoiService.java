package br.com.xy.camada.dados.servicos;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.xy.camada.dados.entidades.PoiEnt;
import br.com.xy.camada.dados.repositorios.PoiRep;
import br.com.xy.camada.frente.modelo.dto.PoiDto;
import br.com.xy.camada.frente.modelo.form.PoiForm;

/* @Transactional -> para fazer o commit ao finalizar o método */

@Service
public class PoiService {

	@Autowired
	private PoiRep rep;

	public List<PoiDto> getLista() {


		List<PoiEnt> lista = rep.findAll();
		return PoiDto.converter(lista);

	}

	public List<PoiDto> getLista(Integer x, Integer y, Integer dMax) {

		List<PoiEnt> lista = rep.findByProximidade(x, y, dMax);

		return PoiDto.converter(lista);

	}

	public ResponseEntity<PoiDto> detalhar(Long id) {

		if(id == null)
			return ResponseEntity.badRequest().build();
		
		Optional<PoiEnt> oEnt = rep.findById(id);
		
		if (oEnt.isPresent()) {
			PoiEnt ent = oEnt.get();
			
			return ResponseEntity.ok(new PoiDto(ent));

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Transactional
	public ResponseEntity<PoiDto> cadastrar(PoiForm form, String path, UriComponentsBuilder uriBuilder) {


		PoiEnt ent = form.converter();

		rep.save(ent);

		URI uri = uriBuilder.path(path).buildAndExpand(ent.getId()).toUri();

		return ResponseEntity.created(uri).body(new PoiDto(ent));
	}

}
