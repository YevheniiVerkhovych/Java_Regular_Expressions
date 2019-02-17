package regExp;
import regExp.controller.Controller;
import regExp.model.Model;
import regExp.view.View;

public class Main {

  public static void main(String[] args) {
        //Initialization
        Model model = new Model();
        View view = new View();


        Controller controller = new Controller(model, view);

        controller.createNewSubscribers();


    }

}
