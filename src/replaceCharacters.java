public class replaceCharacters {
     public static void main(String[] args) {
         System.out.println(replaceKlammern("[[0,1],[0,3],[1,2],[1,3]]"));

    }
    public static String replaceKlammern(String s){

         s = s.replaceAll("\\[", "{").replaceAll("\\]", "}");
         return s;
    }
} //( (
