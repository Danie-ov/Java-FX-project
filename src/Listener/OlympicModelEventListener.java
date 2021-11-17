package Listener;

import olympics.Country;
import olympics.Referee;
import olympics.Stadium;

public interface OlympicModelEventListener {

	void fireNewCountryWasCreate(Country country);

	void fireNewStadiumWasCreate(Stadium stadium);

	void fireNewRefereeWasCreate(Referee referee);


	
}
