package belavia.BusinessLogic;

import java.io.IOException;

public class FileDataStore<T> extends DataStore<T> {
    public FileDataStore() {
        this.fileSerializer = new FileSerializer<T>();
    }

    private FileSerializer<T> fileSerializer;

    public void updateData(T newData) throws IOException {
        fileSerializer.save(null, newData);
    }

    public T loadData() {
        try {
            return fileSerializer.load(null);
        } catch (Exception e) {
            return null;
        }
    }
}
