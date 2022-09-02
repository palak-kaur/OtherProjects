import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login {
    private JPanel panel1;
    private JButton login;
    private JPasswordField password;
    private JTextField username;

    public Login() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try{

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Prison","root","pluralsight");
                    String us = username.getText();
                    String pass = password.getText();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select username from officer where username = '"+us+"' AND pasword = '"+pass+"'");
                       if(rs.next()) {
                           /* Home nextt = new Home();
                           nextt.setVisible(true); */
                           JOptionPane.showMessageDialog(null, "welcome " + rs.getString(1));

                                                            }
                        else{

                            JOptionPane.showMessageDialog(null,"INVALID CREDENTIALS.");
                        }

                    con.close();
                }catch(Exception e){ System.out.println(e);}
            }
        });
    }

    public static void main(String[] args) {



        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}




