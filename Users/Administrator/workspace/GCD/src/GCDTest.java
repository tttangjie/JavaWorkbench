import junit.framework.TestCase;
public class GCDTest extends  TestCase{

	public void testGCD() {
		GCD g=new GCD();
		//*语句覆盖 分支覆盖 条件覆盖 分支/条件覆盖 条件组合覆盖*//
		assertEquals(10,g.getGCD(20, 10));
		assertEquals(1,g.getGCD(3,5));
		assertEquals(-1,g.getGCD(0,0));
		assertEquals(-1,g.getGCD(101,101));
		
		//*路径覆盖*//
		

	}
}
