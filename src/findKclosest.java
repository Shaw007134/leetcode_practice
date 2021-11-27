import java.util.ArrayList;
import java.util.List;

class findKclosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int start = 0, end = 0;
        int max = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for(; end < arr.length; end++){
            int cur = Math.abs(arr[end] - x);
            if(end - start + 1 > k){
                if(Math.abs(arr[start] - x) > cur){
                    start++;
                }else{
                    if(arr[start] == arr[end] && arr[start] - x < 0){
                        start++;
                    }else{
                        break;
                    }
                }
            }
        }
        for(int i = start; i < end; i++){
            res.add(arr[i]);
        }
        return res;

    }

    public List<Integer> findClosets(int[] arr, int k, int x){

        ArrayList<Integer> res = new ArrayList<>();

        if(arr.length == k){
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            return res;
        }

        //binary search
        int start = 0;
        int end = arr.length;
        int middle = 0;
        while(start < end){
            middle = (end + start) / 2;
            if(arr[middle] == x) break;
            if(arr[middle] >= x){
                end = middle;
            }else{
                start = middle + 1;
            }
        }

        // Initial the sliding window's bounds
        start = start - 1;
        end = start + 1;

        while(end - start - 1 < k){
            if(start == -1){
                end++;
                continue;
            }

            if(end == arr.length || Math.abs(arr[start] -x) < Math.abs(arr[end] - x)){
                start--;
            }else{
                end++;
            }
        }

        for (int i = start + 1; i < end; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
