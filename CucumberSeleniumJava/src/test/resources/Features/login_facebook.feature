Feature: Login Facebook
  
  Scenario: User melakukan login dengan menggunakan akun facebook
    Given User is on Main Screen from PS Enterprise Gameshop App
		When User click Login With Facebook button
		Then User is on facebook login page
		When User fill the email from facebook account
		When User fill the correct password
		When User click on Facebook Log In Button
		Then User is on My Account Detail Page
