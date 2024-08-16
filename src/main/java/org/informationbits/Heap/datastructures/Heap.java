package org.informationbits.Heap.datastructures;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

//TODO: Implement heap using non-continuous memory.
public class Heap<T> {
    final Comparator<T> cmp;
    final int maxSize;
    T[] data;
    int currentSize;
    Logger logger = LogManager.getLogger();

    public Heap(T[] list, int size, Comparator<T> cmp) {
        assert (list.length <= size);
        this.data = (T[]) new Object[size];
        this.currentSize = list.length;
        this.maxSize = size;
        this.cmp = cmp;
        System.arraycopy(list, 0, data, 0, list.length);
        buildHeap();
    }


    public boolean insert(T val) {
        assert (currentSize <= maxSize);
        if (currentSize == maxSize) {
            logger.info("unable to insert value: %d because heap is full".formatted(val));
            return false;
        } else {
            data[currentSize] = val;
            currentSize++;
            fixIndexToRoot(currentSize - 1);
            return true;
        }
    }

    public T peek() {
        return data[0];
    }

    public T pop() {
        swap(0, currentSize - 1);
        currentSize--;
        fixIndexToBottom(0);
        return data[currentSize];
    }

    public void print() {
        if (currentSize == 0) {
            System.out.println("Heap is empty.");
            return;
        }

        int level = (int) Math.floor(Math.log(currentSize) / Math.log(2)) + 1;

        int currentLevel = 0;
        int index = 0;
        int padding = (int) Math.pow(2, level - currentLevel);
        int spacing = 0;
        while (index < currentSize) {
            int levelSize = (int) Math.pow(2, currentLevel);
            int elementsToPrint = Math.min(levelSize, currentSize - index);

            // Print leading spaces
            System.out.print(" ".repeat(padding));

            // Print elements at the current level
            for (int i = 0; i < elementsToPrint; i++) {
                System.out.print(data[index++] + " ".repeat(spacing));
            }
            System.out.println();
            currentLevel++;
            spacing = padding;
            padding = (int) Math.pow(2, level - currentLevel);
        }
    }

    private void buildHeap() {
        for (int i = parentIndex(currentSize - 1); i >= 0; i--) {
            int parentIndex = i;
            int lCIdx = leftChildIndex(parentIndex);
            int rCIdx = rightChildIndex(parentIndex);
            int swapIndex = parentIndex;
            if (cmp.compare(data[lCIdx], data[swapIndex]) > 0) {
                swapIndex = lCIdx;
            }
            if (cmp.compare(data[rCIdx], data[swapIndex]) > 0) {
                swapIndex = rCIdx;
            }
            if (swapIndex != parentIndex) {
                swap(parentIndex, swapIndex);
                fixIndexToBottom(swapIndex);
            }
        }
    }

    private void fixIndexToRoot(int i) {
        if (i <= 0) return;
        int parentIndex = parentIndex(i);
        if (parentIndex >= 0 && cmp.compare(data[i], data[parentIndex]) > 0) {
            swap(i, parentIndex);
            fixIndexToRoot(parentIndex);
        }
    }

    private void fixIndexToBottom(int i) {
        if (i >= (currentSize - 1)) return;
        int parentIndex = i;
        int lCIdx = leftChildIndex(parentIndex);
        int rCIdx = rightChildIndex(parentIndex);
        int nextIndex = parentIndex;
        if (lCIdx < currentSize && cmp.compare(data[lCIdx], data[parentIndex]) > 0) {
            swap(lCIdx, parentIndex);
            nextIndex = lCIdx;
        }
        if (rCIdx < currentSize && cmp.compare(data[rCIdx], data[parentIndex]) > 0) {
            swap(rCIdx, parentIndex);
            nextIndex = rCIdx;
        }
        if (nextIndex != parentIndex) fixIndexToBottom(nextIndex);
    }

    private void swap(int i, int j) {
        T tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private int parentIndex(int childIndex) {
        return (int) Math.floor((childIndex - 1) / 2);
    }

    private int leftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return 2 * (parentIndex + 1);
    }
}
