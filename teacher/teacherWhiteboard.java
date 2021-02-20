import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class teacherWhiteboard extends JPanel{

	public Color a;
	public static int x1,y1,x2,y2;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0;i<teacherFrame.allShapes.size();i++){
			a=new Color(teacherFrame.allShapes.get(i).RGB);
			g.setColor(a);
			if(teacherFrame.allShapes.get(i).type==0) {
				x1=teacherFrame.allShapes.get(i).x;
				y1=teacherFrame.allShapes.get(i).y;
				x2=teacherFrame.allShapes.get(i).w;
				y2=teacherFrame.allShapes.get(i).h;
				g.drawLine(x1, y1, x2, y2);
			}
			else if(teacherFrame.allShapes.get(i).type==1) {
				if(teacherFrame.allShapes.get(i).w >= teacherFrame.allShapes.get(i).x && teacherFrame.allShapes.get(i).h >= teacherFrame.allShapes.get(i).y){
					x1=teacherFrame.allShapes.get(i).x;
					y1=teacherFrame.allShapes.get(i).y;
					x2=teacherFrame.allShapes.get(i).w-teacherFrame.allShapes.get(i).x;
					y2=teacherFrame.allShapes.get(i).h-teacherFrame.allShapes.get(i).y;
					if(x2>y2){
						y2=x2;
					}
					else {
						x2=y2;
					}
				}
				else if(teacherFrame.allShapes.get(i).w <= teacherFrame.allShapes.get(i).x && teacherFrame.allShapes.get(i).h <= teacherFrame.allShapes.get(i).y){
					x1=teacherFrame.allShapes.get(i).w;
					y1=teacherFrame.allShapes.get(i).h;
					x2=teacherFrame.allShapes.get(i).x-teacherFrame.allShapes.get(i).w;
					y2=teacherFrame.allShapes.get(i).y-teacherFrame.allShapes.get(i).h;
					if(x2>y2){
						y2=x2;
						y1=teacherFrame.allShapes.get(i).y-x2;
					}
					else {
						x2=y2;
						x1=teacherFrame.allShapes.get(i).x-x2;
					}
				}		
				
				else if(teacherFrame.allShapes.get(i).w > teacherFrame.allShapes.get(i).x && teacherFrame.allShapes.get(i).h < teacherFrame.allShapes.get(i).y){
					x1=teacherFrame.allShapes.get(i).x;
					y1=teacherFrame.allShapes.get(i).h;
					x2=teacherFrame.allShapes.get(i).w-teacherFrame.allShapes.get(i).x;
					y2=teacherFrame.allShapes.get(i).y-teacherFrame.allShapes.get(i).h;
					if(x2>y2){
						y2=x2;
						y1=teacherFrame.allShapes.get(i).y-x2;
					}
					else {
						x2=y2;
					}
				}	
				else if(teacherFrame.allShapes.get(i).w < teacherFrame.allShapes.get(i).x && teacherFrame.allShapes.get(i).h > teacherFrame.allShapes.get(i).y){
					x1=teacherFrame.allShapes.get(i).w;
					y1=teacherFrame.allShapes.get(i).y;
					x2=teacherFrame.allShapes.get(i).x-teacherFrame.allShapes.get(i).w;
					y2=teacherFrame.allShapes.get(i).h-teacherFrame.allShapes.get(i).y;
					if(x2>y2){
						y2=x2;
					}
					else {
						x2=y2;
						x1=teacherFrame.allShapes.get(i).x-x2;
					}
				}	
				g.drawRect(x1, y1, x2, y2);
			}
			else if(teacherFrame.allShapes.get(i).type==2) {
				int cX,cY;
				double a,b;
				int r;
				a=teacherFrame.allShapes.get(i).x-teacherFrame.allShapes.get(i).w;
				b=teacherFrame.allShapes.get(i).y-teacherFrame.allShapes.get(i).h;
				cX=(teacherFrame.allShapes.get(i).x+teacherFrame.allShapes.get(i).w)/2;
				cY=(teacherFrame.allShapes.get(i).y+teacherFrame.allShapes.get(i).h)/2;
				r=(int)(Math.sqrt((a*a)+(b*b))/2.0);
				x1=cX-r;
				y1=cY-r;
				x2=2*r;
				y2=2*r;
				
				g.drawOval(x1, y1, x2, y2);
			}
			else if(teacherFrame.allShapes.get(i).type==3) {
				if(teacherFrame.allShapes.get(i).w >= teacherFrame.allShapes.get(i).x && teacherFrame.allShapes.get(i).h >= teacherFrame.allShapes.get(i).y){
					x1=teacherFrame.allShapes.get(i).x;
					y1=teacherFrame.allShapes.get(i).y;
					x2=teacherFrame.allShapes.get(i).w-teacherFrame.allShapes.get(i).x;
					y2=teacherFrame.allShapes.get(i).h-teacherFrame.allShapes.get(i).y;
					if(x2>y2){
						y2=x2;
					}
					else {
						x2=y2;
					}
				}
				else if(teacherFrame.allShapes.get(i).w <= teacherFrame.allShapes.get(i).x && teacherFrame.allShapes.get(i).h <= teacherFrame.allShapes.get(i).y){
					x1=teacherFrame.allShapes.get(i).w;
					y1=teacherFrame.allShapes.get(i).h;
					x2=teacherFrame.allShapes.get(i).x-teacherFrame.allShapes.get(i).w;
					y2=teacherFrame.allShapes.get(i).y-teacherFrame.allShapes.get(i).h;
					if(x2>y2){
						y2=x2;
						y1=teacherFrame.allShapes.get(i).y-x2;
					}
					else {
						x2=y2;
						x1=teacherFrame.allShapes.get(i).x-x2;
					}
				}		
				
				else if(teacherFrame.allShapes.get(i).w > teacherFrame.allShapes.get(i).x && teacherFrame.allShapes.get(i).h < teacherFrame.allShapes.get(i).y){
					x1=teacherFrame.allShapes.get(i).x;
					y1=teacherFrame.allShapes.get(i).h;
					x2=teacherFrame.allShapes.get(i).w-teacherFrame.allShapes.get(i).x;
					y2=teacherFrame.allShapes.get(i).y-teacherFrame.allShapes.get(i).h;
					if(x2>y2){
						y2=x2;
						y1=teacherFrame.allShapes.get(i).y-x2;
					}
					else {
						x2=y2;
					}
				}	
				else if(teacherFrame.allShapes.get(i).w < teacherFrame.allShapes.get(i).x && teacherFrame.allShapes.get(i).h > teacherFrame.allShapes.get(i).y){
					x1=teacherFrame.allShapes.get(i).w;
					y1=teacherFrame.allShapes.get(i).y;
					x2=teacherFrame.allShapes.get(i).x-teacherFrame.allShapes.get(i).w;
					y2=teacherFrame.allShapes.get(i).h-teacherFrame.allShapes.get(i).y;
					if(x2>y2){
						y2=x2;
					}
					else {
						x2=y2;
						x1=teacherFrame.allShapes.get(i).x-x2;
					}
				}
				
				g.fillRect(x1, y1, x2, y2);
			}
			else if(teacherFrame.allShapes.get(i).type==4) {
				int cX,cY;
				double a,b;
				int r;
				a=teacherFrame.allShapes.get(i).x-teacherFrame.allShapes.get(i).w;
				b=teacherFrame.allShapes.get(i).y-teacherFrame.allShapes.get(i).h;
				cX=(teacherFrame.allShapes.get(i).x+teacherFrame.allShapes.get(i).w)/2;
				cY=(teacherFrame.allShapes.get(i).y+teacherFrame.allShapes.get(i).h)/2;
				r=(int)(Math.sqrt((a*a)+(b*b))/2.0);
				x1=cX-r;
				y1=cY-r;
				x2=2*r;
				y2=2*r;
				g.fillOval(x1, y1, x2, y2);
			}
			
		}
		g.setColor(Color.black);
		g.drawString("Shapes Count:"+Integer.toString(teacherFrame.shapeCounter), 540, 20);
		g.drawString(teacherFrame.clockInfo,600,35);
	}
}
