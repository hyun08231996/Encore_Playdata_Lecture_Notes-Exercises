package thread.step1.test;
/*
 * Thread Ŭ������ ��ӹ޾Ƽ� Thread�� ������.
 * Thread�� 2���� �����Ѵ�.
 * GoThread, ComeThread
 */
class GoThread extends Thread{
	//�����尡 �۵��ϴ� �κ�...run() �����ȿ��� �ش� �����尡 �����ϴ� ���� Ȯ���� �� �ִ�.
	public void run() {
		int i=0;
		while(true) {
			System.out.println("Go...."+i);
			i++;
			if(i==20) break;
		}
	}
}
class ComeThread extends Thread{
	//�����尡 �۵��ϴ� �κ�...run() �����ȿ��� �ش� �����尡 �����ϴ� ���� Ȯ���� �� �ִ�.
	public void run() {
		int i=0;
		while(true) {
			System.out.println("Come...."+i);
			i++;
			if(i==20) break;
		}
	}
}
public class GoComeThread {//�̰� ���μ����� �� �ȿ��� �� ���� ������ (GoThread,ComeThread)�� ����.
	public static void main(String[] args) {
		//GoComeThread ��� ���μ��� �ȿ��� 2���� �����带 ���۽��Ѻ����� ����
		GoThread t1 = new GoThread();
		ComeThread t2 = new ComeThread();
		
		t1.start();
		t2.start();
	}
}