package utils;

public class GcdUtils {

    public static int gcd(int a, int b){
        if(a == 0)  return b;
        return gcd(b%a, a);
    }

}
