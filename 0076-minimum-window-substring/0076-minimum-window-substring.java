class Solution {
    /*

        백트래킹 탈출 조건
            - sum >= target
                - target == sum, add val to list

        for 조건
            - 동일한 숫자 사용 x이므로 i = 최근 사용되었던 index + 1

        아이디어
            1. s의 길이보다 t의 길이가 크면 empty를 반환한다.
            2. HashMap을 생성후 right인덱스를 증가시키며 s를 탐색한다
            3. 탐색한 요소가 t에 있는 요소이면 Hashmap에 넣고 freq를 1증가 시킨다.
            4. HashMap의 크기가 t의 길이보다 작다면 2,3을 반복한다.
            5. min 값을 업데이트 시켜준다.
            6. left 값을 증가시켜주면서 hashmap의 freq를 감소시키고, 만약 freq가 0이면 hashmap을 삭제시켜준다.
            7. hashmap의 크기가 t의 길이와 같다면 5, 6을 반복한다.
            8 min 값을 반환한다.
        자료구조
            슬라이딩 윈도우

        시간복잡도
            O(2*N) = 2 * 10^5 < 1 * 10^8

     */

    private boolean check(HashMap<Character, Integer> sFreq, HashMap<Character, Integer> tFreq){
        if(sFreq.size() != tFreq.size()){
            return false;
        }

        for(Character c : tFreq.keySet()){
            if(sFreq.get(c) < tFreq.get(c)){
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        HashMap<Character, Integer> tFreq = new HashMap<>();
        HashMap<Character, Integer> freq = new HashMap<>();
        int left, right, min, minLeft, minRight;

        left = right = minLeft = minRight = 0;
        min = Integer.MAX_VALUE;

        for(int i = 0; i < t.length(); i++){
            tFreq.put(t.charAt(i), tFreq.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (right < s.length()){
            if(!check(freq, tFreq)){
                char rightC = s.charAt(right);

                if(tFreq.containsKey(rightC)){
                    freq.put(rightC, freq.getOrDefault(rightC,0) + 1);
                }

                right += 1;
            }

            while (left <= right && check(freq, tFreq)){
                if(min > right - left){
                    minRight = right;
                    minLeft = left;
                    min = minRight - minLeft;
                }
                char leftC = s.charAt(left);

                if(freq.containsKey(s.charAt(left))){
                    freq.put(leftC, freq.get(leftC) - 1);

                    if(freq.get(leftC) == 0){
                        freq.remove(leftC);
                    }
                }

                left += 1;
            }
        }

        return s.substring(minLeft, minRight);
    }
}