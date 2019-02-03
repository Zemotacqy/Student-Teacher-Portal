import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.*;
public class Add_student{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton add,reset;
	Add_student(String value){
		f = new JFrame("Add Student Information");
		f.setLayout(new GridLayout(7,2,10,30));   //entered hgap and vgap
		l1 = new JLabel("Student Name");
		l2 = new JLabel("Age");
		l3 = new JLabel("Course");
		l4 = new JLabel("College");
		l5 = new JLabel("Contact No.");
		l5.setToolTipText("Enter contact No. without zero atfirst.");
		l6 = new JLabel("Student ID");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField(value);
		t6.setEditable(false);
		add = new JButton("ADD");
		reset = new JButton("RESET");
		f.add(l6);
		f.add(t6);
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(l5);
		f.add(t5);
		f.add(add);
		f.add(reset);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(true);
		f.setSize(500,500);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			}
		});
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("")){
					JOptionPane.showMessageDialog(null,"FILL ALL.","INFO!!",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					String val1 = t1.getText();
					String val2 = t2.getText();
					String val3 = t3.getText();
					String val4 = t4.getText();
					String val5 = t5.getText();
					Connection con = null;
					String url = "jdbc:mysql://localhost:3306/";
					String db = "login";
					String driver = "com.mysql.jdbc.Driver";
					String user = "zemotacqy";
					String pass = "Zemotacqy";
					try{
												Class.forName(driver);
						con = DriverManager.getConnection(url+db, user, pass);
						PreparedStatement st = con.prepareStatement("insert into student(student_name,age,course,college,Contact) values(?,?,?,?,?)");
						st.setString(1,val1);
						st.setString(2,val2);
						st.setString(3,val3);
						st.setString(4,val4);
						st.setString(5,val5);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"INFORMATION ADDED SUCCESSFULLY","INFO!!",JOptionPane.INFORMATION_MESSAGE);
						f.dispose();
						Main_form p = new Main_form();
						p.display();
						con.close();
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null,"INVALID INPUT.","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
	void display(){
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(true);
		f.setSize(600,600);
	}
	public static void main(String args[]){
		/*Add_student d = new Add_student();
		Add_student.display();*/
	}
}