/*
 * https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu


*
*3 3 10
7 2 9
6 6 6
5 5 7
*/
import java.util.Scanner;
public class Solution2115 {
	static class dfsyx{
		int y;
		int x;
	}
	static int T;
	static int N;
	static int M; //������ ��
	static int C; //���� ä���� �� �ִ� �ִ� ��
	static int map[][];
	static int amount[][];
	static int visit[][];
	static int result;
	static int totalAmount;
	static int curAmount1;
	static int curAmount2;
	static int maxM1;
	
	static void dfs(int y, int x){
		if(curAmount1+map[y][x] <= C){
			curAmount1 += map[y][x];
			totalAmount += map[y][x]*map[y][x];
			for(int i=1; i<M-x ; i++){
				dfs(y,x+i);
			}
		}else{
			if(result < totalAmount ) result = totalAmount;
			return;
		}
		
		
	}
	
	static int cal(int y1, int x1, int y2, int x2){
		maxM1 =N-x1;
		int maxM1 = N-x1;
		int maxM2 = N-x2;
		totalAmount = 0; 
		curAmount1=0;
		curAmount2=0;
		//�߰��� ���԰� ä�� ����
		//ù��°
			for(int i= 0 ; i< M; i++){ //���� �ִ뷮 ���ϱ�
				if(i>=maxM1) break; //������ �ʰ��ϸ� break
				visit[y1][x1+i] = 1;
			
			//dfs(y1,x1);
			
				if(curAmount1+map[y1][x1+i] <=C){ // �ִ� ���� �� �ִ� �纸�� ������
					curAmount1 +=map[y1][x1+i];
					totalAmount+= map[y1][x1+i]*map[y1][x1+i];
				}else break;
			}
		//	System.out.println(totalAmount);
		//�ι�°
				
				for(int i=0; i<M ; i++) {
					if(i>=maxM2) break;		
					if(visit[y2][x2+i] == 1 ) break;;
					if(curAmount2+map[y2][x2+i] <=C){
					curAmount2+=map[y2][x2+i];
					totalAmount += map[y2][x2+i]*map[y2][x2+i];
					}
				}
				return totalAmount;
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int tmpResult;
			result =0;
			N = scan.nextInt();
			M = scan.nextInt();
			C = scan.nextInt();
			map = new int[N][N];
			amount = new int[N][N];
			visit = new int[N][N];
			result =0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int i2 = 0; i2 < N; i2++) {
						for (int j2 = 0; j2 < N; j2++) {
						tmpResult = cal(i,j,i2,j2);
						if(result<tmpResult) result = tmpResult;
					if(tmpResult==146){
							System.out.println("-----------------");
							System.out.print(i+ " ");
							System.out.println(j);
							System.out.print(i2+ " ");
							System.out.println(j2);
						}
						}
					}
				}
			}
			//result = cal(0,0,0,0);
			//dfs(0,0);
			System.out.println("#"+tc+" "+result);
		}

	}

}