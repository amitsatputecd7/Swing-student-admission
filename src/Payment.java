import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
public class Payment {


    Payment()
    {
        JFrame fp= new JFrame("PAYMENT");
        JTextField rptf,amtf;
        JLabel id,rpt,nm,amt,idf,nmf ,stat;
        JButton val,pay,can,mm;



       stat=new JLabel();
        nm=new JLabel("Student Name :"); id=new JLabel("ID :");             rpt=new JLabel("Reciept Number :"); amt=new JLabel("Amount(Rs.) :");

        nmf= new JLabel();            idf= new JLabel();              rptf=new JTextField();              amtf=new JTextField();

        val=new JButton("VALIDATE");      can=new JButton("CANCEL");         pay=new JButton("MAKE PAYMENT"); mm=new JButton("MAIN MENU");

        nmf.setBackground(Color.GRAY);    nmf.setOpaque(true);
        idf.setBackground(Color.GRAY);   idf.setOpaque(true);

        nm.setBounds(50, 250, 130, 20);   id.setBounds(50, 300, 130, 20);     rpt.setBounds(50, 50, 100, 20);     amt.setBounds(50, 350, 130, 20);

        nmf.setBounds(160, 250, 170, 20);   idf.setBounds(160, 300, 130, 20);     rptf.setBounds(160, 50, 160, 20);     amtf.setBounds(160, 350, 130, 20);

        val.setBounds(50, 120, 100, 40);  can.setBounds(160, 120, 100, 40);      pay.setBounds(160, 390, 150, 40);
         stat.setBounds(160, 450, 600, 40);                                                            mm.setBounds(320, 390, 160, 40);


         val.setBackground(Color.PINK); pay.setBackground(Color.GREEN); mm.setBackground(Color.lightGray);

     amtf.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent e) {
             char character=e.getKeyChar();
             if(((character<'0')||(character>'9'))&&(character !='\b') )
             {
                 e.consume();
             }
             else pay.setVisible(true);
         }
     });
val.setVisible(true);
        val.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                 String rpts=rptf.getText();
               // String nms=nmf.getText();   String ids=idf.getText();


                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("reg");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","amit123");
                    System.out.println("connected");

                    Statement st=con.createStatement();
                   // PreparedStatement pr=con.prepareStatement("insert into student values(?,?,?)");

                    ResultSet rs=st.executeQuery("select * from admits where recipt="+rpts+"");

                    while(rs.next())
                    {
                        nmf.setText(rs.getString(2));
                        idf.setText(String.valueOf(rs.getInt(1)));
                       pay.setVisible(false);
                    }
                    con.close();
                    if(nmf.getText()==null){
                        stat.setText("Not Found");
                    }

                }
                catch (Exception e)
                {
                    //stat.setText("Not Found");
                }
                finally {

                    mm.setVisible(true);
                }


            }
        });

        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String amts=amtf.getText();   int amts1=Integer.parseInt(amts);
                String ids=idf.getText();     int ids1=Integer.parseInt(ids);
                String injpds,injpends;


                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("reg");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","amit123");
                    System.out.println("connected");

                    Statement st=con.createStatement();

                    ResultSet rs=st.executeQuery("select paid,pending from admits  where id="+ids1+"");

                    while(rs.next())
                    {  injpds=rs.getString(1);
                      injpends=rs.getString(2);
                        int injpd1=Integer.parseInt(injpds),      injpend1=Integer.parseInt(injpends);
                        injpd1=injpd1+amts1;                       injpend1=injpend1-amts1;
                       String injpd1s=String.valueOf(injpd1);      String injpend1s=String.valueOf(injpend1);
                       val.setVisible(false);
                        int a=st.executeUpdate("update admits set paid='"+injpd1s+"',pending='"+injpend1s+"' where id="+ids1+";");

                        if(a>0)
                        {
                            System.out.println("updated");
                            stat.setText("Payment Successful. Thank you!");
                            stat.setBackground(Color.GREEN); stat.setOpaque(true);
                            pay.setVisible(false);
                            mm.setVisible(true);
                        }
                        else
                        {
                            System.out.println("sorry111");
                        }
                    }

                }
                catch (Exception e5)
                {
                   System.out.println(e5);
                }

            }
        });
        mm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fp.setVisible(false);

            }
        });
        can.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fp.setVisible(false);

            }
        });





        fp.add(nm); fp.add(id);  fp.add(rpt); fp.add(stat);
        fp.add(nmf); fp.add(idf);  fp.add(rptf); fp.add(amt);
        fp.add(val);   fp.add(can); fp.add(pay); fp.add(amtf); fp.add(mm);  pay.setVisible(false); mm.setVisible(false);

        fp.setSize(630,641);
        fp.setLayout(null);
        fp.setVisible(true);


    }

}
