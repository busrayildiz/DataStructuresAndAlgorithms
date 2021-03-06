package com.busrayildiz.CtCI;

import java.util.EmptyStackException;

public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int [] values;
    private int [] sizes;

    public FixedMultiStack(int stackSize) {
        this.stackCapacity = stackSize;
        this.values = new int[stackSize*numberOfStacks];
        this.sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value)  {
        if(isFull(stackNum)){
            throw new StackOverflowError();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)]=value;
    }

    public int pop (int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size -1;

    }




}
