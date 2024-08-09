package org.informationbits.LinkedList.solutionsuit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.informationbits.LinkedList.datastructures.LinkedListNode;
import org.informationbits.LinkedList.util.LinkedListCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.informationbits.LinkedList.util.PrintList.print;
import static org.junit.jupiter.api.Assertions.*;

class ReverseVariantsTest {

    Set<LinkedListNode> inputLinkedLists;
    int inputSize = 10;
    Logger logger = LogManager.getLogger();
    @BeforeEach
    void setUp() {
        inputLinkedLists = new HashSet<LinkedListNode>();
        int[][] inputInt = new int[inputSize][];
        for (int i = 0; i < inputSize; i++) {
            inputInt[i] = new int[i];
            for (int j = 0; j < i; j++) {
                inputInt[i][j] = i + j;
            }
            inputLinkedLists.add(new LinkedListCreator(inputInt[i]).head);
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testReverseV1() {
        for (LinkedListNode head : inputLinkedLists) {
            LinkedListNode cloneListHead = LinkedListCreator.clone(head);
            print(head,logger);
            assertTrue(isEqual(ReverseVariants.reverseV1(ReverseVariants.reverseV1(cloneListHead)), head));
        }
    }

    @Test
    void testReverseV2() {
        for (LinkedListNode head : inputLinkedLists) {
            LinkedListNode cloneListHead = LinkedListCreator.clone(head);
            print(head,logger);
            assertTrue(isEqual(ReverseVariants.reverseV2(ReverseVariants.reverseV2(cloneListHead)), head));
        }
    }

    @Test
    void testReverseV3() {
        for (LinkedListNode head : inputLinkedLists) {
            LinkedListNode cloneListHead = LinkedListCreator.clone(head);
            print(head,logger);
            assertTrue(isEqual(ReverseVariants.reverseV3(ReverseVariants.reverseV3(cloneListHead)), head));
        }
    }

    @Test
    void testReverseV4() {
        for (LinkedListNode head : inputLinkedLists) {
            LinkedListNode cloneListHead = LinkedListCreator.clone(head);
            print(head, logger);
            assertTrue(isEqual(ReverseVariants.reverseV4(ReverseVariants.reverseV4(cloneListHead)), head));
        }
    }

    @Test
    void reverseV5() {
        for (LinkedListNode head : inputLinkedLists) {
            LinkedListNode cloneListHead = LinkedListCreator.clone(head);
            int len = LinkedListCreator.size(cloneListHead);
            print(head, logger);
            //Case 1:
            assertTrue(isEqual(ReverseVariants.reverseV5(
                    ReverseVariants.reverseV5(cloneListHead, 1, len), 1, len), head));

            //Case 2:
            assertTrue(isEqual(ReverseVariants.reverseV5(cloneListHead, 1, 1), head));

            //Case 3:
            assertTrue(isEqual(ReverseVariants.reverseV5(cloneListHead, -4, -2), head));

            //Case 4:
            assertTrue(isEqual(ReverseVariants.reverseV5(cloneListHead, len + 1, len + 4), head));

            //Case 5:
            assertTrue(isEqual(ReverseVariants.reverseV5(cloneListHead, len, len), head));

            //Case 6:
            assertTrue(inputSize >= 5);
            assertTrue(isEqual(ReverseVariants.reverseV5(
                    ReverseVariants.reverseV5(cloneListHead, 2, 5), 2, 5), head));

            //Case 7:
            assertTrue(inputSize >= 2);
            assertTrue(isEqual(ReverseVariants.reverseV5(
                    ReverseVariants.reverseV5(cloneListHead, -2, 2), -2, 2), head));
        }
    }

    @Test
    void reverseV6() {
        for (LinkedListNode head : inputLinkedLists) {
            LinkedListNode cloneListHead = LinkedListCreator.clone(head);
            int len = LinkedListCreator.size(cloneListHead);
            print(head, logger);

            //Case 1:
            assertTrue(isEqual(ReverseVariants.reverseV6(
                    ReverseVariants.reverseV6(cloneListHead, 1, len), 1, len), head));

            //Case 2:
            assertTrue(isEqual(ReverseVariants.reverseV6(cloneListHead, 1, 1), head));

            //Case 3:
            assertTrue(isEqual(ReverseVariants.reverseV6(cloneListHead, -4, -2), head));

            //Case 4:
            assertTrue(isEqual(ReverseVariants.reverseV6(cloneListHead, len + 1, len + 4), head));

            //Case 5:
            assertTrue(isEqual(ReverseVariants.reverseV6(cloneListHead, len, len), head));

            //Case 6:
            assertTrue(inputSize >= 5);
            assertTrue(isEqual(ReverseVariants.reverseV6(
                    ReverseVariants.reverseV6(cloneListHead, 2, 5), 2, 5), head));

            //Case 7:
            assertTrue(inputSize >= 2);
            assertTrue(isEqual(ReverseVariants.reverseV6(
                    ReverseVariants.reverseV6(cloneListHead, -2, 2), -2, 2), head));
        }
    }

    @Test
    void reverseV7() {
        for (LinkedListNode head : inputLinkedLists) {
            LinkedListNode cloneListHead = LinkedListCreator.clone(head);
            int len = LinkedListCreator.size(cloneListHead);
            print(head, logger);

            //Case 1:
            assertTrue(isEqual(ReverseVariants.reverseV7(
                    ReverseVariants.reverseV7(cloneListHead, 1, len), 1, len), head));

            //Case 2:
            assertTrue(isEqual(ReverseVariants.reverseV7(cloneListHead, 1, 1), head));

            //Case 3:
            assertTrue(isEqual(ReverseVariants.reverseV7(cloneListHead, -4, -2), head));

            //Case 4:
            assertTrue(isEqual(ReverseVariants.reverseV7(cloneListHead, len + 1, len + 4), head));

            //Case 5:
            assertTrue(isEqual(ReverseVariants.reverseV7(cloneListHead, len, len), head));

            //Case 6:
            assertTrue(inputSize >= 5);
            assertTrue(isEqual(ReverseVariants.reverseV7(
                    ReverseVariants.reverseV7(cloneListHead, 2, 5), 2, 5), head));

            //Case 7:
            assertTrue(inputSize >= 2);
            assertTrue(isEqual(ReverseVariants.reverseV7(
                    ReverseVariants.reverseV7(cloneListHead, -2, 2), -2, 2), head));
        }
    }

    @Test
    void reverseV8() {
        for (LinkedListNode head : inputLinkedLists) {
            LinkedListNode cloneListHead = LinkedListCreator.clone(head);
            int len = LinkedListCreator.size(cloneListHead);
            print(head ,logger);

            //Case 1:
            assertTrue(isEqual(ReverseVariants.reverseV8(
                    ReverseVariants.reverseV8(cloneListHead, len), len), head));

            //Case 2:
            assertTrue(isEqual(ReverseVariants.reverseV8(cloneListHead, 1), head));

            //Case 3:
            assertTrue(isEqual(ReverseVariants.reverseV8(cloneListHead,  -2), head));

            //Case 4:
            assertTrue(isEqual(ReverseVariants.reverseV8(cloneListHead, len + 4), head));

            //Case 5:
            assertTrue(inputSize >= 5);
            assertTrue(isEqual(ReverseVariants.reverseV8(
                    ReverseVariants.reverseV8(cloneListHead, 4), 4), head));

            //Case 6:
            assertTrue(inputSize >= 2);
            assertTrue(isEqual(ReverseVariants.reverseV8(
                    ReverseVariants.reverseV8(cloneListHead, 2),  2), head));
        }
    }

    @Test
    void reverseV9() {
        for (LinkedListNode head : inputLinkedLists) {
            LinkedListNode cloneListHead = LinkedListCreator.clone(head);
            int len = LinkedListCreator.size(cloneListHead);
            print(head, logger);

            //Case 1:
            LinkedListNode a = ReverseVariants.reverseV9(cloneListHead, len);
            LinkedListNode b  = ReverseVariants.reverseV9(a, len);
            assertTrue(isEqual(b, head));

            //Case 2:
            assertTrue(isEqual(ReverseVariants.reverseV9(cloneListHead, 1), head));

            //Case 3:
            assertTrue(isEqual(ReverseVariants.reverseV9(cloneListHead,  -2), head));

            //Case 4:
            assertTrue(isEqual(ReverseVariants.reverseV9(ReverseVariants.reverseV9(cloneListHead, len + 4),len+4), head));

            //Case 5:
            assertTrue(inputSize >= 5);
            assertTrue(isEqual(ReverseVariants.reverseV9(
                    ReverseVariants.reverseV9(cloneListHead, 4), 4), head));

            //Case 6:
            assertTrue(inputSize >= 2);
            assertTrue(isEqual(ReverseVariants.reverseV9(
                    ReverseVariants.reverseV9(cloneListHead, 2),  2), head));
        }
    }

    @Test
    void reverseV10() {
        for (LinkedListNode head : inputLinkedLists) {
            LinkedListNode cloneListHead = LinkedListCreator.clone(head);
            int len = LinkedListCreator.size(cloneListHead);
            print(head,logger);

            //Case 1:
            assertTrue(isEqual(ReverseVariants.reverseV10(
                    ReverseVariants.reverseV10(cloneListHead, 1, len), 1, len), head));

            //Case 2:
            assertTrue(isEqual(ReverseVariants.reverseV10(cloneListHead, 1, 1), head));

            //Case 3:
            assertTrue(isEqual(ReverseVariants.reverseV10(cloneListHead, -4, -2), head));

            //Case 4:
            assertTrue(isEqual(ReverseVariants.reverseV10(cloneListHead, len + 1, len + 4), head));

            //Case 5:
            assertTrue(isEqual(ReverseVariants.reverseV10(cloneListHead, len, len), head));

            //Case 6:
            assertTrue(inputSize >= 5);
            assertTrue(isEqual(ReverseVariants.reverseV10(
                    ReverseVariants.reverseV10(cloneListHead, 2, 5), 2, 5), head));

            //Case 7:
            assertTrue(inputSize >= 2);
            assertTrue(isEqual(ReverseVariants.reverseV10(
                    ReverseVariants.reverseV10(cloneListHead, -2, 2), -2, 2), head));
        }
    }

    private boolean isEqual(LinkedListNode headOne, LinkedListNode headTwo) {
        while (headOne != null && headTwo != null) {
            if (headOne.data != headTwo.data) return false;
            headOne = headOne.next;
            headTwo = headTwo.next;
        }
        if (headOne != null || headTwo != null) return false;
        return true;
    }
}