package JavaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreamsExamples {
	
//	//@Test
//	public void regular() {
//		
//		ArrayList<String> names = new ArrayList<String>();
//		names.add("Damian");
//		names.add("Lukasz");
//		names.add("Micha³");
//		names.add("Daria");
//		names.add("Marcin");
//		names.add("Kasia");
//		int count = 0;
//		
//		for(int i = 0; i < names.size(); i++) {
//			
//			String name = names.get(i);
//			if(name.startsWith("D")) {
//				count++;
//			}
//		}
//		System.out.println(count);
//	}
//	//@Test
//	public void streamTest() {
//		ArrayList<String> names = new ArrayList<String>();
//		names.add("Damian");
//		names.add("Lukasz");
//		names.add("Micha³");
//		names.add("Daria");
//		names.add("Marcin");
//		names.add("Kasia");
//		
//		//converting array list to stream and using lambda expression to gather specific data
//		long c = names.stream().filter(name->name.startsWith("D")).count();
//		
//		//additional way of creating stream - skipping array list
//		System.out.println(Stream.of
//				("Damian", "Lukasz", "Michal", "Daria", "Marcin", "Kasia").filter(s->s.startsWith("L")).count());
//		
//		//printing names grater than 5 characters by using stream and lambda expression
//		names.stream().filter(n->n.length()>5).forEach(s->System.out.println(s));
//		
//		//printing specific number of names - in this case only 1st one
//		names.stream().filter(n->n.length()>5).limit(1).forEach(s->System.out.println(s));
//	}
//	
	@Test
	public void streamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Celina");
		names.add("Roman");
		names.add("Leszek");
	

		//printing names with ending "ia" with uppercase
//		Stream.of("Damian", "Lukasz", "Michal", "Daria", "Marcin", "Kasia")
//		.filter(n->n.endsWith("ia")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
//		
//		//printing all names sorted
//		Stream.of("Damian", "Lukasz", "Michal", "Daria", "Marcin", "Kasia").sorted()
//		.forEach(s->System.out.println(s));
		
		//printing names started with "K" sorted and converted to upper case
		List<String> newList = Arrays.asList("Damian", "Kasia", "Aga", "Marcin");
		//newList.stream().filter(n->n.startsWith("K")).sorted().map(n->n.toUpperCase()).forEach(n->System.out.println(n));
		
		//merging two lists converted to stream into one only
//		Stream<String> newStream = Stream.concat(newList.stream(), names.stream());
//		
//		boolean flag = newStream.anyMatch(s->s.equals("Celina1"));
//		System.out.println(flag);
//		Assert.assertTrue(flag);
		
}
	
	@Test
	public void streamCollect() {
		
		List<String> collectionList = Stream.of("Damian", "Lukasz", "Michal", "Daria", "Marcin", "Kasia").filter(n->n.endsWith("ia"))
		.map(s->s.toUpperCase()).collect(Collectors.toList());
		
		List<Integer> values = Arrays.asList(3,2,2,1,5,7,4);
		List<Integer> newValues = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(newValues);
	}
}
