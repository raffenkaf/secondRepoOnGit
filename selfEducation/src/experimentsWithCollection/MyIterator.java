package experimentsWithCollection;

public interface MyIterator <T>{
	MyIterator <T> myIterator();
	boolean hasNext();
	T next();
	void restart();
}
