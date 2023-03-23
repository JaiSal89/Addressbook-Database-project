import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestGUI extends JFrame implements ActionListener{

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public JInternalFrame mFrame;
	public JInternalFrame cFrame;

	public TestGUI()
	{
		super();
		setSize(WIDTH, HEIGHT);
		setLocation(80,80); // setting the location on the screen
		setTitle("Button Demo");
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.gray);
		addWindowListener(new WindowDestroyer());

		JDesktopPane dtp = new JDesktopPane();

	   	 	setContentPane(dtp);

	    	JPanel buttonPanel = new JPanel(); // Java panel to hold buttons
	    	buttonPanel.setLayout(new FlowLayout());// Setting the layout of buttons

	    	JPanel textPanel = new JPanel();// Java panel to hold labels and text fields
	    	textPanel.setLayout(new FlowLayout());

	    	JLabel fname = new JLabel("First Name"); //Creates Java label
	    	JTextField f1 = new JTextField(10); // Creates Java text field

	    	textPanel.add(fname); //adds the label to the textPanel
	    	textPanel.add(f1); //adds the text field to the textPanel



	    	mFrame = new JInternalFrame("First frame", true,true, true, true);
	    	mFrame.setLayout(new BorderLayout());

	    	JButton redButton = new JButton("Red");
	    	redButton.addActionListener(this);

	    	JButton greenButton = new JButton("Green");
	    	greenButton.addActionListener(this);

	    	buttonPanel.add(redButton);
	    	buttonPanel.add(greenButton);
	    	mFrame.setSize(400, 300);
	    	mFrame.setLocation(50, 50);

	    	mFrame.add(textPanel, BorderLayout.WEST); // adds textPanel to the main frame of the window
	    	mFrame.add(buttonPanel, BorderLayout.SOUTH);// adds buttons to the main frame
	    	mFrame.setVisible(true);
	    	dtp.add(mFrame);

	    JPanel newButtonPanel = new JPanel();
	    cFrame = new JInternalFrame("Second frame", true,true, true, true);
	    cFrame.setLayout(new BorderLayout());

	    JButton blueButton = new JButton("Blue");
	    blueButton.addActionListener(this);

	    JButton yellowButton = new JButton("Yellow");
	    yellowButton.addActionListener(this);

	    newButtonPanel.add(blueButton);
	    newButtonPanel.add(yellowButton);
	    cFrame.setSize(400, 300);
	    cFrame.setLocation(70, 70);
	    cFrame.add(newButtonPanel, BorderLayout.SOUTH);
	    cFrame.setVisible(true);
	    dtp.add(cFrame);
	    }

	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Red"))
			mFrame.setBackground(Color.red);
		else if(e.getActionCommand().equals("Green"))
			mFrame.setBackground(Color.green);
		else if(e.getActionCommand().equals("Blue"))
			cFrame.setBackground(Color.blue);
		else if(e.getActionCommand().equals("Yellow"))
			cFrame.setBackground(Color.yellow);
		else
			System.out.println("Error in button interface");
	}

	public static void main(String[] args)
	{
		TestGUI buttonGui = new TestGUI();
		buttonGui.setVisible(true);
	}
}

class WindowDestroyer extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
	    System.exit(0);
	}

}
