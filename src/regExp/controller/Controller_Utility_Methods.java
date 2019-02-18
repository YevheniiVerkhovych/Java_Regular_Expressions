package regExp.controller;
import regExp.model.Model;
import regExp.model.Notebook_Note;
import regExp.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Controller_Utility_Methods implements RegExpContainer {

    private View view;
    private Model model;
    private Notebook_Note note;
    private Scanner scanner;


    public Controller_Utility_Methods(View view, Model model, Notebook_Note note, Scanner scanner) {

        this.view = view;

        this.model = model;

        this.note = note;

        this.scanner = scanner;
    }

    public void inputSubscriberFieldsValues()  {

//        Date date = new Date();
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        StringBuilder subscriberGroups = new StringBuilder();

        note.setSubscriberSurname(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_SURNAME, RegExpContainer.patternSubscriberSurname));

        note.setSubscriberName(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_NAME, RegExpContainer.patternSubscriberName));

        note.setSubscriberMiddleName(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_MIDDLE_NAME, RegExpContainer.patternSubscriberMiddleName));

        note.setSubscriberSurnameAndName(note.getSubscriberSurname() + " " + note.getSubscriberName().charAt(0) + ".");

        note.setSubscriberNickname(inputStringValueWithScanner(View.MESSAGE_SUBSCRIBER_NICKNAME, RegExpContainer.patternSubscriberNickname));

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

        model.addNewSubscriberToArray(note);


    }

        private String inputStringValueWithScanner(String message, String regexp) {
        String res;

        view.printMessage(message);

        while (!(scanner.hasNextLine() && (res = scanner.nextLine()).matches(regexp))) {

            view.printMessage(View.MESSAGE_WRONG_DATA);


       }

        return res;
    }


    public Model getModel() {
        return model;
    }

}
