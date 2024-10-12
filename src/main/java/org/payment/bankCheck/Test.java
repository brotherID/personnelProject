package org.payment.bankCheck;

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        int sum = IntStream.range(0,100)
                .reduce(0 , (a,b) -> a+b);
        System.out.println(sum);

        int found = IntStream.of(-3,3,4)
                .reduce ( (a,b) -> {
                    if(Test.isALessThenB(a,b) || Test.isEqualTOB(a,b) &&  a > b)
                        return a;
                    return b;
                } ).getAsInt();
        System.out.println(found);

    }

    private static boolean isALessThenB(int a, int b) {
        return  (Math.abs(a) < Math.abs(b));
    }
    private static boolean isEqualTOB(int a, int b) {
        return  (Math.abs(a) == Math.abs(b));
    }
}
