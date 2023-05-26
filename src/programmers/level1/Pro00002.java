package programmers.level1;

import java.util.Arrays;

//주사위 게임 3
public class Pro00002 {
  /*
  네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.

주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.


   */
  public int solution(int a, int b, int c, int d) {

    int[] dice = { a, b, c, d };
    Arrays.sort(dice);

    int ans = 0;

    if (dice[0] == dice[3]) {
      ans = 1111 * dice[3];
    } else if (dice[0] == dice[2] || dice[1] == dice[3]) {
      ans = (int) Math.pow(dice[1] * 10 + (dice[0] + dice[3] - dice[1]), 2);
    } else if (dice[0] == dice[1] && dice[2] == dice[3]) {
      ans = (dice[0] + dice[3]) * (dice[3] - dice[0]);
    } else if (dice[0] == dice[1]) {
      ans = dice[2] * dice[3];
    } else if (dice[1] == dice[2]) {
      ans = dice[0] * dice[3];
    } else if (dice[2] == dice[3]) {
      ans = dice[0] * dice[1];
    } else {
      ans = dice[0];
    }

    return ans;
  }

}
