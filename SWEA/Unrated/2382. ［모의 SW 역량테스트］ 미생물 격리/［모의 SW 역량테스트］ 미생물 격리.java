import java.io.*;
import java.util.*;

public class Solution {
    static int n; // map 크기
    static int m; // 시간
    static int k; // 미생물 군집 수
    static List<Community>[][] map;
    static int[] vecR = {0, -1, 1, 0, 0}; 
    static int[] vecC = {0, 0, 0, -1, 1}; 
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().trim().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);
            
            result = 0;
            map = new ArrayList[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }

            for (int i = 0; i < k; i++) {
                input = br.readLine().trim().split(" ");
                int r = Integer.parseInt(input[0]);
                int c = Integer.parseInt(input[1]);
                int num = Integer.parseInt(input[2]);
                int vector = Integer.parseInt(input[3]);
                map[r][c].add(new Community(num, vector));
            }

            dfs(0);           

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (Community community : map[i][j]) {
                        result += community.num;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int time) {
    	if (time == m) return;
    	
        List<Community>[][] newMap = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMap[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (Community community : map[i][j]) {
                    int nr = i + vecR[community.vector];
                    int nc = j + vecC[community.vector];

                    if (nr == 0 || nr == n - 1 || nc == 0 || nc == n - 1) {
                        community.num /= 2;
                        if (community.vector % 2 == 0) community.vector -= 1;
                        else community.vector += 1;
                    }

                    if (community.num > 0) {
                        newMap[nr][nc].add(community);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (newMap[i][j].size() > 1) {
                    int maxNum = 0;
                    int sumNum = 0;
                    int newVector = 0;

                    for (Community community : newMap[i][j]) {
                        sumNum += community.num;
                        if (community.num > maxNum) {
                            maxNum = community.num;
                            newVector = community.vector;
                        }
                    }
                    newMap[i][j].clear(); 
                    newMap[i][j].add(new Community(sumNum, newVector)); 
                }
            }
        }
        map = newMap;
        dfs(time + 1);
    }

    static class Community {
        int num;
        int vector;

        public Community(int num, int vector) {
            this.num = num;
            this.vector = vector;
        }
    }
}
