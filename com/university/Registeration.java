package com.university;

import java.awt.EventQueue;
import javax.swing.*;

public class Registeration {

  public JFrame frame;
  private JTextField textField;
  private JTextField textField_1;
  private JPasswordField passwordField_1;
  private JPasswordField passwordField_2;
  private JTextField textField_2;
  private JTextField textField_3;
  private Person person=new Person();
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Registeration window = new Registeration();
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
  public Registeration() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 467, 621);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JLabel lblNewLabel = new JLabel("First Name");
    lblNewLabel.setBounds(61, 97, 70, 13);
    frame.getContentPane().add(lblNewLabel);

    JLabel lblLastName = new JLabel("Last Name");
    lblLastName.setBounds(61, 135, 70, 13);
    frame.getContentPane().add(lblLastName);

    JLabel lblNewLabel_1 = new JLabel("User Name");
    lblNewLabel_1.setBounds(61, 170, 85, 18);
    frame.getContentPane().add(lblNewLabel_1);

    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(61, 212, 70, 13);
    frame.getContentPane().add(lblPassword);

    JLabel lblNewLabel_2 = new JLabel("Retype pass :");
    lblNewLabel_2.setBounds(61, 252, 85, 18);
    frame.getContentPane().add(lblNewLabel_2);

    JLabel lblNewLabel_3 = new JLabel("New label");
    lblNewLabel_3.setBounds(75, 240, -14, 13);
    frame.getContentPane().add(lblNewLabel_3);

    JLabel lblAge = new JLabel("Age");
    lblAge.setBounds(61, 293, 70, 13);
    frame.getContentPane().add(lblAge);

    textField = new JTextField();
    textField.addActionListener(e -> {person.setName(textField.getText());textField_1.requestFocus();});
    textField.setBounds(178, 94, 96, 19);
    frame.getContentPane().add(textField);
    textField.setColumns(10);

    textField_1 = new JTextField();
    textField_1.addActionListener(e -> {person.setName(textField.getText()+" "+textField_1.getText());textField_2.requestFocus();});
    textField_1.setBounds(178, 132, 96, 19);
    frame.getContentPane().add(textField_1);
    textField_1.setColumns(10);

    passwordField_1 = new JPasswordField();
    passwordField_1.addActionListener(e -> {person.setPassWord(passwordField_1.getText());passwordField_2.requestFocus();});
    passwordField_1.setBounds(178, 209, 96, 19);
    frame.getContentPane().add(passwordField_1);

    passwordField_2 = new JPasswordField();
    passwordField_2.addActionListener(e -> {if(!passwordField_1.getText().equals(passwordField_2.getText())) JOptionPane.showMessageDialog(frame,"The passwords don't match");else textField_3.requestFocus();});
    passwordField_2.setBounds(178, 252, 96, 19);
    frame.getContentPane().add(passwordField_2);

    textField_2 = new JTextField();
    textField_2.addActionListener(e -> {person.setUserName(textField_2.getText());passwordField_1.requestFocus();});
    textField_2.setBounds(178, 170, 96, 19);
    frame.getContentPane().add(textField_2);
    textField_2.setColumns(10);

    textField_3 = new JTextField();
    textField_3.addActionListener(e -> person.setAge(Integer.parseInt(textField_3.getText())));
    textField_3.setBounds(178, 290, 96, 19);
    frame.getContentPane().add(textField_3);
    textField_3.setColumns(10);

    JButton btnCan = new JButton("Cancel");
    btnCan.addActionListener(e -> this.frame.dispose());
    btnCan.setBounds(98, 464, 85, 24);
    frame.getContentPane().add(btnCan);

    JButton btnRegister = new JButton("Register");
    btnRegister.addActionListener(e ->person.insert());
    btnRegister.setBounds(255, 464, 85, 25);
    frame.getContentPane().add(btnRegister);

    JLabel lblClickToLogin = new JLabel("Click to login");
    lblClickToLogin.addMouseListener ( (MousePressListener) e -> {System.out.println();this.frame.dispose();Login login=new Login();login.frame.setVisible(true);} );
    lblClickToLogin.setBounds(178, 507, 96, 13);
    frame.getContentPane().add(lblClickToLogin);

    JRadioButton rdbtnShowPassword = new JRadioButton("show password");
    rdbtnShowPassword.addActionListener(e -> {
      if(rdbtnShowPassword.isSelected())
        passwordField_1.setEchoChar((char)0);
      else
        passwordField_1.setEchoChar('*');
    });
    rdbtnShowPassword.setBounds(297, 208, 148, 20);
    frame.getContentPane().add(rdbtnShowPassword);

    JList list = new JList();
    list.setBounds(321, 233, 44, -24);
    frame.getContentPane().add(list);

    JComboBox comboBox = new JComboBox();
    comboBox.addActionListener(e -> person.setType(comboBox.getSelectedItem().toString()));
    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Lecturer"}));
    comboBox.setBounds(178, 334, 96, 24);
    frame.getContentPane().add(comboBox);

    JLabel lblSelctYourProfile = new JLabel("Selct your profile");
    lblSelctYourProfile.setBounds(61, 336, 107, 13);
    frame.getContentPane().add(lblSelctYourProfile);

    JLabel lblRegisterationForm = new JLabel("Registeration Form");
    lblRegisterationForm.setBounds(178, 25, 124, 37);
    frame.getContentPane().add(lblRegisterationForm);

    JCheckBox chckbxSengjhgfdsdfghj = new JCheckBox("SENG-12323-jhgfdsdfghj");
    chckbxSengjhgfdsdfghj.addActionListener(e -> {
      if(chckbxSengjhgfdsdfghj.isSelected())
        person.setReeg(0,1);
      else
        person.setReeg(0,0);
    });
    chckbxSengjhgfdsdfghj.setBounds(178, 377, 161, 18);
    frame.getContentPane().add(chckbxSengjhgfdsdfghj);

    JCheckBox chckbxSengwefghgfdsdfgh = new JCheckBox("SENG-12345-wefghgfdsdfgh");
    chckbxSengwefghgfdsdfgh.addActionListener(e -> {
      if(chckbxSengwefghgfdsdfgh.isSelected())
        person.setReeg(1,1);
      else
        person.setReeg(1,0);
    });
    chckbxSengwefghgfdsdfgh.setBounds(178, 399, 172, 18);
    frame.getContentPane().add(chckbxSengwefghgfdsdfgh);

    JCheckBox chckbxSengsdfghj = new JCheckBox("SENG-34567-sdfghj");
    chckbxSengsdfghj.addActionListener(e -> {
      if(chckbxSengsdfghj.isSelected())
        person.setReeg(2,1);
      else
        person.setReeg(2,0);
    });
    chckbxSengsdfghj.setBounds(178, 421, 148, 18);
    frame.getContentPane().add(chckbxSengsdfghj);

    JLabel lblSelectYourCourses = new JLabel("Select your courses");
    lblSelectYourCourses.setBounds(61, 391, 107, 34);
    frame.getContentPane().add(lblSelectYourCourses);
  }

}
