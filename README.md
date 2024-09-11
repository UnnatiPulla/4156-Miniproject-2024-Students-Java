# Welcome Students of 4156

Please follow the assignment specifications on Courseworks when completing this project.

Q: How did I get the code coverage report?
A: In order to get the code coverage report, I ran "mvn clean test" within my Individual Project directory (which contains the pom.xml file where we have the configs set up for JaCoCo).
After that, I ran "mvn jacoco:report" within the same directory. This generated the code coverage report in target/site/jacoco. The report is called "index.html". Right click on the "index.html" file in the intellij side bar and click on "Open In" -> Browser. Then, I selected Chrome for me to be able to view the report in a well formatted html page.
