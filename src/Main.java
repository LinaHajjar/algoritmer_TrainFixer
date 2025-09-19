import java.util.*;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] edges = new int[m][2];

        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            train_Fixer.buildGraphWithoutEdge(edges, i);
            if (train_Fixer.isStronglyConnected()) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(-1);
    }
