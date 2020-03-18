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

    @FXML // fx:id="mcID"
    private Button mcID; // Value injected by FXMLLoader

    @FXML // fx:id="sevenID"
    private Button sevenID; // Value injected by FXMLLoader

    @FXML // fx:id="fourID"
    private Button fourID; // Value injected by FXMLLoader

    @FXML // fx:id="oneID"
    private Button oneID; // Value injected by FXMLLoader

    @FXML // fx:id="zeroID"
    private Button zeroID; // Value injected by FXMLLoader

    @FXML // fx:id="mrID"
    private Button mrID; // Value injected by FXMLLoader

    @FXML // fx:id="eightID"
    private Button eightID; // Value injected by FXMLLoader

    @FXML // fx:id="fiveID"
    private Button fiveID; // Value injected by FXMLLoader

    @FXML // fx:id="twoID"
    private Button twoID; // Value injected by FXMLLoader

    @FXML // fx:id="ceID"
    private Button ceID; // Value injected by FXMLLoader

    @FXML // fx:id="nineID"
    private Button nineID; // Value injected by FXMLLoader

    @FXML // fx:id="sixID"
    private Button sixID; // Value injected by FXMLLoader

    @FXML // fx:id="threeID"
    private Button threeID; // Value injected by FXMLLoader

    @FXML // fx:id="resultID"
    private Button resultID; // Value injected by FXMLLoader

    @FXML // fx:id="cID"
    private Button cID; // Value injected by FXMLLoader

    @FXML // fx:id="multiplyID"
    private Button multiplyID; // Value injected by FXMLLoader

    @FXML // fx:id="divideID"
    private Button divideID; // Value injected by FXMLLoader

    @FXML // fx:id="substractID"
    private Button substractID; // Value injected by FXMLLoader

    @FXML // fx:id="addID"
    private Button addID; // Value injected by FXMLLoader

    @FXML // fx:id="rootID"
    private Button rootID; // Value injected by FXMLLoader

    @FXML // fx:id="displayID"
    private TextField displayID; // Value injected by FXMLLoader

    @FXML
    void addClick(ActionEvent event) {
        if (event.getSource() == addID) {
            displayID.setText(displayID.getText() + "+");
        }
    }

    @FXML
    void cClick(ActionEvent event) {
        // clear

    }

    @FXML
    void ceCLick(ActionEvent event) {
        // clear
    }

    @FXML
    void display(ActionEvent event) {

    }

    @FXML
    void divideClick(ActionEvent event) {
        if (event.getSource() == divideID) {
            displayID.setText(displayID.getText() + "/");
        }
    }

    @FXML
    void eightClick(ActionEvent event) {
        if (event.getSource() == eightID) {
            displayID.setText(displayID.getText() + "8");
        }
    }

    @FXML
    void fiveClick(ActionEvent event) {
        if (event.getSource() == fiveID) {
            displayID.setText(displayID.getText() + "5");
        }
    }

    @FXML
    void fourClick(ActionEvent event) {
        if (event.getSource() == fourID) {
            displayID.setText(displayID.getText() + "4");
        }
    }

    @FXML
    void mcClick(ActionEvent event) {

    }

    @FXML
    void mrClick(ActionEvent event) {

    }

    @FXML
    void multiplyClick(ActionEvent event) {
        if (event.getSource() == multiplyID) {
            displayID.setText(displayID.getText() + "*");
        }
    }

    @FXML
    void nineClick(ActionEvent event) {
        if (event.getSource() == nineID) {
            displayID.setText(displayID.getText() + "9");
        }
    }

    @FXML
    void oneClick(ActionEvent event) {
        if (event.getSource() == oneID) {
            displayID.setText(displayID.getText() + "1");
        }
    }

    @FXML
    void resultClick(ActionEvent event) {
        // display the result of calculation
        if (event.getSource() == resultID) {
            displayID.setText(displayID.getText() + "=");
        }
    }

    @FXML
    void rootClick(ActionEvent event) {
        if (event.getSource() == rootID) {
            displayID.setText(displayID.getText() + "V");
        }
    }

    @FXML
    void sevenClick(ActionEvent event) {
        if (event.getSource() == sevenID) {
            displayID.setText(displayID.getText() + "7");
        }
    }

    @FXML
    void sixClick(ActionEvent event) {
        if (event.getSource() == sixID) {
            displayID.setText(displayID.getText() + "6");
        }
    }

    @FXML
    void substractClick(ActionEvent event) {
        if (event.getSource() == substractID) {
            displayID.setText(displayID.getText() + "-");
        }
    }

    @FXML
    void threeClick(ActionEvent event) {
        if (event.getSource() == threeID) {
            displayID.setText(displayID.getText() + "3");
        }
    }

    @FXML
    void twoClick(ActionEvent event) {
        if (event.getSource() == twoID) {
            displayID.setText(displayID.getText() + "2");
        }
    }

    @FXML
    void zeroClick(ActionEvent event) {
        if (event.getSource() == zeroID) {
            displayID.setText(displayID.getText() + "0");
        }
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
        assert cID != null : "fx:id=\"cID\" was not injected: check your FXML file 'sample.fxml'.";
        assert multiplyID != null : "fx:id=\"multiplyID\" was not injected: check your FXML file 'sample.fxml'.";
        assert divideID != null : "fx:id=\"divideID\" was not injected: check your FXML file 'sample.fxml'.";
        assert substractID != null : "fx:id=\"substractID\" was not injected: check your FXML file 'sample.fxml'.";
        assert addID != null : "fx:id=\"addID\" was not injected: check your FXML file 'sample.fxml'.";
        assert rootID != null : "fx:id=\"rootID\" was not injected: check your FXML file 'sample.fxml'.";
        assert displayID != null : "fx:id=\"displayID\" was not injected: check your FXML file 'sample.fxml'.";
        //displayID.setText("");
    }
}
