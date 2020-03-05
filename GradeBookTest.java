package wjones;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
 private GradeBook alpha; 
 private GradeBook Bravo;
	
	@BeforeEach
	void setUp() throws Exception {
	 alpha = new GradeBook(5);
		alpha.addScore(90.5);
		alpha.addScore(25.45);
		
		Bravo = new GradeBook(5);
		Bravo.addScore(66.5);
		Bravo.addScore(24.56);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		alpha = null;
		Bravo = null;
	}

	@Test
	void testAddScore() {
	assertTrue((alpha.toString()).equals("90.5 25.45"));
	assertTrue((Bravo.toString()).equals("66.5 24.56"));
		
	assertEquals(2,alpha.getScoreSize());
	assertEquals(2,Bravo.getScoreSize());
		
	}

	@Test
	void testSum() {
		assertEquals(115.95, alpha.sum(), .0001);
		assertEquals(91.06, Bravo.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(25.45, alpha.minimum(),.001);
		assertEquals(24.56, Bravo.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(90.5, alpha.finalScore(), .0001);
		assertEquals(66.5,Bravo.finalScore(), .0001);
	}

	@Test
	void testGetScoresize() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
