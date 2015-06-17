package experimentsWithCollection;
//4 прокола
//1. currentIteratorNode должен быть в 2 вариантах, что была возможность передвигаться по списку вручную 
//	 и при этом выполнять удаление или вставку элементов
//2. Список двусвязный, а двигаюсь только в 1 направлении, смысл делать двусвязным? Должна быть оценка, 
//   с какой стороны быстрее достигаешь элемента и добираться до элемента с этой стороны. 
//3. Надо переделать текст на инглиш
//4. Проверка на null
//16,06,2016

public class MyColLL<T> implements MyList<T>{
	private Node<T> firstNode;
	private Node<T> lastNode;
	Node<T> currentIteratorNode;
	
	@Override
	public void add(T addElement){
		if (lastNode == null) {
			lastNode = new Node<T>(null, addElement);
			firstNode = lastNode;
			firstNode.setNumber(0);
		}
		else {
			Node<T> tmpNode = new Node<>(lastNode, addElement);
			lastNode.setNextNode(tmpNode);
			tmpNode.setNumber(lastNode.getNumber()+1);
			lastNode = tmpNode;
		}
	}

	@Override
	public void remove(T delElement) {
		restart();
		
		if (currentIteratorNode == firstNode && currentIteratorNode == lastNode) {//Only 1 node
			firstNode = null;
			lastNode = null;
		}
		
		while (hasNext()==true) {
			if (currentIteratorNode.getNextNode().getValue() == delElement) {
				currentIteratorNode.setNextNode(currentIteratorNode.getNextNode().getNextNode());//delete node
				currentIteratorNode.getNextNode().setPrevNode(currentIteratorNode);
								
				while (hasNext()==true) {	//decr per 1 numbers in all nodes after deleted node
					currentIteratorNode.getNextNode().setNumber(currentIteratorNode.getNumber()+1);
					next();
				}
				
			}
			else {
				next();
			}
			
		}
	}

	@Override
	public MyIterator<T> myIterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		if (currentIteratorNode.getNextNode() == null) {
			return false;
		}
		else {
			return true;
		}		
	}

	@Override
	public T next() {
		currentIteratorNode = currentIteratorNode.getNextNode();
		return currentIteratorNode.getValue();
	}

	public void restart() {
		currentIteratorNode = new Node<T>(null, null);
		currentIteratorNode.setNextNode(firstNode);
	}

	@Override
	public T get(int index) {
		restart();
		while (hasNext() == true) {
			if (currentIteratorNode.getNextNode().getNumber() == index) {	//currentIteratorNode - all 
				return currentIteratorNode.getNextNode().getValue(); 		//the the time is prev node
			}																//Method work with 
			else															//currentIteratorNode.getNextNode()
			{
				next();
			}
		}
		return null;
	}

	@Override
	public boolean set(int index, T elem) {
		restart();
		while (hasNext() == true) {
			if (currentIteratorNode.getNextNode().getNumber() == index) {
				currentIteratorNode.getNextNode().setValue(elem);
				return true;
			}
			else {
				next();
			}
		}
		return false;
	}

	@Override
	public boolean add(int index, T elem) {
		restart();
		
		if ((firstNode == null && index == 0) || 		//No elem in list 
				(lastNode.getNumber() == (index-1))) {	//or addition in last node	
			add(elem);								  														      
			return true;
		}
		
		while (hasNext() == true) {
			if (currentIteratorNode.getNumber() == index) {//Search for elem by his num
				
				Node<T> tmpNode = new Node<T>(currentIteratorNode.getPrevNode(), 		//
						currentIteratorNode, elem, index);								//
				currentIteratorNode.getPrevNode().setNextNode(tmpNode);					//Add new node
				currentIteratorNode.setPrevNode(tmpNode);								//
								
				currentIteratorNode = currentIteratorNode.getPrevNode();//Incr nums of all nodes after new
				while (hasNext() == true) {
					currentIteratorNode.getNextNode().setNumber(currentIteratorNode.getNextNode().getNumber()+1);
					currentIteratorNode = currentIteratorNode.getNextNode();
				}
				return true;
			}
			else{
				next();
			}
		}
		return false;
	}

}
