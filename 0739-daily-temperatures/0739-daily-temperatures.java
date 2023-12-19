class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<Integer> monoStack = new Stack<>(); // 내림차순 모노토닉 스택

        for(int i = 0; i < temperatures.length; i++){
            while (!monoStack.isEmpty() &&  temperatures[monoStack.peek()] < temperatures[i]){
                int day = monoStack.pop();
                answer[day] = i - day;
            }

            monoStack.push(i);
        }
     
        return answer;
    }
}