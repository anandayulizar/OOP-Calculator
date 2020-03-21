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
    private String ansString;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    // Button number & .
    @FXML
    private Button zeroButton,oneButton,twoButton,threeButton,fourButton,fiveButton,sixButton,sevenButton,eightButton,nineButton,dotButton;
    // Button operator
    @FXML
    private Button multiplyButton,divideButton,substractButton,addButton,
            rootButton,resultButton;
    // Button MC & MR
    @FXML
    private Button mcButton, mrButton;
    // Button ans
    @FXML
    private Button ansButton;
    // Button clear
    @FXML
    private Button ceButton;
    // Layar
    @FXML
    private TextField displayText; // Value injected by FXMLLoader

    // METHODS
    @FXML
    void onClickExpression(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        displayText.setText(displayText.getText() + value);
    }
    @FXML
    // Melakukan perhitungan
    // Perhitungan bisa valid atau tidak
    // Bila valid tampilkan hasil kalkulasi, simpan hasil di antrian
    // Bila tidak beri pesan eror
    void onClickResult(ActionEvent event) {
        // display the result of calculation
        CalculatorStack stack = new CalculatorStack();
        String str = displayText.getText();
        TerminalExpression hasil = stack.calculate(str);
        String hasilInString = Double.toString(hasil.solve());
        ansString = hasilInString;
        displayText.setText(hasilInString);
    }
    @FXML
    // Menyimpan nilai "saat ini" ke dalam history kalkulator
    void onClickMC(ActionEvent event) {

    }
    @FXML
    // Menampilkan nilai yang disimpan ke layar
    void onClickMR(ActionEvent event) {

    }
    @FXML
    // Menuliskan hasil perhitungan sebelumnya di layar
    void onClickAns(ActionEvent event) {
        displayText.setText(displayText.getText() + ansString);
    }
    @FXML
    // Menghapus semua karakter di layar
    // Menghapus semua histori perhitungan
    void onClickCE(ActionEvent event) {
        // clear
        ansString = "";
        displayText.setText("");
        displayText.getText();
    }
    @FXML
    void display(ActionEvent event) {

    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert mcButton != null : "fx:id=\"mcButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert sevenButton != null : "fx:id=\"sevenButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert fourButton != null : "fx:id=\"fourButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert oneButton != null : "fx:id=\"oneButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert zeroButton != null : "fx:id=\"zeroButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert mrButton != null : "fx:id=\"mrButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert eightButton != null : "fx:id=\"eightButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert fiveButton != null : "fx:id=\"fiveButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert twoButton != null : "fx:id=\"twoButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert ceButton != null : "fx:id=\"ceButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert nineButton != null : "fx:id=\"nineButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert sixButton != null : "fx:id=\"sixButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert threeButton != null : "fx:id=\"threeButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert resultButton != null : "fx:id=\"resultButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert ansButton != null : "fx:id=\"ansButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert multiplyButton != null : "fx:id=\"multiplyButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert divideButton != null : "fx:id=\"divideButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert substractButton != null : "fx:id=\"substractButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert rootButton != null : "fx:id=\"rootButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert displayText != null : "fx:id=\"displayText\" was not injected: check your FXML file 'sample.fxml'.";

        ansString = "";

        displayText.setText("");
    }
}