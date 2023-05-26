package programmers.level1;


import java.util.ArrayList;
import java.util.List;


//배열 만들기 2
public class Pro00004 {

  public int[] solution(int l, int r) {

    List<Integer> list = new ArrayList<>();
    for (int i = l; i <= r; i++) {
      if (checkNum(i)) {
        list.add(i);
      }
    }
    int[] answer = list.stream().mapToInt(t -> t).toArray();
    if(answer.length==0){
      return new int[]{-1};
    }
    return answer;
  }

  public boolean checkNum(int num) {
    String str = String.valueOf(num);
    if (str.contains("1") || str.contains("2") || str.contains("3") || str.contains("4")
        || str.contains("6") || str.contains("7") || str.contains("8") || str.contains("9")) {
      return false;
    } else {
      return true;
    }
  }
}
