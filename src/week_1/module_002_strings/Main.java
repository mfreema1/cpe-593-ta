package week_1.module_002_strings;

public class Main {

    public static void main(String[] args) {
        naiveSearch("Hello my name is Mark", "Mark");
        boyerMoore("Hello my name is Mark", "Mark");
    }

    /*
    Naive search -- just run through the search string and if we find something
    that could be a match, search forward for it to see if it's there.  If you
    find out that it's not a match, just continue.
     */
    private static void naiveSearch(String search, String target) {
        for(int i = 0; i < search.length(); i++) {
            for(int j = 0; j < target.length(); j++) {
                if(search.charAt(i + j) == target.charAt(j)) {
                    //if it's the last one, we found the whole string
                    if(j == target.length() - 1) {
                        System.out.println("Found at: " + i);
                    }
                } else {
                    //mismatch, no use continuing
                    break;
                }
            }
        }
    }

    //what is the complexity of the naive search? worst case? best case?


    /*
    Boyer-Moore -- sort of like naive search, but with some optimizations.
    We keep a jump table in memory to help instruct us on how quickly we can
    move through the search string.  If we find something that could be part
    of the string, we jump to the last letter of the string and then walk
    backwards from there.
     */
    private static void boyerMoore(String search, String target) {
        //take an ASCII table -- 256 characters
        int[] table = new int[256];
        for(int i = 0; i < table.length; i++) {
            //initialize them all to the max jump
            table[i] = target.length();
        }

        for(int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int index = c; //convert this to index in ASCII table
            table[index] = target.length() - i - 1; //max jump for that letter
        }

        //everything initialized, now scan
        int i = target.length() - 1;
        while(i < search.length()) {
            int jump = table[search.charAt(i)];
            if(jump == 0) { //possible match, walk backwards
                for(int j = 1; j < target.length(); j++) {
                    if(search.charAt(i - j) == target.charAt(target.length() - j - 1)) {
                        //keep going until we know that it's empty
                        if(j == target.length() - 1) {
                            //found it!
                            System.out.println("Found at: " + (i - target.length() + 1));
                            jump = target.length();
                        }
                    } else {
                        //was not a match, jump the full distance
                        jump = target.length();
                        break;
                    }
                }
            }
            i += jump;
        }
    }

    //what's the complexity on that?  worst case?  best case?
}
