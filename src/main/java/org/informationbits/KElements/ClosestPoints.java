package org.informationbits.KElements;

import java.util.*;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 * https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 */
public class ClosestPoints {
    public static List<Point> kClosest(Point[] points, int k) {
        ArrayList<Point> closestPoints = new ArrayList<Point>();
        if (points.length <= k) {
            closestPoints.addAll(Arrays.asList(points));
            return closestPoints;
        }


        PriorityQueue<Point> maxHeap = initMaxHeap(k);
        for (Point point : points) {
            add(maxHeap, point, k);
        }

        closestPoints.addAll(maxHeap);
        return closestPoints;
    }

    private static Point add(PriorityQueue<Point> maxHeap, Point point, int maxHeapSize) {
        if (maxHeap.size() == maxHeapSize) {
            if (getDistance(maxHeap.peek()) > getDistance(point)) {
                maxHeap.poll();
                maxHeap.add(point);
            }
        } else {
            maxHeap.add(point);
        }
        return maxHeap.peek();
    }

    private static PriorityQueue<Point> initMaxHeap(int heapSize) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(heapSize, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                double p1Dist = getDistance(p1);
                double p2Dist = getDistance(p2);
                if (p2Dist == p1Dist) {
                    if (p2.x - p1.x > 0) return 1;
                    return p2.y - p1.y;
                } else {
                    return p2Dist - p1Dist > 0 ? 1 : -1;
                }
            }
        });
        return maxHeap;
    }

    private static double getDistance(Point p) {
        return p.x * p.x + p.y * p.y;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

