import javax.swing.*;
import java.awt.*;
public class GameFrame extends JFrame{ 
	private Mario m;
	public  JLabel scoreLabel = new JLabel("score : ");
	public  JLabel timerLabel = new JLabel("seconds : ");
	private JPanel scorePanel, gamePanel;
	
	public GameFrame( GamePanel gamePanel, Mario m, int width, int height) {
		this.m = m;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		editLabel(scoreLabel);
		editLabel(timerLabel);
		scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 300, 3));
		cp.add(gamePanel, BorderLayout.CENTER);
		scorePanel.setBackground(new Color(163, 212, 247));
		scorePanel.add(scoreLabel);
		scorePanel.add(timerLabel);
		cp.add(scorePanel, BorderLayout.NORTH);	
		setSize(width, height);
		setTitle("Super Mario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(m);
		gamePanel.repaint();
	}

	public void editLabel(JLabel label) {
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
	}
	public void editButton(JButton b) {
		b.setBackground(new Color(250, 22, 79));
		b.setForeground(Color.WHITE);
		b.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
	}
	public void setLeftTime(long time) {
		timerLabel.setText("time: " + (60 - time));
	}
	public void setScoreLabel(int s) {
		scoreLabel.setText("score: " + s );
	}

}

