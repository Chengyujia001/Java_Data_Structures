package Ch24_Implementation;

public abstract class MyAbstractList<E> implements MyList<E>{
	protected int size = 0; //size of list	
	
	protected MyAbstractList() {
	}
	
	
	protected MyAbstractList(E[] array) {
		for (int i=0; i<array.length; i++)
			add(array[i]);
	}
	
	@Override 
	public void add(E e) {
		add(size , e);
	}
	
	/*
	 * public void add(int index, E e) {		//defined in concrete class
	 * 
	 * }
	 * 
	 * public void clear();
	 * 
	 * public boolean cotains(E e);
	 * 
	 * public E get(int index);
	 * 
	 * public int indexOf(E e);
	 * public int lastIndexOf(E e);
	 * public Object set(int index,E e);
	 */
	@Override 
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	
	@Override
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else
			return false;	
		
	}
	

	@Override 
	public int size() {
		return size;
	}
	


}
