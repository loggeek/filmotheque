package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.Membre;

import java.util.List;


public interface ContexteService
{
	/**
	 * @param pseudo le pseudo du membre à charger
	 * @return le membre ayant le pseudo indiqué
	 */
	Membre charger(String pseudo);

	/**
	 * @deprecated <strong>AVERTISSEMENT</strong>: Les hashes des mots de passe sont exposés par cette fonction.
	 * Elle est par conséquent dépreciée.
	 * @return la liste des membres enregistrés
	 */
	@Deprecated
	List<Membre> getMembres();
}
