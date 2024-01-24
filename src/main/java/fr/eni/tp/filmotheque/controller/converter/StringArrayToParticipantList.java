package fr.eni.tp.filmotheque.controller.converter;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Participant;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class StringArrayToParticipantList implements Converter<String[], List<Participant>>
{
	private final FilmService filmService;

	@Autowired
	public StringArrayToParticipantList(FilmService filmService)
	{
		this.filmService = filmService;
	}

	@Override
	public List<Participant> convert(@NonNull String[] from)
	{
		List<Participant> participants = new ArrayList<>();

		for (String participant : from)
		{
			String[] champs = participant.split(" ");
			String prenom = champs[0];
			String nom = champs[1];

			participants.add(filmService.consulterParticipants()
				.stream()
				.filter(p -> p.getPrenom().equals(prenom) && p.getNom().equals(nom))
				.findFirst()
				.orElseThrow());
		}

		return participants;
	}
}
