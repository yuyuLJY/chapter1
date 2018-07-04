package exercise;

public class E29 {
  /**
   * ��������
   *pre:����û���ظ���Ԫ�ز���ȷ����Ȼ�޷��ó���ȷ��
        ������ظ���Ԫ�أ����Ǳ������غ��ã���Ȼ������ȶ�a��ȥ�ظ���Ԫ�أ�������O(n)��������
   *@param �ؼ�ֵ
   *@param �����������Ԫ��
   *@return ��������a��С��key��Ԫ�صĸ���
   */
  public static int rank(int key,int a[]) {
    int lo = 0;
    int hi = a.length-1;
    int location =-1;
    int mid=0;
    while(lo<=hi) {
      mid = lo + (hi-lo)/2;
      if(key < a[mid]) hi = mid-1;
      if(key > a[mid]) lo = mid+1;
      if(key == a[mid]) return mid;
    }
    //�ܽ������
    if(a[mid] > key) return mid;
    else return mid+1;
  }
  
  /**
   *�������� 
   */
  public static int rankBrute(int key, int[] a) {
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] < key) {
        count++;
      } else {
        break;
      }
    }
    return count;
  }
  
  public static void main(String[] args) {
    int[] a = {1,2,4,5,7,8,8,8,8,10};
    System.out.println(rank(8,a));
    
  }
  
  
}