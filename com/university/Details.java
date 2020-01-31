package com.university;

import java.awt.EventQueue;
import javax.swing.*;

public class Details {

  public JFrame frame;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextArea textArea;
  JLabel lblCurrentlyLoggedIn;
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        Details window = new Details();
        window.frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the application.
   */
  public Details() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 451, 517);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JLabel lblName = new JLabel("Name");
    lblName.setBounds(81, 84, 88, 23);
    frame.getContentPane().add(lblName);

    textField = new JTextField();
    textField.setBounds(206, 86, 96, 19);
    frame.getContentPane().add(textField);
    textField.setColumns(10);

    JLabel lblAge = new JLabel("Age");
    lblAge.setBounds(81, 138, 46, 13);
    frame.getContentPane().add(lblAge);

    textField_1 = new JTextField();
    textField_1.setBounds(206, 135, 96, 19);
    frame.getContentPane().add(textField_1);
    textField_1.setColumns(10);

    JLabel lblProfile = new JLabel("Profile");
    lblProfile.setBounds(81, 191, 46, 13);
    frame.getContentPane().add(lblProfile);

    textField_2 = new JTextField();
    textField_2.setBounds(206, 185, 96, 19);
    frame.getContentPane().add(textField_2);
    textField_2.setColumns(10);

    JLabel lblUniversityManagementSystem = new JLabel("University Management System");
    lblUniversityManagementSystem.setBounds(81, 10, 203, 23);
    frame.getContentPane().add(lblUniversityManagementSystem);

    JLabel lblRegisteredCourseUnits = new JLabel("You have successfully registered to these");
    lblRegisteredCourseUnits.setBounds(99, 234, 259, 29);
    frame.getContentPane().add(lblRegisteredCourseUnits);

    JLabel lblCourseUnits = new JLabel("course units");
    lblCourseUnits.setBounds(173, 259, 102, 23);
    frame.getContentPane().add(lblCourseUnits);

    textArea = new JTextArea();
    textArea.setColumns(1);
    textArea.setRows(3);
    textArea.setBounds(81, 284, 248, 52);
    frame.getContentPane().add(textArea);

    JButton btnSignOut = new JButton("Sign out");
    btnSignOut.setBounds(173, 367, 85, 21);
    btnSignOut.addActionListener(e -> {this.frame.dispose();Login login=new Login();login.frame.setVisible(true);});
    frame.getContentPane().add(btnSignOut);

    lblCurrentlyLoggedIn = new JLabel("Currently logged in as ");
    lblCurrentlyLoggedIn.setBounds(81, 43, 317, 19);
    frame.getContentPane().add(lblCurrentlyLoggedIn);
  }

  public void valueSetter(String [] string){
    textField.setText(string[0]);
    textField_1.setText(string[1]);
    textField_2.setText(string[2]);
    textArea.setText(string[3]);
    lblCurrentlyLoggedIn.setText("Currently logged in as "+string[4]);
  }
}
