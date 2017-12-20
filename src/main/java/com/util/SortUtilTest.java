package com.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author zhangyaz
 *排序算法。
 */
public class SortUtilTest {
	/**
	 * 冒泡排序
	 * @param array
	 * @return
	 */
	public static int[] maoPaoTest(int[] array){
		//for循环表示要比较多少轮。
	for (int i = 1; i < array.length; i++) {
		//j的范围很关键，这个范围是在逐步缩小的,因为每轮比较都会将最大的放在右边
		for (int j = 0; j < array.length-i; j++) {
			if (array[j]>array[j+1]) {
				int temp = array[j];
				array[j] =array[j+1] ;
				
				array[j+1] =temp ;
			}
		}
	}
		
		return array ;
	}

	
	/**
	 * 选择排序
	 * @param array
	 * @return
	 */
	public static int [] choiceSort(int[] array){
		//总共进行的排序的轮次。
		for (int i = 0; i < array.length-1; i++) {
			int min = i ;
		  for (int j = i+1; j < array.length; j++) {
			if (array[j]<array[min]) {
				min = j ; //记录目前找到的最小元素的下标。
			}
		}
			//如果第一个元素不是最小的元素就进行互换，如果是最小的进入下一次的循环。
		  if (i!=min) {
				int temp = array[i] ;
				array[i] =array[min] ;
				array[min] =temp ;
			}
			for (int k = 0; k < array.length; k++) {
				System.out.print("---->"+array[k]);
			}
			System.out.println();
		}
		return array ;
	}
	
	
	/**
	 * 插入排序
	 * @param array
	 * @return
	 */
	public static int[] insertSort(int[] array){
		int j ;
		//从下标为1的元素开始选择合适的位置进行插入。因为下标为0的元素只有一个默认是有序的。
		for (int i = 1; i < array.length; i++) {
			
			int temp = i ; //记录要插入的数据。
			
			j=i;
			
			while (j>0&&temp<array[j-1]) { //从已经排序的序列最右边开始比较，找到比其小的数
				
			array[j] = array[j-1] ;
			j-- ;
				
			}
			array[j] =temp ;
		
		
		}
		
		
		return array ;
	}
	public static void main(String[] args) {
		
		Map<String, Object> map  = new HashMap<>() ;
		int [] array = {4,2,1,2,6,0,12};
		
		int [] array1 =SortUtilTest.choiceSort(array);
		
		System.out.println("结束了！");
		
		System.out.println("end");
	}
}
