package ds;

public class UnionFind {

    private int[] nodes;

    public UnionFind(int n) {
        this.nodes = new int[n];
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
