package GUI.AgentGUI.Insurance;

import GUI.GuiHelper.CommonGUIMethods;
import GUI.GuiHelper.RegEX;
import GUI.StartMain;
import Insurance.Helper.PaymentOption;
import Insurance.Insurance;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

/**
 * Created by steinar on 17.04.2015.
 */
public final class RegisterCarModuleController implements CommonGUIMethods
{
    @FXML
    TextField registrationnumber;
    @FXML
    TextField km;
    @FXML
    TextField maker;
    @FXML
    TextField model;
    @FXML
    TextField motorsize;
    @FXML
    TextField modelYear;
    @FXML
    TextField color;
    @FXML
    TextField buyPrice;

    @FXML
    DatePicker fromDate;
    @FXML
    CheckBox ageRequirements;
    @FXML
    ComboBox kasko;
    @FXML
    ComboBox bonus;
    @FXML
    ComboBox yearlyKM;
    @FXML
    ComboBox deductible;
    @FXML
    ComboBox paymentOption;

    //combobox values:
    private ObservableList<String> kaskoValues = FXCollections.observableArrayList();
    private ObservableList<Integer> bonusValues = FXCollections.observableArrayList();
    private ObservableList<String> kmValues = FXCollections.observableArrayList();
    private ObservableList<Integer> deductablenumbers = FXCollections.observableArrayList();
    private ObservableList<String> paymentOptionNummber = FXCollections.observableArrayList();

    private StringProperty personName = new SimpleStringProperty();

    @FXML
    private void initialize()
    {
        //todo: some of these might be used for more insurances -> move into Vehicle Class
        kaskoValues.addAll("Ansvar", "Delkasko", "Fullkasko");
        kasko.setItems(kaskoValues);

        bonusValues.addAll(0, 10, 20, 30, 40, 50, 60, 70, 75);
        bonus.setItems(bonusValues);

        kmValues.addAll("8000", "12000", "16000", "ubegrenset");
        yearlyKM.setItems(kmValues);

        deductablenumbers.addAll(2000, 4000, 8000, 12000);
        deductible.setItems(deductablenumbers);

        paymentOptionNummber.addAll(PaymentOption.MONTHLY.getName(), PaymentOption.QUARTERLY.getName(), PaymentOption.YEARLY.getName());
        paymentOption.setItems(paymentOptionNummber);

        addCSSValidation();
        clearFields();
        setInsuranceChoiceListener();
    }

    @Override
    public void clearFields()
    {
        resetTextField(registrationnumber);
        resetTextField(km);
        resetTextField(maker);
        resetTextField(model);
        resetTextField(motorsize);
        resetTextField(modelYear);
        resetTextField(color);
        resetTextField(buyPrice);
        personName.setValue("");
        fromDate.setValue(LocalDate.now());
        ageRequirements.setIndeterminate(false);

        kasko.setValue("Fullkasko");
        bonus.setValue(20);
        yearlyKM.setValue("12000");
        deductible.setValue(4000);
        paymentOption.setValue(PaymentOption.MONTHLY.getName());
    }

    @Override
    public void addCSSValidation() {
        RegEX.addCSSTextValidation(registrationnumber, RegEX.isAllChars()); //todo: rege for this?
        RegEX.addCSSTextValidation(km, RegEX.isNumber());
        RegEX.addCSSTextValidation(maker, RegEX.isLetters());
        RegEX.addCSSTextValidation(model, RegEX.isAllChars()); //todo: is chars or is letters
        RegEX.addCSSTextValidation(motorsize, RegEX.isNumber());
        RegEX.addCSSTextValidation(modelYear, RegEX.isNumber(4));
        RegEX.addCSSTextValidation(color, RegEX.isLetters());
        RegEX.addCSSTextValidation(buyPrice, RegEX.isNumber());
    }
    private void setInsuranceChoiceListener()
    {

        StartMain.currentInsurance.getPersonProperty().addListener(
                observable -> {
                    ObjectProperty<Insurance> insurance = (ObjectProperty<Insurance>)observable;

                    if ( insurance.isNotNull().get() )
                    {
                        //todo: set insurance
                    }
                    else
                        clearFields();
                }
        );

        AgentInsuranceController.insuranceChoiceListener.getStringProperty().addListener(
            observable -> {
                StringProperty string = (StringProperty) observable;

                if (string.getValue().equals("tøm skjerm"))
                {
                    System.out.print(string.getValue());
                    clearFields();
                }
            });
    }

}
