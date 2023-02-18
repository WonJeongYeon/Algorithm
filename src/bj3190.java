import java.util.*;
import java.io.*;

public class bj3190 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //snake : 1, apple = 2, empty = 0
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        Deque<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{0, 0});
        board[0][0] = 1;

        int K = Integer.parseInt(br.readLine()); //사과
        for (int i = 0; i < K; i++) {
            int[] apple = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            board[apple[0] - 1][apple[1] - 1] = 2;
        }

        int L = Integer.parseInt(br.readLine()); //방향전환 입력
        int index = 0;
        int time = 0;
        Map<Integer, String> inputMap = new HashMap<>();
        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            int sec = Integer.parseInt(input[0]); //sec 초까지 앞으로 간 뒤
            String way = input[1]; //way 로 회전함
            inputMap.put(sec, way);
        }

        while (true) {
            time++;
            //기존 머리의 x, y 좌표
            int x = snake.peek()[0];
            int y = snake.peek()[1];

            switch (index) { //방향, 0 동쪽(기본값), 1 남쪽, 2 서쪽, 3 북쪽
                case 0:
                    snake.offerFirst(new int[]{x, ++y});
                    break;
                case 1:
                    snake.offerFirst(new int[]{++x, y});
                    break;
                case 2:
                    snake.offerFirst(new int[]{x, --y});
                    break;
                case 3:
                    snake.offerFirst(new int[]{--x, y});
                    break;
            }

            if (x < 0 || y < 0 || x >= N || y >= N) { //벽
                break;
            }

            if (board[x][y] == 2) { //사과
                board[x][y] = 1;
            } else if (board[x][y] == 1) { //몸에 부딪힘
                break;
            } else { //빈공간
                board[x][y] = 1;
                int[] tail = snake.removeLast();
                board[tail[0]][tail[1]] = 0; //꼬리 이동(제거)
            }
            try { //방향전환 할 때만
                if (inputMap.get(time).equals("L")) { //+90도
                    index -= 1;
                    if (index < 0) {
                        index += 4;
                    }
                } else if (inputMap.get(time).equals("D")) { //-90도
                    index += 1;
                    if (index > 3) {
                        index -= 4;
                    }
                }
            } catch (NullPointerException ignored) {
            }
        }
        bw.write(time + "");
        bw.flush();

    }

}
