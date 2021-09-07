Feature: Login Manual

	Scenario Outline: User melakukan login manual hingga berhasil tanpa menggunakan fitur Remember Me
    Given User is on Log In and Sign Up Page from PS Enterprise Gameshop Apps
		When User fill the registered and verified <email> on the login email field
		When User fill the correct <password> on the login password field
		When User click on Log In Button
		Then User is on My Account Page from Apps
		
	Examples:
	|email|password|
	|arbiminanda10@gmail.com|*******|
	
	Scenario Outline: User melakukan login manual hingga berhasil dengan menggunakan fitur Remember Me
    Given User is on Log In and Sign Up Page from PS Enterprise Gameshop Apps
		When User click on Remember Me checklist box button
		When User fill the registered and verified <email> on the login email field
		When User fill the correct <password> on the login password field
		When User click on Log In Button
		Then User is on My Account Page from Apps
		
	Examples:
	|email|password|
	|arbiminanda10@gmail.com|*******|