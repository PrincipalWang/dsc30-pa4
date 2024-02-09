import java.util.*;

/**
 * ListManual Implementation
 *
 * @author Chen Wang
 * @since  2/8/2024
 */

public class ListManual {

// No style for this file. How poetic :D

    public static ArrayList<String>  listManipulations() {

        ArrayList<String> answers = new ArrayList<>(11);

        answers.add("h = h.next;");
        answers.add("h = r;");
        answers.add("r = h;");
        answers.add("t = h.next;");
        answers.add("h.elem = t.elem;");
        answers.add("h.elem = h.next.next.elem;");
        answers.add("h.next.next.next = h;");
        answers.add("h.next = h.next.next;");
        answers.add("while(r.next != null){if(r.elem == 'M'){break;}else{r = r.next}}");
        answers.add("h = new Node('A', new Node('B', new Node('C', new Node('D', null))));");
        answers.add("h.next.next.next = new Node('D', null)");
        return answers;
    }
}