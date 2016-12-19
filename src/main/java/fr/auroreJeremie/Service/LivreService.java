package fr.auroreJeremie.Service;

import java.util.List;

import fr.auroreJeremie.Entity.Livre;

public interface LivreService {

	public abstract List<Livre> findAll();

	public abstract Livre findById(Long id);

	public abstract Livre save(Livre livre);

	public abstract void delete(Long id);

}