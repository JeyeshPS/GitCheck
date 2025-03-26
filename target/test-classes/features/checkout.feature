
Feature: Adding vegetable to the cart

  
  Scenario: check user is able to add to card and checkout
  
  Given User should able to search and select the product "carrot" in the homepage
  When user should able to select the required quantity 4 usign plus symbol
  Then User added items to the cart using add to cart option
  And post addition check the button is changed to orange color and button changed to added
  
  
  
	#Scenario: verify card items is able to checkout
  
  Given Click on the cart and proceed to checkout
  When added details should reflect in the cart
  Then validate the product name "carrot" and quantity 4 and price and total
  And validate whether Apply and place order button is displayed
  
  


