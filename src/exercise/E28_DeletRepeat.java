package exercise;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

//1.1.28
public class E28_DeletRepeat {

  public static void main(String[] args) {
    int[] whiteList = { 7, 1, 5, 1, 9, 5, 7, 7, 5, 1 };
    Arrays.sort(whiteList);
    ArrayList<Integer> list = new ArrayList<>();
    list.add(whiteList[0]);//��Ϊ��һ�����Ƚ�
    for(int i = 0; i<whiteList.length-1;i++) {
      if(whiteList[i]!=whiteList[i+1]) {
        list.add(whiteList[i+1]);//�Ѻ�һ��Ԫ�ؼӽ�ȥ 
      }
    }
    for(int i : list) {
      System.out.print(i+" ");//��ӡ������� 1 5 7 9
    }
  }

}
