import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowPrisons {
    private JTable table1;
    private JPanel panel1;
    public ShowPrisons(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Prison","root","pluralsight");
            PreparedStatement st = con.prepareStatement("select * from Prisons;");
            ResultSet rs = st.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("ShowPrisons");
        frame.setContentPane(new ShowPrisons().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
