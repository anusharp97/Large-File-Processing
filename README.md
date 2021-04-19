## Large-File-Processing
### Section a: Steps to run the code

``git clone https://github.com/anusharp97/Large-File-Processing.git ``

``docker-compose up``

Redirect to the http://localhost:8080/h2-console/ to access in-memory h2 database. 
![image](https://user-images.githubusercontent.com/35512779/115274177-081c4400-a15e-11eb-9bd4-53a982873dce.png)

Table "Product" can be seen filled with a sample of 1000 records read from products.csv file.

### Section b: Details of the teables created
JPA has been used for creation of tables, that takes care of queries needed to create them.

Table 1: Product

| ID    | SKU           | NAME    | DESCRIPTION   |
| ------|:-------------:| -------:|--------------------------------------------------------------------------------------------------:|
| 1     | lay-raise-best-end | Bryce Jones  | Art community floor adult your single type. Per back community former stock thing.      |
| 2     | cup-return-guess     |   John Robinson  |    Produce successful hot tree past action young song. Himself then tax eye little last state vote. Country down list that speech economy leave. |
| 3     | step-onto     |    Theresa Taylor  | 	Choice should lead budget task. Author best mention.Often stuff professional today allow after door instead. Model seat fear evidence. Now sing opportunity feeling no season show.|
| 4     | citizen-some-middle| Roger Huerta | Important fight wrong position fine. Friend song interview glass pay. Organization possible just.|
| 5     |term-important | John Buckley | 	Alone maybe education risk despite way.Want benefit manage financial story term must. Former wife activity firm example|
| 6     | do-many-avoid | Tiffany Johnson | Born tree wind.Boy marriage begin value. Record health laugh ask under notice federal. Hard lose need sell treatment.|

Table 2: ProductCount
| Name   | NoOfProducts      |
| ------------- |:-------------:| 
| Aaron Miller     | 2| 
| Abigail Rodriguez | 1      | 
| Maria Richard | 4      | 

### Section c: Points Achieved
##### 1. Follows the OOPS concepts
In order to allow update the products based on sku, react based frontend is developed, which can be accessed at http://localhost:4200. Based on the sku entered, next page will display the records with the entered sku name, then the user can select the record that needs to be updated.


