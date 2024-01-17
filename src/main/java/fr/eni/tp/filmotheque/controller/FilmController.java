package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class FilmController
{
	private FilmService filmService;

	@Autowired
	public FilmController(FilmService filmService)
	{
		this.filmService = filmService;
	}

	public void afficherUnFilm(long id)
	{
		System.out.println(filmService.consulterFilmParId(id));
	}

	public void afficherFilms()
	{
		filmService.consulterFilms().forEach(System.out::println);
	}
}
