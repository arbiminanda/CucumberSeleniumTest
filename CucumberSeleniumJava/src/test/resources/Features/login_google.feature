Feature: Login Google

  Scenario Outline: User melakukan login dengan menggunakan akun google lain yang belum login
    Given User is on Log In and Sign Up Page from PS Enterprise Gameshop App
    When User click Login With Google button
    Then User is on Google Email Log In page
    When User fill a valid and registered google <email>
    When User click Next button
    Then User is on Google Password Log In Page
    When User fill a correct <password>
    When User click Next button
    Then User is on Detail My Account Page from Apps

    Examples: 
      | email                 | password |
      | arbiminanda10@gmail.com | ******* |
