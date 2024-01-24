package fr.eni.tp.filmotheque.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Component
@EqualsAndHashCode(of = "id")
public class Avis implements Serializable
{
	private long id;
	private int note;
	private String commentaire;
	private Membre membre;

	public Avis()
	{
	}

	public Avis(int note, String commentaire, Membre membre)
	{
		this.note = note;
		this.commentaire = commentaire;
		this.membre = membre;
	}

	public Avis(long id, int note, String commentaire, Membre membre)
	{
		this.id = id;
		this.note = note;
		this.commentaire = commentaire;
		this.membre = membre;
	}
}
