package regExp.model;

import java.util.ArrayList;

public class Model {
//    private Notebook_Note note;

    private ArrayList<Notebook_Note> subscribersArray = new ArrayList();

       public void addNewSubscriberToArray(Notebook_Note note) {
 //       this.note = note;
        subscribersArray.add(note);
    }

    public ArrayList<Notebook_Note> getSubscribersArray() {
        return subscribersArray;
    }

}
