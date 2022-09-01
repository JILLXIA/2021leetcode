package OA.Amazon.UserSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static List<String> implementAPI(List<String> logs){
        HashMap<String, String> userNameToPassword = new HashMap<>();
        HashSet<String> login = new HashSet<>();
        List<String> result = new ArrayList<>();
        for(String log: logs){
            String[] parse = log.split(" ");
            if(parse[0].equals("register")){
                if(userNameToPassword.containsKey(parse[1])){
                    result.add("Username already exists");
                } else{
                    userNameToPassword.put(parse[1],parse[2]);
                    result.add("Registered Successfully");
                }
            } else if(parse[0].equals("login")){
                if(userNameToPassword.containsKey(parse[1])){
                    if(userNameToPassword.get(parse[1]).equals(parse[2]) && !login.contains(parse[1])){
                        result.add("Logged In Successfully");
                        login.add(parse[1]);
                    } else {
                        result.add("Login Unsuccessful");
                    }
                }

            } else if(parse[0].equals("logout")){
                if(userNameToPassword.containsKey(parse[1]) && login.contains(parse[1])){
                    result.add("Logged Out Successfully");
                    login.remove(parse[1]);
                } else{
                    result.add("Logged Out Unsuccessful");
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("register Tom 12321");
        logs.add("register Tom 12321");
        logs.add("register Pat 121");
        logs.add("login Pat 12");
        logs.add("login Pat 121");
        logs.add("login Pat 121");
        logs.add("logout Tom");
        logs.add("logout Pat");
        logs.add("logout Tim");
        List<String> result = Solution.implementAPI(logs);
        for(String s:result){
            System.out.println(s);
        }
    }
}
