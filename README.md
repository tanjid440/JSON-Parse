# JSON-Parse
A minimal json parser written in java8 that does not requires any special or unofficial library or package.
limitation: no json array and no object within object as of now.

#Usage
Simply add the JsonParse.java in your code and create an object of that type passing the url as constructor
parameter. Then you can simply call getData() method on that object passing a String type parameter of which
you want the value for. For more info read the jsonTester.java which is well documented and gives a better understanding.

#Example

  JsonParse person = new JsonParse(url);
  String name = person.getData("name");

#Thank you
Any suggestion or contribution will be highly appreciated.
