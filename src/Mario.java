import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class Mario extends KeyAdapter{
	private Image mario;
	public int width, height, mariosGround ;
	public int xPosition, yPosition, imageWidth, imageHeight, blocksWidth;
	private int translateX, walking, score;
	private int img = 1;
	private boolean pressedRight, pressedSpace, releasedSpace, isBlocked, isTube, gameOver, isTranslating, falledIntoPit;
	private double runner;
	private String imagePath = "src/mario1.png";
	public Mario(int width, int height) {
		this.width = width;
		this.height = height;
		imageWidth = new ImageIcon(imagePath).getImage().getWidth(null);
		imageHeight = new ImageIcon(imagePath).getImage().getHeight(null);
		mariosGround = -106;
		yPosition = mariosGround -imageHeight;
	}

	public void keyPressed(KeyEvent e){
		int keycode=e.getKeyCode();
		if(keycode == e.VK_RIGHT){
			pressedRight = true;
		}
		if(keycode == e.VK_SPACE) {
			pressedSpace = true;
		}
	}
	public void keyReleased(KeyEvent e){
		int keycode=e.getKeyCode();
		if(keycode == e.VK_RIGHT){
			pressedRight = false;
			
		 }
		   if(keycode == e.VK_SPACE) {
			   pressedSpace = false;
			   releasedSpace = true;
		   }
		   imagePath = "src/mario2.png";
		}
	public void move() {
		if(this.isBlocked  && yPosition + this.imageHeight > -265 +4 && mariosGround > -265) {
			this.pressedRight = false;
			isTube = true;
			
		}
		else if(isTube && !pressedRight && mariosGround == -106 ) {
			this.mariosGround = -106;
		}
		else if(isBlocked) {
			this.mariosGround = -265;
			isTube = false;
		} 

		if(this.mariosGround == -265 && (pressedRight)) { 
			runner+=1;
		}
		if((pressedRight && pressedSpace) || (pressedSpace && pressedRight) ) {
			imagePath = "src/mario2.png";
			if(xPosition < width/2 && yPosition >= mariosGround - 4*height/10) {
				   xPosition +=1;
				   yPosition-=1;
				   walking+=1;
//				   updateTranslateX(-1);
			   }
			   else if(yPosition >= mariosGround - 4*height/10){
				   updateTranslateX(-1);
				   yPosition-=1;
				   walking+=1;
			   }
			if(yPosition < mariosGround - 4*height/10) {
				releasedSpace = true;
				pressedSpace = false;
			}
				
		}
		else if(pressedSpace) {
			imagePath = "src/mario2.png";
				   yPosition-=1;
				   if(yPosition < mariosGround - 4*height/10) {
					   releasedSpace = true;
					   pressedSpace = false;
				   }
		}
		else if(pressedRight) {
			if(xPosition >= width) 
				   xPosition = width;
			else if(xPosition < width/2) {
				   xPosition += 1;
			       walking+=1;
			}
			else{
				   xPosition = width/2;
			   		updateTranslateX(-1);
			   		walking+=1;
			   }
		   if(img == 1) {
			   imagePath = "src/mario2.png";
			   img = 2;
		   }
		   else{
			   imagePath = "src/mario1.png";
			   img = 1;
		   }
		}
		
		if(releasedSpace) {
			pressedSpace = false;
			yPosition += 1;
			   if(yPosition < mariosGround -imageHeight){
				   releasedSpace = true;
			   }
			   else {
				   releasedSpace = false;
			   }
		}
		
		if(gameOver) {
			yPosition += 1;
			pressedRight = false;
			 if(yPosition < 0) {
				 gameOver = true;
			 }
			 else {
				 System.out.println("Over");
				 this.falledIntoPit = true;
			 }
		}
		if(this.mariosGround == -265 && this.runner  - this.imageWidth -1>= this.blocksWidth ) {
		runner = 0;
		mariosGround = -106;
	 	this.releasedSpace = true;
		this.isBlocked = false;
		isTube = false;
	}
		
	}
	public int calculateScore() {
		walking = walking % this.blocksWidth;
		if(walking >= 65) {
			score+=2;
			walking = 0;
		}
		return score;
	}
	public int getTranslateX() {
		return translateX;
	}
	
	public void updateTranslateX(int translateX) {
		isTranslating = true;
		this.translateX += translateX;
	}
	public void setTranslateX(int translateX) {
			this.translateX = translateX;
	}
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
	 this.xPosition = xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setBlocked(boolean b) {
		isBlocked = b;
	}
	public void isTube(boolean b) {
		isTube = b;
	}
	public void setGameOver(boolean b) {
		gameOver = b;
	}
	public boolean fallIntoPit() {
		return falledIntoPit;
	}
	public void setBlocksWidth(int blocksWidth) {
		this.blocksWidth = blocksWidth;
	}
	public boolean getMovement() {
		return pressedRight && isTranslating;
	}
	public Image getImage() {
		mario = new ImageIcon(imagePath).getImage();
		return mario;
	}
}
