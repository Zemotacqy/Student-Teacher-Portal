import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.util.*;
public class Login_page{
	static JFrame f;
	JLabel l1,l2,head;
	JTextField pw;
	JTextField t1;
	JButton login,reset;
	Login_page(){
		f = new JFrame("Login Page");
		head = new JLabel("LOGIN PAGE");
		head.setBounds(200,50,100,40);
		l1 = new JLabel("Username");
		l1.setBounds(100,100,100,40);
		l2 = new JLabel("Password");
		l2.setBounds(100,175,100,40);
		t1 = new JTextField();
		t1.setBounds(250,105,150,25);
		pw = new JPasswordField();
		pw.setBounds(250,180,150,25);
		login = new JButton("LOGIN");
		login.setBounds(150,250,75,30);
		reset = new JButton("RESET");
		reset.setBounds(275,250,75,30);
		f.add(l1);
		f.add(l2);
		f.add(pw);
		f.add(t1);
		f.add(login);
		f.add(head);
		f.add(reset);
		
	
	reset.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			t1.setText(" ");
			pw.setText("");
		}
	});
	
	login.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			if(t1.getText().equals("") || pw.getText().equals("")){
					JOptionPane.showMessageDialog(null,"FILL ALL.","INFO!!",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				try{
					if(t1.getText().equals("admin") && pw.getText().equals("admin")){
						JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFULL.","INFO!!",JOptionPane.INFORMATION_MESSAGE);
						Main_form m = new Main_form();
						m.display();
						f.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"INVALID USERNAME AND PASSWORD!","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,"INVALID INPUT.","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
	});
	}
	public void display(){
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String args[]){
		Login_page l = new Login_page();
		l.display();
	}
}