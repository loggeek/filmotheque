package fr.eni.tp.filmotheque.dal.impl;

import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.dal.GenreDAO;
import fr.eni.tp.filmotheque.dal.rowmapper.GenreRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GenreDAOImpl implements GenreDAO
{
	@Autowired GenreRowMapper rowMapper;
	@Autowired JdbcTemplate jdbc;

	@Override
	public Genre read(int id)
	{
		String sql = "SELECT * FROM genre WHERE id = ?";

		return jdbc.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<Genre> readAll()
	{
		String sql = "SELECT * FROM genre";

		return jdbc.query(sql, rowMapper);
	}
}
