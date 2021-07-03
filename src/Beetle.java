import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Beetle  {
    private ImageIcon beetle;
    private int x ;
    private int y ;
    private int counter;
    private List<Rectangle> walls;
    public Beetle(int x , int y, List<Rectangle> walls) {
        this.beetle=new ImageIcon("images/beetle.jpg");
       this.x =x ;
       this.y=y;
        this.walls = walls;
    }



    public void paint(Graphics graphics,MazeScene mazeScene){
        this.beetle.paintIcon(mazeScene,graphics,x,y);

    }


    public int getCounter() {
        return counter;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    private boolean canMove(Rectangle rect){
        for(Rectangle wall: walls){
            if (wall.intersects(rect)){
                return false;
            }
        }
        return  true;
    }

    public void moveUp(){
        if(canMove(new Rectangle(this.x, this.y-Definitions.BEETLE_HEIGHT/4,Definitions.BEETLE_WIDTH,Definitions.BEETLE_HEIGHT)) ){
            this.y -= Definitions.BEETLE_HEIGHT/4;
            counter++;
        }

    }

    public void moveDown(){
        if(canMove(new Rectangle(this.x, this.y+Definitions.BEETLE_HEIGHT/4,Definitions.BEETLE_WIDTH,Definitions.BEETLE_HEIGHT))) {
            this.y += Definitions.BEETLE_HEIGHT/4;
            counter++;
        }
    }
    public void moveRight(){
        if(canMove(new Rectangle(this.x+Definitions.BEETLE_WIDTH/4, this.y,Definitions.BEETLE_WIDTH,Definitions.BEETLE_HEIGHT))) {
            this.x += Definitions.BEETLE_WIDTH/4;
            counter++;
        }
    }
    public void moveLeft(){
        if(canMove(new Rectangle(this.x-Definitions.BEETLE_WIDTH/4, this.y,Definitions.BEETLE_WIDTH,Definitions.BEETLE_HEIGHT))) {
            this.x -= Definitions.BEETLE_WIDTH/4;
            counter++;
        }
    }


}
