import javax.swing.*;

public class Home {
    private JPanel panel1;
    private JButton officerMenuButton;
    private JButton prisonersMenuButton;
    private JButton prisonMenuButton;
    private JButton signOutButton;

    public static void main(String[] args) {



        JFrame frame = new JFrame("Home");
        frame.setContentPane(new Home().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}