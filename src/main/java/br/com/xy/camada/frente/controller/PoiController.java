package br.com.xy.camada.frente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.xy.camada.dados.servicos.PoiService;
import br.com.xy.camada.frente.modelo.dto.PoiDto;
import br.com.xy.camada.frente.modelo.form.PoiForm;


@RestController
@RequestMapping("/poi")
public class PoiController {

	@Autowired
	private PoiService servicePoi;

	@GetMapping
	public List<PoiDto> getLista() {

		return servicePoi.getLista();

	}

	
	@GetMapping("/proximidade")
	public List<PoiDto> getListaPorProximidade(@RequestParam Integer x, @RequestParam @Valid Integer y, @RequestParam @Valid Integer dmax) {

		return servicePoi.getLista(x, y, dmax);

	}

	@GetMapping("/{id}")
	public ResponseEntity<PoiDto> detalhar(@PathVariable Long id) {

		return servicePoi.detalhar(id);
	}

	@PostMapping
	public ResponseEntity<PoiDto> cadastrar(@RequestBody @Valid PoiForm form, UriComponentsBuilder uriBuilder) {

		return servicePoi.cadastrar(form, "/poi/{id}", uriBuilder);

	}
	
	
}
