package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Date;


public class PatientDetailsController {

    @FXML
    private Button btnGenerateReceipt;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtSurName;
    @FXML
    private TextField txtVaccinationType;
    @FXML
    private TextField txtBoothNumber;


    private Parent root;

    @FXML
    public void receiptWindowAppear(ActionEvent actionEvent) throws Exception{

        String FirstName = txtFirstName.getText();
        String SurName = txtSurName.getText();
        String VaccinationType = txtVaccinationType.getText();
        String BoothNumber = txtBoothNumber.getText();
        String dateString = getDateAndTime().toString();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("Receipt.fxml"));
        root = loader.load();

        ReceiptController receiptControllerObject = loader.getController();
        receiptControllerObject.printDetails(FirstName,SurName,VaccinationType,BoothNumber,dateString);

        //Creating new Stage
        Stage receiptStage = new Stage();
        receiptStage.setTitle("Receipt");

        receiptStage.setScene(new Scene(root,650,550));
        receiptStage.show();



        //Identifying and closing the previous Stage
        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();


    }

    //To generate Current Time...
     public Date getDateAndTime(){
        Date dateAndTime = new Date();
        return dateAndTime;
     }

}
