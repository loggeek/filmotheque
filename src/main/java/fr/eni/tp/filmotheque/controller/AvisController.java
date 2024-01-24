package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/avis")
@SessionAttributes({"s_membre"})
public class AvisController
{
	private final FilmService filmService;

	@Autowired
	public AvisController(FilmService filmService)
	{
		this.filmService = filmService;
	}

	@GetMapping("/{id}")
	public String afficherUnAvis(@PathVariable long id, Model model)
	{
		if (! model.containsAttribute("s_membre")) {
			return "redirect:/films";
		}

		model.addAttribute("film", filmService.consulterFilmParId(id));
		return "view-create-avis";
	}

	@PostMapping("/{id}")
	public String creerUnAvis(@PathVariable long id, @RequestParam int note, @RequestParam String commentaire, Model model)
	{
		if (! model.containsAttribute("s_membre")) {
			return "redirect:/films";
		}

		filmService.publierAvis(
			new Avis(note, commentaire, (Membre) model.getAttribute("s_membre")),
			id
		);

		return "redirect:/films/" + id;
	}
}
