import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
//        File image = new File("C:\\Users\\sofer\\OneDrive\\שולחן העבודה\\image\\familyGuy.jpg");
//        try {
//            BufferedImage imageFile = ImageIO.read(image);
//            int rgb = imageFile.getRGB(0, 0);
//            Color color = new Color(rgb);
//            System.out.println("RED : " + color.getRed());
//            System.out.println("GREEN : " + color.getGreen());
//            System.out.println("BLUE : " + color.getBlue());
//            int width = imageFile.getWidth();
//            int height = imageFile.getHeight();
//            for (int x = 0; x < width; x++){
//                for (int y = 0; y < height; y+=2){
//                    Color color1 = Color.black;
//                    imageFile.setRGB(x,y,color1.getRGB());
//                }
//                File file = new File("C:\\Users\\sofer\\OneDrive\\שולחן העבודה\\image\\output.jpg");
//                ImageIO.write(imageFile,"jpg",file);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }

}

