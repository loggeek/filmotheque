package fr.eni.tp.filmotheque.bll;


import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;

import java.util.List;


public interface FilmService
{
	/**
	 * @return la liste des films
	 */
	List<Film> consulterFilms();

	/**
	 * @param id l'ID du film à consulter
	 * @return le film ayant l'ID indiqué
	 */
	Film consulterFilmParId(int id);

	/**
	 * @return la liste des genres
	 */
	List<Genre> consulterGenres();

	/**
	 * @param id l'ID du genre à consulter
	 * @return le genre ayant l'ID indiqué
	 */
	Genre consulterGenreParId(int id);

	/**
	 * @return la liste des participants
	 */
	List<Participant> consulterParticipants();

	/**
	 * @param id l'ID du participant à consulter
	 * @return le participant ayant l'ID indiqué
	 */
	Participant consulterParticipantParId(int id);

	/**
	 * Crée un film.
	 * @param film le film à créer
	 */
	void creerFilm(Film film);

	/**
	 * @param id l'ID du film à consulter
	 * @return le titre du film ayant l'ID indiqué
	 */
	String consulterTitreFilm(int id);

	/**
	 * Publie un avis
	 * @param avis l'avis à publier
	 * @param idFilm l'ID du film sur lequel porte l'avis
	 */
	void publierAvis(Avis avis, int idFilm);

	/**
	 * @param idFilm l'ID du film sur lesquels consulter les avis
	 * @return les avis portant sur le film ayant l'ID indiqué
	 */
	List<Avis> consulterAvis(int idFilm);
}
