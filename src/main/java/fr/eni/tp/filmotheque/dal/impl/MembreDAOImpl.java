package fr.eni.tp.filmotheque.dal.impl;

import fr.eni.tp.filmotheque.bo.Membre;
import fr.eni.tp.filmotheque.dal.MembreDAO;
import fr.eni.tp.filmotheque.dal.rowmapper.MembreRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MembreDAOImpl implements MembreDAO
{
	@Autowired MembreRowMapper rowMapper;
	@Autowired JdbcTemplate jdbc;

	@Override
	public Membre read(int id)
	{
		String sql = "SELECT * FROM membre WHERE id = ?";

		return jdbc.queryForObject(sql, rowMapper, id);
	}

	@Override
	public Membre readByPseudo(String pseudo)
	{
		String sql = "SELECT * FROM membre WHERE pseudo = ?";

		return jdbc.queryForObject(sql, rowMapper, pseudo);
	}

	@Override
	public List<Membre> readAll()
	{
		String sql = "SELECT * FROM membre";

		return jdbc.query(sql, rowMapper);
	}
}
