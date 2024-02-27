package labuladong.ConnectingCitiesWithMinimumCost1135;

import java.util.Arrays;

// 也可以算作最小生成树问题, Kruskal algorithm
public class Solution1 {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        int result = 0;
        for(int i = 0; i < connections.length; i++) {
            if(uf.isConnect(connections[i][0] - 1, connections[i][1] - 1)) {
                continue;
            }
            result += connections[i][2];
            uf.union(connections[i][0] - 1, connections[i][1] - 1);
        }

        if(uf.count != 1) {
            return -1;
        } else {
            return result;
        }
    }
}

class UnionFind {
    int count;
    int[] parents;

    public UnionFind(int count) {
        this.count = count;
        parents = new int[count];

        for(int i = 0; i < count; i++) {
            parents[i] = i;
        }
    }

    public int find(int p) {
        if(parents[p] != p) {
            parents[p] = find(parents[p]);
        }
        return parents[p];
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) {
            return;
        }
        count--;
        parents[pRoot] = qRoot;
    }

    public boolean isConnect(int p, int q) {
        return find(p) == find(q);
    }
}