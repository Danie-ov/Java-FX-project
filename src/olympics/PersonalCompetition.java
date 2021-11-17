package olympics;

import java.util.ArrayList;
import java.util.Collections;

import olympics.Competition.CompetitionType;

public class PersonalCompetition extends Competition {

	private ArrayList<athlete> allSportMan;
	private String refereeSportType;
	
	
	public PersonalCompetition(String refereeName, Country refereeCountry, String stadiumName, String stadiumLocation,
			 String refereeSportType, CompetitionType cmpType) {
		super(refereeName, refereeCountry, stadiumName, stadiumLocation, cmpType);
		allSportMan = new ArrayList<athlete>();
		this.refereeSportType = refereeSportType;
	}
	
	public void addSportMan(athlete sportMan) {
		allSportMan.add(sportMan);
	}
	
	public void compete() {
		Collections.shuffle(allSportMan);
		allSportMan.get(0).addMedalsToSportMan(3);//first rank
		allSportMan.get(1).addMedalsToSportMan(2);//second rank
		allSportMan.get(2).addMedalsToSportMan(1);//third rank
	}
	//getters

	public ArrayList<athlete> getAllSportMan() {
		return allSportMan;
	}

	public String getRefereeSportType() {
		return refereeSportType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < allSportMan.size(); i++) {
			sb.append("SportMan " + (i+1) + " --> \n" );
			  sb.append(allSportMan.get(i).toString() + "\n");
		}
		return super.toString() + sb.toString();
	}
	
	
	
	
	
}
