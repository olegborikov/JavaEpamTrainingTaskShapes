package com.borikov.task1.socket;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ImageSocket {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9000);
             Socket socket = serverSocket.accept();
             ByteArrayOutputStream baoStream = new ByteArrayOutputStream()) {
            System.out.println("Client is running. Reading image from disk.");
            BufferedImage img = ImageIO.read(new File("C:\\_ROOT\\used_words.jpg"));
            ImageIO.write(img, "jpg", baoStream);
            PrintStream output = new PrintStream(socket.getOutputStream());
            baoStream.writeTo(output);
            baoStream.flush();
            System.out.println("Image sent to server.");
        } catch (IOException e) {
            System.out.println("I/O: " + e);
        }
    }
}
