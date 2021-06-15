package ACM.leecode周赛.第48场双周赛;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lee2_5694设计一个验证系统 {

    /***
     你需要设计一个包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，这个验证码在 currentTime 时刻之后
     timeToLive 秒过期。如果验证码被更新了，那么它会在 currentTime （可能与之前的 currentTime 不同）时刻延长 timeToLive 秒。

     请你实现 AuthenticationManager 类：

     AuthenticationManager(int timeToLive) 构造 AuthenticationManager 并设置 timeToLive 参数。
     generate(string tokenId, int currentTime) 给定 tokenId ，在当前时间 currentTime 生成一个新的验证码。
     renew(string tokenId, int currentTime) 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新。
     如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
     countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。
     如果一个验证码在时刻 t 过期，且另一个操作恰好在时刻 t 发生（renew 或者 countUnexpiredTokens 操作），
     过期事件 优先于 其他操作。
     */


    /**
     * Your AuthenticationManager object will be instantiated and called as such:
     * AuthenticationManager obj = new AuthenticationManager(timeToLive);
     * obj.generate(tokenId,currentTime);
     * obj.renew(tokenId,currentTime);
     * int param_3 = obj.countUnexpiredTokens(currentTime);
     */

    int timeToLive;
    Map<String, Integer> map = new HashMap<>();
    //int count = 0;
    public lee2_5694设计一个验证系统(int timeToLive) {//AuthenticationManager
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
        //count++;
    }

    public void renew(String tokenId, int currentTime) {
        Integer integer = map.get(tokenId);
        if (integer != null && currentTime < integer + timeToLive) {
            map.put(tokenId, currentTime);

        }
    }

    public int countUnexpiredTokens(int currentTime) {

        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            int integer = map.get(s);
            if (currentTime >= integer + timeToLive) {
                list.add(s);
            }
        }

        for (String s : list) {
            map.remove(s);
        }
        return map.size();
    }

    public static void main(String[] args) {
        lee2_5694设计一个验证系统 authenticationManager = new lee2_5694设计一个验证系统(5); // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
        authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
        authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
        System.out.println(authenticationManager.countUnexpiredTokens(6));
        authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
        authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
        authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
        System.out.println(authenticationManager.countUnexpiredTokens(15));
    }
}
