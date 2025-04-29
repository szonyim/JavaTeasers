package hu.isilent.teasers.trail;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    int[][] map = {
      {8, 9, 0, 1, 0, 1, 2, 3}, // 0
      {7, 8, 1, 2, 1, 8, 7, 4}, // 1
      {8, 7, 4, 3, 0, 9, 6, 5}, // 2
      {9, 6, 5, 4, 9, 8, 7, 4}, // 3
      {4, 5, 6, 7, 8, 9, 0, 3}, // 4
      {3, 2, 0, 1, 9, 0, 1, 2}, // 5
      {0, 1, 3, 2, 9, 8, 0, 1}, // 6
      {1, 0, 4, 5, 6, 7, 3, 2}  // 7
    };


    TrailPlanner planner = new TrailPlanner(map);
    planner.plan();


  }

}
