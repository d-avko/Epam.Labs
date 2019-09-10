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

        FileInputStream file = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(file);

        var result = (T) in.readObject();

        in.close();
        file.close();

        return result;
    }
}
