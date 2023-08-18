public class replaceCharacters {
     public static void main(String[] args) {
         System.out.println(replaceKlammern("[[1,0,1,1,0,0,1,0,0,1],[0,1,1,0,1,0,1,0,1,1],[0,0,1,0,1,0,0,1,0,0],[1,0,1,0,1,1,1,1,1,1],[0,1,0,1,1,0,0,0,0,1],[0,0,1,0,1,1,1,0,1,0],[0,1,0,1,0,1,0,0,1,1],[1,0,0,0,1,1,1,1,0,1],[1,1,1,1,1,1,1,0,1,0],[1,1,1,1,0,1,0,0,1,1]]"));

    }
    public static String replaceKlammern(String s){

         s = s.replaceAll("\\[", "{").replaceAll("\\]", "}");
         return s;
    }
} //( (
