import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.String;
import java.sql.Statement;

public class AddOfficer {
    private JTextField Officer_id;
    private JTextField Name;
    private JTextField Location;
    private JTextField Post;
    private JTextField date;
    private JTextField username;
    private JTextField date1;
    private JTextField salary;
    private JTextField month;
    private JTextField year;
    private JTextField month1;
    private JTextField year1;
    private JButton insertButton;
    private JPanel panel1;

    public AddOfficer() {
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Prison","root","pluralsight");
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into Officer\n" +
                            " VALUES("+Officer_id.getText()+",'"+Name.getText()+"','"+Location.getText()+"','"+Post.getText()+"','"+year.getText()+"-"+month.getText()+"-"+date.getText()+"',"+salary.getText()+",'"+year1.getText()+"-"+month1.getText()+"-"+date1.getText()+"','"+username.getText()+"','"+username.getText()+"');");
                    JOptionPane.showMessageDialog(null, "INSERTED SUCCESSFULLY!");

                    con.close();
                }catch(Exception e){ System.out.println(e);}

            }
        });
    }

    public static void main(String[] args) {



        JFrame frame = new JFrame("AddOfficer");
        frame.setContentPane(new AddOfficer().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
