package ALGO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NISHANT on 11/10/17.
 */
public class SieveOfEratosthenes {

    public static void main(String args[])
    {
        int n = 30;
        System.out.print("Following are the prime numbers ");
        System.out.println("smaller than or equal to " + n);
        SieveOfEratosthenes g = new SieveOfEratosthenes();
//        Map<Integer, Integer> map = g.sieveOfEratosthenesMap(n);
//        for (Map.Entry entry : map.entrySet()){
//            System.out.print(" " + entry.getKey());
//        }
        g.sieveOfEratosthenes(n);
    }

    private void sieveOfEratosthenes(int n){

        double floor = Math.floor(Math.sqrt(n));
        boolean prime[] = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        for (int p = 2; p <= floor; p++) {
            if (prime[p] == true){
                for (int j = p*2; j <= n ; j += p) {
                    prime[j] = false;
                }
            }
        }
        for(int x = 2; x <= n; x++)
        {
            if(prime[x] == true)
                System.out.print(x + " ");
        }

    }

    private Map<Integer, Integer> sieveOfEratosthenesMap(int n) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            map.put(i, i);
        }
        double floor = Math.floor(Math.sqrt(n));
        System.out.println(floor);
        for (int i = 2; i <= floor; i++) {
            for (int j = i*2; j <= n; j += i) {
                map.remove(j);
            }
        }
        return map;
    }

}
