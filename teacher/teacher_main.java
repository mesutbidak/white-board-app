import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class teacher_main {

	public static void main(String[] args) throws IOException {
		teacherFrame tFrame = new teacherFrame();
		tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tFrame.setVisible(true);
		tFrame.setSize(650, 500);
		tFrame.setResizable(false);
		//////el kaldýrma özelliðinin threadi
		handThread h=new handThread();
		Thread t2=new Thread(h);
		t2.start();
		//////saat threadi
		clockThread ct=new clockThread();
		Thread t3=new Thread(ct);
		t3.start();
		//////ATTENDANCE THREADÝ
		attendance at=new attendance();
		Thread t4=new Thread(at);
		t4.start();
		//////shape arrayi aktarma kýsmý
		ServerSocket ss1=new ServerSocket(12345);
		Socket s1=ss1.accept();
		System.out.println("Student connected");
		ObjectOutputStream oos=new ObjectOutputStream(s1.getOutputStream());
		while(true) {
			System.out.println("sonsuz döngüdeyim");
			while(teacherFrame.change) {
				//System.out.println("change=true");
				oos.writeObject(teacherFrame.allShapes.size());
				oos.flush();
				for(int i=0;i<teacherFrame.allShapes.size();i++) {
					oos.writeObject(teacherFrame.allShapes.get(i).x);
					oos.flush();
					oos.writeObject(teacherFrame.allShapes.get(i).y);
					oos.flush();
					oos.writeObject(teacherFrame.allShapes.get(i).w);
					oos.flush();
					oos.writeObject(teacherFrame.allShapes.get(i).h);
					oos.flush();
					oos.writeObject(teacherFrame.allShapes.get(i).type);
					oos.flush();
					oos.writeObject(teacherFrame.allShapes.get(i).RGB);
					oos.flush();
					System.out.println("yolladým.");
				}
				teacherFrame.change=false;
			}
		}

		

	}

}

////////////el kaldýrma kýsmý
class handThread implements Runnable{
		ServerSocket ss2;
		Socket s2;
		ObjectInputStream ois;
		static int x;
	@Override
	public void run() {
		try {
			ss2=new ServerSocket(12346);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			s2=ss2.accept();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("el kaldýrma baglandý");
		try {
			ois=new ObjectInputStream(s2.getInputStream());
			while(true) {
				System.out.println("el kaldýrma çalýþýyor");
				try {
					x=Integer.parseInt(ois.readObject().toString());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				if(x==1) {
					teacherFrame.handValue=1;
				}
				
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
	}
	
}
///////////saat yönetimi
class clockThread implements Runnable{
	ServerSocket ss3;
	Socket s3;
	ObjectOutputStream oos;
	
	@Override
	public void run() {
		try {
			ss3=new ServerSocket(12347);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			s3=ss3.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos=new ObjectOutputStream(s3.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			System.out.println("saat gönderildi");
			if(teacherFrame.clockIsChange==true) {
				try {
					oos.writeObject(teacherFrame.clockInfo);
					oos.flush();
					teacherFrame.clockIsChange=false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
///////////////Öðrenci bilgisi ve Attendance alma
class attendance implements Runnable{
	ServerSocket ss4;
	Socket s4;
	ObjectInputStream ois;
	@Override
	public void run() {
		try {
			ss4=new ServerSocket(12348);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			s4=ss4.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ois= new ObjectInputStream(s4.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			teacherFrame.studentInfo=ois.readObject().toString();
			teacherFrame.takeAttendance=true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}