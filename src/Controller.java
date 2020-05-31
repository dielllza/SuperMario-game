import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Controller extends JFrame{
	private Tiles t;
	private Mario m;
	private GamePanel gamePanel;
	private int width = 1280;
	private int height = 700;
	private TimeCalculator timer;
	private GameFrame game;
	private JLabel gameDescription = new JLabel("Score 200 points in 60 seconds to win the game.");
	private JButton startButton;

	public Controller() {
		m = new Mario(width, height);
		t = new Tiles(height-50, m);
		width = t.getImageWidth() * t.getNumberOfBlocks();
		gamePanel = new GamePanel(m,t);
		timer = new TimeCalculator(60);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout( FlowLayout.CENTER, 560,160));
		cp.setBackground(new Color(163, 212, 247));
		game = new GameFrame(gamePanel, m, width, height);
		game.editLabel(gameDescription);
		cp.add(gameDescription);
		startButton = new JButton("Start");
		game.editButton(startButton);
		timer.startTimer();
		startButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timer.startTimer();
				game.setVisible(true);
				setVisible(false);
			}
		});
		
		cp.add(startButton);		
		setSize(width, height);	
		setTitle("Super Mario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void run() {
		while(!timer.isOver() && ! m.fallIntoPit() && m.calculateScore() < 200){
			game.setLeftTime(timer.getCurrentTimer());
			game.setScoreLabel(m.calculateScore());
			gamePanel.repaint();
		}
		try{Thread.sleep(500);}
		catch(InterruptedException e) {}
		startButton.setText("Close");
		startButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		if(timer.isOver()) {
			gameDescription.setText("Time's up. Game Over");
		}
		else if(m.fallIntoPit()) {
			gameDescription.setText("Game Over");
		}
		else if(m.calculateScore() >= 200) {
			gameDescription.setText("Congratulations! You Won!");
		}
		game.setVisible(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
	new Controller().run();
	}	
}
