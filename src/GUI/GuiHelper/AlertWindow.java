package GUI.GuiHelper;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

/**
 * Created by steinar on 19.03.2015.
 *
 * Class for displaying alertwindows
 * Add more methods as you see fit
 * Refer to http://code.makery.ch/blog/javafx-dialogs-official/ for how these work
 *  - All functions return a boolean
 *  - Except multichoice
 */

public final class AlertWindow
{
    public static boolean messageDialog( String message, String title ) {
        Alert.AlertType aType = Alert.AlertType.INFORMATION;
        return alert(message, title, aType);
    }

    public static boolean errorDialog( String message, String title ) {
        Alert.AlertType aType = Alert.AlertType.ERROR;
        return alert(message, title, aType);
    }

    public static boolean waringDialog( String message, String title ) {
        Alert.AlertType aType = Alert.AlertType.WARNING;
        return alert(message, title, aType);
    }

    public static boolean confirmDialog( String message, String title ) {
        Alert.AlertType aType = Alert.AlertType.CONFIRMATION;
        return alert(message, title, aType);
    }

    private static boolean alert(String message, String title, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.initModality(Modality.WINDOW_MODAL);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        Parent parent = alert.getDialogPane();
        parent.setStyle("-fx-font-size: 1.3em;");

        return alert.showAndWait().get() == ButtonType.OK;
    }
}