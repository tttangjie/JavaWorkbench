package collection;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
public class pratice_3 {
	public static void main(String[] args){
		HashSet hs = new HashSet();
		hs.add(new Employee("001", "����", "����"));
		hs.add(new Employee("002", "����", "�ܼ�"));
		hs.add(new Employee("003", "����", "����Ա"));
		Iterator it_hs = hs.iterator();
		while (it_hs.hasNext()) {
			System.out.println(it_hs.next());
		}
		System.out.println("----------------------------");
		TreeSet ts=new TreeSet();
		ts.add(new Employee("004","֮һ","����Ա"));
		ts.add(new Employee("005","֮��","����ʦ"));
		ts.add(new Employee("006","֮��","����"));
		Iterator it_ts=ts.iterator();
		while(it_ts.hasNext()){
			System.out.println(it_ts.next());
		}
	}
	
}
