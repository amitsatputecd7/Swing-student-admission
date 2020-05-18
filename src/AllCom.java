import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;

public class AllCom
{
    AllCom()
    {
        JFrame fa=new JFrame("COMPANY LIST");

        String[] columnnames = {"ID","NAME","POST","DESCRIPTION","SALARY","CITY","INVOKED","REQUIREMENTS"};


        DefaultTableModel tableModel = new DefaultTableModel( columnnames,0);

        try {


            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("reg");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","amit123");
            System.out.println("connected");

            Statement st=con.createStatement();


            ResultSet rs = st.executeQuery("select * from company1");
            rs.beforeFirst();
            System.out.println("query passed");

            tableModel.addRow(columnnames);

            while (rs.next()) {
                String id =String.valueOf(rs.getInt(1));
                String name=rs.getString(2);
                String mn1= rs.getString(3);
                String mn2=rs.getString(4);
                String wt=rs.getString(5);
                String eml=rs.getString(6);
                String sx=rs.getString(7);

                String  adr= rs.getString(8);

                String data[]={id,name,mn1,mn2,wt,eml,sx,adr};
                System.out.println("data assigned");
                tableModel.addRow(data);
                System.out.println(id);
            }


            JTable jt=new JTable(tableModel);


            jt.setBounds(10,20,1300,768);
            fa.add(jt);
            con.close();

        }catch (Exception e1)
        {
            System.out.println("failed");
            //tempf.setText("NOT FOUND / INVALID INPUT");
        }


        fa.setSize(1366,768);
        fa.setLayout(null);
        fa.setVisible(true);

    }
}
