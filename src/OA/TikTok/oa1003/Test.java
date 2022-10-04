package OA.TikTok.oa1003;

public class Test {
    public static void main(String[] args) {
        int a = 1;
        int b = 4;
        int c = (~a&b)+(a&~b)+(a&b);
        int d = (a&b) + (a|b);
        int e = (a^b) + (a&b)*2;
        int f = (~a&b) + (a&~b) + 2*(a&b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }
}

/**
 * 1
 * 1 2
 * 1
 * 1 3
 * p3 = 1
 *
 * 1
 * []
 * 2
 * 2 3
 * 2
 * p3 = 2
 *
 * 1
 * []
 * 2
 * 2 3
 * 2
 * 2 4
 *
 *
 * n-1
 */