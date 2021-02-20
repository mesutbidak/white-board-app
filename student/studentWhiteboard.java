import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class studentWhiteboard extends JPanel{

	public Color a;
	public static int x1,y1,x2,y2;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0;i<studentFrame.allShapes.size();i++){
			//System.out.println(i+".ci þeklin type="+studentFrame.allShapes.get(i).type);
			//System.out.println(i+".ci þeklin x="+studentFrame.allShapes.get(i).x);
			a=new Color(studentFrame.allShapes.get(i).RGB);
			g.setColor(a);
			if(studentFrame.allShapes.get(i).type==0) {
				x1=studentFrame.allShapes.get(i).x;
				y1=studentFrame.allShapes.get(i).y;
				x2=studentFrame.allShapes.get(i).w;
				y2=studentFrame.allShapes.get(i).h;
				g.drawLine(x1, y1, x2, y2);
			}
			else if(studentFrame.allShapes.get(i).type==1) {
				if(studentFrame.allShapes.get(i).w >= studentFrame.allShapes.get(i).x && studentFrame.allShapes.get(i).h >= studentFrame.allShapes.get(i).y){
					x1=studentFrame.allShapes.get(i).x;
					y1=studentFrame.allShapes.get(i).y;
					x2=studentFrame.allShapes.get(i).w-studentFrame.allShapes.get(i).x;
					y2=studentFrame.allShapes.get(i).h-studentFrame.allShapes.get(i).y;
					if(x2>y2){
						y2=x2;
					}
					else {
						x2=y2;
					}
				}
				else if(studentFrame.allShapes.get(i).w <= studentFrame.allShapes.get(i).x && studentFrame.allShapes.get(i).h <= studentFrame.allShapes.get(i).y){
					x1=studentFrame.allShapes.get(i).w;
					y1=studentFrame.allShapes.get(i).h;
					x2=studentFrame.allShapes.get(i).x-studentFrame.allShapes.get(i).w;
					y2=studentFrame.allShapes.get(i).y-studentFrame.allShapes.get(i).h;
					if(x2>y2){
						y2=x2;
						y1=studentFrame.allShapes.get(i).y-x2;
					}
					else {
						x2=y2;
						x1=studentFrame.allShapes.get(i).x-x2;
					}
				}		
				
				else if(studentFrame.allShapes.get(i).w > studentFrame.allShapes.get(i).x && studentFrame.allShapes.get(i).h < studentFrame.allShapes.get(i).y){
					x1=studentFrame.allShapes.get(i).x;
					y1=studentFrame.allShapes.get(i).h;
					x2=studentFrame.allShapes.get(i).w-studentFrame.allShapes.get(i).x;
					y2=studentFrame.allShapes.get(i).y-studentFrame.allShapes.get(i).h;
					if(x2>y2){
						y2=x2;
						y1=studentFrame.allShapes.get(i).y-x2;
					}
					else {
						x2=y2;
					}
				}	
				else if(studentFrame.allShapes.get(i).w < studentFrame.allShapes.get(i).x && studentFrame.allShapes.get(i).h > studentFrame.allShapes.get(i).y){
					x1=studentFrame.allShapes.get(i).w;
					y1=studentFrame.allShapes.get(i).y;
					x2=studentFrame.allShapes.get(i).x-studentFrame.allShapes.get(i).w;
					y2=studentFrame.allShapes.get(i).h-studentFrame.allShapes.get(i).y;
					if(x2>y2){
						y2=x2;
					}
					else {
						x2=y2;
						x1=studentFrame.allShapes.get(i).x-x2;
					}
				}	
				g.drawRect(x1, y1, x2, y2);
			}
			else if(studentFrame.allShapes.get(i).type==2) {
				int cX,cY;
				double a,b;
				int r;
				a=studentFrame.allShapes.get(i).x-studentFrame.allShapes.get(i).w;
				b=studentFrame.allShapes.get(i).y-studentFrame.allShapes.get(i).h;
				cX=(studentFrame.allShapes.get(i).x+studentFrame.allShapes.get(i).w)/2;
				cY=(studentFrame.allShapes.get(i).y+studentFrame.allShapes.get(i).h)/2;
				r=(int)(Math.sqrt((a*a)+(b*b))/2.0);
				x1=cX-r;
				y1=cY-r;
				x2=2*r;
				y2=2*r;
				
				g.drawOval(x1, y1, x2, y2);
			}
			else if(studentFrame.allShapes.get(i).type==3) {
				if(studentFrame.allShapes.get(i).w >= studentFrame.allShapes.get(i).x && studentFrame.allShapes.get(i).h >= studentFrame.allShapes.get(i).y){
					x1=studentFrame.allShapes.get(i).x;
					y1=studentFrame.allShapes.get(i).y;
					x2=studentFrame.allShapes.get(i).w-studentFrame.allShapes.get(i).x;
					y2=studentFrame.allShapes.get(i).h-studentFrame.allShapes.get(i).y;
					if(x2>y2){
						y2=x2;
					}
					else {
						x2=y2;
					}
				}
				else if(studentFrame.allShapes.get(i).w <= studentFrame.allShapes.get(i).x && studentFrame.allShapes.get(i).h <= studentFrame.allShapes.get(i).y){
					x1=studentFrame.allShapes.get(i).w;
					y1=studentFrame.allShapes.get(i).h;
					x2=studentFrame.allShapes.get(i).x-studentFrame.allShapes.get(i).w;
					y2=studentFrame.allShapes.get(i).y-studentFrame.allShapes.get(i).h;
					if(x2>y2){
						y2=x2;
						y1=studentFrame.allShapes.get(i).y-x2;
					}
					else {
						x2=y2;
						x1=studentFrame.allShapes.get(i).x-x2;
					}
				}		
				
				else if(studentFrame.allShapes.get(i).w > studentFrame.allShapes.get(i).x && studentFrame.allShapes.get(i).h < studentFrame.allShapes.get(i).y){
					x1=studentFrame.allShapes.get(i).x;
					y1=studentFrame.allShapes.get(i).h;
					x2=studentFrame.allShapes.get(i).w-studentFrame.allShapes.get(i).x;
					y2=studentFrame.allShapes.get(i).y-studentFrame.allShapes.get(i).h;
					if(x2>y2){
						y2=x2;
						y1=studentFrame.allShapes.get(i).y-x2;
					}
					else {
						x2=y2;
					}
				}	
				else if(studentFrame.allShapes.get(i).w < studentFrame.allShapes.get(i).x && studentFrame.allShapes.get(i).h > studentFrame.allShapes.get(i).y){
					x1=studentFrame.allShapes.get(i).w;
					y1=studentFrame.allShapes.get(i).y;
					x2=studentFrame.allShapes.get(i).x-studentFrame.allShapes.get(i).w;
					y2=studentFrame.allShapes.get(i).h-studentFrame.allShapes.get(i).y;
					if(x2>y2){
						y2=x2;
					}
					else {
						x2=y2;
						x1=studentFrame.allShapes.get(i).x-x2;
					}
				}
				
				g.fillRect(x1, y1, x2, y2);
			}
			else if(studentFrame.allShapes.get(i).type==4) {
				int cX,cY;
				double a,b;
				int r;
				a=studentFrame.allShapes.get(i).x-studentFrame.allShapes.get(i).w;
				b=studentFrame.allShapes.get(i).y-studentFrame.allShapes.get(i).h;
				cX=(studentFrame.allShapes.get(i).x+studentFrame.allShapes.get(i).w)/2;
				cY=(studentFrame.allShapes.get(i).y+studentFrame.allShapes.get(i).h)/2;
				r=(int)(Math.sqrt((a*a)+(b*b))/2.0);
				x1=cX-r;
				y1=cY-r;
				x2=2*r;
				y2=2*r;
				g.fillOval(x1, y1, x2, y2);
			}
			
		}
		
	}
}