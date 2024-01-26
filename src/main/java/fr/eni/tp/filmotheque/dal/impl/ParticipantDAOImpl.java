package fr.eni.tp.filmotheque.dal.impl;

import fr.eni.tp.filmotheque.bo.Participant;
import fr.eni.tp.filmotheque.dal.ParticipantDAO;
import fr.eni.tp.filmotheque.dal.rowmapper.ParticipantRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParticipantDAOImpl implements ParticipantDAO
{
	@Autowired ParticipantRowMapper rowMapper;
	@Autowired JdbcTemplate jdbc;
	@Autowired NamedParameterJdbcTemplate namedjdbc;

	@Override
	public Participant read(int id)
	{
		String sql = "SELECT * FROM participant WHERE id = ?";

		return jdbc.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<Participant> readAll()
	{
		String sql = "SELECT * FROM participant";

		return jdbc.query(sql, rowMapper);
	}

	@Override
	public List<Participant> readActeurs(int film)
	{
		String sql = "SELECT * FROM participant " +
			"INNER JOIN acteur_film ON participant.id = acteur_film.acteur " +
			"WHERE film = ?";

		return jdbc.query(sql, rowMapper, film);
	}

	@Override
	public void createActeur(int participant, int film)
	{
		String sql = "INSERT INTO acteur_film(acteur, film) " +
			"VALUES(:acteur, :film)";

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		namedParameters.addValue("acteur", participant);
		namedParameters.addValue("film", film);

		namedjdbc.update(sql, namedParameters);
	}
}
