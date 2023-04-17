
import java.util.*;

//https://www.acmicpc.net/problem/25402
//정올 2022 2차 2번문제
public class bj25402_VCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] tree = new int[n+1][n+1];

        for(int i = 1; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a][b] = 1;
            tree[b][a] = 1;

        }

        int q = sc.nextInt();
        ArrayList<Integer> arrlist = new ArrayList<>();

        for(int i = 0; i<q; i++){
            int k = sc.nextInt();
            arrlist.clear();
            for(int j = 1; j<=k; j++){
                int l = sc.nextInt();
                arrlist.add(l);
            }
            solution(tree,q,arrlist,n);
        }

    }

    public static void solution(int[][] tree, int q,ArrayList<Integer> arrlist, int treesize){
        int ans = 0;
        for(int i = 0; i<q; i++){
            ans = 0;
            for(int j : arrlist){
                ans +=findTree(tree, j, 0 , arrlist);
            }
        }
        System.out.println(ans/2);
    }

    public static int findTree(int[][] tree, int a, int n , ArrayList<Integer> arrlist) {
        int ans = 0;
        for(int i = 1; i<=tree.length; i++){
            if(i == n )continue;
            if(!arrlist.contains(i)) continue;
            if(arrlist.size() == 1 ) return 0;
            if(tree[a][i] == 1){
                ans++;
                ans += findTree(tree, i, a, arrlist);
            }
        }
        return ans;
    }
}