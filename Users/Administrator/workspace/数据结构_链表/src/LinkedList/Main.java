package LinkedList;

public class Main {

	public static void main(String[] args) {
		Node head1=new Node();
		head1.creatListTail();
		head1.print();
		//Node q=head.reverse();
		//q.print();
		//head.insert(3);
		//head.print();
		//head.delete(1);
		//head.print();
		Node head2=new Node();
		head2.creatListTail();
		head2.print();
		head1.combine(head2);
		head1.print();
		
	}

}
