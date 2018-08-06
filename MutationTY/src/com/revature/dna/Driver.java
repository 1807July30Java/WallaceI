package com.revature.dna;

public class Driver {

	public Driver() {
		
	}
	
	public static void main(String[] args)
	{
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bank = new String[3];
		bank[0] = "AACCGGTA";
		bank[1] = "AACCGCTA";
		bank[2] = "AAACGGTA";
		int result = com.revature.dna.Gene.muta(start, end, bank);
		
//		System.out.println(result);
		com.revature.dna.Gene.fileReader();
	}
	
	
	
	

}
