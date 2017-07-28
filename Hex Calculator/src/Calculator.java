import java.util.HashMap;

/**
 * This calculator converts between hexadecimal to decimal
 */
public class Calculator {

    final static HashMap<Integer, String> hex = new HashMap<>();

    public static void main(String[] args) {
        fillHash();
        long startTime = System.nanoTime();
        System.out.println("0x" + decToHex(999999999,2));
        long finishTime = System.nanoTime();
        System.out.println("That took: "+(finishTime-startTime)+ " ns");


        long startTime1 = System.nanoTime();
        System.out.println("0x" + decToHexBetter(999999999));
        long finishTime1 = System.nanoTime();
        System.out.println("That took: "+(finishTime1-startTime1)+ " ns");


    }

    public static void fillHash() {
        for (Integer i = 0; i < 10; i++) {
            hex.put(i, i.toString());
        }
        hex.put(10, "A");
        hex.put(11, "B");
        hex.put(12, "C");
        hex.put(13, "D");
        hex.put(14, "E");
        hex.put(15, "F");
    }

    public static String decToHex(Integer d, Integer exp) {

        Integer a = (int) Math.pow(16, exp);
        Integer b = (int) Math.pow(16, exp-1);

        if (d < 16) {
            return hex.get(d);
        } else if ((d/a) < (d/b) && (d/a < 16) ){
            return hex.get(d/a) + decToHex(d%(a), exp-1);
        } else {
            return decToHex(d, exp+1);
        }
    }

    // The elegant method
    public static String decToHexBetter(Integer d) {
        String hex = "0123456789ABCDEF";
        String output = "";
        Integer base = 16;

        while (d>0) {
            Integer lookup = d%base;
            output = hex.charAt(lookup) + output;
            d=d/base;
        }
        return output;
    }
}