package StreamAPI_1_2.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        for (int elem : filterList(intList)){
            System.out.println(elem);
        }
    }

    public static List<Integer> filterList(List<Integer> intList) {
        List<Integer> newList = new ArrayList<>();

        for (int elem : intList) {
            if (elem > 0) {
                newList.add(elem);
            }
        }

        newList.removeIf(elem -> elem % 2 != 0);
        Collections.sort(newList);
        return newList;
    }
}
