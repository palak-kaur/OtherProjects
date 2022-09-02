import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddPrisoners {
    private JButton insertButton;
    private JTextField prisoner_id;
    private JTextField pname;
    private JTextField crime;
    private JTextField date;
    private JTextField month;
    private JTextField year;
    private JTextField date1;
    private JTextField month1;
    private JTextField year1;
    private JTextField location;
    private JPanel panel1;

    public AddPrisoners() {
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Prison","root","pluralsight");
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into Prisoners\n" +
                            " VALUES("+prisoner_id.getText()+",'"+crime.getText()+"','"+location.getText()+"','"+year.getText()+"-"+month.getText()+"-"+date.getText()+"','"+year1.getText()+"-"+month1.getText()+"-"+date1.getText()+"','"+pname.getText()+"');");
                    JOptionPane.showMessageDialog(null, "INSERTED SUCCESSFULLY!");

                    con.close();
                }catch(Exception e){ System.out.println(e);}
            }
        });
    }
    public static void main(String[] args) {



        JFrame frame = new JFrame("AddPrisoners");
        frame.setContentPane(new AddPrisoners().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



}

