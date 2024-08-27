package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReceiptController {

    @FXML
    private Label lblName;
    @FXML
    private Label lblVaccinationType;
    @FXML
    private Label lblBoothNumber;
    @FXML
    private Label lblDate;

    @FXML
    public void printDetails(String FirstName,String Surname, String VaccinationType, String BoothNumber, String dateString){
        lblName.setText(FirstName + " " + Surname);
        lblVaccinationType.setText(VaccinationType);
        lblBoothNumber.setText(BoothNumber);
        lblDate.setText(dateString);

    }

}
