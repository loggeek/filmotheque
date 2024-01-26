package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Film;

import java.util.List;


public interface FilmDAO
{
	void create(Film film);
	Film read(int id);
	List<Film> readAll();
	String readTitre(int id);
}
