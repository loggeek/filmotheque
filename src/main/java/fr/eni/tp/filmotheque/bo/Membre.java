package fr.eni.tp.filmotheque.bo;

import lombok.*;
import org.springframework.stereotype.Component;


@Data
@Component
@EqualsAndHashCode(callSuper = true)
public class Membre extends Personne
{
	private String pseudo;
	@ToString.Exclude
	private String motDePasse;
	private boolean admin;

	public Membre()
	{
	}

	public Membre(String nom, String prenom, String pseudo, boolean admin)
	{
		super(nom, prenom);
		this.pseudo = pseudo;
		this.admin = admin;
	}

	public Membre(long id, String nom, String prenom, String pseudo, boolean admin)
	{
		super(id, nom, prenom);
		this.pseudo = pseudo;
		this.admin = admin;
	}

	public Membre(String pseudo, boolean admin)
	{
		this.pseudo = pseudo;
		this.admin = admin;
	}
}
