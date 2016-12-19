package fr.auroreJeremie;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

import fr.auroreJeremie.Entity.Auteur;
import fr.auroreJeremie.Entity.Editeur;
import fr.auroreJeremie.Entity.Livre;
import fr.auroreJeremie.Service.AuteurService;
import fr.auroreJeremie.Service.EditeurService;
import fr.auroreJeremie.Service.LivreService;

@SpringBootApplication
@EnableSwagger2
public class BibliothequeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);
	}

	/**
	 * Initialisation des données dans la base de données
	 */
	@Autowired
	private AuteurService auteurService;
	@Autowired
	private LivreService livreService;
	@Autowired
	private EditeurService editeurService;

	@Override
	public void run(String... paramArrayOfString) throws Exception {
		List<Auteur> auteurs = new ArrayList<>();
		List<Auteur> auteurs2 = new ArrayList<>();

		Auteur auteur1 = auteurService.save(new Auteur("Rice", "Anne"));
		Auteur auteur2 = auteurService.save(new Auteur("Straub", "Peter"));
		Auteur auteur3 = auteurService.save(new Auteur("King", "Stephen"));

		Editeur editeur = editeurService.save(new Editeur("Broche"));
		Editeur editeur2 = editeurService.save(new Editeur("Points"));
		auteurs.add(auteur1);
		Livre livre1 = livreService.save(new Livre("Lestat", auteurs));
		auteurs2.add(auteur2);
		Livre livre2 = livreService.save(new Livre("Ghost Story", auteurs2));
	}

	/**
	 * Generation de la documentation swagger
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		// url docs : http://localhost:8080/v2/api-docs
		// url UI : http://localhost:8080/swagger-ui.html
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.any())
				.paths(bibliothequePaths()).build();
	}

	private Predicate<String> bibliothequePaths() {
		return or(regex("/livres.*"), 
				regex("/auteurs.*"), 
				regex("/editeurs.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Bibliotheque API")
				.description(
						"Bibliotheque stockant des livres, des auteurs et des editeurs")
				.contact("Aurore").build();
	}
}
