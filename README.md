## Task: Simple search agent

### Description
Improve your search engine to support complex queries containing a sequence of words and a strategy that determines how to match data.

Take, for example, these six sample lines:
````

Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
Katie Jacobs
Erick Harrington harrington@gmail.com
Myrtle Medina
Erick Burgess
````

Let's consider the searching strategies: ALL, ANY and NONE.

If the strategy is ALL, the program should print lines containing all the words from the query.
````
Query:

Harrington Erick
Result:

Erick Harrington harrington@gmail.com
If the strategy is ANY, the program should print the lines containing at least one word from the query.
Query:

Erick Dwight webb@gmail.com
Result:

Erick Harrington harrington@gmail.com
Erick Burgess
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
````

If the strategy is NONE, the program should print lines that do not contain words from the query at all:
````
Query:

djo@gmail.com ERICK

Result:

Katie Jacobs
Myrtle Medina
Rene Webb webb@gmail.com
````
All listed operations are implemented in the inverted index.<br>
The results should not contain duplicates.<br>
Note, do not forget to use methods to decompose your program.<br>


Example <br>
The lines that start with > represent the user input.<br>
Note that these symbols are not part of the input.
````
=== Menu ===
1. Find a person
2. Print all persons
0. Exit
> 1

Select a matching strategy: ALL, ANY, NONE
> ANY

Enter a name or email to search all suitable people.
> Katie Erick QQQ


Persons found:
Katie Jacobs
Erick Harrington harrington@gmail.com
Erick Burgess
````

### How to run:
Before run please create the same configuration as on the picture "ProjectConfiguration.png" that can be found in folder:
```
src/main/resources/
```