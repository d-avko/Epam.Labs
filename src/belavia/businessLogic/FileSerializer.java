package belavia.businessLogic;

import java.io.*;

public class FileSerializer<T> {
    public static String filePath = "Orders.txt";

    /** Used to serialize an object of type T and write it to the file.
     *  Overwrites existing file or creates new one.
     * @param path Path where to save the file, or null to use default path.
     * @param object object to serialize
     * @throws IOException path was incorrect
     */
    public void save(String path, T object) throws IOException {
        if (path == null) {
            path = filePath;
        }
        var newFile = new File(path);

        if (newFile.exists()) {
            newFile.delete();
            newFile.createNewFile();
        } else {
            newFile.createNewFile();
        }

        var file = new FileOutputStream(newFile);
        var out = new ObjectOutputStream(file);
        out.writeObject(object);
        out.close();
        file.close();
    }

    /** Used to load serialized object from file
     * @param path Path to file with serialized object or null, if default path will be used.
     * @return Deserialized object of type T
     * @throws IOException file of path or defaultPath was not found
     * @throws ClassNotFoundException class used as a type parameter for this class was not found.
     */
    public T load(String path) throws IOException, ClassNotFoundException {
        if (path == null) {
            path = filePath;
        }

        var file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
            throw new FileNotFoundException();
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileInputStream);

        var result = (T) in.readObject();

        in.close();
        fileInputStream.close();

        return result;
    }
}
