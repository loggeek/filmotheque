package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/films")
public class FilmController
{
	private FilmService filmService;

	@Autowired
	public FilmController(FilmService filmService)
	{
		this.filmService = filmService;
	}

	@GetMapping("/{id}")
	public String afficherUnFilm(@PathVariable long id, Model model)
	{
		Film film = filmService.consulterFilmParId(id);
		model.addAttribute("film", film);

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
