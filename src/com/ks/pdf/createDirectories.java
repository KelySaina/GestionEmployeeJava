/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ks.pdf;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
/**
 *
 * @author thyler
 */
public class createDirectories {
  
    public createDirectories(){
        
    }
    
    public void create(String path){
    try {
      File myObj = new File(path);
      if (myObj.mkdir()) {
        //System.out.println("Directory created: " + myObj.getName());
      } else {
        //System.out.println("Directory already exists.");
      }
    } catch (Exception e) {
      //System.out.println("An error occurred.");
      System.out.println(e.getMessage());
    }
  }

}
