package Controller;

import Listener.OlympicModelEventListener;
import Listener.OlympicUIEventListener;
import javafx.scene.control.TextField;
import olympics.Country;
import olympics.OlympicManager;
import olympics.Referee;
import olympics.SportType;
import olympics.Stadium;
import view.OlympicViewable;

public class OlympicController implements OlympicModelEventListener, OlympicUIEventListener{

	private OlympicManager theModel;
	private OlympicViewable theView;
	
	public OlympicController(OlympicManager m, OlympicViewable v) {
		theModel = m;
		theView = v;
		
		theModel.registerListener(this);
		theView.registerListener(this);
	}

	@Override
	public void viewFireOlympicAdded(String name, String startDate, String endDate) {
		theModel.createNewOlympic(name, startDate, endDate);
		theView.sendNewOlympicIsCreated();
	}

	@Override
	public void viewFireNewCompatitonWasAdd(SportType sportType) {
		theView.setNewCompatition(sportType);
	}

	@Override
	public void viewFireNewCountryWasAdd(String countryName) {
		theModel.createNewCountry(countryName);
		
	}

	@Override
	public void fireNewCountryWasCreate(Country country) {
		theView.setNewCountry(country);
		
	}

	@Override
	public void viewFireNewStadiumWasAdd(String name, String location, int numOfSeat) {
		theModel.createNewStadium(name , location , numOfSeat);
		
	}

	@Override
	public void fireNewStadiumWasCreate(Stadium stadium) {
		theView.setNewStadium(stadium);
		
	}

	@Override
	public void viewFireNewRefereeWasCreate(String name, Country country, SportType sportType) {
		theModel.createNewReferee(name , country , sportType);
		
	}

	@Override
	public void fireNewRefereeWasCreate(Referee referee) {
		theView.setNewReferee( referee);
		
	}


}
