package belavia.businessLogic;

import java.io.IOException;

public class FileDataStore<T> extends DataStore<T> {
    public FileDataStore() {
        this.fileSerializer = new FileSerializer<T>();
    }

    private FileSerializer<T> fileSerializer;

    /** Used to save object to a file.
     * @param newData Data to save to a default file path
     * @throws IOException file was busy
     */
    public void updateData(T newData) throws IOException {
        fileSerializer.save(null, newData);
    }


    /** Loads data from default file path, if the file exists.
     * @return Data
     * @throws IOException File was not found.
     * @throws ClassNotFoundException Should not show up
     */
    public T loadData() throws IOException, ClassNotFoundException {
        return fileSerializer.load(null);
    }
}
