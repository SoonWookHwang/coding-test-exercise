package programmers.level1;


import java.util.Arrays;

//배열 조각하기
public class Pro00001 {
  public int[] solution(int[] arr, int[] query) {

    for(int i=0; i<query.length; i++){
      int a = query[i];
      if(a%2==0){
        arr = Arrays.copyOfRange(arr, 0, a+1);
      }
      if(a%2==1){
        arr = Arrays.copyOfRange(arr, a, arr.length);
      }
    }
    return arr;
  }

  public static void main(String[] args) {
      Pro00001 a = new Pro00001();
      int[] b = a.solution(new int[]{,}, new int[]{4, 1, 2,12,5,6,1,2});
    System.out.println(Arrays.toString(b));
  }

}
