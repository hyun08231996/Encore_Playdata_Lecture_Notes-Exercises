package test;

import java.util.Scanner;

/*
 * Scanner Ŭ������
 * �����(�����Ͻð� �ƴ�) Ű����� �Էµ� ���� �޵��� ���ִ� ����� ������ �ִ� Ŭ����
 */
public class ScannerTest2 {

	public static void main(String[] args) {
		System.out.println("Ű����� ���� 2���� �̸��� �Է��ϼ���>>>");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt(); //������ �������� �����͸� ��ȯ�Ѵ�.
		int j = sc.nextInt();
		
		sc.nextLine(); //�� ������ �������� �����͸� ��ȯ
		String name = sc.next(); //������ �������� �����͸� ��ȯ�Ѵ�.
		
		System.out.println("���ڰ� i: "+i+", j: "+j);
		System.out.println(name);

	}

}