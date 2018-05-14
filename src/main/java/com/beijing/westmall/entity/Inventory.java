package com.beijing.westmall.entity;


/**
 * @Author Joker
 * @Description
 * @Date Create in 下午2:31 2018/5/14
 */
public class Inventory {
    private Long id;
    private int count;
    private int lockedCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLockedCount() {
        return lockedCount;
    }

    public void setLockedCount(int lockedCount) {
        this.lockedCount = lockedCount;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", count=" + count +
                ", lockedCount=" + lockedCount +
                '}';
    }
}
