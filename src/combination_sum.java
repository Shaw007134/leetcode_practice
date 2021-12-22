import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<>();
        this.backtracking(target, comb, 0, candidates, results);
        return results;
    }

    public void backtracking(int remain, LinkedList<Integer> comb, int curr, int[] candidates, List<List<Integer>> results){
        if(remain == 0){
            // make a deep copy of the current combination
            results.add(new ArrayList<>(comb));
            return;
        }else if(remain < 0){
            // exceed the scope, stop exploration
            return;
        }

        for (int i = curr; i < candidates.length; i++) {
            // add the number into the combination
            comb.add(candidates[i]);
            this.backtracking(remain - candidates[i], comb, i, candidates, results);
            // backtrack, remove the number from the combination
            comb.removeLast();
        }
    }
}
