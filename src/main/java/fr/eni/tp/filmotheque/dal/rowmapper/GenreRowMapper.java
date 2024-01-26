package fr.eni.tp.filmotheque.dal.rowmapper;

import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class GenreRowMapper implements RowMapper<Genre>
{
	@Override
	public Genre mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		return Genre.builder()
			.id(rs.getInt("id"))
			.titre(rs.getNString("titre"))
			.build();
	}
}
