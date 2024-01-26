package fr.eni.tp.filmotheque.bll;


import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;

import java.util.List;


public interface FilmService
{
	List<Film> consulterFilms();
	Film consulterFilmParId(int id);
	List<Genre> consulterGenres();
	Genre consulterGenreParId(int id);
	List<Participant> consulterParticipants();
	Participant consulterParticipantParId(int id);
	void creerFilm(Film film);
	String consulterTitreFilm(int id);
	void publierAvis(Avis avis, int idFilm);
	List<Avis> consulterAvis(int idFilm);
}
