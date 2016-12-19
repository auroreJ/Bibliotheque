package fr.auroreJeremie.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Editeur implements Serializable {

	private static final long serialVersionUID = 4269377609953066761L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	@OneToMany(mappedBy = "editeur", fetch = FetchType.LAZY)
	private List<Livre> livres;

	public Editeur() {}

	public Editeur(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@JsonIgnore
	public List<Livre> getLivres() {
		return livres;
	}

	@JsonSetter
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

}
