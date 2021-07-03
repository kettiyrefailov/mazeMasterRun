import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;

public class Maze extends JPanel {

    public  List<Rectangle> rectangleList = new ArrayList<>();
    public Maze(){
        addedMazeWalls();

    }

    private void addedMazeWalls(){

        //Upper and Bottom bound
        rectangleList.add(new Rectangle(Definitions.MAZE_STARTING_X, Definitions.MAZE_STARTING_Y, Definitions.MAZE_WIDTH, Definitions.MAZE_HEIGHT));
        rectangleList.add(new Rectangle(Definitions.MAZE_STARTING_X,Definitions.MAZE_ENDING_Y,Definitions.MAZE_WIDTH-Definitions.BEETLE_WIDTH-5,Definitions.MAZE_HEIGHT));
        //Side Walls
        rectangleList.add(new Rectangle(Definitions.MAZE_STARTING_X,Definitions.MAZE_STARTING_Y,Definitions.MAZE_HEIGHT,Definitions.MAZE_ENDING_Y-Definitions.MAZE_STARTING_Y) );
        rectangleList.add(new Rectangle(Definitions.MAZE_STARTING_X+Definitions.MAZE_WIDTH,Definitions.MAZE_STARTING_Y,Definitions.MAZE_HEIGHT,Definitions.MAZE_ENDING_Y-Definitions.MAZE_STARTING_Y));

        //Inner bounds drawing accroding to Y
        //Line 1
        rectangleList.add(new Rectangle(Definitions.MAZE_WIDTH_BORDERS,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS,Definitions.MAZE_WIDTH_BORDERS/2,Definitions.MAZE_HEIGHT));
        rectangleList.add(new Rectangle(Definitions.MAZE_WIDTH_BORDERS+300,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS,Definitions.MAZE_WIDTH_BORDERS/2,Definitions.MAZE_HEIGHT));
        rectangleList.add(new Rectangle(Definitions.MAZE_WIDTH_BORDERS+600,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS,Definitions.MAZE_WIDTH_BORDERS,Definitions.MAZE_HEIGHT));
        //line 2
        rectangleList.add(new Rectangle(Definitions.MAZE_STARTING_X,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS *3,Definitions.MAZE_WIDTH_BORDERS/2,Definitions.MAZE_HEIGHT));
        rectangleList.add(new Rectangle(Definitions.MAZE_WIDTH_BORDERS+450,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS *2,Definitions.MAZE_WIDTH_BORDERS/2, Definitions.MAZE_HEIGHT));
        rectangleList.add(new Rectangle(Definitions.MAZE_WIDTH-Definitions.MAZE_HEIGHT,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS *2,Definitions.MAZE_WIDTH_BORDERS/2,Definitions.MAZE_HEIGHT));
        //line 3
        rectangleList.add(new Rectangle(Definitions.MAZE_STARTING_X,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS *3,Definitions.MAZE_WIDTH_BORDERS/2,Definitions.MAZE_HEIGHT));
        rectangleList.add(new Rectangle(Definitions.MAZE_WIDTH_BORDERS+300,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS *3,Definitions.MAZE_WIDTH_BORDERS/2,Definitions.MAZE_HEIGHT));
        rectangleList.add(new Rectangle(Definitions.MAZE_WIDTH_BORDERS+500,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS*3,Definitions.MAZE_WIDTH_BORDERS,Definitions.MAZE_HEIGHT));
        //line 4
        rectangleList.add(new Rectangle(Definitions.MAZE_STARTING_X+100,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS*4-Definitions.BEETLE_HEIGHT/2,Definitions.MAZE_WIDTH_BORDERS,Definitions.MAZE_HEIGHT));
        rectangleList.add(new Rectangle(Definitions.MAZE_WIDTH_BORDERS+300,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS*4-Definitions.BEETLE_HEIGHT/2,Definitions.MAZE_WIDTH_BORDERS,Definitions.MAZE_HEIGHT));
        rectangleList.add(new Rectangle(Definitions.MAZE_WIDTH-Definitions.MAZE_HEIGHT-Definitions.MAZE_HEIGHT_BETWEEN_BORDERS,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS*4-Definitions.BEETLE_HEIGHT/2,Definitions.MAZE_WIDTH_BORDERS,Definitions.MAZE_HEIGHT));
        //Column Drawing
        rectangleList.add(new Rectangle(Definitions.MAZE_WIDTH_BORDERS,Definitions.MAZE_STARTING_Y+Definitions.MAZE_HEIGHT_BETWEEN_BORDERS,Definitions.MAZE_HEIGHT,Definitions.MAZE_WIDTH_BORDERS/2));

    }


    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        //upperbounds of the maze

        for(Rectangle rectangle : rectangleList) {
            graphics.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }


}
