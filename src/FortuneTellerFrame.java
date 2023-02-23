import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FortuneTellerFrame extends JFrame
{
    private JPanel mainPanel, topPanel, middlePanel, bottomPanel;
    private JLabel title;
    private ImageIcon imageIcon;
    private JLabel imageLable;
    private JTextArea fortuneTextArea;
    private JScrollPane scroll;
    private JButton quitButton, newFortuneButton;
    private ActionListener quit = new QuitListener();
    private ActionListener newFortune = new FortuneListener();
    private int timePressed = 0;

    private String[] fortunes =
            {
                    "You and Love will meet again", // 1
                    "The end could happen anyday, so be grateful always", // 2
                    "Darkness is within you", // 3
                    "Love, & Happiness is coming", // 4
                    "Be the one that makes a difference", // 5
                    "All you have is yourself sometimes, but thats ok", // 6
                    "Life is precious", // 7
                    "Happiness is coming", // 8
                    "Your past is your past, the future is the future, the present is what matters", // 9
                    "Times will get easier as time keeps moving", // 10
                    "Here is your sign", // 11
                    "Press the button again, and your fortune may grow", // 12
            };

    public FortuneTellerFrame()
    {
        setTitle("Fortune Teller");
        setSize(1000,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();

        title = new JLabel("Welcome to the Fortune Teller");
        imageIcon = new ImageIcon("FortuneTellerPic.jpg");

        Image image = imageIcon.getImage();
        Image newIMG = image.getScaledInstance(150,100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon((newIMG));

        imageLable = new JLabel(imageIcon);
        fortuneTextArea = new JTextArea(12,40);
        scroll = new JScrollPane(fortuneTextArea);
        newFortuneButton = new JButton("Read my New Fortune!");
        newFortuneButton.addActionListener(newFortune);
        quitButton = new JButton("Quit");
        quitButton.addActionListener(quit);

        add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new GridLayout(2,1));
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new GridLayout(1,2));

        topPanel.add(title);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        topPanel.add(imageLable);

        middlePanel.add(scroll);
        fortuneTextArea.setFont(new Font("Times New Roman", Font.BOLD, 28));

        bottomPanel.add(newFortuneButton);
        newFortuneButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 38));
        bottomPanel.add(quitButton);
        quitButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 38));
    }

    private class QuitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.exit(0);
        }
    }

    private class FortuneListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            int i = (int)((Math.random() * (12 - 1)) + 1);

            while (i == timePressed)
            {
                i = (int)((Math.random() * (12 - 1)) + 1);
            }
            timePressed = i;

            fortuneTextArea.append(fortunes[i] + "\n");
        }
    }
}