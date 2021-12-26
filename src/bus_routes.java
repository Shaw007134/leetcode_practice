import java.awt.*;
import java.util.*;
import java.util.List;

class bus_routes {

    public int numBuses(int [][] routes, int source, int target){
        if(source == target) return 0;
        int N = routes.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList<>());
        }
        Set<Integer> seen = new HashSet();
        Set<Integer> targets = new HashSet();
        Deque<Point> queue = new ArrayDeque<>();

        // Build the graph, two buses are connected if they share at least one bus stop
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(intersect(routes[i], routes[j])){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        // Initialize seen, queue, targets
        for (int i = 0; i < N; i++) {
            if(Arrays.binarySearch(routes[i], source) >= 0){
                seen.add(i);
                queue.offer(new Point(i, 0));
            }
            if(Arrays.binarySearch(routes[i], target) >= 0){
                targets.add(i);
            }
        }

        while (!queue.isEmpty()){
            Point info = queue.poll();
            int node = info.x, depth = info.y;
            if(targets.contains(node)) return depth + 1;
            for(Integer next: graph.get(node)){
                if(!seen.contains(next)){
                    seen.add(next);
                    queue.offer(new Point(next, depth + 1));
                }
            }
        }
        return -1;
    }

    private boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            if(A[i] == B[j]) return true;
            if(A[i] < B[j]) i++; else j++;
        }
        return false;
    }
}
