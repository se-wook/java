package chapter03;


/**
 *	�޼��� 
 *  - �ڵ� ������ �ּ� ����  
 *  - ���� 
 *    [modifiers] ����Ÿ�� �޼ҵ��([����, ...]){
 *    
 *    	[return  ��]
 *    }
 *  - ȣ��]
 *      �޼����([���� ��, ...]);  
 *    
 * modifiers
 *   -access modifier(����������) : public protected ����	private 
 *   -usage modifier(���������)  : static, final, abstract  
 */
public class MethodTest1 {
	public static int plus(int i, int j) {
		return i+j;
	}
	public static void main(String[] args) {
		System.out.println( plus(256, 128));
	}
}







