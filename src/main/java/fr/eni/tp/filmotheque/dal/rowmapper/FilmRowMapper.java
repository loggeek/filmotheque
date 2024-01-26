package fr.eni.tp.filmotheque.dal.rowmapper;

import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.dal.AvisDAO;
import fr.eni.tp.filmotheque.dal.GenreDAO;
import fr.eni.tp.filmotheque.dal.ParticipantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class FilmRowMapper implements RowMapper<Film>
{
	@Autowired AvisDAO avisDAO;
	@Autowired GenreDAO genreDAO;
	@Autowired ParticipantDAO participantDAO;

	@Override
	public Film mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		int id = rs.getInt("id");

		return Film.builder()
			.id(id)
			.titre(rs.getNString("titre"))
			.annee(rs.getInt("annee"))
			.duree(rs.getInt("duree"))
			.synopsis(rs.getString("synopsis"))
			.realisateur(participantDAO.read(rs.getInt("realisateur")))
			.acteurs(participantDAO.readActeurs(id))
			.genre(genreDAO.read(rs.getInt("genre")))
			.avis(avisDAO.readByFilm(id))
			.build();
	}
}
