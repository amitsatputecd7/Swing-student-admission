import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ConReg
{
    ConReg()
    {
        JFrame fd=new JFrame("Company Post Record");
        JButton sub,res;
        JLabel  fn,mn1,mn2,wn,em,ed;
        JTextField fnf,mnf1,wnf,emf,edf;
        JTextArea mnf2;
        sub=new JButton("SUBMIT");                 res=new JButton("RESET");

        fn=new JLabel("COMPANY NAME :");
        mn1=new JLabel("POST :");
        mn2=new JLabel("DESCRIPTION");
        wn=new JLabel("SALARY :");
        em=new JLabel("CITY :");
        ed=new JLabel("DESIRED EXPERIENCE OF :");                    //------------------------radio


        fnf=new JTextField();
        mnf1=new JTextField();
        mnf2=new JTextArea();
        wnf=new JTextField();
        emf=new JTextField();
        edf=new JTextField();


        fn.setBounds(30,30,150,20);         fnf.setBounds(180,30,250,20);
        mn1.setBounds(30,100,150,20);        mnf1.setBounds(180,100,250,20);
        mn2.setBounds(30,170,150,20);        mnf2.setBounds(180,170,350,50);
        wn.setBounds(30,260,150,20);         wnf.setBounds(180,260,250,20);
        em.setBounds(30,330,150,20);         emf.setBounds(180,330,250,20);
        ed.setBounds(30,400,150,20);         edf.setBounds(180,400,350,20);


        sub.setBounds(180,490,100,30); res.setBounds(300,490,100,30);


        res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fnf.setText(null);mnf1.setText(null);wnf.setText(null);emf.setText(null);edf.setText(null);;
               mnf2.setText(null);;
               sub.setVisible(true);
            }
        });

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=fnf.getText();  String mob1=mnf1.getText();               String mob2=mnf2.getText();    String wht=wnf.getText();
                String mail=emf.getText();
                String edu=edf.getText();



                String sql1="insert into company1(cname,post,descr,salary,city,rdate,dexp) values('"+name+"','"+mob1+"','"+mob2+"','"+wht+"','"+mail+"',localtime(),'"+edu+"')";


                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("reg");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","amit123");
                    System.out.println("connected");
                    Statement st=con.createStatement();

                    int a=st.executeUpdate(sql1);

                    if(a>0)
                    {
                        System.out.println("inserted");
                        sub.setVisible(false);
                        System.out.println("Record registered successfully. Thank you!");
                    }
                    else
                    {
                        System.out.println("sorry");
                    }
                }
                catch(Exception e1) {
                    System.out.println("not inserted");
                    //id.setText("Input Error! ");
                    sub.setVisible(true);

                }
            }
        });


        fd.getContentPane().setBackground(Color.gray);
        fd.add(res); fd.add(sub);

        fd.add(fnf); fd.add(mnf1); fd.add(mnf2); fd.add(wnf); fd.add(emf);   fd.add(edf);
        fd.add(fn);fd.add(mn1);fd.add(mn2);fd.add(wn);fd.add(em); fd.add(ed);

        fd.setSize(900,650);
        fd.setLayout(null);
        fd.setVisible(true);
    }
}
