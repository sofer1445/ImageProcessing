import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Panel extends JPanel {
    public Panel(int x, int y, int width, int height) {
        try {
            this.setLayout(null);
            this.setBounds(x, y, width, height);
            JLabel pic = new JLabel();
            JLabel pic2 = new JLabel();
            pic.setBounds(x, y, width / 2, height);
            pic2.setBounds(800,y,600, height);
//          File file = new File("C:\\Users\\sofer\\OneDrive\\שולחן העבודה\\image\\familyGuy.jpg");
            URL url = new URL("https://sport1images.maariv.co.il/image/upload/1099630");

            BufferedImage bufferedImage = ImageIO.read(url);
            Image image = resize(bufferedImage, Final.X_SEARCH_BUTTON, height);
            pic.setIcon(new ImageIcon(image));

            BufferedImage newBuffer = ImageIO.read(url);
            Image imageNew = resize(newBuffer, 600, height);
            pic2.setIcon(new ImageIcon(imageNew));
            this.add(pic);
            this.add(pic2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private BufferedImage resize(BufferedImage img, int width, int height) {

        double scalex = (double) width / img.getWidth();
        double scaley = (double) height / img.getHeight();
        double scale = Math.min(scalex, scaley);

        int w = (int) (img.getWidth() * scale);
        int h = (int) (img.getHeight() * scale);

        Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);

        BufferedImage resized = new BufferedImage(w, h, img.getType());
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resized;
    }


}
