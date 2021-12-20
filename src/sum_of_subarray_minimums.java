import java.util.Stack;

class sum_of_subarray_minimums {
    public int sumSubarrayMins(int[] arr){
        int n = arr.length;
        long mod = (long) 1e9 + 7;
        long res = 0;
        Stack<Integer> sp = new Stack<>();
        Stack<Integer> sn = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            while(!sp.empty() && arr[sp.peek()] >= arr[i]){
                sp.pop();
            }
            prev[i] = sp.empty() ? i + 1 : i - sp.peek();
            sp.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while(!sn.empty() && arr[sn.peek()] > arr[i]){
                sn.pop();
            }
            next[i] = sn.empty() ? n - i : sn.peek() - i;
            sn.push(i);
        }

        for (int i = 0; i < n; i++) {
            res = (res + (long)arr[i] * prev[i] * next[i]) % mod;
        }
        return (int)res;
    }
}
