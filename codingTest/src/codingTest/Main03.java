package codingTest;

import java.util.HashMap;

public class Main03 {	// 대충 만든 자판
	
	  public int[] solution(String[] keymap, String[] targets) {
		  
		  int[] answer = new int[targets.length];
		  HashMap<Character, Integer> keypad = new HashMap();
		  
		  /*keymap에 있는 알파벳의 최소 클릭 수를 keypad(HashMap)에 담기*/
		  for(int i = 0; i<keymap.length; i++) {
			  for(int j = 0; j<keymap[i].length(); j++) {
				  char key = keymap[i].charAt(j); 	// keymap의 key 값 빼오기
				  if(keypad.containsKey(key)) {		// keypad에 이미 해당 key값이 존재한다면
					   int click = keypad.get(key);
					   	/*최소 클릭 수를 구하기 위해 index 비교*/
	                    if (click > (j+1)){
	                    	keypad.put(key,j+1); 
	                    }
				  } else {
					  keypad.put(key,j+1);
				  }
			  }
		  }
	 
		 /*target의 문자열의 알파벳의 클릭수를 구해서 계산*/
		for(int i = 0; i<targets.length; i++) {
			  int nCnt = 0;
			 
			  for(int j = 0; j<targets[i].length(); j++) {
				  char str = targets[i].charAt(j);
				  if(!keypad.containsKey(str)) {	// 알파벳이 keypad에 존재하지 않으면 -1
					  nCnt = -1;
					  break;
				  } else {
					  nCnt += keypad.get(str);
				  }
			  }
			  answer[i] = nCnt;
		  }
		  return answer;
	  }

	  public static void main(String[] args) {
			Main03 h = new Main03();
			
			String[] keymap = {"AGZ", "BSSS"}; 
			String [] targets = {"ASA","BGZ"}; 
			
			for(int i : h.solution(keymap, targets)) {
				System.out.println(i);
			}

	  }

}
