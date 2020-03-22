/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */
package sample;

import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    private String ansString, currentText,mcString;
    private boolean isEqualButtonBefore, isMCButtonBefore;
    private Queue<String> memory;

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
        System.out.println(value.equals("<-"));
        if (isEqualButtonBefore || isMCButtonBefore) {
            if (value.charAt(0) >= '0' && value.charAt(0) <= '9') {
                System.out.println("Ini 1");
                displayText.setText("");
            }
        }
        if (value.equals("<-")) {
            if (displayText.getText().length() > 0) {
                System.out.println("Ini 2");
                displayText.setText(displayText.getText().substring(0, displayText.getText().length() - 1));
            } else {
                System.out.println("Ini 3");
                displayText.setText("0");
            }
        } else {
            if (displayText.getText().equals("0")) {
                if (value.charAt(0) >= '0' && value.charAt(0) <= '9') {
                    System.out.println("Ini 4");
                    displayText.setText(value);
                } else {
                    System.out.println("Ini 5");
                    displayText.setText(displayText.getText() + value);
                }
            } else {
                System.out.println("Ini 6");
                displayText.setText(displayText.getText() + value);
            }
        }
        currentText += displayText.getText();
        isEqualButtonBefore = false;
        isMCButtonBefore = false;
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
        String hasilString = "";
        if (!isEqualButtonBefore) {
            try {
                hasilString = stack.calculate(str);
                double hasilDouble = Double.parseDouble(hasilString);
                long hasilLong = (long)hasilDouble;
                if (hasilDouble == hasilLong) {
                    hasilString = Long.toString(hasilLong);
                }
            } catch (Exception e) {
                hasilString = e.getMessage();
            }
            ansString = hasilString;
            displayText.setText(hasilString);
            currentText = ""; // bila = dipencet maka currentText diset default
            isEqualButtonBefore = true;
            isMCButtonBefore = false;
        }
    }
    @FXML
    // Menyimpan nilai "saat ini" ke dalam history kalkulator
    void onClickMC(ActionEvent event) {
        currentText = displayText.getText();
        if (currentText == ""){
            // do nothing
            System.out.println("Layar kosong");
        } else {
            if (mcString.contains("+") || mcString.contains("-") || mcString.contains("*")
            || mcString.contains("/") || mcString.contains("V"))        {
                // throw exception
                System.out.println("String bukan sebuah value");
            } else {
                mcString = currentText;
                memory.add(mcString);
                displayText.setText(mcString);
                currentText = "";
            }
        }
        isEqualButtonBefore = false;
        isMCButtonBefore = true;
    }
    @FXML
    // Menampilkan nilai yang disimpan ke layar
    void onClickMR(ActionEvent event) {
        String pop;
        if (!memory.isEmpty()){
            pop = memory.remove();
            displayText.setText(pop);
        } else {
            // throw exception
            displayText.setText("");
            System.out.println("Queue kosong");
        }
        isEqualButtonBefore = false;
        isMCButtonBefore = false;
    }
    @FXML
    // Menuliskan hasil perhitungan sebelumnya di layar
    void onClickAns(ActionEvent event) {
        if (currentText == ""){
            // bila sebelum ans dipencet layar kosong maka tampilkan nilai Ans
            displayText.setText(ansString);
        } else {
            // bila sebelum ans dipencet layar tidak kosong maka layar+=ans
            displayText.setText(displayText.getText() + ansString);
        }
        isEqualButtonBefore = false;
        isMCButtonBefore = false;
    }
    @FXML
    // Menghapus semua karakter di layar
    // Menghapus semua histori perhitungan
    void onClickCE(ActionEvent event) {
        // clear
        ansString = "";
        while (!memory.isEmpty()){
            memory.remove();
        }
        displayText.setText("");
        displayText.getText();
        isEqualButtonBefore = false;
        isMCButtonBefore = false;
        if (memory.isEmpty()){
            System.out.println("Queue kosong");
        }
        System.out.println("Histori perhitungan kosong");
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
        currentText = "";
        mcString = "";
        isEqualButtonBefore = false;
        isMCButtonBefore = false;
        memory = new LinkedList<>();
        displayText.setText("");
    }
}