import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] W;
    static int[][] dp;
    static final int INF = 1_000_000_0; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int size = 1 << N;
        dp = new int[size][N];
        for(int i=0;i<size;i++){
            Arrays.fill(dp[i], INF);
        }

        dp[1][0] = 0; 

        for(int visited=1; visited<size; visited++){
            for(int last=0; last<N; last++){
                if(dp[visited][last] == INF) continue;

                for(int next=0; next<N; next++){
                    if((visited & (1<<next)) != 0) continue; 
                    if(W[last][next] == 0) continue;

                    int nextVisited = visited | (1<<next);
                    dp[nextVisited][next] = Math.min(dp[nextVisited][next], dp[visited][last] + W[last][next]);
                }
            }
        }

        int ans = INF;
        int ALL_VISITED = (1<<N) - 1;
        for(int i=1;i<N;i++){
            if(W[i][0] != 0){
                ans = Math.min(ans, dp[ALL_VISITED][i] + W[i][0]);
            }
        }
        System.out.println(ans);
    }
}
