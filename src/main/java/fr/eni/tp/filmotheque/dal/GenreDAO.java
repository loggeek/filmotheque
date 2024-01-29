package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Genre;

import java.util.List;


public interface GenreDAO
{
	Genre read(int id);
	List<Genre> readAll();
}
