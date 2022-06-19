import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Panel extends JPanel {
    public Panel(int x, int y, int width, int height){
        try {
            this.setLayout(null);
            this.setBounds(x, y, width, height);
            JLabel pic = new JLabel();
            pic.setBounds(x, y, width / 2, height);
            File file = new File("C:\\Users\\sofer\\OneDrive\\שולחן העבודה\\image\\familyGuy.jpg");
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = bufferedImage.getScaledInstance(width/2,height,Image.SCALE_SMOOTH );
            pic.setIcon(new ImageIcon(image));
            this.add(pic);
        }catch (Exception e){
            System.out.println(e);
        }
    }


}
