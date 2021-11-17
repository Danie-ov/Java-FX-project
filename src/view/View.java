package view;
//view --> controller (fire)
//controller --> model (get)
//model --> controller (from model)
//controller --> view (set)

import java.util.Vector;
import javax.swing.JOptionPane;
import Controller.OlympicController;
import Listener.OlympicModelEventListener;
import Listener.OlympicUIEventListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import olympics.Country;
import olympics.OlympicManager;
import olympics.PersonalCompetition;
import olympics.Referee;
import olympics.SportType;
import olympics.Stadium;

public class View implements OlympicViewable {

	private Vector<OlympicUIEventListener> allListeners = new Vector<OlympicUIEventListener>();
	//private Vector<OlympicManager> allListeners = new Vector<OlympicManager>();
	ComboBox<Country> cmbCountries;
	ComboBox<Stadium> cmbStadiums;
	ComboBox<SportType> cmbSportTypes;
	ComboBox<Referee> cmbReferees;

	
	Button btnMenuCreateOlympic;
	Button btnMenuCompetitionType;
	Button btnMenuCountryList;
	Button btnMenuStadiumList;
	Button btnMenuRefereeList;
	Button btnMenuAthletesList;
	Button btnMenuStartOlympic;
	Button btnAddComp;
	Button btnAddCountry;
	Button btnSetStadium;
	Button btnAddReferee;
	Button btnAddAthlet;
	
	Label lblOlympicName;
	Label lblStartOlympic;
	Label lblEndOlympic;
	Label lblAddCompetition;
	Label lblAddCountry;
	Label lblStadiumName;
	Label lblStadiumLocation;
	Label lblNumOfSeats;
	Label lblRefereeName;
	Label lblRefereeCountry;
	Label lblRefereeList;
	Label lblAthletName;
	Label lblAthletCountry;
	Label lblAthletesList;
	
	TextField tfOlympicName;
	TextField tfStartOlympic;
	TextField tfEndOlympic;
	TextField tfAddCompetition;
	TextField tfAddCountry;
	TextField tfStadiumName;
	TextField tfStadiumLocation;
	TextField tfStadiumNumOfSeats;
	TextField tfRefereeName;
	TextField tfRefereeCountry;
	TextField tfAthletName;
	TextField tfAthletCountry;
	
	Button btnSetOlympic;
	public View(Stage theStage) {
		theStage.setTitle("Welcome to olympics! ");
		GridPane gpRoot = new GridPane();
		gpRoot.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		gpRoot.setPrefHeight(200);
		gpRoot.setPrefWidth(200);
		gpRoot.setPadding(new Insets(10));
		gpRoot.setAlignment(Pos.TOP_LEFT);
		gpRoot.setHgap(10);
		gpRoot.setVgap(10);
		
		cmbSportTypes = new ComboBox<SportType>();
		cmbReferees = new ComboBox<Referee>() ;

		
				
		cmbSportTypes.getItems().addAll(SportType.running, SportType.jumping , SportType.runningAndJumping);
		cmbCountries = new ComboBox<Country>();
		
		btnMenuCreateOlympic = new Button("Create new olympic"); 
		GridPane.setRowIndex(btnMenuCreateOlympic, 0);
		GridPane.getColumnIndex(btnMenuCreateOlympic);
		
		btnSetOlympic = new Button("Set data");

		
		btnMenuCreateOlympic.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {	
				setMenu(gpRoot);
				lblOlympicName = new Label("Olympic name:");
				GridPane.setConstraints(lblOlympicName, 5, 1);
				//
				tfOlympicName = new TextField();
				GridPane.setConstraints(tfOlympicName, 6, 1);
				//
				lblStartOlympic = new Label("Start at:");
				GridPane.setConstraints(lblStartOlympic, 5, 2);
				//
				tfStartOlympic = new TextField();
				GridPane.setConstraints(tfStartOlympic, 6, 2);
				//
				lblEndOlympic = new Label("End at:");
				GridPane.setConstraints(lblEndOlympic, 5, 3);
				//
				tfEndOlympic = new TextField();
				GridPane.setConstraints(tfEndOlympic, 6, 3);
				//
//				btnSetOlympic = new Button("Set data");
				GridPane.setConstraints(btnSetOlympic, 9, 2);
				//
				gpRoot.getChildren().addAll(lblOlympicName, tfOlympicName, lblStartOlympic, tfStartOlympic, lblEndOlympic
						,tfEndOlympic, btnSetOlympic);
			}
		});
		
		btnSetOlympic.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ex) {	
				String name = tfOlympicName.getText();
				String startDate = tfStartOlympic.getText();
				String endDate = tfEndOlympic.getText(); 
				for(OlympicUIEventListener l : allListeners) {
					l.viewFireOlympicAdded(name, startDate, endDate);
					
				}
			}
		});
		
		btnAddComp = new Button("Add Competition");
		btnMenuCompetitionType = new Button("Competitions types");
		GridPane.setRowIndex(btnMenuCompetitionType, 1);
		GridPane.getColumnIndex(btnMenuCompetitionType);
		
		btnMenuCompetitionType.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblAddCompetition = new Label("Add competition:");
				GridPane.setConstraints(lblAddCompetition, 5, 2);
				//
				tfAddCompetition = new TextField();
				GridPane.setConstraints(tfAddCompetition, 6, 2);
				//
				GridPane.setConstraints(btnAddComp, 7, 2);
				//
				cmbSportTypes.setPromptText("Types");
				GridPane.setConstraints(cmbSportTypes, 6, 3);
				//
				gpRoot.getChildren().addAll(lblAddCompetition, tfAddCompetition, btnAddComp, cmbSportTypes);	
			}
		});
		
		btnAddComp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String compatitionName = tfAddCompetition.getText();
				for(OlympicUIEventListener l : allListeners) {
//					l.viewFireNewCompatitonWasAdd(compatitionName);
				}
					
			}
		});
		
		btnMenuCountryList = new Button("Country list"); 
		btnAddCountry = new Button("Add Country");

		GridPane.setRowIndex(btnMenuCountryList, 2);
		GridPane.getColumnIndex(btnMenuCountryList);
		
		btnMenuCountryList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblAddCountry = new Label("Add country:");
				GridPane.setConstraints(lblAddCountry, 5, 2);
				//
				tfAddCountry = new TextField();
				GridPane.setConstraints(tfAddCountry, 6, 2);
				//
				GridPane.setConstraints(btnAddCountry, 7, 2);
				//
				cmbCountries.setPromptText("Countries");
				GridPane.setConstraints(cmbCountries, 6, 3);
				//
				gpRoot.getChildren().addAll(lblAddCountry, tfAddCountry, btnAddCountry, cmbCountries);	
			}
		});
		
		btnAddCountry.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for(OlympicUIEventListener l : allListeners) {
					l.viewFireNewCountryWasAdd(tfAddCountry.getText());
				}
			}	
		});
		
		btnMenuStadiumList = new Button("Stadium list");
		btnSetStadium = new Button("Add Stadium");


		GridPane.setRowIndex(btnMenuStadiumList, 3);
		GridPane.getColumnIndex(btnMenuStadiumList);
		
		tfStadiumName = new TextField();
		tfStadiumLocation = new TextField();
		tfStadiumNumOfSeats = new TextField();

		cmbStadiums = new ComboBox<Stadium>();

		
		btnMenuStadiumList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblStadiumName = new Label("Stadium name:");
				GridPane.setConstraints(lblStadiumName, 5, 1);
				//
				GridPane.setConstraints(tfStadiumName, 6, 1);
				//
				lblStadiumLocation = new Label("Stadium location:");
				GridPane.setConstraints(lblStadiumLocation, 5, 2);
				//
				GridPane.setConstraints(tfStadiumLocation, 6, 2);
				//
				lblNumOfSeats = new Label("Number of seats:");
				GridPane.setConstraints(lblNumOfSeats, 5, 3);
				//
				GridPane.setConstraints(tfStadiumNumOfSeats, 6, 3);
				//
				GridPane.setConstraints(btnSetStadium, 9, 2);
				//
				
				gpRoot.getChildren().addAll(lblStadiumName, tfStadiumName, lblStadiumLocation, tfStadiumLocation, 
						lblNumOfSeats,tfStadiumNumOfSeats, btnSetStadium);
			}
		});
		
		btnSetStadium.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for(OlympicUIEventListener l : allListeners) {
					l.viewFireNewStadiumWasAdd(tfStadiumName.getText() ,tfStadiumLocation.getText()
							, Integer.parseInt(tfStadiumNumOfSeats.getText()));
				}

			}
		});

		
		
		btnMenuRefereeList = new Button("Referee list"); 
		GridPane.setRowIndex(btnMenuRefereeList, 4);
		GridPane.getColumnIndex(btnMenuRefereeList);
		

		
		btnMenuRefereeList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblRefereeName = new Label("Referee name:");
				GridPane.setConstraints(lblRefereeName, 5, 1);
				//
				GridPane.setConstraints(tfRefereeName, 6, 1);
				//
				lblRefereeCountry = new Label("Referee country:");
				GridPane.setConstraints(lblRefereeCountry, 5, 2);
				//
				GridPane.setConstraints(tfRefereeCountry, 6, 2);
				//
				lblRefereeList = new Label("List of referees:");
				GridPane.setConstraints(lblRefereeList, 5, 3);
				//
				GridPane.setConstraints(btnAddReferee, 9, 2);
				//
				cmbSportTypes.setPromptText("Types");
				GridPane.setConstraints(cmbSportTypes, 6, 3);
				//TextArea txStadiumDetails = new TextArea();
				//GridPane.setConstraints(txStadiumDetails, 6, 5);
				gpRoot.getChildren().addAll(lblRefereeName, tfRefereeName, lblRefereeCountry, tfRefereeCountry, 
						lblRefereeList,cmbSportTypes, btnAddReferee); 
			}
		});
		
		tfRefereeName = new TextField();
		tfRefereeCountry = new TextField();
		btnAddReferee = new Button("Add referee");
		
		btnAddReferee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for(OlympicUIEventListener l : allListeners) {
	/*need to check what to do with the counter	*/
					
//					SportType sportType;
//					String tfCountry = tfRefereeCountry.getText();
//					for(SportType sp : SportType.values()) {
//						if(sp.name().equalsIgnoreCase(tfCountry))
//							sportType = sp;
//						
//					}
		
					l.viewFireNewRefereeWasCreate(tfRefereeName.getText() , new Country(tfRefereeCountry.getText()),cmbSportTypes.getSelectionModel().getSelectedItem());

//					l.viewFireNewRefereeWasCreate(tfRefereeName.getText() , tfRefereeCountry.getText() ,cmbSportTypes.getSelectionModel().getSelectedItem());
				}

			}
		});
		
		
		
		btnMenuAthletesList = new Button("Athletes list"); 
		GridPane.setRowIndex(btnMenuAthletesList, 5);
		GridPane.getColumnIndex(btnMenuAthletesList);
		
		btnMenuAthletesList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblAthletName = new Label("Athlet name:");
				GridPane.setConstraints(lblAthletName, 5, 1);
				//
				tfAthletName = new TextField();
				GridPane.setConstraints(tfAthletName, 6, 1);
				//
				lblAthletCountry = new Label("Athlet country:");
				GridPane.setConstraints(lblAthletCountry, 5, 2);
				//
				tfAthletCountry = new TextField();
				GridPane.setConstraints(tfAthletCountry, 6, 2);
				//
				lblAthletesList = new Label("List of Athletes:");
				GridPane.setConstraints(lblAthletesList, 5, 3);
				//
				btnAddAthlet = new Button("Add Athlet");
				GridPane.setConstraints(btnAddAthlet, 9, 2);
				//
				cmbSportTypes.setPromptText("Types");
				GridPane.setConstraints(cmbSportTypes, 6, 3);
				//TextArea txStadiumDetails = new TextAfireNewRefereeWasCreaterea();
				//GridPane.setConstraints(txStadiumDetails, 6, 5);
				gpRoot.getChildren().addAll(lblAthletName, tfAthletName, lblAthletCountry, tfAthletCountry, 
						lblAthletesList,cmbSportTypes, btnAddAthlet); 
			}
		});
		
		btnMenuStartOlympic = new Button("Start Olympic games!"); 
		GridPane.setRowIndex(btnMenuStartOlympic, 6);
		GridPane.getColumnIndex(btnMenuStartOlympic);

		setMenu(gpRoot);
		
		theStage.setScene(new Scene(gpRoot, 650, 600));
		theStage.show();
		
	}
	private void setMenu(GridPane gpRoot) {
		gpRoot.getChildren().clear();
		gpRoot.getChildren().addAll(btnMenuCreateOlympic, btnMenuCompetitionType, btnMenuCountryList, btnMenuStadiumList,
				btnMenuRefereeList, btnMenuAthletesList, btnMenuStartOlympic);
		
	}
	@Override
	public void registerListener(OlympicController oc) {
		Boolean res = allListeners.add(oc);	
		System.out.println(res);
	}
	@Override
	public void sendNewOlympicIsCreated() {
		JOptionPane.showMessageDialog(null, "Olympic " + tfOlympicName.getText() + " was create! ");
		
	}
	@Override
	public void setNewCompatition(SportType compatitionName) {
		cmbSportTypes.getItems().add(compatitionName);
		JOptionPane.showMessageDialog(null, "New compatition (" + compatitionName + " ) was create! ");

		
	}
	@Override
	public void setNewCountry(Country countryName) {
		cmbCountries.getItems().add(countryName);
		tfAddCountry.clear();
		JOptionPane.showMessageDialog(null, "New country (" + countryName + " ) was create! ");

		
	}
	@Override
	public void setNewStadium(Stadium stadium) {
		cmbStadiums.getItems().add(stadium);
		tfStadiumName.clear();
		tfStadiumLocation.clear();
		tfStadiumNumOfSeats.clear();
		JOptionPane.showMessageDialog(null, "New stadium (" + stadium + " ) was create! ");

		
	}
	@Override
	public void setNewReferee(Referee referee) {
		cmbReferees.getItems().add(referee);
		tfRefereeCountry.clear();
		tfRefereeName.clear();
		cmbSportTypes.getSelectionModel().clearSelection();
		JOptionPane.showMessageDialog(null, "New Referee (" + referee + " ) was create! ");

	}

	
	
}
