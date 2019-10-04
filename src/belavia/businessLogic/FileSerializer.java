package belavia.businessLogic;

import java.io.*;

public class FileSerializer<T> {
    public static final String filePath = "Orders.txt";

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

            if(!newFile.delete()){
                throw new IOException("Could not delete file because it was busy.");
            }

        }

        if(!newFile.createNewFile()){
            throw new IOException("Could not create file: " + newFile.getName());
        }

        try(var file = new FileOutputStream(newFile);
            var out = new ObjectOutputStream(file)){
            out.writeObject(object);
        }
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

        try(var fileInputStream = new FileInputStream(file);
            var in = new ObjectInputStream(fileInputStream)){
            return (T) in.readObject();
        }
    }
}
