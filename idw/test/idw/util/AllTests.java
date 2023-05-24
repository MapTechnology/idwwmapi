package idw.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
	FormulasInjetTest.class,
	EqualsBuilderIdwTest.class,
	HashCodeBuilderIdwTest.class,
	SQLUtilsTest.class})
public class AllTests {
}
