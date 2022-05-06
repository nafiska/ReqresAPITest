# SeleniumUIAutomation

								=======================
								Framework Architecture:
								=======================

Project - Maven
Framework - RESTAssured
Language - Java
Test Executions - JUnit (or) maven test
Reports - Cucumber Report - {rootfolder}\target\cucumber-reports\index.html
Extent/Spark/Logger reports -  {rootfolder}\test-output\HtmlReport\ExtentHtml.html
{rootfolder}\test-output\Spark\Index.html
{rootfolder}\test-output\Logger\*.html

Editor - Eclipse

=================
Folder Structure
=================
src/main/java - POJO Classes (Request & Response) and also Request & Responses are written inside java file

src/main/resources - contains properties file and log4j.xml file

src/test/java - Runner and Step Definition File

src/test/resources - Contains Feature Files

pom.xml - contains dependencies,plugins,etc

===========
Executions:
===========
=======
Junit
=======
For running test:
 Right click on src/test/java/com.runners/APITestRunner.java and Run As-> JUnit Test
	(OR)
 Right click on project -> pom.xml and Run As-> Maven build.. -> Goals (clean test -D test=<runner file> test)
