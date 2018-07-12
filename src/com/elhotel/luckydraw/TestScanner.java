
package com.elhotel.luckydraw;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int select;
			System.out.println("1.继续；2.退出");
			if (!scan.hasNextInt()) {
				scan.next();
				select = -1;
			} else {
				select = scan.nextInt();
			}
			switch (select) {
			case 1:
				System.out.println("选择了1");
				continue;
			case 2:
				System.out.println("选择了2");
				System.out.println("退出系统！");
				scan.close();
				System.exit(0);
			default:
				System.out.println("选择错误，请重新选择！");
			}

		}
	}
}
