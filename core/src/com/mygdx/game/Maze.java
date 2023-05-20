package com.mygdx.game;

import java.awt.Paint;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import javax.naming.Context;

public class Maze{
    public int[][] generateMaze(int width, int height) {
        int[][] maze = new int[width][height];

        // Fill the maze with walls
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                maze[i][j] = 1;
            }
        }

        // Create the list of walls
        List<Wall> walls = new ArrayList<Wall>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (i > 1 && maze[i - 2][j] == 1) { // Add the left wall
                    walls.add(new Wall(i, j, Direction.LEFT));
                }
                if (j > 1 && maze[i][j - 2] == 1) { // Add the top wall
                    walls.add(new Wall(i, j, Direction.UP));
                }
            }
        }

        // Shuffle the list of walls
        Collections.shuffle(walls);

        // Create the disjoint sets
        DisjointSets disjointSets = new DisjointSets(maze.length * maze[0].length);

        // Remove walls
        for (Wall wall : walls) {
            int x = wall.getX();
            int y = wall.getY();
            if ((wall.getDirection() == Direction.LEFT && x > 1) || (wall.getDirection(
            ) == Direction.UP && y > 1)) {
                // Check if the cells are already part of the same set
                int cell1 = x + y * maze.length;
                int cell2;
                if (wall.getDirection() == Direction.LEFT) {
                    cell2 = (x - 2) + y * maze.length;
                } else {
                    cell2 = x + (y - 2) * maze.length;
                }
                if (disjointSets.find(cell1) != disjointSets.find(cell2)) {
                    // Remove the wall
                    maze[x][y] = 0;

                    // Merge the two sets
                    disjointSets.union(disjointSets.find(cell1), disjointSets.find(cell2));
                }
            }
        }

        // Set the start and end points
        maze[1][1] = 0;
        maze[maze.length - 2][maze[0].length - 2] = 0;

        return maze;
    }

    private enum Direction {
        LEFT, UP
    }

    private class Wall {
        private int x;
        private int y;
        private Direction direction;

        public Wall(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Direction getDirection() {
            return direction;
        }
    }

    private class DisjointSets {
        private int[] parent;
        private int[] rank;

        public DisjointSets(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot == yRoot) {
                return;
            }

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }
}
