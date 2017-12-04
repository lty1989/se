package com.se.serial;

import java.io.*;

public class SerializableTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("a.txt"));
        os.writeObject(new User(10,"andy"));
        os.close();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("a.txt"));
        User user = (User)is.readObject();
        System.out.println(user);
    }
}
