import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.*;

public class ShowPrisoners {
    private JTable table1;
    private JPanel panel1;

    public ShowPrisoners(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Prison","root","pluralsight");
            PreparedStatement st = con.prepareStatement("select * from Prisoners;");
            ResultSet rs = st.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("ShowPrisoners");
        frame.setContentPane(new ShowPrisoners().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
