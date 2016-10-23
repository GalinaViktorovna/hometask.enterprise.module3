package com.enterprise.module3.part2;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

public class AreaCounter implements Callable<Long> {
    private int[] values;
    private int start;
    private int finish;
    private List<Long> result;
    private Phaser planner;

    public AreaCounter(int[] values, int start, int finish, List<Long> result, Phaser planner){
        this.values = values;
        this.start = start;
        this.finish = finish;
        this.result = result;
        this.planner = planner;
    }

    @Override
    public Long call() throws Exception {

        Long sum = 0L;

        for(int i = start; i < finish; i ++){
            sum += values[i] * values[i];
        }
        result.add(sum);
        planner.arriveAndDeregister();
        return sum;
    }
}
