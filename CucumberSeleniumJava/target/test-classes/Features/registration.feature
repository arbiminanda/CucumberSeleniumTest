Feature: Registration

	Scenario Outline: User melakukan registrasi dengan mengisi seluruh field hingga berhasil
		Given New User is on Log In and Sign Up Page from PS Enterprise Gameshop Apps
		When User choose one of Favorite Genre from dropdown list
		When User choose one of Favorite Console from dropdown list
		When User choose one of Hobbies & Interests from dropdown list
		When User choose one of Gender from two radiobuttons
		When User fill a valid <email> address
		When User fill a valid <password> that contain at least nine characters
		When User fill the same <password> in confirm password field
		When User click the Register button
		Then User get info 'Thank you for registering. Your account has to be activated before you can login. Please check your email.'
		
	Examples:
		|email|password|
		|testing26@goo.co|dsahjjs123452|
		
	Scenario Outline: User melakukan registrasi dengan email yang telah ter-registrasi
		Given New User is on Log In and Sign Up Page from PS Enterprise Gameshop Apps
		When User choose one of Favorite Genre from dropdown list
		When User choose one of Favorite Console from dropdown list
		When User choose one of Hobbies & Interests from dropdown list
		When User choose one of Gender from two radiobuttons
		When User fill a valid <email> address
		When User fill a valid <password> that contain at least nine characters
		When User fill the same <password> in confirm password field
		When User click the Register button
		Then User get error message 'Error: An account is already registered with your email address.'
		
	Examples:
		|email|password|
		|testing1@goo.co|dsahjjs123452|
