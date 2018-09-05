package challenge.TheaterSeating.test;

import java.util.ArrayList;
import java.util.List;

import challenge.TheaterSeating.service.MovieTheater;

public class TestTheaterSeating {

	MovieTheater testTheater;

	public void testMe(MovieTheater movieTheaterIn) {
		System.out.println("***** TESTING ******");
		testTheater = movieTheaterIn;
		checkReservationWithZeroTickets();
		checkFirstCustomerSeat();
		checkConsecutiveSeats();
		checkInsufficientSeats();
		checkGroupUnableToAccomodateInRow();
		checkGroupAccomodationOfSizeLargerSize();
	}

	private void checkReservationWithZeroTickets(){
		if(testTheater.bookSeat("R001 0")== 1){
			System.out.println("Test 1 Passed : No seat reserved for Reservation Id R001 with requirement of zero seats.");
		}else{
			System.out.println("Test 1 Failed : Reservation made for R001 with zero requirement of seats.");
		}
	}
	private void checkFirstCustomerSeat() {
		// testTheater.printLayout();
		testTheater.bookSeat("R002 5");
		List<String> list = new ArrayList<>();
		list.add("E1");
		list.add("E2");
		list.add("E3");
		list.add("E4");
		list.add("E5");
		if (testTheater.getResults().get("R002").equals(list)) {
			System.out
					.println("Test 2 Passed : 5 Seats successfully reserved for first customer at the middle row.");
		} else {
			System.out
					.println("Test 2 Failed: Failed to reserve seats for first customer at the middle row.");
		}
	}

	public void checkConsecutiveSeats() {
		List<String> list = new ArrayList<>();
		list.add("R002");
		list.add("R002");
		list.add("R002");
		list.add("R002");
		list.add("R002");
		if (testTheater.getList(4, 0, 4).equals(list)) {
			System.out
					.println("Test 3 Passed : 5 Consecutive seats successfully reserved for first customer row E.");

		} else {
			System.out
					.println("Test 3 Failed : Failed to reserve consecutive seats.");
		}

	}

	public void checkInsufficientSeats() {
		testTheater.bookSeat("R003 250");
		if (testTheater.getNumberOfSeats() > 0) {
			System.out
					.println("Test 4 Passed : Failed to allocate seats when the request was greater than the available seats.");
		} else {
			System.out
					.println(" Test 4 Failed : Allocated as many seta as possible.");
		}
	}

	public void checkGroupUnableToAccomodateInRow() {
		int result = testTheater.bookSeat("R004 24");
		if (result == 0) {
			System.out
					.println("Test 5 Passed : Successfully allocated seats to a large group that could not be accomodated in a row.");
		} else {
			System.out
					.println("Test 5 Failed : Failed to allocate seats to a large group.");
		}
	}
	
	private void checkGroupAccomodationOfSizeLargerSize(){
		List<String> list = new ArrayList<>();
		list.add("F1");
		list.add("F2");
		list.add("F3");
		list.add("F4");
		list.add("F5");
		list.add("F6");
		list.add("F7");
		list.add("F8");
		list.add("F9");
		list.add("F10");
		list.add("F11");
		list.add("F12");
		list.add("F13");
		list.add("F14");
		list.add("F15");
		list.add("F16");
		list.add("F17");
		list.add("F18");
		list.add("F19");
		list.add("F20");
		list.add("E6");
		list.add("E7");
		list.add("E8");
		list.add("E9");
		if(testTheater.getResults().get("R004").equals(list)){
			System.out.println("Test 6 Passed : Successfully accomodated a group that could not be accomodated in a single row.");
		}else{
			System.out.println(" Test 6 Failed : Failed to accomodate the group that could not be accomodated in a single row.");
		}
	}
	
	
}
