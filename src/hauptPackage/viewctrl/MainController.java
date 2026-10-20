package hauptPackage.viewctrl;

import hauptPackage.mdl.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Label value;

    private double printValue;

    @FXML
    private TextField textField;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private ChoiceBox<String> currency2;


    ObservableList<String> options = FXCollections.observableArrayList(
            "EUR", "USD", "CHF"
    );

    public double returnValue() {
        double amount = Double.parseDouble(textField.getText());

        String from =
                choiceBox.getValue();

        String to =
                currency2.getValue();

        return model.convert(amount, from, to);
    }


    ObservableList<String> options2 = FXCollections.observableArrayList(
            "USD", "CHF", "EUR"
    );


    Model model = new Model();

    @FXML
    public void doClick() {

        try {
            printValue = returnValue();

            refreshGUI();
        } catch (Exception e) {
            value.setText("Fehler!");
        }
    }

    private void refreshGUI() {
        value.setText(
                String.format("%.2f", printValue)
        );
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(options);
        currency2.setItems(options2);

        choiceBox.setValue("EUR");
        currency2.setValue("USD");

        value.setText("0");
    }
}
