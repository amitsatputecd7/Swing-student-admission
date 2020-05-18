import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
public class ConSearch
{
    ConSearch()
    {
        JFrame fs=new JFrame("COMPANY RECORD");
        JLabel nm,id,tempf=new JLabel();
        JTextField nmf,idf;
        JButton sch,bck;

        JLabel  id1=new JLabel("ID:"),nm1=new JLabel("COMPANY NAME :"),mn1=new JLabel("POST :"),mn2=new JLabel("DESCRIPTION :"),w1=new JLabel("SALARY :"),em1=new JLabel("CITY :"),emp1=new JLabel("DESIRED EXPERIENCE OF :");

        JLabel  id1f=new JLabel(),nm1f=new JLabel(),mn1f=new JLabel(),mn2f=new JLabel(),w1f=new JLabel(),em1f=new JLabel(),emp1f=new JLabel();

        JButton del=new JButton("DELETE RECORD"); del.setBackground(Color.RED);
        del.setBounds(340,420,160,26);
        tempf.setBounds(430,445,500,100);

        id1.setBounds(20,150,150,20);     id1f.setBounds(140,150,450,20);
        nm1.setBounds(20,190,150,20);   nm1f.setBounds(140,190,450,20);
        mn1.setBounds(20,230,150,50);   mn1f.setBounds(140,230,450,20);
        mn2.setBounds(20,310,150,20);  mn2f.setBounds(140,310,450,20);
        w1.setBounds(20,350,150,20);    w1f.setBounds(140,350,450,20);
        em1.setBounds(20,390,150,20);   em1f.setBounds(140,390,450,20);

        emp1.setBounds(330,150,150,20);  emp1f.setBounds(510,150,450,20);


        nm=new JLabel("NAME :");      id=new JLabel("ID :");
        nmf=new JTextField(null);               idf=new JTextField(null);
        sch=new JButton("SEARCH");     bck=new JButton("BACK");

        nm.setBounds(10,20,150,20);  id.setBounds(360,20,150,20);

        nmf.setBounds(130,20,190,20); idf.setBounds(420,20,150,20);

        sch.setBounds(130,60,100,26);  bck.setBounds(250,60,100,26);



        idf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }
        });
        bck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fs.setVisible(false);
            }
        });





        sch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // String nmfs,idfs,rptfs;
                //tempf.setText("");
                tempf.setVisible(false);
                String idfs1 = idf.getText(); String nmfs = nmf.getText();

                try {


                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("reg");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","amit123");
                    System.out.println("connected");

                    Statement st=con.createStatement();


                    try {
                        ResultSet rs1 = st.executeQuery("select * from company1 where ID="+idfs1+"");
                        while (rs1.next()) {
                            id1f.setText(String.valueOf(rs1.getInt(1)));
                            nm1f.setText(rs1.getString(2));
                            mn1f.setText(rs1.getString(3));
                            mn2f.setText(rs1.getString(4));
                            w1f.setText(rs1.getString(5));
                            em1f.setText(rs1.getString(6));

                            emp1f.setText(rs1.getString(7));

                        }


                    }catch (Exception e1)
                    {   try{ ResultSet rs3 = st.executeQuery("select * from company1 where name LIKE '%" + nmfs + "%'");
                        while (rs3.next()) {

                            id1f.setText(String.valueOf(rs3.getInt(1)));
                            nm1f.setText(rs3.getString(2));
                            mn1f.setText(rs3.getString(3));
                            mn2f.setText(rs3.getString(4));
                            w1f.setText(rs3.getString(5));
                            em1f.setText(rs3.getString(6));
                            emp1f.setText(rs3.getString(7));

                        }
                    }
                    catch (Exception e11)
                    {
                        System.out.print("not found");
                    }
                    }


                    con.close();
                    del.setVisible(true);

                }catch (Exception e1)
                {
                    //tempf.setText("NOT FOUND / INVALID INPUT");
                }

            }
        });

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)throws ClassCastException {
                String idel=id1f.getText();


                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("reg");
                    Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","amit123");
                    System.out.println("connected");
                    Statement st=con1.createStatement();
                    st.executeUpdate("delete from company1 where id="+idel+"");
                    System.out.println("rec deleted");
                    tempf.setVisible(true);


                } catch (Exception e1) {
                    System.out.println("rec not deleted");
                    e1.printStackTrace();
                }


            }
        });
        del.setVisible(false);  tempf.setVisible(false); fs.add(del);

        fs.add(nm); fs.add(id);
        fs.add(nmf); fs.add(idf);
        fs.add(sch); fs.add(bck);

        fs.add(id1); fs.add(nm1);fs.add(mn1);fs.add(mn2);fs.add(w1);fs.add(em1);fs.add(emp1);
        fs.add(id1f); fs.add(nm1f);fs.add(mn1f);fs.add(mn2f);fs.add(w1f);fs.add(em1f);fs.add(emp1f);
        fs.setSize(800,630);
        fs.setLayout(null);
        fs.setVisible(true);


    }
}
