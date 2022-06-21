import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class MainPanel extends JPanel {

    private JTextField textField;
    private JTextField emailAccount;
    private JTextField passwordAccount;
    private JButton searchButton;
    private JButton grayscaleButton;
    private JButton colorShiftRightButton;
    private JButton colorShiftLeftButton;
    private JButton sepiaButton;
    private JButton negativeButton;
    private PanelImage newPanel;
    private ChromeOptions options;
    private ChromeDriver driver;
    private String email;
    private String password;


    public MainPanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        startProgram();
        this.newPanel = new PanelImage(x, y, width, height);
        this.add(newPanel);
        this.options = new ChromeOptions();



    }

    public void loginToAFacebookAccount() {
        options.addArguments("user-data-dir=C:\\Users\\sofer\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sofer\\OneDrive\\שולחן העבודה\\image\\chromedriver_win32 (1)\\chromedriver.exe");//שוהם
        this.driver = new ChromeDriver(options);
        driver.get("https://he-il.facebook.com/");
        driver.manage().window().maximize();
        Thread thread = new Thread(() -> {
            WebElement enterEmail = driver.findElement(By.id("email"));
            enterEmail.sendKeys(this.email);
            WebElement enterPass = driver.findElement(By.id("pass"));
            enterPass.sendKeys(this.password);
            WebElement logIn = driver.findElement(By.xpath("//*[@id=\"u_0_d_XD\"]"));
            logIn.click();

        });
        thread.start();


    }

    public void startProgram() {

        this.searchButton = new JButton("search Button");
        this.searchButton.setBounds(Final.X_SEARCH_BUTTON, Final.Y_SEARCH_BUTTON, 200, 50);
        this.add(searchButton);
        searchButton.addActionListener(e -> {
            try{
                loginToAFacebookAccount();
            }catch (Exception exception){
                System.out.println(exception);
            }

        });

        this.textField = new JTextField("search");
        this.textField.setBounds(searchButton.getX(), searchButton.getY() - searchButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(textField);

        this.emailAccount = new JTextField("Enter an email");
        this.emailAccount.setBounds(textField.getX() - textField.getWidth(), textField.getY() - textField.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(emailAccount);
        emailAccount.addActionListener(e -> {
            try {
                this.email = emailAccount.getText();
            } catch (Exception exception) {
                System.out.println(exception);
            }

        });

        this.passwordAccount = new JTextField("Enter an password");
        this.passwordAccount.setBounds(emailAccount.getX() + emailAccount.getWidth(), textField.getY() - textField.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(passwordAccount);
        passwordAccount.addActionListener(e -> {
            try {
                this.password = passwordAccount.getText();
            } catch (Exception exception) {
                System.out.println(exception);
            }

        });

        this.grayscaleButton = new JButton("Grayscale Button");
        this.grayscaleButton.setBounds(searchButton.getX(), searchButton.getY() + searchButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(this.grayscaleButton);
        this.grayscaleButton.addActionListener(e -> {
            this.newPanel.setNewImage(grayscaleColor(this.newPanel.getNewImage(), this.newPanel.getNewImage().getWidth(), this.newPanel.getNewImage().getHeight()));
            repaint();
        });

        this.colorShiftRightButton = new JButton("Color Shift Right Button");
        this.colorShiftRightButton.setBounds(grayscaleButton.getX(), grayscaleButton.getY() + grayscaleButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(this.colorShiftRightButton);
        colorShiftRightButton.addActionListener(e -> {
            this.newPanel.setNewImage(colorShiftRight(this.newPanel.getNewImage(), this.newPanel.getNewImage().getWidth(), this.newPanel.getNewImage().getHeight()));
            repaint();
        });

        this.colorShiftLeftButton = new JButton("Color Shift Left Button");
        this.colorShiftLeftButton.setBounds(colorShiftRightButton.getX(), colorShiftRightButton.getY() + colorShiftRightButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(this.colorShiftLeftButton);
        colorShiftLeftButton.addActionListener(e -> {
            this.newPanel.setNewImage(colorShiftLeft(this.newPanel.getNewImage(), this.newPanel.getNewImage().getWidth(), this.newPanel.getNewImage().getHeight()));
            repaint();
        });

        this.sepiaButton = new JButton("Sepia Button");
        this.sepiaButton.setBounds(colorShiftLeftButton.getX(), colorShiftLeftButton.getY() + colorShiftLeftButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(this.sepiaButton);
        sepiaButton.addActionListener(e -> {
            this.newPanel.setNewImage(sepiaColor(this.newPanel.getNewImage(), this.newPanel.getNewImage().getWidth(), this.newPanel.getNewImage().getHeight()));
            repaint();
        });

        this.negativeButton = new JButton("Negative Button");
        this.negativeButton.setBounds(sepiaButton.getX(), sepiaButton.getY() + sepiaButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(this.negativeButton);
        negativeButton.addActionListener(e -> {
            this.newPanel.setNewImage(negative(this.newPanel.getNewImage(), this.newPanel.getNewImage().getWidth(), this.newPanel.getNewImage().getHeight()));
            repaint();
        });
    }

    public BufferedImage negative(BufferedImage bufferedImage, int width, int height) {
        BufferedImage image;
        for (int x = 0; x < width - 1; x++) {
            for (int y = 0; y < height - 1; y++) {
                int currentRgb = bufferedImage.getRGB(x, y);
                Color currentColor = new Color(currentRgb);
                int currentRed = currentColor.getRed();
                int currentGreen = currentColor.getGreen();
                int currentBlue = currentColor.getBlue();
                Color newColor = new Color(255 - currentRed, 255 - currentGreen, 255 - currentBlue);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        image = bufferedImage;
        return image;
    }

    public BufferedImage sepiaColor(BufferedImage bufferedImage, int width, int height) {
        BufferedImage imageSepiaColor;
        for (int x = 0; x < width - 1; x++) {
            for (int y = 0; y < height - 1; y++) {
                int currentRgb = bufferedImage.getRGB(x, y);
                Color currentColor = new Color(currentRgb);
                int currentRed = (int) (currentColor.getRed() * 0.393 + currentColor.getGreen() * 0.769 + currentColor.getBlue() * 0.189);
                if (currentRed >= 255) {
                    currentRed = 255;
                }
                int currentGreen = (int) (currentColor.getRed() * 0.349 + currentColor.getGreen() * 0.686 + currentColor.getBlue() * 0.168);
                if (currentGreen >= 255) {
                    currentGreen = 255;
                }
                int currentBlue = (int) (currentColor.getRed() * 0.272 + currentColor.getGreen() * 0.534 + currentColor.getBlue() * 0.131);
                if (currentBlue >= 255) {
                    currentBlue = 255;
                }
                Color newColor = new Color(currentRed, currentGreen, currentBlue);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        imageSepiaColor = bufferedImage;
        return imageSepiaColor;
    }

    public BufferedImage colorShiftLeft(BufferedImage bufferedImage, int width, int height) {
        BufferedImage colorShiftLeftRGB;
        for (int x = 0; x < width - 1; x++) {
            for (int y = 0; y < height - 1; y++) {
                int currentRgb = bufferedImage.getRGB(x, y);
                Color currentColor = new Color(currentRgb);
                int currentRed = currentColor.getBlue();
                int currentGreen = currentColor.getRed();
                int currentBlue = currentColor.getGreen();
                Color newColor = new Color(currentRed, currentGreen, currentBlue);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        colorShiftLeftRGB = bufferedImage;
        return colorShiftLeftRGB;
    }

    public BufferedImage colorShiftRight(BufferedImage bufferedImage, int width, int height) {
        BufferedImage colorShiftLeftRGB;
        for (int x = 0; x < width - 1; x++) {
            for (int y = 0; y < height - 1; y++) {
                int currentRgb = bufferedImage.getRGB(x, y);
                Color currentColor = new Color(currentRgb);
                int currentRed = currentColor.getGreen();
                int currentGreen = currentColor.getBlue();
                int currentBlue = currentColor.getRed();
                Color newColor = new Color(currentRed, currentGreen, currentBlue);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        colorShiftLeftRGB = bufferedImage;
        return colorShiftLeftRGB;
    }

    public BufferedImage grayscaleColor(BufferedImage bufferedImage, int width, int height) {
        BufferedImage grayscale;
        for (int x = 0; x < width - 1; x++) {
            for (int y = 0; y < height - 1; y++) {
                int currentRgb = bufferedImage.getRGB(x, y);
                Color currentColor = new Color(currentRgb);
                int currentRed = (int) (currentColor.getRed() * 0.299);
                int currentGreen = (int) (currentColor.getGreen() * 0.587);
                int currentBlue = (int) (currentColor.getBlue() * 0.114);
                int gray = currentRed + currentGreen + currentBlue;
                Color newColor = new Color(gray, gray, gray);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        grayscale = bufferedImage;
        return grayscale;
    }
}




