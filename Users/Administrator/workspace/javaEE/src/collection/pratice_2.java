package collection;
import java.util.TreeSet;
import java.util.Iterator;
public class pratice_2 {
	public static void main(String[] args){
		TreeSet ts=new TreeSet();
		ts.add("one");
		ts.add("two");
		ts.add("three");
		Iterator it=ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}	
	}
}

//´òÓ¡½á¹û
//one
//three
//two