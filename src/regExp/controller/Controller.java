package regExp.controller;
import regExp.model.Model;
import regExp.view.View;
import java.util.Scanner;


public class Controller {
    private Model model;
    Scanner scanner = new Scanner(System.in);


public Controller(Model model) {
        this.model = model;
    }


public void createNewSubscribers () {
    Controller_Utility_Methods controllerUtilityMethods = new Controller_Utility_Methods(model, scanner);

    while (controllerUtilityMethods.checkIfInputContinuous()) {

        scanner.nextLine();

        model = controllerUtilityMethods.inputSubscriberFieldsValues();

        }

    controllerUtilityMethods.getAllNotesInString();

    }


}
