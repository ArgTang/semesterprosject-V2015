package GUI.CustomerGUI;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by steinar on 22.04.2015.
 */
public class CustomerLoggedInController
{
    public Parent initEditPerson() {
        HBox container = new HBox();
        Parent editPerson = null;
        Parent insuranceTable = null;
        Parent incidentTable = null;
        try {
            editPerson = FXMLLoader.load( getClass().getResource("/GUI/CustomerGUI/EditCustomer.fxml") );
            insuranceTable = FXMLLoader.load( getClass().getResource("/GUI/CustomerGUI/CustomerInsuranseTable.fxml") );
            incidentTable = FXMLLoader.load( getClass().getResource("/GUI/CustomerGUI/CustomerIncidentTable.fxml") );
        } catch (IOException e) {
            System.out.println("failed loading fxml file in PersonController");
            e.printStackTrace();
        }

        editPerson = addParentLabel(editPerson, "Persondata:");
        insuranceTable = addParentLabel(insuranceTable, "Registrerte forsikringer:");
        incidentTable = addParentLabel( incidentTable, "Registrerte hendelser:");

        HBox.setMargin(editPerson, new Insets(0, 20, 0, 0));
        container.prefWidth(Region.USE_COMPUTED_SIZE);
        container.setSpacing(5);
        container.setPadding(new Insets(10, 5, 0, 0));
        container.getChildren().addAll(editPerson, insuranceTable, incidentTable);
        return container;
    }

    private Parent addParentLabel(Parent parent, String title) {
        VBox.setVgrow(parent, Priority.ALWAYS);
        VBox vbox= new VBox();
        HBox.setHgrow(vbox, Priority.ALWAYS);

        Label label = new Label(title);
        vbox.setSpacing(2);
        vbox.getChildren().addAll(label, parent);
        return vbox;
    }
}