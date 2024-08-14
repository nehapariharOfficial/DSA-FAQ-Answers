package org.informationbits.LinkedList.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.informationbits.LinkedList.datastructures.LinkedListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.informationbits.LinkedList.util.LinkedListCreator.isEqual;
import static org.informationbits.LinkedList.util.PrintList.print;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeTest {

    Logger logger = LogManager.getLogger();
    @BeforeEach
    void setUp() {

    }

    @Test
    void mergeAlternate() {
        //Case 1:
        LinkedListNode h1 = Merge.mergeAlternate(new LinkedListCreator(new int[]{1, 3}).head,
                new LinkedListCreator(new int[]{2,4}).head);
        print(h1,logger);
        assertTrue(isEqual(h1, new LinkedListCreator(new int[]{1, 2,3,4}).head));

        //Case 2:
        LinkedListNode h2 = Merge.mergeAlternate(new LinkedListCreator(new int[]{1, 3}).head,
                new LinkedListCreator(new int[]{2,4,5}).head);
        print(h2,logger);
        assertTrue(isEqual(h2, new LinkedListCreator(new int[]{1, 2, 3, 4,5}).head));

        //Case 3:
        LinkedListNode h3 = Merge.mergeAlternate(new LinkedListCreator(new int[]{1, 3, 5}).head,
                new LinkedListCreator(new int[]{2,4}).head);
        print(h3,logger);
        assertTrue(isEqual(h3, new LinkedListCreator(new int[]{1, 2, 3, 4, 5}).head));

        //Case 4:
        LinkedListNode h4 =Merge.mergeAlternate(new LinkedListCreator(new int[]{}).head,
                new LinkedListCreator(new int[]{1}).head);
        print(h4,logger);
        assertTrue(isEqual(h4, new LinkedListCreator(new int[]{1}).head));

        //Case 5:
        LinkedListNode h5 = Merge.mergeAlternate(new LinkedListCreator(new int[]{1}).head,
                new LinkedListCreator(new int[]{}).head);
        print(h5,logger);
        assertTrue(isEqual(h4, new LinkedListCreator(new int[]{1}).head));

        //Case 6:
        LinkedListNode h6 = Merge.mergeAlternate(new LinkedListCreator(new int[]{1}).head,
                new LinkedListCreator(new int[]{2}).head);
        print(h6,logger);
        assertTrue(isEqual(h6, new LinkedListCreator(new int[]{1,2}).head));

        //Case 7:
        LinkedListNode h7 = Merge.mergeAlternate(new LinkedListCreator(new int[]{}).head,
                new LinkedListCreator(new int[]{}).head);
        print(h7,logger);
        assertTrue(isEqual(h7, new LinkedListCreator(new int[]{}).head));

    }
}