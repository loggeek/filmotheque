package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.ContexteService;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;


@Controller
@RequestMapping("/ctx")
@SessionAttributes({"s_membre"})
public class ContexteController
{
	ContexteService contexteService;

	@Autowired
	public ContexteController(ContexteService contexteService)
	{
		this.contexteService = contexteService;
	}

	@GetMapping
	public String login(Model model)
	{
		List<Membre> membres = contexteService.getMembres();
		model.addAttribute("membres", membres);

		return "view-contexte";
	}

	@GetMapping("/login/{pseudo}")
	public String login(Model model, @PathVariable String pseudo)
	{
		model.addAttribute("s_membre", contexteService.charger(pseudo));
		return "redirect:/films";
	}

	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		System.out.println("Déconnexion");
		sessionStatus.setComplete();
		return "redirect:/films";
	}
}
