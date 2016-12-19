package fr.auroreJeremie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.auroreJeremie.Entity.Editeur;
import fr.auroreJeremie.Service.EditeurService;

@RestController
@RequestMapping("/editeurs")
public class EditeurController {

	@Autowired
	private EditeurService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Editeur> getAllEditeurs() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Editeur getEditeurById(@PathVariable Long id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEditeurById(@PathVariable Long id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Editeur saveEditeur(@RequestBody Editeur editeur) {
		return service.save(editeur);
	}
}
