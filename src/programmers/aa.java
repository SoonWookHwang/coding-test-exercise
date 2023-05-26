package programmers;

import java.util.Arrays;


public class aa {

  public int[][] solution(int n) {
    int[][] answer = new int[n+2][n+2];
    //2
    int dir = 0;
    int garolimit = n + 1 ;
    int serolimit = n + 1;
    int reversegaro = 1;
    int reversesero = 2;
    int i = 1;
    int j = 1;

    for (int k = 1; k <= n * n; k++) {  //   16
      answer[i][j] = k;
      if (dir % 4 == 0) {
        j++;
        if (j == garolimit) {
          j--;
          dir += 1;
          garolimit--;
        }
      }

      if (dir % 4 == 1) {  //아래  j ==2
        i++;                // 0 1 2
        if (i == serolimit) {
          i--;
          dir+=1;
          serolimit -= 1;
        }
      }
      if (dir % 4 == 2) {     //왼쪽
        j--;
        if (j == reversegaro-1) {
          j++;
          dir+=1;
          reversegaro++;
        }
      }
      if (dir % 4 == 3) {    //위
        i--;
        if (i == reversesero) {
          dir+=1;
          reversesero++;
        }
      }
    }
    int[][] newanswer = new int[n][n];
      for(int l = 0; l<n; l++){
        for(int m = 0; m<n; m++){
          newanswer[l][m] = answer[l+1][m+1];
        }
      }
      return newanswer;
    }


  public static void main(String[] args) {
    aa a = new aa();
    System.out.println(Arrays.toString(a.solution(5)[0]));
    System.out.println(Arrays.toString(a.solution(5)[1]));
    System.out.println(Arrays.toString(a.solution(5)[2]));
    System.out.println(Arrays.toString(a.solution(5)[3]));
    System.out.println(Arrays.toString(a.solution(5)[4]));

  }
}
