package fr.eni.tp.filmotheque.dal.impl;

import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.dal.FilmDAO;
import fr.eni.tp.filmotheque.dal.rowmapper.FilmRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FilmDAOImpl implements FilmDAO
{
	@Autowired FilmRowMapper rowMapper;
	@Autowired JdbcTemplate jdbc;
	@Autowired NamedParameterJdbcTemplate namedjdbc;

	@Override
	public void create(Film film)
	{
		String sql = "INSERT INTO film(realisateur, genre, titre, annee, duree, synopsis) " +
				 "VALUES(:realisateur, :genre, :titre, :annee, :duree, :synopsis)";

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		namedParameters.addValue("realisateur", film.getRealisateur().getId());
		namedParameters.addValue("genre", film.getGenre().getId());
		namedParameters.addValue("titre", film.getTitre());
		namedParameters.addValue("annee", film.getAnnee());
		namedParameters.addValue("duree", film.getDuree());
		namedParameters.addValue("synopsis", film.getSynopsis());

		namedjdbc.update(sql, namedParameters);
	}

	@Override
	public Film read(int id)
	{
		String sql = "SELECT * FROM film WHERE id = ?";

		return jdbc.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<Film> readAll()
	{
		String sql = "SELECT * FROM film";

		return jdbc.query(sql, rowMapper);
	}

	@Override
	public String readTitre(int id)
	{
		String sql = "SELECT titre FROM film WHERE id = ?";

		return jdbc.queryForObject(sql, String.class, id);
	}
}
