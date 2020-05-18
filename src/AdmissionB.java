
import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;

public class AdmissionB  {

    String crsel;
    AdmissionB(){
        JFrame fd=new JFrame("ADMISSION FORM");
        JButton sub,res,cal;
        JLabel rec=new JLabel("");
        JLabel  fn,mn1,mn2,wn,em,sx,dob,adr,emp,cr,ed,fes,dis,pd,pnd,doa,id,lfe,to,fac;
        JTextField fnf,mnf1,mnf2,wnf,emf,dbf,edf,fesf,disf,pdf,lfef,pnd1f,facf;
        JTextArea adrf;
        JRadioButton m,f,oth;   ButtonGroup sex =new ButtonGroup();

        JRadioButton y,n;       ButtonGroup empl=new ButtonGroup();

        m=new JRadioButton("MALE");                f=new JRadioButton("FEMALE");                 oth=new JRadioButton("OTHER");

        y=new JRadioButton("Yes");                 n=new JRadioButton("No");
        sub=new JButton("SUBMIT");                 res=new JButton("RESET");                    cal=new JButton("CALCULATE");

        sex.add(m);sex.add(f);sex.add(oth);  //------------------------------RADIO GROUPS
        empl.add(y);empl.add(n);

        fn=new JLabel("FULL NAME : ");
        mn1=new JLabel("MOBILE NUMBER : 1.");
        mn2=new JLabel("2.");
        wn=new JLabel("WHATSAPP NUMBER :");
        em=new JLabel("E-MAIL :");
        sx=new JLabel("SEX :");                    //------------------------radio
        dob=new JLabel("DATE OF BIRTH :");
        adr=new JLabel("ADDRESS OF RESIDANCE :");
        emp=new JLabel("EMPLOYED :");               //------------------------radio
        cr=new JLabel("COURSE :");                  //------------------------checks
        ed=new JLabel("EDUCATIONAL INFO :");
        fes=new JLabel("FEES(Rs.):");
        dis=new JLabel("DISCOUNT (%):");
        lfe=new JLabel("FINAL FEES (Rs.):");
        pd=new JLabel("PAID FEES(Rs.) :");
        pnd=new JLabel("PENDING FEES(Rs.) :");
        doa=new JLabel("SCHEDULE :");          JTextField doa1=new JTextField();  JTextField doa2=new JTextField();
        id=new JLabel();
        to=new JLabel("TO");
        fac=new JLabel("FACULTY:");


        fnf=new JTextField();
        mnf1=new JTextField(); mnf2=new JTextField();
        wnf=new JTextField();  fesf=new JTextField("0");
        emf=new JTextField();   disf=new JTextField("0"); lfef=new JTextField(); facf=new JTextField();
        dbf=new JTextField();    pdf=new JTextField();  pnd1f=new JTextField();
        adrf=new JTextArea();
        edf=new JTextField();
        //--------------------BUTTON BOUNDS
        m.setBounds(180,200,60,20);    f.setBounds(260,200,80,20);         oth.setBounds(350,200,80,20);

        y.setBounds(180,350,50,20);    n.setBounds(350,350,50,20);
        sub.setBounds(800,600,100,30);  res.setBounds(920,600,100,30);  cal.setBounds(950,160,130,30);


        fn.setBounds(10,40,150,20);  //-----------------------------labels
        mn1.setBounds(10,80,150,20); mn2.setBounds(390,80,150,20);
        wn.setBounds(10,120,150,20);
        em.setBounds(10,160,150,20);
        sx.setBounds(10,200,150,20);
        dob.setBounds(10,240,150,20);
        adr.setBounds(10,280,150,20);
        emp.setBounds(10,350,150,20);
        cr.setBounds(10,390,150,20);
        ed.setBounds(10,650,150,20);
        fes.setBounds(800,40,150,20);  //---------------------------------------------------auto
        dis.setBounds(800,80,150,20);
        lfe.setBounds(800,120,150,20);//---final fees
        pd.setBounds(800,250,150,20);
        pnd.setBounds(800,290,150,20);
        doa.setBounds(800,340,150,20); doa1.setBounds(920,340,50,20); doa1.setBackground(Color.lightGray); doa1.setOpaque(true); //-----auto
                                                            doa2.setBounds(1020,340,50,20); doa2.setBackground(Color.lightGray); doa1.setOpaque(true); //-----auto
                                                            to.setBounds(990,340,40,20);
        id.setBounds(800,450,350,20);  //-----------------------------------------------------------auto
        fac.setBounds(800,380,150,20);   facf.setBounds(920,380,300,20);

        //-------------------------------------FIELD BOUNDS
        fnf.setBounds(180,40,280,20);//---------------------------------fields
        mnf1.setBounds(180,80,180,20);      mnf2.setBounds(440,80,180,20);
        wnf.setBounds(180,120,280,20);      fesf.setBounds(920,40,280,20); //----------------------------------auto
        emf.setBounds(180,160,280,20);      disf.setBounds(920,80,280,20);
        dbf.setBounds(180,240,280,20);       pdf.setBounds(920,250,280,20); pnd1f.setBounds(920,290,150,20); pnd1f.setBackground(Color.lightGray);  pnd1f.setOpaque(true);//-----auto
        adrf.setBounds(180,280,350,60);      lfef.setBounds(920,120,280,20);
        edf.setBounds(180,650,280,20);

        JLabel l1=new JLabel(" 1.Name field shouldn't be empty.");
        JLabel l2=new JLabel("2.Make sure DOB format is yyyy-mm-dd.");
        JLabel l3=new JLabel("3.Fields related to Money shouldn't null.");
        l1.setBounds(800,490,350,20);
        l2.setBounds(800,530,350,20);
        l3.setBounds(800,570,350,20);

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
        int cpp=8000,cjj=800,andd=84000,webdd=8000,nett=55000,pyy=80,pmm=8000,htt=800,ioss=800000000,sftt=4000,tall=55,catt=2000,hww=3000,
                atcdd=8000;

        rec.setBounds(920,200,800,20);

        c.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(c.isSelected()){

                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+cpp;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-cpp;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
                System.out.println(crsel);
            }
        });
        cj.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cj.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+cjj;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-cjj;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        and.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(and.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+andd;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-andd;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        webd.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(webd.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+webdd;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-webdd;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        net.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(net.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+nett;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-nett;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        py.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(py.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+pyy;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-pyy;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        pm.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(pm.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+pmm;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-pmm;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        ht.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ht.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+htt;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-htt;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        ios.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ios.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+ioss;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-ioss;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        sft.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(sft.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+sftt;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-sftt;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        tal.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(tal.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+tall;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-tall;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        cat.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cat.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+catt;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-catt;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        hw.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(hw.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+hww;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-hww;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });
        atcd.addItemListener(new ItemListener() {   //-------------------------------------ITEM LISTENER
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(atcd.isSelected()){
                    //fesf.setText("5000");
                    String s1=fesf.getText();

                    int amount= Integer.parseInt(s1);
                    amount=amount+atcdd;      String s2=String.valueOf(amount);  fesf.setText(s2);

                }
                else{ String s3=fesf.getText();

                    int amount1=Integer.parseInt(s3);
                    amount1=amount1-atcdd;     String s4=String.valueOf(amount1); fesf.setText(s4);
                }
            }
        });


        mnf1.addKeyListener(new KeyAdapter() {                 //--------------------------------key listeners
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }

        });



       /* dbf.addKeyListener(new KeyAdapter() {                 //--------------------------------key listeners
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }

        });*/
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
        doa1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }
        });

        doa2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }
        });

        disf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }
        }); pdf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }
        });
        pnd1f.addKeyListener(new KeyAdapter() {
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
        fesf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }
        });
        lfef.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character=e.getKeyChar();
                if(((character<'0')||(character>'9'))&&(character !='\b') )
                {
                    e.consume();
                }
            }
        });




               /* JLabel  fn,mn1,mn2,wn,em,sx,dob,adr,emp,cr,ed,fes,dis,pd,pnd,pnd1,doa,doa1,id;
                JTextField fnf,mnf1,mnf2,wnf,emf,dbf,edf,fesf,disf,pdf;
                JTextArea adrf;
                JRadioButton m,f,oth;   ButtonGroup sex =new ButtonGroup();
                JCheckBox c,cj,and,webd,net,py,pm,ht,ios,sft,tal,cat,hw,atcd,other;
                JRadioButton y,n;       ButtonGroup empl=new ButtonGroup();*/
        sub.addActionListener(new ActionListener() {  //----------------------------------submit button
            @Override
            public void actionPerformed(ActionEvent e) {





            }
        });
        res.addActionListener(new ActionListener() {   //-------------------------------------reset button
            @Override
            public void actionPerformed(ActionEvent e) {
                sub.setVisible(false);
                fnf.setText(null);mnf1.setText(null);mnf2.setText(null);wnf.setText(null);emf.setText(null);dbf.setText(null);edf.setText(null);
                disf.setText("0"); pdf.setText(null); pnd1f.setText(null); adrf.setText(null);lfef.setText(null);  //JLabel rec = null;
                doa1.setText(null); doa2.setText(null);
                id.setVisible(false);

                c.setSelected(false);cj.setSelected(false);and.setSelected(false);webd.setSelected(false);net.setSelected(false);py.setSelected(false);
                pm.setSelected(false);ht.setSelected(false);ios.setSelected(false);sft.setSelected(false);tal.setSelected(false);cat.setSelected(false);
                hw.setSelected(false);atcd.setSelected(false);other.setSelected(false); fesf.setText("0"); facf.setText(null);

            }
        });

        cal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String d1=fesf.getText();
                    String d2=disf.getText();
                    float f1=Integer.valueOf(d1); float f2=Integer.valueOf(d2);
                    float new1=f1-((f2/100)*f1);
                    String news=String.valueOf(new1);
                    lfef.setText(news);


                    int new2= (int) (0.3*new1);
                    String new2s=String.valueOf(new2);
                    rec.setText("Recommended 30% for admission: Rs."+new2s);
                   // rec=new JLabel("Recommended 30% for admission: Rs."+new2s);
                   // rec.setBounds(920,200,800,20);
                   // fd.add(rec);

                }//========================discaount cal
                catch (Exception e1){
                    //rec.setText("noo");
                }



               if((fesf.getText()==null)||(fesf.getText().equals("0")))
                sub.setVisible(false);
               else sub.setVisible(true);
            }

        });
        sub.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

             id.setVisible(true);
               String faculty=facf.getText();
                String name=fnf.getText();  String mob1=mnf1.getText();               String mob2=mnf2.getText();    String wht=wnf.getText();
                String mail=emf.getText();    String sexi;  String birth=dbf.getText();  String address=adrf.getText();  String employ;
                String edu=edf.getText();     String fina=lfef.getText();/* String fee=fesf.getText();*/     String paid=pdf.getText();
                /* String disc=disf.getText();*/  String pend=pnd1f.getText();  String do1= doa1.getText(); String do2=doa2.getText(); String do3=do1+" - "+do2;
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







                String sql1="insert into admits(name,mn1,mn2,whatsapp,email,sex,dob,address,employed,course,education,fees,paid,pending,doa,sch,faculty) values('"+name+"','"+mob1+"','"+mob2+"','"+wht+"','"+mail+"','"+sexi+"','"+birth+"','"+address+"','"+employ+"','"+course+"','"+edu+"','"+fina+"','"+paid+"','"+pend+"',localtime(),'"+do3+"','"+faculty+"')";
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

                        con.close();

                    }


                    else
                    {
                        System.out.println("sorry");
                    }
                    Recgen recv=new Recgen();
                }
                catch(Exception e1) {
                    System.out.println("not inserted");
                    id.setText("Input Error!");


                    sub.setVisible(true);


                }

            }





        });

        cal.setBackground(Color.LIGHT_GRAY);
        sub.setBackground(Color.PINK);
        res.setBackground(Color.YELLOW);

        fd.getContentPane().setBackground(Color.gray);

        fd.add(m);fd.add(f);fd.add(oth); fd.add(c);fd.add(cj);fd.add(and);fd.add(webd);fd.add(net);fd.add(py);fd.add(pm); fd.add(res);
        fd.add(ht);fd.add(ios);fd.add(sft);fd.add(tal);fd.add(cat);fd.add(hw);fd.add(atcd);fd.add(other);fd.add(y);fd.add(n); fd.add(cal);
        fd.add(sub);  sub.setVisible(false);//------buttons

        fd.add(fn);fd.add(mn1);fd.add(mn2);fd.add(wn);fd.add(em);fd.add(sx);fd.add(dob);fd.add(adr);fd.add(emp);fd.add(cr);fd.add(fac);
        fd.add(ed); fd.add(fes);fd.add(pd);fd.add(pnd);fd.add(pnd1f);fd.add(doa);fd.add(doa1);fd.add(doa2);fd.add(to);fd.add(id);fd.add(dis); fd.add(lfe);fd.add(rec);  //----------lables

        fd.add(fnf); fd.add(mnf1); fd.add(mnf2); fd.add(wnf); fd.add(emf); fd.add(dbf); fd.add(adrf); fd.add(edf); fd.add(fesf); fd.add(disf); fd.add(pdf);
        fd.add(lfef); fd.add(facf);//---fields
        fd.add(l1);fd.add(l2);fd.add(l3);
        fd.setSize(1366,768);
        fd.setLayout(null);
        fd.setVisible(true);
    }
}