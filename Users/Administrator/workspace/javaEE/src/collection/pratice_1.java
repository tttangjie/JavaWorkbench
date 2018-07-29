package collection;
import java.util.HashSet;
import java.util.Iterator;
public class pratice_1 {
	public static void main(String[] args)
	{
		HashSet hs=new HashSet();
		hs.add("one");
		hs.add("two");
		hs.add("three");
		Iterator it=hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}

//´òÓ¡½á¹û
//one
//three
//two
