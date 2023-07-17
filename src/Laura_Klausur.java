import java.util.Arrays;

public class Laura_Klausur {
    static double [] [] Cells = new double[][]{ {},{},{0,2,3,1,3,100.00, 0.00, 0.00}, {0, 0, 0, 3, 2, 200.00, 0.00, 0.00}, {0, 0, 0, 0, 0, 0, -1.00, 4.00} };
    static double ns = Cells[2][1];
    static double nkn = Cells[2][2];
    static double [][] geo = new double[(int) ns + 1][2 + 1];
    static double[] flex = new double[(int) ns + 1];
    static double[][] svlag = new double[(int)nkn + 1] [2 + 1];
   static double[][] globalkfed;
    static double[] globalr;


    public static void main(String[] args){

        for (int i = 1; i <= (int) ns ; i++) {
            flex[i] = Cells[i + 1][5];
            for (int j = 1; j <= 2 ; j++) {
                geo[i][j] = Cells[i + 1][j + 2];
            }
        }
        double nla = nkn;
        for (int i = 1; i <= (int) nkn ; i++) {
            for (int j = 1; j <= 2 ; j++) {
                svlag[i][j] = Cells[i + 1][j + 5];
            }
            if(svlag[i][1] == -1){
                nla = nla - 1;
            }
        }
        double[][] kfed = new double[(int) nkn + 1][(int) nkn + 1];
        double [][] ksys = new double [(int) nla + 1][(int) nla + 1];
        double [] s0 = new double[(int) nkn + 1];
        double[] ssys = new double[(int) nla + 1];
        algo(ns, nkn, geo, flex, svlag, kfed, s0);
        rand(nkn, svlag, globalkfed, globalr, ksys, ssys);
        System.out.println("ns Wert: "+ ns);
        System.out.println("nkn Wert: "+ nkn);
        System.out.println("nla Wert: "+ nla);

        System.out.println("svlag Wert: "+ Arrays.deepToString(svlag));


        //einfügen
    }
    public static void algo(double ns, double nkn, double[][] knoten, double[] feder, double[][] last, double[][] a, double[] r){
        for (int i = 1; i <= ns ; i++) {
            double ix = knoten[i][1];
            double iy = knoten[i][2];
            a[(int) ix][(int) ix] += feder[i];
            a[(int) iy][(int) iy] += feder[i];
            a[(int) ix][(int) iy] += feder[i];
            a[(int) iy][(int) ix] += feder[i];
        }
        for (int i = 1; i <= nkn ; i++) {
            for (int j = 1; j <= nkn ; j++) {
                r[i] += a[i][j] * last[j][2];
            }
        }
        globalkfed = a;
        globalr = r;
        System.out.println("a " + Arrays.deepToString(a));
        System.out.println("r " + Arrays.toString(r));
        System.out.println("Flex " + Arrays.toString(flex));
        System.out.println("Geo Wert: "+ Arrays.deepToString(knoten));

    }
    public static void rand(double nkn, double[][] lager, double[][] a, double[] r, double[][] alag, double[] rlag){
        double ix = 1;
        double iy = 1;
        for (int i = 1; i <= nkn ; i++) {
            if(lager[i][1] == 0){
                rlag[(int) iy] = r[i];
                for (int j = 1; j <= nkn ; j++) {
                    if(lager[j][1] == 0){
                        alag[(int) ix][(int) iy] = a[i][j];
                        ix = ix + 1;
                    }
                }
                ix = 1;
                iy = iy +1;
            }
        }
        System.out.println("global kfed " + Arrays.deepToString(a));
        System.out.println("ksys " + Arrays.deepToString(alag));
        System.out.println("(globalr) s0 " + Arrays.toString(r));
        System.out.println(" rlag " + Arrays.toString(rlag));
        //xD

    }


}
