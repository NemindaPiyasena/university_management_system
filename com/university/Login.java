package com.university;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class Login {

  protected static int detail=0;
  public JFrame frame;
  private JTextField textField;
  private JPasswordField passwordField;
  private Person person=new Person();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Login window = new Login();
          window.frame.setVisible(true);
          window.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Login() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JLabel lblName = new JLabel("Username");
    lblName.setBounds(69, 54, 69, 24);
    frame.getContentPane().add(lblName);

    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(69, 103, 69, 23);
    frame.getContentPane().add(lblPassword);

    JLabel lblSelectYourProfile = new JLabel("Select your profile");
    lblSelectYourProfile.setBounds(69, 146, 99, 20);
    frame.getContentPane().add(lblSelectYourProfile);

    JLabel lblLoginForm = new JLabel("Login Form");
    lblLoginForm.setBounds(174, 21, 90, 13);
    frame.getContentPane().add(lblLoginForm);

    textField = new JTextField();
    textField.addActionListener(e ->  {person.setUserName(textField.getText());passwordField.requestFocus();});
    textField.setBounds(174, 56, 109, 21);
    frame.getContentPane().add(textField);
    textField.setColumns(10);

    passwordField = new JPasswordField();
    passwordField.addActionListener(e ->  person.setPassWord(passwordField.getText()));
    passwordField.setBounds(174, 104, 109, 21);
    frame.getContentPane().add(passwordField);

    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(e -> this.frame.dispose());
    btnCancel.setBounds(120, 189, 85, 21);
    frame.getContentPane().add(btnCancel);

    JButton btnLogin = new JButton("Login");
    btnLogin.addActionListener(e -> {person.retrieve();if(this.detail==1) this.frame.dispose();});
    btnLogin.setBounds(230, 189, 85, 21);
    frame.getContentPane().add(btnLogin);

    JLabel lblClickToRegister = new JLabel("Click to register");
    lblClickToRegister.addMouseListener((MousePressListener) e -> {this.frame.dispose();Registeration registeration =new Registeration();registeration.frame.setVisible(true);});
    lblClickToRegister.setBounds(174, 220, 109, 13);
    frame.getContentPane().add(lblClickToRegister);

    JComboBox comboBox = new JComboBox();
    comboBox.addActionListener(e -> person.setType(comboBox.getSelectedItem().toString()));
    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Lecturer"}));
    comboBox.setBounds(174, 146, 109, 21);
    frame.getContentPane().add(comboBox);

    JRadioButton rdbtnShowPassword = new JRadioButton("show password");
    rdbtnShowPassword.addActionListener(e -> {
      if(rdbtnShowPassword.isSelected())
        passwordField.setEchoChar((char)0);
      else
        passwordField.setEchoChar('*');
    });
    rdbtnShowPassword.setBounds(289, 104, 141, 24);
    frame.getContentPane().add(rdbtnShowPassword);

  }

}
