package ru.itis.inf501.lab2_5;

import java.util.List;

public class Bubble {

    public List<Transport> sort(List<Transport> a) {
        int k = a.size() - 1;
        while (k > 0) {
            for (int i = 0; i < a.size() - 1; i++) {
                if (compare(Integer.parseInt(a.get(i).getNumber()), Integer.parseInt(a.get(i + 1).getNumber())) > 0) {
                    swap(i, i + 1, a);
                }
//                if (compare(Integer.parseInt(a.get(i).getWorkTimeBegin(), Integer.parseInt(a.get(i + 1).getWorkTimeBegin())) > 0){
//                    swap(i, i+1,a);
//                }
            }
            k--;
        }
        return a;
    }

    public int compare(int a, int b) {
        return a - b;
    }

    public void swap(int i, int j, List<Transport> a) {
        Transport x = a.get(i);
        a.set(i, a.get(j));
        a.set(j, x);
    }
}
