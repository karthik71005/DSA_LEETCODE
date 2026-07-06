class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0, countR = 0, make = -1, distance = 0;
        for (int i = 0; i < moves.length(); i++) 
            if (moves.charAt(i) == 'R') countR++;
            else if (moves.charAt(i) == 'L') countL++;

        if (countL > countR) make = 1;
        else make = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R') distance++;
            else if (moves.charAt(i) == 'L') distance--;
            else {
                if (make == 1) distance--;
                else if (make == 0) distance++;
            }

        }
        return Math.abs(distance);
    }
}