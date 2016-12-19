package fr.auroreJeremie.Service;

import java.util.List;

import fr.auroreJeremie.Entity.Editeur;

public interface EditeurService {

	public abstract List<Editeur> findAll();

	public abstract Editeur findById(Long id);

	public abstract Editeur save(Editeur editeur);

	public abstract void delete(Long id);

}