package olympics;

public class Stadium {
	
	private String stadiumName;
	private String location;
	private int numberOfSeats;
	
	public Stadium(String stadiumName , String location , int numberOfSeats) {
		this.stadiumName = stadiumName;
		this.location = location;
		try {
			this.setNumberOfSeats(numberOfSeats);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void setNumberOfSeats(int numOfSeats) throws Exception {
		if(numOfSeats<0)
			throw new Exception("Invaliad seats number");
	}

}
