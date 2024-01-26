package fr.eni.tp.filmotheque.controller.converter;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToGenre implements Converter<String, Genre>
{
	@Autowired FilmService filmService;

	@Override
	public Genre convert(String source)
	{
		return filmService.consulterGenres()
			.stream()
			.filter(g -> g.getTitre().equals(source))
			.findFirst()
			.orElseThrow();
	}
}
