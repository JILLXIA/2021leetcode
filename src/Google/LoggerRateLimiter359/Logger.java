package Google.LoggerRateLimiter359;

import java.util.HashMap;

public class Logger {
    HashMap<String,Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp + 10);
            return true;
        } else {
            if(timestamp >= map.get(message)){
                map.put(message, timestamp + 10);
                return true;
            }
            return false;
        }
    }
}
