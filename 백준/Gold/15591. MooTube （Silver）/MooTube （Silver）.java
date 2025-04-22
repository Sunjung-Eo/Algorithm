import java.util.*;

public class Main {
    static class Edge {
        int u, v, uso;

        Edge(int u, int v, int uso) {
            this.u = u;
            this.v = v;
            this.uso = uso;
        }
    }

    static int[] parent, size;
    static List<Edge> edges;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        parent = new int[N + 1];
        size = new int[N + 1];
        edges = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            edges.add(new Edge(p, q, r));
        }

        edges.sort((e1, e2) -> Integer.compare(e2.uso, e1.uso));

        List<int[]> queries = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();
            queries.add(new int[]{k, v, i});
        }

        queries.sort((q1, q2) -> Integer.compare(q2[0], q1[0]));

        int[] answer = new int[Q];
        int edgeIndex = 0;

        for (int[] query : queries) {
            int k = query[0];
            int v = query[1];
            int idx = query[2];

            while (edgeIndex < edges.size() && edges.get(edgeIndex).uso >= k) {
                Edge edge = edges.get(edgeIndex++);
                union(edge.u, edge.v);
            }

            int rootV = find(v);
            answer[idx] = size[rootV] - 1;  
        }

        for (int ans : answer) {
            System.out.println(ans);
        }

        sc.close();
    }
}

