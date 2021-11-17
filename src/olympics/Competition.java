package olympics;

public class Competition {
	public enum CompetitionType {running, jumping};

	protected String refereeName;
	protected Country refereeCountry;
	protected String stadiumName;
	protected String stadiumLocation;
	protected CompetitionType cmpType;
	protected final int NUM_OF_SEATS = 10000;
	
	public Competition(String refereeName, Country refereeCountry, String stadiumName, String stadiumLocation, CompetitionType cmpType) {
		this.refereeName = refereeName;
		this.refereeCountry = refereeCountry;
		this.stadiumName = stadiumName;
		this.stadiumLocation = stadiumLocation;
		this.cmpType = cmpType;
	}
	//getters

	public CompetitionType getCmpType() {
		return cmpType;
	}

	public String getRefereeName() {
		return refereeName;
	}

	public Country getRefereeCountry() {
		return refereeCountry;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public String getStadiumLocation() {
		return stadiumLocation;
	}

	public int getNUM_OF_SEATS() {
		return NUM_OF_SEATS;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("details competition are --> \n" );
		sb.append("refereeName: " + refereeName + ", from " + refereeCountry + ", the stadiumName: "
				+ stadiumName + ", in Location: " + stadiumLocation + ", competition type is: " + cmpType + " \n");
		return sb.toString();	
	}
}

	
	
	
	
	

