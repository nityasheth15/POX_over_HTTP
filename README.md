# POX_over_HTTP

This is a Maven project created in Eclipse Mars.
I am putting two projects in the Zip folder as follows:

1. Client: POX-FoodMenu-ndsheth1-Eclipse
This is a simple Maven project.

2. Server: POX-FoodMenu-S-ndsheth1-Eclipse
This is a Maven Web project.

To run the projects you need to follow the following steps:
1. Import both the projects into your IDE [choose the Import Existing Maven Project option].
2. After the projects are loaded correctly, you need to run the Server first. Hence run POX-FoodMenu-S-ndsheth1-Eclipse as 'Run on Server'.
3. As soon as the browser opens, it means that the server is on. Now, run the client project by following the next steps.
4. Open 'FoodItemApp.java' from the client project POX-FoodMenu-ndsheth1-Eclipse and run that file as 'Run as java application'.
5. You will see the console asking you to enter the data. Follow the steps as shown on console.

P.S.: I have chosen a hardcoded path for FoodDataItems.xml file; this is because while the server is on, it locks the 'resource' folder and doesn't allow the program to write. Since I'm using a windows pc, I chose 'C\Windows\Temp' folder, and if you are using windows too, then you should just copy and paste the file 'FoodDataItem.xml' into that folder and make no changes in the program. 
But, in case you wish to use another location of any other system, then copy and paste the file from 'resource' folder, located under src folder of server project. The last thing you need to do is to copy and paste the location in file 'FoodItemXMLData.java' in createFoodItem() method.

Two functions in the project:

1) AddFoodItem
You can add one element at a time.

2) GetFoodItem
You can search more than one element at a time.
