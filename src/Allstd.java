import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
public class Allstd{

    Allstd()
    {
        JFrame fa=new JFrame("ALL STUDENTS IN INSTITUTE");

        String[] columnnames = {"ID","NAME","MOB NO1","MOB NO2","WHATSAPP","EMAIL","SEX","DOB","ADDRESS","EMPLOYED","COURSE","EDUCATION","FEES","PAID","PENDING","DOA","RECEIPT","SCHEDULE"};


        DefaultTableModel tableModel = new DefaultTableModel( columnnames,0);





        try {


            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("reg");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","amit123");
            System.out.println("connected");

            Statement st=con.createStatement();


                ResultSet rs = st.executeQuery("select * from admits");
               rs.beforeFirst();
            System.out.println("query passed");

                tableModel.addRow(columnnames);
                //tableModel.addRow();

                while (rs.next()) {
                   String id =String.valueOf(rs.getInt(1));
                   String name=rs.getString(2);
                   String mn1= rs.getString(3);
                   String mn2=rs.getString(4);
                    String wt=rs.getString(5);
                   String eml=rs.getString(6);
                   String sx=rs.getString(7);
                   String dob=rs.getString(8);
                   String  adr= rs.getString(9);
                   String empl=rs.getString(10);
                   String crs=rs.getString(11);
                   String edu= rs.getString(12);
                   String fes=rs.getString(13);
                  String pd=rs.getString(14);
                  String pend=rs.getString(15);
                   String doa=rs.getString(16);
                  String rec=String.valueOf(rs.getInt(17));
                   String sch=rs.getString(18);

                    String data[]={id,name,mn1,mn2,wt,eml,sx,dob,adr,empl,crs,edu,fes,pd,pend,doa,rec,sch};
                    System.out.println("data assigned");
                  tableModel.addRow(data);
                    System.out.println(id);
                }


            JTable jt=new JTable(tableModel);



            jt.setBounds(40,40,1300,750);
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
