import java.util.function.*;
class Parametre {
    static int cumul(int[] t, Function<Integer, Integer> ld) {
        int cumul =0;
        for (int x : t) {
            cumul += ld.apply(x);
        }
        return cumul;
    }

    public static void main(String[] args) {
        int[] t = {0,1,2,3};

        System.out.println(cumul(t,x-> x));
        System.out.println(cumul(t,x-> x+1));
        System.out.println(cumul(t,x-> 2*x));
        System.out.println(cumul(t,x-> x*x));
    }
}
