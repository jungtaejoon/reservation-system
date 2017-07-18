package kr.or.reservation.jdbc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class MokitoTest {

	@Test
	public void MokiTest() {
		// mock
		List mockedList = mock(List.class);

		// mock 사용하기
		mockedList.add("one");
		mockedList.clear();

	}
}
