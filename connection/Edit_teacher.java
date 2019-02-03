import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.io.*;
public class Edit_teacher{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton edit,update;
	Edit_teacher(){
		f = new JFrame("Edit teacher Information");
		f.setLayout(new GridLayout(7,2,10,30));   //entered hgap and vgap
		l1 = new JLabel("Teacher Name");
		l2 = new JLabel("Age");
		l3 = new JLabel("Subject");
		l4 = new JLabel("Qualifications");
		l5 = new JLabel("Contact No.");
		l6 = new JLabel("Teacher ID");
		t1 = new JTextField();
		t1.setEditable(false);
		t2 = new JTextField();
		t2.setEditable(false);
		t3 = new JTextField();
		t3.setEditable(false);
		t4 = new JTextField();
		t4.setEditable(false);
		t5 = new JTextField();
		t5.setEditable(false);
		t6 = new JTextField();
		edit = new JButton("EDIT");
		update = new JButton("UPDATE");
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
		f.add(edit);
		f.add(update);
		
		edit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(t6.getText().equals("")){
					JOptionPane.showMessageDialog(null,"FILL ALL.","INFO!!",JOptionPane.INFORMATION_MESSAGE);

				}
				else{
					String val1 = t6.getText();
					Connection con = null;
					String url = "jdbc:mysql://localhost:3306/";
					String db = "login";
					String driver = "com.mysql.jdbc.Driver";
					String user = "zemotacqy";
					String pass = "Zemotacqy";
					try{
						Class.forName(driver);
						con = DriverManager.getConnection(url+db,user,pass);
						PreparedStatement st = con.prepareStatement("SELECT * FROM teacher WHERE teacher_id = ?");
						st.setString(1,val1);
						ResultSet rs = st.executeQuery();
						rs.next();
						t1.setText(rs.getString(2));
						t1.setEditable(true);
						t2.setText(rs.getString(3));
						t2.setEditable(true);
						t3.setText(rs.getString(4));
						t3.setEditable(true);
						t4.setText(rs.getString(5));
						t4.setEditable(true);
						t5.setText(rs.getString(6));
						t5.setEditable(true);
						t6.setEditable(false);
						con.close();
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null,"INVALID INPUT.","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		update.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("")){
					JOptionPane.showMessageDialog(null,"FILL ALL.","INFO!!",JOptionPane.INFORMATION_MESSAGE);
				}
				else{				
					int x = JOptionPane.showConfirmDialog(f,"Confirm edit? All data will be replaced");
					if(x==0){
						String val1 = t1.getText();
						String val2 = t2.getText();
						String val3 = t3.getText();
						String val4 = t4.getText();
						String val5 = t5.getText();
						String val6 = t6.getText();
						Connection con = null;
						String url = "jdbc:mysql://localhost:3306/";
						String db = "login";
						String driver = "com.mysql.jdbc.Driver";
						String user = "zemotacqy";
						String pass = "Zemotacqy";
						try{
							Class.forName(driver);
							con = DriverManager.getConnection(url+db,user,pass);
							Statement st = con.createStatement();
							st.executeUpdate("update teacher set teacher_name='"+val1+"' , age='"+val2+"' , college='"+val3+"' , qualifications='"+val4+"' , Contact='"+val5+"' WHERE teacher_id='"+val6+"'");
							JOptionPane.showMessageDialog(null,"INFORMATION UPDATED SUCCESSFULLY.","INFO!!",JOptionPane.INFORMATION_MESSAGE);
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
		/*Edit_teacher d = new Edit_teacher();
		d.display();*/
	}
}