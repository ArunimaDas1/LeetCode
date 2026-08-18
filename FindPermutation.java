import java.util.ArrayList;
import java.util.List;

public class FindPermutation {

    public static void findPerm(List<Integer> rest, List<Integer> ans) {
        if (rest.size() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            int curr = rest.get(i);

            List<Integer> newRest = new ArrayList<>(rest);
            newRest.remove(i);              // remove chosen element

            List<Integer> newAns = new ArrayList<>(ans);
            newAns.add(curr);               // add it to the answer so far

            findPerm(newRest, newAns);
        }
    }

    public static void main(String[] args) {
        List<Integer> rest = new ArrayList<>();
        rest.add(1);
        rest.add(2);
        rest.add(3);

        findPerm(rest, new ArrayList<>());
    }
}