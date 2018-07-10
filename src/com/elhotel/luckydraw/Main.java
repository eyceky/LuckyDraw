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
	public static void main(String[] args) {
		initList();
	}

	public static void initList() {
		Scanner scan = new Scanner(System.in);
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
