package _IO_File;

import java.io.*;
import java.util.ArrayList;

public class IOFile<E> {
    public void writerFileData(ArrayList<E> arrayData, String pathname) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(pathname)));
            objectOutputStream.writeObject(arrayData);
            objectOutputStream.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public ArrayList<E> readFileData(String pathname) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathname));
            return (ArrayList<E>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi đọc file "+ e.getMessage());
        }
        return null;
    }
}
