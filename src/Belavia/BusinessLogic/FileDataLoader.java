package Belavia.BusinessLogic;

import java.io.IOException;
import java.util.ArrayList;

public class FileDataLoader<T> {
    public FileDataLoader(){
        this.fileSerializer = new FileSerializer<T>();
    }

    private FileSerializer<T> fileSerializer;

    public void UpdateDataOnDisk(T newData) throws IOException {
        fileSerializer.Save(null ,newData);
    }

    public T LoadFromDisk(){
        try {
            return fileSerializer.Load(null);
        } catch (Exception e) {
            return null;
        }
    }
}
