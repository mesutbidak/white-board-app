import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class teacherFrame extends JFrame implements ActionListener, KeyListener, MouseListener {
	BorderLayout bl;
	JPanel jpCenter;
	protected static int shapeCounter;
	protected static int x1,y1,x2,y2;
	public static ArrayList<shapes> allShapes = new ArrayList<shapes>();
	shapes shp=new shapes();
	protected static Color c;
	protected static int ColorCode;
	int click;
	boolean move_flag;
	public static int shapeType;
	JMenuBar jmb;
	JMenu color_m,shape,delete,move,exit,time_m;
	JMenuItem color_sbm, line_sbm, square_sbm, circle_sbm, fillS_sbm, fillC_sbm,delete_sbm, move_sbm, exit_sbm,time_sbm;
	Timer timer;
	int clock,minute,second;
	protected static String clockInfo,studentInfo;
	public static boolean finisher;
	public static boolean change;
	public static int handValue;
	public static boolean clockIsChange,takeAttendance;
	
	public teacherFrame(){
		super("Teacher");
		timer=new Timer(1000,this);
		finisher=false;
		change=false;
		clockIsChange=false;
		takeAttendance=false;
		handValue=0;
		studentInfo="unknown";
		clockInfo="00:00";
		clock=60;
		second=0;
		minute=0;
		shapeCounter=0;
		bl=new BorderLayout();
		setLayout(bl);
		click=0;
		ColorCode=-16777216;
		shapeType=0;
		move_flag=false;
		menu();
		center();
		timer.start();
	}
	
	public void menu() {
		jmb = new JMenuBar();
		
		color_m = new JMenu("Color");
		shape = new JMenu("Shape");
		delete=new JMenu("Delete");
		move = new JMenu("Move");
		time_m = new JMenu("Time");
		exit = new JMenu("Exit");
		
		color_sbm = new JMenuItem("Color Chooser");
		color_sbm.addActionListener(this);
		
		line_sbm = new JMenuItem("Line");
		line_sbm.addActionListener(this);
		
		square_sbm = new JMenuItem("Square");
		square_sbm.addActionListener(this);
		
		circle_sbm = new JMenuItem("Circle");
		circle_sbm.addActionListener(this);
		
		fillS_sbm = new JMenuItem("FillSquare");
		fillS_sbm.addActionListener(this);
		
		fillC_sbm = new JMenuItem("FillCircle");
		fillC_sbm.addActionListener(this);
		
		delete_sbm = new JMenuItem("DeleteLastShape");
		delete_sbm.addActionListener(this);		
		
		move_sbm = new JMenuItem("Move Object");
		move_sbm.addActionListener(this);
		
		time_sbm = new JMenuItem("Lecture Time");
		time_sbm.addActionListener(this);
		
		exit_sbm = new JMenuItem("Exit");
		exit_sbm.addActionListener(this);
		
		addKeyListener(this);
		
		color_m.add(color_sbm);
		shape.add(line_sbm);
		shape.add(square_sbm);
		shape.add(circle_sbm);
		shape.add(fillS_sbm);
		shape.add(fillC_sbm);
		delete.add(delete_sbm);
		move.add(move_sbm);
		time_m.add(time_sbm);
		exit.add(exit_sbm);
		
		jmb.add(color_m);
		jmb.add(shape);
		jmb.add(delete);
		jmb.add(move);
		jmb.add(time_m);
		jmb.add(exit);
		
		add(jmb);
		setJMenuBar(jmb);
	
	}
	
	public void center() {
		jpCenter = new teacherWhiteboard();
		jpCenter.addMouseListener(this);
		jpCenter.setBackground(Color.white);
		add(jpCenter,BorderLayout.CENTER);
	}
	

	
	
	//Buranýn aþaðýsý mouse click,key press ve actionperformed 
	
	/////////////////////////mouseclick
	@Override
	public void mouseClicked(MouseEvent e) {
		move_flag=false;
		if(click==0) {
			shp.x=e.getX();
			System.out.println("click=0=>"+e.getX());
			shp.y=e.getY();
			System.out.println("click=0=>"+e.getY());
			click++;
		} 
		else if(click==1) {
			shp.w=e.getX();
			System.out.println("click=1=>"+e.getX());
			shp.h=e.getY();
			System.out.println("click=1=>"+e.getY());
			click--;
			shp.RGB=ColorCode;
			shp.type=shapeType;
			allShapes.add(shp);
			System.out.println((allShapes.size()-1)+".index shape si="+allShapes.get(allShapes.size()-1).RGB);
			System.out.println((allShapes.size()-1)+".index shape si="+allShapes.get(allShapes.size()-1).type);
			System.out.println((allShapes.size()-1)+".index x si="+allShapes.get(allShapes.size()-1).x);
			System.out.println((allShapes.size()-1)+".index y si="+allShapes.get(allShapes.size()-1).y);
			System.out.println((allShapes.size()-1)+".index w si="+allShapes.get(allShapes.size()-1).w);
			System.out.println((allShapes.size()-1)+".index h si="+allShapes.get(allShapes.size()-1).h);
			shp=new shapes();
			repaint();
			this.change=true;
		
		}
	}
	/////////////////////keypressed
	@Override
	public void keyPressed(KeyEvent e) {
		if(move_flag){
			if(e.getKeyCode()==e.VK_UP) {
				(allShapes.get(allShapes.size()-1).y)-=5;
				(allShapes.get(allShapes.size()-1).h)-=5;
				this.change=true;
			}
			else if(e.getKeyCode()==e.VK_DOWN) {
				(allShapes.get(allShapes.size()-1).y)+=5;
				(allShapes.get(allShapes.size()-1).h)+=5;
				this.change=true;
			}
			else if(e.getKeyCode()==e.VK_RIGHT) {
				(allShapes.get(allShapes.size()-1).x)+=5;
				(allShapes.get(allShapes.size()-1).w)+=5;
				this.change=true;
			}
			else if(e.getKeyCode()==e.VK_LEFT) {
				(allShapes.get(allShapes.size()-1).x)-=5;
				(allShapes.get(allShapes.size()-1).w)-=5;
				this.change=true;
			}
		}
		repaint();
	}
	
	
	////////////////////actionperformed
	@Override
	public void actionPerformed(ActionEvent e) {
		////////////Saat kýsmý ve bitiþ animasyonu
		shapeCounter=allShapes.size();
		
		if(clock>0){
			clock--;
			clockIsChange=true;
		}
		if(clock == 0) {
			clock=-1;
			shapes finish = new shapes();
			finish.type=4;
			finish.x=0;
			finish.y=0;
			finish.w=0;
			finish.h=0;
			allShapes.add(finish);
			finisher=true;
			timer.setDelay(50);
			this.removeMouseListener(this);
			change=true;
			clockIsChange=true;
		}
		if(finisher) {
			allShapes.get(allShapes.size()-1).w+=5;
			allShapes.get(allShapes.size()-1).h+=5;
			change=true;
			if(allShapes.get(allShapes.size()-1).w>=650) {
				JOptionPane.showMessageDialog(null, "Time is over!");
				System.exit(0);
			}
		}
		minute=clock/60;
		second=clock-minute*60;
		if(second<10){
			clockInfo="0"+Integer.toString(minute)+":"+"0"+Integer.toString(second);
		}
		else {
			clockInfo="0"+Integer.toString(minute)+":"+Integer.toString(second);
		}
		if(clock==-1) {
			clockInfo="00:00";
		}
		System.out.println(clockInfo);
		/////////el kaldýrma kýsmý
		if(handValue==1) {
			JOptionPane.showMessageDialog(this, "Student want to talk");
			handValue=0;
		}
		/////////ATTENDANCE ALMA VE YAZMA
		if(takeAttendance) {
			JOptionPane.showMessageDialog(this, ""+studentInfo+" attended the lecture.Attendance list was created.");
			/////////////ATTENDANCE TXT DOSYASINA YAZMA
			File f = new File("attendancelist.txt");
			System.out.println(f.getAbsolutePath());
			try{
				FileWriter dosyaYazici = new FileWriter(f);
				BufferedWriter dosyaOutput = new BufferedWriter(dosyaYazici);
				dosyaOutput.write(studentInfo);
				dosyaOutput.flush();
				dosyaYazici.close();
				dosyaOutput.close();
			}
			catch(IOException a) {
				a.printStackTrace();
			}
			/////////////
			takeAttendance=false;
		}
		/////////Menubar
		if(e.getSource() == color_sbm) {
			move_flag=false;
			click=0;
			c = JColorChooser.showDialog(this, "Choose Color", Color.red);
			System.out.println(c.getRGB());
			ColorCode=c.getRGB();
			repaint();
		}
		else if(e.getSource() == line_sbm) {
			move_flag=false;
			click=0;
			shapeType=0;
			JOptionPane.showMessageDialog(this, "Choose two point with mouse click for drawing line which is default option");
		}
		else if(e.getSource() == square_sbm) {
			move_flag=false;
			click=0;
			shapeType=1;
			JOptionPane.showMessageDialog(this, "Choose two point with mouse click for drawing square");
		}
		else if(e.getSource() == circle_sbm) {
			move_flag=false;
			click=0;
			shapeType=2;
			JOptionPane.showMessageDialog(this, "Choose two point with mouse click for drawing circle");
		}
		else if(e.getSource() == fillS_sbm) {
			move_flag=false;
			click=0;
			shapeType=3;
			JOptionPane.showMessageDialog(this, "Choose two point with mouse click for drawing fill square");
		}
		else if(e.getSource() == fillC_sbm) {
			move_flag=false;
			click=0;
			shapeType=4;
			JOptionPane.showMessageDialog(this, "Choose two point with mouse click for drawing fill circle");
		}
		else if(e.getSource() == delete_sbm) {
			move_flag=false;
			click=0;
			System.out.println(allShapes.size());
			if(allShapes.size()>0) {
				allShapes.remove(allShapes.size()-1);
			}
			this.change=true;
			//System.out.println(allShapes.size());
		}
		else if(e.getSource() == move_sbm) {
			click=0;
			move_flag=true;
			
		}
		else if(e.getSource() == time_sbm) {
			click=0;
			move_flag=false;
			try{
				clock = Integer.parseInt(JOptionPane.showInputDialog(this,"Give lecture time(second) between 0 and 600\nif you give wrong,time will ve default one\ndefault time is 60 second"));
				if(clock<=0 || clock>=600) {
					clock=60;
				}
			}
			catch(Exception a) {
				clock=60;
			}
			
		}
		else if(e.getSource() == exit_sbm) {
			System.exit(0);
		}
		
		repaint();
	
	}
	
	
	//Buranýn altý gereksiz
	
	

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	
	
	
}
