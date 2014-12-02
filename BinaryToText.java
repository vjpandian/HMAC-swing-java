/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package hmacdecryption;

/**
 *
 * @author spiro14
 */
public class BinaryToText {
    public String binaryToText(String binaryString)
    {
        String textString="";
	//	binaryString=binaryString.trim();

        for(int i = 0 ; i< binaryString.length(); i=i+7)
        {
			System.out.println("length"+binaryString.length());
			if((i+7)< binaryString.length()){
				String temp = binaryString.substring(i, i+7);
			
            int j= Integer.parseInt(temp,2);
			//System.out.println("value of j ,,,,,,,,,,,,,,,,,,,"+j);
            textString += (char)j;    
			}else{
				break;
			}
			//System.out.println("textString ,,,,,,,,,,,,,,,,,,,"+textString);
        }
        return textString;
    }


}
