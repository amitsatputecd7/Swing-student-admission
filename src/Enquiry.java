import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Enquiry {

    Enquiry()
    {
        JFrame fd=new JFrame("ENQUIRY FORM");
        JButton sub,res;
        JLabel  fn,mn1,mn2,wn,em,sx,adr,emp,cr,ed,fes,doa,doa1,id;
        JTextField fnf,mnf1,mnf2,wnf,emf,edf,fesf;
        JTextArea adrf;
        JRadioButton m,f,oth;   ButtonGroup sex =new ButtonGroup();

        JRadioButton y,n;       ButtonGroup empl=new ButtonGroup();

        m=new JRadioButton("MALE");                f=new JRadioButton("FEMALE");                 oth=new JRadioButton("OTHER");

        y=new JRadioButton("Yes");                 n=new JRadioButton("No");
        sub=new JButton("SUBMIT");                 res=new JButton("RESET");

        sex.add(m);sex.add(f);sex.add(oth);  //------------------------------RADIO GROUPS
        empl.add(y);empl.add(n);

        fn=new JLabel("FULL NAME : ");
        mn1=new JLabel("MOBILE NUMBER : 1.");
        mn2=new JLabel("2.");
        wn=new JLabel("WHATSAPP NUMBER :");
        em=new JLabel("E-MAIL :");
        sx=new JLabel("SEX :");                    //------------------------radio
        adr=new JLabel("ADDRESS OF RESIDANCE :");
        emp=new JLabel("EMPLOYED :");               //------------------------radio
        cr=new JLabel("COURSE :");                  //------------------------checks
        ed=new JLabel("EDUCATIONAL INFO :");
        fes=new JLabel("HOW KNOWN ABOUT ASTERISC:");
        doa=new JLabel("ENQUIRY DATE :"); doa1=new JLabel("77-55-77");
        id=new JLabel();


        fnf=new JTextField();
        mnf1=new JTextField(); mnf2=new JTextField();
        wnf=new JTextField();  fesf=new JTextField("0");
        emf=new JTextField();
        adrf=new JTextArea();
        edf=new JTextField();
        //--------------------BUTTON BOUNDS
        m.setBounds(180,200,60,20);    f.setBounds(260,200,80,20);         oth.setBounds(350,200,80,20);

        y.setBounds(180,350,50,20);    n.setBounds(350,350,50,20);
        sub.setBounds(800,600,100,30);  res.setBounds(920,600,100,30);


        fn.setBounds(10,40,150,20);  //-----------------------------labels
        mn1.setBounds(10,80,150,20); mn2.setBounds(390,80,150,20);
        wn.setBounds(10,120,150,20);
        em.setBounds(10,160,150,20);
        sx.setBounds(10,200,150,20);

        adr.setBounds(10,280,150,20);
        emp.setBounds(10,350,150,20);
        cr.setBounds(10,390,150,20);
        ed.setBounds(10,650,150,20);
        fes.setBounds(800,40,300,20);  //---------------------------------------------------auto
        doa.setBounds(800,340,150,20); doa1.setBounds(920,340,150,20); doa1.setBackground(Color.lightGray); doa1.setOpaque(true); //-----auto
        id.setBounds(800,450,350,20);  //-----------------------------------------------------------auto


        fnf.setBounds(180,40,280,20);//---------------------------------fields
        mnf1.setBounds(180,80,180,20);      mnf2.setBounds(440,80,180,20);
        wnf.setBounds(180,120,280,20);      fesf.setBounds(920,85,280,20); //----------------------------------auto
        emf.setBounds(180,160,280,20);

        adrf.setBounds(180,280,350,60);
        edf.setBounds(180,650,280,20);

        JCheckBox c,cj,and,webd,net,py,pm,ht,ios,sft,tal,cat,hw,atcd,other;  ButtonGroup cou=new ButtonGroup();

        c=new JCheckBox("C & C++ Programming");  cj=new  JCheckBox ("Core & Advanced JAVA");   and=new  JCheckBox ("Android");
        webd=new  JCheckBox ("Web Designing");     net=new  JCheckBox (".Net(VB,C#,ASP");        py=new  JCheckBox ("Python");
        pm=new JCheckBox("PHP & MySQL");           ht=new  JCheckBox ("HTML5,CSS3 & JQuery");    ios=new  JCheckBox ("iOS");
        sft=new  JCheckBox ("Software Testing");   tal=new  JCheckBox ("Tally ERP 9");           cat=new  JCheckBox("CATIA");
        hw=new  JCheckBox ("H/W & Networking");    atcd=new  JCheckBox("Auto CAD");              other=new  JCheckBox ("Others");

        c.setBounds(180,390,160,20);    cj.setBounds(350,390,160,20);   and.setBounds(520,390,160,20);
        webd.setBounds(180,440,160,20); net.setBounds(350,440,160,20);  py.setBounds(520,440,160,20);
        pm.setBounds(180,490,160,20);   ht.setBounds(350,490,160,20);   ios.setBounds(520,490,160,20);
        sft.setBounds(180,540,160,20);  tal.setBounds(350,540,160,20);  cat.setBounds(520,540,160,20);
        hw.setBounds(180,590,160,20);   atcd.setBounds(350,590,160,20); other.setBounds(520,590,160,20);




        mnf2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }
        });
        wnf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }
        });



        res.addActionListener(new ActionListener() {   //-------------------------------------reset button
            @Override
            public void actionPerformed(ActionEvent e) {
               sub.setVisible(true);
                fnf.setText(null);mnf1.setText(null);mnf2.setText(null);wnf.setText(null);emf.setText(null);edf.setText(null);
                adrf.setText(null);


                c.setSelected(false);cj.setSelected(false);and.setSelected(false);webd.setSelected(false);net.setSelected(false);py.setSelected(false);
                pm.setSelected(false);ht.setSelected(false);ios.setSelected(false);sft.setSelected(false);tal.setSelected(false);cat.setSelected(false);
                hw.setSelected(false);atcd.setSelected(false);other.setSelected(false); fesf.setText(null);

            }
        });





        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                String name=fnf.getText();  String mob1=mnf1.getText();               String mob2=mnf2.getText();    String wht=wnf.getText();
                String mail=emf.getText();    String sexi;  String address=adrf.getText();  String employ;
                String edu=edf.getText();   String fees=fesf.getText();

                String course=" ->";

                if(c.isSelected()){course=course+"|C & C++| ";}    if(cj.isSelected()){course=course+"|Core & Adv. Java| ";}    if(and.isSelected()){course=course+"|Android| ";}
                if(webd.isSelected()){course=course+"|Web Designing| ";}   if(net.isSelected()){course=course+"|.Net(VB,C#,ASP)| ";}     if(py.isSelected()){course=course+"|Python| ";}
                if(pm.isSelected()){course=course+"PHP & MySQL ";}   if(ht.isSelected()){course=course+"|HTML5,CSS3,JQuery| ";}     if(ios.isSelected()){course=course+"|iOS| ";}
                if(sft.isSelected()){course=course+"|S/W Testing| ";}   if(tal.isSelected()){course=course+"|Tally ERP9| ";}     if(cat.isSelected()){course=course+"|CATIA| ";}
                if(hw.isSelected()){course=course+"|H/W & Networking| ";}   if(atcd.isSelected()){course=course+"|Auto CAD| ";}     if(other.isSelected()){course=course+"Others ";}

                if(m.isSelected()){ sexi="Male";}    //--------------------sex check
                else if(f.isSelected()){ sexi="Female";}
                else{ sexi="Other";}
                if(y.isSelected()){employ="Yes";}    //-----------------------employ check
                else {employ="No";}
                // c,cj,and,webd,net,py,pm,ht,ios,sft,tal,cat,hw,atcd,other;







                String sql1="insert into enq(name,mn1,mn2,whatsapp,email,sex,address,employed,course,education,doa,source) values('"+name+"','"+mob1+"','"+mob2+"','"+wht+"','"+mail+"','"+sexi+"','"+address+"','"+employ+"','"+course+"','"+edu+"',localtime(),'"+fees+"')";
                //String sql2="insert into admits(name,mn1,mn2,whatsapp,email,sex,dob,address,employed,course,education,fees,paid,pending,doa) values('amitya','9821763','33223323','7382822','jkshdjd','d','2008-7-04','sdsdsd','s','sadsa','assa','445465','4545','555','2008-7-04')";

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
                        id.setText("Record registered successfully. Thank you!");
                    }
                    else
                    {
                        System.out.println("sorry");
                    }
                }
                catch(Exception e1) {
                    System.out.println("not inserted");
                    id.setText("Input Error! ");
                    sub.setVisible(true);

                }

            }





        });


        fd.getContentPane().setBackground(Color.gray);

        fd.add(m);fd.add(f);fd.add(oth); fd.add(c);fd.add(cj);fd.add(and);fd.add(webd);fd.add(net);fd.add(py);fd.add(pm); fd.add(res);
        fd.add(ht);fd.add(ios);fd.add(sft);fd.add(tal);fd.add(cat);fd.add(hw);fd.add(atcd);fd.add(other);fd.add(y);fd.add(n);
        fd.add(sub); //------buttons

        fd.add(fn);fd.add(mn1);fd.add(mn2);fd.add(wn);fd.add(em);fd.add(sx);fd.add(adr);fd.add(emp);fd.add(cr);
        fd.add(ed); fd.add(fes);fd.add(doa);fd.add(doa1);fd.add(id);//----------lables

        fd.add(fnf); fd.add(mnf1); fd.add(mnf2); fd.add(wnf); fd.add(emf);  fd.add(adrf); fd.add(edf); fd.add(fesf);
        //---fields

        fd.setSize(1366,768);
        fd.setLayout(null);
        fd.setVisible(true);


    }
}
