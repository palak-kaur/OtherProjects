import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.*;

public class ShowOfficers {
    private JTable table1;
    private JPanel panel1;
    public ShowOfficers(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Prison","root","pluralsight");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(" select * from Officer;");
            table1.setModel(DbUtils.resultSetToTableModel(rs));

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("ShowOfficer");
        frame.setContentPane(new ShowOfficers().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
