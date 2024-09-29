public class replaceCharacters {
     public static void main(String[] args) {
         System.out.println(replaceKlammern("[[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]"));

    }
    public static String replaceKlammern(String s){

         s = s.replaceAll("\\[", "{").replaceAll("\\]", "}");
         return s;
    }
} //( (
