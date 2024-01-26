package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Membre;

import java.util.List;


public interface MembreDAO
{
	Membre read(int id);
	Membre readByPseudo(String pseudo);
	List<Membre> readAll();
}
