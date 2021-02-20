import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class student_main {

	public static void main(String[] args) throws UnknownHostException, IOException, NumberFormatException, ClassNotFoundException {
		studentFrame sFrame = new studentFrame();
		sFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sFrame.setVisible(true);
		sFrame.setSize(650, 500);
		sFrame.setResizable(false);
		///////el kaldýrma özelliðinin threadi
		handThread h=new handThread();
		Thread t2=new Thread(h);
		t2.start();
		/////////saat threadi
		clockThread ct=new clockThread();
		Thread t3=new Thread(ct);
		t3.start();
		//////ATTENDANCE THREADÝ
		attendance at=new attendance();
		Thread t4=new Thread(at);
		t4.start();
		/////////shape arrayi aktarma kýsmý
		try{
			Socket s1=new Socket("127.0.0.1",12345);
			ObjectInputStream ois=new ObjectInputStream(s1.getInputStream());
			int size=0;
			//shapes shape=new shapes();
			while(true) {
				System.out.println("sonsuz döngüye girdim");
				size=Integer.parseInt(ois.readObject().toString());
				System.out.println("döngüde geziniyorum");
				studentFrame.allShapes.clear();
				for(int i=0;i<size;i++) {
					shapes shape=new shapes();
					shape.x=Integer.parseInt(ois.readObject().toString());
					shape.y=Integer.parseInt(ois.readObject().toString());
					shape.w=Integer.parseInt(ois.readObject().toString());
					shape.h=Integer.parseInt(ois.readObject().toString());
					shape.type=Integer.parseInt(ois.readObject().toString());
					System.out.println(shape.type);
					shape.RGB=Integer.parseInt(ois.readObject().toString());
					studentFrame.allShapes.add(shape);
						for(int j=0;j<studentFrame.allShapes.size();j++) {
							//System.out.print(studentFrame.allShapes.get(j).type+" ");
						}
				}
			}
		}
		catch(IOException e) {
			System.exit(0);
		}
	}

}

////////////el kaldýrma kýsmý
class handThread implements Runnable{
		Socket s2;
		ObjectOutputStream oos;
	@Override
	public void run() {
		try {
			s2=new Socket("127.0.0.1",12346);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos=new ObjectOutputStream(s2.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			System.out.println("el kaldýrma sonsuz döngüsündeyim");
			if(studentFrame.handValue==1) {
				try {
					oos.writeObject(studentFrame.handValue);
					oos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				studentFrame.handValue=0;
			}
			
		}
		
	}
	
	
	
}
/////////saat yönetimi
class clockThread implements Runnable{
	Socket s3;
	ObjectInputStream ois;
	
	@Override
	public void run() {
		try {
			s3=new Socket("127.0.0.1",12347);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ois=new ObjectInputStream(s3.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			System.out.println("saati aldým");
			try {
				studentFrame.clockInfo=ois.readObject().toString();
				studentFrame.clockIsChange=true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
///////////////Öðrenci bilgisi yollama

class attendance implements Runnable{
	Socket s4;
	ObjectOutputStream oos;
	@Override
	public void run() {
		try {
			s4=new Socket("127.0.0.1",12348);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos=new ObjectOutputStream(s4.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			System.out.println("attendance içindeyim.");
			if(studentFrame.studentInfo != "unknown") {
				try {
					oos.writeObject(studentFrame.studentInfo);
					oos.flush();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			
		}
	}
	
}

