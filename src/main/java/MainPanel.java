import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.image.BufferedImage;

//מטלה של עיבוד תמונה אופן שימוש: צעד ראשון הכנסת פרטי פייסבוק (שם משתמש וסיסמא) באופן חד פעמי
// אחר כך הכנסת פרופיל פייסבוק (שם החשבון המיועד) בתיבת הטקסט(search)
// ואז לחיצה על כפתור החיפוש.
// נ.ב חייב פרופיל הפייסבוק המבוקש להיות חבר של החשבון שלך ורק לאחר שהינכם חברים תוכל לייבא את התמונה.

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
    private JButton login;
    private PanelImage newPanel;
    private ChromeOptions options;
    private ChromeDriver driver;
    private String email;
    private String password;
    private String userName;
    private URL url;


    public MainPanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        startProgram();
        this.newPanel = new PanelImage(x, y, width, height, url);
        this.options = new ChromeOptions();
    }

    public void loginToAFacebookAccount() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sofer\\OneDrive\\שולחן העבודה\\image\\chromedriver_win32 (1)\\chromedriver.exe");//שוהם
        options.addArguments("user-data-dir=C:\\Users\\sofer\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        this.driver = new ChromeDriver(options);
        driver.get("https://he-il.facebook.com/");
        driver.manage().window().maximize();
        Thread thread = new Thread(() -> {
            WebElement enterEmail = driver.findElement(By.id("email"));
            enterEmail.sendKeys(this.email);
            WebElement enterPass = driver.findElement(By.id("pass"));
            enterPass.sendKeys(this.password);
            try {
                Thread.sleep(Final.SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement logIn = driver.findElement(By.name("login"));
            logIn.click();

        });
        thread.start();

    }

    public void FindingPeopleAndTakingAPicture() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sofer\\OneDrive\\שולחן העבודה\\image\\chromedriver_win32 (1)\\chromedriver.exe");//שוהם
        options.addArguments("user-data-dir=C:\\Users\\sofer\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        this.driver = new ChromeDriver(options);
        driver.get("https://he-il.facebook.com/");
        driver.manage().window().maximize();
        System.out.println("start: FindingPeopleAndTakingAPicture");
        WebElement webElement = driver.findElement(By.cssSelector("div[aria-label='חפש בפייסבוק']"));
        webElement.click();
        Thread.sleep(Final.SLEEP2);
        WebElement typeName = driver.findElement(By.cssSelector("input[role='combobox']"));
        typeName.sendKeys(this.userName);
        Thread.sleep(Final.SLEEP2);
        WebElement click = driver.findElement(By.cssSelector("span[class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh a8c37x1j fe6kdd0r mau55g9w c8b282yb keod5gw0 nxhoafnm aigsh9s9 d9wwppkn iv3no6db e9vueds3 j5wam9gi b1v8xokw m9osqain hzawbc8m']"));
        click.click();
        Thread.sleep(Final.SLEEP2);
        WebElement imagePro = driver.findElement(By.cssSelector("image[style='height: 168px; width: 168px;']"));
        imagePro.click();
        Thread.sleep(Final.SLEEP2);
        WebElement thisImage = driver.findElement(By.cssSelector("img[class='ji94ytn4 d2edcug0 r9f5tntg r0294ipz']"));
        try {
            this.url = new URL(thisImage.getAttribute("src"));
            PanelImage panelImage = new PanelImage(Final.X_AND_Y,Final.X_AND_Y,Final.WINDOW_WIDTH,Final.WINDOW_HEIGHT,url);
            this.newPanel = panelImage;
            this.add(newPanel);
            repaint();

        } catch (Exception e) {
            System.out.println("doesnt have");
        }
        
    }


    public void startProgram() {
        this.searchButton = new JButton("search Button");
        this.searchButton.setBounds(Final.X_SEARCH_BUTTON, Final.Y_SEARCH_BUTTON, Final.WIDTH_SEARCH, Final.HEIGHT_SEARCH);
        this.add(searchButton);
        searchButton.addActionListener(e -> {
            try {
                this.userName = textField.getText();
                FindingPeopleAndTakingAPicture();
            } catch (Exception exception) {
                System.out.println(exception);
            }

        });

        this.textField = new JTextField("search");
        this.textField.setBounds(searchButton.getX(), searchButton.getY() - searchButton.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(textField);

        this.emailAccount = new JTextField("Enter an email");
        this.emailAccount.setBounds(textField.getX() - textField.getWidth(), textField.getY() - textField.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(emailAccount);

        this.passwordAccount = new JTextField("Enter an password");
        this.passwordAccount.setBounds(emailAccount.getX() + emailAccount.getWidth(), textField.getY() - textField.getHeight(), searchButton.getWidth(), searchButton.getHeight());
        this.add(passwordAccount);

        this.login = new JButton("Login for the first time");
        this.login.setBounds(passwordAccount.getX() + passwordAccount.getWidth(), passwordAccount.getY(), passwordAccount.getWidth(), passwordAccount.getHeight());
        this.add(login);
        login.addActionListener(e -> {
            try {
                this.email = emailAccount.getText();
                this.password = passwordAccount.getText();
                loginToAFacebookAccount();
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
                Color newColor = new Color(Final.NEW_COLOR - currentRed, Final.NEW_COLOR - currentGreen, Final.NEW_COLOR - currentBlue);
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
                int currentRed = (int) (currentColor.getRed() * Final.CURRENT_RED + currentColor.getGreen() * Final.CURRENT_GREEN + currentColor.getBlue() * Final.CURRENT_BLUE);
                if (currentRed >= Final.NEW_COLOR) {
                    currentRed = Final.NEW_COLOR;
                }
                int currentGreen = (int) (currentColor.getRed() * Final.CURRENT_RED2 + currentColor.getGreen() * Final.CURRENT_GREEN2 + currentColor.getBlue() * Final.CURRENT_BLUE2);
                if (currentGreen >= Final.NEW_COLOR) {
                    currentGreen = Final.NEW_COLOR;
                }
                int currentBlue = (int) (currentColor.getRed() * Final.CURRENT_RED3 + currentColor.getGreen() * Final.CURRENT_GREEN3 + currentColor.getBlue() * Final.CURRENT_BLUE3);
                if (currentBlue >= Final.NEW_COLOR) {
                    currentBlue = Final.NEW_COLOR;
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
                int currentRed = (int) (currentColor.getRed() * Final.GRAY_RED);
                int currentGreen = (int) (currentColor.getGreen() * Final.GRAY_GREEN);
                int currentBlue = (int) (currentColor.getBlue() * Final.GRAY_BLUE);
                int gray = currentRed + currentGreen + currentBlue;
                Color newColor = new Color(gray, gray, gray);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }
        grayscale = bufferedImage;
        return grayscale;
    }
}




