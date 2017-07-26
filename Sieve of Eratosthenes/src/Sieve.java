import java.util.ArrayList;

/**
 * An alternative, non-recursive approach of using the Sieve of Eratosthenes to
 * find all prime numbers less than a given integer.
 */

public class Sieve {

    static ArrayList<Integer> notPrime = new ArrayList<>();
    static ArrayList<Integer> Prime = new ArrayList<>();
    private static Integer multiple;

    public static void main(String[] args) {
        run(200); // Insert integer here
    }

    public static void run(Integer max) {

        for (Integer num=2; num < max; num++) {
            if (!notPrime.contains(num)) {
                multiple = setMultiple(num);
                while (multiple < max) {
                    if (!notPrime.contains(multiple)) {
                        notPrime.add(multiple);
                    }
                    multiple += num;
                }
                Prime.add(num);
            }
        }
        System.out.println(Prime);
    }

    public static Integer setMultiple(Integer addThis) {
        return addThis + addThis;
    }
}
