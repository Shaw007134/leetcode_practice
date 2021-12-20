import java.util.Stack;

class nextGreaterElement {
    public int[] findNextGreater(int[] nums){
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while(!stack.empty() && stack.peek() <= nums[i%nums.length]){
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }
        return res;
    }
}
