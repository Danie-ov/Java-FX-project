package olympics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Olympic {

	private final int startDate = 2020;
	private final int endDate = 2021;
	private ArrayList<PersonalCompetition> allPersonalsCompetition;
	private ArrayList<TeamCompetition> allTeamsCompetition;
	private String name;
	
	public Olympic(String name) {
		allPersonalsCompetition = new ArrayList<PersonalCompetition>();
		allTeamsCompetition = new ArrayList<TeamCompetition>();
		this.name = name;
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

	public int getStartDate() {
		return startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public ArrayList<PersonalCompetition> getAllPersonalsCompetition() {
		return allPersonalsCompetition;
	}

	public ArrayList<TeamCompetition> getAllTeamsCompetition() {
		return allTeamsCompetition;
	}

	@Override
	public String toString() {
		return "olympic [startDate=" + startDate + ", endDate=" + endDate + ", allPersonalsCompetition="
				+ allPersonalsCompetition + ", allTeamsCompetition=" + allTeamsCompetition + "]";
	}
	
	
	
	
}
