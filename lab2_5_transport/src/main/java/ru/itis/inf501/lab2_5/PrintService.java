package ru.itis.inf501.lab2_5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PrintService {
    public void printRouteNumberAndTransport(List<Transport> list) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 1; i < maxRouteNumber(list); i++) {
            int count = 0;
            for (Transport t : list) {
                if (t.getRouteNumber().equals("" + i)) {
                    ++count;
                    map.put(t.getRouteNumber(),count);
                }
            }
        }
        System.out.print("Номер маршрута - Количество транспортных средств: ");
        System.out.println(map);
    }

    public void printTransportNumber(List<Transport> list) {
        HashMap<String,Integer> map = new HashMap<>();
        int countBus = 0;
        int countTram = 0;
        int countTroll = 0;
        for (Transport t : list) {
            if (t.getType().equals(TransportType.bus)) {
                countBus++;
            } else if (t.getType().equals(TransportType.trolleybus)) {
                countTroll++;
            } else {
                countTram++;
            }
        }
        map.put("Bus",countBus);
        map.put("Tram",countTram);
        map.put("Trolleybus",countTroll);
        System.out.println(map);
    }

    public void printNumberRoute(List<Transport> list) {
        HashSet<String> set = new HashSet<>();
        for (Transport t : list) {
           set.add(t.getRouteNumber());
        }
        System.out.print("Всего маршрутов: " + (set.size()) + ", а именно: ");
        for (String x : set) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public void printRouteNumberAndTimeEndAndTimeBegin(List<Transport> list) {
        int k = list.size() - 1;
        while (k > 0) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (compare(Integer.parseInt(list.get(i).getRouteNumber()), Integer.parseInt(list.get(i + 1).getRouteNumber())) > 0) {
                    swap(i, i + 1, list);
                }
            }
            k--;
        }

        int n = list.size() - 1;
        while (n > 0) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (Integer.parseInt(list.get(i).getRouteNumber())== Integer.parseInt(list.get(i + 1).getRouteNumber()) && compare(list.get(i).getWorkTimeBegin().charAt(0) , list.get(i + 1).getWorkTimeBegin().charAt(0)) > 0) {
                    swap(i, i + 1, list);
                } else if (Integer.parseInt(list.get(i).getRouteNumber())== Integer.parseInt(list.get(i + 1).getRouteNumber()) && compare(list.get(i).getWorkTimeBegin().charAt(0) , list.get(i + 1).getWorkTimeBegin().charAt(0)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(1) , list.get(i + 1).getWorkTimeBegin().charAt(1)) > 0 ) {
                    swap(i, i + 1, list);
                } else if (Integer.parseInt(list.get(i).getRouteNumber())== Integer.parseInt(list.get(i + 1).getRouteNumber()) && compare(list.get(i).getWorkTimeBegin().charAt(0) , list.get(i + 1).getWorkTimeBegin().charAt(0)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(1) , list.get(i + 1).getWorkTimeBegin().charAt(1)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(3) , list.get(i + 1).getWorkTimeBegin().charAt(3)) > 0) {
                    swap(i,i + 1,list);
                } else if (Integer.parseInt(list.get(i).getRouteNumber())== Integer.parseInt(list.get(i + 1).getRouteNumber()) && compare(list.get(i).getWorkTimeBegin().charAt(0) , list.get(i + 1).getWorkTimeBegin().charAt(0)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(1) , list.get(i + 1).getWorkTimeBegin().charAt(1)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(3) , list.get(i + 1).getWorkTimeBegin().charAt(3)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(4) , list.get(i + 1).getWorkTimeBegin().charAt(4)) > 0) {
                    swap(i, i + 1, list);
                }
            }
            n--;
        }
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getRouteNumber() + " - " + list.get(i).getWorkTimeBegin() + " - " + list.get(i).getWorkTimeEnd());
            if (i != list.size() - 1) System.out.print(", ");
        }
        System.out.println("}");
    }

    public void printNumberAndTimeBegin(List<Transport> list) {
        int k = list.size() - 1;
        while (k > 0) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (compare(Integer.parseInt(list.get(i).getNumber()), Integer.parseInt(list.get(i + 1).getNumber())) > 0) {
                    swap(i, i + 1, list);
                }
            }
            k--;
        }

        int n = list.size() - 1;
        while (n > 0) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (Integer.parseInt(list.get(i).getNumber())== Integer.parseInt(list.get(i + 1).getNumber()) && compare(list.get(i).getWorkTimeBegin().charAt(0) , list.get(i + 1).getWorkTimeBegin().charAt(0)) > 0) {
                    swap(i, i + 1, list);
                } else if (Integer.parseInt(list.get(i).getNumber())== Integer.parseInt(list.get(i + 1).getNumber()) && compare(list.get(i).getWorkTimeBegin().charAt(0) , list.get(i + 1).getWorkTimeBegin().charAt(0)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(1) , list.get(i + 1).getWorkTimeBegin().charAt(1)) > 0 ) {
                    swap(i, i + 1, list);
                } else if (Integer.parseInt(list.get(i).getNumber())== Integer.parseInt(list.get(i + 1).getNumber()) && compare(list.get(i).getWorkTimeBegin().charAt(0) , list.get(i + 1).getWorkTimeBegin().charAt(0)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(1) , list.get(i + 1).getWorkTimeBegin().charAt(1)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(3) , list.get(i + 1).getWorkTimeBegin().charAt(3)) > 0) {
                    swap(i,i + 1,list);
                } else if (Integer.parseInt(list.get(i).getNumber())== Integer.parseInt(list.get(i + 1).getNumber()) && compare(list.get(i).getWorkTimeBegin().charAt(0) , list.get(i + 1).getWorkTimeBegin().charAt(0)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(1) , list.get(i + 1).getWorkTimeBegin().charAt(1)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(3) , list.get(i + 1).getWorkTimeBegin().charAt(3)) == 0 && compare(list.get(i).getWorkTimeBegin().charAt(4) , list.get(i + 1).getWorkTimeBegin().charAt(4)) > 0) {
                    swap(i, i + 1, list);
                }
            }
            n--;
        }
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getNumber() + " - " + list.get(i).getWorkTimeBegin());
            if (i != list.size() - 1) System.out.print(", ");
        }
        System.out.println("}");
    }

    public int compare(int a, int b) {
        return a - b;
    }

    public void swap(int i, int j, List<Transport> a) {
        Transport x = a.get(i);
        a.set(i, a.get(j));
        a.set(j, x);
    }

    public int maxRouteNumber(List<Transport> list) {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (Integer.parseInt(list.get(i).getRouteNumber()) > max) {
                max = Integer.parseInt(list.get(i).getRouteNumber());
            }
        }
        return max;
    }
}