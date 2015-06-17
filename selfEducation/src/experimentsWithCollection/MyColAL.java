package experimentsWithCollection;

public class MyColAL <T> implements MyList<T>{
	Object objArrayList[] = new Object[16];
	float capacity = 0.75f; 
	int currentAdditionPosition = 0;
	int currentIteratorPosition;
	
	@Override
	public void add(T addElement) {
		if(objArrayList.length*capacity > currentAdditionPosition)
			objArrayList[currentAdditionPosition++] = addElement;
		else{
			Object tmp[] = new Object[(int) (objArrayList.length*1.5)];
			System.arraycopy(objArrayList, 0, tmp, 0, currentAdditionPosition);
			objArrayList = tmp;
			objArrayList[currentAdditionPosition++] = addElement;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(T delElement) {
		for (int i = 0; i < objArrayList.length; i++){
			if(delElement.equals((T)objArrayList[i])){
				objArrayList[i]=null;
				System.arraycopy(objArrayList, (i+1), objArrayList, i, objArrayList.length-i-1);
				currentAdditionPosition--;
			}
		}		
	}

	@Override
	public MyIterator<T> myIterator() {
		currentIteratorPosition = -1;
		return this;
	}

	@Override
	public boolean hasNext() {
		if(currentIteratorPosition < (currentAdditionPosition - 1))
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T next() {
		if(currentIteratorPosition < (currentAdditionPosition - 1))
			return (T)objArrayList[++currentIteratorPosition];
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if(index < currentAdditionPosition && index> -1)
			return (T) objArrayList[index];
		else
			return null;
	}

	@Override
	public boolean set(int index, T elem) {
		if(index < currentAdditionPosition && index> -1){
			objArrayList[index] = elem;
			return true;
		}
		else 
			return false;
	}

	@Override
	public boolean add(int index, T elem) {
		if(index < currentAdditionPosition && index> -1){
			currentAdditionPosition++;
			if(objArrayList.length*capacity > currentAdditionPosition){
				System.arraycopy(objArrayList, index, objArrayList, (index+1), objArrayList.length-index-1);
				objArrayList[index] = elem;
				return true;
			}
			else{
				Object tmp[] = new Object[(int) (objArrayList.length*1.5)];
				System.arraycopy(objArrayList, 0, tmp, 0, currentAdditionPosition);
				objArrayList = tmp;
				System.arraycopy(objArrayList, index, objArrayList, (index+1), objArrayList.length-index-1);
				objArrayList[index] = elem;
				return true;
			}
		}
		else if(index == currentAdditionPosition){
			add(elem);
			return true;
		}
		else
			return false;
	}

	@Override
	public void restart() {
		currentIteratorPosition = -1;	
	}
}
