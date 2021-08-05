# planit-assessment-jupitertoys

Test Assessment questions and answers
1. What other possible scenario’s would you suggest for testing the Jupiter Toys application? 
	 a. Validate checkout functionality usinf Checkout button in Cart page
   b. Validate empting cart usinf Empty cart button in cart page
   c. Validate Actions button in Cart page
   d. Validate Start Shopping button in home page
   e. Validate login credentials using login page

2. Jupiter Toys is expected to grow and expand its offering into books, tech, and modern art. We are expecting the of tests will grow to a very large number. 1. What approaches could you used to reduce overall execution time? 
    a. Parrallel test execution
    b. Segregating tests to acheive better results through remote exxcution setup and CI/CD pipeline
    c. Use only Explicit wait times and fast selectors in test scripts
    c. Reduce the build time(if case of java projects)
    
  4. How will your framework cater for this? 
    The current framework already supports parrallel execution, implementing in CI/CD pipeline and avoids implicit waits. Implementing hybid framework that handles both data and page object oriented structure.
      
3. Describe when to use a BDD approach to automation and when NOT to use BDD
    When to use BDD,
      a. Verifying the most important parts of the application using end-to-end tests
      b. Business analyst or product owner involved in cretaed the BDD files
      c. Long term projects with mutiple systems and interations
    When not to use BDD,
      a. Project with limited impovement by business analyst towards test scripts 
      b. In Agile projects the test planning having much shorter time where it's difficult to implement BDD approach
      c. Time overhead, Creating and maintaining the feature files and scenarios requires an overhead investment of time and effort.
     
