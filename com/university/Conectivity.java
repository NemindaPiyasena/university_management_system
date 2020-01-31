package com.university;

import javax.swing.*;
import java.sql.*;

public abstract class Conectivity {
  protected Connection conn;

  public Conectivity() {
    try {
      conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/university_management_system","root","sesame");
    }catch(Exception e) {
      System.err.println("Connection failed : There is an error in the system");
      JOptionPane.showMessageDialog(null,"There was an error in the system");
    }
  }

  public abstract void insert() ;

  public abstract void retrieve();

}
