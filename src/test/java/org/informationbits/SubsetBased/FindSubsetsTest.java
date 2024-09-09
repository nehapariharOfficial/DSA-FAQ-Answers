package org.informationbits.SubsetBased;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindSubsetsTest {

    @Test
    void findAllSubsets() {
        assertEquals(1, FindSubsets.findAllSubsets(new int[]{}).size());
        assertEquals(2, FindSubsets.findAllSubsets(new int[]{1}).size());
        assertEquals(4, FindSubsets.findAllSubsets(new int[]{1, 2}).size());
    }
}