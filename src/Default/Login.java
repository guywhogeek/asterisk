/*
 * Saharsh: Line 100: Login(): commented "connection = sqliteConnection.dbConnector();". Added "connection = sqliteConnection.dbConnector();" in Line 183 in lgn_button action
 * Saharsh: Line 189: clickAction() for Login. Added connection and login authentication system.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */



package Default;

import java.awt.EventQueue;
import java.security.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.io.File;
import java.awt.SystemColor;



public class Login {

	private JFrame formAsterisk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.formAsterisk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	
	/**
	 * Create the application.
	 */
	
	String filePath, originalPath, loginPassword;
	

	
	static final private String rhapsody = "e3jwA8Mfrs8CqcFNj7RfH7RV";
	static private String masterpass;
	static final String AB = "0123456789ABCDEFGHIJKLMOPQRSTUVWXYZabcdefghijklmonpqrstuvwxyz@$#";
	static SecureRandom rnd = new SecureRandom();
	private JPasswordField lng_passwd_fld;
	private JTextField pathField;
	
	String randomString(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0 ; i < len ; i++)
		{
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}
	
	
	
	public Login() {
		initialize();
		//connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private DefaultTableModel model;
	private ArrayList<Users> users; 
	private JPasswordField passfield;
	private JPasswordField confirmpass;
	private JTextField save_dest;
	private String new_file_add;
	private File created_File;
	private JPasswordField pass_input;
	private JTextField user_input;
	private JTextField web_input;
	private JTextField search_site;
	private JTextField search_user;
	private JTable table;
	private JPasswordField update_pass;
	private JTextField update_user;
	private JTextField update_web;
	private JTextField delete_site;
	private JTextField delete_user;
	private JPasswordField prevPass;
	private JPasswordField nuPass;
	private JPasswordField conNuPass;
	
	
	
	
	private void initialize() {
		formAsterisk =  new JFrame();
		formAsterisk.setResizable(false);
		formAsterisk.setType(Type.POPUP);
		formAsterisk.setFont(new Font("Rockwell", Font.PLAIN, 12));
		formAsterisk.setTitle("Asterisk* - Password Manager");
		formAsterisk.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\College\\Mini-I\\Asterisk\\Logo\\logo.png"));
		formAsterisk.getContentPane().setLocation(0, 162);
		formAsterisk.getContentPane().setBackground(Color.WHITE);
		formAsterisk.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel welcome = new JPanel();
		welcome.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(welcome, "name_1031052069408735");
		welcome.setLayout(null);
		
		JPanel login = new JPanel();
		login.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(login, "name_1031052084328624");
		login.setLayout(null);
		
		JPanel display = new JPanel();
		display.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(display, "name_1031052111462232");
		display.setLayout(null);
		
		JPanel delete = new JPanel();
		delete.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(delete, "name_1031052149777264");
		delete.setLayout(null);
		
		JPanel help = new JPanel();
		help.setBackground(new Color(0, 191, 255));		
		formAsterisk.getContentPane().add(help, "name_1478948930350");
		help.setLayout(null);
		
		JPanel changeMP = new JPanel();
		formAsterisk.getContentPane().add(changeMP, "name_4670521238724");
		changeMP.setBackground(new Color(0, 191, 255));	
		changeMP.setLayout(null);
		
		JPanel menu = new JPanel();
		formAsterisk.getContentPane().add(menu, "name_5297513390425");
		menu.setBackground(new Color(0, 191, 255));
		menu.setLayout(null);
		
		
		lng_passwd_fld = new JPasswordField();
		lng_passwd_fld.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lng_passwd_fld.setBounds(317, 438, 394, 50);
		login.add(lng_passwd_fld);
		
		
		
		JButton btnChangeMasterPassword = new JButton("Change Master Password");
		btnChangeMasterPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMP.setVisible(true);
				menu.setVisible(false);
				
			}
		});
		btnChangeMasterPassword.setForeground(Color.WHITE);
		btnChangeMasterPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnChangeMasterPassword.setBackground(new Color(255, 165, 0));
		btnChangeMasterPassword.setBounds(369, 180, 252, 55);
		menu.add(btnChangeMasterPassword);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				changeMP.setVisible(false);
			}
		});
		button_3.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\Picture2.png"));
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		button_3.setBackground(new Color(8, 204, 120));
		button_3.setBounds(10, 13, 37, 37);
		changeMP.add(button_3);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\logo2.png"));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(0, 48, 1027, 220);
		changeMP.add(label_9);
		
		JLabel lblPreviousPassword = new JLabel("Previous Password:");
		lblPreviousPassword.setForeground(Color.WHITE);
		lblPreviousPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPreviousPassword.setBounds(338, 261, 198, 34);
		changeMP.add(lblPreviousPassword);
		
		prevPass = new JPasswordField();
		prevPass.setHorizontalAlignment(SwingConstants.LEFT);
		prevPass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		prevPass.setBounds(338, 292, 344, 49);
		changeMP.add(prevPass);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewPassword.setBounds(338, 348, 198, 34);
		changeMP.add(lblNewPassword);
		
		nuPass = new JPasswordField();
		nuPass.setHorizontalAlignment(SwingConstants.LEFT);
		nuPass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		nuPass.setBounds(338, 380, 344, 49);
		changeMP.add(nuPass);
		
		
		
		
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblConfirmPassword.setBounds(338, 432, 198, 34);
		changeMP.add(lblConfirmPassword);
		
		conNuPass = new JPasswordField();
		conNuPass.setHorizontalAlignment(SwingConstants.LEFT);
		conNuPass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		conNuPass.setBounds(338, 464, 344, 49);
		changeMP.add(conNuPass);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			display.setVisible(true);
			help.setVisible(false);
			}
		});
		button_2.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\Picture2.png"));
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		button_2.setBackground(new Color(8, 204, 120));
		button_2.setBounds(12, 13, 37, 37);
		help.add(button_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\output (1).png"));
		lblNewLabel_4.setBounds(0, 63, 1027, 561);
		help.add(lblNewLabel_4);
		
		JButton lgn_bk_bnt = new JButton("");
		lgn_bk_bnt.setIcon(new ImageIcon("C:\\College\\Mini-I\\Asterisk\\Logo\\Picture2.png"));
		lgn_bk_bnt.setSelectedIcon(null);
		lgn_bk_bnt.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				pathField.setText(null);
				lng_passwd_fld.setText(null);
				welcome.setVisible(true);
				login.setVisible(false);
				masterpass = lng_passwd_fld.getText();
			}
		});
		
		lgn_bk_bnt.setForeground(Color.WHITE);
		lgn_bk_bnt.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lgn_bk_bnt.setBackground(new Color(245, 102, 23));
		lgn_bk_bnt.setBounds(10, 11, 37, 37);
		login.add(lgn_bk_bnt);
		
		
		
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "SQLite Database", "sqlite");
		fc.setFileFilter(filter);
		final JButton db_choose_btn = new JButton("Choose");
		db_choose_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				int returnVal = fc.showDialog(db_choose_btn, "Choose");
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();
					String returnAdd = file.getAbsolutePath();
					String fixAdd = returnAdd.replace("\\", "\\\\");
					pathField.setText(returnAdd);
					filePath = fixAdd;
					originalPath = returnAdd;
					 
				}
			}
		});
		db_choose_btn.setForeground(Color.WHITE);
		db_choose_btn.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		db_choose_btn.setBackground(new Color(245, 102, 23));
		db_choose_btn.setBounds(557, 332, 154, 50);
		login.add(db_choose_btn);
		

		
		
		
		pathField = new JTextField();
		pathField.setEditable(false);
		pathField.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
		pathField.setBounds(317, 332, 238, 50);
		login.add(pathField);
		JButton lgn_btn = new JButton("Login");
		lgn_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(originalPath==null){
					JOptionPane.showMessageDialog(null, "No database chosen!");
				}
				else{
					connection = sqliteConnection.dbConnector(filePath);
					
					loginPassword = lng_passwd_fld.getText();
					masterpass = loginPassword;
					
					try{
						String scrambled = Encrypt.scramble(rhapsody, loginPassword);
						JOptionPane.showMessageDialog(null,Encrypt.scramble(rhapsody, loginPassword));
						String query = "select * from whitestar where content = ?";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1,scrambled);
						ResultSet rs = pst.executeQuery();
						int hlp_int = 9;
						int count = 0;
						while(rs.next()){
							hlp_int = rs.getInt("hash");
							count++;
						}
						if(count == 1){
							
							JOptionPane.showMessageDialog(null, "Authentication Successfull");
						
							if(hlp_int == 1)
							{
								help.setVisible(true);
								String query1 = "update whitestar set hash = 0";
								PreparedStatement pst1 = connection.prepareStatement(query1);
								int rs1 = pst1.executeUpdate();
								
							}
							else
							{
								display.setVisible(true);
							}
							
							login.setVisible(false);
							
						}
						else{
							JOptionPane.showMessageDialog(formAsterisk, "Invalid password!", "Access Denied!", JOptionPane.WARNING_MESSAGE);
						}
						rs.close();
						pst.close();
					
					}catch(Exception e1){
						JOptionPane.showMessageDialog(formAsterisk, "Invalid credentials!", "Access Denied!", JOptionPane.WARNING_MESSAGE);
						JOptionPane.showMessageDialog(null, e1);
						
					}
					
					lng_passwd_fld.setText(null);
				}
			}
		});
		

		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				display.setVisible(true);
			}
		});
		button_4.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\Picture2.png"));
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		button_4.setBackground(new Color(8, 204, 120));
		button_4.setBounds(12, 13, 37, 37);
		menu.add(button_4);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnHelp.setBackground(new Color(255, 165, 0));
		btnHelp.setBounds(369, 97, 252, 55);
		menu.add(btnHelp);
		
		
		lgn_btn.setForeground(Color.WHITE);
		lgn_btn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lgn_btn.setBackground(new Color(8, 204, 120));
		lgn_btn.setBounds(435, 547, 154, 50);
		login.add(lgn_btn);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBounds(317, 403, 198, 34);
		login.add(lblNewLabel_2);
		
		JLabel lblChooseFile = new JLabel("Choose File:");
		lblChooseFile.setForeground(Color.WHITE);
		lblChooseFile.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblChooseFile.setBounds(317, 299, 198, 34);
		login.add(lblChooseFile);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\login.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 13, 1027, 229);
		login.add(label);
		
				
		JButton button_5 = new JButton("Done");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Century Gothic", Font.BOLD, 25));
		button_5.setBackground(new Color(8, 204, 120));
		button_5.setBounds(387, 534, 238, 60);
		changeMP.add(button_5);
		button_5.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(masterpass.equals(prevPass.getText()) && nuPass.getText().equals(conNuPass.getText()))
				{
					
					JOptionPane.showMessageDialog(null, "Success");
					try {
						String up = "update whitestar set content = ? ";
						PreparedStatement pst = connection.prepareStatement(up);
						pst.setString(1, Encrypt.scramble(rhapsody, nuPass.getText()));
						int rs = pst.executeUpdate();
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			}
		});
		
		
		JPanel signup = new JPanel();
		signup.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(signup, "name_1031052097970885");
		signup.setLayout(null);
		
		JPanel add = new JPanel();
		add.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(add, "name_175497036809876");
		add.setLayout(null);
		
		pass_input = new JPasswordField();
		pass_input.setHorizontalAlignment(SwingConstants.LEFT);
		pass_input.setFont(new Font("Century Gothic", Font.BOLD, 18));
		pass_input.setBounds(344, 453, 344, 49);
		add.add(pass_input);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try{
					String web = Encrypt.scramble(masterpass, web_input.getText());
					String user = Encrypt.scramble(masterpass, user_input.getText());
					String pass = Encrypt.scramble(masterpass, pass_input.getText());
					
					String query = "select * from Data where website = ? and username = ?";
					
					PreparedStatement pst1 = connection.prepareStatement(query);
					pst1.setString(1, web);
					pst1.setString(2, user);
					ResultSet rs = pst1.executeQuery();
					int count = 0;
					while(rs.next())
					{
						count++;
					}
					
					if(count == 0)
					{
					String query1 = "insert into Data (website, username, password) values (?, ?, ?)";
					PreparedStatement pst = connection.prepareStatement(query1);
					pst.setString(1, web);
					pst.setString(2, user);
					pst.setString(3, pass);
					pst.execute();
					pst.close();
					JOptionPane.showMessageDialog(formAsterisk, "Successfully Added", "Success", JOptionPane.PLAIN_MESSAGE, null);
					}
					else
					{
						JOptionPane.showMessageDialog(formAsterisk, "Username Password Combo already exist", "Failure", JOptionPane.PLAIN_MESSAGE, null);
					}
					web_input.setText(null);
					user_input.setText(null);
					pass_input.setText(null);
					pst1.close();
					rs.close();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(formAsterisk, e1, null, JOptionPane.WARNING_MESSAGE, null);
				}
				
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnRegister.setBackground(new Color(8, 204, 120));
		btnRegister.setBounds(393, 547, 238, 60);
		add.add(btnRegister);
		
		JLabel lblWebsite = new JLabel("Website:");
		lblWebsite.setForeground(Color.WHITE);
		lblWebsite.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblWebsite.setBounds(344, 255, 198, 34);
		add.add(lblWebsite);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblUsername.setBounds(344, 334, 198, 34);
		add.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPassword.setBounds(344, 418, 198, 34);
		add.add(lblPassword);
		
		user_input = new JTextField();
		user_input.setFont(new Font("Century Gothic", Font.BOLD, 18));
		user_input.setBounds(344, 370, 344, 47);
		add.add(user_input);
		user_input.setColumns(10);
		
		web_input = new JTextField();
		web_input.setFont(new Font("Century Gothic", Font.BOLD, 18));
		web_input.setColumns(10);
		web_input.setBounds(344, 285, 344, 47);
		add.add(web_input);
		
		JButton back_input = new JButton("");
		back_input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				web_input.setText(null);
				user_input.setText(null);
				pass_input.setText(null);
				display.setVisible(true);
				add.setVisible(false);
			}
		});
		back_input.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\Picture2.png"));
		back_input.setForeground(Color.WHITE);
		back_input.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		back_input.setBackground(new Color(8, 204, 120));
		back_input.setBounds(15, 16, 37, 37);
		add.add(back_input);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Mini-I\\asterisk\\Logo\\logo2.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 13, 1027, 229);
		add.add(label_1);
		
		JButton btnRandomize = new JButton("Randomize");
		btnRandomize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass_input.setText(randomString(10));
			}
		});
		btnRandomize.setForeground(Color.WHITE);
		btnRandomize.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnRandomize.setBackground(Color.LIGHT_GRAY);
		btnRandomize.setBounds(700, 453, 180, 49);
		add.add(btnRandomize);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\College\\Mini-I\\Asterisk\\Logo\\signup.png"));
		lblNewLabel_1.setBounds(0, 46, 1027, 220);
		signup.add(lblNewLabel_1);
		
		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\Picture2.png"));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passfield.setText(null);
				save_dest.setText(null);
				confirmpass.setText(null);
				welcome.setVisible(true);
				signup.setVisible(false);
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		backBtn.setBackground(new Color(8, 204, 120));
		backBtn.setBounds(10, 11, 37, 37);
		signup.add(backBtn);
		
		JLabel databasename = new JLabel("Database Save Location:");
		databasename.setForeground(Color.WHITE);
		databasename.setFont(new Font("Century Gothic", Font.BOLD, 16));
		databasename.setBounds(338, 249, 198, 34);
		signup.add(databasename);
		
		JLabel password = new JLabel("Password:");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Century Gothic", Font.BOLD, 16));
		password.setBounds(338, 333, 198, 34);
		signup.add(password);
		
		JLabel confirmpassword = new JLabel("Confirm Password:");
		confirmpassword.setForeground(Color.WHITE);
		confirmpassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		confirmpassword.setBounds(338, 415, 198, 34);
		signup.add(confirmpassword);
		
		passfield = new JPasswordField();
		passfield.setFont(new Font("Century Gothic", Font.BOLD, 18));
		passfield.setHorizontalAlignment(SwingConstants.LEFT);
		passfield.setBounds(338, 364, 344, 49);
		signup.add(passfield);
		
		confirmpass = new JPasswordField();
		confirmpass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		confirmpass.setHorizontalAlignment(SwingConstants.LEFT);
		confirmpass.setBounds(338, 447, 344, 49);
		signup.add(confirmpass);

		final JFileChooser filesave = new JFileChooser();
		filesave.setDialogTitle("Specify a file to save"); 
		FileNameExtensionFilter savefilter = new FileNameExtensionFilter("SQLite Database", "sqlite");
		filesave.setFileFilter(savefilter);
		JButton btn_save_db = new JButton("Choose");
		btn_save_db.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = filesave.showSaveDialog(btn_save_db);
				
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File file = filesave.getSelectedFile();
					new_file_add = file.getAbsolutePath();
					String dblocation = new_file_add+".sqlite";
					save_dest.setText(dblocation);
					filePath=dblocation;
					created_File = new File(new_file_add + ".sqlite");
				}
			}
		});
		btn_save_db.setForeground(Color.WHITE);
		btn_save_db.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		btn_save_db.setBackground(new Color(245, 102, 23));
		btn_save_db.setBounds(552, 283, 130, 50);
		signup.add(btn_save_db);
		
		save_dest = new JTextField();
		save_dest.setEditable(false);
		save_dest.setFont(new Font("Century Gothic", Font.BOLD, 18));
		save_dest.setBounds(338, 284, 213, 49);
		signup.add(save_dest);
		save_dest.setColumns(10);
		
		JButton signupBtn = new JButton("Done");
		signupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passwordField = passfield.getText();
				String confirmPassword = confirmpass.getText();
				
				if(!passwordField.contains(" ")&&!confirmPassword.equals(null)&&!passwordField.equals(null)&&passwordField.equals(confirmPassword)&&passwordField.length()>=8){
					try {
						created_File.createNewFile();
						JOptionPane.showMessageDialog(null, "Database successfully created!");
						connection = sqliteConnection.dbConnector(filePath); 
						String UD = "Data";
						String query = "CREATE TABLE IF NOT EXISTS " + UD + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, website string, username string, password string)";
						Statement st = connection.createStatement();
						st.execute(query);
						
						String WS = "whitestar";
						String query1 = "CREATE TABLE IF NOT EXISTS " + WS + "(hash INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content VARCHAR)";
						Statement st1 = connection.createStatement();
						st1.execute(query1);
						String scrambledText = Encrypt.scramble(rhapsody, passwordField);
						String query2 = "insert into " + WS + "('content') values ('" + scrambledText + "')";
						PreparedStatement pst2 = connection.prepareStatement(query2);
						pst2.execute();
						passfield.setText(null);
						save_dest.setText(null);
						confirmpass.setText(null);
						welcome.setVisible(true);
						signup.setVisible(false);
						st.close();
						pst2.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					if(passwordField.equals("")||confirmPassword.equals(""))
						JOptionPane.showMessageDialog(null, "Password field can't be empty");
					else if(passwordField.length()<8)
						JOptionPane.showMessageDialog(null, "Password length should be more than 8");
					else if(passwordField.contains(" "))
						JOptionPane.showMessageDialog(null, "No spaces are allowed in password");
				}
			}
		});
		signupBtn.setForeground(Color.WHITE);
		signupBtn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		signupBtn.setBackground(new Color(8, 204, 120));
		signupBtn.setBounds(387, 524, 238, 60);
		signup.add(signupBtn);

		
		
		JButton disp_bk_btn = new JButton("");
		disp_bk_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display.setVisible(false);
				welcome.setVisible(true);
			}
		});
		disp_bk_btn.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\Picture2.png"));
		disp_bk_btn.setForeground(Color.WHITE);
		disp_bk_btn.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		disp_bk_btn.setBackground(new Color(8, 204, 120));
		disp_bk_btn.setBounds(15, 16, 37, 37);
		display.add(disp_bk_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 205, 1003, 363);
		display.add(scrollPane);
		
        
       
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//JScrollPane pane = new JScrollPane(table);
		
		
		
		JButton refresh = new JButton("Refresh");
		refresh.setBackground(new Color(255, 165, 0));
		refresh.setForeground(new Color(255, 255, 255));
		refresh.setFont(new Font("Century Gothic", Font.BOLD, 16));
		refresh.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try{
					users = new ArrayList<Users>();
				       
				       try {
				           
				    	   String q = "SELECT * FROM Data";
				           PreparedStatement pst1 = connection.prepareStatement(q);
				           ResultSet rs1 = pst1.executeQuery();
				           int k = 1;
				           while(rs1.next()){
				               
				               Users u = new Users(
				                       k,
				                       rs1.getString("website"),
				                       rs1.getString("username"),
				                       rs1.getString("password")
				               );
				               
				               users.add(u);
				               k++;
				           }
				           
				           model = new DefaultTableModel();
				           
				           Object[] columnsName = new Object[4];
				           
				           columnsName[0] = "Id";
				           columnsName[1] = "Website";
				           columnsName[2] = "UserName";
				           columnsName[3] = "Password";
				           
				           model.setColumnIdentifiers(columnsName);
				           
				           Object[] rowData = new Object[4];
				           
				           for(int i = 0; i < users.size(); i++){
				               
				               rowData[0] = users.get(i).getId();
				                rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
				                 rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
				                  rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
				                  
				                  model.addRow(rowData);
				           }
				           rs1.close();
				           pst1.close();
				            
				       } catch (SQLException ex) {
				           JOptionPane.showMessageDialog(null, ex);
				       }
					 
					table.setModel(model);
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					table.show(true);
					
					
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(formAsterisk, e2);
				}
				search_site.setText(null);
				search_user.setText(null);
			}
		});
		refresh.setBounds(918, 16, 97, 37);
		display.add(refresh);
		
		
		
		
		
		JButton addInfo = new JButton("Add Data");
		addInfo.setBackground(new Color(102, 204, 102));
		addInfo.setForeground(new Color(255, 255, 255));
		addInfo.setFont(new Font("Century Gothic", Font.BOLD, 16));
		addInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_site.setText(null);
				search_user.setText(null);
				add.setVisible(true);
				display.setVisible(false);
			}
		});
		addInfo.setBounds(15, 581, 110, 37);
		display.add(addInfo);
		
		search_site = new JTextField();
		search_site.setBackground(new Color(255, 255, 255));
		search_site.setFont(new Font("Century Gothic", Font.BOLD, 16));
		search_site.setBounds(465, 107, 203, 37);
		display.add(search_site);
		search_site.setColumns(10);
		
		search_user = new JTextField();
		search_user.setBackground(new Color(255, 255, 255));
		search_user.setFont(new Font("Century Gothic", Font.BOLD, 16));
		search_user.setColumns(10);
		search_user.setBounds(465, 157, 203, 37);
		display.add(search_user);
		
		JButton site_search = new JButton("Site");
		site_search.setBackground(new Color(106, 90, 205));
		site_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				model.setRowCount(0);
				users = new ArrayList<Users>();
			       
			       try {
			           
			    	   String q = "SELECT * FROM Data where website = ?";
			           PreparedStatement pst1 = connection.prepareStatement(q);
			           pst1.setString(1, Encrypt.scramble(masterpass, search_site.getText().toString()));
			           ResultSet rs1 = pst1.executeQuery();
			           int k = 1;
			           while(rs1.next()){
			               
			               Users u = new Users(
			                       k,
			                       rs1.getString("website"),
			                       rs1.getString("username"),
			                       rs1.getString("password")
			               );
			               
			               users.add(u);
			               k++;
			           }
			           
			         
			           
			           Object[] columnsName = new Object[4];
			           
			           columnsName[0] = "Id";
			           columnsName[1] = "Website";
			           columnsName[2] = "UserName";
			           columnsName[3] = "Password";
			           
			           model.setColumnIdentifiers(columnsName);
			           
			           Object[] rowData = new Object[4];
			           
			           for(int i = 0; i < users.size(); i++){
			               
			               rowData[0] = users.get(i).getId();
			                rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
			                 rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
			                  rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
			                  
			                  model.addRow(rowData);
			           }
			           pst1.close();
			            
			       } catch (SQLException ex) {
			           JOptionPane.showMessageDialog(null, ex);
			       }
			       search_user.setText(null);
			
				
		}});
		site_search.setForeground(new Color(255, 255, 255));
		site_search.setFont(new Font("Century Gothic", Font.BOLD, 16));
		site_search.setBounds(360, 107, 97, 37);
		display.add(site_search);
		
		JButton user_search = new JButton("User");
		user_search.setBackground(new Color(106, 90, 205));
		user_search.setForeground(new Color(255, 255, 255));
		user_search.setFont(new Font("Century Gothic", Font.BOLD, 16));
		user_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				users = new ArrayList<Users>();
			       
			       try {
			           
			    	   String q = "SELECT * FROM Data where username = ?";
			           PreparedStatement pst1 = connection.prepareStatement(q);
			           pst1.setString(1, Encrypt.scramble(masterpass, search_user.getText().toString()));
			           ResultSet rs1 = pst1.executeQuery();
			           int k = 1;
			           while(rs1.next()){
			               
			               Users u = new Users(
			                       k,
			                       rs1.getString("website"),
			                       rs1.getString("username"),
			                       rs1.getString("password")
			               );
			               
			               users.add(u);
			               k++;
			           }
			           
			         
			           
			           Object[] columnsName = new Object[4];
			           
			           columnsName[0] = "Id";
			           columnsName[1] = "Website";
			           columnsName[2] = "UserName";
			           columnsName[3] = "Password";
			           
			           model.setColumnIdentifiers(columnsName);
			           
			           Object[] rowData = new Object[4];
			           
			           for(int i = 0; i < users.size(); i++){
			               
			               rowData[0] = users.get(i).getId();
			                rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
			                 rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
			                  rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
			                  
			                  model.addRow(rowData);
			           }
			            
			       } catch (SQLException ex) {
			           JOptionPane.showMessageDialog(null, ex);
			}
			       search_site.setText(null);
		}});
		user_search.setBounds(360, 157, 97, 37);
		display.add(user_search);
		
		JButton btnDeleteData = new JButton("Delete Data");
		btnDeleteData.setBackground(new Color(255, 102, 51));
		btnDeleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_site.setText(null);
				search_user.setText(null);
				display.setVisible(false);
				delete.setVisible(true);
			}
		});
		btnDeleteData.setForeground(new Color(255, 255, 255));
		btnDeleteData.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnDeleteData.setBounds(886, 581, 129, 37);
		display.add(btnDeleteData);
		
		JLabel lblSearchDataBy = new JLabel("Search Data By:");
		lblSearchDataBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchDataBy.setForeground(Color.WHITE);
		lblSearchDataBy.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblSearchDataBy.setBounds(413, 69, 198, 34);
		display.add(lblSearchDataBy);
		
		JPanel update = new JPanel();
		update.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(update, "name_1031052123407705");
		update.setLayout(null);
		
		update_pass = new JPasswordField();
		update_pass.setHorizontalAlignment(SwingConstants.LEFT);
		update_pass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		update_pass.setBounds(344, 440, 344, 49);
		update.add(update_pass);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try{
					String site = Encrypt.scramble(masterpass, update_web.getText().toString());
					String user = Encrypt.scramble(masterpass, update_user.getText().toString());
					String pass = Encrypt.scramble(masterpass, update_pass.getText());
				
					String query = "select * from Data WHERE website= ? and username= ?";
					PreparedStatement pst1 = connection.prepareStatement(query);
					pst1.setString(1, site);
					pst1.setString(2, user);
					ResultSet rs = pst1.executeQuery();
					
					int count = 0;
					
					while(rs.next())
					{
						count++;
					}
					
					if(count == 1){
					
					
						try{
							
						String q = "UPDATE Data SET password= ? WHERE website= ? and username= ?";
						PreparedStatement pst = connection.prepareStatement(q);
						pst.setString(1, pass);
						pst.setString(2, site);
						pst.setString(3, user);
						pst.execute();
						
					
						JOptionPane.showMessageDialog(formAsterisk, "Update Successfull");
						update_web.setText(null);
						update_user.setText(null);
						update_pass.setText(null);
						
						pst.close();
						}
						catch(Exception e2)
						{
							JOptionPane.showMessageDialog(formAsterisk, e2);
						}
						
	
					
					}
					else
					{
						JOptionPane.showMessageDialog(formAsterisk, "Website or Password Does not Exist!!");
					}
					
					pst1.close();
					rs.close();
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnUpdate.setBackground(new Color(8, 204, 120));
		btnUpdate.setBounds(395, 536, 238, 60);
		update.add(btnUpdate);
		
		JLabel label_2 = new JLabel("Website:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_2.setBounds(344, 242, 198, 34);
		update.add(label_2);
		
		JLabel label_3 = new JLabel("Username:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_3.setBounds(344, 321, 198, 34);
		update.add(label_3);
		
		JLabel label_4 = new JLabel("Password:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_4.setBounds(344, 405, 198, 34);
		update.add(label_4);
		
		update_user = new JTextField();
		update_user.setFont(new Font("Century Gothic", Font.BOLD, 18));
		update_user.setColumns(10);
		update_user.setBounds(344, 357, 344, 47);
		update.add(update_user);
		
		update_web = new JTextField();
		update_web.setFont(new Font("Century Gothic", Font.BOLD, 18));
		update_web.setColumns(10);
		update_web.setBounds(344, 272, 344, 47);
		update.add(update_web);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update.setVisible(false);
				display.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Mini-I\\asterisk\\Logo\\Picture2.png"));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		button_1.setBackground(new Color(8, 204, 120));
		button_1.setBounds(12, 13, 37, 37);
		update.add(button_1);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Mini-I\\asterisk\\Logo\\logo2.png"));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 13, 1027, 229);
		update.add(label_5);
		
		JButton btnUpdateData = new JButton("Update Data");
		btnUpdateData.setBackground(SystemColor.activeCaption);
		btnUpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search_site.setText(null);
				search_user.setText(null);
				update.setVisible(true);
				display.setVisible(false);
			}
		});
		btnUpdateData.setForeground(new Color(255, 255, 255));
		btnUpdateData.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnUpdateData.setBounds(444, 581, 151, 37);
		display.add(btnUpdateData);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\Capture.PNG"));
		lblNewLabel_3.setBounds(245, 13, 542, 55);
		display.add(lblNewLabel_3);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setVisible(false);
				menu.setVisible(true);
			}
			
		});
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnMenu.setBackground(new Color(255, 165, 0));
		btnMenu.setBounds(918, 66, 97, 37);
		display.add(btnMenu);
		
		
		
		
		
		JLabel label_6 = new JLabel("Website:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_6.setBounds(344, 255, 198, 34);
		delete.add(label_6);
		
		delete_site = new JTextField();
		delete_site.setFont(new Font("Century Gothic", Font.BOLD, 18));
		delete_site.setColumns(10);
		delete_site.setBounds(344, 285, 344, 47);
		delete.add(delete_site);
		
		JLabel label_7 = new JLabel("Username:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_7.setBounds(344, 334, 198, 34);
		delete.add(label_7);
		
		delete_user = new JTextField();
		delete_user.setFont(new Font("Century Gothic", Font.BOLD, 18));
		delete_user.setColumns(10);
		delete_user.setBounds(344, 370, 344, 47);
		delete.add(delete_user);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display.setVisible(true);
				delete.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("C:\\Mini-I\\asterisk\\Logo\\Picture2.png"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		button.setBackground(new Color(8, 204, 120));
		button.setBounds(15, 16, 37, 37);
		delete.add(button);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					String site = Encrypt.scramble(masterpass, delete_site.getText().toString());
					String user = Encrypt.scramble(masterpass, delete_user.getText().toString());
					
					
					
					String q = "select * FROM Data WHERE website = ? AND username = ?";
					PreparedStatement pst = connection.prepareStatement(q);
					pst.setString(1, site);
					pst.setString(2, user);
					ResultSet rs = pst.executeQuery();
					int  count = 0;
					while(rs.next())
					{
						count++;
					}
						if(count == 1)
						{
							String query = "delete FROM Data WHERE website = ? AND username = ?";
							PreparedStatement pst1 = connection.prepareStatement(query);
							pst1.setString(1, site);
							pst1.setString(2, user);
							pst1.execute();
							pst1.close();
							
							JOptionPane.showMessageDialog(formAsterisk, "Successfully Data Deleted From " + delete_site.getText() + " " + delete_user.getText(), "Operation Successful", JOptionPane.PLAIN_MESSAGE, null);
						}
						else
						{
							JOptionPane.showMessageDialog(formAsterisk, "Website or Username Does not exist" , "Failure", JOptionPane.PLAIN_MESSAGE, null);
						}
					
						pst.close();
						rs.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(formAsterisk, "Website or Username Does not exist" , "Failure", JOptionPane.PLAIN_MESSAGE, null);
				}
				delete_site.setText(null);
				delete_user.setText(null);
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnDelete.setBackground(new Color(8, 204, 120));
		btnDelete.setBounds(396, 478, 238, 60);
		delete.add(btnDelete);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\Mini-I\\asterisk\\Logo\\logo2.png"));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 13, 1027, 229);
		delete.add(label_8);
		formAsterisk.setBounds(0, 64, 1033, 666);
		formAsterisk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 13, 1027, 229);
		lblNewLabel.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\logo2.png"));
		welcome.add(lblNewLabel);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setForeground(new Color(255, 255, 255));
		loginBtn.setBackground(new Color(8, 204, 120));
		loginBtn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login.setVisible(true);
				welcome.setVisible(false);
			}
		});
		loginBtn.setBounds(186, 337, 238, 60);
		welcome.add(loginBtn);
		
		JButton createBtn = new JButton("Create");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signup.setVisible(true);
				welcome.setVisible(false);
			}
		});
		createBtn.setForeground(new Color(255, 255, 255));
		createBtn.setBackground(new Color(255, 192, 0));
		createBtn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		createBtn.setBounds(603, 337, 238, 60);
		welcome.add(createBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setIcon(null);
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitBtn.setForeground(new Color(255, 255, 255));
		exitBtn.setBackground(new Color(245, 102, 23));
		exitBtn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		exitBtn.setBounds(394, 497, 238, 60);
		welcome.add(exitBtn);
		
		
		
		
		
		
				
	}
}
