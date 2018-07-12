package com.elhotel.luckydraw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 总名单459人.txt
 * @author eyceky
 *
 */
public class Main {

	private Employee[] emps; // 全部员工
	private Employee[] todo; // 未中奖员工
	private Employee[] prizeLucky; // 幸运奖
	private Employee[] prizeWarm; // 温暖奖
	private Employee[] prizeThird; // 三等奖
	private Employee[] prizeSecond; // 二等奖
	private Employee[] prizeFirst; // 一等奖
	private Employee[] prizeSpecial; // 特等奖

	public static void main(String[] args) {
		mainMenu();
	}

	/**
	 * 主菜单
	 */
	public static void mainMenu() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("**********广东鸿兴集团2017新春年会**********");
			System.out.println("1.导入名单；2.开始抽奖；3.查看中奖名单；4.退出系统；");
			int select;
			if (scan.hasNextInt()) {
				select = scan.nextInt();
			} else {
				scan.next();
				select = -1;
			}
			switch (select) {
			case 1:
				importList();
				continue;
			case 2:
				System.out.println("开始抽奖。");
				continue;
			case 3:
				System.out.println("查看中奖名单。");
				continue;
			case 4:
				System.out.println("正在退出系统！");
				scan.close();
				System.exit(0);
			default:
				System.out.println("选择错误，请重新选择");
				continue;
			}
		}
	}

	/**
	 * 导入名单
	 */
	public static void importList() {
		Scanner scan = new Scanner(System.in);
		System.out.println("**********广东鸿兴集团2017新春年会**********");
		System.out.println("请输入名单路径：");
		String listPath = scan.nextLine();
		scan.close();
		File listFile = new File(listPath);

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(listFile)))) {
			String line = null;
			int lineCount = 0;
			reader.mark(8192);
			while (reader.readLine() != null) {
				lineCount++;
			}
			Employee[] emps = new Employee[lineCount];

			reader.reset();
			int count = 0;
			while ((line = reader.readLine()) != null) {
				line.trim();
				String elements[] = line.split("-");
				emps[count] = new Employee(elements[1], elements[0]);
				count++;
			}
			System.out.println(Arrays.toString(emps));
		} catch (FileNotFoundException e) {
			System.out.println("输入的路径无效，请重新输入！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void draw() {
		System.out.println("请选择");
	}
}
