import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	GradeBook g1;
	GradeBook g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		g1.addScore(2);
		g1.addScore(3);
		g1.addScore(4);
		
		g2.addScore(2.9);
		g2.addScore(2.4);
		g2.addScore(3);
		g2.addScore(4);
		g2.addScore(5);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		g1= g2 = null;
	}

	@Test
	void testAddScore(){
		assertEquals(3, g1.getScoreSize());
		assertTrue("2.9 2.4 3.0 4.0 5.0".equals(g2.toString()));
	}
	
	@Test
	void testSum(){
		assertEquals(9,g1.sum());		
	}
	
	@Test
	void testMinimum(){
		assertEquals(2.4,g2.minimum());		
	}

	@Test
	void testFinalScore(){
		assertEquals(7,g1.finalScore());
		assertEquals(14.9,g2.finalScore());
	}
}
