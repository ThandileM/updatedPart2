/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_2;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author RC_Student_lab
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
     private Message message;

    @BeforeEach
    public void setUp() {
        message = new Message("+27718693002", "HI Mike, can you join us for dinner tonight?");
    }

    @Test
    public void testMessageIDLength() {
        assertTrue(message.checkMessageID(), "Message ready to send");
    }

    @Test
    public void testValidRecipientNumber() {
        assertTrue(Message.checkRecipientCell("+27718693002"), "Cellphone number successfully captured");
    }

    @Test
    public void testInvalidRecipientNumber() {
        assertFalse(Message.checkRecipientCell("0838968976"), "Missing '+' should fail");
        assertFalse(Message.checkRecipientCell("+2783896"), "Too short, shoul fail");
        assertFalse(Message.checkRecipientCell(null), "Null input should fail");
    }

    @Test
    public void testSendMessageOption() {
        assertTrue(Message.sendMessageOption("1"));
        assertFalse(Message.sendMessageOption("2"));
    }

    @Test
    public void testTotalMessagesCountIncreases() {
        int initialCount = Message.returnTotalMessages();
         message = new Message("+27820000001", "Test message");
        assertEquals(initialCount + 1, Message.returnTotalMessages());
    }

    @Test
    public void testJsonFileIsCreated() {
        File file = new File("messages.json");
        assertTrue(file.exists(), "messages.json should be created after storing message");
    }

    @Test
    public void testJsonFileIsNotEmpty() throws Exception {
        File file = new File("messages.json");
        assertTrue(file.exists());
        assertTrue(Files.size(Paths.get("messages.json")) > 0, "messages.json should not be empty");
    }

    //@AfterEach
    //void tearDown() {
        // Optional: Clean up file between runs if needed
        // new File("messages.json").delete();
    }



