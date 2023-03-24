


import java.awt.BorderLayout;
import java.sql.*;
import java.util.regex.Pattern;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Manage_User extends JFrame {

  private JPanel contentPane;
  


    
  public static void main(String[] args) {

  
  
  
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Manage_User frame = new Manage_User();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  
   /* Create the frame.*/
   
  int student_id;
  String student_name,course,address;
  private JTextField txt_id_1;
  private JTextField txt_name_1;
  private JTextField txt_course_1;
  private JTextField txt_address_1;
  
  public boolean validater() {
	  	String id = "";
	  	student_name = txt_name_1.getText();
	     course = txt_course_1.getText();
	     id = txt_id_1.getText();
	     address = txt_address_1.getText();
	    
	 boolean valid = true;
	  
	 
	  if (id.equals("")) {
		  JOptionPane.showMessageDialog(this, "please enter id");
		  return false;
	  }
	  
	  if (student_name.equals("")){
          JOptionPane.showMessageDialog(this, "please enter name");
          return false;   
      }
      
    
      if (address.equals("")){
          JOptionPane.showMessageDialog(this, "please enter address");
          return false;   
      }
      if (course.equals("")){
          JOptionPane.showMessageDialog(this, "please enter course");
          return false;   
      }
   
      return valid;
      
  }
  
  
  public void setFields() {
	  String id = txt_id_1.getText();
		if (!(Pattern.matches("[a-zA-Z]+", id) == false && id.length() > 0)) {JOptionPane.showMessageDialog(this, "please enter a number id");}
		else {
		if (!txt_id_1.getText().isEmpty()) {
		int student_id= Integer.parseInt(txt_id_1.getText());
		try {
			Connection con= DBConnector.getDBconnector();
			String sql = "select*from student where student_id = ?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, student_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				txt_name_1.setText(rs.getString("student_name"));
				txt_course_1.setText(rs.getString("course"));
				txt_id_1.setText(rs.getString("student_id"));
				txt_address_1.setText(rs.getString("address"));
				
				
				
			}else {
				txt_name_1.setText("");
				txt_course_1.setText("");
				txt_address_1.setText("");
			}}
			catch(SQLException e) {
				e.printStackTrace();
				}
			}
				
			}}

  
  
public boolean Adduser() {
    
    boolean isAdded = false;
    
     student_name = txt_name_1.getText();
     course = txt_course_1.getText();
     student_id = Integer.parseInt(txt_id_1.getText());
     address = txt_address_1.getText();
    
     String sql = "insert into student values(?,?,?,?)";
     
     try {
       Connection con = DBConnector.getDBconnector();
       PreparedStatement pst = con.prepareStatement(sql);
       pst.setInt(1, student_id);
       pst.setString(2, student_name);
       pst.setString(3, course);
       pst.setString(4, address);
       int rs = pst.executeUpdate();
       if(rs>0) {
         isAdded = true;
       } 
       else {
         isAdded=false;}}
     catch(SQLException e) {
       e.getMessage();
     } return isAdded;}

public boolean isRemoved() {
  boolean isRemoved = false;
   student_name = txt_name_1.getText();
   course = txt_course_1.getText();
   student_id = Integer.parseInt(txt_id_1.getText());
   address = txt_address_1.getText();
   
  
   try {
     String sql = "Delete from student where student_id = ?";
     Connection con = DBConnector.getDBconnector();
     PreparedStatement pst = con.prepareStatement(sql);
     pst.setInt(1, student_id);
     int rs = pst.executeUpdate();
     if(rs>0) {
       isRemoved = true;
     } 
     else {
       isRemoved=false;}}
   catch(SQLException e) {
     e.getMessage();
   } return isRemoved;}

public boolean isUpdated() {
  boolean isUpdated = false;
   student_name = txt_name_1.getText();
   course = txt_course_1.getText();
   student_id = Integer.parseInt(txt_id_1.getText());
   address = txt_address_1.getText();
   
  
   try {
     Connection con = DBConnector.getDBconnector();
     String sql = "update student set student_name = ?, course =?, address = ? where student_id = ?";
     
     PreparedStatement pst = con.prepareStatement(sql);
     pst.setString(1, student_name);
     pst.setString(2, course);
     pst.setString(3, address);
     pst.setInt(4, student_id);
    
     int rs = pst.executeUpdate();
     if(rs>0) {
       isUpdated = true;
     } 
     else {
       isUpdated=false;}}
   catch(SQLException e) {
     e.getMessage();
   } return isUpdated;}


public Manage_User() {
    
    
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 947, 722);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.DARK_GRAY);
    panel.setBounds(0, 0, 933, 685);
    contentPane.add(panel);
    panel.setLayout(null);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBounds(49, 31, 49, -15);
    panel.add(panel_1);
    
    JLabel lblNewLabel = new JLabel("Manage User");
    lblNewLabel.setForeground(Color.BLUE);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
    lblNewLabel.setBounds(307, 5, 379, 57);
    panel.add(lblNewLabel);
    
    JPanel panel_2 = new JPanel();
    panel_2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Home_Page home = new Home_Page();
          home.setVisible(true);
                dispose();
      }
    });
    panel_2.setBackground(Color.RED);
    panel_2.setBounds(0, 5, 108, 23);
    panel.add(panel_2);
    
    JLabel lblNewLabel_1 = new JLabel("BACK");
    panel_2.add(lblNewLabel_1);
    
    JPanel panel_3 = new JPanel();
    panel_3.setBounds(59, 72, 828, 530);
    panel.add(panel_3);
    panel_3.setLayout(null);
    
    JLabel lblNewLabel_2 = new JLabel("Student_Id");
    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel_2.setBounds(74, 47, 171, 31);
    panel_3.add(lblNewLabel_2);
    
    JLabel lblNewLabel_2_1 = new JLabel("student name");
    lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel_2_1.setBounds(74, 130, 136, 35);
    panel_3.add(lblNewLabel_2_1);
    
    JLabel lblNewLabel_2_2 = new JLabel("Course");
    lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel_2_2.setBounds(74, 241, 136, 29);
    panel_3.add(lblNewLabel_2_2);
    
    JLabel lblNewLabel_2_3 = new JLabel("Address");
    lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel_2_3.setBounds(74, 337, 151, 37);
    panel_3.add(lblNewLabel_2_3);
    
    JButton add_btn = new JButton("Add Student");
    add_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
    add_btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	if (validater()) {
        if(Adduser()) {
          JOptionPane.showMessageDialog(null, "user added successfully");
        }else {
          JOptionPane.showMessageDialog(null, "can't add user");
      }
      }}
    });
    add_btn.setBounds(488, 130, 185, 21);
    panel_3.add(add_btn);
    
    JButton remove_btn = new JButton("Remove Student");
    remove_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
    remove_btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(isRemoved()) {
          JOptionPane.showMessageDialog(null, "student removed successfully");
        }
        else {JOptionPane.showMessageDialog(null, "Can't remove user");}}}
      
      );
    remove_btn.setBounds(488, 222, 185, 21);
    panel_3.add(remove_btn);
    
    JButton update_btn = new JButton("Update");
    update_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
    update_btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(isUpdated()) {
          JOptionPane.showMessageDialog(null, "student Updated successfully");
        }
        else {JOptionPane.showMessageDialog(null, "Can't Update student");}}}
      
      );
      
    
    update_btn.setBounds(488, 320, 185, 21);
    panel_3.add(update_btn);
    
    txt_id_1 = new JTextField();
    txt_id_1.addFocusListener(new FocusAdapter() {
    	@Override
    	public void focusLost(FocusEvent e) {
    		setFields();
    	}
    });
    txt_id_1.setBounds(66, 88, 295, 31);
    panel_3.add(txt_id_1);
    txt_id_1.setColumns(10);
    
    txt_name_1 = new JTextField();
    txt_name_1.setBounds(68, 182, 293, 36);
    panel_3.add(txt_name_1);
    txt_name_1.setColumns(10);
    
    txt_course_1 = new JTextField();
    txt_course_1.setBounds(74, 280, 287, 31);


panel_3.add(txt_course_1);
    txt_course_1.setColumns(10);
    
    txt_address_1 = new JTextField();
    txt_address_1.setBounds(74, 384, 287, 36);
    panel_3.add(txt_address_1);
    txt_address_1.setColumns(10);
  }
  }