import junit.framework.TestCase;
public class GCDTest extends  TestCase{

	public void testGCD() {
		GCD g=new GCD();
		//*��串�� ��֧���� �������� ��֧/�������� ������ϸ���*//
		assertEquals(10,g.getGCD(20, 10));
		assertEquals(1,g.getGCD(3,5));
		assertEquals(-1,g.getGCD(0,0));
		assertEquals(-1,g.getGCD(101,101));
		
		//*·������*//
		

	}
}
