import java.util.*;

class Solution {
    static int n;
    static int[][] gameBoard, table;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] game_board, int[][] table) {
        Solution.gameBoard = game_board;
        Solution.table = table;
        n = game_board.length;
        visited = new boolean[n][n];

        List<List<int[]>> emptyShapes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && gameBoard[i][j] == 0) {
                    List<int[]> shape = bfs(i, j, 0, gameBoard);
                    emptyShapes.add(PuzzleUtil.normalize(shape));
                }
            }
        }

        visited = new boolean[n][n]; 
        List<List<int[]>> puzzleShapes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && table[i][j] == 1) {
                    List<int[]> shape = bfs(i, j, 1, table);
                    puzzleShapes.add(shape);
                }
            }
        }

        boolean[] used = new boolean[puzzleShapes.size()];
        int answer = 0;

        for (List<int[]> empty : emptyShapes) {
            for (int i = 0; i < puzzleShapes.size(); i++) {
                if (used[i]) continue;

                List<List<int[]>> rotations = PuzzleUtil.allRotations(puzzleShapes.get(i));
                boolean matched = false;
                for (List<int[]> rot : rotations) {
                    if (isSameShape(empty, rot)) {
                        answer += rot.size();
                        used[i] = true;
                        matched = true;
                        break;
                    }
                }
                if (matched) break;
            }
        }

        return answer;
    }
    
    private static List<int[]> bfs(int x, int y, int target, int[][] board) {
        List<int[]> shape = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            shape.add(new int[]{cx, cy});

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && !visited[nx][ny] && board[nx][ny] == target) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return shape;
    }

    private static boolean isSameShape(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
}

class PuzzleUtil {

    public static List<int[]> normalize(List<int[]> shape) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] p : shape) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        List<int[]> normalized = new ArrayList<>();
        for (int[] p : shape) {
            normalized.add(new int[]{p[0] - minX, p[1] - minY});
        }

        normalized.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return normalized;
    }

    public static List<int[]> rotate90(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : shape) {
            rotated.add(new int[]{p[1], -p[0]});
        }
        return normalize(rotated); 
    }

    public static List<int[]> rotate180(List<int[]> shape) {
        return rotate90(rotate90(shape));
    }

    public static List<int[]> rotate270(List<int[]> shape) {
        return rotate90(rotate180(shape));
    }

    public static List<List<int[]>> allRotations(List<int[]> shape) {
        List<List<int[]>> rotations = new ArrayList<>();
        rotations.add(normalize(shape));
        rotations.add(rotate90(shape));
        rotations.add(rotate180(shape));
        rotations.add(rotate270(shape));
        return rotations;
    }
}
