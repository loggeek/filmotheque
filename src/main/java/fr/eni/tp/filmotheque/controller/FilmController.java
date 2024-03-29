package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Membre;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;


@Controller
@RequestMapping("/films")
@SessionAttributes({"s_genres", "s_membre"})
public class FilmController
{
	@Autowired FilmService filmService;

	@ModelAttribute("s_genres")
	public List<Genre> chargerGenres()
	{
		return filmService.consulterGenres();
	}

	@GetMapping("/new")
	public String creerFilm(Model model)
	{
		if (! model.containsAttribute("s_membre")) {
			return "redirect:/films";
		}

		if (! ((Membre) Objects.requireNonNull(model.getAttribute("s_membre"))).isAdmin()) {
			return "redirect:/films";
		}

		model.addAttribute("film", new Film());
		model.addAttribute("participants", filmService.consulterParticipants());

		return "view-create-film";
	}

	@PostMapping("/new")
	public String ajouterFilm(@Valid @ModelAttribute Film film, BindingResult bindingResult, Model model)
	{
		if (! model.containsAttribute("s_membre")) {
			return "redirect:/films";
		}
		if (! ((Membre) Objects.requireNonNull(model.getAttribute("s_membre"))).isAdmin()) {
			return "redirect:/films";
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("participants", filmService.consulterParticipants());

			return "view-create-film";
		}

		filmService.creerFilm(film);

		return "redirect:/films";
	}

	@GetMapping("/{id}")
	public String afficherUnFilm(@PathVariable int id, Model model)
	{
		try {
			Film film = filmService.consulterFilmParId(id);
			model.addAttribute("film", film);
		}
		catch (NoSuchElementException e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		List<Avis> avis = filmService.consulterAvis(id);
		if (! avis.isEmpty()) {
			model.addAttribute("avis", avis);
		}

		return "view-detail-film";
	}

	@GetMapping
	public String afficherFilms(Model model)
	{
		List<Film> films = filmService.consulterFilms();
		model.addAttribute("films", films);

		return "view-films";
	}
}
