

import java.awt.BorderLayout;
import java.sql.*;
import java.util.regex.Pattern;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField text_book_id;
	private JTextField text_student_id;
	private JTextField book_name;
	private JTextField student_name;
	private JTextField issue_date;
	private JTextField due_date;
	private JTextField error_message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReturnBook() {
		setUndecorated(true);
		setTitle("ReturnBook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 420);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 634, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return Book");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(31, 42, 203, 53);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(31, 92, 206, 5);
		panel.add(panel_1);
		
		JLabel txt_book_id = new JLabel("BOOK_ID:");
		txt_book_id.setBackground(Color.GRAY);
		txt_book_id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_book_id.setBounds(21, 117, 91, 23);
		panel.add(txt_book_id);
		
		JLabel lblNewLabel_1_1 = new JLabel("STUDENT_ID:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 165, 91, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lbl_book_id = new JLabel("");
		lbl_book_id.setForeground(Color.WHITE);
		lbl_book_id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_book_id.setBackground(Color.GRAY);
		lbl_book_id.setBounds(97, 117, 147, 23);
		panel.add(lbl_book_id);
		
		text_book_id = new JTextField();
		text_book_id.setBackground(Color.WHITE);
		text_book_id.setBounds(93, 119, 127, 20);
		panel.add(text_book_id);
		text_book_id.setColumns(10);
		
		JLabel Student_id = new JLabel("");
		Student_id.setForeground(Color.WHITE);
		Student_id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Student_id.setBackground(Color.WHITE);
		Student_id.setBounds(97, 165, 127, 23);
		panel.add(Student_id);
		
		text_student_id = new JTextField();
		text_student_id.setColumns(10);
		text_student_id.setBounds(97, 167, 127, 20);
		panel.add(text_student_id);
		
		JButton btnNewButton = new JButton("ReturnBook");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(returnBook()) {
					JOptionPane.showMessageDialog(null,"book returned successfuly");
					updateBookQuantity();
				}else {
					JOptionPane.showMessageDialog(null,"cannot return book");
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(80, 298, 119, 23);
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(320, 92, 221, 5);
		panel.add(panel_2);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setForeground(Color.BLUE);
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDetails.setBounds(352, 42, 203, 53);
		panel.add(lblDetails);
		
		JButton btnNewButton_1 = new JButton("Find");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(variableType()) {
				getIssueDetial();}
				
			}
		});
		btnNewButton_1.setBounds(80, 244, 119, 23);
		panel.add(btnNewButton_1);
		
		JLabel txt_book_id_1 = new JLabel("Book Name");
		txt_book_id_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_book_id_1.setBackground(Color.GRAY);
		txt_book_id_1.setBounds(320, 122, 91, 23);
		panel.add(txt_book_id_1);
		
		JLabel txt_book_id_1_1 = new JLabel("Student Name");
		txt_book_id_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_book_id_1_1.setBackground(Color.GRAY);
		txt_book_id_1_1.setBounds(320, 165, 91, 23);
		panel.add(txt_book_id_1_1);
		
		JLabel txt_book_id_1_1_1 = new JLabel("Issue Date");
		txt_book_id_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_book_id_1_1_1.setBackground(Color.GRAY);
		txt_book_id_1_1_1.setBounds(320, 215, 91, 23);
		panel.add(txt_book_id_1_1_1);
		
		JLabel txt_book_id_1_1_2 = new JLabel("Due Date");
		txt_book_id_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_book_id_1_1_2.setBackground(Color.GRAY);
		txt_book_id_1_1_2.setBounds(320, 266, 91, 23);
		panel.add(txt_book_id_1_1_2);
		
		JLabel lbl_book_name = new JLabel("");
		lbl_book_name.setForeground(Color.WHITE);
		lbl_book_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_book_name.setBackground(Color.GRAY);
		lbl_book_name.setBounds(408, 117, 147, 23);
		panel.add(lbl_book_name);
		
		JLabel lbl_student_name = new JLabel("");
		lbl_student_name.setForeground(Color.WHITE);
		lbl_student_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_student_name.setBackground(Color.GRAY);
		lbl_student_name.setBounds(408, 165, 147, 23);
		panel.add(lbl_student_name);
		
		JLabel lbl_issue_date = new JLabel("");
		lbl_issue_date.setForeground(Color.WHITE);
		lbl_issue_date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_issue_date.setBackground(Color.GRAY);
		lbl_issue_date.setBounds(408, 215, 147, 23);
		panel.add(lbl_issue_date);
		
		JLabel lbl_error_message = new JLabel("");
		lbl_error_message.setForeground(Color.WHITE);
		lbl_error_message.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_error_message.setBackground(Color.GRAY);
		lbl_error_message.setBounds(320, 334, 221, 23);
		panel.add(lbl_error_message);
		
		JLabel lbl_due_date = new JLabel("");
		lbl_due_date.setForeground(Color.WHITE);
		lbl_due_date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_due_date.setBackground(Color.GRAY);
		lbl_due_date.setBounds(408, 266, 147, 23);
		panel.add(lbl_due_date);
		
		book_name = new JTextField();
		book_name.setEditable(false);
		book_name.setColumns(10);
		book_name.setBackground(Color.WHITE);
		book_name.setBounds(414, 119, 127, 26);
		panel.add(book_name);
		
		student_name = new JTextField();
		student_name.setFont(new Font("Tahoma", Font.PLAIN, 10));
		student_name.setEditable(false);
		student_name.setColumns(10);
		student_name.setBackground(Color.WHITE);
		student_name.setBounds(414, 165, 132, 23);
		panel.add(student_name);
		
		issue_date = new JTextField();
		issue_date.setEditable(false);
		issue_date.setColumns(10);
		issue_date.setBackground(Color.WHITE);
		issue_date.setBounds(414, 217, 127, 28);
		panel.add(issue_date);
		
		due_date = new JTextField();
		due_date.setEditable(false);
		due_date.setColumns(10);
		due_date.setBackground(Color.WHITE);
		due_date.setBounds(414, 268, 127, 21);
		panel.add(due_date);
		
		error_message = new JTextField();
		error_message.setEditable(false);
		error_message.setColumns(10);
		error_message.setBackground(Color.WHITE);
		error_message.setBounds(320, 334, 221, 20);
		panel.add(error_message);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.CYAN);
		panel_1_1.setBounds(0, 10, 91, 34);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Back");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home_Page home = new Home_Page();
				home.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBackground(Color.CYAN);
		lblNewLabel_1_1_1.setBounds(19, 5, 72, 20);
		panel_1_1.add(lblNewLabel_1_1_1);
	}
	//method to return the book and update the database
	public boolean returnBook() {
		boolean isReturned=false;
		int book_id=Integer.parseInt(text_book_id.getText());
	    int student_id=Integer.parseInt(text_student_id.getText());
		try {
			Connection con = DBConnector.getDBconnector();
			String sql="update issue_details set status=? where student_id=? and book_id=? and status=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, "returned");
			ps.setInt(2, student_id);
			ps.setInt(3, book_id);
			ps.setString(4, "pending");
			int count=ps.executeUpdate();
			if(count>0) {
				isReturned=true;
			}else {
				isReturned=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isReturned;
	}
	//method to get data from database and display it to the panel
	public void getIssueDetial(){
		

		int book_id=Integer.parseInt(text_book_id.getText());
	    int student_id=Integer.parseInt(text_student_id.getText());
	    try {
	    	Connection con =DBConnector.getDBconnector();
	    	  PreparedStatement ps=con.prepareStatement("select * from issue_details where book_id=? and student_id=? and status=?");
			   ps.setInt(1,book_id);
			   ps.setInt(2,student_id);
			   ps.setString(3,"pending");
			   ResultSet rs= ps.executeQuery();
			   if (rs.next()) {
			
				   book_name.setText(rs.getString("book_name"));
				   student_name.setText(rs.getString("student_name"));
				   issue_date.setText(rs.getString("issue_date"));
				   due_date.setText(rs.getString("return_date"));
				   error_message.setText("");
	
			   }else {
				   error_message.setText("No record Found");
				   book_name.setText("");
				   student_name.setText("");
				   issue_date.setText("");
				   due_date.setText("");
				
			   }
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	
	    }
	   
	}
	  //method to update book quantity
	public void updateBookQuantity(){
		int book_id;
		 book_id=Integer.parseInt(text_book_id.getText());
		 try {
			 Connection con =DBConnector.getDBconnector();
		      PreparedStatement ps=con.prepareStatement("update books set quantity=quantity+1 where book_id=?");
		      ps.setInt(1, book_id);
		      int count = ps.executeUpdate();
		      if(count>0) {
		    	  JOptionPane.showMessageDialog(null,"book quantity updated");
		      }else {
		    	  JOptionPane.showMessageDialog(null,"cannot update book count");
		      }
		      
		      
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
	  }
	public boolean variableType() {
		boolean valid = false;
		String id = text_book_id.getText();
		String student = text_student_id.getText();
		
		
		if (!(Pattern.matches("[a-zA-Z]+", id) == false && id.length() > 0)) {JOptionPane.showMessageDialog(this, "please enter a numbere valued book id");
	    return false;   }
		if (!(Pattern.matches("[a-zA-Z]+", student) == false && student.length() > 0)) {
			JOptionPane.showMessageDialog(this, "please enter a number valued student id");
	        return false;   
		}
		
		
		return true;
		
			
		
	}}
