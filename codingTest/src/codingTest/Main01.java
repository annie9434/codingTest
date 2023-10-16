package codingTest;

public class Main01 {//크레인 인형 뽑기
	
    public int solution(int[][] board, int[] moves) {
		int answer = 0;


		return answer;
	}

	public static void main(String[] args) {
		Main01 h = new Main01();
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(h.solution(board, moves));
		
	}

}
