import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.io.*;
public class Delete_teacher{
	JFrame f;
	JLabel l1;
	JTextField t1;
	JButton delete,reset;
	Delete_teacher(){
		f = new JFrame("Delete teacher Information");
		f.setLayout(null);   
		l1 = new JLabel("teacher ID");
		l1.setBounds(100,200,100,30);
		t1 = new JTextField();
		t1.setBounds(250,200,100,30);
		delete = new JButton("DELETE");
		delete.setBounds(100,350,100,40);
		reset = new JButton("RESET");
		reset.setBounds(245,350,100,40);
		f.add(l1);
		f.add(t1);
		f.add(delete);
		f.add(reset);
		
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				t1.setText("");
			}
		});
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(t1.getText().equals("")){
					JOptionPane.showMessageDialog(null,"FILL ALL.","INFO!!",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					String val1 = t1.getText();
					Connection con = null;
					String url = "jdbc:mysql://localhost:3306/";
					String db = "login";
					String driver = "com.mysql.jdbc.Driver";
					String user = "zemotacqy";
					String pass = "Zemotacqy";
					try{
						Class.forName(driver);
						con = DriverManager.getConnection(url+db,user,pass);
						PreparedStatement st = con.prepareStatement("DELETE FROM teacher WHERE teacher_id = ?");
						st.setString(1,val1);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"INFORMATION DELETED.","INFO!!",JOptionPane.INFORMATION_MESSAGE);
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
		/*Delete_teacher d = new Delete_teacher();
		d.display();*/
	}
}