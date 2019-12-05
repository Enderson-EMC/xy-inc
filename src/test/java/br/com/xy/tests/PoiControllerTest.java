package br.com.xy.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import br.com.xy.camada.dados.entidades.PoiEnt;
import br.com.xy.camada.dados.repositorios.PoiRep;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PoiControllerTest extends TestCase{

	    @Autowired
	    private MockMvc mockMvc;
	    @Autowired
	    private PoiRep repository;
	    
	    @Before
	    @Transactional
	    public void setUp() throws Exception {
	 
	    	repository.deleteAll();
	    	
	        repository.save(new PoiEnt("Lanchonete", 27, 12));
	        repository.save(new PoiEnt("Posto", 31, 18));
	        repository.save(new PoiEnt("Joalheria", 15, 12));
		    repository.save(new PoiEnt("Floricultura", 19, 21));
		    repository.save(new PoiEnt("Pub", 12, 8));        
		    repository.save(new PoiEnt("Supermercado", 23, 6));
		    repository.save(new PoiEnt("Churrascaria", 28, 2));
		    
	    }	    
	    
	    @Test
	    public void listar() throws Exception {
	        mockMvc.perform(get("/poi")
	                .accept(MediaType.APPLICATION_JSON))
	        	    .andExpect(status().isOk())
	                ;
	    }
	
	    @Test
	    public void listarPorProximidade() throws Exception {
	        mockMvc.perform(get("/poi/proximidade")
	        		.param("x", "20")
	        		.param("y", "10")
	        		.param("dmax", "10")
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                ;
	    }
	
}
