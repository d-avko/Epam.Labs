package Belavia.BusinessLogic;

import java.io.*;

public class FileSerializer<T> {
    public static String FilePath = "Orders.txt";

    public void Save(String path, T object) throws IOException {
        if(path == null){
            path = FilePath;
        }
        var newFile = new File(path);

        if(newFile.exists()){
            newFile.delete();
            newFile.createNewFile();
        }

        var file = new FileOutputStream(newFile);
        var out = new ObjectOutputStream(file);
        out.writeObject(object);
        out.close();
        file.close();
    }

    public T Load(String path) throws IOException, ClassNotFoundException {
        if(path == null){
            path = FilePath;
        }

        var file = new File(path);

        if(!file.exists()){
            file.createNewFile();
            return null;
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileInputStream);

        var result = (T) in.readObject();

        in.close();
        fileInputStream.close();

        return result;
    }
}
