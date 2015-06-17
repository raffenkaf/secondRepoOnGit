package experimentsWithCollection;

public interface MyCollection <T> extends MyIterator <T>{
	void add(T addElement);
	void remove(T delElement);	
}
