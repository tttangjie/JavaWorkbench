package collection;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
public class pratice_3 {
	public static void main(String[] args){
		HashSet hs = new HashSet();
		hs.add(new Employee("001", "张三", "经理"));
		hs.add(new Employee("002", "李四", "总监"));
		hs.add(new Employee("003", "王五", "打字员"));
		Iterator it_hs = hs.iterator();
		while (it_hs.hasNext()) {
			System.out.println(it_hs.next());
		}
		System.out.println("----------------------------");
		TreeSet ts=new TreeSet();
		ts.add(new Employee("004","之一","程序员"));
		ts.add(new Employee("005","之二","工程师"));
		ts.add(new Employee("006","之三","美工"));
		Iterator it_ts=ts.iterator();
		while(it_ts.hasNext()){
			System.out.println(it_ts.next());
		}
	}
	
}
