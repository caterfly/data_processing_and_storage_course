import java.util.ArrayList;
import java.util.Comparator;


public class Task {

    public void sortList(ArrayList list){
        list.sort((Comparator<String>) String::compareTo);
    }
}