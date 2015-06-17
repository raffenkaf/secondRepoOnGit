package experimentsWithCollection;

public class TestCollectionClass {
	public static void main(String[] args) {
//		//test MyColAl
//		MyList<Integer> testAL= new MyColAL<>();
//		testAL.add(12);
//		testAL.add(5);
//		MyIterator<Integer> testAlIter = testAL.myIterator();
//		while (testAlIter.hasNext()) {
//			System.out.println(testAlIter.next());			
//		}
//		testAL.remove(12);
//		while (testAlIter.hasNext()) {
//			System.out.println(testAlIter.next());			
//		}
//		
//		System.out.println(testAL.add(5, new Integer(4)));
//		System.out.println(testAL.add(1, new Integer(4)));
//		
//		testAlIter.restart();
//		while (testAlIter.hasNext()) {
//			System.out.println(testAlIter.next());			
//		}
//		//
		
		MyList<Integer> testLL= new MyColLL<>();
		testLL.add(12);
		testLL.add(5);
		testLL.add(2);
		testLL.add(2);
		testLL.add(3);
		testLL.add(4);
		testLL.add(6);
		MyIterator<Integer> testLLIter = testLL.myIterator();
		System.out.println("After add");
		testLL.restart();
		while (testLLIter.hasNext()) {
			System.out.println(testLLIter.next());			
		}
		testLL.remove(22);
		System.out.println("After remove");
		testLLIter.restart();
		while (testLLIter.hasNext()) {
			System.out.println(testLLIter.next());			
		}
		
		System.out.println(testLL.add(5, new Integer(4)));
		System.out.println(testLL.add(1, new Integer(4)));
		 
		System.out.println("After 2-nd add");
		testLLIter.restart();
		while (testLLIter.hasNext()) {
			System.out.println(testLLIter.next());
		}
	}
}
