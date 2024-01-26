package fr.eni.tp.filmotheque.controller.converter;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Participant;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToParticipant implements Converter<String, Participant>
{
	@Autowired FilmService filmService;

	@Override
	public Participant convert(@NonNull String from)
	{
		String[] champs = from.split(" ");
		String prenom = champs[0];
		String nom = champs[1];

		return filmService.consulterParticipants()
			.stream()
			.filter(p -> p.getPrenom().equals(prenom) && p.getNom().equals(nom))
			.findFirst()
			.orElseThrow();
	}
}
