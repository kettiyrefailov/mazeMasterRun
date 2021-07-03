import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MazeScene extends JPanel {
    private ImageIcon imageIcon;
    private JButton start;
    private JLabel moveCounter;
    private JButton pause ;
    private int moves ;
    private Beetle beetle;
    private List<Rectangle> walls;
    public  Maze maze;

    public MazeScene() {
        this.setDoubleBuffered(true);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.start = new JButton("START");
        this.moveCounter = new JLabel("Moves: 0");
       // this.pause = new JButton("PAUSE");
        this.start.setBounds(0,0,Definitions.BUTTON_WIDTH,Definitions.BUTTON_HEIGHT);
        this.moveCounter.setBounds(Definitions.BUTTON_WIDTH+30 , 0, Definitions.MOVES_COUNTER_LABEL_WIDTH, Definitions.MOVES_COUNTER_LABEL_HEIGHT );
        //this.pause.setBounds(Definitions.BOARD_WIDTH-Definitions.BUTTON_WIDTH,0,Definitions.BUTTON_WIDTH,Definitions.BUTTON_HEIGHT);

        this.add(start);
        this.add(moveCounter);

        this.buildMaze(); // build the walls and pass the information to beetle. (in paint method we pass it to Maze as well
        this.beetle=new Beetle(Definitions.BEETLE_STARTING_X+5,Definitions.BEETLE_STARTING_Y+5,walls);
        this.imageIcon =new ImageIcon("images/maze.png");
        this.mainGameLoop();
    }

    public void buildMaze(){
        maze = new Maze();
        walls = maze.rectangleList;
    }

    public void mainGameLoop(){
        new Thread(() -> {
            while (true){

                repaint();


                try {
                    this.moveCounter.setText("Moves: " + this.beetle.getCounter() );
                    Thread.sleep(25);

                }
                catch (InterruptedException exception){
                    exception.printStackTrace();
                }
            }
        }) .start();

    }


    public void paint(Graphics graphics) {
        super.paint(graphics);
        beetle.paint(graphics,this);
        maze.paint(graphics);

    }

    public void setMaze() {
        Image image = imageIcon.getImage() ;
        Image newImage = image.getScaledInstance(Definitions.BOARD_WIDTH,Definitions.BOARD_HEIGHT,java.awt.Image.SCALE_SMOOTH);
        this.imageIcon =new ImageIcon(newImage);
    }

    public Beetle getBeetle() {
        return beetle;
    }

}
