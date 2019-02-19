package com.portal.automation.daimler.pages.test.search;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String st ="true|true";
		String[] arrV = st.split("|");
		for(int i=0;i<arrV.length;i++){
			System.out.println("\n "+i+" value="+arrV[i]);*/
				String string = "True-False";
				String[] parts = string.split("-");
				//String part1 = parts[0]; // 004
				//String part2 = parts[1]; // 034556
				for(int i=0;i<parts.length;i++){
					System.out.println("\n "+i+" value="+parts[i]);
				}
	}
}
	


