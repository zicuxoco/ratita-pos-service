# ratita-pos-service
Rest Web Service for ratitaPos

This branch was created for run Sonar and JAcoco and obtain the code coverage

# Use of the branch
In Git console, you can type ./gradlew (or gradle) tasks for see that the project have the correct configuration for all the tasks and that the jacocoTest and sonarqube tasks; after of that we will found the results in the build folder and the results on Sonar web page server.
For to execute the Jacoco test use 'gradle test jacocoTestReport' and see into of build/reports/jacoco
For sonar you can to execute 'gradle sonarqube --stacktrace' and see in the sonar page you sonar an jacoco report

# Motivation
I decided to use Jacoco instead of Clover (from attlassian) or Cobertura for differents reasons

1. Clover is a very good tool for code coverage and for default is used in Bamboo, unfortunaly there are not yet good support for JUnit, specifically with @Rules (One of the wonderfull things that JUnit 4.* has) and sometimes (this happened to me) the support for Java 8 is not good (again, for me!)
2. Cobertura does not have a good integration with Bamboo and my aim is to use Bamboo for CI; other thing is that this one not have good integration with Gradle
3. Jacoco is by default used by Sonar and the integration is good, Jacoco can inspect @Rules without problems; however and here is the point 4!
4. I've been loogking for some days and the information about of the configuration between Jacoco-Sonar-Java 8-Bamboo is very limited

I finally got integrate these beatiful tools and this is the result, the greatest difficulty was to know which were the correct tools and versions, you know, there exist SonarQube, Sonar, SonarRunner and Jacoco versions that not support Java 1.8

Anyway, this is the resut Enjoy it!!


