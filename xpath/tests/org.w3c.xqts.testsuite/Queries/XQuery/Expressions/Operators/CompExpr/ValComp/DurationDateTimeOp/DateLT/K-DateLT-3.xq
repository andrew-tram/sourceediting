(:*******************************************************:)
(: Test: K-DateLT-3                                      :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:37+02:00                       :)
(: Purpose: Simple test of 'lt' for xs:date.             :)
(:*******************************************************:)
not(xs:date("2004-07-13") lt
			       xs:date("2004-07-13"))