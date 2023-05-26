package programmers.level1;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

// 전국 대회 선발고사
public class Pro00005 {

  /*
  각 학생들의 선발 고사 등수를 담은 정수 배열 rank와 전국 대회 참여 가능 여부가 담긴 boolean 배열 attendance가 매개변수로 주어집니다.
  전국 대회에 선발된 학생 번호들을 등수가 높은 순서대로 각각 a, b, c번이라고 할 때 10000 × a + 100 × b + c를 return 하는 solution 함수를 작성해 주세요.
   */

  public int solution(int[] rank, boolean[] attendance) {
    int answer = 0;
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    int third = Integer.MAX_VALUE;
    int firstidx =0;
    int secondidx =0;
    int thirdidx =0;

    for(int i =0; i<rank.length; i++){
      if(first>rank[i]&& attendance[i]) {
        first = rank[i];
        firstidx= i;
      }
    }
    for(int i =0; i<rank.length; i++){
      if(rank[i]!=first) {
        if (second > rank[i] && attendance[i]) {
          second = rank[i];
          secondidx =i;
        }
      }
    }
    for(int i =0; i<rank.length; i++){
      if(rank[i]!=first&&rank[i]!=second) {
        if (third > rank[i] && attendance[i]) {
          third = rank[i];
          thirdidx =i;
        }
      }
    }

    answer = firstidx*10000 + 100*secondidx + thirdidx;
    return answer;
  }

  // 스트림 쓰는방법
  public int solution2(int[] rank, boolean[] attendance) {
    return IntStream.range(0, rank.length)
        .filter(i -> attendance[i])
        .boxed()
        .sorted(Comparator.comparing(i -> rank[i]))
        .limit(3L)
        .reduce((current, next) -> current * 100 + next)
        .get();
  }

  public static void main(String[] args) {
    int[] a = {3, 7, 2, 5, 4, 6, 1};
    boolean[] b = {false, true, true, true, true, false, false};

    Pro00005 pro00005 = new Pro00005();
    pro00005.solution(a, b);
  }

}
