/**
 * Created by Trz1000 on 9/23/2016.
 */

public class Driver {
    static Fork[]FList;
    static Philosopher[]PList;
    public static void main(String[] args){
        if (args[1] == null || args[1] == ""){
            args[1] = "4";
        }
        if (Integer.parseInt(args[2]) == 0){
            args[2] = "10";
        }
        if (Integer.parseInt(args[3]) == 0){
            args[3] = "0";
        }
        if (Integer.parseInt(args[4]) == 0){
            args[4] = "0";
        }

        int philoCount = Integer.parseInt(args[1]);
        FList = new Fork[philoCount];
        for (int z = 0; z < philoCount; z+= 1){
            FList[z] = new Fork(z);
        }
        PList = new Philosopher[philoCount];
        for (int i = 0; i < Integer.parseInt(args[1]); i += 1) {
            if (args[0].equals("-l")) {
                if (i % 2 == 0) {
                    PList[i] = new Philosopher(i, FList[(philoCount + i - 1) % philoCount], FList[i], true,
                            Integer.parseInt(args[2]), Long.parseLong(args[3]), Long.parseLong(args[4]));
                }
                else {
                    PList[i] = new Philosopher(i, FList[(philoCount + i - 1) % philoCount], FList[i], false,
                            Integer.parseInt(args[2]), Long.parseLong(args[3]), Long.parseLong(args[4]));
                }
            }
            else{
                PList[i] = new Philosopher(i, FList[(philoCount + i - 1) % philoCount], FList[i], true,
                        Integer.parseInt(args[2]), Long.parseLong(args[3]), Long.parseLong(args[4]));
            }
        }
    }
}