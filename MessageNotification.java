package restaurantsoftware;

import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class MessageNotification {

    /*LOGIN Action Message Notification*/
    public void loginSuccessTrayNotification(String detail) {
        TrayNotification tray = new TrayNotification();

        String title = "Login Successfull";
        String message = "Welcome " + detail;
        NotificationType type = NotificationType.SUCCESS;

        basicStructure(tray, title, message, type);
    }

    public void loginErrorTrayNotification() {
        TrayNotification tray = new TrayNotification();

        String title = "Login Error";
        String message = "Username or Password or Type is incorrect";
        NotificationType type = NotificationType.ERROR;

        basicStructure(tray, title, message, type);
    }

    /*ADD Action Message Notification*/
    public void addSuccessTrayNotification(String focus, String detail) {
        TrayNotification tray = new TrayNotification();

        String title = focus + " Inserted";
        String message = focus + " name: " + detail;
        NotificationType type = NotificationType.SUCCESS;

        basicStructure(tray, title, message, type);
    }

    public void addErrorTrayNotification(String focus) {
        TrayNotification tray = new TrayNotification();

        String title = "Insert Error";
        String message = "Duplicate occurred while inserting: " + focus;
        NotificationType type = NotificationType.ERROR;

        basicStructure(tray, title, message, type);
    }

    public void addErrorTrayNotificationLogin(String focus) {
        TrayNotification tray = new TrayNotification();

        String title = "Can't Login";
        String message = "Check UserName,Password And Type(User Or Customer)" + focus;
        NotificationType type = NotificationType.ERROR;

        basicStructure(tray, title, message, type);
    }

    /*DELETE Action Message Notification*/
    public void deleteSuccessTrayNotification(String focus, String detail) {
        TrayNotification tray = new TrayNotification();

        String title = focus + " Deleted";
        String message = focus + " name: " + detail;
        NotificationType type = NotificationType.SUCCESS;

        basicStructure(tray, title, message, type);
    }

    public void deleteupdatedNotification_placed(double priceTotal, String detail) {
        TrayNotification tray = new TrayNotification();

        String title = " Update";
        String message = "Your Card Placed Successfully Total Price = " + priceTotal;
        NotificationType type = NotificationType.SUCCESS;

        basicStructure(tray, title, message, type);
    }

    public void deleteErrorTrayNotification(String focus) {
        TrayNotification tray = new TrayNotification();

        String title = "Delete Error";
        String message = "Problem occurred while deleting: " + focus;
        NotificationType type = NotificationType.ERROR;

        basicStructure(tray, title, message, type);
    }

    /*UPDATE Action Message Notification*/
    public void updateSuccessTrayNotification(String focus, String detail) {
        TrayNotification tray = new TrayNotification();

        String title = focus + " Updated";
        String message = focus + " name: " + detail;
        NotificationType type = NotificationType.SUCCESS;

        basicStructure(tray, title, message, type);
    }

    public void updateErrorTrayNotification(String focus) {
        TrayNotification tray = new TrayNotification();

        String title = "Update Error";
        String message = "Problem occurred while updating: " + focus;
        NotificationType type = NotificationType.ERROR;

        basicStructure(tray, title, message, type);
    }

    //basic structure of notifications
    private void basicStructure(TrayNotification tray, String title, String message, NotificationType type) {
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
    }

}