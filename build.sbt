name := "scala-bwt"

version := "1.0"

scalaVersion := "2.9.2"

testOptions := Seq(Tests.Filter(s => Seq("Spec", "Unit").exists(s.endsWith(_))))

testOptions in Test += Tests.Argument("html", "console")
