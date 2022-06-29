import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class PanelImage extends JPanel {

    private BufferedImage originalImage;
    private BufferedImage newImage;
    private URL url;


    public PanelImage(int x, int y, int width, int height, URL url) {
        try {
            this.setLayout(null);
            this.setBounds(x, y, width, height);
            JLabel pic = new JLabel();
            JLabel pic2 = new JLabel();
            this.url = url;
            this.originalImage = pic(x, y, width / 2, height, pic);
            this.newImage = pic(Final.WINDOW_WIDTH - Final.X_SEARCH_BUTTON, y, Final.X_SEARCH_BUTTON, height, pic2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public BufferedImage pic(int x, int y, int width, int height, JLabel pic) throws IOException {
        pic.setBounds(x, y, width, height);
        BufferedImage bufferedImage = ImageIO.read(this.url);
        Image image = resize(bufferedImage, Final.X_SEARCH_BUTTON, height);
        BufferedImage buffer = (BufferedImage) image;
        pic.setIcon(new ImageIcon(image));
        this.add(pic);
        return buffer;

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
        g2d.drawImage(tmp, Final.X_AND_Y, Final.X_AND_Y, null);
        g2d.dispose();

        return resized;
    }
    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(BufferedImage originalImage) {
        this.originalImage = originalImage;
    }

    public BufferedImage getNewImage() {
        return newImage;
    }

    public void setNewImage(BufferedImage newImage) {
        this.newImage = newImage;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}