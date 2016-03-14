# ratita-pos-service
Rest Web Service for ratitaPos

This is a demo that contains a little Rest API, basically the API is a Offers provider, this WS have a differents levels of permissions, some users can access only for see the offers, another one can to request a more detail offers and other (the administrator) can modify the offers, offer to other customers this one offers, etc

This project was built using Test driven development(TDD) creating a suite of Functional test, Unit test (in the future Integration test)

actually the web services and endpoints only are a test case, I mean, this is not alocated in any server, but all the test cases run on the web service and endpoints

# Tools
For the construction of this project I used:
  Java 1.8 (with all the charectics that this have): Though I have used in a lot of time different frameworks like Spring (wonderful tool for the development of web services) for over a year I prefer using all the power of Java 8, my perception is that the proccess, the code, goes much more rapid beside I liking very much the improvements that have done to java 8, you know lambda expressions, interface so powerfull, etc.
  Gradle: I always love Maven, I felt comfortable; the reality is that gradle is much more easy, all the configurations, the dependencies, the builds proccess; the execution of tasks is staggeringly easy and very intuitive. There are some problems with the integrations of some tools like Jacoco and SonarQube, but this can be resolved with a little patiente.
  JUnit 4.12
  Mockito: that is the tool for make mocks in my code
  Hamcrest 2.0: this is a great tool for custom we asserts and I think has a quite a hold on with Mockito, please take a look of the class Matchers, this is a very good class for to evaluate any object into of Java/Junit
  Apache tools.
  Sonar: complete suite for quality of code
  Jacoco: thats support completly Jaca 8 and @Rules Junit and by default is the code coverage tool for sonar
  
# Quality code and Code coverage
  I created a branch and you can take a look of this, the branch is ratita-pos-service-sonar-bamboo, here I have implemented Sonar and Jacoco, you can test it with gradle (./gradlew if you prefer) tasks for see if all is good, you can see in "other tasks" the task jacocoTestReport, you can execute this and see the report in buil/reports/jacoco
  For the use of Sonar you need to set your server and database, actually in "build.properties" files not is setted the host because this can setted in a Job into of bamboo of Jenkins, I mean in an environment of CI
  
  this is a screenshot of the code coverage, but you can see direcly in the branch above and geterate it
  
  ![alt tag]
  
  # CheckStyle
  I included a cehckStyle module, this is called into of gradle and execute the rules contained in checkStyle.xml
  
