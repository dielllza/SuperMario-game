
public class MovingObject {
	private int xPosition, yPosition, width, height;
	private static boolean isMoving;
	public MovingObject(int xPosition,int yPosition, int width, int height) {
		this.width = width;
		this.height = height;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	public int getxPosition() {
		if(xPosition <= 0)
			xPosition = this.width;
		if(isMoving)
			return xPosition -= 1;
		else
			return xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public static void setIsMoving(boolean b) {
		isMoving = b;
	}
 }
