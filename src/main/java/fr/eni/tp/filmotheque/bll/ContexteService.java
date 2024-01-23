package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.Membre;

import java.util.List;


public interface ContexteService
{
	Membre charger(String pseudo);
	List<Membre> getMembres();
}
