package fr.eni.tp.filmotheque.bo;

import lombok.*;
import org.springframework.stereotype.Component;


@Data
@Component
@EqualsAndHashCode(of = "id")
public abstract class Personne
{
	private long id;
	private String nom;
	private String prenom;

	public Personne()
	{
	}

	public Personne(String nom, String prenom)
	{
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(long id, String nom, String prenom)
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
}