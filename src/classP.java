import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class classP {

    public int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String answer;

        int N;
        try {
            N = Integer.parseInt(str.split(" ")[0]);
        } catch (NumberFormatException e) {
            answer = "잘못된 입력입니다. 다시 시도해 주세요.";
            System.out.println(answer);
            N = input();
        }
        return N;
    }

    public String option(int N) {
        switch (N) {
            case 0: return "취소";
            case 1: return "통화연결";
            case 2: return "수신거부";
            case 3: return "착신전환";
            case 4: return "통화 보류";
            default: return "에러";
        }
    }

}
