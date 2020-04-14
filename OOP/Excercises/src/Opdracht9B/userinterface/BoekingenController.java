package Opdracht9B.userinterface;

import Opdracht9B.model.Hotel;
import Opdracht9B.model.KamerType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoekingenController implements FocusListener{
    public Button bookButton;
    public Button resetButton;
    public Button cancelButton;

    public Label gegevensID;

    public TextField nameID;
    public TextField adressID;
    public DatePicker arrivaldDateID;
    public DatePicker departureDateID;
    public ComboBox<KamerType> roomTypeID = new ComboBox<>();

    private Hotel hotel = Hotel.getHotel();

    private String naam;
    private String adres;
    private KamerType kamerType;

    public BoekingenController() {
    }

    public void initialize() {
        roomTypeID.setItems(FXCollections.observableList(hotel.getKamerTypen()));
        arrivaldDateID.setValue(LocalDate.now());
        departureDateID.setValue(LocalDate.now());
    }

    public void createNewBoeking(ActionEvent actionEvent) throws Exception{
        LocalDate aankomst = arrivaldDateID.getValue();
        LocalDate vertrek = departureDateID.getValue();

        naam = nameID.getText();
        adres = adressID.getText();
        kamerType = roomTypeID.getValue();

        if(checkEverything()){
            try{
                hotel.voegBoekingToe(aankomst, vertrek, naam, adres, kamerType);
                backToOverzicht(actionEvent);
            }catch(Exception e){
                gegevensID.setText(e.getMessage());
            }
        }
    }

    @FXML private Label warningNaam;
    @FXML private Label warningAdres;
    @FXML private Label warningDatum;
    @FXML private Label warningKamer;

    private boolean checkEverything(){
        List<Label> warningLabels = List.of(warningNaam, warningAdres, warningDatum, warningDatum, warningKamer);
        ArrayList<Label> usedWarningLabels = new ArrayList<>();

        if(naam.isEmpty()){usedWarningLabels.add(warningNaam);}
        if(adres.isEmpty()){usedWarningLabels.add(warningAdres);}
        if(arrivaldDateID.getValue().compareTo(departureDateID.getValue()) >= 0){
            usedWarningLabels.add(warningDatum);
        }
        if(kamerType == null){usedWarningLabels.add(warningKamer);}

        if(usedWarningLabels.isEmpty()){ return true; }

        for(Label label:warningLabels){
            if(usedWarningLabels.contains(label)){
                label.setVisible(true);
            }else{
                label.setVisible(false);
            }
        }
        return false;
    }

    public void clearEverything(ActionEvent actionEvent) throws Exception{
        Stage stage = (Stage) resetButton.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Boekingen.fxml"));
        Parent root = loader.load();

        Stage boekingStage = new Stage();
        boekingStage.setTitle("Boekingen");
        boekingStage.setScene(new Scene(root));
        boekingStage.initModality(Modality.APPLICATION_MODAL);
        boekingStage.show();

        initialize();
    }

    public void backToOverzicht(ActionEvent actionEvent) throws Exception{
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HotelOverzicht.fxml"));
        Parent root = loader.load();

        Stage hotelStage = new Stage();
        hotelStage.setTitle("HotelApp");
        hotelStage.setScene(new Scene(root));
        hotelStage.initModality(Modality.APPLICATION_MODAL);
        hotelStage.show();
    }

    @Override
    public void focusGained(FocusEvent e) {
        nameID.setText(nameID.getText() + e.getComponent().getClass().getSimpleName() + " gained focus. ");
        System.out.println("hey");
    }

    @Override
    public void focusLost(FocusEvent e) {
        nameID.setText(nameID.getText() + e.getComponent().getClass().getSimpleName() + " gained focus. ");
        System.out.println("no");

    }
}
