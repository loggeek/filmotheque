package fr.eni.tp.filmotheque.dal;

import fr.eni.tp.filmotheque.bo.Participant;

import java.util.List;


public interface ParticipantDAO
{
	Participant read(int id);
	List<Participant> readAll();
	List<Participant> readActeurs(int film);
	void createActeur(int participant, int film);
}
