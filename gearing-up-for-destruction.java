public class Solution {
    public static int[] solution(int[] pegs) {
        double[] radi = new double[pegs.length]; // Array for all gear radi
        int[] distances = new int[pegs.length - 1]; // Array for all distances between pegs, there will be one less than the amount of pegs
        int mid = 0; // Variable for the midpoint between pegs
        int denom = 1; // Variable for the denominator
        double radius; // Variable that stores the radius to be returned
        for (int i = 0; i < distances.length; i++) {
            distances[i] = pegs[i + 1] - pegs[i]; // Loops through distances array and sets each value to the distance between corresponding pegs
        }
        radi[0] = distances[0] / 2.0; // The first radius gets set to the midpoint of the first distance 
        if (radi[0] % 2.0 != 0.0) {
            radi[0] -= 1.0; // If the first radius is odd 1 is subtracted
        }
        for (int i = 1; i < radi.length; i++) {
            radi[i] =  distances[i - 1] - radi[i - 1]; // Loops through the rest of the radi and sets them to the previous distance minus the previous radius
        }
        radius = radi[0]; // Sets the radius to be returned to the first radius in the radi array
        while (radius % 1 != 0) { // If the radius to be returned is not a whole number, both the radius and denominator is doubled
            radius *= 2;
            denom *= 2;
        }
        if (radi[0] == radi[pegs.length - 1] * 2) { // If the first radius is equal to double the last radius, the radius and denominator are returned
            return new int[] {(int) radius, denom};
        }
        else { // If the peg positions don't work, -1,-1 is returned to signal an error
            return new int[] {-1,-1};
        }
    }
    public static void main(String[] args) {
        int[] ans = solution(new int[] {32,73,236,776});
        System.out.println(Integer.toString(ans[0]) + ", " + Integer.toString(ans[1]));
    }
}
