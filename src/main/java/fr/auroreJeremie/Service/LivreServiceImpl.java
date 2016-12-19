package fr.auroreJeremie.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.auroreJeremie.Dao.LivreRepository;
import fr.auroreJeremie.Entity.Livre;

@Service
public class LivreServiceImpl implements LivreService {

	@Autowired
	private LivreRepository repository;

	/*
	 * Recherche tous les livres en base
	 * 
	 * @see fr.auroreJeremie.Service.LivreService#findAll()
	 */
	@Override
	public List<Livre> findAll() {
		return repository.findAll();
	}

	/*
	 * Recherche un livre en BDD a partir de son ID
	 * 
	 * @see fr.auroreJeremie.Service.LivreService#findById(java.lang.Long)
	 */
	@Override
	public Livre findById(Long id) {
		return repository.findOne(id);
	}

	/*
	 * Ajoute un livre en base de données
	 * 
	 * @see
	 * fr.auroreJeremie.Service.LivreService#save(fr.auroreJeremie.Entity.Livre)
	 */
	@Override
	public Livre save(Livre livre) {
		return repository.save(livre);
	}

	/*
	 * Supprime un livre en BDD a partir de son ID
	 * 
	 * @see fr.auroreJeremie.Service.LivreService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

}
