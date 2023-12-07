import java.util.*;
import java.util.stream.*;

class Solution {
    Set<NumsClass> answer = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    public List<List<Integer>> threeSum(int[] nums) {
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        if(map.getOrDefault(0, 0) >= 3) answer.add(new NumsClass(0, 0, 0));
        for(int n1 : map.keySet()) {
            for(int n2 : map.keySet()) {
                if(n1 == n2) continue;
                addIfSumZero(n1, n2);
            }
        }
        return answer.stream().map(NumsClass::getList).collect(Collectors.toList());
    }
    public void addIfSumZero(int n1, int n2) {
        for(int i = 1 ; i <= map.get(n1) ; i++) {
            for(int j = 1 ; j <= map.get(n2) ; j++) {
                if(i + j == 3 && n1 * i + n2 * j == 0) addHaveSame(n1, n2, i, j);
                if(i + j == 2 && map.containsKey(-n1 - n2)) addAllDiff(n1, n2);
            }
        }
    }
    public void addHaveSame(int n1, int n2, int idx1, int idx2) {
        NumsClass list = new NumsClass();
        for(int k = 0 ; k < idx1 ; k++) list.getList().add(n1);
        for(int k = 0 ; k < idx2 ; k++) list.getList().add(n2);
        answer.add(list);
    }
    public void addAllDiff(int n1, int n2) {
        if(n1 * 2 + n2 == 0 || n2 * 2 + n1 == 0) return;
        answer.add(new NumsClass(n1, n2, -n1 - n2));
    }
}

class NumsClass {
    private List<Integer> list;
    public List<Integer> getList() {
        return list;
    }
    public NumsClass() {
        this.list = new ArrayList<>();
    }
    public NumsClass(int n1, int n2, int n3) {
        this.list = Arrays.asList(n1, n2, n3);
    }
    @Override
    public boolean equals(Object o) {
        NumsClass obj = (NumsClass) o;
        return this.list.equals(obj.list);
    }
    @Override
    public int hashCode() {
        Collections.sort(list);
        return list.hashCode();
    }
}