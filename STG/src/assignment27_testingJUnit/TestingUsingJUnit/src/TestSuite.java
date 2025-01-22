import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
// for multiple
//@Suite
//@SelectPackages({"test.boothValidator","test.votingValidator"})
//
//public class TestSuite {
//	
//}
/*
 * // for single
 * 
 * @Suite
 * 
 * @SelectPackages("test.boothValidator") public class TestSuite {
 * 
 * }
 */

// perform on all.
//@Suite
//@SelectPackages("test")
//
//public class TestSuite {
//	
//}

@Suite
@SelectPackages("test")
//@IncludePackages("test.boothValidator") // include only this.
//@ExcludePackages("test.boothValidator") // exclude this only.
@IncludeClassNamePatterns(".*Test")
public class TestSuite {
	
}


