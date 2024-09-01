package org.informationbits.Heap.solutionsuit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeetingRooms3Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mostBooked() {
        //Case 1:
        int[][] meetings = new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};
        int rooms = 3;
        int expected = 1;
        int actual = MeetingRooms3.mostBooked(meetings, rooms);
        assertEquals(expected, actual);

        //Case 2:
        meetings = new int[][]{{0, 4}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {5, 7}};
        rooms = 4;
        expected = 1;
        actual = MeetingRooms3.mostBooked(meetings, rooms);
        assertEquals(expected, actual);

        //Case 3:
        meetings = new int[][]{{10, 11}, {2, 10}, {1, 17}, {9, 13}, {18, 20}};
        rooms = 2;
        expected = 1;
        actual = MeetingRooms3.mostBooked(meetings, rooms);
        assertEquals(expected, actual);
    }
}