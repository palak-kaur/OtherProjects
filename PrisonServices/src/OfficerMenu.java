import javax.swing.*;

public class OfficerMenu {
    private JButton ADDAOFFICERButton;
    private JButton REMOVEAOFFICERButton;
    private JPanel panel1;
    private JButton SHOWOFFICERSButton;

    public static void main(String[] args) {



        JFrame frame = new JFrame("OfficerMenu");
        frame.setContentPane(new OfficerMenu().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
