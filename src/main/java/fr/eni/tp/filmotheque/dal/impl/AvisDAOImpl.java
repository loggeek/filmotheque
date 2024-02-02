package fr.eni.tp.filmotheque.dal.impl;

import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.dal.AvisDAO;
import fr.eni.tp.filmotheque.dal.rowmapper.AvisRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AvisDAOImpl implements AvisDAO
{
	@Autowired AvisRowMapper rowMapper;
	@Autowired JdbcTemplate jdbc;
	@Autowired NamedParameterJdbcTemplate namedjdbc;

	@Override
	public void create(Avis avis, int film)
	{
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "INSERT INTO avis(membre, film, note, commentaire) " +
			"VALUES(:membre, :film, :note, :commentaire)";

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		namedParameters.addValue("membre", avis.getMembre().getId());
		namedParameters.addValue("film", film);
		namedParameters.addValue("note", avis.getNote());
		namedParameters.addValue("commentaire", avis.getCommentaire());

		namedjdbc.update(sql, namedParameters, keyHolder);

		if (keyHolder.getKey() != null) {
			avis.setId(keyHolder.getKey().intValue());
		}
	}

	@Override
	public List<Avis> readByFilm(int film)
	{
		String sql = "SELECT * FROM avis WHERE film = ?";

		return jdbc.query(sql, rowMapper, film);
	}
}
