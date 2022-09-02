import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddPrison {
    private JTextField phone;
    private JTextField prison_id;
    private JTextField location;
    private JTextField total_cells;
    private JTextField free_cells;
    private JButton insertButton;
    private JPanel panel1;

    public AddPrison() {
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Prison","root","pluralsight");
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into Prisons\n" +
                            " VALUES("+prison_id.getText()+",'"+location.getText()+"',"+total_cells.getText()+","+free_cells.getText()+","+phone.getText()+");");
                    JOptionPane.showMessageDialog(null, "INSERTED SUCCESSFULLY!");

                    con.close();
                }catch(Exception e){ System.out.println(e);}
            }
        });
    }
    public static void main(String[] args) {



        JFrame frame = new JFrame("AddPrison");
        frame.setContentPane(new AddPrison().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
