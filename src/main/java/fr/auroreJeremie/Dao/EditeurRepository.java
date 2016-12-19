package fr.auroreJeremie.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.auroreJeremie.Entity.Editeur;

@Repository
public interface EditeurRepository extends JpaRepository<Editeur, Long> {

}
