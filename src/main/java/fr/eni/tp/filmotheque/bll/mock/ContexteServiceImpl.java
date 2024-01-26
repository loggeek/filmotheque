package fr.eni.tp.filmotheque.bll.mock;

import fr.eni.tp.filmotheque.bll.ContexteService;
import fr.eni.tp.filmotheque.bo.Membre;
import fr.eni.tp.filmotheque.dal.MembreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContexteServiceImpl implements ContexteService
{
	@Autowired MembreDAO membreDAO;

	@Override
	public Membre charger(String pseudo)
	{
		return membreDAO.readByPseudo(pseudo);
	}

	@Override
	public List<Membre> getMembres()
	{
		return membreDAO.readAll();
	}
}
