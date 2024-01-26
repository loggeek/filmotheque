package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Avis;

import java.util.List;


public interface AvisDAO
{
	void create(Avis avis, int film);
	List<Avis> readByFilm(int film);
}
