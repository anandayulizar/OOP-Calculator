/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */
package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    // Button number & .
    @FXML
    private Button zeroID,oneID,twoID,threeID,fourID,
            fiveID,sixID,sevenID,eightID,nineID, dotID;
    // Button operator
    @FXML
    private Button multiplyID,divideID,substractID,addID,
            rootID,resultID;
    // Button MC & MR
    @FXML
    private Button mcID, mrID;
    // Button ans
    @FXML
    private Button ansID;
    // Button clear
    @FXML
    private Button ceID;
    // Layar
    @FXML
    private TextField displayID; // Value injected by FXMLLoader

    // METHODS
    @FXML
    void zeroClick(ActionEvent event) {
        if (event.getSource() == zeroID) {
            displayID.setText(displayID.getText() + "0");
        }
    }
    @FXML
    void oneClick(ActionEvent event) {
        if (event.getSource() == oneID) {
            displayID.setText(displayID.getText() + "1");
        }
    }
    @FXML
    void twoClick(ActionEvent event) {
        if (event.getSource() == twoID) {
            displayID.setText(displayID.getText() + "2");
        }
    }
    @FXML
    void threeClick(ActionEvent event) {
        if (event.getSource() == threeID) {
            displayID.setText(displayID.getText() + "3");
        }
    }
    @FXML
    void fourClick(ActionEvent event) {
        if (event.getSource() == fourID) {
            displayID.setText(displayID.getText() + "4");
        }
    }
    @FXML
    void fiveClick(ActionEvent event) {
        if (event.getSource() == fiveID) {
            displayID.setText(displayID.getText() + "5");
        }
    }
    @FXML
    void sixClick(ActionEvent event) {
        if (event.getSource() == sixID) {
            displayID.setText(displayID.getText() + "6");
        }
    }
    @FXML
    void sevenClick(ActionEvent event) {
        if (event.getSource() == sevenID) {
            displayID.setText(displayID.getText() + "7");
        }
    }
    @FXML
    void eightClick(ActionEvent event) {
        if (event.getSource() == eightID) {
            displayID.setText(displayID.getText() + "8");
        }
    }
    @FXML
    void nineClick(ActionEvent event) {
        if (event.getSource() == nineID) {
            displayID.setText(displayID.getText() + "9");
        }
    }
    @FXML
    void dotClick(ActionEvent event) {
        if (event.getSource() == dotID) {
            displayID.setText(displayID.getText() + ".");
        }
    }
    @FXML
    void addClick(ActionEvent event) {
        if (event.getSource() == addID) {
            displayID.setText(displayID.getText() + "+");
        }
    }
    @FXML
    void divideClick(ActionEvent event) {
        if (event.getSource() == divideID) {
            displayID.setText(displayID.getText() + "/");
        }
    }
    @FXML
    void multiplyClick(ActionEvent event) {
        if (event.getSource() == multiplyID) {
            displayID.setText(displayID.getText() + "*");
        }
    }
    @FXML
    void substractClick(ActionEvent event) {
        if (event.getSource() == substractID) {
            displayID.setText(displayID.getText() + "-");
        }
    }
    @FXML
    void rootClick(ActionEvent event) {
        if (event.getSource() == rootID) {
            displayID.setText(displayID.getText() + "V");
        }
    }
    @FXML
    // Melakukan perhitungan
    // Perhitungan bisa valid atau tidak
    // Bila valid tampilkan hasil kalkulasi, simpan hasil di antrian
    // Bila tidak beri pesan eror
    void resultClick(ActionEvent event) {
        // display the result of calculation
        CalculatorStack stack = new CalculatorStack();
        String str = displayID.getText();
        TerminalExpression hasil = stack.calculate(str);
        String hasilInString = Double.toString(hasil.solve());
        if (event.getSource() == resultID) {
            displayID.setText(hasilInString);
        }
    }
    @FXML
    // Menyimpan nilai "saat ini" ke dalam history kalkulator
    void mcClick(ActionEvent event) {

    }
    @FXML
    // Menampilkan nilai yang disimpan ke layar
    void mrClick(ActionEvent event) {

    }
    @FXML
    // Menuliskan hasil perhitungan sebelumnya di layar
    void ansClick(ActionEvent event) {
        if (event.getSource() == ansID) {

        }
    }
    @FXML
    // Menghapus semua karakter di layar
    // Menghapus semua histori perhitungan
    void ceCLick(ActionEvent event) {
        // clear
        if (event.getSource() == ceID) {
            displayID.setText("");
            displayID.getText();
        }
    }
    @FXML
    void display(ActionEvent event) {

    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert mcID != null : "fx:id=\"mcID\" was not injected: check your FXML file 'sample.fxml'.";
        assert sevenID != null : "fx:id=\"sevenID\" was not injected: check your FXML file 'sample.fxml'.";
        assert fourID != null : "fx:id=\"fourID\" was not injected: check your FXML file 'sample.fxml'.";
        assert oneID != null : "fx:id=\"oneID\" was not injected: check your FXML file 'sample.fxml'.";
        assert zeroID != null : "fx:id=\"zeroID\" was not injected: check your FXML file 'sample.fxml'.";
        assert mrID != null : "fx:id=\"mrID\" was not injected: check your FXML file 'sample.fxml'.";
        assert eightID != null : "fx:id=\"eightID\" was not injected: check your FXML file 'sample.fxml'.";
        assert fiveID != null : "fx:id=\"fiveID\" was not injected: check your FXML file 'sample.fxml'.";
        assert twoID != null : "fx:id=\"twoID\" was not injected: check your FXML file 'sample.fxml'.";
        assert ceID != null : "fx:id=\"ceID\" was not injected: check your FXML file 'sample.fxml'.";
        assert nineID != null : "fx:id=\"nineID\" was not injected: check your FXML file 'sample.fxml'.";
        assert sixID != null : "fx:id=\"sixID\" was not injected: check your FXML file 'sample.fxml'.";
        assert threeID != null : "fx:id=\"threeID\" was not injected: check your FXML file 'sample.fxml'.";
        assert resultID != null : "fx:id=\"resultID\" was not injected: check your FXML file 'sample.fxml'.";
        assert ansID != null : "fx:id=\"ansID\" was not injected: check your FXML file 'sample.fxml'.";
        assert multiplyID != null : "fx:id=\"multiplyID\" was not injected: check your FXML file 'sample.fxml'.";
        assert divideID != null : "fx:id=\"divideID\" was not injected: check your FXML file 'sample.fxml'.";
        assert substractID != null : "fx:id=\"substractID\" was not injected: check your FXML file 'sample.fxml'.";
        assert addID != null : "fx:id=\"addID\" was not injected: check your FXML file 'sample.fxml'.";
        assert rootID != null : "fx:id=\"rootID\" was not injected: check your FXML file 'sample.fxml'.";
        assert displayID != null : "fx:id=\"displayID\" was not injected: check your FXML file 'sample.fxml'.";
        displayID.setText("");
    }
}