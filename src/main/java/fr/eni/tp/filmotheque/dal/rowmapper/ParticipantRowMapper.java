package fr.eni.tp.filmotheque.dal.rowmapper;

import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ParticipantRowMapper implements RowMapper<Participant>
{
	@Override
	public Participant mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		return Participant.builder()
			.id(rs.getInt("id"))
			.nom(rs.getNString("nom"))
			.prenom(rs.getNString("prenom"))
			.build();
	}
}
