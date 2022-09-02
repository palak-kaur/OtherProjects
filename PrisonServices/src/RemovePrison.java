import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RemovePrison {
    private JPanel panel1;
    private JTextField textField1;
    private JButton deleteButton;

    public RemovePrison() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Prison","root","pluralsight");
                    Statement st = con.createStatement();
                    st.executeUpdate("DELETE FROM Prisons WHERE prison_id = "+textField1.getText()+" ;");
                    JOptionPane.showConfirmDialog(null, "are you sure you want to continue?");
                    JOptionPane.showMessageDialog(null, "DELETED!");

                    con.close();
                }catch(Exception e){ System.out.println(e);}
            }
        });
    }
    public static void main(String[] args) {



        JFrame frame = new JFrame("RemovePrison");
        frame.setContentPane(new RemovePrison().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
