package fr.eni.tp.filmotheque.bll;


import java.util.List;


// NOTE: for future use
public interface Service<BO>
{
	List<BO> consulterTous();
	BO consulterParID(long id);
	void ajouter(BO bo);
}
