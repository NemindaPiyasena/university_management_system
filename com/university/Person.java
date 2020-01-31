package com.university;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Person extends Conectivity {
  private String userName;
  private String passWord;
  private String name;
  private int age;
  private  String type;
  private int [] reeg={0,0,0};

  public Person() {

    super();

  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setReeg(int index,int value){
    this.reeg[index]=value;
  }

  @Override
  public void retrieve(){

    String retrieval_query="SELECT * FROM "+type+ " WHERE User_name='"+userName+"' AND Password='"+passWord+"'";
    //System.out.println(retrieval_query);
    try {
      Statement st=conn.createStatement();
      ResultSet rs=st.executeQuery(retrieval_query);
      if(rs.next()) {
        Login.detail=1;
        String [] string=new String[5];
        string[0]=rs.getString("Name");
        string[1]=Integer.toString(rs.getInt("Age"));
        string[2]=this.type;
        string[4]=rs.getString("User_Name");
        System.out.println("Connection success : You have registered to these course units successfully");
        if(rs.getInt("SENG_11111")!=0) {
          System.out.println("SENG 11111 - object oriented programming");
          string[3] = "SENG 11111 - Object oriented programming\n";
        }
        if(rs.getInt("SENG_11112")!=0) {
          System.out.println("SENG 11112 - Introduction to database");
          string[3] += "SENG 11112 - Introduction to database\n";
        }
        if(rs.getInt("SENG_11113")!=0) {
          System.out.println("SENG 11123 - Project management");
          string[3] += "SENG 11123 - Project management\n";
        }
        Details details=new Details();
        details.frame.setVisible(true);
        details.valueSetter(string);
      }
      else {
        System.err.println("Connection failed : The username and the password deos not match");
        JOptionPane.showMessageDialog(null,"The username and the password deos not match");
      }
    }catch(Exception e) {
      System.err.println("Connection failed ");
      JOptionPane.showMessageDialog(null,"There was an error in the system");
    }

  }

  @Override
  public void insert(){
    String insertion_query="INSERT INTO "+type+"(Name,User_Name,Password,Age,SENG_11111,SENG_11112,SENG_11113) VALUES(\""+name+"\",\""+userName+"\",\""+passWord+"\","+age+","+reeg[0]+","+reeg[1]+","+reeg[2]+")";
   // System.out.println(insertion_query);
    try {
      PreparedStatement s=conn.prepareStatement(insertion_query);
      s.execute();
      JOptionPane.showMessageDialog(null,"Connection success : You have registered to the course unit successfully");
    }catch(Exception e) {
      System.err.println("Connection failed : There is an error in the system");
      JOptionPane.showMessageDialog(null,"There was an error in the system");
    }
  }

}
