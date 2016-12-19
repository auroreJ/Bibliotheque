package fr.auroreJeremie.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Livre implements Serializable {

	private static final long serialVersionUID = 7473431192736390698L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titre;
	@ManyToOne
	@JoinColumn(name = "ID_EDIT")
	private Editeur editeur;
	@ManyToMany
	@JoinTable(name = "LIV_AUT")
	private List<Auteur> auteurs;

	public Livre() {}

	public Livre(String titre, List<Auteur> auteurs) {
		this.titre = titre;
		this.auteurs = auteurs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	@JsonIgnore
	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	@JsonSetter
	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

}
