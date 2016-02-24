package com.interviewbit;

import java.util.ArrayList;
// Works fine

/**Given a set of non-overlapping intervals, insert a new interval into the intervals
 (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.*/

/**
 * Definition for an interval.
 */
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	public String toString() {
		return "[" + start + "," + end + "]";
	}
}

public class IntervalClass {
	public static void main(String ar[]) {
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(2503984, 6044502));
		intervals.add(new Interval(8299441, 16663259));
		intervals.add(new Interval(16793501, 19614603));
		intervals.add(new Interval(19728782, 20375958));
		intervals.add(new Interval(25968417, 28010146));
		intervals.add(new Interval(96983158, 98983423));
		intervals.add(new Interval(99682953, 99956221));
		Interval newInterval = new Interval(16338702, 96742429);
		ArrayList<Interval> solutionList = new Solution4().insert(intervals, newInterval);
		// System.out.println(Arrays.toString(solutionList.toArray()));
		System.out.println(solutionList.toString());
	}
}

class Solution4 {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		if (newInterval.start > newInterval.end) {
			int temp = newInterval.start;
			newInterval.start = newInterval.end;
			newInterval.end = temp;
		}
		ArrayList<Interval> finalInterval = new ArrayList<Interval>();
		boolean flagDone = false;
		// for(Interval singleInterval: intervals){
		for (int i = 0; i < intervals.size(); i++) {
			Interval singleInterval = intervals.get(i);
			if (flagDone) {
				finalInterval.add(singleInterval);
				continue;
			}
			// If the new Interval is not within the existing range. Then just
			// let the next values take care
			if (newInterval.start > singleInterval.start && (newInterval.start > singleInterval.end)) {
				finalInterval.add(singleInterval);
			}
			// New interval is in between the exisiting interval
			else if (newInterval.start > singleInterval.start && newInterval.end < singleInterval.end) {
				finalInterval.add(singleInterval);
				flagDone = true;
			}
			// New interval is before the start
			else if ((newInterval.start < singleInterval.start) && (newInterval.end < singleInterval.start)) {
				finalInterval.add(newInterval);
				finalInterval.add(singleInterval);
				flagDone = true;
			}
			// new interval is overlapping
			else {
				int startTime = Math.min(singleInterval.start, newInterval.start);
				while (i < intervals.size()) {
					int endTime = Math.max(singleInterval.end, newInterval.end);
					if (endTime == singleInterval.end || i + 1 >= intervals.size()) {
						finalInterval.add(new Interval(startTime, endTime));
						flagDone = true;
						break;
					} else {
						if (endTime < intervals.get(i + 1).start) {
							finalInterval.add(new Interval(startTime, endTime));
							flagDone = true;
							break;
						} else {
							singleInterval = intervals.get(++i);
						}
					}
				}
			}
		}
		if (!flagDone) {
			finalInterval.add(newInterval);
		}
		return finalInterval;
	}
}
