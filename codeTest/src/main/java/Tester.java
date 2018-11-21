public class Tester {
    public static void main(String[] args) {
        System.out.println("===========");
        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
        NumArray n = new NumArray(nums);
        n.sumRange(0,2);
        n.sumRange(2,5);
        n.sumRange(0,5);
//        Solution s = new Solution();
//        int[] nums = new int[] {3, 1};
//        int a = s.("leetcode");
//        System.out.println("===========" + a);
    }
}
