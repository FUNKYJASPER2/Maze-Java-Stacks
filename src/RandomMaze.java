import java.util.Stack;
public class RandomMaze {
    private int size;
    private Tile[][] maze;
    private Stack<Tile> path;
    private int notVisited;

    public RandomMaze(int size){
        this.size = size;
        maze = new Tile[size][size];
        path = new Stack<>();
        notVisited = 0;
    }

    public int getSize(){ return size; }
    public Tile[][] getMaze(){return maze; }
    public void initialize(){
        int tempRow, tempCol;
        //for loop places a tile in each grid point
        for (int row = 0;row < size; row++){
            for (int col = 0;col < size;col++){
                maze[row][col] = new Tile(row, col);
                notVisited++;
            }
        }

        //for loop to give each tile their respective neighbors
        for (int row = 0;row < size;row++){
            for (int col = 0;col < size;col++){
                //if statements check if the tile would have neighbors in every direction and adds them
                //to the tiles neighbors array if it does.
                if (row - 1 >= 0){
                    tempRow = row - 1;
                    maze[row][col].addNeighbor(maze[tempRow][col]);
                }
                if (row + 1 < size){
                    tempRow = row + 1;
                    maze[row][col].addNeighbor(maze[tempRow][col]);
                }
                if (col - 1 >= 0){
                    tempCol = col - 1;
                    maze[row][col].addNeighbor(maze[row][tempCol]);
                }
                if (col + 1 < size){
                    tempCol = col + 1;
                    maze[row][col].addNeighbor(maze[row][tempCol]);
                }
            }
        }
    }
    //this method will create a random maze
    public void createMaze(){
        Tile curTile = maze[0][0];
        curTile.setVisited();
        while (notVisited > 1){

            if (curTile.notVisitedNeighbors() > 0){
                Tile newTile = curTile.chooseNeighbor();
                path.push(curTile);
                curTile.removeWalls(maze[newTile.getRow()][newTile.getCol()]);
                curTile = maze[newTile.getRow()][newTile.getCol()];
                curTile.setVisited();
                notVisited--;
                //System.out.println(++count);
            }
            else if (!path.empty()){
                curTile = path.pop();
            }
            //System.out.println("1");
        }

    }


}
