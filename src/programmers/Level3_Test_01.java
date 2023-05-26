package programmers;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Level3_Test_01 {

  static int MAX = (int) 1e5;

  public int solution(int n, int[] cores) {
    int MAX = (int) 1e5;
    // task가 core수보다 작을 경우
    if (n <= cores.length) {
      return n;
    }
    int size = cores.length;
    int minCore = MAX;
    int maxCore = 0;

    for (int core : cores) {
      minCore = min(minCore, core);
      maxCore = max(maxCore, core);
    }

    int left = minCore * (n / size);
    int right = maxCore * n;

    while (left <= right) {
      int mid = (left + right) / 2;
      int workCnt = size;
      int curWorkCnt = 0;

      for (int core : cores) {
        workCnt += (mid / core);

        if (mid % core == 0) {
          workCnt--;
          curWorkCnt++;
        }
      }

      int sum = workCnt + curWorkCnt;

      if (workCnt >= n) {
        right = mid - 1;
      } else if (sum < n) {
        left = mid + 1;
      } else {
        for (int i = 0; i < size; i++) {
          if (mid % cores[i] == 0) {
            workCnt++;
          }

          if (workCnt == n) {
            return i + 1;
          }
        }
      }
    }

    return 0;
  }
}
