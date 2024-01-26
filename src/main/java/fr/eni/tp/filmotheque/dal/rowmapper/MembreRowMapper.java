package fr.eni.tp.filmotheque.dal.rowmapper;

import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MembreRowMapper implements RowMapper<Membre>
{
	@Override
	public Membre mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		return Membre.builder()
			.id(rs.getInt("id"))
			.nom(rs.getNString("nom"))
			.prenom(rs.getNString("prenom"))
			.pseudo(rs.getNString("pseudo"))
			.motDePasse(rs.getNString("mdp"))
			.isAdmin(rs.getBoolean("is_admin"))
			.build();
	}
}
