public class Exceptions {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6}; // 0 - 2

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println(nums[i]);
            }

            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }
}
