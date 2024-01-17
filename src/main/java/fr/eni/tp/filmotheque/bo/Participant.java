package fr.eni.tp.filmotheque.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;


@Data
@Component
@EqualsAndHashCode(callSuper = true)
public class Participant extends Personne
{
	public Participant()
	{
	}

	public Participant(String nom, String prenom)
	{
		super(nom, prenom);
	}

	public Participant(long id, String nom, String prenom)
	{
		super(id, nom, prenom);
	}
}
