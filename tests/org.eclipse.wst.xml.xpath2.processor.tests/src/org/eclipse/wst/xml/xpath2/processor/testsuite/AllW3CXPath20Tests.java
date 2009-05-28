package org.eclipse.wst.xml.xpath2.processor.testsuite;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllW3CXPath20Tests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for W3C XPath 2.0 test suite.");
		//$JUnit-BEGIN$
		suite.addTestSuite(NumericUnaryPlusTest.class);
		suite.addTestSuite(SequenceTypeSyntaxTest.class);
		suite.addTestSuite(SeqUnionTest.class);
		suite.addTestSuite(NumericGTTest.class);
		suite.addTestSuite(DateTimeAddDTDTest.class);
		suite.addTestSuite(gDayEQTest.class);
		suite.addTestSuite(TimeSubtractTest.class);
		suite.addTestSuite(DateEQTest.class);
		suite.addTestSuite(SeqIntersectTest.class);
		suite.addTestSuite(CombNodeSeqTest.class);
		suite.addTestSuite(DayTimeDurationDivideDTDTest.class);
		suite.addTestSuite(SeqExceptTest.class);
		suite.addTestSuite(BooleanLTTest.class);
		suite.addTestSuite(NodeSameTest.class);
		suite.addTestSuite(QNameEQTest.class);
		suite.addTestSuite(NumericMultiplyTest.class);
		suite.addTestSuite(DayTimeDurationGTTest.class);
		suite.addTestSuite(gMonthDayEQTest.class);
		suite.addTestSuite(DateSubtractDTDTest.class);
		suite.addTestSuite(AxesTest.class);
		suite.addTestSuite(GenCompEqTest.class);
		suite.addTestSuite(NodeTestTest.class);
		suite.addTestSuite(BooleanEqualTest.class);
		suite.addTestSuite(TimeAddDTDTest.class);
		suite.addTestSuite(TimeEQTest.class);
		suite.addTestSuite(YearMonthDurationAddTest.class);
		suite.addTestSuite(DayTimeDurationAddTest.class);
		suite.addTestSuite(InternalContextExprTest.class);
		suite.addTestSuite(dateTimesSubtractTest.class);
		suite.addTestSuite(DayTimeDurationMultiplyTest.class);
		suite.addTestSuite(gYearEQTest.class);
		suite.addTestSuite(AbbrAxesTest.class);
		suite.addTestSuite(DateTimeSubtractDTDTest.class);
		suite.addTestSuite(NumericSubtractTest.class);
		suite.addTestSuite(DayTimeDurationDivideTest.class);
		suite.addTestSuite(YearMonthDurationLTTest.class);
		suite.addTestSuite(NumericLTTest.class);
		suite.addTestSuite(NameTestTest.class);
		suite.addTestSuite(NumericDivideTest.class);
		suite.addTestSuite(NodeAfterTest.class);
		suite.addTestSuite(YearMonthDurationSubtractTest.class);
		suite.addTestSuite(RangeExprTest.class);
		suite.addTestSuite(BooleanGTTest.class);
		suite.addTestSuite(DateSubtractYMDTest.class);
		suite.addTestSuite(LiteralsTest.class);
		suite.addTestSuite(TimeGTTest.class);
		suite.addTestSuite(TimeSubtractDTDTest.class);
		suite.addTestSuite(DateTimeLTTest.class);
		suite.addTestSuite(YearMonthDurationMultiplyTest.class);
		suite.addTestSuite(GenCompLTEQTest.class);
		suite.addTestSuite(GenCompLTTest.class);
		suite.addTestSuite(NodeBeforeTest.class);
		suite.addTestSuite(gYearMonthEQTest.class);
		suite.addTestSuite(DateTimeGTTest.class);
		suite.addTestSuite(YearMonthDurationDivideTest.class);
		suite.addTestSuite(PrefixFromQNameTest.class);
		suite.addTestSuite(GenCompNETest.class);
		suite.addTestSuite(DateLTTest.class);
		suite.addTestSuite(NumericAddTest.class);
		suite.addTestSuite(commaOpTest.class);
		suite.addTestSuite(NumericIntegerDivideTest.class);
		suite.addTestSuite(Base64BinaryEQTest.class);
		suite.addTestSuite(FilterExprTest.class);
		suite.addTestSuite(YearMonthDurationDivideYMDTest.class);
		suite.addTestSuite(PredicatesTest.class);
		suite.addTestSuite(YearMonthDurationGTTest.class);
		suite.addTestSuite(ExternalContextExprTest.class);
		suite.addTestSuite(DayTimeDurationLTTest.class);
		suite.addTestSuite(NumericModTest.class);
		suite.addTestSuite(LogicExprTest.class);
		suite.addTestSuite(DateGTTest.class);
		suite.addTestSuite(DateTimeSubtractYMDTest.class);
		suite.addTestSuite(DurationEQTest.class);
		suite.addTestSuite(GenCompGTTest.class);
		suite.addTestSuite(NumericEqualTest.class);
		suite.addTestSuite(TimeLTTest.class);
		suite.addTestSuite(DatesSubtractTest.class);
		suite.addTestSuite(HexBinaryEQTest.class);
		suite.addTestSuite(DateAddDTDTest.class);
		suite.addTestSuite(DayTimeDurationSubtractTest.class);
		suite.addTestSuite(NumericUnaryMinusTest.class);
		suite.addTestSuite(YearMonthDurationAddDTTest.class);
		suite.addTestSuite(gMonthEQTest.class);
		suite.addTestSuite(DateAddYMDTest.class);
		suite.addTestSuite(ParenExprTest.class);
		suite.addTestSuite(UnabbrAxesTest.class);
		suite.addTestSuite(DateTimeEQTest.class);
		suite.addTestSuite(GenCompGTEQTest.class);
		//$JUnit-END$
		return suite;
	}

}
