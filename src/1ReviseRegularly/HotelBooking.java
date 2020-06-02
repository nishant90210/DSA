package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by NISHANT on 3/31/18.
 */
//  https://www.geeksforgeeks.org/find-k-bookings-possible-given-arrival-departure-times/
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
        int arrivalIndex = 0;
        int departureIndex = 0;
        int size = arrive.size();
        int count = 0;

        while (arrivalIndex < size && departureIndex < size){

            if (arrive.get(arrivalIndex) < depart.get(departureIndex)){
                arrivalIndex++;
                count++;
                if (count > k) {
                    return false;
                }
            }else {
                departureIndex++;
                count--;
            }
        }
        return true;
    }
}
