package regExp;
import regExp.controller.Controller;
import regExp.model.Model;

public class Main {

  public static void main(String[] args) {
        //Initialization
        Model model = new Model();

        Controller controller = new Controller(model);

        controller.createNewSubscribers();


    }

}
