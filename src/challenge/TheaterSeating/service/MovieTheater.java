package challenge.TheaterSeating.service;

import challenge.TheaterSeating.util.FileProcessor;

public class MovieTheater {
    int rows = 10;
    int columns = 20;
    int numberOfSeats = 200;
    
    String[][] seats = new String[10][20];
    int remainingSeats[]= {20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
    public MovieTheater(){
      //FileProcessor fileProcessor = new FileProcessor("output.txt");	
    }
    
    public void bookSeat(String reservation){
    	String[] input = reservation.split(" ");
    	String rno = input[0];
    	int count = Integer.parseInt(input[1]);
    	int n = count;
    	if(numberOfSeats>=count){
    		if(n>20){
    			while(n>20){
    			  allocate(rno, 20);
    			  n -=20;
    			}
    			allocate(rno, n);
    		}else{
    			allocate(rno, n);
    		}
    	
    	}else{
    		System.out.println("Insufficient number of seats available for the group of "+count);
    	}
    }
    
    private void allocate(String rno, int n){
    	int count = n;
    	for(int r=0; r<10 && n>0; r++){
    		if(remainingSeats[r] >= n){
    			for(int c=0; c<20 && n>0; c++){
    				if(seats[r][c] == null){
    					seats[r][c] = rno;
    					remainingSeats[r]--;
    					numberOfSeats--;
    					n--;
    				}
    			}
    		}
    	}
    	if(n==0){
			System.out.println(count+" Seats reserved for "+rno);
		}else{
			// find and allocate in the remaining seat
			for(int i=0; i<remainingSeats.length; i++){
				if(remainingSeats[i]>0){
					for(int j=19; seats[i][j]==null; j--){
						seats[i][j]= rno;
						n--;
						numberOfSeats--;
						remainingSeats[i]--;
					}
				}
			}
		}
    }
    public void printMap(){
    	System.out.println("               ********************* RESERVATIONS **********************");
    	for(int r=0; r<10; r++){
    		System.out.print((char)(r+65)+" ");
    		for(int c=0; c<20; c++){
    			System.out.print(" "+seats[r][c]);
    		}
    		System.out.println();
    	}
    }
}
