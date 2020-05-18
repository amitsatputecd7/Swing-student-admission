import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
public class Search {


    Search()
    {
        JFrame fs=new JFrame("Search Students");
        JLabel nm,id,rpt;
        JTextField nmf,idf,rptf;
        JButton sch,bck,del;


        JLabel  id1=new JLabel("ID:"),nm1=new JLabel("NAME:"),mn1=new JLabel("MOB NO:"),mn2=new JLabel("MOB NO:"),w1=new JLabel("WHATSAPP:"),em1=new JLabel("EMAIL:"),s1=new JLabel("SEX"),db1=new JLabel("DOB:"),ad1=new JLabel("ADDRESS:"),emp1=new JLabel("EMPLOYED:"),cr1=new JLabel("COURSES:"),ed1=new JLabel("EDUCATION:"),fe1=new JLabel("TOTAL FEE:"),pd1=new JLabel("PAID FEE"),pn1=new JLabel("PENDING FEE:"),da1=new JLabel("ADMISSION:"),rec1=new JLabel("RECEIPT NO:"),sc1=new JLabel("SCHEDULE:");
        JLabel  id1f=new JLabel(),nm1f=new JLabel(),mn1f=new JLabel(),mn2f=new JLabel(),w1f=new JLabel(),em1f=new JLabel(),s1f=new JLabel(),db1f=new JLabel(),ad1f=new JLabel(),emp1f=new JLabel(),cr1f=new JLabel(),ed1f=new JLabel(),fe1f=new JLabel(),pd1f=new JLabel(),pn1f=new JLabel(),da1f=new JLabel(),rec1f=new JLabel(),sc1f=new JLabel();

        id1.setBounds(20,150,150,20);     id1f.setBounds(140,150,450,20);
        nm1.setBounds(20,190,150,20);   nm1f.setBounds(140,190,450,20);
        mn1.setBounds(20,230,150,20);   mn1f.setBounds(140,230,450,20);
        mn2.setBounds(20,270,150,20);  mn2f.setBounds(140,270,450,20);
        w1.setBounds(20,310,150,20);    w1f.setBounds(140,310,450,20);
        em1.setBounds(20,350,150,20);   em1f.setBounds(140,350,450,20);
        s1.setBounds(20,390,150,20);    s1f.setBounds(140,390,450,20);
        db1.setBounds(20,430,150,20);  db1f.setBounds(140,430,450,20);
        ad1.setBounds(20,470,150,20);  ad1f.setBounds(140,470,450,20);
        emp1.setBounds(630,150,150,20);  emp1f.setBounds(740,150,450,20);
        cr1.setBounds(630,190,150,20);   cr1f.setBounds(740,190,450,20);
        ed1.setBounds(630,230,150,20);  ed1f.setBounds(740,230,450,20);
        fe1.setBounds(630,270,150,20);   fe1f.setBounds(740,270,450,20);
        pd1.setBounds(630,310,150,20);  pd1f.setBounds(740,310,450,20);
        pn1.setBounds(630,350,150,20);  pn1f.setBounds(740,350,450,20);
        da1.setBounds(630,390,150,20);  da1f.setBounds(740,390,450,20);
        rec1.setBounds(630,430,150,20);  rec1f.setBounds(740,430,450,20);
        sc1.setBounds(630,470,150,20);  sc1f.setBounds(740,470,450,20);





        nm=new JLabel("NAME :");      id=new JLabel("ID :");      rpt=new JLabel("RECEIPT NO:"); JLabel tempf= new JLabel("RECORD DELETED SUCCESSFULLY.");
        nmf=new JTextField(null);               idf=new JTextField(null);            rptf=new JTextField(null);
        sch=new JButton("SEARCH");     bck=new JButton("BACK");        del=new JButton("DELETE RECORD"); del.setBackground(Color.RED);

        nm.setBounds(10,20,150,20);  id.setBounds(360,20,150,20);     rpt.setBounds(630,20,150,20); tempf.setBounds(630,645,500,100);

        nmf.setBounds(130,20,190,20); idf.setBounds(420,20,150,20);   rptf.setBounds(760,20,150,20);

        sch.setBounds(130,60,100,26);  bck.setBounds(250,60,100,26); del.setBounds(740,620,180,26);

        rptf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }
        });

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
                tempf.setVisible(false);

                String idfs1 = idf.getText();String rptfs = rptf.getText();String nmfs = nmf.getText();

               try {


                   Class.forName("com.mysql.jdbc.Driver");
                   System.out.println("reg");
                   Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","amit123");
                   System.out.println("connected");

                   Statement st=con.createStatement();


                   try {
                       ResultSet rs = st.executeQuery("select * from admits where  recipt=" + rptfs + "");


                       while (rs.next()) {
                           id1f.setText(String.valueOf(rs.getInt(1)));
                           nm1f.setText(rs.getString(2));
                           mn1f.setText(rs.getString(3));
                           mn2f.setText(rs.getString(4));
                           w1f.setText(rs.getString(5));
                           em1f.setText(rs.getString(6));
                           s1f.setText(rs.getString(7));
                           db1f.setText(rs.getString(8));
                           ad1f.setText(rs.getString(9));
                           emp1f.setText(rs.getString(10));
                           cr1f.setText(rs.getString(11));
                           ed1f.setText(rs.getString(12));
                           fe1f.setText(rs.getString(13));
                           pd1f.setText(rs.getString(14));
                           pn1f.setText(rs.getString(15));
                           da1f.setText(rs.getString(16));
                           rec1f.setText(String.valueOf(rs.getString(17)));
                           sc1f.setText(rs.getString(18));

                        // tempf.setText(rs.getString(2));//.setText(String.valueOf(rs.getInt(1)));

                       }


                   }catch (Exception e1)
                   {   try{
                       ResultSet rs1 = st.executeQuery("select * from admits where ID="+idfs1+"");
                       while (rs1.next()) {
                           id1f.setText(String.valueOf(rs1.getInt(1)));
                           nm1f.setText(rs1.getString(2));
                           mn1f.setText(rs1.getString(3));
                           mn2f.setText(rs1.getString(4));
                           w1f.setText(rs1.getString(5));
                           em1f.setText(rs1.getString(6));
                           s1f.setText(rs1.getString(7));
                           db1f.setText(rs1.getString(8));
                           ad1f.setText(rs1.getString(9));
                           emp1f.setText(rs1.getString(10));
                           cr1f.setText(rs1.getString(11));
                           ed1f.setText(rs1.getString(12));
                           fe1f.setText(rs1.getString(13));
                           pd1f.setText(rs1.getString(14));
                           pn1f.setText(rs1.getString(15));
                           da1f.setText(rs1.getString(16));
                           rec1f.setText(String.valueOf(rs1.getString(17)));
                           sc1f.setText(rs1.getString(18));

                           //  tempf.setText(rs1.getString(2));
                           //.setText(String.valueOf(rs.getInt(1)));

                       }}catch (Exception e11){
                       ResultSet rs3 = st.executeQuery("select * from admits where name LIKE '%" + nmfs + "%'");
                       while (rs3.next()) {

                               id1f.setText(String.valueOf(rs3.getInt(1)));
                               nm1f.setText(rs3.getString(2));
                               mn1f.setText(rs3.getString(3));
                               mn2f.setText(rs3.getString(4));
                               w1f.setText(rs3.getString(5));
                               em1f.setText(rs3.getString(6));
                               s1f.setText(rs3.getString(7));
                               db1f.setText(rs3.getString(8));
                               ad1f.setText(rs3.getString(9));
                               emp1f.setText(rs3.getString(10));
                               cr1f.setText(rs3.getString(11));
                               ed1f.setText(rs3.getString(12));
                               fe1f.setText(rs3.getString(13));
                               pd1f.setText(rs3.getString(14));
                               pn1f.setText(rs3.getString(15));
                               da1f.setText(rs3.getString(16));
                               rec1f.setText(String.valueOf(rs3.getString(17)));
                               sc1f.setText(rs3.getString(18));



                       }
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
                    st.executeUpdate("delete from admits where id="+idel+"");
                    System.out.println("rec deleted");
                    tempf.setVisible(true);


                } catch (Exception e1) {
                    System.out.println("rec not deleted");
                    e1.printStackTrace();
                }


            }
        });
        del.setVisible(false);  tempf.setVisible(false);
        fs.add(nm); fs.add(id); fs.add(rpt); fs.add(tempf);
        fs.add(nmf); fs.add(idf); fs.add(rptf);
        fs.add(sch); fs.add(bck); fs.add(del);

        fs.add(id1); fs.add(nm1);fs.add(mn1);fs.add(mn2);fs.add(w1);fs.add(em1);fs.add(s1);fs.add(db1);fs.add(ad1);fs.add(emp1);fs.add(cr1);fs.add(ed1);fs.add(fe1);fs.add(pd1);fs.add(pn1);fs.add(da1);fs.add(rec1);fs.add(sc1);
        fs.add(id1f); fs.add(nm1f);fs.add(mn1f);fs.add(mn2f);fs.add(w1f);fs.add(em1f);fs.add(s1f);fs.add(db1f);fs.add(ad1f);fs.add(emp1f);fs.add(cr1f);fs.add(ed1f);fs.add(fe1f);fs.add(pd1f);fs.add(pn1f);fs.add(da1f);fs.add(rec1f);fs.add(sc1f);

        fs.setSize(1366,768);
        fs.setLayout(null);
        fs.setVisible(true);

    }
}
