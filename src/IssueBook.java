

import java.awt.BorderLayout;
import java.sql.*;
import java.util.regex.Pattern;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IssueBook extends JFrame {

  private JPanel contentPane;
  private JTextField text_book_id;
  private JTextField text_student_id;
  private JTextField text_issue_date;
  private JTextField text_return_date;
  private JTextField err_text;


  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          IssueBook frame = new IssueBook();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public IssueBook() {
  	setUndecorated(true);
  	setResizable(false);
    setTitle("Issue Book ");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 648, 421);
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
    
    JLabel lblNewLabel = new JLabel("Issue Book");
    lblNewLabel.setForeground(Color.BLUE);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblNewLabel.setBounds(166, 25, 203, 53);
    panel.add(lblNewLabel);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.BLUE);
    panel_1.setBounds(163, 68, 206, 5);
    panel.add(panel_1);
    
    JLabel txt_book_id = new JLabel("BOOK_ID:");
    txt_book_id.setBackground(Color.GRAY);
    txt_book_id.setFont(new Font("Tahoma", Font.PLAIN, 12));
    txt_book_id.setBounds(21, 117, 91, 23);
    panel.add(txt_book_id);
    
    JLabel lblNewLabel_1_1 = new JLabel("STUDENT_ID:");
    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
    lblNewLabel_1_1.setBounds(21, 165, 91, 23);
    panel.add(lblNewLabel_1_1);
    
    JLabel lblNewLabel_1_1_1 = new JLabel("ISSUE_DATE:");
    lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
    lblNewLabel_1_1_1.setBounds(21, 213, 91, 23);
    panel.add(lblNewLabel_1_1_1);
    
    JLabel lblNewLabel_1_1_1_1 = new JLabel("RETURN_DATE:");
    lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
    lblNewLabel_1_1_1_1.setBounds(21, 259, 91, 23);
    panel.add(lblNewLabel_1_1_1_1);
    
    JLabel lbl_issue_date = new JLabel("");
    lbl_issue_date.setForeground(Color.WHITE);
    lbl_issue_date.setBackground(Color.WHITE);
    lbl_issue_date.setFont(new Font("Tahoma", Font.PLAIN, 10));
    lbl_issue_date.setBounds(136, 213, 127, 23);
    panel.add(lbl_issue_date);
    
    JLabel lbl_return_date = new JLabel("");
    lbl_return_date.setForeground(Color.WHITE);
    lbl_return_date.setFont(new Font("Tahoma", Font.PLAIN, 10));
    lbl_return_date.setBackground(Color.WHITE);
    lbl_return_date.setBounds(136, 259, 127, 23);
    panel.add(lbl_return_date);
    
    JLabel lbl_book_id = new JLabel("");
    lbl_book_id.setForeground(Color.WHITE);
    lbl_book_id.setFont(new Font("Tahoma", Font.PLAIN, 12));
    lbl_book_id.setBackground(Color.GRAY);
    lbl_book_id.setBounds(136, 117, 119, 23);
    panel.add(lbl_book_id);
    
    text_book_id = new JTextField();
    text_book_id.setBackground(Color.WHITE);
    text_book_id.setBounds(136, 119, 119, 20);
    panel.add(text_book_id);
    text_book_id.setColumns(10);
    
    JLabel Student_id = new JLabel("");
    Student_id.setForeground(Color.WHITE);
    Student_id.setFont(new Font("Tahoma", Font.PLAIN, 12));
    Student_id.setBackground(Color.WHITE);
    Student_id.setBounds(136, 165, 119, 23);
    panel.add(Student_id);
    text_student_id = new JTextField();
    text_student_id.setColumns(10);
    text_student_id.setBounds(136, 167, 119, 20);
    panel.add(text_student_id);
    
    text_issue_date = new JTextField();
    text_issue_date.setColumns(10);
    text_issue_date.setBounds(136, 215, 119, 20);
    panel.add(text_issue_date);
    
    text_return_date = new JTextField();
    text_return_date.setColumns(10);
    text_return_date.setBounds(136, 261, 127, 20);
    panel.add(text_return_date);
    
    JButton btnNewButton = new JButton("IssueBook");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  //validateQuantity check if quantity is 0 in books table
    	  if(type()) {if(empty()) {
    	  if(validateQuantity()==false) {
    		  JOptionPane.showMessageDialog(null, "book is not available");
    	  }else {
    	  //isAlreadyIssued method check whether the book is already allocated or not
    	  if(isAlreadyIssued()==false) {
    		  //add BookDetial add values to issue_detial table 
               if(addBookDetail()) {
    	    JOptionPane.showMessageDialog(null, "book issued sucessfuly");
    		    updateBookQuantity();
    		   }else {
    		          JOptionPane.showMessageDialog(null, "sorry can't issue book");
    		        }
    	  }else {
    		  JOptionPane.showMessageDialog(null,"book already given to the student");
    	  }}
        
      }}
    }});
    btnNewButton.setForeground(Color.BLACK);
    btnNewButton.setBackground(Color.GREEN);
    btnNewButton.setBounds(358, 322, 119, 23);
    panel.add(btnNewButton);
    
    JLabel lbl_Error_message = new JLabel("");
    lbl_Error_message.setBackground(Color.GRAY);
    lbl_Error_message.setBounds(80, 322, 176, 31);
    panel.add(lbl_Error_message);
    
    err_text = new JTextField();
    err_text.setBackground(Color.GRAY);
    err_text.setBounds(80, 326, 211, 23);
    panel.add(err_text);
    err_text.setColumns(10);
    
    JPanel panel_1_1 = new JPanel();
    panel_1_1.setLayout(null);
    panel_1_1.setBackground(Color.CYAN);
    panel_1_1.setBounds(0, 0, 75, 34);
    panel.add(panel_1_1);
    
    JLabel lblNewLabel_1_1_2 = new JLabel("Back");
    lblNewLabel_1_1_2.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		Home_Page home = new Home_Page();
			home.setVisible(true);
			dispose();
    	}
    });
    lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblNewLabel_1_1_2.setBackground(Color.CYAN);
    lblNewLabel_1_1_2.setBounds(19, 5, 46, 20);
    panel_1_1.add(lblNewLabel_1_1_2);
  }
  
  //add values to issue_detial table
  public boolean addBookDetail() {
    boolean isAdded=false;
    int issue_id,book_id,student_id;
    String book_name,student_name,status;
    String issue_date,return_date;
    book_id=Integer.parseInt(text_book_id.getText());
    student_id=Integer.parseInt(text_student_id.getText());
    issue_date=text_issue_date.getText();
    return_date=text_return_date.getText();
    try {
      Connection con =DBConnector.getDBconnector();
      PreparedStatement ps0=con.prepareStatement("select * from books where book_id=?");
      
      ps0.setInt(1, book_id);
      ResultSet rs1=ps0.executeQuery();
      if(rs1.next()) {
      book_name=rs1.getString("bookName");}
     
      else {
        err_text.setText("invalid book_id");
        book_name="";
      }
      PreparedStatement ps=con.prepareStatement("select * from student where student_id=?");
      ps.setInt(1, student_id);
      ResultSet rs=ps.executeQuery();
      if(rs.next()) {
        student_name=rs.getString("student_name");
      }
      else {
        err_text.setText("invalid student_id");
        student_name="";
      }
      if(!book_name.equals("") && !student_name.equals("")) {
      //make issue_id auto_increment
      String sql="insert into issue_details(book_id,student_id,book_name,student_name,issue_date,return_date,status) values(?,?,?,?,?,?,?)";
      PreparedStatement ps1=con.prepareStatement(sql);
      ps1.setInt(1, book_id);
      ps1.setInt(2, student_id);
      ps1.setString(3, book_name);
      ps1.setString(4, student_name);
      ps1.setString(5, issue_date);
      ps1.setString(6,return_date );
      ps1.setString(7,"pending" );
      int rs2=ps1.executeUpdate();
      if (rs2>0) {
        isAdded=true;}}
      }
    
          
    catch(Exception e) {
      e.printStackTrace();
    }
    return isAdded;}
  //method to check whether quantity is 0
  public boolean validateQuantity() {
	  boolean valid=false;
	  int book_id=Integer.parseInt(text_book_id.getText());
	  try {
		  Connection con =DBConnector.getDBconnector();
	      PreparedStatement ps=con.prepareStatement("select * from books where book_id=?");
	      ps.setInt(1, book_id);
	      ResultSet rs=ps.executeQuery();
	      if(rs.next()) {
	    	  int quantity=rs.getInt("quantity");
		      if(quantity<=0) {
		    	  valid=false;}
		      else {
			    	  valid=true;
			      }
	      }
	      
	  }catch(Exception e) {
		  e.printStackTrace();
		  
	  }
	return valid;
	 
      }
  
  //method to check whether book is already issued or not
  public boolean isAlreadyIssued() {
	  boolean isAlreadyIssued=false;
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
			   isAlreadyIssued=true;
		   }else {
			   isAlreadyIssued=false;
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	  return isAlreadyIssued;
  }
  //method to update book quantity
public void updateBookQuantity(){
	int book_id;
	 book_id=Integer.parseInt(text_book_id.getText());
	 try {
		 Connection con =DBConnector.getDBconnector();
	      PreparedStatement ps=con.prepareStatement("update books set quantity=quantity-1 where book_id=?");
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
  
public boolean type() {
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
	
		
	
}
public boolean empty() {
  	
	String issue_date=text_issue_date.getText();
    String return_date=text_return_date.getText();
    
     
    
 boolean valid = true;
  
 
  if (issue_date.equals("")) {
	  JOptionPane.showMessageDialog(this, "please enter issue date");
	  return false;
  }
  
  if (return_date.equals("")){
      JOptionPane.showMessageDialog(this, "please enter return date");
      return false;   
  }
  

 
 

  return valid;
  
}}

	
