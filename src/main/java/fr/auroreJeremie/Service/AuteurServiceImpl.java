package fr.auroreJeremie.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.auroreJeremie.Dao.AuteurRepository;
import fr.auroreJeremie.Entity.Auteur;

@Service
public class AuteurServiceImpl implements AuteurService {

	@Autowired
	private AuteurRepository repository;

	/*
	 * Recherche tous les auteurs en base
	 * 
	 * @see fr.auroreJeremie.Service.AuteurService#findAll()
	 */
	@Override
	public List<Auteur> findAll() {
		return repository.findAll();
	}

	/*
	 * Supprime un auteur en BDD a partir de son ID
	 * 
	 * @see fr.auroreJeremie.Service.AuteurService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	/*
	 * Ajoute un auteur en base de données
	 * 
	 * @see
	 * fr.auroreJeremie.Service.AuteurService#save(fr.auroreJeremie.Entity.Auteur
	 * )
	 */
	@Override
	public Auteur save(Auteur auteur) {
		return repository.save(auteur);
	}

	/*
	 * Recherche un auteur en BDD a partir de son ID
	 * 
	 * @see fr.auroreJeremie.Service.AuteurService#findById(java.lang.Long)
	 */
	@Override
	public Auteur findById(Long id) {
		return repository.findOne(id);
	}

	/*
	 * Recherche un auteur en BDD a partir de son nom
	 * 
	 * @see fr.auroreJeremie.Service.AuteurService#findByNom(java.lang.String)
	 */
	@Override
	public Auteur findByNom(String name) {
		return repository.findByNom(name);
	}

}
