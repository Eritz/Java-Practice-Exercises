import java.util.ArrayList;

/**
 * Every natural number has a unique set of prime factors
 * This program outputs the prime factors and how many the number has.
 * Example is 48 = 2 * 2 * 2 * 2 * 3; so it'll be 5.
 */
public class Factor {

    static ArrayList<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) {
        getPF(48);
    }

    public static boolean checkPrime(Integer check, Integer div) {
        if (div <= 1) {
            return true;
        } else if (check%div == 0) {
            return false;
        } else return checkPrime(check, div-1);
    }

    public static void getPF(Integer n) {

        Integer STAY = n, branch = n;

        if (checkPrime(n,(int) Math.sqrt(n)) == true) { // Check if the number itself is a prime
            primeList.add(n);

        } else { // If not find its prime factors
            for (Integer i = 2; i <= (int) Math.sqrt(STAY); i++) {
                if (checkPrime(i, (int) Math.sqrt(i)) == true) {

                    while (branch % i == 0) {
                        primeList.add(i);
                        branch = branch / i;
                    }
                }
            }
        }
        System.out.println(primeList);
        System.out.println("The number of prime factors is " + primeList.size());
    }


}
