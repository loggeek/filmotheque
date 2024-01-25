package fr.eni.tp.filmotheque.bo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

	@NotBlank
	@Size(max = 250)
	private String titre;

	@Min(1900)
	private int annee;

	@Min(1)
	private int duree;

	@Size(min = 20, max = 250)
	private String synopsis;

	@NotNull
	private Participant realisateur;

	private List<Participant> acteurs = new ArrayList<>();

	@NotNull
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
