package olympics;

import java.util.ArrayList;
import java.util.Collections;

import olympics.Competition.CompetitionType;

public class TeamCompetition extends Competition {

	private ArrayList<Team> allTeams;
	private String refereeSportType;
	
	
	public TeamCompetition(String refereeName, Country refereeCountry, String stadiumName, String stadiumLocation,
			String refereeSportType, CompetitionType cmpType) {
		super(refereeName, refereeCountry, stadiumName, stadiumLocation, cmpType);
		allTeams = new ArrayList<Team>();
		this.refereeSportType = refereeSportType;
	}
	
	public void addTeam(Team team) {
		allTeams.add(team);
	}
	
	public void teamCompete() {
		Collections.shuffle(allTeams);
		allTeams.get(0).addMedals(3);//first rank
		allTeams.get(1).addMedals(2);//second rank
		allTeams.get(2).addMedals(1);//third rank
	}
	//getters

	public ArrayList<Team> getAllTeams() {
		return allTeams;
	}

	public String getRefereeSportType() {
		return refereeSportType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < allTeams.size(); i++) {
			sb.append("Team " + (i+1) + " --> \n" );
			  sb.append(allTeams.get(i).toString() + "\n");
		}
		return super.toString() + sb.toString();
	}
	
	
	
	
}
