import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Tiles {
	private Image tile;
	private ArrayList<Integer> tilesList;
	private int imageWidth, imageHeight, numberOfBlocks;
	private int frameHeight;
	private Mario m;
//	public int score = 0;
	private int translatorMario;
	public Tiles(int frameHeight, Mario m) {
		this.m = m;
		tile =  new ImageIcon("src/tile4.png").getImage();
		imageWidth = tile.getWidth(null);
		imageHeight = tile.getHeight(null);
		m.setBlocksWidth(imageWidth);
		tilesList = new ArrayList<Integer>();
		numberOfBlocks = 16;
		this.frameHeight = frameHeight;
		generateInitialArray();
	}
	private Integer generateTileHeight() {
		int n = (int)(Math.random()*10);
		if(n ==0 ) { // ==0
			return new Integer(0); //probabiliteti 0.1
		}
		else if(n <= 7) {
			return new Integer(1); //probabiliteti 0.7
		}
		else {
			return new Integer(2); //probabiliteti 0.2
		}
	}
	public void generateInitialArray(){
		tilesList.add(1);
		for(int i = 1; i <= numberOfBlocks; i++) {
			Integer num = generateTileHeight();
			if(num == 2 && tilesList.get(i-1).equals(num)) {
				num = 1;
			}
			tilesList.add(num);
		}
	}
	public void updateTilesList(){
		tilesList.remove(0);
		Integer num = generateTileHeight();
		if(num == 2 && tilesList.get(tilesList.size()-1).equals(num)) {
			num = 1;
		}
		tilesList.add(num);
	}
	public ArrayList<Integer> getTilesList() {
		return tilesList;
	}
	/**
	public void drawTiles(Graphics g, ImageObserver i,int translator){
//		if(m.getxPosition()   imageWidth *numberOfBlocks/2)
			g.translate(translator, frameHeight);
 
		for(int x = 0; x < tilesList.size(); x++) {
			if((tilesList.get(x) == 0 && m.getxPosition() >= x*imageWidth && m.getxPosition()+m.getImageWidth() - translator <= (x+1)*imageWidth) && m.getyPosition() + m.getImageHeight() == -2*imageHeight) {
				m.setGameOver(true);
				System.out.println( m.getyPosition() + m.getImageHeight());
				System.out.println(-2*imageHeight);
			}
			for (int y = 0; y < 3*tilesList.get(x); y++) {
				g.drawImage(tile, x*imageWidth , -y*imageHeight, i);
				if(tilesList.get(x) == 2) {
					//Drejtwza tw nevojshme pwr vizatimin e pozitws sw Marios
//					g.setColor(Color.RED);
//					g.drawLine(m.getxPosition() + m.getImageWidth() - translator, -20, m.getxPosition() + m.getImageWidth() - translator, -400);
//					g.drawLine(x*imageWidth, -20, x*imageWidth, -400);
//					g.setColor(Color.YELLOW);
//					g.drawLine(m.getxPosition() - translator, -20, m.getxPosition() - translator, -400);
//					g.drawLine((x+1)*imageWidth, -20, (x+1)*imageWidth, -400);	
					if(m.getxPosition() + m.getImageWidth() - translator >= x*imageWidth   && m.getxPosition() - translator <= (x+1)*imageWidth) {
						m.setBlocked(true);
					}
				}
			}
		}
//		if(m.getxPosition()  < imageWidth *numberOfBlocks/2 && translator <= -imageWidth) {
//			m.setTranslateX(0);
//			score += 2;
//		}
		if(translator <= -imageWidth) {
			this.updateTilesList();
			m.setTranslateX(0);
			score += 2;
			System.out.println(score);
		}
		g.translate(-translator, 0);

	}
	**/
	public void drawTiles(Graphics g, ImageObserver i){
		g.translate(translatorMario, frameHeight);
		for(int x = 0; x < tilesList.size(); x++) {
			for (int y = 0; y < 3*tilesList.get(x); y++) {
				g.drawImage(tile, x*imageWidth , -y*imageHeight, i);
			}
		}
		g.translate(-translatorMario, 0);
	}
	public void collisionControll(int translator){
		translatorMario = translator;
		for(int x = 0; x < tilesList.size(); x++) {
				if((tilesList.get(x) == 0 && m.getxPosition() >= x*imageWidth && m.getxPosition()+ m.getImageWidth() - translator <= (x+1)*imageWidth) && m.getyPosition() + m.getImageHeight() == -2*imageHeight) {
					m.setGameOver(true);
				}
			for (int y = 0; y < 3*tilesList.get(x); y++) {
				if(tilesList.get(x) == 2) {			
					if(m.getxPosition() + m.getImageWidth() - translator >= x*imageWidth   && m.getxPosition() - translator <= (x+1)*imageWidth) {
						m.setBlocked(true);
					
					}
				}
			}
		}
		if(translator <= -imageWidth) {
			this.updateTilesList();
			m.setTranslateX(0);
			translatorMario = 0;
		}
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public int getNumberOfBlocks() {
		return numberOfBlocks;
	}
}
