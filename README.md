#Running 
  #IDE
  To run the project import into IDE e.g Eclipse and then just run the main class CodetestApplication.java as a Java Application 
  
  #CLI - Maven 
  Alternatively you can run it via maven using the command 
  
  mvn spring-boot:run
  
 
 #Using Tool 
 
 Once you run the tool it will launch into a shell where you can add People / Addresses 
 examples can be seen below. 
 You can type help and it will list the available commands below. 
 
#Commands Examples 

Person Shell

        add-person: Add a person to the database
        
        delete-person: Delete a person from the database
        
        edit-person: Edit an existing person in the database
        
        list-people: List all people in the database

Examples

add-person Conor McKernan

add-person Donald McKernan

add-person Billy McKernan

add-person Chunk McKernan

Address Shell

        add-address: Add an address to person in the database
        
        delete-address: Delete an address from the database
        
        edit-address: Edit an existing address in the database
        
        list-addresses: List all addresses in the database


add-address 1 "Fake Street" "New Jersey" Kentucky 32FDS

add-address 2 "Fake Land" New Jersey" Ireland 32FDS

add-address 4 "Fake Street" "Cork" Ireland 32FDS

add-address 3 "Fake Street" "Dublin" Ireland 32FDS

add-address 1 "Fake Street" "Paris" Kentucky 32FDS

edit-address --id 1 --street "Fake Ville" --city "New Jersey" --state Kentucky --postal-code 32FDS

