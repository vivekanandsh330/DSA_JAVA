class Solution {
    public String addSpaces(String s, int[] spaces) {
       StringBuilder copy = new StringBuilder();
        int spaceIndex = 0; 
        int spLength = spaces.length;
        for (int i = 0; i < s.length(); i++) {
            if (spaceIndex < spLength && i == spaces[spaceIndex]) {
                copy.append(" ");
                spaceIndex++; 
            }
            copy.append(s.charAt(i)); 
        }
        return copy.toString();
    }
}