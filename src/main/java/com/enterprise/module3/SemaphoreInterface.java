package com.enterprise.module3;

public interface SemaphoreInterface {

    public void acquire() throws InterruptedException;

    public void acquire(int permits) throws InterruptedException;

    public void release() throws InterruptedException;

    public void release(int permits) throws InterruptedException;

    public int getAvailablePermits();
}