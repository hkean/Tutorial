package com.github.tutorial.bitwise;

public class BinaryChmod {

	@SuppressWarnings("unused")
	private Integer strToInt(String s, Integer radix) {
		return Integer.parseInt(s, radix);
	}

	private static Integer binaryStrToInt(String binaryStr) {
		return Integer.parseInt(binaryStr, 2);
	}

	public static Boolean getResultByStr(String binaryStrSrc, String binaryStrTar) {
		return getResultByInt(binaryStrToInt(binaryStrSrc), binaryStrToInt(binaryStrTar));
	}

	public static Boolean getResultByInt(Integer binarySrc, Integer binaryTar) {
//		if ((binarySrc & binaryTar) != 0) {
//			return true;
//		} else {
//			return false;
//		}

		return ((binarySrc & binaryTar) != 0) ? Boolean.TRUE : Boolean.FALSE;
	}

}
