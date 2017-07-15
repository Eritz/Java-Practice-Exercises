/**
 * Challenge # 4 from r/dailyprogrammer.
 * This program is designed to generate a password of a desired length. The passwords can be purely
 * alphabetical, alphanumeric, or alphanumeric with symbols.
 * Short term: Create a command line operatable program.
 * Long term: Create a GUI program that can do it.
 *
 * 1-26 is A-Z, 97-122 is a-z
 */
import java.util.Scanner;
import java.util.Random;

public class PasswordGen {

    public static void main(String args[]) {
        Password pd = new Password();
        pd.createAlphaNumSym(pd.getLength());
        System.out.println("The password generated is" + pd);
    }

    private static class Password {

        Random r = new Random();
        String newPassword = "";

        // Get the password length
        public Integer getLength() {
            int length;
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the password length: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Not a valid number. Try again.");
                } else {
                    length = sc.nextInt();
                    break;
                }
            }
            return length;
        }

        // Create a password with alphabetical characters
        public String createAlpha(int pl) {

            for (int i = 0; i < pl; i++) {
                if (r.nextBoolean() == true) {
                    char pd = (char) (r.nextInt(26) + 'a'); //'a' is 97 in ASCII. So the parenthesis will add the random int to "a"
                    newPassword = newPassword + String.valueOf(pd);
                } else {
                    char pd = (char) (r.nextInt(26) + 'A'); //'A' is 1 in ASCII. So the parenthesis will add the random int to "A"
                    newPassword = newPassword + String.valueOf(pd);
                }
            }
            return newPassword;
        }

        // Create a password with alphanumeric characters
        public String createAlphaNum(int pl) {

            for (int i = 0; i < pl; i++) {
                int guess = r.nextInt(3);
                if (guess == 0) {
                    char pd = (char) (r.nextInt(26) + 'a');
                    newPassword = newPassword + String.valueOf(pd);
                } else if (guess == 1) {
                    char pd = (char) (r.nextInt(26) + 'A');
                    newPassword = newPassword + String.valueOf(pd);
                } else {
                    char pd = (char) (r.nextInt(10) + '0');
                    newPassword = newPassword + String.valueOf(pd);
                }
            }
            return newPassword;
        }

        // Create a password with alphanumeric characters and symbols
        public String createAlphaNumSym(int pl) {
            for (int i = 0; i < pl; i++) {
                int guess = r.nextInt(5);
                if (guess == 0) {
                    char pd = (char) (r.nextInt(26) + 'a');
                    newPassword = newPassword + String.valueOf(pd);
                } else if (guess == 1) {
                    char pd = (char) (r.nextInt(26) + 'A');
                    newPassword = newPassword + String.valueOf(pd);
                } else if (guess == 2) {
                    char pd = (char) (r.nextInt(10) + '0');
                    newPassword = newPassword + String.valueOf(pd);
                } else if (guess == 3){
                    char pd = (char) (Math.random() * 14 + 33); //33 to 47 are symbols
                    newPassword = newPassword + String.valueOf(pd);
                } else {
                    char pd = (char) (Math.random() * 8 + 144); //144 to 152 are symbols
                    newPassword = newPassword + String.valueOf(pd);
                }
            }
            return newPassword;
        }
    }
}
