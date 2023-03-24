



import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Show_Detail extends JFrame {

  private JPanel contentPane;
  int student_id;

  /*
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Show_Detail frame = new Show_Detail();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /*
   * Create the frame.
   */
  Connection con = null;
  private JTable table_student;
  private JTable book_table;
  private JTable show_rec_tab;
  public Show_Detail() {
    con = DBConnector.getDBconnector();
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 932, 762);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.DARK_GRAY);
    panel.setBounds(10, 10, 898, 705);
    contentPane.add(panel);
    panel.setLayout(null);
    
    JButton btn_showstudent = new JButton("show student detail");
    btn_showstudent.setForeground(Color.BLUE);
    btn_showstudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btn_showstudent.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
      
        try {
          String sql = "select* from student";
          PreparedStatement pst = con.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
           ResultSetMetaData rsmd = rs.getMetaData();
           DefaultTableModel model =(DefaultTableModel) table_student.getModel();
           int cols = rsmd.getColumnCount();
           String[] colName = new String[cols];
           for(int i = 0; i < cols ;i++) {
             colName[i] = rsmd.getColumnName(i+1);  
           } 
           model.setColumnIdentifiers(colName);
           String student_id;
           String student_name;
           String course;
           String address;
           while(rs.next()) {
             student_id = rs.getString(1);
             student_name = rs.getString(2);
             course = rs.getString(3);
             address = rs.getString(4);
             String[] row = {student_id,student_name,course,address};
             model.addRow(row);
           }
           pst.close();
           rs.close();
           
           }
            
        catch(Exception e1 ) {
          e1 .printStackTrace();;
        }
        
        
      }
    });
    btn_showstudent.setBounds(114, 333, 267, 21);
    panel.add(btn_showstudent);
    
    JButton btnNewButton_1 = new JButton("show book detail");
    btnNewButton_1.setForeground(Color.BLUE);
    btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String sql = "select * from books";
          PreparedStatement pst = con.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
           ResultSetMetaData rsmd = rs.getMetaData();
           DefaultTableModel model =(DefaultTableModel) book_table.getModel();
           int cols = rsmd.getColumnCount();
           String[] colName = new String[cols];
           for(int i = 0; i < cols ;i++) {
             colName[i] = rsmd.getColumnName(i+1);  
           } 
           model.setColumnIdentifiers(colName);
           String book_name;


String Author;
           String publisher;
           String price;
           String quantity;
           String book_id;
           while(rs.next()) {
             book_name = rs.getString(1);
             Author= rs.getString(2);
             publisher = rs.getString(3);
             price = rs.getString(4);
             quantity = rs.getString(5);
             book_id = rs.getString(6);
             String[] row = {book_name,Author,publisher,price,quantity,book_id};
             model.addRow(row);
           }
           pst.close();
           rs.close();
           
           }
            
        catch(Exception e1 ) {
          e1 .printStackTrace();;
        }
      }
    });
    btnNewButton_1.setBounds(564, 333, 230, 21);
    panel.add(btnNewButton_1);
    
    JButton show_rec_btn = new JButton("show transaction");
    show_rec_btn.setForeground(Color.BLUE);
    show_rec_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
    show_rec_btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String sql = "select * from issue_details";
          PreparedStatement pst = con.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
           ResultSetMetaData rsmd = rs.getMetaData();
           DefaultTableModel model =(DefaultTableModel)  show_rec_tab.getModel();
           int cols = rsmd.getColumnCount();
           String[] colName = new String[cols];
           for(int i = 0; i < cols ;i++) {
             colName[i] = rsmd.getColumnName(i+1);  
           } 
           model.setColumnIdentifiers(colName);
           String issue_id;
           String book_id;
           String student_id;
           String book_name;
           String student_name;
           String issue_date;
           String return_date;
           String status;
           
           while(rs.next()) {
             issue_id = rs.getString(1);
             book_id= rs.getString(2);
             student_id = rs.getString(3);
             book_name = rs.getString(4);
             student_name = rs.getString(5);
             issue_date= rs.getString(6);
             return_date= rs.getString(6);
             status= rs.getString(6);
             String[] row = {issue_id,book_id,student_id,book_name,student_name ,issue_date,return_date,status};
             model.addRow(row);
           }
           pst.close();
           rs.close();
           
           }
            
        catch(Exception e1 ) {
          e1 .printStackTrace();;
        }
        
        
      }
    });
    show_rec_btn.setBounds(330, 642, 256, 21);
    panel.add(show_rec_btn);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(29, 145, 383, 142);
    panel.add(scrollPane);
    
    table_student = new JTable();
    scrollPane.setViewportView(table_student);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(461, 146, 404, 142);
    panel.add(scrollPane_1);
    
    book_table = new JTable();
    scrollPane_1.setViewportView(book_table);
    
    JScrollPane scrollPane_2 = new JScrollPane();
    scrollPane_2.setBounds(75, 407, 763, 209);
    panel.add(scrollPane_2);
    
    show_rec_tab = new JTable();
    scrollPane_2.setViewportView(show_rec_tab);
    
    JLabel lblNewLabel = new JLabel("SHOW DETAILS");
    lblNewLabel.setForeground(Color.BLUE);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 41));
    lblNewLabel.setBounds(275, 10, 488, 97);
    panel.add(lblNewLabel);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.RED);
    panel_1.setForeground(Color.RED);
    panel_1.setBounds(0, 0, 89, 20);
    panel.add(panel_1);
    panel_1.setLayout(null);
    
    JLabel lblNewLabel_1 = new JLabel("BACK");
    lblNewLabel_1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        Home_Page home = new Home_Page();
        home.setVisible(true);
        dispose();
      }
    });
    lblNewLabel_1.setForeground(Color.BLACK);


lblNewLabel_1.setBounds(10, 5, 82, 13);
    panel_1.add(lblNewLabel_1);
    
    JLabel lblNewLabel_2 = new JLabel("STUDENT DETAIL TABLE");
    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel_2.setBounds(45, 108, 224, 30);
    panel.add(lblNewLabel_2);
    
    JLabel lblNewLabel_3 = new JLabel("BOOK DETAIL TABLE");
    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel_3.setBounds(461, 108, 346, 28);
    panel.add(lblNewLabel_3);
    
    JLabel lblNewLabel_4 = new JLabel("ISSUED BOOK DETAIL");
    lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel_4.setBounds(324, 364, 501, 33);
    panel.add(lblNewLabel_4);
  }
}