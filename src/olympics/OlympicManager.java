package olympics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JOptionPane;

import Controller.OlympicController;
import Listener.OlympicModelEventListener;

public class OlympicManager {

	private Olympics olympic;
	private Vector<OlympicModelEventListener> allListeners;
	private ArrayList<PersonalCompetition> allPersonalsCompetition;
	private ArrayList<TeamCompetition> allTeamsCompetition;
	
	public OlympicManager() {
		allListeners = new Vector<OlympicModelEventListener>();
		allPersonalsCompetition = new ArrayList<PersonalCompetition>();
		allTeamsCompetition = new ArrayList<TeamCompetition>();
	}
	
	public void createNewOlympic(String name, String startDate, String endDate) {
		olympic = new Olympics(name, startDate, endDate);
	}
	
	public void registerListener(OlympicController oc) {
		allListeners.add(oc);
	}
	
	public void runOlympic() {
		for(PersonalCompetition p : allPersonalsCompetition) {
			p.compete();
			p.toString();
		}
		for(TeamCompetition p : allTeamsCompetition) {
			p.teamCompete();
			p.toString();
		}
	}
	//getters

	public ArrayList<PersonalCompetition> getAllPersonalsCompetition() {
		return allPersonalsCompetition;
	}

	public ArrayList<TeamCompetition> getAllTeamsCompetition() {
		return allTeamsCompetition;
	}

	public void createNewCountry(String countryName) {
		Country country = new Country(countryName);
		for(OlympicModelEventListener l : allListeners)
			l.fireNewCountryWasCreate(country);
		
	}

	public void createNewStadium(String name, String location, int numOfSeat) {
		Stadium stadium = new Stadium(name , location , numOfSeat);
		for(OlympicModelEventListener l : allListeners)
			l.fireNewStadiumWasCreate(stadium);
		
	}


	public void createNewReferee(String name, Country country, SportType sportType) {
		Referee referee = new Referee(name, country, sportType);
		for(OlympicModelEventListener l : allListeners)
			l.fireNewRefereeWasCreate(referee);

		
	}	
	
}
