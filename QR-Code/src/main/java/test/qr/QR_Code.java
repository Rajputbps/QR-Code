package test.qr;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
 

public class QR_Code {

	public static void main(String[] args) throws WriterException, IOException {
		InetAddress localhost = InetAddress.getLocalHost(); 
        System.out.println("System IP Address : " + 
                      (localhost.getHostAddress()).trim()); 
        String ipadress = localhost.getHostAddress().trim();
		String qrText = "Hello Pagal" + ipadress;
		String filePath="QR.png";
		int size  = 500;
		String fileType = "png";
		
		File fileFile = new File(filePath);
		createQRCode(fileFile, qrText, size, fileType);
		System.out.println("****************** Done ****************");
	}
	private static void createQRCode(File qrFile, String qrCodeText, int size, String fileType) throws WriterException, IOException {
		System.out.println("Hello");
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintmap = new  Hashtable<EncodeHintType, ErrorCorrectionLevel>();
		hintmap.put( EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter codeWriter = new  QRCodeWriter();
		BitMatrix bitMatrix = codeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size,hintmap);
		int matrixWidth =bitMatrix.getWidth();
		BufferedImage  image =  new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();
		Graphics2D graphics2d  = (Graphics2D) image.getGraphics();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, matrixWidth, matrixWidth);
		graphics2d.setColor(Color.BLACK);
		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (bitMatrix.get(i, j)) {
					graphics2d.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}
}
