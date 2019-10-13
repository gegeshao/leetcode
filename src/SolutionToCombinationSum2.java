import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionToCombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        nowAnswers(res,candidates,target,new ArrayList<>(),0);
        return res;
    }

    public void nowAnswers(List<List<Integer>> res, int[] candidates, int target,
                           List<Integer> tempList, int index) {
        if (target == 0) {
            if(!res.contains(tempList))
                res.add(tempList);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i]<=target) {
                List<Integer> list=new ArrayList<>(tempList);
                list.add(candidates[i]);
                nowAnswers(res,candidates,target-candidates[i],list,i + 1);
            } else {
                break;
            }
        }
    }
}
