public class BinaryNumber {
    /**
     * Assignment 1
     *
     * @author Jerry Cheng
     * Lecture B
     * <p>
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
        } else {
            for (int i = 0; i < length; i++) {
                data[i] = 0;
            }
        }
    }

    // Given string str creates binary number
    public BinaryNumber(String str) {
        length = str.length();
        data = new int[length];
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != 0 && str.charAt(i) != 1) {
                System.out.println("This is not a binary number!");
            } else {
                data[i] = Character.getNumericValue(str.charAt(i));
            }
        }

    }

    // Returns the length of the binary number
    public int getLength() {
        return data.length;
    }

    // Returns the digit located at the given index
    public int getDigit(int index) {
        if (index > length || index < 0) {
            System.out.println("Index out of bounds!");
            return -1;
        } else {
            return data[index];
        }
    }

    // Shifts a binary number right int amount times and pads the left with 0's
    public void shiftR(int amount) {
        BinaryNumber shift = new BinaryNumber(data.length + amount);
        for (int i = 0; i < shift.getLength(); i++) {
            shift.data[i] = data[i - amount];
        }
        data = shift.data;
    }

    // Transfers the binary number into a string. If there is an overflow, the string Overflow is returned
    public String toString() {
        if(overflow) {
            return "Overflow";
        }
        else {
            String BinaryString = "";
            for(int i = 0; i < data.length; i++) {
                BinaryString += data[i];
            }
            return BinaryString;
        }
    }

    // Transforms a binary number to its decimal notation
    public int toDecimal() {
        int number = 0;
        for (int i = 0; i < data.length; i++) {
            number += (data[i] * (int) Math.round((Math.pow(2, i))));
        }
        return number;
    }

    // Clears the overflow flag
    public void clearOverflow() {
        overflow = false;
    }

    // Adds two binary numbers -> one is the binary number that recieves the message and the other
    // is given as a parameter.
    public void add(BinaryNumber aBinaryNumber) {
        BinaryNumber sum = new BinaryNumber(data.length + 1);
        if (this.getLength() != aBinaryNumber.getLength()) {
            System.out.println("These numbers are not the same length");
        }
        else {
            for (int i = 0; i < data.length; i++) {
                if ((data[i] + aBinaryNumber.data[i]) == 0 && overflow == false) {
                    sum.data[i] = 0;
                    sum.overflow = false;
                } else if ((data[i] + aBinaryNumber.data[i]) == 0 && overflow == true) {
                    sum.data[i] = 1;
                    sum.overflow = false;
                } else if ((data[i] + aBinaryNumber.data[i]) == 1 && overflow == false) {
                    sum.data[i] = 0;
                    sum.overflow = false;
                } else if ((data[i] + aBinaryNumber.data[i]) == 1 && overflow == true) {
                    sum.data[i] = 0;
                    sum.overflow = true;
                } else if ((data[i] + aBinaryNumber.data[i]) == 1 && overflow == true) {
                    sum.data[i] = 0;
                    sum.overflow = true;
                } else if ((data[i] + aBinaryNumber.data[i]) == 2 && overflow == false) {
                    sum.data[i] = 0;
                    sum.overflow = true;
                } else {
                    sum.data[i] = 1;
                    sum.overflow = true;
                }
            }
            if (sum.overflow) {
                sum.data[this.getLength()] = 1;
            }
        }
    }
}