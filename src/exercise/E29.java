package exercise;

public class E29 {
  /**
   * 二分搜索
   *pre:必须没有重复的元素才正确，不然无法得出正确答案
        如果有重复的元素，还是暴力搜素好用，不然，如果先对a除去重复的元素，代价是O(n)，不划算
   *@param 关键值
   *@param 给出的数组的元素
   *@return 返回数组a中小于key的元素的个数
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
    //总结出来的
    if(a[mid] > key) return mid;
    else return mid+1;
  }
  
  /**
   *暴力搜索 
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