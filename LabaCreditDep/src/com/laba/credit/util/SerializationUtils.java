package com.laba.credit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationUtils {
    public void saveObjectToFile(String fileName, Serializable object) {
        FileOutputStream outputStream = null;
        ObjectOutputStream out = null;
        try {
            outputStream = new FileOutputStream(fileName);
            out = new ObjectOutputStream(outputStream);
            out.writeObject(object);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Object restoreObjectFromFile(String fileName) {
        if (!isDataFileExist(fileName)) {
            return null;
        }
        FileInputStream inputStream = null;
        ObjectInputStream in = null;
        Object result = null;
        try {
            inputStream =new FileInputStream(fileName);
            in = new ObjectInputStream(inputStream);
            result = in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    private boolean isDataFileExist(String fileName) {
        return new File(fileName).canRead();
    }
}
