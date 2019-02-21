package regExp.model;

import java.util.ArrayList;

public class Model {

    private ArrayList<Notebook_Note> subscribersArray = new ArrayList();

       public void addNewSubscriberToArray(Notebook_Note note) throws LoginAlreadyExistException {

           for (Notebook_Note note_check : subscribersArray) {

            if (note.getSubscriberLogin().equals(note_check.getSubscriberLogin())) {
//                System.out.println("Alert!!1");
                throw new LoginAlreadyExistException(note);
            }

           }
        subscribersArray.add(note);
    }

    public ArrayList<Notebook_Note> getSubscribersArray() {
        return subscribersArray;
    }

}
