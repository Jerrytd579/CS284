/**
 * Jerry Cheng
 *
 * I pledge my honor that I have abided by the Stevens Honor System.
 *
 */


import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
        // Cell is either out of bounds or is on barrier or dead end
        if (x < 0 || y < 0 || x >= maze.getNCols() || y >= maze.getNRows()
                || maze.getColor(x, y) != GridColors.NON_BACKGROUND) {
            return false;
        }
        // Cell is on path and is maze exit
        else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            maze.recolor(x, y, GridColors.PATH);
            return true;
        }
        else {
            // Attempts to find a path from each neighbor
            maze.recolor(x, y, GridColors.PATH);
            if (findMazePath(x - 1, y) || findMazePath(x + 1, y) || findMazePath(x, y - 1) ||
            findMazePath(x, y + 1)) {
                return true;
            }
            else {
                maze.recolor(x, y, GridColors.TEMPORARY);
                return false;
            }
        }
    }

    /**
     * Modifies the solution of problem 1 so that a list of all the solutions to the maze is returned
     * @param x the x-coordinate of the current point
     * @param y the y-corrdinate of the current point
     * @return array list containing all possible paths to the maze
     */
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
        ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
        Stack <PairInt> trace = new Stack <>();
        findMazePathStackBased (0 ,0 , result , trace);
        return result;
    }

    /**
     * A helper method for findAllMazePaths
     * @param x the x coordinate
     * @param y the y coordinate
     * @param result the list of successful paths recorded up to now
     * @param trace the trace of the current path being explored
     */
    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
        // If the coordinates are out of bounds, do nothing
        if (x < 0 || y < 0 || x >= maze.getNCols() || y >= maze.getNRows()
                || maze.getColor(x, y) != GridColors.NON_BACKGROUND) { }
        // Cell is on path and is maze exit
        else if(x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            trace.push(new PairInt(x, y));
            ArrayList<PairInt> temp = new ArrayList<PairInt>(trace);
            trace.pop();
            result.add(temp);
        }
        else {
            maze.recolor(x, y, GridColors.TEMPORARY);
            trace.push(new PairInt(x, y));
            findMazePathStackBased(x + 1, y, result, trace);
            findMazePathStackBased(x - 1, y, result, trace);
            findMazePathStackBased(x, y + 1, result, trace);
            findMazePathStackBased(x, y - 1, result, trace);
            maze.recolor(x, y, GridColors.NON_BACKGROUND);
            trace.pop();

        }
    }
    
    // ADD METHOD FOR PROBLEM 3 HERE
    /**
     * Returns the shortest path in the list of paths
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the shortest path in the list of paths
     */

    public ArrayList<PairInt> findMazePathMin(int x, int y) {
        maze.recolor(GridColors.PATH, GridColors.NON_BACKGROUND);
        ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
        result = findAllMazePaths(x,y);

        if (result.size() != 0) {
            ArrayList<PairInt> minimum = result.get(0);
            int minimum_length = minimum.size();
            for (ArrayList<PairInt> pairInts : result) {
                if (minimum_length >= pairInts.size()) {
                    minimum = pairInts;
                    minimum_length = minimum.size();
                }
            }
            return minimum;
        }
        return new ArrayList<PairInt>();

    }

    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/
