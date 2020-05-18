import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.Timer;

public class Adm {

    JLabel clock = new JLabel();
    public void tickTock() {
        clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
    }
    Adm()
    {

        JFrame f1=new JFrame("Asterisc Software ver<1.0>");
        f1.getContentPane().setBackground(Color.black);
        //==============================================================================================timer
        clock.setBackground(Color.GRAY);  clock.setOpaque(true);
        clock.setBounds(880,30,150,20);

        tickTock();
        f1.add(clock);
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tickTock();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();

//==============================================================================================================timer

        JButton regc=new JButton("REGISTER"),vc=new JButton("VIEW ALL"),sc=new JButton("SEARCH");



//=========company



        JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,reg,enc,regs,encs;
        JLabel l1,l2,l3;
        l3=new JLabel(new ImageIcon("C:\\Users\\Cap\\Desktop\\asterisk-primary_2x.jpg"));
        l3.setBounds(10,10,300,50);
        f1.add(l3);

        b1=new JButton("PAY");
        b2=new JButton("ENQUIRY");
        b3=new JButton("ADMISSION");
        b4=new JButton("SCHEDULE");
        b5=new JButton("SEARCH");
        b6=new JButton("ALL STUDENTS");
        b7=new JButton("COMPANY LIST");
        b8=new JButton("SUSPEND");
        b9=new JButton("DOWNLOAD LIST");
        reg=new JButton("REGISTERED");
        enc=new JButton("ENQUIRED");
        regs=new JButton("REGISTERED");
        encs=new JButton("ENQUIRED");
        l1=new JLabel() ;
        l2=new JLabel("For Full List: ") ;




      b1.setBackground(Color.PINK);
      b2.setBackground(Color.gray);
      b3.setBackground(Color.PINK);
      b4.setBackground(Color.gray);
      b5.setBackground(Color.PINK);
      reg.setBackground(Color.PINK); enc.setBackground(Color.PINK);
      b6.setBackground(Color.gray);
      regs.setBackground(Color.gray); encs.setBackground(Color.gray);
      b7.setBackground(Color.PINK);   regc.setBackground(Color.PINK); vc.setBackground(Color.PINK); sc.setBackground(Color.PINK);
        b8.setBackground(Color.BLUE);
      b9.setBackground(Color.PINK);






        b1.setBounds(1120,60,130,40);
        b2.setBounds(1120,140,130,40);
        b3.setBounds(1120,220,130,40);
        b4.setBounds(1120,300,130,40);
        b5.setBounds(1120,380,130,40);
        reg.setBounds(1055,430,120,22);
        b6.setBounds(1120,460,130,40);
       enc.setBounds(1185,430,120,22);
        b7.setBounds(1120,540,130,40);
        b8.setBounds(340,620,130,40);
        b9.setBounds(140,620,150,40);
        regs.setBounds(1055,510,120,22);
        encs.setBounds(1185,510,120,22);
        regc.setBounds(1055,590,120,22);
        vc.setBounds(1185,590,120,22);
        sc.setBounds(1140,622,100,22);

        l1.setBounds(10,80,1024,500);
        l2.setBounds(10,630,104,20);

        l1.setBackground(Color.GRAY);
        l1.setOpaque(true);

        b1.addActionListener(new ActionListener() {      //------------------------------------------------------pay
            @Override
            public void actionPerformed(ActionEvent e) {
             Payment paym=new Payment();
            }
        });
        b2.addActionListener(new ActionListener() {      //------------------------------------------------------inquiry
            @Override
            public void actionPerformed(ActionEvent e) {
             Enquiry en=new Enquiry();
            }
        });
        b3.addActionListener(new ActionListener() {      //------------------------------------------------------admission


            public void actionPerformed(ActionEvent e) {

               AdmissionB admB=new AdmissionB();
            }
        });
        b4.addActionListener(new ActionListener() {      //------------------------------------------------------schedule
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b5.addActionListener(new ActionListener() {      //------------------------------------------------------search
            @Override
            public void actionPerformed(ActionEvent e) {
                if(reg.isVisible()){
                    reg.setVisible(false); enc.setVisible(false);
                }
                else{reg.setVisible(true); enc.setVisible(true);}


            }
        });
        b6.addActionListener(new ActionListener() {      //------------------------------------------------------all students
            @Override
            public void actionPerformed(ActionEvent e) {

                if(regs.isVisible()){
                    regs.setVisible(false); encs.setVisible(false);
                }
                else{regs.setVisible(true); encs.setVisible(true);}



            }
        });
        b7.addActionListener(new ActionListener() {      //------------------------------------------------------company
            @Override
            public void actionPerformed(ActionEvent e) {
              if(regc.isVisible()) {
                  regc.setVisible(false);
                  vc.setVisible(false);
                  sc.setVisible(false);
              }
              else{  regc.setVisible(true); vc.setVisible(true); sc.setVisible(true);}

            }
        });
        b8.addActionListener(new ActionListener() {      //------------------------------------------------------suspend
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
            }
        });
        b9.addActionListener(new ActionListener() {      //------------------------------------------------------list
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


//============================================================================

        regs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e5) {
                Allstd allstd=new Allstd();
            }
        });
                                                            //=====all std.
        encs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e6) {
              Allenquiry allenquiry=new Allenquiry();
            }
        });
//============================================================================

        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                Search srch=new Search();
            }
        });
                                                                //===search
        enc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e2) {
                SearchEnc senc=new SearchEnc();
            }
        });

        //=======================================================================

        regc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConReg();
            }
        });
        vc.addActionListener(new ActionListener() {           //====================company actions
            @Override
            public void actionPerformed(ActionEvent e) {
                new AllCom();
            }
        });
        sc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConSearch();
            }
        });

        //=================================================================================


        //=========================================================================
        reg.setVisible(false); enc.setVisible(false);
        regs.setVisible(false); encs.setVisible(false);
        f1.add(l1); f1.add(l2);

        f1.add(b1); f1.add(b2); f1.add(b3); f1.add(b4); f1.add(b5);
        f1.add(b6); f1.add(b7); f1.add(b8); f1.add(b9); f1.add(reg);f1.add(enc);  f1.add(regs);f1.add(encs);
        f1.add(regc);f1.add(vc);f1.add(sc);
        regc.setVisible(false); vc.setVisible(false); sc.setVisible(false);

        f1.setSize(1366,768);
        f1.setLayout(null);
        f1.setVisible(true);


    }



    public static void main(String[] args)throws Exception {

        new Adm();


    }
}
