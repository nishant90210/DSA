package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by NISHANT on 3/31/18.
 */
//  http://qa.geeksforgeeks.org/3634/find-out-whether-there-are-enough-rooms-hotel-satisfy-demand
public class HotelBooking {

    public static void main (String[] args) {

        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(2,6,10,14));
        /*
        [2, 4, 7, 12, 15, 16, 22, 24, 26, 29, 31, 33, 47, 47, 49]
        [4, 16, 16, 26, 27, 29, 30, 32, 43, 51, 54, 58, 79, 80, 95]
         */
        System.out.printf("Is booking possible: " + hotel(arrive, depart, 2));
    }

    private static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {

        Collections.sort(arrive);
        Collections.sort(depart);
        int begin = arrive.get(0);
        int end = depart.get(depart.size() - 1);
        int booked = 0;
        int arrivalIndex = 0;
        int departureIndex = 0;

        for (int i = begin; i < end; i++) {
            while (arrivalIndex < arrive.size() && arrive.get(arrivalIndex) == i){
                booked++;
                arrivalIndex++;
            }
            while (departureIndex < depart.size() && depart.get(departureIndex) == i){
                if (booked >= 1 ){
                    booked--;
                }
                departureIndex++;
            }
            if (booked > k){
                return false;
            }
        }
        return true;
    }
}
