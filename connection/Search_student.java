/*CREATE TABLE `student`(
	`student_id` int(10) NOT NULL ,
	`student_name` varchar(100) DEFAULT NULL , 
	`age` int(10) DEFAULT NULL , 
	`course` varchar(100) DEFAULT NULL , 
	`college` varchar(100) DEFAULT NULL ,
	`contact` int(10) DEFAULT NULL ,
	PRIMARY KEY(`student_id`)
	)*/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Search_student
{
	JFrame f,f1;
	JLabel l1,l2;
	JTextField t1;
	JButton b1,b2;
	static JTable table;
	String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/login";
		String user = "zemotacqy";
		String pass = "Zemotacqy";
	String[] column_names = {"Student id","Student name","Age","Course","College","Contact No."};
	Search_student(){
		f = new JFrame("Search Information");
		l1 = new JLabel("Search Information");
		l1.setBounds(200,60,150,50);
		l2 = new JLabel("Student ID");
		l2.setBounds(100,150,150,50);
		t1 = new JTextField();
		t1.setBounds(250,155,150,35);
		b1 = new JButton("SEARCH");
		b1.setBounds(120,250,100,40);
		b2 = new JButton("RESET");
		b2.setBounds(270,250,100,40);
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(b1);
		f.add(b2);
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(t1.getText().equals("")){
					JOptionPane.showMessageDialog(null,"FILL ALL.","INFO!!",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					result();
				}
			}
		});
		
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				t1.setText("");
			}
		});
	}
	public void result(){
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
		
		String text = t1.getText();
		String val1 = "";
		String val2 = "";
		String val3 = "";
		String val4 = "";
		String val5 = "";
		String val6 = "";
		
		
		try{
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			String sql = "select * from student where student_id = "+text;
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			int i=0;
			
			if(rs.next()){
				val1 = rs.getString("student_id");
				val2 = rs.getString("student_name");
				val3 = rs.getString("age");
				val4 = rs.getString("course");
				val5 = rs.getString("college");
				val6 = rs.getString("contact");
				model.addRow(new Object[] {val1,val2,val3,val4,val5,val6});
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
	public void display(){
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setSize(500,500);
		f.setResizable(true);
		f.setVisible(true);
	}
	public static void main(String args[]){
		/*Search_student a = new Search_student();
		a.display();*/
	}
}