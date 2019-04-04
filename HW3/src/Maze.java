import java.util.ArrayList;

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
                || maze.getColor(x, y) != NON_BACKGROUND) {
            return false;
        }
        // Cell is on path and is maze exit
        else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            maze.recolor(x, y, PATH);
            return true;
        }
        else {
            // Attempts to find a path from each neighbor
            maze.recolor(x, y, PATH);
            if (findMazePath(x - 1, y) || findMazePath(x + 1, y) || findMazePath(x, y - 1) ||
            findMazePath(x, y + 1)) {
                return true;
            }
            else {
                maze.recolor(x, y, TEMPORARY);
                return false;
            }
        }
    }

    /**
     * Modifies the solution of problem 1 so that a list of all the solutions to the maze is returned
     * @param x the x-coordinate of the current point
     * @param y the y-corrdinate of the current point
     * @return a list of all the solutions to the maze
     */
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {

    }
    
    // ADD METHOD FOR PROBLEM 3 HERE
    

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
