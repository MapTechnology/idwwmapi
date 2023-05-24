package idw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
	idw.model.pojos.AllTests.class,
	idw.model.rn.imp.injet.AllTests.class,
	idw.util.EqualsBuilderIdwTest.class,
	idw.model.rn.DataHoraRNTest.class})
public class AllTests {
}
