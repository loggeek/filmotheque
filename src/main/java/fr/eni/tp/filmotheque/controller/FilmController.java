package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;


@Controller
@RequestMapping("/films")
@SessionAttributes({"s_genres", "s_membre"})
public class FilmController
{
	private final FilmService filmService;

	@Autowired
	public FilmController(FilmService filmService)
	{
		this.filmService = filmService;
	}

	@ModelAttribute("s_genres")
	public List<Genre> chargerGenres()
	{
		LoggerFactory.getLogger(getClass()).info("Chargement des genres en session");
		return filmService.consulterGenres();
	}

	@GetMapping("/new")
	public String creerFilm()
	{
		return "view-create-film";
	}

	@GetMapping("/{id}")
	public String afficherUnFilm(@PathVariable long id, Model model)
	{
		try {
			Film film = filmService.consulterFilmParId(id);
			model.addAttribute("film", film);
		}
		catch (NoSuchElementException e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return "view-film-detail";
	}

	@GetMapping
	public String afficherFilms(Model model)
	{
		List<Film> films = filmService.consulterFilms();
		model.addAttribute("films", films);

		return "view-films";
	}
}
