package regExp.controller;
import regExp.model.LoginAlreadyExistException;
import regExp.model.Model;
import regExp.model.Notebook_Note;
import regExp.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Controller_Utility_Methods implements RegExpContainer {

 private View view = new View();
 private Model model;
 private Scanner scanner;


public Controller_Utility_Methods( Model model, Scanner scanner) {

        this.model = model;
        this.scanner = scanner;
    }


public boolean checkIfInputContinuous() {

        view.printMessage(view.MESSAGE_CREATE_NEW_SUBSCRIBER);
        return (scanner.hasNext() && (scanner.next()).matches(View.MESSAGE_CONFIRM_INPUT_STATEMENT));
    }

public Model inputSubscriberFieldsValues()  {
       Notebook_Note note = new Notebook_Note();
       boolean checkLogin = true;

        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        StringBuilder subscriberGroups = new StringBuilder();

        note.setSubscriberSurname(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_SURNAME, RegExpContainer.patternSubscriberSurname));

        note.setSubscriberName(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_NAME, RegExpContainer.patternSubscriberName));

        note.setSubscriberMiddleName(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_MIDDLE_NAME, RegExpContainer.patternSubscriberMiddleName));

        note.setSubscriberSurnameAndName(note.getSubscriberSurname() + " " + note.getSubscriberName().charAt(0) + ".");

        note.setSubscriberLogin(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_LOGIN, RegExpContainer.patternSubscriberLogin));

        note.setSubscriberComments(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_COMMENTS, RegExpContainer.patternSubscriberComments));

        for (Subscriber_Groups group : Subscriber_Groups.values()) {

            view.printMessage(view.MESSAGE_SUBSCRIBER_GROUPS + group.toString());

            if (scanner.hasNext() && (scanner.nextLine()).matches(View.MESSAGE_CONFIRM_INPUT_STATEMENT)) {

            subscriberGroups.append(group.toString() + " ");
            }

        }

        note.setSubscriberGroups(subscriberGroups.toString());

        note.setSubscriberHomePhone(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_HOME_PHONE, RegExpContainer.patternSubscriberHomePhone));

        note.setSubscriberCellPhone_1(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_CELL_PHONE_1, RegExpContainer.patternSubscriberCellPhone_1));

        view.printMessage(view.MESSAGE_SUBSCRIBER_CELL_PHONE_ADD_REQUEST);

            if (scanner.hasNext() && (scanner.nextLine()).matches(View.MESSAGE_CONFIRM_INPUT_STATEMENT)) {

             note.setSubscriberCellPhone_2(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_CELL_PHONE_2, RegExpContainer.patternSubscriberCellPhone_2));

            } else note.setSubscriberCellPhone_2("");


        note.setSubscriberEmail(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_EMAIL, RegExpContainer.patternSubscriberEmail));

        note.setSubscriberSkype(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_SKYPE, RegExpContainer.patternSubscriberSkype));

        note.setSubscriberZipCode(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_ZIPCODE, RegExpContainer.patternSubscriberZipCode));

        note.setSubscriberCity(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_CITY, RegExpContainer.patternSubscriberCity));

        note.setSubscriberStreet(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_STREET, RegExpContainer.patternSubscriberStreet));

        note.setSubscriberBuildingNumber(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_BUILDING_NUMBER, RegExpContainer.patternSubscriberBuildingNumber));

        note.setSubscriberFlatNumber(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_FLAT_NUMBER, RegExpContainer.patternSubscriberFlatNumber));

        note.setSubscriberAddressFull(note.getSubscriberZipCode() + " " + note.getSubscriberCity() + " " + note.getSubscriberStreet() + " " + note.getSubscriberBuildingNumber() + " "+ note.getSubscriberFlatNumber());

        note.setSubscriberDateNoteCreation(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_DATE_NOTE_CREATION, RegExpContainer.patternSubscriberDateNoteCreation));

        note.setSubscriberDateNoteLastModified(currentDate);
    do {

        try {
            model.addNewSubscriberToArray(note);
            checkLogin = false;
        } catch (LoginAlreadyExistException loginExeption) {

            view.printMessage(View.MESSAGE_SUBSCRIBER_LOGIN_EXIST);
            note.setSubscriberLogin(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_LOGIN, RegExpContainer.patternSubscriberLogin));

        }
    } while (checkLogin);

        return model;

}

private String inputStringValueWithScanner(String message, String regexp) {
        String res;

        view.printMessage(message);

        while (!(scanner.hasNextLine() && (res = scanner.nextLine()).matches(regexp))) {

            view.printMessage(View.MESSAGE_WRONG_DATA);

       }

        return res;
    }


public void getAllNotesInString() {
        for (Notebook_Note subscriber : model.getSubscribersArray()) {
            view.printMessage(subscriber.getSubscriberID() + " " + subscriber.getSubscriberSurnameAndName() + " " + subscriber.getSubscriberLogin() +
                    " " + subscriber.getSubscriberComments() + " " + subscriber.getSubscriberGroups() + " " +subscriber.getSubscriberHomePhone() + " " +
                    subscriber.getSubscriberCellPhone_1() + " " + subscriber.getSubscriberCellPhone_2() + " " + subscriber.getSubscriberEmail() + " " + subscriber.getSubscriberSkype() +
                    " " + subscriber.getSubscriberAddressFull() + " " + subscriber.getSubscriberDateNoteCreation() + " " + subscriber.getSubscriberDateNoteLastModified());
        }
    }

}
