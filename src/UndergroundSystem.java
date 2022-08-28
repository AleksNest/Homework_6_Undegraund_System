import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    static HashMap<Integer, passengerData> trip;                                       // поле поездка (Id пассаж, станция, время)
    static Map<String, HashMap<String, avgObject>> registr;

    public UndergroundSystem() {
        this.trip = new HashMap<>();
        this.registr = new HashMap<>();
    }

    public static void checkIn(int id, String stationName, int t) {                    // фиксация регистрации пассажира с id в момент t на станции отправления

        passengerData newcust = new passengerData(t, stationName);              // создается новый пассажир (время, станция)
        trip.put(id, newcust);                                                   // инициализация поздки по id пассажира (id, время, станция)

    }

    public static void checkOut(int id, String stationName, int t) {                   //  фиксация выписки пассажира с  id со санции прибытия в момент t
        passengerData cust = trip.get(id);
        String startStation = cust.st;                                        // наименование станции прибытия
        int duration = t - cust.t;                                             // расчет времени от станции оправления до станции прибытия

        registr.putIfAbsent(startStation, new HashMap<>());
        HashMap<String, avgObject> endstation = registr.get(startStation);


        avgObject e = endstation.get(stationName);

        if (e != null) {
            e.updateAvg(duration);
        } else {
            avgObject entry = new avgObject(1, duration);
            endstation.put(stationName, entry);
        }
        trip.remove(id);
    }

    public static double getAverageTime(String startStation, String endStation) {
        HashMap<String, avgObject> station = registr.get(startStation);
        avgObject entry = station.get(endStation);
        return (double) entry.total / entry.c;

    }
}