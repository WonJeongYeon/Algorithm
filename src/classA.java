import java.io.IOException;

public class classA {

    public static void main(String[] args) throws IOException {
        classP classP = new classP();
        int N = classP.input();

        option(N);
    }

    public static void option(int N) throws IOException {
        classP classP = new classP();
        System.out.println("입력하신 값은 " + N + "입니다.");
        String option = classP.option(N);
        if (option.equals("에러")) {
            System.out.println("다시 시도해 주세요.");
            N = classP.input();
            option(N);
        } else if (option.equals("취소")) {
            System.out.println("취소하셨습니다.");
            return;
        } else {
            System.out.println("선택하신 옵션은 " + option + "입니다.");
        }
    }

}
