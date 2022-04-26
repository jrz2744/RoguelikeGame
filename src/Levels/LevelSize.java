package Levels;

public class LevelSize {

    private int xSize;
    private int ySize;

    public LevelSize(int x, int y){
        this.xSize = x;
        this.ySize = y;
    }

    public int getXSize() {
        return this.xSize;
    }

    public int getYSize() {
        return this.ySize;
    }

    /**
     * Returns the size x by y as an array [x, y]
     * @return array of x and y sizes
     */
    public int[] getSize(){
        int[] size = new int[2];
        size[0] = this.xSize;
        size[1] = this.ySize;
        return size;
    }
}
