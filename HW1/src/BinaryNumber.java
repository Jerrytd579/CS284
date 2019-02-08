public class BinaryNumber {
    /**
     * Assignment 1
     *
     * @author Jerry Cheng
     * Lecture B
     *
     * I pledge my Honor that I have abided by the Stevens Honor System.
     */

    // Data fields
    private int length;
    private int data[];
    private String str;
    private boolean overflow;

    // Creates a binary number of 0s with length int length
    public BinaryNumber(int length) {
        data = new int[length];
        if (length <= 0) {
            System.out.println("Length cannot be less than 0!");
        }
        else {
            for(int i = 0; i < length; i++) {
                data[i] = 0;
            }
        }
    }

    // Given string str creates binary number
    public BinaryNumber(String str) {
        length = str.length();
        data = new int[length];
        for(int i = 0; i < length; i++) {
            if(str.charAt(i) != 0 && str.charAt(i) != 1) {
                System.out.println("This is not a binary number!");
            }
            else {
                data[i] = Character.getNumericValue(str.charAt(i));
            }
        }

    }

    public int getLength() {
        return data.length;
    }

    public int getDigit(int index) {

    }

    public void shiftR(int amount) {

    }

    public void add(BinaryNumber aBinaryNumber) {

    }

    public String toString() {

    }

    public int toDecimal() {

    }

    public void clearOverflow() {

    }
}
