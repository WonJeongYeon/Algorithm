import java.util.*;

public class bj25401 {

    public static void main(String[] args) {

    }
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        Map<String, String> musicTable = new HashMap<>();
        for (String s: musicinfos) {
            String[] info = s.split(",");
            int start = Integer.parseInt(info[0].split(":")[0])*60+Integer.parseInt(info[0].split(":")[1]);
            int end = Integer.parseInt(info[1].split(":")[0])*60+Integer.parseInt(info[1].split(":")[1]);
            int time = end-start;
            int re = time/info[3].length();
            int sub = time % info[3].length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<re; i++) {
                sb.append(info[3]);
            }
            sb.append(info[3].substring(0, sub));
            musicTable.put(info[2], sb.toString());
        }
        System.out.println(musicTable);
        for (Map.Entry<String, String> entry: musicTable.entrySet()) {
            if (entry.getValue().contains(m)) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}