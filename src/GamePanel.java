import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel{ 
	private Tiles t;
	private Mario m;
	private int width;
	private int height = 650;
	private MovingObject c1, c2, c3;
	private Image cloud1, cloud2, finishLine;
	public GamePanel(Mario m, Tiles t) {
		this.m = m;
		this.t = t;
		width = t.getImageWidth() * t.getNumberOfBlocks();
		c1 = new MovingObject(700, -630,width, height);
		c2 = new MovingObject(1000, -650 ,width, height);
		finishLine = new ImageIcon("src/finish.png").getImage();
		c3 = new MovingObject(width, -106 - finishLine.getHeight(null),width, height);
		cloud1 = new ImageIcon("src/clouds1.png").getImage();
		cloud2 = new ImageIcon("src/clouds2.png").getImage();
		setSize(width, height);
		setVisible(true);
	}
	public void paint(Graphics g)
	   {
	   Image Imazhi=createImage(getWidth(),getHeight());
	   Graphics gi=Imazhi.getGraphics();
	   paintComponent(gi);
	   g.drawImage(Imazhi,0,0,this);
	   }
	public void paintComponent(Graphics g) {
		g.setColor(new Color(163, 212, 247));
		g.fillRect(0, 0, width, height);
		t.collisionControll(m.getTranslateX());
		t.drawTiles(g, this);
		m.move();
		if(m.calculateScore() >= 184) {
			g.drawImage(finishLine, c3.getxPosition(), c3.getyPosition(), this);
		}
		g.drawImage(m.getImage(), m.getxPosition(), m.getyPosition(), this);
		MovingObject.setIsMoving(m.getMovement());
		g.drawImage(cloud1, c1.getxPosition(), c1.getyPosition(), this);
		g.drawImage(cloud2, c2.getxPosition(), c2.getyPosition(), this);
	}
}
