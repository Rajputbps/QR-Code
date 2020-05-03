package test.qr;

import java.io.File;

import net.sourceforge.tess4j.*;

public class TextFromImage {
	
	public static void main(String[] args) {
		ITesseract iTesseract = new Tesseract();
		try {
			
        iTesseract.doOCR(new File("/home/rajput/Pictures/S.png"));
			 
			
		} catch (Exception e) {
			 System.err.println(e.getMessage()+"not fon");
	             
		} 
		//System.out.println(crackImage("/home/rajput/Pictures/Screenshot from 2019-09-23 20-49-47.png"));
	}
	
//	public static String crackImage(String filePath) {
//		
//		File file  = new File(filePath);
//		ITesseract iTesseract = new Tesseract();
//		try {
//			
//			String result = iTesseract.doOCR(file);
//			return result;
//			
//		} catch (Exception e) {
//			 System.err.println(e.getMessage());
//	            return "Error while reading image";
//		}
//			 
//	}

}
