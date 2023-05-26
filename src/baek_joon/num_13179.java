package baek_joon;

import java.util.Scanner;

public class num_13179 {

  static int MAXN = 1005;
  static int mod = 1000000007;
  static int n, k;
  static int[] f = new int[MAXN];
  static int[] inv = new int[MAXN];
  static int[][][] dp = new int[MAXN][MAXN][2];
  static int[][] sum = new int[MAXN][MAXN];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();

    init();

    for (int i = 1; i <= n; i++) {
      work(i);
    }

    solve();
  }

  public static void init() {
    f[0] = inv[0] = 1;
    for (int i = 1; i <= n; i++) {
      f[i] = (int) ((long) f[i - 1] * i % mod);
      inv[i] = (int) pow(f[i], mod - 2, mod);
    }
  }

  public static int pow(long a, int b, int p) {
    int ans = 1 % p;
    for (; b > 0; b >>= 1) {
      if ((b & 1) == 1) {
        ans = (int) ((long) ans * a % p);
      }
      a = a * a % p;
    }
    return ans;
  }

  public static void work(int x) {
    int[] cnt = new int[2];
    for (int i = 1; i <= k; i++) {
      if (x % 2 == 1) {
        cnt[1]++;
      } else {
        cnt[0]++;
      }
      x = (x + n / 2) % n + 1;
    }
    if (cnt[0] > cnt[1]) {
      cnt[0] = n / 2 - cnt[0] + cnt[1];
    }

    dp[cnt[0]][cnt[1]][0] = 1;
  }

  public static void solve() {
    for (int i = n / 2; i >= 0; i--) {
      for (int j = n / 2; j >= 0; j--) {
        for (int k = 0; k <= 1; k++) {
          sum[i][j] = (sum[i][j] + dp[i][j][k]) % mod;
          if (i > 0) {
            dp[i - 1][j][k] = (int) ((dp[i - 1][j][k] + (long) dp[i][j][k] * i % mod * inv[i + j])
                % mod);
          }
          if (j > 0) {
            dp[i][j - 1][k] = (int) ((dp[i][j - 1][k] + (long) dp[i][j][k] * j % mod * inv[i + j])
                % mod);
          }
          dp[i][j][k ^ 1] = (int) (
              (dp[i][j][k ^ 1] + (long) dp[i][j][k] * (n / 2 - i - j) % mod * inv[i + j]) % mod);
        }
      }
    }

    for (int i = 0; i <= n / 2; i++) {
      System.out.println((long) sum[i][n / 2 - i] * f[i] % mod);
    }
  }
}

