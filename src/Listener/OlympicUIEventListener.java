package Listener;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import olympics.Country;
import olympics.SportType;

public interface OlympicUIEventListener {

	void viewFireOlympicAdded(String name, String startDate, String endDate);

	void viewFireNewCompatitonWasAdd(SportType sportType);

	void viewFireNewCountryWasAdd(String countryName);

	void viewFireNewStadiumWasAdd(String name, String location, int numOfSeat);

	void viewFireNewRefereeWasCreate(String name, Country country, SportType sportType);
	
}
