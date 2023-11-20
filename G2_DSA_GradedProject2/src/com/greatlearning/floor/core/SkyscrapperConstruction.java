package com.greatlearning.floor.core;

/***
 * package used java.util
 * Scanner----for taking input from the user
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;


public class SkyscrapperConstruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the total number of floors in the building:");
		int totalFloors= sc.nextInt();
		
		//implementation of queue using linkedlist interface  and stack for storing the output
		Queue<Integer> floorSizes = new LinkedList<>();
		Stack<Integer> assembledFloors= new Stack<>();
		//iterate through totalfloors to take the input from the user for the respective day
		for(int i=1;i<=totalFloors;i++) {
			System.out.println("Enter the floor size given on day " + i + ":");
			//now add this input in queue
			floorSizes.add(sc.nextInt());
		}
		//call the function for performing the given operation to arrange the floor day wise 
		constructionOrder(totalFloors,floorSizes, assembledFloors);
		
	}
	private static void constructionOrder(int n, Queue<Integer> floorSizes, Stack<Integer> assembledFloors) {
		//loop to iterate through days
		for(int day=1;day<=n;day++) {
			int currentFloor=floorSizes.poll(); //used for storing the top element from queue
			 
			while(!assembledFloors.isEmpty() && assembledFloors.peek()>currentFloor) {
				//remainingFloors.add(floorSizes.poll());
				System.out.print(assembledFloors.pop() + " ");
			}
			assembledFloors.push(currentFloor);
			System.out.println(); //to print space incase if that particular day we have bigger size on other day as compared to present day
			System.out.print("Day: " + day + "\n");
		
		}
		//as for loop completes we have remaining values in stack that we need to pop one by one 
		while(!assembledFloors.isEmpty()) {
			System.out.print(assembledFloors.pop() + " "); //printing remiaing values 
		}	
		System.out.println();
	}
}

/**
 * Team members:
 * 1.Shivam Kumar Raj
 * 2.Syed Shoebuddin
 * 3.Ishika Nehra
 * 4.Sandeep
 */