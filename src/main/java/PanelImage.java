import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class PanelImage extends JPanel {

    private BufferedImage originalImage;
    private BufferedImage newImage;

    public PanelImage(int x, int y, int width, int height) {
        try {
            this.setLayout(null);
            this.setBounds(x, y, width, height);
            JLabel pic = new JLabel();
            JLabel pic2 = new JLabel();
            URL url = new URL("https://sport1images.maariv.co.il/image/upload/1099630");
            this.originalImage = pic(x, y, width / 2, height, url, pic);
            this.newImage = pic(Final.WINDOW_WIDTH - Final.X_SEARCH_BUTTON, y, Final.X_SEARCH_BUTTON, height, url, pic2);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
//        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
//        Graphics2D graphics2D = resizedImage.createGraphics();
//        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
//        graphics2D.dispose();
//        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//קומבינות לשיפור תמונה
//        return resizedImage;
//    }
//    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
//        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
//        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
//        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
//        return outputImage;
//    }
    public BufferedImage pic(int x, int y, int width, int height, URL url, JLabel pic) throws IOException {
        pic.setBounds(x, y, width, height);
        BufferedImage bufferedImage = ImageIO.read(url);
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
        g2d.drawImage(tmp, 0, 0, null);
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


}
