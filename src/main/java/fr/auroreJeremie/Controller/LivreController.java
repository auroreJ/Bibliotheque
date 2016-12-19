package fr.auroreJeremie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.auroreJeremie.Entity.Livre;
import fr.auroreJeremie.Service.LivreService;

@RestController
@RequestMapping("/livres")
public class LivreController {

	@Autowired
	private LivreService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Livre> getAllLivres() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Livre findLivreById(@PathVariable Long id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeLivreById(@PathVariable Long id) {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Livre saveLivre(@RequestBody Livre livre) {
		return service.save(livre);
	}

}
