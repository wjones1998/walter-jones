import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	private GradeBook gradebook;
	private GradeBook gradebook2;
	
	@BeforeEach
	void setUp() throws Exception {
		gradebook = new GradeBook(4);
		gradebook2 = new GradeBook(2);
		
		gradebook.addScore(55.6);
		gradebook.addScore(45.6);
		gradebook.addScore(88.0);
		gradebook.addScore(76.0);
		gradebook2.addScore(68.9);
		gradebook2.addScore(100.0);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		gradebook = null;
		gradebook2 = null;
		
	}

	@Test
	public void testAddScore() {
		assertTrue(gradebook.toString().equals("55.6 45.6 88.0 76.0"));
		assertTrue(gradebook2.toString().equals("68.9 100.0"));
	}

	public void testSum() {
		
		
		assertEquals(265.2, gradebook.sum(), .0001);
		assertEquals(168.9, gradebook2.sum(), .0001);
	}

	
	public void testMinimum() {
		
		assertEquals(45.6, gradebook.minimum(), .001);
		assertEquals(68.9, gradebook2.minimum(), .001);
	}
	
	public void finalScore() {
		assertEquals(219.6, gradebook.finalScore(), .001);
		assertEquals(100, gradebook2.minimum(), .001);
	}
}
