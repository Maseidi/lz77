import java.util.Scanner;

public class Main {

    static char character;

    static String input;

    public static int[] update(int[] offsetLength, String lookAhead, String searchBuffer) {
        for ( int i = lookAhead.length(); i > 0; i-- ) {
            String subString = lookAhead.substring(0,i);
            System.out.println("Input: "+input);
            System.out.println("Look Ahead: "+lookAhead);
            System.out.println("Search Buffer: "+searchBuffer);
            System.out.println("subString: "+subString);
            if ( searchBuffer.contains(subString) ) {
                offsetLength[0] = searchBuffer.length()-searchBuffer.lastIndexOf(subString);
                offsetLength[1] = subString.length();
                if ( i == lookAhead.length() ) {
                    character = lookAhead.charAt(i-1);
                } else {
                    character = lookAhead.charAt(i);
                }
                System.out.println();
                return offsetLength;
            }
            System.out.println();
        }
        offsetLength[0] = 0;
        offsetLength[1] = 0;
        character = lookAhead.charAt(0);
        System.out.println();
        return offsetLength;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        input = scan.next();

        int lookAheadSize = Integer.parseInt(scan.next());

        String lookAhead;

        String searchBuffer;

        String result = "";

        int[] offsetLength={0,0};

        for ( int i = 0; i < input.length(); i += offsetLength[1]+1 ) {
            if ( i+lookAheadSize <= input.length() ) {
                lookAhead = input.substring(i, i+lookAheadSize);
            } else {
                lookAhead = input.substring(i);
            }
            searchBuffer = input.substring(0, i);
            offsetLength = update(offsetLength, lookAhead,searchBuffer);
            System.out.println("<"+offsetLength[0]+","+offsetLength[1]+","+character+">");
            System.out.println("*********************");
            if ( offsetLength[0] == 0 && offsetLength[1] == 0 ) {
                result += character;
            } else {
                result += ("<" + offsetLength[0] + "," + offsetLength[1] + "," + character + ">");
            }
        }

        System.out.println("Final encoding result: "+result);
    }
}