/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_2;

/**
 *
 * @author RC_Student_lab
 */

import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Message {
    
    private static int messageCount = 0;
  
   //Attributes
    private String messageID;
    private String recipient;
    private String content;
    private String messageHash;
    
    //Constructors
    public Message(String recipient, String content){
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.content = content;
        this.messageHash = createMessageHash();
        messageCount++;
        
        storeMessage(); 
    }
    //Generate a random numeric Message ID
    private String generateMessageID(){
        return String.valueOf((int)(Math.random() * 1000000000));
    }
    
    //Check if the generated message ID is valid
    public boolean checkMessageID(){
        return this.messageID.length()<= 10;
    }
    
    //Check if recipient cell number is valid
    public static boolean checkRecipientCell(String recipient){
        return recipient != null && 
               recipient.startsWith("+") && 
               recipient.substring(1).matches("\\d{10,15}");
    }
    
    //Create a message hash
    private String createMessageHash(){
        String[]words = this.content.trim().split("\\s+");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        return this.messageID.substring(0,2) + ":" + messageCount + ":" + "firstWord" + "lastWord";
    }
    
    //Return a user-facing message based on input option
    public static boolean sendMessageOption(String option){
        return option.equals("1");
    }
    
    //Print message info
    public String printMessage(){
        return "Message ID: " + messageID +
                "\nMessage Hash: " + messageHash +
                "\nRecipient: " + recipient + 
                "\nMessage Content: " + content;
    }
    
    //Static method to return total messages sent
    public static int returnTotalMessages(){
        return messageCount;
    }
    
    //Store message infro in JSON 
    private void storeMessage() {
        JSONObject messageJson = new JSONObject();
        messageJson.put("MessageID", messageID);
        messageJson.put("MessageHash", messageHash);
        messageJson.put("Recipient", recipient);
        messageJson.put("Content", content);
    
        try(FileWriter file = new FileWriter("messages.json", true)){
            file.write(messageJson.toString());
        }catch(IOException e){
            System.out.println("Error writing message to JSON: " + e.getMessage());
        }   
    
    }
}

