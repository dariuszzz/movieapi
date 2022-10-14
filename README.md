# Movie app api ::))

## Routes
- **/user**
    - [ ] **/{id}** - User with given id 
    - [ ] **/register** - Register new account and get a jwt back\
            `POST { username, password }`
    - [ ] **/login** - Retrieve jwt \
            `POST { username, password }`
- **/review**
    - [ ] **/add** - Add a review \
            `POST { token, content { movie, __TODO__ } }`
    - [ ] **/edit** - Edit a review \
            `POST { token, content { id,  __TODO__ } }`
    - [ ] **/delete** - Delete a review \
            `POST { token, content { id } }`
- **/movie**
    - [ ] **/{id}** - Movie with given id
    - [ ] **/search** - List of movies satysfying given criteria\
            <!-- `GET ?title=, ?director=, ?releaseYear=` \ -->
            `GET { title?, director?, releaseYear? }`
    

     