package com.enterprise.module3.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SquareSumImpl implements SquareSum {

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        int part = values.length/numberOfThreads;

        List<Long> callables = new ArrayList<>();

        Phaser phaser = new Phaser(1);

        int start = 0;
        int finish = part;
        for (int i = 0; i < numberOfThreads; i++){
            if (i+1 == numberOfThreads) finish = values.length;
            Future<Long> future = executorService.submit(new AreaCounter(values, start, finish, callables, phaser));

            try{
                Long x = future.get();
                System.out.println(x);
            } catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }

            phaser.register();
            start = start + part;

            finish = finish + part;
        }
        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndDeregister();
        executorService.shutdown();

        long result = 0;
        for(Long number : callables){
            result += number;
        }

        return result;
    }
}
