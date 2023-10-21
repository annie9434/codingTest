package codingTest;

import java.util.Stack;

public class Main01 {//크레인 인형 뽑기
	
    public int solution(int[][] board, int[] moves) {
		// 제거된 인형의 수
    	int answer = 0;
    	// 인형이 담길 stack 바구니
    	Stack<Integer> stack = new Stack<>();
    	
    	// java.util.EmptyStackException 방지용 (empty() 사용해도 될듯..?)
    	stack.push(0);
    
    	for(int move : moves) {// board의 행(move)
    		for(int j = 0; j < board.length; j++) { // board의 열 
    			if(board[j][move-1] != 0) { // board가 비어있지 않을 때
    				
    				// 바구니의 인형과 크레인의 인형이 같을 때
    				if(board[j][move-1] == stack.peek()) {
    					stack.pop();			// 바구니의 인형 제거
    					board[j][move-1] = 0;	// board의 인형 제거
    					answer += 2; 			// 제거된 인형의 수
    					break; 					// 크레인이 인형을 잡고나면 해당 열을 탐색할 필요가 없기 때문에 반복문 종료   
    				
    				// 바구니의 인형과 크레인의 인형이 같지 않을 때	
    				} else {
    					stack.push(board[j][move-1]);	// 바구니에 인형 담기
    					board[j][move-1] = 0;			// board의 인형을 제거
    					break; 							// 크레인이 인형을 잡고나면 해당 열을 탐색할 필요가 없기 때문에 반복문 종료
    				}
    				
    			}
    		}
    	}
		return answer;
	}

	public static void main(String[] args) {
		Main01 h = new Main01();
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(h.solution(board, moves));
		
	}

}
