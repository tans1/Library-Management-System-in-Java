
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_Page extends JFrame {

  private JPanel contentPane;

  
  /* Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Home_Page frame = new Home_Page();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  
   /* Create the frame.
   */
  public Home_Page() {
    setBackground(Color.WHITE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 845, 619);
    contentPane = new JPanel();
    contentPane.setBackground(Color.DARK_GRAY);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("HOME PAGE");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
    lblNewLabel.setForeground(Color.WHITE);
    lblNewLabel.setBackground(Color.BLACK);
    lblNewLabel.setBounds(309, 27, 336, 40);
    contentPane.add(lblNewLabel);
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.CYAN);
    panel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Manage_User User = new Manage_User();
          User.setVisible(true);
                dispose();
      }
    });
    panel.setBounds(75, 77, 680, 55);
    contentPane.add(panel);
    
    JLabel lblNewLabel_1 = new JLabel("Manage User");
    lblNewLabel_1.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		Manage_User user = new Manage_User();
    		user.setVisible(true);
    		dispose();
    	}
    });
    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
    panel.add(lblNewLabel_1);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.CYAN);
    panel_1.setBounds(75, 153, 680, 55);
    contentPane.add(panel_1);
    
    JLabel lblNewLabel_2 = new JLabel("Manage Book");
    lblNewLabel_2.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		BookManagement book = new BookManagement();
    		book.setVisible(true);
    		dispose();
    		
    	}
    });
    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
    panel_1.add(lblNewLabel_2);
    
    JPanel panel_2 = new JPanel();
    panel_2.setBackground(Color.CYAN);
    panel_2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Show_Detail show = new Show_Detail();
          show.setVisible(true);
          dispose();
      }
    });
    panel_2.setBounds(75, 227, 680, 55);
    contentPane.add(panel_2);
    
    JLabel lblNewLabel_3 = new JLabel("Show Detail");
    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
    panel_2.add(lblNewLabel_3);
    
    JPanel panel_3 = new JPanel();
    panel_3.setBackground(Color.CYAN);
    panel_3.setBounds(75, 297, 680, 55);
    contentPane.add(panel_3);
    
    JLabel lblNewLabel_4 = new JLabel("Issue Book");
    lblNewLabel_4.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		IssueBook book = new IssueBook();
    		book.setVisible(true);
    		dispose();
    	}
    });
    lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
    panel_3.add(lblNewLabel_4);
    
    JPanel panel_4 = new JPanel();
    panel_4.setBackground(Color.CYAN);
    panel_4.setBounds(75, 375, 680, 55);
    contentPane.add(panel_4);
    
    JLabel lblNewLabel_5 = new JLabel("Return Book");
    lblNewLabel_5.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		ReturnBook book = new ReturnBook();
    		book.setVisible(true);
    		dispose();
    	}
    });
    lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
    panel_4.add(lblNewLabel_5);
    
    Button button = new Button("LOG OUT");
    button.setBackground(Color.BLACK);
    button.setForeground(Color.WHITE);
    button.setFont(new Font("Dialog", Font.PLAIN, 20));
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    button.setBounds(290, 451, 242, 49);
    contentPane.add(button);
  }
}