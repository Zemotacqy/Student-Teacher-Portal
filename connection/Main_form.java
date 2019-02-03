import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
public class Main_form{
	JFrame f,f1;
	JPanel student,teacher;
	JLabel l1,l11,l12,l13,l2,l21,l22,l23,l3,l4,l5,l6,l7,l8,l14,l24,l9,l15,l10,l25;
	JTabbedPane tb;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;								
	static JTable table;		
	String[] column_names = {"Student id","Student name","Age","Course","College","Contact No."};	
	String[] column_namest = {"Teacher id","Teacher name","Age","Subject","Qualifications","Contact No."};	

	Main_form(){
		f = new JFrame("Main_form");
		tb = new JTabbedPane();
		student = new JPanel(new GridLayout(5,3,10,75));
		teacher = new JPanel(new GridLayout(5,3,10,75));
		l1 = new JLabel("1.");
		l2 = new JLabel("2.");
		l3 = new JLabel("3.");
		l4 = new JLabel("1.");
		l5 = new JLabel("2.");
		l6 = new JLabel("3.");
		l7 = new JLabel("4.");
		l8 = new JLabel("4.");
		l9 = new JLabel("5.");
		l10 = new JLabel("5.");
		l11 = new JLabel("Add Information");
		l12 = new JLabel("Edit Information");
		l13 = new JLabel("Delete Information");
		l14 = new JLabel("View Information");
		l15 = new JLabel("Search Information");
		l21 = new JLabel("Add Information");
		l22 = new JLabel("Edit Information");
		l23 = new JLabel("Delete Information");
		l24 = new JLabel("View Information");
		l25 = new JLabel("Search Information");
		b1 = new JButton("GO");
		b2 = new JButton("GO");
		b3 = new JButton("GO");
		b4 = new JButton("GO");
		b5 = new JButton("GO");
		b6 = new JButton("GO");
		b7 = new JButton("GO");
		b8 = new JButton("GO");
		b9 = new JButton("GO");
		b10 = new JButton("GO");
		student.add(l1);
		student.add(l11);
		student.add(b1);
		student.add(l2);
		student.add(l12);
		student.add(b2);
		student.add(l3);
		student.add(l13);
		student.add(b3);
		student.add(l7);
		student.add(l14);
		student.add(b4);
		student.add(l9);
		student.add(l15);
		student.add(b5);
		
		teacher.add(l4);
		teacher.add(l21);
		teacher.add(b6);
		teacher.add(l5);
		teacher.add(l22);
		teacher.add(b7);
		teacher.add(l6);
		teacher.add(l23);
		teacher.add(b8);
		teacher.add(l8);
		teacher.add(l24);
		teacher.add(b9);
		teacher.add(l10);
		teacher.add(l25);
		teacher.add(b10);
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Connection con = null;
				String url = "jdbc:mysql://localhost:3306/";
				String db = "login";
				String driver = "com.mysql.jdbc.Driver";
				String user = "zemotacqy";
				String pass = "Zemotacqy";
				try{
					Class.forName(driver);
					con = DriverManager.getConnection(url+db,user,pass);
					PreparedStatement st = con.prepareStatement("select * from student order by student_id desc limit 0,1");
					ResultSet rs = st.executeQuery();
					rs.next();
					String val = String.format("%d",Integer.parseInt(rs.getString(1))+1);
					con.close();
					Add_student a = new Add_student(val);
					a.display();
					f.dispose();
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,"BLAH!!","ERROR",JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Edit_student a = new Edit_student();
				a.display();
				f.dispose();
			}
		});
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Delete_student a = new Delete_student();
				a.display();
				f.dispose();
			}
		});
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				result_s();
			}
		});
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Search_student a = new Search_student();
				a.display();
			}
		});
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Connection con = null;
				String url = "jdbc:mysql://localhost:3306/";
				String db = "login";
				String driver = "com.mysql.jdbc.Driver";
				String user = "zemotacqy";
				String pass = "Zemotacqy";
				try{
					Class.forName(driver);
					con = DriverManager.getConnection(url+db,user,pass);
					PreparedStatement st = con.prepareStatement("select * from teacher order by teacher_id desc limit 0,1");
					ResultSet rs = st.executeQuery();
					rs.next();
					String val = String.format("%d",Integer.parseInt(rs.getString(1))+1);
					con.close();
					Add_teacher a = new Add_teacher(val);
					a.display();
				  	f.dispose();
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,"BLAH!!","ERROR",JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Edit_teacher a = new Edit_teacher();
				a.display();
				f.dispose();
			}
		});
		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Delete_teacher a = new Delete_teacher();
				a.display();
				f.dispose();
			}
		});
		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				result_t();
			}
		});
		b10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Search_teacher a = new Search_teacher();
				a.display();
			}
		});
	}
	public void result_s(){
		f1 = new JFrame("Search Result");
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable();
		table.setModel(model);
		model.setColumnIdentifiers(column_namest);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		String id = "";
		String val2 = "";
		String val3 = "";
		String val4 = "";
		String val5 = "";
		String val6 = "";
		Connection con = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/login";
		String user = "zemotacqy";
		String pass = "Zemotacqy";
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement("select * from student ");
			ResultSet rs = st.executeQuery();
			int i=0;
			
			while(rs.next()){
				id = rs.getString("student_id");
				val2 = rs.getString("student_name");
				val3 = rs.getString("age");
				val4 = rs.getString("course");
				val5 = rs.getString("college");
				val6 = rs.getString("contact");
				model.addRow(new Object[] {id,val2,val3,val4,val5,val6});
				i++;
			}
			if(i<1){
				JOptionPane.showMessageDialog(null,"Record Not Found.","INFO!!",JOptionPane.INFORMATION_MESSAGE);
			}
			if(i==1){
				JOptionPane.showMessageDialog(null,"Record Found.","INFO!!",JOptionPane.INFORMATION_MESSAGE);

			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"INVALID INPUT.","ERROR",JOptionPane.ERROR_MESSAGE);

		}
		f1.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f1.setSize(500,500);
		f1.setLayout(new BorderLayout());
		f1.setResizable(true);
		f1.setVisible(true);	
		f1.add(scroll);
	}
	public void result_t(){
		f1 = new JFrame("Search Result");
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable();
		table.setModel(model);
		model.setColumnIdentifiers(column_names);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		String id = "";
		String val2 = "";
		String val3 = "";
		String val4 = "";
		String val5 = "";
		String val6 = "";
		Connection con = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/login";
		String user = "zemotacqy";
		String pass = "Zemotacqy";
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pass);
			PreparedStatement st = con.prepareStatement("select * from teacher ");
			ResultSet rs = st.executeQuery();
			int i=0;
			
			while(rs.next()){
				id = rs.getString("teacher_id");
				val2 = rs.getString("teacher_name");
				val3 = rs.getString("age");
				val4 = rs.getString("subject");
				val5 = rs.getString("qualifications");
				val6 = rs.getString("contact");
				model.addRow(new Object[] {id,val2,val3,val4,val5,val6});
				i++;
			}
			if(i<1){
				JOptionPane.showMessageDialog(null,"Record Not Found.","INFO!!",JOptionPane.INFORMATION_MESSAGE);
			}
			if(i==1){
				JOptionPane.showMessageDialog(null,"Record Found.","INFO!!",JOptionPane.INFORMATION_MESSAGE);

			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"INVALID INPUT.","ERROR",JOptionPane.ERROR_MESSAGE);

		}
		f1.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f1.setSize(500,500);
		f1.setLayout(new BorderLayout());
		f1.setResizable(true);
		f1.setVisible(true);	
		f1.add(scroll);
	}
	void display(){
		f.getContentPane().add(tb);
		tb.add("student",student);
		tb.add("teacher",teacher);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setSize(600,600);
		f.setResizable(true);
	}
	
	public static void main(String args[]){
		/*Main_form m = new Main_form();
		m.display();*/
	}
}