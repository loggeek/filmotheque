package fr.eni.tp.filmotheque.bll.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.tp.filmotheque.bll.ContexteService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.tp.filmotheque.bo.Membre;

@Service
@Profile("dev")
public class ContexteServiceBouchon implements ContexteService
{
	// Liste des membres
	private static List<Membre> lstMembres;

	public ContexteServiceBouchon() {
		// initialisation de la liste
		lstMembres = new ArrayList<>();
		lstMembres.add(new Membre(1, "Baille", "Anne-Lise", "abaille", false));
		Membre admin = new Membre(2, "Gobin", "Stéphane", "sgobin", false);
		admin.setAdmin(true);
		lstMembres.add(admin);
		lstMembres.add(new Membre(3, "Trillard", "Julien", "jtrillard", false));
	}

	@Override
	public Membre charger(String pseudo) {
		return lstMembres
			.stream()
			.filter(item -> item.getPseudo().equals(pseudo == null ? "jtrillard" : pseudo))
			.findAny()
			.orElse(null);
	}

	@Override
	public List<Membre> getMembres()
	{
		return lstMembres;
	}
}
