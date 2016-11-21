package fibonacci;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.Arrays;

public class FibonacciSequence {
  public static void main(String args[]) {
    if(args.length > 1 || args.length == 0){
      System.out.println("Please rerun code with argument of one number.");
      return;
    }

    int position = Integer.parseInt(args[0]);
    
    if(position <= 0) {
      System.out.println("Please enter a number that is > 0.");
      return;
    }

    System.out.println(fibonacciSequenceMutability(position));

    System.out.println(fibonacciSequenceImmutability(position));

    System.out.println(fibonacciRecursive(position));
  }

  public static List<Integer> fibonacciSequenceMutability(int position) {
    List<Integer> sequence = new ArrayList<>();
      
    if (position >= 1) {
      sequence.add(1);
    }     

    if (position >= 2) {
      sequence.add(1);
    }

    for (int i = 3; i <= position; i++) {
      sequence.add(sequence.get(i - 2) + sequence.get(i - 3));
    }

    return sequence;
  }

  public static List<Integer> fibonacciSequenceImmutability(int position) {
    return Stream.iterate(new int[] {0, 1}, 
                    series -> new int[] {series[1], series[0] + series[1]})
                 .limit(position)
                 .map(series -> series[1])
                 .collect(Collectors.toList());
  }
                                                      
  public static List<Integer> fibonacciRecursive(int position){
    if (position == 1){
      return Arrays.asList(1);
    }                                                     
    
    if (position == 2){                                                 
      return Arrays.asList(1,1);
    }

    List<Integer> recursiveFibSequence = 
      new ArrayList<>(fibonacciRecursive(position - 1));
    int size = recursiveFibSequence.size();
    recursiveFibSequence.add(recursiveFibSequence.get(size - 1) +
      recursiveFibSequence.get(size - 2));
    
    return recursiveFibSequence;
  }
}