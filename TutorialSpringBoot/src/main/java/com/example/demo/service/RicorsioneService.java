package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RicorsioneService {

    public int fibonacci( int n) {

        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            int res = fibonacci(n-1)+fibonacci(n-2);
            return res;
        }
    }

    //int[] intArr = {1,2,3,4,5,6,7};
    //ricevo in ingresso arr di interi e lo inverte ma farlo in modo ricorsivo
    public int[] reverse(int[] arr, int n, int arrLenght){

        if(n <= arrLenght){
            int x = arr[n]; //salvo il valore attuale
            arr[n] = arr[arrLenght]; //arr[0] diventa arr[6] *fase 1 dell' inversione*
            arr[arrLenght] = x; //arr[6] diventa arr[0] *fase 2 dell' inversione*
            reverse(arr, n+1,arrLenght-1);
        }
        return arr;
    }

}
