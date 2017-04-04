package pl.sda.spring2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FileProcessorTest {

	@Test
	public void deleteTest() {
		assertEquals(true, new FileProcessor().delete());
	}
	
	@Test
	public void getTest() {
		new FileProcessor().delete();
		new FileProcessor().save("dupa jasiu");
		List<String> list = new ArrayList<String>();
		list.add("dupa jasiu");
		assertEquals(list, new FileProcessor().get());
	}
	
	@Test
	public void postTest() {
		assertEquals(true, new FileProcessor().delete());
		assertEquals(true, new FileProcessor().save("dupa jasiu"));
		assertEquals(true, new FileProcessor().save("pierdzi stasiu"));
		List<String> list = new ArrayList<String>();
		list.add("dupa jasiu");
		list.add("pierdzi stasiu");
		assertEquals(list, new FileProcessor().get());
	}
}
