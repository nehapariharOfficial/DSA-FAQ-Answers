package org.informationbits.Heap.solutionsuit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Similar Questions -
 * https://leetcode.com/problems/meeting-rooms-iii/description/
 **/

public class MeetingRooms3 {
    public static int mostBooked(int[][] meetings, int rooms) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int maxMeeting = -1;
        int maxMeetingRoomNumber = -1;

        PriorityQueue<Room> occupiedRoomHeap = new PriorityQueue<Room>(new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o1.meetingEndTime == o2.meetingEndTime ? o1.roomNum - o2.roomNum : o1.meetingEndTime - o2.meetingEndTime;
            }
        });

        PriorityQueue<Room> availableRoomHeap = new PriorityQueue<Room>(new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o1.roomNum - o2.roomNum;
            }
        });


        for (int rNum = 0; rNum < rooms; rNum++) {
            availableRoomHeap.add(new Room(rNum, -1));
        }

        for (int mNum = 0; mNum < meetings.length; mNum++) {
            int currentMStart = meetings[mNum][0];
            int currentMEnd = meetings[mNum][1];

            while (occupiedRoomHeap.size() > 0 && occupiedRoomHeap.peek().meetingEndTime <= currentMStart) {
                Room room = occupiedRoomHeap.poll();
                availableRoomHeap.add(room);
            }

            if (availableRoomHeap.size() == 0) {
                Room room = occupiedRoomHeap.poll();
                int waitTime = room.meetingEndTime - currentMStart;
                currentMStart = currentMStart + waitTime;
                currentMEnd = currentMEnd + waitTime;
                availableRoomHeap.add(room);
            }

            Room room = availableRoomHeap.poll();
            room.meetingEndTime = currentMEnd;
            room.meetingHeld++;
            occupiedRoomHeap.add(room);
            if (room.meetingHeld > maxMeeting || (room.meetingHeld == maxMeeting && room.roomNum < maxMeetingRoomNumber)) {
                maxMeeting = room.meetingHeld;
                maxMeetingRoomNumber = room.roomNum;
            }
        }

        return maxMeetingRoomNumber;
    }

    private static class Room {
        int roomNum;
        int meetingEndTime;
        int meetingHeld;

        Room(int rNum, int meetingET) {
            this.roomNum = rNum;
            this.meetingEndTime = meetingET;
            this.meetingHeld = 0;
        }
    }
}
