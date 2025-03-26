Feature: Search and place order for search products

Scenario: Smart search in home and offer page

Given User is in greencart page
When user search with smart search with three letter "tom" of product and extracted product
Then user search with smart search with three letter "tom" of product in offer page
And Check whether smart search letter matches with product 


Scenario Outline: Smart search in home and offer page

Given User is in greencart page
When user search with smart search with three letter <name> of product and extracted product
Then user search with smart search with three letter <name> of product in offer page
And Check whether smart search letter matches with product 

Examples:
|name |
|tom  |