package fr.auroreJeremie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.auroreJeremie.Entity.Auteur;
import fr.auroreJeremie.Service.AuteurService;

@RestController
@RequestMapping("/auteurs")
public class AuteurController {

	@Autowired
	private AuteurService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Auteur> getAllAuteurs() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Auteur getAuteurById(@PathVariable Long id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Auteur saveAuteur(@RequestBody Auteur auteur) {
		return service.save(auteur);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeAuteur(@PathVariable Long id) {
		service.delete(id);
	}

	@RequestMapping(value = "/search/findByLastName", method = RequestMethod.GET)
	public Auteur getAuteurByName(@RequestParam String nom) {
		return service.findByNom(nom);
	}
}
