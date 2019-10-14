package subway;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Mainui extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	
	private JPanel jp2 = new JPanel();
	
	
	private JButton search = new JButton("查询");
	private JLabel start = new JLabel("起始站："); 
	private JLabel end = new JLabel("终点站：");
	private JTextField starttxt = new JTextField(30);
	private JTextField endtxt = new JTextField(30);

	public Mainui() {
		super( "北京地铁出行规划系统");
		
		
		jp2.add(start);
		jp2.add(starttxt);
		jp2.add(end);
		jp2.add(endtxt);
		jp2.add(search);
		

		this.add(jp2,BorderLayout.CENTER);
		
		this.setSize(400, 150);
		
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);
		
		this.validate();
		
		search.addActionListener(this);
		
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.search) { 
			LineOut lo = new LineOut();
			
			System.out.println((lo.LineOut(Data.toStation((String)starttxt.getText()),Data.toStation((String)endtxt.getText()))));
		}
	}
}
