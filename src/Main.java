import com.tuling.chat.test.Chat;
import org.json.JSONObject;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JSONObject json;
        Chat chat = new Chat();
        Scanner sc = new Scanner(System.in);
        while (true) {
            json = chat.getReplay(sc.next());
            if (json.get("code") != null) {
                System.out.println("图灵机器人: " + json.get("text"));
            } else {
                System.out.println(json.toString());
            }
        }
    }
}
