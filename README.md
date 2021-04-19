## Large-File-Processing
### Section a: Steps to run the code

``git clone https://github.com/anusharp97/Large-File-Processing.git ``

``docker-compose up``

Redirect to the http://localhost:8080/h2-console/ to access in-memory h2 database. Table "Product" can be seen filled with a sample of 1000 records read from products.csv file
![image](https://user-images.githubusercontent.com/35512779/115274177-081c4400-a15e-11eb-9bd4-53a982873dce.png)
In order to allow update the products based on sku, react based frontend is developed, which can be accessed at http://localhost:4200. Based on the sku entered, next page will display the records with the entered sku name, then the user can select the record that needs to be updated.


