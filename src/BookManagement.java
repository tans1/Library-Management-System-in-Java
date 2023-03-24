
import java.sql.*;
import java.util.regex.Pattern;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class BookManagement extends JFrame {

	private JPanel contentPane;
	private JTextField text_book_name;
	private JTextField text_author;
	private JTextField text_publisher;
	private JTextField text_price;
	private JTextField text_quantity;
	private JTextField text_book_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagement frame = new BookManagement();
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
	String bookName,publisher,author;
	int book_id,quantity;
	double price;
	
	public boolean empty() {
	  	
	  	bookName = text_book_name.getText();
	     author = text_author.getText();
	    
	     publisher = text_publisher.getText();
	    
	 boolean valid = true;
	  
	 
	  if (bookName.equals("")) {
		  JOptionPane.showMessageDialog(this, "please enter book name");
		  return false;
	  }
	  
	  if (author.equals("")){
          JOptionPane.showMessageDialog(this, "please enter author");
          return false;   
      }
      
    
      if (publisher.equals("")){
          JOptionPane.showMessageDialog(this, "please enter publisher");
          return false;   
      }
     
   
      return valid;
      
  }
  
	
	
	
	public boolean typeValidation() {
		boolean valid = false;
		String id = text_book_id.getText();
		String price = text_price.getText();
		String quantity = text_quantity.getText();
		
		if (!(Pattern.matches("[a-zA-Z]+", id) == false && price.length() > 0)) {JOptionPane.showMessageDialog(this, "please enter a number id");
        return false;   }
		if (!(Pattern.matches("[a-zA-Z]+", price) == false && price.length() > 0)) {
			JOptionPane.showMessageDialog(this, "please enter a number valued price");
            return false;   
		}
		if (!(Pattern.matches("[a-zA-Z]+", quantity) == false && quantity.length() > 0)) {
			JOptionPane.showMessageDialog(this, "please enter a number valued quantity");
            return false;   
		}
		
		
		return true;
		
			
		
	}
	
	
	public boolean quantityDecrementer(int book_id,int quantity) {
		
		
		try {
			
			String sql = "select * from books where book_id = ?";
			Connection con= DBConnector.getDBconnector();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,book_id);
			
			ResultSet rs=pst.executeQuery();
			
			
			
			
			
			if (rs.next()) {
			quantity = rs.getInt("quantity")-quantity;
			if (quantity > 0) {
				sql = "update books set quantity = ? where book_id = ?";
				pst =con.prepareStatement(sql);
				pst.setInt(1,quantity);
				pst.setInt(2,book_id);
				int rst=pst.executeUpdate();
				return false;
				}
			
				
			else {
				
				return true;
				
				
			}}
			
			
			
			
			
		
			}catch(SQLException e) {
				
				
				
				
			}
		return true;
		
		
		
		
		
	}
	
	
	public boolean quantiyUpdater(int book_id, int quantiy) {
		boolean isAdded = false;
		
		
		try {
		
			String sql = "select * from books where book_id = ?";
			Connection con= DBConnector.getDBconnector();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,book_id);
			
			ResultSet rs=pst.executeQuery();
			
			
			
			
			
			if (rs.next()) {
			quantity = rs.getInt("quantity")+quantity;
			sql = "update books set quantity = ? where book_id = ?";
			pst =con.prepareStatement(sql);
			pst.setInt(1,quantity);
			pst.setInt(2,book_id);
		}
			
			
			
			
			
			int rst=pst.executeUpdate();
			if(rst>0){
				isAdded=true;
			}else {
				isAdded=false;
			}}catch(SQLException e) {
				
				
				
				
			}
	
		
		return isAdded;
	}
	public boolean addBook(){
		
		boolean isAdded=false;
		
		
		
			quantity=Integer.parseInt(text_quantity.getText());
			
			author=text_author.getText();
			double price = Double.parseDouble(text_price.getText());
			bookName=text_book_name.getText();
			Connection con= DBConnector.getDBconnector();
			book_id = Integer.parseInt(text_book_id.getText());
			String sql = "insert into books values(?,?,?,?,?,?)";
			publisher =text_publisher.getText();
			
			
			
			if (!quantiyUpdater(book_id,quantity) ) {
				
			
			
		
				
					try {
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,bookName);
					pst.setString(2,author);
					pst.setString(3,publisher);
					pst.setDouble(4,price);
					pst.setInt(5,quantity);
					pst.setInt(6, book_id);
					int rs=pst.executeUpdate();
					if(rs>0){
						isAdded=true;
					}else {
						isAdded=false;
					}}catch(SQLException e) {
						e.printStackTrace();
			}}
			
			else{
				isAdded =true;
			}
			
		
		
	
		return isAdded;}
	
	
	public boolean update() {
		boolean isUpdated=false;
		book_id = Integer.parseInt(text_book_id.getText());
		quantity=Integer.parseInt(text_quantity.getText());
		author=text_author.getText();
		bookName=text_book_name.getText();
		publisher =text_publisher.getText();
		Connection con= DBConnector.getDBconnector();
		String sql = "update books set BookName = ?, Author = ?, publisher = ?, Price = ?, quantity = ? where book_id = ?";
		
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,bookName);
		pst.setString(2,author);
		pst.setString(3,publisher);
		pst.setDouble(4,price);
		pst.setInt(5,quantity);
		pst.setInt(6, book_id);
		
		int rs=pst.executeUpdate();
		if(rs>0){
			isUpdated=true;
		}else {
			isUpdated=false;
		}}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isUpdated;
		
		
		
	}
	
	public boolean delete() {
		boolean isDeleted = false;
		book_id = Integer.parseInt(text_book_id.getText());
		quantity = Integer.parseInt(text_quantity.getText());
		String sql = "delete from books where book_id = ?";
		
		Connection con= DBConnector.getDBconnector();
		if (quantityDecrementer(book_id,quantity)) {
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				
				pst.setInt(1, book_id);
			
			
			int rs=pst.executeUpdate();
			if(rs>0){
				isDeleted=true;
			}else {
				isDeleted=false;}}
			
			catch(SQLException e) {
				e.printStackTrace();}
	}
		
		else {
			
			isDeleted = true;
		}
		
		
		return isDeleted;}
		
		
		
	
	
	
	
	public BookManagement() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-12, 0, 1226, 875);
		panel.setBackground(Color.GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOK MANAGEMENT WINDOW");
		lblNewLabel.setBounds(209, 55, 288, 29);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.BLACK);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(73, 189, 158, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book ID");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel_2.setBounds(79, 128, 100, 29);
		panel.add(lblNewLabel_2);
		
		text_book_name = new JTextField();
		text_book_name.setBounds(196, 193, 380, 29);
		panel.add(text_book_name);
		text_book_name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Author:");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel_3.setBounds(74, 266, 78, 21);
		panel.add(lblNewLabel_3);
		
		text_author = new JTextField();
		text_author.setBounds(193, 265, 383, 29);
		panel.add(text_author);
		text_author.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Publisher:");
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel_4.setBounds(74, 332, 105, 21);
		panel.add(lblNewLabel_4);
		
		text_publisher = new JTextField();
		text_publisher.setBounds(193, 331, 383, 29);
		panel.add(text_publisher);
		text_publisher.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Price:");
		lblNewLabel_5.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel_5.setBounds(74, 407, 100, 29);
		panel.add(lblNewLabel_5);
		
		text_price = new JTextField();
		text_price.setBounds(193, 410, 383, 26);
		panel.add(text_price);
		text_price.setColumns(10);
		
		
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (typeValidation()) {
					if(empty()) {
				if(addBook()==true) {
					JOptionPane.showMessageDialog(btnNewButton, "book added");
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "book has not been added");
				}}}
				
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		btnNewButton.setBounds(43, 551, 100, 36);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (delete()) {
					
					JOptionPane.showMessageDialog(btnNewButton_1, "successfully deleted");
					
					
				}
				
				else {
					JOptionPane.showMessageDialog(btnNewButton_1, "deletion failed");
				}
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		btnNewButton_1.setBounds(222, 551, 112, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Give Away");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (delete()) {
					JOptionPane.showMessageDialog(btnNewButton_2, quantity +" books have been given away");
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton_2, "Couldn't give away the books");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		btnNewButton_2.setBounds(516, 551, 149, 36);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (update()) {
					
					JOptionPane.showMessageDialog(btnNewButton_3, "Update was succesfull");
				}
				
				else {
					
					JOptionPane.showMessageDialog(btnNewButton_3, "Update failed");
				}
			}
		});
		btnNewButton_3.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		btnNewButton_3.setBounds(383, 551, 100, 36);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("quantity:");
		lblNewLabel_5_1.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel_5_1.setBounds(74, 481, 100, 29);
		panel.add(lblNewLabel_5_1);
		
		text_quantity = new JTextField();
		text_quantity.setColumns(10);
		text_quantity.setBounds(193, 484, 383, 26);
		panel.add(text_quantity);
		
		text_book_id = new JTextField();
		text_book_id.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				
				setFields();
			}
		});
		text_book_id.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		text_book_id.setColumns(10);
		text_book_id.setBounds(193, 128, 383, 26);
		panel.add(text_book_id);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.CYAN);
		panel_1_1.setBounds(24, 10, 75, 34);
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
	public void setFields() {
		String id = text_book_id.getText();
		if (!(Pattern.matches("[a-zA-Z]+", id) == false && id.length() > 0)) {JOptionPane.showMessageDialog(this, "please enter a number id");}
		else {
          
		if (!text_book_id.getText().isEmpty()) {
		int book_id= Integer.parseInt(text_book_id.getText());
		try {
			Connection con= DBConnector.getDBconnector();
			String sql = "select*from books where book_id = ?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, book_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				text_book_name.setText(rs.getString("bookName"));
				text_author.setText(rs.getString("Author"));
				text_publisher.setText(rs.getString("publisher"));
				text_price.setText(rs.getString("price"));
				text_quantity.setText(rs.getString("quantity"));
				
				
			}else {
				text_book_name.setText("");
				text_author.setText("");
				text_publisher.setText("");
				text_price.setText("");
				text_quantity.setText("");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}}
	}
	
	

}}
