package labuladong.InsertDeleteGetRandomO1380;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedSet1 {
	HashMap<Integer,Integer> map;
	int[] arr;
	int size;
	Random rd;
	public RandomizedSet1() {
		map = new HashMap<>();
		arr = new int[200000];
		size = 0;
		rd = new Random();
	}

	public boolean insert(int val) {
		// 直接插入到尾部
		if(map.containsKey(val)){
			return false;
		}
		map.put(val,size);
		arr[size] = val;
		size++;
		return true;
	}

	public boolean remove(int val) {
		// 交换到尾部再删除
		if(!map.containsKey(val)){
			return false;
		}
		int index = map.get(val);
		arr[index] = arr[size-1];
		arr[size-1] = val;
		map.put(arr[index],index);
		size--;
		map.remove(val);
		return true;
	}

	public int getRandom() {
		int random = rd.nextInt(size);
		return arr[random];
	}
	public static void main(String[] args){
		RandomizedSet1 rs = new RandomizedSet1();
		rs.insert(0);
		rs.insert(1);
		rs.remove(0);
		rs.insert(2);
		rs.remove(1);
		System.out.println(rs.getRandom());
	}
}
