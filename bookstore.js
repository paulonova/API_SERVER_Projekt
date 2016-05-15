//My Bookstore Server



var express = require('express');

var app = express();

var bookstore = {books: [{name: "Bootstrap 3.3",
                                            description: "Discover how easy it is to design killer interfaces and responsive websites with the Bootstrap framework. ", 
                                            price: 320},
                            
                            {name: "Core Java, Volume II * Advanced Features",
                                            description: "Fully updated to reflect Java SE 7 language changes, Core Java, Volume IIAdvanced Features, Ninth Edition, is the definitive guide to ", 
                                            price: 275},
                            
                            {name: "JavaScript & jQuery: The Missing Manual",
                                            description: "JavaScript lets you supercharge your HTML with animation, interactivity, and visual effects - but many web designers find the language hard to learn. ", 
                                            price: 449},
                            
                            {name: "Creating Mobile Apps with jQuery Mobile",
                                            description: "In DetailjQuery Mobile is a touch-optimized web framework (also known as a JavaScript library or a mobile framework) currently being developed by the jQuery project team. ", 
                                            price: 339},
                            
                            {name: "SQL for MySQL Developers",
                                            description: "MySQL version 5 offers a SQL dialect with immense power. In SQL for MySQL Developers, Rick F. van der Lans helps you master this version ofSQL and take advantage of ", 
                                            price: 469},
                            
                            {name: "Using SQLite", 
                                            description: "Application developers, take note: databases aren't just for the IS group any more. You can build database-backed applications for the desktop, Web, embedded systems,", 
                                            price: 318},
                            
                            {name: "Swift 2 for Absolute Beginners",
                                            description: "Swift 2 for Absolute Beginners is perfect for those with no programming background, those with some programming experience but no object-oriented experience.", 
                                            price: 380},
                            
                            {name: "Android Programming - The Big Nerd Ranch Guide",
                                            description: "Android Programming: The Big Nerd Ranch Guide is an introductory Android book for programmers with Java experience.\n", 
                                            price: 265},
                            
                            {name: "iOS Programming: The Big Nerd Ranch Guide", 
                                            photo: "the_big_nerd_ios.jpg", 
                                            description: "Updated and expanded to cover iOS 7 and Xcode 5, iOS Programming: The Big Nerd Ranch Guide leads you through the essential concepts, tools, and techniques for developing ", 
                                            price: 440},
                            
                            {name: "Web Standards: Mastering HTML5, CSS3, and XML", 
                                            photo: "web_design_book.jpg", 
                                            description: "Web Standards: Mastering HTML5, CSS3, and XML provides solutions to the most common website problems, and gives you a deep understanding of web standards and how they ", 
                                            price: 370}]};


 

//behöver skriva localhost:1338/phones för att fungerar i browser..
app.get("/book/package.json", function(request, response){  
    
    
   //var index = Math.floor((Math.random() * bookstore.books.length));  
    //console.log(bookstore.books[index].name);
   response.send(bookstore.books);
    
});

app.listen(1338);

