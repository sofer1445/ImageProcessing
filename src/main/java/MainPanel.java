import javax.swing.*;

public class MainPanel extends JPanel {

    private JTextField textField;
    private JButton searchButton;
    private JButton grayscaleButton;
    private JButton colorShiftRightButton;
    private JButton colorShiftLeftButton;
    private JButton sepiaButton;
    private JButton negativeButton;


    public MainPanel(int x, int y, int width, int height) {
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        startProgram();
        Panel panel = new Panel(x,y,width,height);
        this.add(panel);
    }


    public void startProgram(){

        this.searchButton = new JButton("search Button");
        this.searchButton.setBounds(Final.X_SEARCH_BUTTON, Final.Y_SEARCH_BUTTON, 200, 50);
        this.add(searchButton);

        this.textField = new JTextField("search");
        this.textField.setBounds(searchButton.getX(),searchButton.getY() - searchButton.getHeight(),searchButton.getWidth(),searchButton.getHeight());
        this.add(textField);

        this.grayscaleButton = new JButton("Grayscale Button");
        this.grayscaleButton.setBounds(searchButton.getX(), searchButton.getY()+searchButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(this.grayscaleButton);

        this.colorShiftRightButton = new JButton("Color Shift Right Button");
        this.colorShiftRightButton.setBounds(grayscaleButton.getX(), grayscaleButton.getY()+grayscaleButton.getHeight(),searchButton.getWidth(), searchButton.getHeight());
        this.add(this.colorShiftRightButton);

        this.colorShiftLeftButton = new JButton("Color Shift Left Button");
        this.colorShiftLeftButton.setBounds(colorShiftRightButton.getX(), colorShiftRightButton.getY()+colorShiftRightButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(this.colorShiftLeftButton);

        this.sepiaButton = new JButton("Sepia Button");
        this.sepiaButton.setBounds(colorShiftLeftButton.getX(), colorShiftLeftButton.getY()+colorShiftLeftButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(this.sepiaButton);

        this.negativeButton = new JButton("Negative Button");
        this.negativeButton.setBounds(sepiaButton.getX(), sepiaButton.getY()+sepiaButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(this.negativeButton);
    }
}
