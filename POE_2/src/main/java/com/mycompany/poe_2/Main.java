/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
package com.mycompany.poe_2;

/**
 *
 * @author RC_Student_lab
 */


import javax.swing.JOptionPane;

public class Main {

   public static void main(String[]args){
       
       String firstName;
       String lastName;
       String username = null;
       String password = null;
       String cellPhoneNumber = null;
       
       firstName = JOptionPane.showInputDialog("Enter first name: ");
       lastName = JOptionPane.showInputDialog("Enter last name: ");
       
       
       
       //Validate username
       boolean isValidUsername = false;
       while(!isValidUsername){
           username = JOptionPane.showInputDialog("Enter username (must contain an underscore and be no more than 5 character):");
           if (username != null && username.contains("_") && username.length() <=5){
            isValidUsername = true;
           }else{
               JOptionPane.showMessageDialog(null, "username is not correctly formatted.");
           }
       }
       
        // Validate password
        
        boolean isValidPassword = false;
        while (!isValidPassword) {
            password = JOptionPane.showInputDialog("Enter password (must contain a capital letter, a special character, a number, and be no more than 8 characters):");
            if (password != null && isValidPassword(password)) {
                isValidPassword = true;
            } else {
                JOptionPane.showMessageDialog(null, "Password is incorrectly formatted. Please ensure that the password contains at least one capital letter, a number, a special character, and is no more than 8 characters.");
            }
        }

        // Validate cellphone number
       
        boolean isValidCellphoneNumber = false;
        while (!isValidCellphoneNumber) {
            cellPhoneNumber = JOptionPane.showInputDialog("Enter cellphone number (must start with +27 and be 12 digits):");
            if(cellPhoneNumber != null && isValidCellphoneNumber(cellPhoneNumber)){    
                isValidCellphoneNumber = true;
            } else {
                JOptionPane.showMessageDialog(null, "Cellphone is incorrectly formatted");
            }
        }

        JOptionPane.showMessageDialog(null, "Cellphone Number successfully added");
      
        // Login phase
        boolean loggedIn =  false;
        while(!loggedIn){
            String loginUsername = JOptionPane.showInputDialog( "=== Log In ===\nEnter username");
            String loginPassword = JOptionPane.showInputDialog("Enter password:");

        if (loginUsername != null && loginPassword != null &&
            loginUsername.equals(username) &&  loginPassword.equals(password)) {
            loggedIn = true;
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");
        } else {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + ", it is great to have you back!");
        }
      }
        
        runQuickChat();
    
   }
       //Validates password with specific conditions 
       private static boolean isValidPassword(String password){
           if (password.length() > 8){
               return false;
           }
           boolean hasUpperCase = false;
           boolean hasDigit = false;
           boolean hasSpecialChar = false;
           String specialCharacters = "@#$%^&*+=";
           
           for (char ch : password.toCharArray()){
               if(Character.isUpperCase(ch)) hasUpperCase = true;
               if(Character.isDigit(ch)) hasDigit = true;
               if(specialCharacters.indexOf(ch) >= 0) hasSpecialChar = true;
           }
           
           return hasUpperCase && hasDigit && hasSpecialChar;
       }
       
       //Validate cellphone Number
       private static boolean isValidCellphoneNumber(String cellPhoneNumber){
           if(cellPhoneNumber.length() != 12 && !cellPhoneNumber.startsWith("+27")){
               return false;
           }
           for (int i = 3; i < cellPhoneNumber.length(); i++){
               if(!Character.isDigit(cellPhoneNumber.charAt(i))){
                   return false;
               }
           }
           return true;
       }


    // Messaging functionality
    private static void runQuickChat() {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");
        boolean running = true;

        while (running) {
            String[] options = {"Send Message", "Show Recent (Coming Soon)", "Quit"};
            int choice = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "QuickChat Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
            );

            switch (choice) {
                case 0: {
                    // Send Message
                    String recipient = JOptionPane.showInputDialog("Enter recipient number:");
                    String message = JOptionPane.showInputDialog("Enter message:");

                    if (message != null && message.length() > 250) {
                        JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters");
                    } else {
                        JOptionPane.showMessageDialog(null, "Message sent" );
                    }
                }
                break;

                case 1:  // Show Recent (Coming Soon)
                    JOptionPane.showMessageDialog(null, "Coming Soon.");
                    break;

                case 2: //Quit
                case JOptionPane.CLOSED_OPTION:
                      running = false;
                      JOptionPane.showMessageDialog(null, "Goodbye!");
                      break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }
}
