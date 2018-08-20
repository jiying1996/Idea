package com.wqk;
import java.io.*;
public class FileTree {
	public static void main(String[] args) {
		File f = new File("E:\\");
		printFile(f, 0);
	}
	
	static void printFile(File file, int level) {
		for(int i=0; i<level;i++) {
			System.out.print("_ ");
		}
		System.out.println(file.getName());
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File temp:files) {
				printFile(temp, level+1);
			}
		}
	}
}
