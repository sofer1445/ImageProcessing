import javax.swing.*;


public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        this.setTitle("Image Processing");
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
        this.add(new MainPanel(Final.X_AND_Y, Final.X_AND_Y, Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT));
        this.setVisible(true);


    }


}

