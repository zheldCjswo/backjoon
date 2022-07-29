import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_1260 {
    public static boolean check[];
    public static int arr[][];

    public static int number;

    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCaseFilePath = "D:\\JavaProject\\backjoon\\backjoon\\src\\BackJoon_1260_TestCase.txt";
        BufferedReader br = new BufferedReader(new FileReader(testCaseFilePath));

        StringTokenizer st = new StringTokenizer(br.readLine());

        number = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        int startNumber = Integer.parseInt(st.nextToken());

        //DFS
        arr = new int[number+1][number+1];
        check = new boolean[number+1];

        for(int i = 0; i < lineCount; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            arr[start][next] = 1;
            arr[next][start] = 1;
        }

        dfs(startNumber);
        System.out.println();

        Arrays.fill(check, false);

        q.add(startNumber);
        bfs();

    }

    private static void dfs(int startNumber) {
        check[startNumber] = true;
        System.out.print(startNumber + " ");
        for(int i = 1; i <= number; i++){
            if(arr[startNumber][i] == 1 && check[i] == false){
                dfs(i);
            }
        }
    }

    private static void bfs() {
        while(!q.isEmpty()){
            int now = q.poll();
            if(check[now] == false) {
                check[now] = true;
                System.out.print(now + " ");
                for(int i = 1; i <= number; i++){
                    if(arr[now][i] == 1 && check[i] == false){
                        q.add(i);
                    }
                }
            }
        }
    }
}
