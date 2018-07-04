package exercise;

//1.1.26
public class E27_Binomial {
  private static int count1=0;
  private static int count2=0;
  private static double MATRIX[][];
  
  /**
   *普通的实现，会有重复计算，比如：
   *(99,50)计算(98,50)(98,49) 
   * (99,49)计算(98,48)(98,49)
   */
  public static double binomial(int N,int k,double p) {
    count1++;
    if(N==0 && k==0) return 1.0;
    if(N<0 || k<0) return 0.0;
    return (1.0-p)*binomial(N-1,k,p)+p*binomial(N-1,k-1,p);
  }
  
  /**
   *较好的方法： 记录重读的解，比如(98,49),再用到的时候，已经求好了
   */
  public static double binomialBetter(int N,int k,double p) {
    count2++;
    //System.out.println("递归的次数："+count2);
    if(N==0 && k==0) return 1.0;
    if(N<0 || k<0) return 0.0;
    if(MATRIX[N][k]!=-1) {
      return MATRIX[N][k];
    }
    MATRIX[N][k] = (1.0-p)*binomialBetter(N-1,k,p)+p*binomialBetter(N-1,k-1,p);
    return MATRIX[N][k];
  }
  
  /**
   *初始化表格：变成每个备忘录格子都是-1 
   */
  public static double[][] initial(int N,int k){
    MATRIX = new double[N+1][k+1];//为了给0腾出一行
    for(int i= 0;i<=N;i++) {
      for(int j=0;j<=k;j++) {
        MATRIX[i][j]=-1;//初始化
      }
    }
    return MATRIX;
  } 
  public static void main(String[] args) {
    System.out.println("普通递归结果："+binomial(10,5,0.25));
    //binomial(100,50,0.25);//超级大的
    System.out.println("递归的次数count1："+count1);
    initial(10,5);
    System.out.println("记录备忘录结果："+binomialBetter(10,5,0.25));
    System.out.println("递归的次数count2："+count2);
  }
}
//运行结果：
/*
 普通递归结果：0.058399200439453125
递归的次数count1：2467
记录备忘录结果：0.058399200439453125
递归的次数count2：101
*/

