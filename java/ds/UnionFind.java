package ds;

public class UnionFind {

    private int[] nodes;
    private int n;

    public UnionFind(int n) {
        this.n = n;
        this.nodes = new int[n];
        this.init();
    }

    private void init() {
        for(int i = 0; i < this.n; i++) {
            this.nodes[i] = i;
        }
    }

    public int find(int x) {
        if (x != nodes[x]) {
            return nodes[x] = find(nodes[x]);
        }
        return nodes[x];
    }

    public boolean union(int a, int b) {
        int p = find(a);
        int q = find(b);
        if (p == q) {
            return false;
        } else if (p < q) {
            nodes[q] = p;
        } else {
            nodes[p] = q;
        }
        return true;
    }
    
}
