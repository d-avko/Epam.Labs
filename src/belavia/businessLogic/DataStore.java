package belavia.businessLogic;

import java.io.IOException;

public abstract class DataStore<T> {
    public abstract void updateData(T newData) throws IOException;

    public abstract T loadData() throws IOException, ClassNotFoundException;
}
