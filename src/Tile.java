import java.util.ArrayList;
import java.util.Random;
public class Tile {
    private int row;
    private int col;
    private boolean visited;
    private boolean rightWall;
    private boolean leftWall;
    private boolean upWall;
    private boolean downWall;
    private ArrayList<Tile> neighbors;

    public Tile(int row, int col){
        this.row = row;
        this.col = col;
        rightWall = true;
        leftWall = true;
        upWall = true;
        downWall = true;
        visited = false;
        neighbors = new ArrayList<>();
    }

    //setters for walls
    public void setRightWall(boolean rightWall){ this.rightWall = rightWall; }
    public void setLeftWall(boolean leftWall){ this.leftWall = leftWall; }
    public void setUpWall(boolean upWall){ this.upWall = upWall; }
    public void setDownWall(boolean downWall){ this.downWall = downWall; }
    public void setVisited(){ visited = true; }
    //getters for walls
    public boolean isRightWall(){ return rightWall; }
    public boolean isLeftWall(){ return leftWall; }
    public boolean isUpWall(){ return upWall; }
    public boolean isDownWall(){ return downWall; }
    public boolean isVisited(){ return visited; }
    public int getRow(){ return row; }
    public int getCol(){ return col; }

    //adds a neighbor to the array list
    public void addNeighbor(Tile n){
        neighbors.add(n);
    }

    //returns the number of unvisited neighbors
    public int notVisitedNeighbors(){
        int count = 0;
        for (int i = 0; i < neighbors.size();i++){
            if (!neighbors.get(i).isVisited()){
                count++;
            }
        }
        return count;
    }

    //randomly chooses a neighbor that has not been visited
    public Tile chooseNeighbor(){
        Random rand = new Random();
        ArrayList<Tile> notVisited = new ArrayList<>();//temp array tos store unvisited neighbors
        //for loop will cycle through the neighbors and add the ones that havent been visited
        for (int i = 0;i < neighbors.size();i++){
            if (!neighbors.get(i).isVisited()){
                notVisited.add(neighbors.get(i));
            }
        }
        int num = rand.nextInt(notVisited.size());//generates random index
        return notVisited.get(num);//returns neighbor
    }

    //this method will remove the walls between two tiles
    public void removeWalls(Tile newTile){
        //checks what column or row the newtile is in and removes the wall between them
        if (newTile.getRow() - 1 == row){
            setDownWall(false);
            newTile.setUpWall(false);
        }
        else if (newTile.getRow() + 1 == row){
            setUpWall(false);
            newTile.setDownWall(false);
        }
        else if (newTile.getCol() - 1 == col){
            setRightWall(false);
            newTile.setLeftWall(false);
        }
        else if (newTile.getCol() + 1 == col){
            setLeftWall(false);
            newTile.setRightWall(false);
        }
    }




}
