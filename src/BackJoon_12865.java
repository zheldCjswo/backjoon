import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BackJoon_12865 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String testCaseFilePath = "D:\\JavaProject\\backjoon\\backjoon\\src\\BackJoon_12865_TestCase.txt";
        BufferedReader br = new BufferedReader(new FileReader(testCaseFilePath));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalCnt = Integer.parseInt(st.nextToken());
        int weightCnt = Integer.parseInt(st.nextToken());

        int dp[][] = new int[totalCnt+1][weightCnt+1];
        int weight[] = new int[totalCnt+1];
        int value[] = new int[totalCnt+1];

        for(int i = 1; i <= totalCnt; i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= totalCnt; i++) {
            for(int j = 1; j <= weightCnt; j++) {
                if(weight[i] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
            }
        }

        System.out.println(dp[totalCnt][weightCnt]);
    }
}
