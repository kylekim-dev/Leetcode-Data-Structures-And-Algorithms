import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Program {
    public static void main(String[] args){
        int n = 5;
        int k = 3;
        System.out.println(findShortestTime(n, k));
    }
    public static int findShortestTime(int n, int k){
        int depth = 0;

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        queue.add(n);

        while(!queue.isEmpty()){
            int position = queue.remove();

            if(position == k){
                break;
            }

            if(set.contains(position)){
                continue;
            }

            set.add(position);

            int child1 = position - 1;
            int child2 = position + 1;
            int child3 = position * 2;

            if(!set.contains(child1)){
                queue.add(child1);
            }

            if(!set.contains(child2)){
                queue.add(child2);
            }

            if(!set.contains(child3)){
                queue.add(child3);
            }

            depth++;
        }
        int c = 0;
        while(depth > 0){
            depth /= 3;
            c++;
        }

        return c;
    }
}