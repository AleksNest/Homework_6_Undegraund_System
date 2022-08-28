public class Main {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();

        UndergroundSystem.checkIn(45, "Leyton", 3);
        UndergroundSystem.checkIn(32, "Paradise", 8);
        UndergroundSystem.checkIn(27, "Leyton", 10);
        UndergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        UndergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        UndergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        System.out.println(UndergroundSystem.getAverageTime("Paradise", "Cambridge")); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        System.out.println(UndergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        UndergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(UndergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000
        UndergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        System.out.println(UndergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12 3"));
    }
}