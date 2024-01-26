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
	@Autowired FilmService filmService;

	@GetMapping("/{id}")
	public String afficherUnAvis(@PathVariable int id, Model model)
	{
		if (! model.containsAttribute("s_membre")) {
			return "redirect:/films";
		}

		model.addAttribute("film", filmService.consulterFilmParId(id));
		return "view-create-avis";
	}

	@PostMapping("/{id}")
	public String creerUnAvis(@PathVariable int id, @RequestParam int note, @RequestParam String commentaire, Model model)
	{
		if (! model.containsAttribute("s_membre")) {
			return "redirect:/films";
		}

		filmService.publierAvis(
			Avis.builder()
				.note(note)
				.commentaire(commentaire)
				.membre((Membre) model.getAttribute("s_membre"))
				.build(),
			id
		);

		return "redirect:/films/" + id;
	}
}
