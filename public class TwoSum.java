public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result1[0] + " " + result1[1]);
    }
}