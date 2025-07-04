import java.util.*;

public class CourseSelection {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course); // edge: prereq -> course
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int completed = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            completed++;
            for (int next : adj.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }

        return completed == numCourses;
    }
}
