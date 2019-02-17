package regExp.controller;
import regExp.model.Model;
import regExp.model.Notebook_Note;
import regExp.view.View;
import java.util.Scanner;


public class Controller {
    private Model model;
    private View view;
    Scanner scanner = new Scanner(System.in);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

public boolean checkIfInputContinuous() {

    view.printMessage(view.MESSAGE_CREATE_NEW_SUBSCRIBER);
    return (scanner.hasNext() && (scanner.nextLine()).matches(View.MESSAGE_CONFIRM_INPUT_STATEMENT));

}

public void createNewSubscribers () {


    while (checkIfInputContinuous()) {

        Notebook_Note note = new Notebook_Note();

        Controller_Utility_Methods controllerUtilityMethods = new Controller_Utility_Methods(view, model, note, scanner);

        controllerUtilityMethods.inputSubscriberFieldsValues();
        model = controllerUtilityMethods.getModel();
    }

    for (Notebook_Note subscriber : model.getSubscribersArray()) {
        view.printMessage(subscriber.getSubscriberID() + " " + subscriber.getSubscriberSurnameAndName() + " " + subscriber.getSubscriberNickname() +
                " " + subscriber.getSubscriberComments() + " " + subscriber.getSubscriberGroups() + " " +subscriber.getSubscriberHomePhone() + " " +
                subscriber.getSubscriberCellPhone_1() + " " + subscriber.getSubscriberCellPhone_2() + " " + subscriber.getSubscriberEmail() + " " + subscriber.getSubscriberSkype() +
                " " + subscriber.getSubscriberAddressFull() + " " + subscriber.getSubscriberDateNoteCreation() + " " + subscriber.getSubscriberDateNoteLastModified());
    }


}


}
