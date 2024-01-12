package example;
import java.util.*;
import java.util.stream.Stream;

public class DoubleEven 
{

	public static void main(String[] args)
	{
		List<Integer> L1 = new ArrayList<>();
		Random ran = new Random();
		
		for(int i=1;i<51;i++)
		{
			int temp = ran.nextInt(1000);
			L1.add(temp);
		}
		
		//int double_even = 0;
		
//		for(int i:L1)
//		{
//			if(i%2 == 0)
//			{
//				double_even +=(i*2);
//			}
//		}
		
		Stream<Integer> s = L1.stream();
		Stream<Integer> s1 = s.filter(n -> n%2 ==0);
		Stream<Integer> s2 = s1.map(n -> (n*2));
		Integer s3 = s2.reduce(0,(t,i) -> t+i);
		
		
		System.out.println("THE SUM OF DOUBLE OF EVEN NUMBER : "+s3);
	}

}
