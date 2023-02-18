import java.util.*;

public class bj1107_ing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String channel = scanner.nextLine();
        int count = scanner.nextInt();
        scanner.nextLine();
        String[] brokenButton = scanner.nextLine().split(" ");
        List<String> brokenList = new ArrayList<>(Arrays.asList(brokenButton));
        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (String s : brokenList) {
            if (channel.contains(s)) {
                list.add(channel.indexOf(s));
            }
        }
        int channelNum = Integer.parseInt(channel);
        if (list.isEmpty()) {
            result = channel.length();
        } else {
            while (!list.isEmpty()) {
                
                list.clear();
            }
        }


        System.out.println(result);


    }
}