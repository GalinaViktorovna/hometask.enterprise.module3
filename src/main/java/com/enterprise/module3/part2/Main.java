package com.enterprise.module3.part2;

public class Main {
    public static void main(String[] args) {
        int[] value = {8,9,10,76,43,54,345,3,5,35,53,53,3,5,5,53,53,53,3,5,35,53};
        SquareSum counter =  new SquareSumImpl();
        Long result = counter.getSquareSum(value, 4);
        System.out.println(result);
    }
}
