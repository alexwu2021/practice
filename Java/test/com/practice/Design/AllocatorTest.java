package com.practice.Design;

import org.junit.jupiter.api.Test;

class AllocatorTest {

    @Test
    void allocate() {
//        ["Allocator","allocate","allocate","allocate","free","allocate","allocate","allocate","free","allocate","free"]
//        [10],[1,1],[1,2],[1,3],[2],[3,4],[1,1],[1,1],[1],[10,2],[7]]
        int n = 10;
        Allocator memoryAllocator = new Allocator(n);
        memoryAllocator.allocate(1, 1);
        memoryAllocator.allocate(1, 2); // allocate 1 cell for iID == 2
        memoryAllocator.allocate(1, 3);
        memoryAllocator.free(2);
        memoryAllocator.allocate(3, 4);
        memoryAllocator.allocate(1, 1);
        memoryAllocator.allocate(1, 1);
        memoryAllocator.free(1);
        memoryAllocator.allocate(10, 2);
        memoryAllocator.free(7);


    }

    @Test
    void free() {
    }
}