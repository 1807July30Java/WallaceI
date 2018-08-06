package com.revature.dna;

import java.io.*;
import java.io.FileInputStream;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class Gene {

	public Gene() {
		
	}
	
	public static int muta(String st1, String st2, String[] bank) {//need to put in gene class, may be too tightly coupled
		char[] first = st1.toCharArray();
		char[] second = st2.toCharArray();
		int count = 0;
		for(int i = 0; i < first.length; i++) {
			if(first[i] != second[i]) {
				count++;
				
			}
		}
		
		
		for(String s: bank) {
			if(s.equals(st2)) {
//				System.out.println(count);
				return count;
			}
		}
		
		
//		System.out.println(-1);
		
		
		
		return -1;
	}
	
	public static int fileReader() {
		int result = 0;
		try{
			
//    	File file = new File(".");
//    	for(String fileNames : file.list()) System.out.println(fileNames);

        File file = new File("new  1.txt");
        //System.out.println(file.getCanonicalPath());
        FileInputStream ft = new FileInputStream(file);

        DataInputStream in = new DataInputStream(ft);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strline;
        
        String first = "";
        String second = "";
        
        ArrayList<String> arrayStrings = new ArrayList<String>();
        
        int count = 0;
        while((strline = br.readLine()) != null){
            strline.toString();
            if(count == 0) {
            	first = strline.toString();
            } else if(count == 1) {
            	second = strline.toString();
            } else if(count > 1) {
            	arrayStrings.add(strline.toString());
            }
            count++;
            
        }
        String[] tokens = new String[arrayStrings.size()];
        for(int i = 0; i < arrayStrings.size(); i++) {
        	tokens[i] = arrayStrings.get(i);
        	
        }
        
        
        in.close();
        
        result = muta(first, second, tokens);
        System.out.println(result);
    }catch(Exception e){
        System.err.println("Error: " + e.getMessage());
        
    }
		return result;
	}
	

}
