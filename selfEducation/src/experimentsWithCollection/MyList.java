package experimentsWithCollection;

public interface MyList <T> extends MyCollection<T>{
	T get (int index);
	boolean set(int index, T elem);
	boolean add(int index, T elem);
}
