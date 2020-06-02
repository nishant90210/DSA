package Arrays;

import java.util.ArrayList;

/**
 * Created by NISHANT on 3/16/18.
 */
public class ReverseList {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
//		ArrayList<String> newlist = new ArrayList<String>();

        list.add("cat");
        list.add("bat");
        list.add("xat");
        list.add("mat");
        list.add("rat");

        System.out.println("Current list is : " + list);

//		for (int i = list.size()-1; i >= 0 ; i--) {
//			String element = list.get(i);
//			newlist.add(element);
//
//		}

        for(int start=0, end=(list.size()-1); start<list.size()/2; start++,end--){
            swap(list, start, end);
        }
        System.out.println("New improved reversed list is:- "+list);
    }

    private static void swap(ArrayList<String> list, int start, int end) {

        Object temp = list.set(start, list.get(end));
        list.set(end, (String) temp);

    }
}
