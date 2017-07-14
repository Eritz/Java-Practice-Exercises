import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> counter = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Add integers to the array list when typing
        while (s.hasNextInt()) {
            int num = s.nextInt();
            counter.add(num);
            System.out.println(num);
        }
        //sort the arraylist
        System.out.println(counter);
        sortArray(counter);
        System.out.println(counter);
    }

    public static int getInteger(ArrayList list, int idx) {
        return (int) list.get(idx);
    }

    public static void setInteger(ArrayList list, int idx, int value) {
        list.set(idx, value);
    }

    public static ArrayList<Integer> sortArray(ArrayList list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int index = i;
            for (int j = i+1; j < list.size(); j++) {
                if (getInteger(list, j) < getInteger(list, index)) {
                    index = j; //swap it if it's smaller
                }
            }
            int small = getInteger(list,index);//else that index is the smaller among the elements
            setInteger(list,index, getInteger(list,i)); //set it the same or change depending on the case
            setInteger(list, i, small);
        }
        return list;
    }
}
