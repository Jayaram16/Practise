package com.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a robot sitting on the upper left comer of an X by Ygrid. The robot
 * can only move in two directions: right and down. How many possible paths are
 * there for the robot to go from (0, 0) to (X, Y) ?
 * 
 * FOLLOW UP Imagine certain spots are "off limits," such that the robot cannot
 * step on them. Design an algorithm to find a path for the robot from the top
 * left to the bottom right.
 * 
 * Steps to do is : we start from backwards from point(x,y) and go to (0,0). The
 * boolean value is returned and arrayList is used to keep track as to where we
 * are moving to.
 * 
 * @author Jayaram
 *
 */
public class MoveFrom00ToXY {
	 class Points {
		int x, y;

		Points(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "(X: " + x + " Y: " + y + ")";
		}
	}

	public static void main(String[] args) {
		List<Points> acceptedPoints = new ArrayList<Points>();
		boolean flag = false;
		System.out.println("Route present " + (flag = new MoveFrom00ToXY().getPath(3, 3, acceptedPoints)));
		if (flag) {
			for (Points p : acceptedPoints) {
				System.out.print(p);
			}
		}
	}

	public boolean getPath(int x, int y, List<Points> points) {
		Points p = new Points(x, y);
		points.add(p);
		if (x == 0 && y == 0) {
			return true;
		}
		boolean found = false;
		if (x >= 1 && isValid(x - 1, y)) {
			found = getPath(x - 1, y, points);
		}
		if (!found && y >= 1 && isValid(x, y - 1)) {
			found = getPath(x, y - 1, points);
		}
		return found;
	}

	boolean isValid(int x, int y) {
		if ((x == 1 && y == 2) | (x == 3 && y == 2)) {
			return false;
		}
		return true;
	}
}
