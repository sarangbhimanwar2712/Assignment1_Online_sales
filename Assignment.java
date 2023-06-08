import java.util.*;

class BiasedEventSimulator {

    private Map<String, Integer> probabilities;

    public BiasedEventSimulator(Map<String, Integer> probabilities) {
        this.probabilities = probabilities;
    }

    public String simulate() {
        int totalProbability = 0;
        for (Object outcome : probabilities.keySet()) {
            totalProbability += probabilities.get(outcome);
        }

        // Generate a random number between 0 and 100.
        int randomNumber = (int) (Math.random() * totalProbability);

        for (String outcome : probabilities.keySet()) {
            //subtracting the probability of each outcome from the random number
            // until the random number is less than or equal to 0
            randomNumber -= probabilities.get(outcome);
            if (randomNumber <= 0) {
                // Return the outcome.
                return outcome;
            }
        }
        //else return null
        return null;
    }

    public static void main(String[] args) {
        Map<String, Integer> probabilities = new HashMap<>();

        // Inputs for Coin
        probabilities.put("Head", 35);
        probabilities.put("Tail", 65);

        //Inputs for dice
//        probabilities.put("1", 0);
//        probabilities.put("2", 30);
//        probabilities.put("3",25);
//        probabilities.put("4",15);
//        probabilities.put("5",30);
//        probabilities.put("6",0);

        BiasedEventSimulator simulator = new BiasedEventSimulator(probabilities);
        int heads = 0;
        int tails = 0;

        int one = 0;
        int two = 0;
        int three =0 ;
        int four = 0;
        int five =0 ;
        int six =0 ;

        // Simulate the event 1000 times.
        for (int i = 0; i < 1000; i++) {
            String outcome = simulator.simulate();
            //output logic for coin
            if (outcome == "Head") {
                heads++;
            } else {
                tails++;
            }

            //Output logic for dice
//            if (outcome == "1") {
//                one++;
//            }else if(outcome == "2") {
//                two++;
//            } else if (outcome == "3") {
//                three++ ;
//            } else if (outcome == "4") {
//                four++ ;
//            } else if (outcome == "5") {
//                five++ ;
//            }else {
//                six++ ;
//            }
//
        }
        //Print Statements for dice
//        System.out.println("1: " + one );
//        System.out.println("2: " + two);
//        System.out.println("3: "+ three);
//        System.out.println("4: "+ four);
//        System.out.println("5: "+ five);
//        System.out.println("6: "+ six);

//        Print statements for Coin
        System.out.println("Heads: " + heads);
        System.out.println("Tails: " + tails);
      
    }
}
