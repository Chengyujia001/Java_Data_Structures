package Ch24_Implementation;

public class test_LinkList {

	public static <E> void main(String[] args) {
		// TODO Auto-generated method stub

		MyLinkedList<String> list = new MyLinkedList<>();
		
		list.add("a1");
		System.out.println(list);
		
		list.add("a2");
		System.out.println(list);
		
		list.add(1, "a1.5");
		System.out.println(list);
		
		for (String s: list)
			System.out.print(s.toUpperCase() + " ");
		System.out.println();
		
		list.remove(1);
		list.remove(1);
		System.out.println(list);
	}

}
