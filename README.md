<h2>My solution</h2>

***

I created a class called LanguageSelector. It's the main class where the program can be run.
LanguageSelector has logic to both user interface and the logic to select the language. 
The reason I created this class is to separate the logic for selecting the language from the logic for adding employees to the database.
Why I didn't also separate the logic for user interface from the logic for selecting the language is because the user interface is very simple, 
and it's not worth it to create a separate class for it. Instead of using JavaFX this time I used Swing.
I wanted to try out something I'm not at this time familiar with and learn more.

LanguageSelector communicates with AddEmployees class. AddEmployees class has the logic for 
connecting to the database and adding employees to the database.

***
