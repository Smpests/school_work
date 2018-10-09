package com.qingsong.book.model;

/**
 * @author qingsong
 * created at 2018/4/19
 */
public class MemoryModel {
    private int maxMemory;
    private int totalMemory;
    private int freeMemory;

    /**
     *
     * @return maxMemory 最大内存
     */
    public int getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public int getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }
}
