# Amazon clone back-end

This project was inspired by the same project the youtube's channel Clever Programmer did in one week.

It has a purpose to improve my knowledge on Java Spring Boot.

The main url for this project is: https://myownamazonclone.herokuapp.com/

For instance, if you would like to show all users, your url will be: https://myownamazonclone.herokuapp.com/users/

***Table of Contents***

[Show All Users](#show-all-users)

[Show User](#show-users)

[Login User](#login-user)

[Add User](#add-user)

[Update User](#update-user)

[Delete User](#delete-user)

[Show all Products](#show-all-products)

[Show Product](#show-product)

[Add Product](#add-product)

[Update Product](#update-product)

[Delete Product](#delete-product)

[Show Cart Items](#show-cart-items)

[Add Cart Item](#add-cart-item)

[Update Cart Item](#update-cart-item)

[Delete Cart Item](#delete-cart-item)

**Show All Users**
----
  Returns a list of json data about all users registered on database.

* **URL**

  /users/

* **Method:**

  `GET`
  
*  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"},
    {"cpf":"12345678913","name":"Test 2","birthday":"1970-07-21T00:00:00.000+00:00","sex":"F","address":"Address 2","nbr":43,"city":"Ponta Grossa","state":"Paraná","country":"Brasil","email":"test2@email.com","password":"123467"}]`
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.get('/users/')
      .then(function(response) {
        console.log(response.data)
      })
  ```

[Back To The Top](#amazon-clone-back-end)

**Show User**
----
  Returns json data about a single user registered on database.

* **URL**

  /users/:cpf

* **Method:**

  `GET`
  
* **URL Params**

   **Required:**
 
   `cpf=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"}`
 
* **Error Response:**
  * **Reason:** CPF informed not found in database. <br />
      **Content:** `{}`

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.get(`/users/${cpf}`)
      .then(function(response) {
        const user = response.data
        if(user !== null)
          console.log(user)
      })
  ```

[Back To The Top](#amazon-clone-back-end)

**Login User**
----
  Returns json data about a the user logged in.

* **URL**

  /users/:email/:password

* **Method:**

  `GET`
  
* **URL Params**

   **Required:**
 
   `email=[string]`

   `password=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"}`
 
* **Error Response:**
  * **Reason:** E-mail or password informed are not matched in database. <br />
      **Content:** `{}`

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.get(`/users/${email}/${password}`)
      .then(function(response) {
        const user = response.data
        if(user !== null)
          console.log(user)
      })
  ```

[Back To The Top](#amazon-clone-back-end)

**Add User**
----
  Returns json data about the user registered in database.

* **URL**

  /users/add/

* **Method:**

  `POST`
  
* **Data Params**

   **Required:**
   
  `cpf: [only 11 number digits]`

  `name: [name of the user]`

  `birthday: [YYYY-MM-DD]`

  `sex: [M (Male) or F (Female) or O (Other)]`

  `address: [street's name]`

  `nbr: [address's number]`

  `city: [user's city]`

  `state: [user's state]`

  `country: [user's country]`
  `email: [user's e-mail]`

  `password: [user's password]`
 
  `email=[string]`

  `password=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"}`
 
* **Error Response:**
  
  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.post('/users/add/', {
                cpf,
                name,
                birthday,
                sex,
                address,
                nbr,
                city,
                state,
                country,
                email,
                password
            }).then(function(response) {
                const user = response.data
                if(user !== null)
                  console.log(user)
            }
  ```

[Back To The Top](#amazon-clone-back-end)

**Update User**
----
  Returns json data about the user updated in database.

* **URL**

  /users/update/:cpf

* **Method:**

  `PUT`

*  **URL Params**

   **Required:**
 
   `cpf=[only 11 number digits]`
  
* **Data Params**

   **Required:**
   
  `cpf: [only 11 number digits]`

  `name: [name of the user]`

  `birthday: [YYYY-MM-DD]`

  `sex: [M (Male) or F (Female) or O (Other)]`

  `address: [street's name]`

  `nbr: [address's number]`

  `city: [user's city]`

  `state: [user's state]`

  `country: [user's country]`
  `email: [user's e-mail]`

  `password: [user's password]`
 
  `email=[string]`

  `password=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"}`
 
* **Error Response:**
  * **Reason:** User's CPF is not found in database <br />
      **Content:** `{}`
  
  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.put('/users/update/', {
                cpf,
                name,
                birthday,
                sex,
                address,
                nbr,
                city,
                state,
                country,
                email,
                password
            }).then(function(response) {
                const user = response.data
                if(user !== null)
                  console.log(user)
            }
  ```

[Back To The Top](#amazon-clone-back-end)

**Delete User**
----
  Returns json data about a single user deleted in database.

* **URL**

  /users/delete/:cpf

* **Method:**

  `DELETE`
  
* **URL Params**

   **Required:**
 
   `cpf=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"}`
 
* **Error Response:**
  * **Reason:** CPF informed not found in database. <br />
      **Content:** `{}`

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.delete(`/users/delete/${cpf}`)
      .then(function(response) {
        const user = response.data
        if(user !== null)
          console.log(user)
      })
  ```

[Back To The Top](#amazon-clone-back-end)

**Show All Products**
----
  Returns a list of json data about all products registered on database.

* **URL**

  /products/

* **Method:**

  `GET`
     
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{"nbr":4,"title":"New Apple iPad Pro","image":"https://images-na.ssl-images-amazon.com/images/I/81SGb5l%2BlZL._AC_SX342_.jpg","quantity":7,"rating":5,"price":1449.0},
    {"nbr":14,"title":"Seagate Portable 2TB External Hard Drive","image":"https://images-na.ssl-images-amazon.com/images/I/31jBba7+ySL.jpg","quantity":3,"rating":4,"price":60.0},
    {"nbr":24,"title":"Roku Express | HD Streaming Media Player","image":"https://images-na.ssl-images-amazon.com/images/I/41Y15o6btZL.jpg","quantity":3,"rating":4,"price":25.0}]`
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.get('/products/')
      .then(function(response) {
        console.log(response.data)
      })
  ```

[Back To The Top](#amazon-clone-back-end)

**Show Product**
----
  Returns a json data about a product registered on database.

* **URL**

  /products/:nbr

* **Method:**

  `GET`

* **URL Params**

   **Required:**
 
   `nbr=[integer]`
     
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"nbr":4,"title":"New Apple iPad Pro","image":"https://images-na.ssl-images-amazon.com/images/I/81SGb5l%2BlZL._AC_SX342_.jpg","quantity":7,"rating":5,"price":1449.0}`
 
* **Error Response:**
  * **Reason:** nbr informed not found in database. <br />
    **Content:** `{}`
  
  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.get(`/products/${nbr}`)
      .then(function(response) {
        const product = response.data
        console.log(product)
      })
  ```

[Back To The Top](#amazon-clone-back-end)

**Add Product**
----
  Adds product object from json data to database.

* **URL**

  /products/add/

* **Method:**

  `POST`
  
* **Data Params**

   **Required:**
   
    `title: [Title that announces the product]`

    `image: [The image's url of the product]`

    `quantity: [It quantifies the amount of objects of its product]`

    `rating: [It quantifies the grade that the users give to the product]`

    `price: [It is a number with float point that quantifies the unit price of the product]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"nbr":4,"title":"New Apple iPad Pro","image":"https://images-na.ssl-images-amazon.com/images/I/81SGb5l%2BlZL._AC_SX342_.jpg","quantity":7,"rating":5,"price":1449.0}`
 
* **Error Response:**
  
  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.post('/products/add/', {
        title,
        image,
        quantity,
        rating,
        price
    }).then(function(response) {
        const product = response.data
        if(product !== null)
          console.log(product)
      }
  ```

[Back To The Top](#amazon-clone-back-end)

**Update product**
----
  Updates product registration from database.

* **URL**

  /products/update/:nbr

* **Method:**

  `PUT`

*  **URL Params**

   **Required:**
 
   `nbr=[integer]`
  
* **Data Params**

   **Required:**
    
    `nbr: [number that identifies the product]`
   
    `title: [Title that announces the product]`

    `image: [The image's url of the product]`

    `quantity: [It quantifies the amount of objects of its product]`

    `rating: [It quantifies the grade that the users give to the product]`

    `price: [It is a number with float point that quantifies the unit price of the product]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"nbr":4,"title":"New Apple iPad Pro","image":"https://images-na.ssl-images-amazon.com/images/I/81SGb5l%2BlZL._AC_SX342_.jpg","quantity":7,"rating":5,"price":1449.0}`
 
* **Error Response:**
  * **Reason:** Product's nbr is not found in database <br />
      **Content:** `{}`
  
  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.put('/products/update/', {
      nbr,
      title,
      image,
      quantity,
      rating,
      price
      }).then(function(response) {
          const product = response.data
          if(product !== null)
            console.log(product)
      }
  ```

[Back To The Top](#amazon-clone-back-end)

**Delete Product**
----
  Deletes a single product from database.

* **URL**

  /products/delete/:nbr

* **Method:**

  `DELETE`
  
* **URL Params**

   **Required:**
 
   `nbr=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"nbr":4,"title":"New Apple iPad Pro","image":"https://images-na.ssl-images-amazon.com/images/I/81SGb5l%2BlZL._AC_SX342_.jpg","quantity":7,"rating":5,"price":1449.0}`
 
* **Error Response:**
  * **Reason:** nbr informed not found in database. <br />
      **Content:** `{}`

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.delete(`/products/delete/${nbr}`)
      .then(function(response) {
        const product = response.data
        if(product !== null)
          console.log(product)
      })
  ```

[Back To The Top](#amazon-clone-back-end)

**Show Cart Items**
----
  Returns a list of json data about cart items registered on database from a single user.

* **URL**

  /cartitems/:cpf

* **Method:**

  `GET`

* **URL Params**

   **Required:**
 
   `cpf=[only 11 number digits]`
     
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{"id":{"cpf":"12345678912","nbr":4},"user":{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"},"product":{"nbr":4,"title":"New Apple iPad Pro","image":"https://images-na.ssl-images-amazon.com/images/I/81SGb5l%2BlZL._AC_SX342_.jpg","quantity":7,"rating":5,"price":1449.0},"quantity":7},{"id":{"cpf":"12345678912","nbr":14},"user":{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"},"product":{"nbr":14,"title":"Seagate Portable 2TB External Hard Drive","image":"https://images-na.ssl-images-amazon.com/images/I/31jBba7+ySL.jpg","quantity":3,"rating":4,"price":60.0},"quantity":3}]`
 
* **Error Response:**
  * **Reason:** cpf or nbr informed not found in database. <br />
    **Content:** `{}`
  
  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.get(`/cartitems/${cpf}`)
      .then(function(response) {
        const cartitems = response.data
        console.log(cartitems)
      })
  ```

[Back To The Top](#amazon-clone-back-end)

**Add Cart Item**
----
  Adds cart item object from json data to database.

* **URL**

  /cartitems/add/:cpf/:nbr

* **Method:**

  `POST`

* **URL Params**

   **Required:**
 
   `cpf=[only 11 number digits that identifies the user]`

   `nbr=[number that identifies the product]`
  
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"id":{"cpf":"12345678912","nbr":4},"user":{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"},"product":{"nbr":4,"title":"New Apple iPad Pro","image":"https://images-na.ssl-images-amazon.com/images/I/81SGb5l%2BlZL._AC_SX342_.jpg","quantity":7,"rating":5,"price":1449.0},"quantity":7}`
 
* **Error Response:**
  * **Reason:** cpf or nbr informed not found in database. <br />
    **Content:** `{}`

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.post(`/cartitems/add/${cpf}/${nbr}`).then(function(response) {
        const item = response.data
        if(item !== null)
          console.log(item)
      }
  ```

[Back To The Top](#amazon-clone-back-end)

**Update cart item**
----
  Updates cart item registration from database.

* **URL**

  /cartitems/update/

* **Method:**

  `PUT`
  
* **Data Params**

   **Required:**
    
    `id: [ cpf: [user's cpf],
	         nbr: [product's number] ]`

    `product: [product's object]`

    `user: [user's object]`

    `quantity: [Amount of items of the same product that is going to be bought modified]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"id":{"cpf":"12345678912","nbr":4},"user":{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"},"product":{"nbr":4,"title":"New Apple iPad Pro","image":"https://images-na.ssl-images-amazon.com/images/I/81SGb5l%2BlZL._AC_SX342_.jpg","quantity":7,"rating":5,"price":1449.0},"quantity":12}`
 
* **Error Response:**
  * **Reason:** cpf or nbr not found in database <br />
      **Content:** `{}`
  
  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
     axios.put(`/cartitems/update/`, item)
        .then(function(response) {
            const item = response.data
            if(item !== null)
                console.log(item)
  ```

[Back To The Top](#amazon-clone-back-end)

**Delete cart item**
----
  Deletes a single cart item from database.

* **URL**

  /cartitems/delete/:cpf/:nbr

* **Method:**

  `DELETE`
  
* **URL Params**

   **Required:**

    `cpf=[only 11 number digits that identifies the user]`

    `nbr=[number that identifies the product]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{"id":{"cpf":"12345678912","nbr":4},"user":{"cpf":"12345678912","name":"Test 1","birthday":"1970-01-01T04:43:42.000+00:00","sex":"M","address":"Address 1","nbr":78,"city":"Curitiba","state":"Paraná","country":"Brasil","email":"test1@email.com","password":"1234"},"product":{"nbr":4,"title":"New Apple iPad Pro","image":"https://images-na.ssl-images-amazon.com/images/I/81SGb5l%2BlZL._AC_SX342_.jpg","quantity":7,"rating":5,"price":1449.0},"quantity":7}`
 
* **Error Response:**
  * **Reason:** cpf or nbr informed not found in database. <br />
      **Content:** `{}`

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```javascript
    axios.delete(`/cartitems/delete/${cpf}/${nbr}`)
      .then(function(response) {
        const item = response.data
        if(item !== null)
          console.log(item)
      })
  ```

[Back To The Top](#amazon-clone-back-end)