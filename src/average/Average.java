package average;

public class Average { 

  // this class should not be instantiated
  private Average() { }

  /**
   * Reads in a sequence of real numbers from standard input and prints
   * out their average to standard output.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) { 
      int count = 0;       // number input values
      double sum = 0.0;    // sum of input values
      
      // read data and compute statistics
      //��StdIn��ӱ�׼�������л�ȡ���ݣ�ʹ��Scanner�������е��������ݾ���������
      while (!StdIn.isEmpty()) {
          double value = StdIn.readDouble();
          sum += value;
          count++;
      }

      // compute the average
      double average = sum / count;

      // print results
      StdOut.println("Average is " + average);
  }
}
