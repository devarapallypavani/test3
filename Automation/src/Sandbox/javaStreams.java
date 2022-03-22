package Sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class javaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//first will create object for list of string array and store the data in that list
		
		ArrayList<String> name = new ArrayList<String>();
		
		name.add("Anu");
		name.add("shruthi");
		name.add("geetha");
		name.add("Akshara");
		name.add("arohai");
		name.add("arya");
		
		//to iterate in the array and to get the count of name which start with a
		// without using streams
//		int count = 0;
//		for (int i=0; i<name.size(); i++)
//		{
//			String result= name.get(i);
//			
//			if (result.startsWith("A"))
//			{
//				count++;
//			}
//		}
//		
//		System.out.println(count);

		// using streams
		// first we are converting the list to stream and then applying filter 
		// in the filter condition we are using lambda function which is storing the results in one variable and comparing the results with the expected one 
		//and getting the count 
		// there is no life for intermediate operation (filter) if there is no terminal operation (count)
		// terminal operation will only execute when intermediate operation returns true executed successfully
		// if the operation has many steps then we can write the code in { }
		//like { 
		// result.startsWith("A"):
		//}... this will also execute 
		long c= name.stream().filter(result-> result.startsWith("A")).count();
		
		//System.out.println("the count of list: " + c);
		// to print list of name we are using foreach method and storing each element in result and displaying the result
		//name.stream().forEach(result-> System.out.println(result));
		// adding some condition to display name which ends with a 
		
		//name.stream().filter(result-> result.endsWith("a")).forEach(result-> System.out.println( "name ends with a are: " + result));
		
		//to limit the number of result we can use terminal operator limit  
		//name.stream().filter(result-> result.endsWith("a")).limit(2).forEach(result-> System.out.println( "name ends with a are: " + result));
		// if we want to display the result in upper or lower case ( modifying the results) we should use map method 
		
		// to display the result in upper case with length more than 4 
		//name.stream().filter(result-> result.length()>4).map(result-> result.toUpperCase())
		//.forEach(result-> System.out.println( "list of name with length greater than 4 " + result));
		
		// to display the result in sorted we have one terminal operator sort
		//note: we can convert arrays to arraylist using aslist method (Arrays.aslist(array name))
		//instead of creating array list and converting to stream we can directly create a stream list  using stream.of and then apply intermediate operator 
		//Stream.of("Akshara", "arohai", "geetha", "shruthi").forEach(result-> System.out.println(result));
		//converting array to arraylist
		List<String> names_1 = Arrays.asList("abhi", "mahesh", "avinash", "lavakush", "sharath");
		
		//name.stream().filter(result-> result.length()>4).sorted().forEach(result-> System.out.print(result));
		//merging two array list 
		// we have concat method 
		//first we need to convert both the list to stream and concat the streams and store the result in stream
		// and displaying the result in sorted order
		Stream<String> name_concat = Stream.concat(name.stream(), names_1.stream());
		
		//name_concat.sorted().forEach(result-> System.out.println(result));
		
		// if we want to math the result with expected one and display if it is true we can use anymatch operator
		//anymatch operator with return true if the condition matches and flase if it does not match
		
		//boolean flag= name_concat.anyMatch(result-> result.equalsIgnoreCase("shruthi"));
		
		//we can validate that by using assertion
		
//		Assert.assertTrue(flag);
//		System.out.println(flag);
		// if we want to convert the resulted stream to list we can use collector operator and store in new list 
		 //List<String> finalList= name_concat.collect(Collectors.toList());
		 // we can also do some operations and then convert to list 
		 List<String> list1= name_concat.filter(result-> result.length()>4).map(result-> result.toUpperCase()).collect(Collectors.toList());
		 
		 //System.out.println(finalList);
		 System.out.println(list1);
		 // displying 5 index from the list starting from 0
		 System.out.println(list1.get(5));
		 
		 // to display unique numbers in integer list and sort them in order
		 List<Integer> values = Arrays.asList(4,8,9,3,4,3,1,2,7,9,12,24,23,4,5);
		 
		 System.out.println(values);
		 // first convert the list to stream and then use distinct operator to display unique numbers
		 // sorting in asc order
		 Stream<Integer> finalValues= values.stream().distinct().sorted();
		 // converting the stream to list and displying the result
		 
		 List<Integer> sortedValues=  finalValues.collect(Collectors.toList());
		 
		 System.out.println(sortedValues);
		 
		 // sorting in desc order
		 List<Integer> descSort = values.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		 
		 System.out.println(descSort);
		
	}

}
