/**
 * Creating a JsonParse type object by passing the URL as the constructor parameter
 * will let you call getData(String data) method on that object to fetch the desired
 * value assigned to the data.
 * 
 * @author: Tanjid Ahmed
 * @date: 28-08-2019
 * 
 */

import java.io.IOException; //you need to catch the IOException

public class JsonTester {
    public static void main (String[] args) throws IOException {
        
        //creating person object of JsonParse type
        JsonParse person = new JsonParse ("http://tanjid.cf/jsonExample"); //pass the URL as constructor parameter
        
        //getting data by simply calling getObject() method on person object of JsonParse type
        String name = person.getData("name");
        int age = Integer.parseInt(person.getData("age")); //getting age as integer type
        String gender = person.getData("gender");
        String nationality = person.getData("nationality");
        String dateOfBirth = person.getData("dateOfBirth");
        boolean married = Boolean.parseBoolean(person.getData("married")); //getting boolean type data
        
        //printing data
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("Date of Birth : "+dateOfBirth);
        System.out.println("Married : "+married);
        
    }
}
