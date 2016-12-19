package fr.auroreJeremie.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import fr.auroreJeremie.Entity.Auteur;
import fr.auroreJeremie.Entity.Livre;
import fr.auroreJeremie.Service.AuteurService;

@RunWith(SpringRunner.class)
@WebMvcTest(AuteurController.class)
public class AuteurControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON_UTF8.getSubtype());
	
	private MockMvc mockMvc;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;
	
	private List<Auteur> auteurs;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private AuteurService service;
	
	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters){
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
				.findAny()
				.orElse(null);
		assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
	}
	
	@Before
	public void setUp() throws Exception{
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
		this.auteurs = new ArrayList<>();
		this.auteurs.add(service.save(new Auteur("Rice", "Anne")));
		this.auteurs.add(service.save(new Auteur("Straub", "Peter")));
		}
	
	 protected String json(Object o) throws IOException {
	        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
	        this.mappingJackson2HttpMessageConverter.write(
	                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
	        return mockHttpOutputMessage.getBodyAsString();
	    }
	
//	@Test
//	public void testShouldReturnAllAuteurs() throws Exception{
//		mockMvc.perform(get("/auteurs")).andExpect(status().isOk())
//		.andExpect(content().con)
//	}
}
