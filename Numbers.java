import java.util.*;
import java.util.concurrent.*;

public class Numbers {
	public static void main(String[] args) {
		CodeTimer.start(); // Keep track of execution time
		int sum = 0;
		for (int t = 0; t < 1_000; t++) {
			for (int i = 0; i < 1_000_000; i++)
				sum++;
		}
		System.out.println("Total Numbers: " + sum);
		String time = CodeTimer.stop("ms"); // Stop here so we don't track println time as well
		System.out.println("Execution time: " + time);
	}
}