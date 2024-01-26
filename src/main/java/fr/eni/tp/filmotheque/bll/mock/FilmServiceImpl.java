package fr.eni.tp.filmotheque.bll.mock;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;
import fr.eni.tp.filmotheque.dal.AvisDAO;
import fr.eni.tp.filmotheque.dal.FilmDAO;
import fr.eni.tp.filmotheque.dal.GenreDAO;
import fr.eni.tp.filmotheque.dal.ParticipantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmServiceImpl implements FilmService
{
	@Autowired AvisDAO avisDAO;
	@Autowired FilmDAO filmDAO;
	@Autowired GenreDAO genreDAO;
	@Autowired ParticipantDAO participantDAO;

	@Override
	public List<Film> consulterFilms()
	{
		return filmDAO.readAll();
	}

	@Override
	public Film consulterFilmParId(int id)
	{
		return filmDAO.read(id);
	}

	@Override
	public List<Genre> consulterGenres()
	{
		return genreDAO.readAll();
	}

	@Override
	public Genre consulterGenreParId(int id)
	{
		return genreDAO.read(id);
	}

	@Override
	public List<Participant> consulterParticipants()
	{
		return participantDAO.readAll();
	}

	@Override
	public Participant consulterParticipantParId(int id)
	{
		return participantDAO.read(id);
	}

	@Override
	public void creerFilm(Film film)
	{
		filmDAO.create(film);
	}

	@Override
	public String consulterTitreFilm(int id)
	{
		return filmDAO.read(id).getTitre();
	}

	@Override
	public void publierAvis(Avis avis, int idFilm)
	{
		avisDAO.create(avis, idFilm);
	}

	@Override
	public List<Avis> consulterAvis(int idFilm)
	{
		return avisDAO.readByFilm(idFilm);
	}
}
