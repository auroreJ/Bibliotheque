package fr.auroreJeremie.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.auroreJeremie.Entity.Auteur;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {

	public Auteur findByNom(String nom);
}
