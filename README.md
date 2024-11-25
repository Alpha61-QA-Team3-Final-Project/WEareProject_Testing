# WEare Social Network Project 

### **Overview**
Welcome to the **WEare** Social Network project repository, created as part of our final project at Telerik Academy. This repository provides comprehensive details and reports on the testing of the WEare Social Network project. The social network is designed to connect individuals who can mutually benefit by exchanging skills and services. Users can create posts, comments, and show appreciation through likes.

### **Testing Strategy**
We have adopted the **Agile Scrum methodology**, organizing our work into sprints. Testing activities are structured to cover **UI testing** with **Selenium WebDriver** and **API testing** with **REST Assured** and **Postman**. Performance testing are also a part of our strategy. For more detailed information on our testing approach and strategies, refer to the **TestPlan** file in the **Documents** folder.

### **Repository Structure**
- **Documents**
  Contains the detailed test plan for the project, bug template and test case template.

- **WEare_Postman_API**  
  Includes **Weare_Postman_API** for API testing and **REPORT** folder.

- **WEare_REST_Assured**  
  Includes **REST_Assured** for API testing and **REPORT** folder.

-  **WEareProject_Selenium**  
   Includes **WEareProject_Selenium** for UI testing, **REPORT** and **ALLURE_REPORT** folders.

- **Jira Report**  
  Includes .png reports.

- **Performance Testing**  
  This folder contains statistics of performance testing conducted with **JMeter**.

### **Viewing Jacoco and Newman Reports**
- To view Jacoco reports open .html file in the **REPORT** folders in **WEareProject_Selenium** and - **WEare_REST_Assured**.
- To view Newman report open .html file in the **REPORT** folder in **WEare_Postman_API**.

### **Viewing Allure Reports**
- To view the generated Allure report, follow these steps:
1. Open your terminal;
2. Navigate to the project directory;
3. Run the following command:
**allure serve allure-results**

This command will start a local server and automatically open the Allure report in your browser, displaying details such as passed/failed tests, test history, and more.

Feel free to explore each section to gain a comprehensive understanding of our project's testing and development process.
