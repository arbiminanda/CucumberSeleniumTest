Feature: Forgot Password

	Scenario: User melakukan permohonan reset password akun
		Given User is on Main Screen from PS Enterprise Gameshop Apps
		When User click Lost Your Password button
		Then User is on Lost Password Page
		When User fill the registered email
		When User click Reset Password button
		Then User get info 'Password reset email has been sent'