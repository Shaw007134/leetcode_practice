import java.util.Arrays;

class boatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        // wrong solution, one boat can only seat two person
        int start = 0;
        int end = people.length - 1;
        int count = 0;
        Arrays.sort(people);
        while(start <= end){
            if(people[end] == limit){
                count++;
                end--;
            }else{
                int cur = people[end];

                while(limit - cur >= people[start]){
                    cur += people[start++];
                    if(start >= end) break;
                }

                if(cur <= limit){
                    count++;
                    end--;
                }
            }
        }

        return count;
    }

    public int numsCount(int[] people, int limit){
        Arrays.sort(people);
        int start = 0, end = people.length - 1;

        int count = 0;

        while(start <= end){
            if(people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            count++;
        }
        return count;
    }
}
