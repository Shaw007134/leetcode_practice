public class friendsOfAges {

    public static int findFriends(int[] ages){
        int max_age = 120, res = 0;
        int[] count = new int[max_age + 1], sum = new int[max_age + 1];
        for (int age : ages) {
            count[age]++;
        }
        for (int i = 1; i <= max_age; i++) {
            sum[i] = sum[i - 1] + count[i];
        }
        for (int i = 15; i <= max_age; i++) {
            res += count[i] * (sum[Math.min(max_age, 2*i -15)] - sum[i - 1] - 1);
        }
        return res;
    }
}
