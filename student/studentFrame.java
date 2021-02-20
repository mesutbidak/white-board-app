import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class studentFrame extends JFrame implements ActionListener{
	public static ArrayList<shapes> allShapes;
	protected static String studentInfo;
	BorderLayout bl;
	JPanel jpCenter,jpEast;
	Timer timer;
	JButton hand,attendance;
	JLabel jlName,jlClock;
	JTextField jtfName; 
	JCheckBox jcbHere;
	public static int handValue;
	public static String clockInfo;
	public static boolean clockIsChange;
	
	
	public studentFrame(){
		super("Student");
		allShapes=new ArrayList<shapes>();
		studentInfo="unknown";
		clockInfo="unknown";
		clockIsChange=false;
		handValue=0;
		timer=new Timer(1000,this);
		bl=new BorderLayout();
		setLayout(bl);
		center();
		east();
		timer.start();
	}
	public void center() {
		jpCenter = new studentWhiteboard();
		jpCenter.setBackground(Color.white);
		add(jpCenter,BorderLayout.CENTER);
	}
	public void east() {
		FlowLayout fl = new FlowLayout();
		jpEast = new JPanel();
		jpEast.setLayout(fl);
		
		jlName = new JLabel("Name\nSurname");
		jtfName = new JTextField(10);
		jcbHere = new JCheckBox("I'm here");
		attendance = new JButton("Attendance");
		attendance.addActionListener(this);
		hand = new JButton("Hand");
		hand.addActionListener(this);
		jlClock = new JLabel(clockInfo); 
		
		jpEast.add(jlName);
		jpEast.add(jtfName);
		jpEast.add(jcbHere);
		jpEast.add(attendance);
		jpEast.add(hand);
		jpEast.add(jlClock);
		
		add(jpEast,BorderLayout.SOUTH);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		///////saat eþleþmesi
		if(clockIsChange==true) {
			jlClock.setText(clockInfo);
			clockIsChange=false;
		}
		
		//////////Buttonlar
		if(e.getSource() == hand) {
			JOptionPane.showMessageDialog(null,"You raised your hand!");
			System.out.println("hand butonuna bastým");
			handValue=1;
		}
		else if(e.getSource() == attendance) {
			if(jcbHere.isSelected()){
				studentInfo=jtfName.getText();
				JOptionPane.showMessageDialog(null,studentInfo+"\nYou have sent your attendance!");
				jtfName.setEnabled(false);
				attendance.setEnabled(false);
				jcbHere.setEnabled(false);
			}
			else {
				JOptionPane.showMessageDialog(null,"Please put the tick on i'm here!");
			}
			System.out.println("attendance butonuna bastým");
			System.out.println(studentInfo);
		}
		repaint();
	}
}
