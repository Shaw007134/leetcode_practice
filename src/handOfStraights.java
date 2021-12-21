import java.util.Arrays;
import java.util.HashMap;

class handOfStraights {
    public boolean isNStraightHand(int[] hand, int gs){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if(map.containsKey(hand[i])){
                for (int j = 0; j < gs; j++) {
                    int curr = hand[i] + j;
                    if(map.containsKey(curr)){
                        map.put(curr, map.get(curr) - 1);
                        if(map.get(curr) == 0){
                            map.remove(curr);
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        return map.size() == 0;
    }
}
