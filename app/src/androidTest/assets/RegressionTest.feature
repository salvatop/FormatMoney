Feature: Format Money
	In order to have a decimal string representations of an inputted number
	As a user of the app
	I type a number in the input form and I on click Format to see the outcome displayed

	Background:
		Given I see an empty input form

	Scenario: Input a valid amount of money to format
       	When I input the valid 1600
       	And  I press the format button
    	Then I should see the output message that contains The formatted amount is: 1 600.00

    	When I clear the input form
    	And I input the valid 2310000.158897
        And  I press the format button
        Then I should see the output message that contains The formatted amount is: 2 310 000.16

        When I clear the input form
        And I input the valid -53100.138897
        And  I press the format button
        Then I should see the output message that contains The formatted amount is: -53 150.13

        When I clear the input form
        And I input the valid 0
        And  I press the format button
        Then I should see the output message that contains The formatted amount is: 0.00


	Scenario Outline: Input an invalid amount of money to format
		When I input the invalid <invalidAmount>
		And  I press the format button
		Then I should see the output message that contains 'Only number are allowed'

		Examples:
			 |invalidAmount|
			 |mario|
			 |-2/1|
			 |$1200|
			 |#|
			 |0'00000.00|


