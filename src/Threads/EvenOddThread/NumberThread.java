package Threads.EvenOddThread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberThread {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Max Number: ");
		int N = scan.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		
		EvenThread evenThread = new EvenThread(N, q);
		OddThread oddThread = new OddThread(N, q);
		
		Thread event = new Thread(evenThread, "EvenThread");
		Thread oddt = new Thread(oddThread, "OddThread");
        event.start();
        oddt.start();
	}

}
