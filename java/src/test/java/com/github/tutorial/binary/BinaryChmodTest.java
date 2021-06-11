package com.github.tutorial.binary;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.github.tutorial.bitwise.BinaryChmod;

class BinaryChmodTest {

	@Test
	void testBinaryStrChooseMonByMonTue() {
		String planBinaryStr = "0000011";
		String redeemBinaryStr = "0000001";
		Boolean expected = Boolean.TRUE;
		Boolean actual = BinaryChmod.getResultByStr(redeemBinaryStr, planBinaryStr);

		assertEquals(expected, actual);
	}

	@Test
	void testBinaryStrChooseWedByMonTue() {
		String planBinaryStr = "0000011";
		String redeemBinaryStr = "0000100";
		Boolean expected = Boolean.FALSE;
//		Boolean actual = BinaryChmod.getResultByStr(redeemBinaryStr, planBinaryStr);
		Boolean actual = BinaryChmod.getResultByStr(planBinaryStr, redeemBinaryStr);

		assertEquals(expected, actual);
	}

	@Test
	void testBinaryIntChooseWedByMonTueThuFriSatSun() {
		Integer planBinary = 123;
		Integer redeemBinary = 4;
		Boolean expected = Boolean.FALSE;
		Boolean actual = BinaryChmod.getResultByInt(redeemBinary, planBinary);

		assertEquals(expected, actual);
	}

	@Test
	void testBinaryStrChooseFriByMonWedFri() {
		String planBinaryStr = "0010101";
		String redeemBinaryStr = "0010000";
		Boolean expected = Boolean.TRUE;
		Boolean actual = BinaryChmod.getResultByStr(redeemBinaryStr, planBinaryStr);

		assertEquals(expected, actual);
	}

	@Test
	void testBinaryIntChooseFriByMonWedFri() {
		LocalDate d = LocalDate.of(2021, 2, 26);
		Integer day = d.getDayOfWeek().getValue(); // aka Friday
		Integer planBinary = 21;
		Integer redeemBinary = (int) Math.pow(2, day - 1);
		Boolean expected = Boolean.TRUE;
		Boolean actual = BinaryChmod.getResultByInt(redeemBinary, planBinary);

		assertEquals(expected, actual);
	}

	@Test
	void testBinaryIntChooseThuByMonWedFri() {
		LocalDate d = LocalDate.of(2021, 2, 25);
		Integer day = d.getDayOfWeek().getValue(); // aka Thursday
		Integer planBinary = 21;
		Integer redeemBinary = (int) Math.pow(2, day - 1);
		Boolean expected = Boolean.FALSE;
		Boolean actual = BinaryChmod.getResultByInt(redeemBinary, planBinary);

		assertEquals(expected, actual);
	}

}
