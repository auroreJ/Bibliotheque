package fr.auroreJeremie.Service;

import java.util.List;

import fr.auroreJeremie.Entity.Auteur;

public interface AuteurService {

	public abstract List<Auteur> findAll();

	public abstract void delete(Long id);

	public abstract Auteur save(Auteur auteur);

	public abstract Auteur findById(Long id);

	public abstract Auteur findByNom(String name);

}