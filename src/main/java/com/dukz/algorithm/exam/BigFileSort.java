package com.dukz.algorithm.exam;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * @author dukezheng
 * @ClassName BigFileSort
 * @Description 大文件排序
 * 题目，对文件进行排序(无重复数据)
 * 请将下方模板代码粘贴到提交内容中，并补充solution方法的代码
 * 其中solution方法的入参为从服务器读取的文件路径和要输出的文件路径
 *
 * 规则与约束条件：
 * 1、要读取的文件内容格式为每行一个int类型数字，最终运行读取的文件大小约10GB 排序后输出到另一个文件
 * 2、数字分两种情况，有重复和无重复，可以优先完成不重复的情况，如果能兼容有重复的情况，给予加分
 * 3、输入内容需要按照从大到小进行排序，写入输出路径， 输出的文件名已经作为参数给出， 每个数字占一行， 不允许有空行
 * 4、首次运行会使用一个50MB左右的小文件，服务器资源有限，大约只有20MB，开发时优先节省资源的前提下尽量快，最慢需要在60s之内跑完
 * 5、只允许用JDK8自带的类库
 * 6、运行过程中可以创建和删除文件，但是只能使用当前相对路径，文件名只允许使用小写英文字母，不包含其他符号，后缀不限
 * 说明：
 * jdk版本1.8.0_292
 * 换行符统一使用 \r\n
 * @date 2021/9/13 20:46
 */
public class BigFileSort {


	public static final int FILE_SIZE_LIMIT = 4000000;
	public static final String FILENAME_PREFIX = "small_file_";
	public static final String FILENAME_OUT_PREFIX = "small_file_out_";

	public static String solution(String files,String result) throws IOException {
		//请在此处填写相关逻辑
		File src = new File(files);
		int min=Integer.MAX_VALUE,max=0;
		FileReader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(src);
			br = new BufferedReader(reader);
			String str = null;
			while ((str = br.readLine()) != null){
				int line = Integer.parseInt(str);
				min = line < min ? line : min;
				max = line > max ? line : max;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null){
				br.close();
			}
			if(reader != null){
				reader.close();
			}
		}
		int length = max - min + 1;
		int fileNum = length / FILE_SIZE_LIMIT + (length%FILE_SIZE_LIMIT==0?0:1);
		BufferedWriter[] bws = new BufferedWriter[fileNum];
		for (int i = 0; i < fileNum; i++) {
			File smallFile = new File(FILENAME_PREFIX +i);
			if (!smallFile.exists()) {
				smallFile.createNewFile();
				bws[i] = new BufferedWriter(new FileWriter(smallFile));
			}
		}
		FileWriter writer = null;
		BufferedWriter bw = null;
		try {
			reader = new FileReader(src);
			br = new BufferedReader(reader);
			String str = null;
			while ((str = br.readLine()) != null){
				int line = Integer.parseInt(str);
				int index = (line-min)/FILE_SIZE_LIMIT;
				bws[index].write(line+"\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null){
				br.close();
			}
			if(reader != null){
				reader.close();
			}
			for (int i = 0; i < fileNum; i++) {
				bws[i].close();
			}
		}
		try {
			File dest = new File(result);
			writer = new FileWriter(dest);
			bw = new BufferedWriter(writer);
			for (int i = 0; i < fileNum; i++) {
				String srcName = FILENAME_PREFIX +i;
				String destName = FILENAME_OUT_PREFIX +i;
				smallFileSort(srcName, destName);
				File destFile = new File(destName);
				reader = new FileReader(destFile);
				br = new BufferedReader(reader);

				String str = null;
				while ((str = br.readLine()) != null){
					bw.write(str+"\r\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null){
				br.close();
			}
			if(reader != null){
				reader.close();
			}
			if(bw != null){
				bw.close();
			}
			if(writer != null){
				writer.close();
			}
		}

		for (int i = 0; i < fileNum; i++) {
			String destName = FILENAME_OUT_PREFIX +i;
			File destFile = new File(destName);
			destFile.delete();
		}
		return result;
	}

	public static String smallFileSort(String files,String result) throws IOException {
		//请在此处填写相关逻辑
		File src = new File(files);
		int min=Integer.MAX_VALUE,max=0;
		FileReader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(src);
			br = new BufferedReader(reader);
			String str = null;
			while ((str = br.readLine()) != null){
				int line = Integer.parseInt(str);
				min = line < min ? line : min;
				max = line > max ? line : max;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null){
				br.close();
			}
			if(reader != null){
				reader.close();
			}
		}
		int length = max - min + 1;
		int[] arr = new int[length];
		File dest = new File(result);
		FileWriter writer = null;
		BufferedWriter bw = null;
		try {
			reader = new FileReader(src);
			br = new BufferedReader(reader);
			writer = new FileWriter(dest);
			bw = new BufferedWriter(writer);
			String str = null;
			while ((str = br.readLine()) != null){
				int line = Integer.parseInt(str);
				arr[line-min] += 1;
			}
			for (int i = 0; i < arr.length; i++) {
				while(arr[i] > 0){
					bw.write((i+min)+"\r\n");
					arr[i]-=1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null){
				br.close();
			}
			if(reader != null){
				reader.close();
			}
			if(bw != null){
				bw.close();
			}
			if(writer != null){
				writer.close();
			}
		}
		src.delete();
		return result;
	}


	static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String files = in.nextLine();
		String out = "out.dic";
		long start = System.currentTimeMillis();
		File file = new File(solution(files,out));
		String result = getMD5Encrypt(file);
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(result);
	}

	public static String getMD5Encrypt(File filePath) {
		FileInputStream input = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			input = new FileInputStream(filePath);
			byte[] buffer = new byte[2048];
			int length = -1;
			while ((length = input.read(buffer)) != -1) {
				//参数为待加密数据
				md.update(buffer, 0, length);
			}
			//加密之后生成的密文的字节数组
			byte[] b = md.digest();
			//转化为16进制字符串
			return byteToHexString(b);
		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String byteToHexString(byte[] b) {
		// 用字节表示就是 16 个字节
		// 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符
		// 比如一个字节为01011011，用十六进制字符来表示就是“5b”
		char[] str = new char[16 * 2];
		int k = 0; // 表示转换结果中对应的字符位置
		for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节转换成 16 进制字符的转换
			byte byte0 = b[i]; // 取第 i 个字节
			str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
			str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
		}
		return new String(str);
	}
}
