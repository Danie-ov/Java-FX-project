package view;

import Controller.OlympicController;
import olympics.Country;
import olympics.Referee;
import olympics.SportType;
import olympics.Stadium;

public interface OlympicViewable {

	void registerListener(OlympicController oc);
	void sendNewOlympicIsCreated();
	void setNewCompatition(SportType sportType);
	void setNewCountry(Country countryName);
	void setNewStadium(Stadium stadium);
	void setNewReferee(Referee referee);
	

}
