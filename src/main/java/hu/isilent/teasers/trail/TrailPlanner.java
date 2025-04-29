package hu.isilent.teasers.trail;

import java.util.ArrayList;
import java.util.List;

public class TrailPlanner {

  private int[][] map;

  private int topEdge;
  private int bottomEdge;
  private int leftEdge;
  private int rightEdge;

  private List<Coordinate> trailHeads;

  public TrailPlanner(int[][] map) {
    this.map = map;
    this.init();
  }

  private void init() {
    this.map = map;
    topEdge = 0;
    bottomEdge = map.length - 1;
    leftEdge = 0;
    rightEdge = map[0].length - 1;
  }

  public void plan() {
    trailHeads = findTrailHeads();
    List<Trail> trails = new ArrayList<>();

    for (Coordinate trailHead : trailHeads) {
      List<List<Coordinate>> trailCoordinate = new ArrayList<>();

      trailCoordinate.add(List.of(trailHead));

      for (int height = 1; height <= 9; height++) {
        List<Coordinate> nextPossibleCoordinates = getNextPossibleCoordinate(trailCoordinate.getLast(), height);
        if (!nextPossibleCoordinates.isEmpty()) {
          trailCoordinate.add(nextPossibleCoordinates);
        }
      }
      trails.add(new Trail(trailCoordinate));
    }


    for(Trail trail : trails) {
      List<List<Coordinate>> trailCoordinates = trail.trails();
      for (List<Coordinate> coords : trailCoordinates) {
        System.out.println(coords);
      }
      System.out.println("-----------------------------------------");
    }

  }


  private List<Coordinate> getNextPossibleCoordinate(List<Coordinate> coordinates, int height) {
    List<Coordinate> newCoordinates = new ArrayList<>();
    for (Coordinate coordinate : coordinates) {
      Coordinate leftHeightCoordinate = new Coordinate(coordinate.row(), coordinate.col() - 1);
      Coordinate rightHeightCoordinate = new Coordinate(coordinate.row(), coordinate.col() + 1);
      Coordinate topHeightCoordinate = new Coordinate(coordinate.row() - 1, coordinate.col());
      Coordinate bottomHeightCoordinate = new Coordinate(coordinate.row() + 1, coordinate.col());

      if(leftHeightCoordinate.col() >= leftEdge && map[leftHeightCoordinate.row()][leftHeightCoordinate.col()] == height) {
        newCoordinates.add(leftHeightCoordinate);
      }

      if(rightHeightCoordinate.col() <= rightEdge && map[rightHeightCoordinate.row()][rightHeightCoordinate.col()] == height) {
        newCoordinates.add(rightHeightCoordinate);
      }

      if(topHeightCoordinate.row() >= topEdge && map[topHeightCoordinate.row()][topHeightCoordinate.col()] == height) {
        newCoordinates.add(topHeightCoordinate);
      }

      if(bottomHeightCoordinate.row() <= bottomEdge && map[bottomHeightCoordinate.row()][bottomHeightCoordinate.col()] == height) {
        newCoordinates.add(bottomHeightCoordinate);
      }
    }

    return newCoordinates;
  }

  private List<Coordinate> findTrailHeads() {
    List<Coordinate> trailHeads = new ArrayList<>();

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == 0) {
          trailHeads.add(new Coordinate(i, j));
        }
      }
    }

    return trailHeads;
  }
}
