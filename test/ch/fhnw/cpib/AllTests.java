package ch.fhnw.cpib;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ LexerContextTest.class, PositionTest.class,
		TokenRecognitionTest.class, TokenTypeTest.class })
public class AllTests {

}
