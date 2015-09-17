package headfirst.decorator.io;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LowerCaseInputStreamTest {
	private InputStream stream;
	private String test ;
	
	@Before
	public void setUp() throws Exception {
		test = "HELLO MY NAME IS GAVAN";
		stream = new LowerCaseInputStream(
				new StringBufferInputStream(test));
	}

	@After
	public void tearDown() throws Exception {
		stream.close();
	}

	@Test
	public void testRead() {
		int i =0;
		String disp = "";
		try {
			for(i = 0; i < test.length(); i++){
				char c = (char)stream.read();
				disp = disp + c;
			}
			assertEquals("hello my name is gavan", disp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	@Test
	public void testReadByteArrayIntInt() {
		byte[] array = test.getBytes();
		try {
			stream.read(array, 0, array.length);
			String disp = new String(array);
			assertEquals("hello my name is gavan", disp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
