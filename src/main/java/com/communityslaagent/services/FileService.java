package com.communityslaagent.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileService {

    public FileService() {
    }

    public void createFile(String name) {
        
        try {
            
            File file = new File(PropertiesService.getProperties().getProperty("logs.files.path") +name);
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File " + file.getName() + " already exists.");
                System.out.println("deleting...");
                if (file.delete()) {
                    System.out.println(file.getName() + " is deleted!");
                } else {
                    System.out.println("Delete operation is failed.");
                }
                System.out.println("\ncreating...");
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String name, StringBuffer sb) {

        try {
            File file = new File(PropertiesService.getProperties().getProperty("logs.files.path") +name);
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File " + file.getName() + " already exists.");
                System.out.println("deleting...");
                if (file.delete()) {
                    System.out.println(file.getName() + " is deleted!");
                } else {
                    System.out.println("Delete operation is failed.");
                }
                System.out.println("\ncreating...");
                file.createNewFile();
            }

            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                out.write(sb.toString());
                out.close();
                System.out.println("File Updated and Saved");
            } catch (IOException e) {
                System.out.println("Exception ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile(String path) throws IOException {
        FileInputStream stream = new FileInputStream(new File(path));
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            /* Instead of using default, pass in a decoder. */
            return Charset.defaultCharset().decode(bb).toString();
        } finally {
            stream.close();
        }
    }
}
