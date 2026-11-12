import java.util.*;
import java.util.concurrent.*;

public class Numbers {
	public static void main(String[] args) {
		CodeTimer.start(); // Keep track of execution time
		ExecutorService executor = Executors.newFixedThreadPool(1000);
		ArrayList<Future<Integer>> futures = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			Future<Integer> future = executor.submit(new Counter());
			futures.add(future);
		}
		int sum = 0;
		try { // Wait for all threads to join before continuing
			for (Future<Integer> future : futures)
				sum += future.get();
		} catch (Exception e) {
			System.out.println("something got messed up");
		}
		System.out.println("Total Numbers: " + sum);
		String time = CodeTimer.stop("ms"); // Stop here so we don't track println time as well
		System.out.println("Execution time: " + time);
		executor.shutdown();
	}
}

class Counter implements Callable<Integer> {

	@Override
	public Integer call() {
		int count = 0;
		for (int i = 0; i < 1_000_000; i++)
			count++;
		return count;
	}
}