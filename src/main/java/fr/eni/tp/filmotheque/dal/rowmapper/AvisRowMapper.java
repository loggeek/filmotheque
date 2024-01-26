package fr.eni.tp.filmotheque.dal.rowmapper;

import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.dal.MembreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AvisRowMapper implements RowMapper<Avis>
{
	@Autowired MembreDAO membreDAO;

	@Override
	public Avis mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		return Avis.builder()
			.id(rs.getInt("id"))
			.membre(membreDAO.read(rs.getInt("membre")))
			.commentaire(rs.getString("commentaire"))
			.note(rs.getInt("note"))
			.build();
	}
}
