package codingTest;

import java.util.HashMap;
import java.util.Map;

public class Main02 {	//성격 유형 검사하기
	  /* getOrDefault : 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드 */
	  public String solution(String[] survey, int[] choices) {
		  String answer = "";
		  Map<Character, Integer> map = new HashMap<>();	//성격 유형별 점수

	        for(int i = 0; i< survey.length; i++) {
	        	int choice = choices[i]; 
	            /*choice 1~3이면 첫번째 유형*/
	            if(choice > 0 && choice < 4){	
	            	char ch = survey[i].charAt(0);
	                map.put(ch, map.getOrDefault(ch, 0) + 4 - choice); // 해당하는 유형 점수 넣기 ex) "AN" 유형의 choice가 3 이면 0+4-3 = 1 
	                System.out.println(ch + ":" + map.getOrDefault(ch, 0));
	           
	            /*choice 5~7이면 두번째 유형*/
	            } else if(choice > 4){ 		
	            	char ch = survey[i].charAt(1);
	            	map.put(ch, map.getOrDefault(ch, 0) + choice - 4); // 해당하는 유형 점수 넣기 ex) "AN" 유형의 choice가 5 이면 0+5-4 = 1 
	                System.out.println(ch + ":" + map.getOrDefault(ch, 0));
	            }
	        }
	        
	        //유형별 점수 출력
	        for(char key : map.keySet()) {
	            int value = (int) map.get(key);
	            System.out.println(key + " : " + value);
	        }

	        // 최종 결과 
	        answer += map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T';
	        answer += map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F';
	        answer += map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M';
	        answer += map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N';
	        
	        return answer;
	    }
	

	public static void main(String[] args) {
		Main02 h = new Main02();
		
		String[] survey = {"TR", "RT", "TR"};
		int [] choices = {7, 1, 3};
		
		System.out.println(h.solution(survey, choices));
	}



}
