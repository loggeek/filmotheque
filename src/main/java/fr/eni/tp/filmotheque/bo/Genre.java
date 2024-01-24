package fr.eni.tp.filmotheque.bo;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Component
@EqualsAndHashCode(of = "id")
public class Genre implements Serializable
{
	private long id;
	private String titre;

	public Genre()
	{
	}

	public Genre(String titre)
	{
		this.titre = titre;
	}

	public Genre(long id, String titre)
	{
		this.id = id;
		this.titre = titre;
	}
}
