package belavia.dataLayer;

import java.io.IOException;

public abstract class DataStore<T> {
    public abstract void updateData(T newData, String path) throws IOException;

    public abstract T loadData(String path) throws IOException, ClassNotFoundException;
}
