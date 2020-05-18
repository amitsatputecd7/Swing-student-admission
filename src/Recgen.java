import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
public class Recgen {

    Recgen()
    {

        try {

              Class.forName("com.mysql.jdbc.Driver");
              System.out.println("reg");
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","amit123");
              System.out.println("connected");

              Statement st=con.createStatement();



                ResultSet rs = st.executeQuery("SELECT * FROM admits ORDER BY ID DESC LIMIT "+1+"");


                    rs.next();
                        int idp = rs.getInt(1);
                        idp = idp - 1;
                        System.out.print(idp);
                        ResultSet rs1=st.executeQuery("SELECT recipt FROM admits where id="+idp+"");
                        rs1.next();
                        int rec=rs1.getInt(1);
                        rec=rec+1;
                        idp=idp+1;
                        st.executeUpdate("update admits set recipt="+rec+" where id="+idp+"");
                        System.out.println("rec done");

            }catch (Exception e1)
            {
                System.out.println("rec fail");

            }

    }
}



