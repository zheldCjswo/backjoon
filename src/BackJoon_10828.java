import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BackJoon_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String testCaseFilePath = "D:\\JavaProject\\backjoon\\backjoon\\src\\BackJoon_10828_TestCase.txt";
        //BufferedReader br = new BufferedReader(new FileReader(testCaseFilePath));

        int totalCnt = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        //System.out.println(totalCnt);
        StringTokenizer st;

        for (int i = 0; i < totalCnt; i++) {
            String inputString = String.valueOf(br.readLine());
            st = new StringTokenizer(inputString);

            String action = st.nextToken();
            int value = 0;
            if ("push".equals(action)) {
                value = Integer.parseInt(st.nextToken());
                stack.add(value);
            } else if ("pop".equals(action)) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            } else if ("size".equals(action)) {
                System.out.println(stack.size());
            } else if ("empty".equals(action)) {
                if (stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if ("top".equals(action)) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
