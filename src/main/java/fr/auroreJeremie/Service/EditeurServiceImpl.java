package fr.auroreJeremie.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.auroreJeremie.Dao.EditeurRepository;
import fr.auroreJeremie.Entity.Editeur;

@Service
public class EditeurServiceImpl implements EditeurService {

	@Autowired
	private EditeurRepository repository;

	/*
	 * Recherche tous les editeurs en base
	 * 
	 * @see fr.auroreJeremie.Service.EditeurService#findAll()
	 */
	@Override
	public List<Editeur> findAll() {
		return repository.findAll();
	}

	/*
	 * Recherche un editeur en BDD a partir de son ID
	 * 
	 * @see fr.auroreJeremie.Service.EditeurService#findById(java.lang.Long)
	 */
	@Override
	public Editeur findById(Long id) {
		return repository.findOne(id);
	}

	/*
	 * Ajoute un editeur en base de données
	 * 
	 * @see
	 * fr.auroreJeremie.Service.EditeurService#save(fr.auroreJeremie.Entity.
	 * Editeur)
	 */
	@Override
	public Editeur save(Editeur editeur) {
		return repository.save(editeur);
	}

	/*
	 * Supprime un editeur en BDD a partir de son ID
	 * 
	 * @see fr.auroreJeremie.Service.EditeurService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

}
