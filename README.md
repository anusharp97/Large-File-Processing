## Large-File-Processing

Visit the problem statement [here](https://docs.google.com/document/d/1RJjQHDxi7jOQVOq8lrkUFPVJO5vnozPRGO-bpzx13wM/edit#)

- Framework
  - Backend: Springboot
  - Frontend: React
- Database - in memory H2 database

### Section a: Steps to run the code

``git clone https://github.com/anusharp97/Large-File-Processing.git ``

``docker-compose up``

Redirect to the http://localhost:8080/h2-console/ to access in-memory h2 database. 
![image](https://user-images.githubusercontent.com/35512779/115274177-081c4400-a15e-11eb-9bd4-53a982873dce.png)

Table "Product" can be seen filled with a sample of 1000 records read from products.csv file.

### Section b: Details of the tables created
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
| John Robinson| 1|
| Bryce Jones | 2|
| Tiffany Johnson| 1|


### Section c: Points Achieved
1. OOPS concept followed.
2. Batch processing has been implmented with the chunk size of 100 rows.
3. Support has been provided to update existing products based on sku.
  - Workaround followed: 
    - React based front end is developed where in a user can fetch products with given sku name resulting in resultRecords, and then allows user to update a record from resultRecords. 
    - Frontend can be accessed at http://localhost:4200. Based on the sku entered, next page will display the records with the entered sku name, then the user can select the record that needs to be updated.
4. All product details are ingested in single table named "Product".
5. "ProductCount" table is created with the result of aggregated query run on "Product" to fetch number of products with the same name.

### Section d: Points Not Achieved
5. Although "ProductCount" table is created, data inside won't be reliable once the product records are updated by the user.
    - If I do so, it'd result in tightly coupling data layer with UI, which would be a poor architecture.
    - It also means one cannot be changed without changing the other.

### Section e: Imporovements
- Parallel Processing can be explored for the given data set, to reduce processing time even further.
