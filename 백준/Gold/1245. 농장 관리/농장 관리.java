import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] farm;
    static boolean[][] visited;
    static int[] dx={-1,-1,0,1,1,1,0,-1}; 
    static int[] dy={0,1,1,1,0,-1,-1,-1};
    static boolean top;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 
        farm = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && farm[i][j] != 0){
                    top = true;
                    dfs(i,j);
                    if(top) count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0;i<8;i++){ 
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(farm[x][y] < farm[nx][ny]){ 
                    top = false; 
                }if(!visited[nx][ny] && farm[nx][ny] == farm[x][y]){
                    dfs(nx,ny);
                }
            }
        }
    }

}