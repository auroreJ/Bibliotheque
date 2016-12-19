package fr.auroreJeremie.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.auroreJeremie.Entity.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {

}
