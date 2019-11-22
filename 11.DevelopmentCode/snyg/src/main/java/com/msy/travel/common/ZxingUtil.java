package com.msy.travel.common;

import java.io.File;
import java.nio.file.Path;
import java.util.Hashtable;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;

public class ZxingUtil {

	private static final int QUIET_ZONE_SIZE = 4;

	/**
	 * 生成二维码
	 * 
	 * @author yf-wanghuan
	 * @date 2017年5月19日 上午9:12:43
	 * @param qrContent
	 *            二维码内容
	 * @param format
	 *            文件格式 png、jpg等
	 * @param width
	 *            二维码宽度
	 * @param height
	 *            二维码高度
	 * @param file
	 *            文件路径名
	 * @return
	 * @return boolean
	 */
	public static boolean createQrcode(String qrContent, String format, int width, int height, Path file) {

		boolean res = true;

		try {

			Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
			hints.put(EncodeHintType.MARGIN, 1);
			BitMatrix bitMatrix = new MultiFormatWriter().encode(qrContent, BarcodeFormat.QR_CODE, width, height, hints);
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {
			res = false;
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 生成无框二维码
	 * 
	 * @author yf-wanghuan
	 * @date 2017年5月19日 上午10:00:02
	 * @param qrContent
	 * @param format
	 * @param width
	 * @param height
	 * @param file
	 * @return
	 * @return boolean
	 */
	public static boolean createFullQrcode(String qrContent, String format, int width, int height, Path file) {

		boolean res = true;

		try {
			Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
			hints.put(EncodeHintType.MARGIN, 1);
			BitMatrix bitMatrix = encode(qrContent, width, height, hints);
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {
			res = false;
			e.printStackTrace();
		}
		return res;
	}

	public static BitMatrix encode(String contents, int width, int height) throws WriterException {

		return encode(contents, width, height, null);
	}

	public static BitMatrix encode(String contents, int width, int height, Map<EncodeHintType, ?> hints) throws WriterException {

		if (contents.isEmpty()) {
			throw new IllegalArgumentException("Found empty contents");
		}

		if (width < 0 || height < 0) {
			throw new IllegalArgumentException("Requested dimensions are too small: " + width + 'x' + height);
		}

		ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
		int quietZone = QUIET_ZONE_SIZE;
		if (hints != null) {
			ErrorCorrectionLevel requestedECLevel = (ErrorCorrectionLevel) hints.get(EncodeHintType.ERROR_CORRECTION);
			if (requestedECLevel != null) {
				errorCorrectionLevel = requestedECLevel;
			}
			Integer quietZoneInt = (Integer) hints.get(EncodeHintType.MARGIN);
			if (quietZoneInt != null) {
				quietZone = quietZoneInt;
			}
		}

		QRCode code = Encoder.encode(contents, errorCorrectionLevel, hints);
		return renderResult(code, width, height, quietZone);
	}

	private static BitMatrix renderResult(QRCode code, int width, int height, int quietZone) {
		ByteMatrix input = code.getMatrix();
		if (input == null) {
			throw new IllegalStateException();
		}
		int inputWidth = input.getWidth();
		int inputHeight = input.getHeight();
		int qrWidth = inputWidth;
		int qrHeight = inputHeight;
		int outputWidth = Math.max(width, qrWidth);
		int outputHeight = Math.max(height, qrHeight);

		int multiple = Math.min(outputWidth / qrWidth, outputHeight / qrHeight);
		// Padding includes both the quiet zone and the extra white pixels to
		// accommodate the requested
		// dimensions. For example, if input is 25x25 the QR will be 33x33
		// including the quiet zone.
		// If the requested size is 200x160, the multiple will be 4, for a QR of
		// 132x132. These will
		// handle all the padding from 100x100 (the actual QR) up to 200x160.

		int leftPadding = (outputWidth - (inputWidth * multiple)) / 2;
		int topPadding = (outputHeight - (inputHeight * multiple)) / 2;

		if (leftPadding >= 0) {
			outputWidth = outputWidth - 2 * leftPadding;
			leftPadding = 0;
		}
		if (topPadding >= 0) {
			outputHeight = outputHeight - 2 * topPadding;
			topPadding = 0;
		}

		BitMatrix output = new BitMatrix(outputWidth, outputHeight);

		for (int inputY = 0, outputY = topPadding; inputY < inputHeight; inputY++, outputY += multiple) {
			// Write the contents of this row of the barcode
			for (int inputX = 0, outputX = leftPadding; inputX < inputWidth; inputX++, outputX += multiple) {
				if (input.get(inputX, inputY) == 1) {
					output.setRegion(outputX, outputY, multiple, multiple);
				}
			}
		}

		return output;
	}

	// 测试方法
	public static void main(String[] args) {

		File basepath = new File("d:/aaaa");
		if (!basepath.isDirectory()) {
			basepath.mkdirs();
		}

		Path path = new File(basepath, "11.jpg").toPath();

		ZxingUtil.createQrcode("http://www.baidu.com", "jpg", 70, 70, path);

		Path path2 = new File(basepath, "22.jpg").toPath();

		ZxingUtil.createFullQrcode("http://www.baidu.com", "jpg", 70, 70, path2);
	}

}
