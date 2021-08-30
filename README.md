### Introduction

LambdaTest Project has been created for Selenium Advanced Certification.
There are overall 14 Test Scenarios provided in the pdf document.

This test project has been completed with the Help of Java, Selenium and Testng framework.

Dependencies can be checked in the pom.xml file available in the root folder.

This project is completed with the help of PageObject Pattern.
Three classes "LTLandingPagePO, "LTAllIntergrations" and "LTBlog" contain Page objects.

There is a single test class "LTNavigationBasicTest" since all the scenarios are interdependent.

Browser capabilities described in the document are being passed with the help testng.xml file(see Parameter with name="CompleteCapabilties").

**To run this test project** , *testng.xml* should be **modified** to desired *grid url*.
See Parameter with  **name="Grid"**

Since all the tests are running with in a single class, **Parallel execution** is being achieved at test level **NOT** at class level.

**Following are the test case ids:**

1. LoadPage_VerifyPageIsLoaded: (Covering: Scenarios 1 and 2)
 
2. Scroll_To_SeeAllIntegration_VerifyURL: (Covering: Scenarios 3, 4, 5 and 6)
 
3. Scroll_To_CodeLess_VerifySelected: (Covering: Scenario 7)
 
4. Click_On_LearnMore_VerifyTitle: (Covering: Scenarios 8, 9, 10 and 11)
 
5. Navigate_To_Blog: (Covering: Scenario 12)
 
6. Click_On_Community_VerifyTitle: (Covering: Scenario 13)

Scenario 14, "Close the current browser window." is implemented with Test_CleanUp() method with @AfterTest annotation.

In **.gitpod.yml** init is assinged to **mvn test**.
Now whenever gitpod enviorment is started all dependencies will be downloaded and tests described in testng.xml file will start automatically.

For **running** these **tests  in Gitpod dev enviorment** :

1. Open Terminal
2. type *mvn test*
3. hit "Enter"

Regards,

Prateek Bhatnagar
