package challenge.TheaterSeating.test;

import java.util.ArrayList;
import java.util.List;

import challenge.TheaterSeating.service.MovieTheater;

public class TestTheaterSeating {
	
	MovieTheater testTheater;
	
	public void testMe(MovieTheater movieTheaterIn){
		System.out.println("***** TESTING ******");
		testTheater = movieTheaterIn;
		testTheater.bookSeat("R001 5");
		checkFirstCustomerSeat();
		checkConsecutiveSeats();
		checkInsufficientSeats();
		checkGroupUnableToAccomodateInRow();
		
	}
	
	private void checkFirstCustomerSeat(){
		//testTheater.printLayout();
		List<String> list = new ArrayList<>();
		list.add("E1");
		list.add("E2");
		list.add("E3");
		list.add("E4");
		list.add("E5");
		if(testTheater.getResults().get("R001").equals(list)){
			System.out.println("Test 1 Passed : 5 Seats successfully reserved for first customer at the middle row.");
		}else{
			System.out.println("Test 1 failed: Failed to reserve seats for first customer at the middle row.");
		}
	}
	
	public void checkConsecutiveSeats(){
		List<String> list = new ArrayList<>();
		list.add("R001");
		list.add("R001");
		list.add("R001");
		list.add("R001");
		list.add("R001");
		if(testTheater.getList(4,0, 4).equals(list)){
			System.out.println("Test 2 Passed : 5 Consecutive seats successfully reserved for first customer row E.");
			
		}else{
			System.out.println("Test 2 failed : Failed to reserve consecutive seats.");
		}
		
	}

	public void checkInsufficientSeats(){
		testTheater.bookSeat("R002 250");
		if(testTheater.getNumberOfSeats()>0){
			System.out.println("Test 3 Passed : Failed to allocate seats when the request was greater than the available seats.");
		}else{
			System.out.println(" Test 3 Failed : Allocated as many seta as possible.");
		}
	}
	
	
	
	public void checkGroupUnableToAccomodateInRow(){
	    int result = testTheater.bookSeat("R003 24");	
	    if(result == 0){
	    	System.out.println("Test 4 Passed : Successfully allocated seats to a large group that could not be accomodated in a row.");
	    }else{
	    	System.out.println("Test 4 Failed : Failed to allocate seats to a large group.");
	    }
	}
}
