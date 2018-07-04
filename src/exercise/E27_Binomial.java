package exercise;

//1.1.26
public class E27_Binomial {
  private static int count1=0;
  private static int count2=0;
  private static double MATRIX[][];
  
  /**
   *��ͨ��ʵ�֣������ظ����㣬���磺
   *(99,50)����(98,50)(98,49) 
   * (99,49)����(98,48)(98,49)
   */
  public static double binomial(int N,int k,double p) {
    count1++;
    if(N==0 && k==0) return 1.0;
    if(N<0 || k<0) return 0.0;
    return (1.0-p)*binomial(N-1,k,p)+p*binomial(N-1,k-1,p);
  }
  
  /**
   *�Ϻõķ����� ��¼�ض��Ľ⣬����(98,49),���õ���ʱ���Ѿ������
   */
  public static double binomialBetter(int N,int k,double p) {
    count2++;
    //System.out.println("�ݹ�Ĵ�����"+count2);
    if(N==0 && k==0) return 1.0;
    if(N<0 || k<0) return 0.0;
    if(MATRIX[N][k]!=-1) {
      return MATRIX[N][k];
    }
    MATRIX[N][k] = (1.0-p)*binomialBetter(N-1,k,p)+p*binomialBetter(N-1,k-1,p);
    return MATRIX[N][k];
  }
  
  /**
   *��ʼ����񣺱��ÿ������¼���Ӷ���-1 
   */
  public static double[][] initial(int N,int k){
    MATRIX = new double[N+1][k+1];//Ϊ�˸�0�ڳ�һ��
    for(int i= 0;i<=N;i++) {
      for(int j=0;j<=k;j++) {
        MATRIX[i][j]=-1;//��ʼ��
      }
    }
    return MATRIX;
  } 
  public static void main(String[] args) {
    System.out.println("��ͨ�ݹ�����"+binomial(10,5,0.25));
    //binomial(100,50,0.25);//�������
    System.out.println("�ݹ�Ĵ���count1��"+count1);
    initial(10,5);
    System.out.println("��¼����¼�����"+binomialBetter(10,5,0.25));
    System.out.println("�ݹ�Ĵ���count2��"+count2);
  }
}
//���н����
/*
 ��ͨ�ݹ�����0.058399200439453125
�ݹ�Ĵ���count1��2467
��¼����¼�����0.058399200439453125
�ݹ�Ĵ���count2��101
*/

