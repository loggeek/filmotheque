package fr.eni.tp.filmotheque.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Component
@EqualsAndHashCode(of = "id")
public class Film implements Serializable
{
	private long id;
	private String titre;
	private int annee;
	private int duree;
	private String synopsis;
	private Participant realisateur;
	private List<Participant> acteurs = new ArrayList<>();
	private Genre genre;
	private List<Avis> avis = new ArrayList<>();

	public Film()
	{
	}

	public Film(String titre, int annee, int duree, String synopsis)
	{
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
	}

	public Film(long id, String titre, int annee, int duree, String synopsis)
	{
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
	}
}
