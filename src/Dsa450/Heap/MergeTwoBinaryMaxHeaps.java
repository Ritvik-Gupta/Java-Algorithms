package src.Dsa450.Heap;

public class MergeTwoBinaryMaxHeaps {
}

class Heap {
    int[] heap;
    int size;

    Heap(int maxSize) {
        heap = new int[maxSize];
        size = -1;
    }

    void copyFrom(int[] prevHeap) {
        for (int elm : prevHeap)
            heap[++size] = elm;
    }

    void insert(int elm) {
        heap[++size] = elm;
        bottomUpHeapify(size);
    }

    private void bottomUpHeapify(int currIdx) {
        int parentIdx = (currIdx - 1) / 2;

        if (parentIdx >= 0 && heap[currIdx] > heap[parentIdx]) {
            swap(currIdx, parentIdx);
            bottomUpHeapify(parentIdx);
        }
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}

class Solution {
    public int[] mergeHeaps(int[] heapA, int[] heapB, int __, int ___) {
        Heap mergedHeap = new Heap(heapA.length + heapB.length);

        if (heapA.length < heapB.length) {
            int[] temp = heapA;
            heapA = heapB;
            heapB = temp;
        }

        mergedHeap.copyFrom(heapA);
        for (int elm : heapB)
            mergedHeap.insert(elm);

        return mergedHeap.heap;
    }
}
