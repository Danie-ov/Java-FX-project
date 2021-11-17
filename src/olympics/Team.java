package olympics;

import java.util.ArrayList;
import java.util.Vector;

public class Team {

	private ArrayList<athlete> allSportsManOfTeam;
	private Vector<athlete> alls = new Vector<athlete>();
	private Country country;
	private int numOfMedals;
	
	public Team(Country country, Vector<athlete> alls) {
		allSportsManOfTeam = new ArrayList<athlete>();
		this.country = country;
		numOfMedals = 0;
	}
	
	public void addSportManToTeam(athlete sportman) {
		alls.add(sportman);
//		allSportsManOfTeam.add(sportman);
	}
	
	public void addMedals(int numOfMedals) {
		this.numOfMedals += numOfMedals;
		country.addMedals(numOfMedals);
	}
	//getters

	public ArrayList<athlete> allSportsManOfTeam() {
		return allSportsManOfTeam;
	}

	public Country getCountry() {
		return country;
	}

	public int getNumOfMedals() {
		return numOfMedals;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < allSportsManOfTeam.size(); i++) {
			sb.append("Team " + (i+1) + "--> ");
			sb.append("from: " + country + " has: " + numOfMedals);
			sb.append(allSportsManOfTeam.get(i).toString());
		}
		return sb.toString();
	}
	
	
	
}
