package Opdracht9B.userinterface;

import Opdracht9B.model.Hotel;
import Opdracht9B.model.Boeking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class HotelOverzichtController {
    public Button openBoekingen;
    @FXML private Label hotelnaamLabel;
    @FXML private ListView<String> boekingenListView = new ListView<>();
    @FXML private DatePicker overzichtDatePicker;

    private Hotel hotel = Hotel.getHotel();

    public void initialize() {
        hotelnaamLabel.setText("Boekingen hotel " + hotel.getNaam());
        overzichtDatePicker.setValue(LocalDate.now());
        toonBoekingen();
    }

    public void toonVorigeDag(ActionEvent actionEvent) {
        LocalDate dagEerder = overzichtDatePicker.getValue().minusDays(1);
        overzichtDatePicker.setValue(dagEerder);
    }

    public void toonVolgendeDag(ActionEvent actionEvent) {
        LocalDate dagLater = overzichtDatePicker.getValue().plusDays(1);
        overzichtDatePicker.setValue(dagLater);
    }

    public void nieuweBoeking(ActionEvent actionEvent) throws Exception{
        Stage stage = (Stage) openBoekingen.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Boekingen.fxml"));
        Parent root = loader.load();

        Stage boekingStage = new Stage();
        boekingStage.setTitle("Boekingen");
        boekingStage.setScene(new Scene(root));
        boekingStage.initModality(Modality.APPLICATION_MODAL);
        boekingStage.show();

        initialize();

        // Update na sluiten van de nieuwe pagina het boekingen-overzicht
    }

    public void toonBoekingen(){
        ObservableList<String> boekingen = FXCollections.observableArrayList();
        ArrayList<Boeking> allBoekingen = new ArrayList<>(hotel.getBoekingen());
        LocalDate huidigeDag = overzichtDatePicker.getValue();

        for(Boeking b : allBoekingen){
            LocalDate aankomst = b.getAankomstDatum();
            LocalDate vertrek = b.getVertrekDatum();

            if(huidigeDag.compareTo(aankomst) >= 0 && huidigeDag.compareTo(vertrek) <= 0){
                String stringformaat = String.format("Van %s tot %s is kamer %s voor %s gereserveerd.",
                        aankomst, vertrek, b.getKamer().getKamerNummer(), b.getBoeker().getNaam());
                boekingen.add(stringformaat);
            }
        }
        boekingenListView.setItems(boekingen);
    }
}