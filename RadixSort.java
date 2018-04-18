/** Class for doing Radix sort
 *
 * @author Benjamin Ulrich
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        int longestWord = getMaxLength(asciis);
        return sortHelper(asciis, longestWord - 1);
    }

    public static String[] sortHelper(String[] asciis, int index) {
        if (index < 0) {
            return asciis;
        }
        int[] counts = new int[256];
        //phase 2
        for (String str : asciis) {
            int lengthCurrString = str.length() - 1;
            if (lengthCurrString < index) {
                counts[0] ++;
            } else {
                char x = str.charAt(index);
                counts[(int) x] ++;
            }
        }
        String[] newlySorted = createList(counts, asciis, index);
        return sortHelper(newlySorted, index - 1);
    }

    public static String[] createList(int[] counts, String[] asciis, int index) {
        makeCounts(counts);
        String[] newlySort = new String[asciis.length];
        for (String i : asciis) {
            int k = 0;
            if (i.length() > index) {
                k = (int) i.charAt(index);
            }
            newlySort[counts[k]] = i;
            counts[k] ++;
        }
        return newlySort;
    }


    public static void makeCounts(int[] counts) {
        //desructively turns counts into indice list
        int total = 0;
        for (int i = 0; i < counts.length; i ++) {
            int x = counts[i];
            counts[i] = total;
            total += x;
        }
    }

    public static int getMaxLength(String[] str) {
        //returns highest length of string
        int maxLength = 0;
        for (String i: str) {
            int k = i.length();
            if (k > maxLength) {
                maxLength = k;
            }
        }
        return maxLength;
    }
}