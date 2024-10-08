import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.sun.source.tree.Tree;
import javafx.util.Pair;
//Änderung wtf is that
// Can i push?


public class Solution {
    double minimalCost = Double.POSITIVE_INFINITY;
    public HashMap<Integer, Integer> Tribu = new HashMap<Integer, Integer>();


    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println( Arrays.toString(s.flipAndInvertImage(new int [][]  {{1,1,0},{1,0,1},{0,0,0}}  ) [0]));
        //System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //System.out.println(s.longestSubsequence(new int[]{4, 12, 10, 0, -2, 7, -8, 9, -9, -12, -12, 8, 8}, 0));
        //s.merge2(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        System.out.println(s.minHeightShelves(new int[][] {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}, 4));

//        try {
//            System.in.read();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        //[3,1,3,1,1]
        //[1,3,2,8,4,9]
        //[7,1,5,3,6,4]
        //[0,1,1,1,0,1,1,0,1]

    }

    private int roman(String s) {

        char[] c = s.toCharArray();
        int erg = 0;

        for (int i = 0; i < c.length; i++) {
            switch (c[i]) {
                case 'I': {
                    if (i != c.length - 1) {
                        switch (c[i + 1]) {
                            case 'V':
                                erg += 4;
                                i++;
                                break;
                            case 'X':
                                erg += 9;
                                i++;
                                break;
                            default:
                                erg++;
                                break;

                        }
                    } else erg += 1;

                    break;
                }
                case 'V': {
                    erg += 5;
                    break;
                }
                case 'X': {
                    if (i != c.length - 1) {
                        switch (c[i + 1]) {
                            case 'L':
                                erg += 40;
                                i++;
                                break;
                            case 'C':
                                erg += 90;
                                i++;
                                break;
                            default:
                                erg += 10;
                                break;

                        }
                    } else erg += 10;

                    break;
                }

                case 'L': {
                    erg += 50;
                    break;
                }

                case 'C': {
                    if (i != c.length - 1) {
                        switch (c[i + 1]) {
                            case 'D':
                                erg += 400;
                                i++;
                                break;
                            case 'M':
                                erg += 900;
                                i++;
                                break;
                            default:
                                erg += 100;
                                break;

                        }
                    } else erg += 100;

                    break;
                }
                case 'D': {
                    erg += 500;
                    break;
                }
                case 'M': {
                    erg += 1000;
                    break;
                }


            }

        }
        return erg;
    }

    private String LongestCommonPrefix(String[] strs) {
        String erg = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char tmp = strs[0].charAt(i);
            boolean append = true;
            for (String s : strs) {
                if (i >= s.length()) {
                    append = false;
                    break;
                }
                if (s.charAt(i) != tmp) {
                    append = false;
                    break;
                }
            }
            if (append) {
                erg = erg + tmp;
            } else {
                break;
            }


        }
        return erg;

    }

    public boolean isHappy(int n) {
        List visited = new ArrayList() {
        };
        boolean Happy = true;
        while (Happy) {
            String Zeichen = Integer.toString(n);
            int erg = 0;
            for (char c : Zeichen.toCharArray()) {
                erg += Math.pow(Integer.parseInt(String.valueOf(c)), 2);

            }
            if (erg == 1) {
                Happy = true;
                break;
            }
            if (visited.contains(erg)) {
                Happy = false;
                break;
            } else {
                visited.add(erg);
            }
            n = erg;
        }
        return Happy;
    }

    public int titleToNumber(String columnTitle) {
        char[] c = columnTitle.toCharArray();//unnötig
        // A = 10, Z = 35
        //System.out.println(Character.getNumericValue('Z') -9);
        int exp = 0;
        int erg = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            erg += (Character.getNumericValue(c[i]) - 9) * (Math.pow(26, exp));
            exp++;

        }
        return erg;

    }

    public int maxLengthBetweenEqualCharacters(String s) {
        /*HashMap<Character , ArrayList<Integer>> h = new HashMap<Character, ArrayList<Integer>>();
        int max = 0;
        for (int i = 0; i < s.length() ; i++) {
            if(!h.containsKey(s.charAt(i))){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(0);
                //tmp.set(0, tmp.get(0)+1); addet 1 für den ersten Eintrag
                h.put(s.charAt(i), tmp);

            }
            else{

            }

        }

         */

        ArrayList<Character> a = new ArrayList<Character>();//Speicher um Matchende Character zu finden.
        int max = 0;
        boolean nothing = true;
        for (int i = 0; i < s.length(); i++) {
            if (!a.contains(s.charAt(i))) {
                a.add(s.charAt(i));
                continue;
            } else {
                nothing = false;
                int tmp = Math.abs(i - s.indexOf(s.charAt(i))) - 1;
                max = Math.max(max, tmp);
            }


        }
        if (nothing)
            max = -1;
        return max;


    }

    public int findJudge(int n, int[][] trust) {
        //Array [n - Person] [Trusten der Person, die Person Trustet denen]
        int[][] person = new int[n][2];
        for (int i = 0; i < trust.length; i++) {
            int Truster = (trust[i][0]) - 1;
            int WirdVertraut = (trust[i][1]) - 1;
            //if(person[Truster][1]== null){ ist das dann schon mit Nullen init?
            person[Truster][1]++;
            person[WirdVertraut][0]++;
        }
        int judge = -1;
        for (int j = 0; j < person.length; j++) {
            if (person[j][0] == n - 1 && person[j][1] == 0) {
                judge = j + 1;
                break;
            }
        }
        return judge;

    }

//hier weitermachen lol xDDD


    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;

    }

    public int guess(int n) {
        return 0;
    }

    public int guessNumber(int n) {
        int Divider = (int) Math.ceil((float) n / 2);
        int Pick = n - Divider;
        while (true) {
            int currentGuess = guess(Pick);
            if (currentGuess == 0)
                break;
            else if (currentGuess == -1) { //num is higher than the picked Number
                Divider = (int) Math.ceil((float) Divider / 2);
                Pick = Pick - Divider;
            } else { // if num is lower than the picked number
                Divider = (int) Math.ceil((float) Divider / 2);
                Pick = Pick + Divider;
            }
        }
        return Pick;

    }

    public int[] decode(int[] encoded, int first) {
        int[] decode = new int[encoded.length + 1];
        decode[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            int ArrayAt = encoded[i];
            decode[i + 1] = first ^ ArrayAt;
            first = decode[i + 1];
        }
        return decode;

    }

    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int counter = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int tmp = Math.min(rectangles[i][0], rectangles[i][1]);
            if (tmp > max) {
                max = tmp;
                counter = 1;
            } else if (tmp == max) {
                counter++;

            } else
                continue;
        }
        return counter;

    }

    public int[][] flipAndInvertImage(int[][] image) {
        int[][] result = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                int tmp = image[i][image[i].length - (j + 1)];
                result[i][j] = (tmp == 1) ? 0 : 1;
            }
        }
        return result;

    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x_distance = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        if (x_distance <= 0)
            return false;
        int y_distance = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        if (y_distance <= 0)
            return false;
        return true;
    }

    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            result = result ^ nums[i];
        }
        return result;

    }

    public double average(int[] salary) {
        int max = salary[0], min = salary[0];
        double gesamt = 0;
        for (int bezahlung : salary
        ) {
            gesamt += bezahlung;
            min = Math.min(min, bezahlung);
            max = Math.max(max, bezahlung);
        }
        gesamt -= (max + min);
        return (double) (gesamt / (salary.length - 2));
    }

    public boolean isPathCrossing(String path) {
        List visited = new LinkedList<int[]>();
        int[] position = {0, 0};
        visited.add(new int[]{position[0], position[1]});

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            switch (c) {
                case 'N': {
                    position[0] += 1;
                    break;
                }
                case 'S': {
                    position[0] -= 1;
                    break;
                }
                case 'W': {
                    position[1] -= 1;
                    break;
                }
                case 'E': {
                    position[1] += 1;
                    break;
                }
                default:
                    throw new IllegalArgumentException("Nicht so spezifiziert du Schwackkopf xDDDD lol");

            }
            if (isInList(visited, new int[]{position[0], position[1]})) {
                return true;
            } else {
                visited.add(new int[]{position[0], position[1]});
            }
        }
        return false;


    }

    public static boolean isInList(
            final List<int[]> list, final int[] candidate) {

        return list.stream().anyMatch(a -> Arrays.equals(a, candidate));
        //  ^-- or you may want to use .parallelStream() here instead
    }

    public String replaceWords3(List<String> dictionary, String sentence) {
        String[] strgs = sentence.split(" ");
        int counter = 0;
        String ergebnis = "";
        for (String Wort : strgs
        ) {
            String replace = Wort;
            double min = Double.POSITIVE_INFINITY;
            for (String potReplace : dictionary) {
                if (Wort.startsWith(potReplace) && potReplace.length() < min) {
                    replace = potReplace;
                    min = potReplace.length();
                }
            }
            if (counter < strgs.length - 1) {
                ergebnis = ergebnis + replace + " ";
            } else {
                ergebnis = ergebnis + replace;
            }
            counter++;

        }
        return ergebnis;
//        String result = strgs[0];
//        for (int i = 1; i < strgs.length ; i++) {
//            result = result + strgs[i];
//        }
//        return result;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int FlowerCounter = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1)
                continue;
            int leftNeighbour = (i - 1 >= 0) ? flowerbed[i - 1] : 0; //Damn bin ich ein krasser Dude xDD
            int rightNeighbour = (i + 1 < flowerbed.length) ? flowerbed[i + 1] : 0; //Damn bin ich ein krasser Dude xDD
            if (leftNeighbour == 0 && rightNeighbour == 0) {
                FlowerCounter++;
                flowerbed[i] = 1;
            } else {
                continue;
            }

        }
        return FlowerCounter >= n;

    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalPoisonedTime = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == timeSeries.length - 1) {
                totalPoisonedTime += duration;
                continue;
            }
            if ((timeSeries[i] + duration - 1) >= timeSeries[i + 1]) {
                totalPoisonedTime += timeSeries[i + 1] - (timeSeries[i]);
            } else {
                totalPoisonedTime += duration;
            }

        }
        return totalPoisonedTime;

    }

    public char nextGreatestLetter(char[] letters, char target) {
        char ResultLetter = letters[0];
        for (char Buchstabe :
                letters) {
            if (Buchstabe > target) { //Ziel Buchstabe gefunden.
                ResultLetter = Buchstabe;
                break;
            }
        }
        return ResultLetter;
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] minArray = new int[cost.length + 2];
        minArray[cost.length] = 0;
        minArray[cost.length + 1] = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int currentMin = Math.min(minArray[i + 1], minArray[i + 2]);
            minArray[i] = currentMin + cost[i];
        }
        return Math.min(minArray[0], minArray[1]);

    }

    private int minCostHelper(int[] cost, int totalCost, int step) {
        if (totalCost > minimalCost)
            return totalCost;
        if (step > cost.length - 1) {
            minimalCost = Math.min(totalCost, minimalCost);
            return totalCost;
        }
        totalCost += cost[step];
        int oneStep = minCostHelper(cost, totalCost, step + 1);
        int twoStep = minCostHelper(cost, totalCost, step + 2);
        int possibleMin = Math.min(oneStep, twoStep);
        minimalCost = Math.min(possibleMin, minimalCost);
        return possibleMin;
    }

    public int climbStairs(int n) {
        int[] resultArray = new int[n];
        resultArray[0] = 1;
        if (n == 1)
            return 1;
        resultArray[1] = 2;
        for (int i = 2; i < n; i++) {
            resultArray[i] = resultArray[i - 1] + resultArray[i - 2];
        }
        return resultArray[n - 1];

    }

    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int currentIndex = 0;
        int minRounds = 0;
        while (currentIndex != tasks.length) {
            int currentTaskDiff = tasks[currentIndex];
            int counter = 1;
            while (true) {
                currentIndex++;
                if (currentIndex == tasks.length)
                    break;
                if (tasks[currentIndex] == currentTaskDiff) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter != 1) {
                minRounds += (int) Math.ceil((double) counter / 3);
            } else {
                return -1;
            }
        }
        return minRounds;

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> Karte = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (Karte.containsKey(diff)) {
                return new int[]{i, Karte.get(diff)};
            }
            Karte.put(nums[i], i);

        }
        return new int[]{-1, -1};
    }

    private int[] twoSumsHelper(int[] nums, int target, int index, int currentTotal, List<Integer> result) {
        if (currentTotal == target) {
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        if (currentTotal > target) {
            return null;
        }
        if (index >= nums.length)
            return null;
        int[] without = twoSumsHelper(nums, target, index + 1, currentTotal, new ArrayList<Integer>(result));
        result.add(index);
        int[] with = twoSumsHelper(nums, target, index + 1, currentTotal + nums[index], new ArrayList<Integer>(result));
        if (without != null)
            return without;
        else
            return with;

    }

    public int tribonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 0)
            return 0;
        int n_th_number = n - 3;
        int n1_th_number = n - 2;
        int n2_th_number = n - 1;
        if (Tribu.containsKey(n_th_number))
            n_th_number = Tribu.get(n_th_number);
        else {
            n_th_number = tribonacci(n_th_number);
            Tribu.put(n - 3, n_th_number);
        }

        if (Tribu.containsKey(n1_th_number))
            n1_th_number = Tribu.get(n1_th_number);
        else {
            n1_th_number = tribonacci(n1_th_number);
            Tribu.put(n - 2, n1_th_number);
        }

        if (Tribu.containsKey(n2_th_number))
            n2_th_number = Tribu.get(n2_th_number);
        else {
            n2_th_number = tribonacci(n2_th_number);
            Tribu.put(n - 1, n2_th_number);
        }
        return n_th_number + n1_th_number + n2_th_number;
    }

    public boolean isPowerOfTwo(int n) {
        String s = Integer.toBinaryString(n);
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                counter++;
                if (counter >= 2)
                    return false;
            }
        }
        return counter == 1 && n >= 0;
    }

    public int maxLengthBetweenEqualCharacters2(String s) {
        int MaxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            char Buchstabe = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == Buchstabe && (j - 1 - i) > MaxLength) {
                    MaxLength = (j - 1 - i);
                }
            }
        }
        return MaxLength;

    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxGrad = new int[n - 2][n - 2];
        for (int i = 0; i < maxGrad.length; i++) {
            for (int j = 0; j < maxGrad[0].length; j++) {
                int middle_x = i + 1;
                int middle_y = j + 1;
                int max = grid[middle_x][middle_y];
                max = Math.max(max, grid[middle_x + 1][middle_y]);
                max = Math.max(max, grid[middle_x - 1][middle_y]);
                max = Math.max(max, grid[middle_x - 1][middle_y - 1]);
                max = Math.max(max, grid[middle_x - 1][middle_y + 1]);
                max = Math.max(max, grid[middle_x + 1][middle_y + 1]);
                max = Math.max(max, grid[middle_x + 1][middle_y - 1]);
                max = Math.max(max, grid[middle_x][middle_y + 1]);
                max = Math.max(max, grid[middle_x][middle_y - 1]);
                maxGrad[i][j] = max;
            }

        }
        return maxGrad;

    }


    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0];
        char LongestKey = keysPressed.charAt(0);
        for (int i = 1; i < keysPressed.length(); i++) {
            int tmpDuration = releaseTimes[i] - releaseTimes[i - 1];
            char c = keysPressed.charAt(i);
            if (tmpDuration >= maxDuration) {
                if (tmpDuration > maxDuration)
                    LongestKey = c;
                else
                    LongestKey = (c > LongestKey) ? c : LongestKey;
                maxDuration = tmpDuration;
            }
        }
        return LongestKey;
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (int) Math.floor((double) (end - start) / 2);
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;

            }
        }
        return start;
    }

    public boolean isFascinating(int n) {
        String zweiN = Integer.toString(2 * n);
        String dreiN = Integer.toString(3 * n);
        String resZahl = Integer.toString(n) + zweiN + dreiN;
        List<Character> kev = new LinkedList<Character>();
        for (int i = 0; i < resZahl.length(); i++) {
            char c = resZahl.charAt(i);
            if (c == '0' || kev.contains(c))
                return false;
            else
                kev.add(c);
        }
        return kev.size() == 9;

    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        int leastindex = list1.length + list2.length;
        List<String> resultList = new LinkedList<String>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j < leastindex) {
                        resultList.clear();
                        resultList.add(list1[i]);
                        leastindex = i + j;
                    } else if (i + j == leastindex) {
                        resultList.add(list1[i]);
                    }
                }

            }
        }
        return resultList.toArray(new String[0]); //mit Map machen :( Ich lerne dass ich öfter an Map denken muss!

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public int maxLevelSum(TreeNode root) {
        HashMap<Integer, Integer> levels = new HashMap<Integer, Integer>();
        maxLevelSumhelper(root, levels, 1);
        return Collections.max(levels.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private void maxLevelSumhelper(TreeNode currNode, HashMap<Integer, Integer> levels, int currLevel) {
        levels.merge(currLevel, currNode.val, (oldValue, newValue) -> oldValue + newValue);
        TreeNode left = currNode.left;
        TreeNode right = currNode.right;
        if (left != null) {
            maxLevelSumhelper(left, levels, currLevel + 1);
        }
        if (right != null) {
            maxLevelSumhelper(right, levels, currLevel + 1);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int currentMin = prices[0];
        int currentMax = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > currentMin) {
                profit = profit + (prices[i] - currentMin);
                currentMin = prices[i];
                continue;
            }
            if (prices[i] < currentMin)
                currentMin = prices[i];
        }
        return profit;


    }

    private int maxProfitHelper(int[] prices, int currIndex, boolean bought, int P_length, int currentProfit, int maxProfit) {
        if (currIndex >= P_length) {
            return currentProfit;
        }
        if (!bought) {
            int not_b = maxProfitHelper(prices, currIndex + 1, false, P_length, currentProfit, maxProfit);
            if (currIndex < P_length - 1 && (prices[currIndex] > prices[currIndex + 1]))
                return Math.max(not_b, maxProfit);
            currentProfit = currentProfit - prices[currIndex];
            int did_b = maxProfitHelper(prices, currIndex + 1, true, P_length, currentProfit, maxProfit);
            return Math.max(Math.max(not_b, did_b), maxProfit);
        } else {
            int not_s = maxProfitHelper(prices, currIndex + 1, true, P_length, currentProfit, maxProfit);
            currentProfit = currentProfit + prices[currIndex];
            if (currentProfit <= 0)
                return Math.max(not_s, maxProfit);
            int did_s = maxProfitHelper(prices, currIndex + 1, false, P_length, currentProfit, maxProfit);
            return Math.max(Math.max(not_s, did_s), maxProfit);
        }

    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> CountList = new HashMap<Integer, Integer>();
        int majority = 0;
        for (int i : nums
        ) {
            CountList.merge(i, 1, (oldvalue, newvalue) -> oldvalue + 1);
            if (CountList.get(i) >= (double) nums.length / 2) {
                majority = i;
                break;
            }
        }
        return majority;
    }

    public int largestAltitude(int[] gain) {
        int heighest = 0;
        int currentAltitude = 0;
        for (int i :
                gain) {
            currentAltitude += i;
            heighest = Math.max(heighest, currentAltitude);
        }
        return heighest;
    }

    public int minSessions(int[] tasks, int sessionTime) {
        List<Integer> list = new ArrayList<>(Arrays.stream(tasks).boxed().toList());
        int minCounter = (int) Double.POSITIVE_INFINITY;
        return minSessionsHelper((ArrayList<Integer>) list, sessionTime, sessionTime, minCounter);


    }

    private int minSessionsHelper(ArrayList<Integer> list, int remTime, int sessTime, int min) {
        if (list.isEmpty())
            return 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= remTime) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(list);
                tmp.remove(i);
                min = Math.min(minSessionsHelper(tmp, remTime - list.get(i), sessTime, min), min);
            } else {
                ArrayList<Integer> tmp = new ArrayList<Integer>(list);
                tmp.remove(i);
                min = Math.min(minSessionsHelper(tmp, sessTime - list.get(i), sessTime, min) + 1, min);

            }

        }
        return min;

    }

    public int[] getAverages(int[] nums, int k) {
        int[] average = new int[nums.length];
        long[] sumArray = new long[nums.length];
        int x = 2 * k + 1;
        for (int i = 0; i < nums.length; i++) {
            long res = 0;
            if (i - k < 0 || i + k >= nums.length)
                average[i] = -1;
            else if (i - k - 1 >= 0) {
                sumArray[i] = sumArray[i - 1] - nums[i - k - 1] + nums[i + k];
                average[i] = (int) (sumArray[i] / x);
            } else {

                for (int j = i - k; j <= i + k; j++) {
                    res += nums[j];
                }
                average[i] = (int) (res / x);
                sumArray[i] = res;
            }
        }
        return average;

    }

    //    public long minCost(int[] nums, int[] cost) {
//        long min_cost = Long.MAX_VALUE;
//        for (int i = 0; i < nums.length ; i++) {
//            long element = nums[i];
//            long currentCost = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if(currentCost >= min_cost)
//                    break;
//                if (i == j)
//                    continue;
//                currentCost += Math.abs((element - nums[j]) * cost[j]);
//
//            }
//            min_cost = Math.min(min_cost, currentCost);
//        }
//        return min_cost;
//
//    }
    public long minCost(int[] nums, int[] cost) {
        int left = nums[0];
        int right = nums[0];
        for (int i : nums) {
            left = Math.min(left, i);
            right = Math.max(right, i);
        }
        long ans = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            long cost1 = minCosthelper(nums, cost, mid);
            long cost2 = minCosthelper(nums, cost, mid + 1);
            if (cost1 > cost2) {
                left = mid + 1;
                ans = cost2;
            } else {
                right = mid;
                ans = cost1;
            }

        }
        return ans;
    }

    public long minCosthelper(int[] nums, int[] cost, int all) {
        long totalCost = 0L;
        for (int i = 0; i < nums.length; i++) {
            totalCost += (long) Math.abs(nums[i] - all) * cost[i];
        }
        return totalCost;
    }

    //    public int maxProfit(int[] prices, int fee) {
//        int currentMin = prices[0];
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length ; i++) {
//            if(prices[i] - fee > currentMin){
//                maxProfit += (prices[i] - fee) - currentMin;
//                currentMin = prices[i];
//                continue;
//            }
//            if(prices[i] < currentMin)
//                currentMin = prices[i];
//
//        }
//        return maxProfit;
//
//    }
    public int maxProfit(int[] prices, int fee) {
        return maxProfitHelper2(prices, fee, 0, 0, prices[0]);
    }

    private int maxProfitHelper2(int[] prices, int fee, int index, int maxProfit, int currentMin) {


        for (int i = index; i < prices.length; i++) {
            if (prices[i] - fee > currentMin) {
                int tmp1 = maxProfitHelper2(prices, fee, i + 1, maxProfit + (prices[i] - fee) - currentMin, prices[i]);
                int tmp2 = maxProfitHelper2(prices, fee, i + 1, maxProfit, currentMin);
                return Math.max(tmp1, tmp2);
            }
            if (prices[i] < currentMin)
                currentMin = prices[i];

        }
        return maxProfit;

    }

    private int maxProfitHelper(int[] prices, int fee, int index, int currentProfit, boolean bought) {
        if (index >= prices.length) {
            return currentProfit;
        }
        if (bought) {
            int tmp1 = maxProfitHelper(prices, fee, index + 1, currentProfit + prices[index] - fee, false);
            int tmp2 = maxProfitHelper(prices, fee, index + 1, currentProfit, true);
            return Math.max(tmp1, tmp2);
        } else {
            int tmp1 = maxProfitHelper(prices, fee, index + 1, currentProfit - prices[index], true);
            int tmp2 = maxProfitHelper(prices, fee, index + 1, currentProfit, false);
            return Math.max(tmp1, tmp2);
        }

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(((a, b) -> a[0] - b[0]));
        List<List<Integer>> res = new LinkedList<>();
        Set<String> visited = new HashSet<String>();
        queue.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add("0,0");
        int n = nums1.length;
        int m = nums2.length;
        k--;
        while (k-- >= 0 && !queue.isEmpty()) {
            int[] tmp = queue.poll();
            int firstIndex = tmp[1];
            int secondIndex = tmp[2];
            res.add(List.of(nums1[firstIndex], nums2[secondIndex]));
            if (firstIndex + 1 < n && !visited.contains(Integer.toString(firstIndex + 1) + "," + Integer.toString(secondIndex))) {
                queue.offer(new int[]{nums1[firstIndex + 1] + nums2[secondIndex], firstIndex + 1, secondIndex});
                visited.add(Integer.toString(firstIndex + 1) + "," + Integer.toString(secondIndex));
            }
            if (secondIndex + 1 < m && !visited.contains(Integer.toString(firstIndex) + "," + Integer.toString(secondIndex + 1))) {
                queue.offer(new int[]{nums1[firstIndex] + nums2[secondIndex + 1], firstIndex, secondIndex + 1});
                visited.add(Integer.toString(firstIndex) + "," + Integer.toString(secondIndex + 1));
            }

        }
        return res;


    }

    public boolean isValid(String s) {
        Stack<Character> stapel = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character currentC = s.charAt(i);
            switch (currentC) {
                case '(' -> stapel.push(currentC);
                case '[' -> stapel.push(currentC);
                case '{' -> stapel.push(currentC);
                case ')' -> {
                    if (stapel.isEmpty() || !stapel.pop().equals('(')) {
                        return false;
                    }
                }
                case ']' -> {
                    if (stapel.isEmpty() || !stapel.pop().equals('[')) {
                        return false;
                    }
                }
                case '}' -> {
                    if (stapel.isEmpty() || !stapel.pop().equals('{')) {
                        return false;
                    }
                }
                default -> {
                    return false;
                }
            }
        }
        return stapel.isEmpty();

    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        int currentMin = prices[0];
        for (int i : prices
        ) {
            if (currentMin > i) {
                currentMin = i;
            } else {
                max = Math.max(i - currentMin, max);
            }

        }
        return max;

    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> kevMap = new HashMap<Integer, Integer>(nums.length);
        for (int i :
                nums) {
            if (kevMap.containsKey(i))
                return true;
            else
                kevMap.put(i, 1);

        }
        return false;

    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> kevSet = new HashMap<Character, Integer>();
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentC = s.charAt(i);
            if (kevSet.containsKey(currentC)) {
                i = kevSet.get(currentC);
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
                kevSet.clear();
            } else {
                currentLength++;
                kevSet.put(currentC, i);
            }
        }
        maxLength = Math.max(currentLength, maxLength);
        return maxLength;
    }

    public int distributeCookies(int[] cookies, int k) {
        if (k == cookies.length) {
            Arrays.sort(cookies);
            return cookies[cookies.length - 1];
        } else if (k == cookies.length - 1) {
            Arrays.sort(cookies);
            if (cookies.length >= 2) {
                return Math.max(cookies[cookies.length - 1], (cookies[0] + cookies[1]));
            } else
                return cookies[0];
        } else {
            int[] childs = new int[k];
            return CookieHelper(cookies, 0, k, childs);

        }

    }

    private int CookieHelper(int[] CookieList, int index, int k, int[] childs) {
        if (index >= CookieList.length) {
            Arrays.sort(childs);
            return childs[childs.length - 1];
        }
        int min = (int) Double.POSITIVE_INFINITY;
        for (int i = 0; i < k; i++) {
            childs[i] += CookieList[index];
            min = Math.min(min, CookieHelper(CookieList, index + 1, k, childs));
            childs[i] -= CookieList[index];

        }
        return min;


    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        if (s.equals(goal)) {
            // If we have 2 same characters in string 's',
            // we can swap them and still the strings will remain equal.
            int[] frequency = new int[26];
            for (char ch : s.toCharArray()) {
                frequency[ch - 'a'] += 1;
                if (frequency[ch - 'a'] == 2) {
                    return true;
                }
            }
            // Otherwise, if we swap any two characters, it will make the strings unequal.
            return false;
        }

        char FirstFalse = 0;
        char FirstRight = 0;
        char SecondFalse;
        char SecondRight;
        int index = 0;
        boolean first = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i) && first) {
                FirstFalse = s.charAt(i);
                FirstRight = goal.charAt(i);
                first = false;
                index = i;
            } else if (s.charAt(i) != goal.charAt(i)) {
                SecondFalse = s.charAt(i);
                SecondRight = goal.charAt(i);
                if (FirstRight == SecondFalse && SecondRight == FirstFalse) {
                    StringBuilder mytmp = new StringBuilder(s);
                    mytmp.setCharAt(index, SecondFalse);
                    mytmp.setCharAt(i, FirstFalse);
                    return mytmp.toString().equals(goal);

                } else
                    return false;
            }

        }
        return false;

    }

    // Returns the delta Y.
    int getYDiff(int[] a, int[] b) {
        return a[1] - b[1];
    }

    // Returns the delta X.
    int getXDiff(int[] a, int[] b) {
        return a[0] - b[0];
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int deltaY = getYDiff(coordinates[1], coordinates[0]);
        int deltaX = getXDiff(coordinates[1], coordinates[0]);

        for (int i = 2; i < coordinates.length; i++) {
            // Check if the slope between points 0 and i, is the same as between 0 and 1.
            if (deltaY * getXDiff(coordinates[i], coordinates[0])
                    != deltaX * getYDiff(coordinates[i], coordinates[0])) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int j = s.length() - 1;
        int upto = (int) (Math.ceil((double) s.length() / 2));
        for (int i = 0; i < upto; i++) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            j--;
        }
        return true;

    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        HashSet<Integer> single = new HashSet<>();
        for (int i : nums
        ) {
            numMap.merge(i, 1, (oldvalue, newvalue) -> oldvalue + 1);
            if (numMap.get(i) == 1) {
                single.add(i);
            } else if (numMap.get(i) == 3) {
                single.remove(i);
            }

        }
        return (int) single.toArray()[0];

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> sHash = new HashMap<>();
        HashMap<Character, Integer> tHash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sHash.merge(s.charAt(i), 1, (oldvalue, newvalue) -> oldvalue + 1);
            tHash.merge(t.charAt(i), 1, (oldvalue, newvalue) -> oldvalue + 1);
        }
        for (Map.Entry<Character, Integer> entry : sHash.entrySet()) {
            if (!tHash.containsKey(entry.getKey()) || !tHash.get(entry.getKey()).equals(sHash.get(entry.getKey()))) //bruh
                return false;

        }
        return true;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder kev = new StringBuilder();
        StringBuilder kevl2 = new StringBuilder();
        ListNode currentNode = l1;
        while (currentNode != null) {
            kev.append(currentNode.val);
            currentNode = currentNode.next;
        }

        currentNode = l2;
        while (currentNode != null) {
            kevl2.append(currentNode.val);
            currentNode = currentNode.next;

        }
        String s1 = kev.toString();
        String s2 = kevl2.toString();
        StringBuilder sb = new StringBuilder();
        int merke = 0;
        if (s1.length() >= s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                int tmp = 0;
                if (i < s2.length())
                    tmp = Character.getNumericValue(s2.charAt(i));
                int value = Character.getNumericValue(s1.charAt(i));
                if (merke + value + tmp >= 10) {
                    sb.append((merke + value + tmp) % 10);
                    merke = 1;
                } else {
                    sb.append((merke + value + tmp) % 10);
                    merke = 0;
                }

            }
        } else {
            for (int i = 0; i < s2.length(); i++) {
                int tmp = 0;
                if (i < s1.length())
                    tmp = Character.getNumericValue(s1.charAt(i));
                int value = Character.getNumericValue(s2.charAt(i));
                if (merke + value + tmp >= 10) {
                    sb.append((merke + value + tmp) % 10);
                    merke = 1;
                } else {
                    sb.append((merke + value + tmp) % 10);
                    merke = 0;
                }

            }

        }
        if (merke == 1)
            sb.append(1);
        System.out.println(sb.toString());
        char[] shutUp = sb.toString().toCharArray();
        ListNode ResNode = new ListNode();
        ListNode tmp = ResNode;
        for (int i = 0; i < shutUp.length; i++) {
            tmp.val = Character.getNumericValue(shutUp[i]); //Character.getNumericValue(c)
            if (i < shutUp.length - 1) {
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
        }
        return ResNode;

        //        BigInteger value1 = new BigInteger(kev.reverse().toString());
//        BigInteger value2 = new BigInteger(kevl2.reverse().toString());
//        value2 = value2.add(value1);
//        String myValue = value2.toString();
//        System.out.println(myValue);
//        StringBuilder sb = new StringBuilder(myValue);

    }

    public int longestSubarray(int[] nums) {
        int maxLength = 0;
        int startPoint = 0;
        int EndPoint = 0;
        int nextIndex = 0;
        boolean neverZero = true;
        boolean containsZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                EndPoint++;
            } else if (nums[i] == 0 && !containsZero) {
                neverZero = false;
                nextIndex = i;
                containsZero = true;
                continue;
            } else { // ist 0 und enthält schon eine Null
                i = nextIndex;
                maxLength = Math.max(maxLength, EndPoint - startPoint);
                startPoint = nextIndex + 1;
                EndPoint = startPoint;
                containsZero = false;

            }

        }
        return (neverZero) ? Math.max(maxLength, EndPoint - startPoint) - 1 : Math.max(maxLength, EndPoint - startPoint);

    }

    //    public int minSubArrayLen(int target, int[] nums) {
//        int minLength = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            int currentSum = nums[i];
//            int index = i + 1;
//            while(currentSum < target && index < nums.length ){
//                currentSum += nums[index];
//                index++;
//            }
//            if(currentSum >= target){
//                minLength = Math.min(minLength, (index - 1) - i);
//            }
//
//        }
//
//    }
    public int minSubArrayLen(int target, int[] nums) { //works!!!
        int minLength = nums.length;
        int startpoint = 0;
        int currentSum = 0;
        boolean neverAchieved = true;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while (currentSum >= target) {
                minLength = Math.min(minLength, (i - startpoint) + 1);
                neverAchieved = false;
                currentSum -= nums[startpoint];
                startpoint++;
            }
        }
        return (neverAchieved) ? 0 : minLength;
    }

    public int removeDuplicates(int[] nums) {
        int inputIndex = 0;
        int numberUnique = 0;
        int heighestNumber = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > heighestNumber) {
                nums[inputIndex] = nums[i];
                inputIndex++;
                numberUnique++;
                heighestNumber = nums[i];
            }
        }
        return numberUnique;

    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int TCounter = 0;
        int FCounter = 0;
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) == 'T') {
                TCounter++;
            } else
                FCounter++;
            int minNumber = Math.min(TCounter, FCounter);
            while (minNumber > k) {
                if (answerKey.charAt(startIndex) == 'T')
                    TCounter--;
                else
                    FCounter--;
                startIndex++;
                minNumber = Math.min(TCounter, FCounter);
            }
            maxLength = Math.max(maxLength, (i - startIndex) + 1);
        }
        return maxLength;

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (i > 0 && value == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int tmp = value + nums[j];
                if (findInArray(j + 1, nums, -tmp)) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(value);
                    tmpList.add(nums[j]);
                    tmpList.add(-tmp);
                    //if(!resList.contains(tmpList))
                    resList.add(tmpList);

                }

            }
        }
        return resList;

    }

    private boolean findInArray(int startpoint, int[] nums, int target) {
        int endpoint = nums.length - 1;
        int mid = ((endpoint + startpoint) / 2);
        while (startpoint <= endpoint) {
            if (nums[mid] == target) {
                return true;
            } else if (target > nums[mid]) {
                startpoint = mid + 1;
                mid = ((endpoint + startpoint) / 2);
            } else {
                endpoint = mid - 1;
                mid = ((endpoint + startpoint) / 2);
            }
        }
        return false;

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    int minDepthLength;

    public int minDepth(TreeNode root) {
        minDepthLength = (int) Double.POSITIVE_INFINITY;
        if (root == null)
            return 0;
        else
            return minDepthHelper(root, 0);

    }

    private int minDepthHelper(TreeNode root, int currentMinDepth) {
        currentMinDepth++;
        if (currentMinDepth >= minDepthLength) //optimization
            return currentMinDepth;
        if (root.left == null && root.right == null) {
            //Base Case
            minDepthLength = Math.min(currentMinDepth, minDepthLength);
            return minDepthLength;
        }
        if (root.left != null)
            minDepthHelper(root.left, currentMinDepth);
        if (root.right != null)
            minDepthHelper(root.right, currentMinDepth);
        return minDepthLength;
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        char digit = (char) Math.abs(Character.getNumericValue(s.charAt(0)) - 1);  //mega Brain move
        System.out.println(digit);
        int count_Digit = 0;
        boolean firstTime = true;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()
        ) {
            if (c == digit) {
                count_Digit++;
            } else if (firstTime) {
                digit = c;
                count_Digit = 1;
                firstTime = false;
            } else {
                sb.append(count_Digit);
                sb.append(digit);
                digit = c;
                count_Digit = 1;
            }

        }
        sb.append(count_Digit);
        sb.append(digit);
        return sb.toString();
    }

    public int mySqrt(int x) { //maybe Binary Search.
        long start = 0;
        long end = x;
        long mid = (start + end) / 2;
        while (start <= end) {
            if (mid * mid == x) // Base Case
                return (int) mid;
            else if (x > mid * mid) {
                start = mid + 1;
                mid = (start + end) / 2;
            } else {
                end = mid - 1;
                mid = (start + end) / 2;
            }
        }
        return (int) mid;
    }

    List<Integer> distanceKList = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        distanceKList.clear();
        distanceKHelper(root, target, k, 0, false);
        return distanceKList;

    }

    private int distanceKHelper(TreeNode root, TreeNode target, int k, int currentK, boolean downwards) {
        if (downwards) {
            if (root == null)
                return -1;
            if (currentK == k) {
                distanceKList.add(root.val);
                return -1;
            }
            if (currentK < k) {
                distanceKHelper(root.left, target, k, currentK + 1, true);
                distanceKHelper(root.right, target, k, currentK + 1, true);
                return -1;

            } else {
                return -1;
            }
        } else {
            if (root == null)
                return 0;
            if (root.val == target.val) {
                if (currentK == k) {
                    distanceKList.add(root.val);
                }
                distanceKHelper(root.left, target, k, 1, true);
                distanceKHelper(root.right, target, k, 1, true);
                return 1;
            }
            int left = distanceKHelper(root.left, target, k, currentK, false);
            int right = distanceKHelper(root.right, target, k, currentK, false);
            if (left > 0) {
                if (left == k) {
                    distanceKList.add(root.val);
                    return -1;
                }
                distanceKHelper(root.right, target, k, left + 1, true);
                return left + 1;
            } else if (right > 0) {
                if (right == k) {
                    distanceKList.add(root.val);
                    return -1;
                }
                distanceKHelper(root.left, target, k, right + 1, true);
                return right + 1;
            } else {
                return 0;
            }

        }

    }

    //    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        HashMap<Integer, List<Integer>> BedingungsListe = new HashMap<>(prerequisites.length);
//        HashMap<Integer, List<Integer>> FreigabeListe = new HashMap<>(prerequisites.length);
//        for (int [] myArray: prerequisites
//             ) {
//            BedingungsListe.merge(myArray[1], new ArrayList<>(List.of(myArray[0])),(newvalue, oldvalue) -> {oldvalue.add(myArray[0]); return oldvalue;});
//            FreigabeListe.merge(myArray[0], new ArrayList<>(List.of(myArray[1])),(newvalue, oldvalue) -> {oldvalue.add(myArray[1]); return oldvalue;});
//        }
//        for (Map.Entry<Integer, List<Integer>> set :
//                BedingungsListe.entrySet()) {
//            // Printing all elements of a Map
////            System.out.println(set.getKey() + " = "
////                    + set.getValue());
//            int remove = set.getKey();
//            if(set.getValue().isEmpty()){
//                BedingungsListe.remove(set.getKey());
//                //maybe add Something here
//            }
//            int currentSize = set.getValue().size();
//            List<Integer> currentList = set.getValue();
//            for (Integer i: currentList
//                 ) {
//                Stack<Integer> currentStack = new Stack<>();
//                currentStack.add(i);
//                while(!currentStack.isEmpty()){
//                    int removeThis = currentStack.peek();
//
//
//
//                }
//
//            }
//        }
    boolean[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(prerequisites.length);
        for (int[] myArray : prerequisites
        ) {
            graph.merge(myArray[1], new ArrayList<>(List.of(myArray[0])), (l1, l2) -> Stream.concat(l1.stream(), Stream.of(myArray[0])).collect(Collectors.toList()));
        }
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean Flag = false;
            if (visited[i] || graph.get(i) == null) {
                continue;
            } else {
                boolean[] b = new boolean[numCourses];
                Flag = canFinishDfs(graph, numCourses, b, i);
            }
            if (Flag)
                return false;

        }
        return true;


    }

    private boolean canFinishDfs(HashMap<Integer, List<Integer>> graph, int numCourses, boolean[] dfsVisited, int number) {
        List<Integer> neighbours = graph.get(number);
        visited[number] = true;
        dfsVisited[number] = true;
        if (neighbours == null)
            return false;
        for (Integer i : neighbours
        ) {
            boolean Flag = false;
            if (dfsVisited[i]) {
                return true;
            } else if (!visited[i]) {
                dfsVisited[i] = true;
                Flag = canFinishDfs(graph, numCourses, dfsVisited, i);
                dfsVisited[i] = false;
            }
            if (Flag)
                return true;
        }
        return false;

    }

    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> myMap = new HashMap<>(arr.length);
        int maxLength = 1;
        for (int i = 0; i < arr.length; i++) {
            int currentValue = arr[i];
            boolean firstTime = false;
            if (!myMap.containsKey(currentValue)) {
                myMap.put(currentValue, 1);
                firstTime = true;
            }
            if (firstTime && difference == 0)
                continue;
            if (myMap.containsKey(currentValue - difference)) {
                Integer tmp = myMap.get(currentValue - difference);
                myMap.put(currentValue, tmp + 1);
                maxLength = Math.max(tmp + 1, maxLength);
            }

        }
        return maxLength;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode currentNode = l1;
        StringBuilder sb1 = new StringBuilder();
        while (currentNode != null) {
            sb1.append(currentNode.val);
            currentNode = currentNode.next;
        }
        currentNode = l2;
        StringBuilder sb2 = new StringBuilder();
        while (currentNode != null) {
            sb2.append(currentNode.val);
            currentNode = currentNode.next;
        }
        String longer;
        String shorter;
        if (sb1.length() > sb2.length()) {
            longer = sb1.toString();
            shorter = sb2.toString();
        } else {
            longer = sb2.toString();
            shorter = sb1.toString();
        }
        int merke = 0;
        StringBuilder resBuilder = new StringBuilder();
        for (int i = 0; i < longer.length(); i++) {
            int shorterNumber = 0;
            if (i < shorter.length())
                shorterNumber = Character.getNumericValue(shorter.charAt(shorter.length() - 1 - i));
            int tmp = Character.getNumericValue(longer.charAt(longer.length() - 1 - i)) + shorterNumber + merke;
            if (tmp >= 10) {
                merke = 1;
            } else {
                merke = 0;
            }
            tmp = tmp % 10;
            resBuilder.append(tmp);
        }
        if (merke == 1)
            resBuilder.append(1);
        String resultString = resBuilder.reverse().toString();
        System.out.println(resultString);
        final ListNode returnPointer = new ListNode();
        ListNode resList = returnPointer;

        for (int i = 0; i < resultString.length(); i++) {
            resList.val = Character.getNumericValue(resultString.charAt(i));
            if (i < resultString.length() - 1) {
                resList.next = new ListNode();
                resList = resList.next;
            }
        }
        return returnPointer;

    }

    class LRUCache {
        HashMap<Integer, Integer> globalCache;
        LinkedBlockingQueue<Integer> lru;

        int capacity;
        int current_Capacity = 0;


        public LRUCache(int capacity) {
            globalCache = new HashMap<>(capacity);
            this.capacity = capacity;
            lru = new LinkedBlockingQueue<>(capacity);
            current_Capacity = 0;
        }

        public int get(int key) {
            Integer tmp = globalCache.get(key);
            if (lru.remove(key)) {
                lru.offer(key);
            }
            return (tmp == null) ? -1 : tmp;
        }

        public void put(int key, int value) {
            if (globalCache.containsKey(key)) {
                globalCache.put(key, value);
                lru.remove(key);
                lru.offer(key);
            } else {
                if (lru.offer(key)) {
                    globalCache.put(key, value);
                } else {
                    Integer tmp = lru.remove();
                    Integer test = globalCache.remove(tmp);
                    if (test == null) {
                        throw new RuntimeException("that shouldnt be possible wtf");
                    }
                    globalCache.put(key, value);
                    lru.offer(key);
                }
            }
        }
    }

    public double myPow(double x, int n) {
        double myX = x;
        long myn = n;

        if (n < 0) {
            myX = 1.0 / x;
            myn = -1l * myn;
        }
        return myPowHelper(myX, myn);
    }

    private double myPowHelper(double x, long n) {
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;
        if (n % 2 == 0) {
            return myPowHelper(x * x, n / 2);
        } else {
            return x * myPowHelper(x * x, (n - 1) / 2);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }
        return 0.0;
    }

    //    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] shorter = nums1;
//        int[] longer = nums2;
//        if(nums1.length > nums2.length){
//            shorter = nums2;
//            longer = nums1;
//        }
//        int total = nums1.length + nums2.length;
//        int myLength = (total + 1) / 2;
//        int left = 0;
//        int end = shorter.length;
//        int mid = (left + end) / 2;
//        int otherHalf = myLength - mid;
//        int shorter0 = (int) Double.NEGATIVE_INFINITY;
//        int shorter1 = (int) Double.POSITIVE_INFINITY;
//        int longer0 = (int) Double.NEGATIVE_INFINITY;
//        int longer1 = (int) Double.POSITIVE_INFINITY;
//        if(mid < shorter.length)
//            shorter0 = shorter[mid];
//        if(mid + 1 < shorter.length)
//            shorter1 = shorter[mid + 1];
//        if(otherHalf < longer.length)
//            longer0 = longer[otherHalf];
//        if(otherHalf + 1 < longer.length)
//            longer1 = longer[otherHalf +1];
//        while(shorter0 > longer1 || longer0 > shorter1){
//            if(shorter0 > longer1){
//                end = mid - 1;
//            }
//            else{
//                left = mid + 1;
//            }
//            mid = (left + end) / 2;
//            otherHalf = myLength - mid - 1;
//            shorter0 = (int) Double.NEGATIVE_INFINITY;
//            shorter1 = (int) Double.POSITIVE_INFINITY;
//            longer0 = (int) Double.NEGATIVE_INFINITY;
//            longer1 = (int) Double.POSITIVE_INFINITY;
//            if(mid < shorter.length)
//                shorter0 = shorter[mid];
//            if(mid + 1 < shorter.length)
//                shorter1 = shorter[mid + 1];
//            if(otherHalf < longer.length)
//                longer0 = longer[otherHalf];
//            if(otherHalf + 1 < longer.length)
//                longer1 = longer[otherHalf +1];
//            if(left> end)
//                break;
//        }
//        if(total % 2 == 0){
//            return (Math.max(shorter0, longer0) + Math.min(shorter1, longer1)) / 2.0;
//        }
//        else{
//            return Math.max(shorter0, longer0);
//        }
//
//
//    }
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String res = "";
        boolean[][] palindrom = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                res = s.substring(0, 1);
            }
            palindrom[i][i] = true;
            maxLength = Math.max(maxLength, 1);
            if (i < s.length() - 1) {
                palindrom[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
                if (palindrom[i][i + 1]) {
                    res = s.substring(i, i + 2);
                    maxLength = 2;
                }
            }
        }
        int j = 2;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int k = 0; k + j < s.length(); k++) {
                if (s.charAt(k) == s.charAt(k + j)) {
                    if (palindrom[k + 1][k + j - 1]) {
                        palindrom[k][k + j] = true;
                        if (k + j - k + 1 > maxLength) {
                            maxLength = k + j - k + 1;
                            res = s.substring(k, k + j + 1);
                        }

                    } else {
                        palindrom[k][k + j] = false;

                    }

                } else {
                    palindrom[k][k + j] = false;

                }

            }
            j++;
        }
        return res;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;
        int mid = (left + right) / 2;
        while (left <= right) {
            int minus = Integer.MAX_VALUE; //possible mistake
            int plus = Integer.MAX_VALUE;
            if (mid - 1 >= 0)
                minus = arr[mid - 1];
            if (mid + 1 < arr.length)
                plus = arr[mid + 1];
            if (arr[mid] > minus && arr[mid] > plus)
                return mid;
            if (plus > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return -1; //no Peak Element or Mistake

    }

    public long maxRunTime(int n, int[] batteries) {
        long left = 0;
        long right = 0;
        for (int b : batteries
        ) {
            right += b;

        }
        long mid = (left + right + 1) / 2;
        ;
        while (left < right) {
            if (checkTime(n, batteries, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right + 1) / 2;
        }
        return mid;

    }

    private boolean checkTime(int n, int[] batteries, long time) {
        long sum = 0;
        for (int x : batteries
        ) {
            sum += Math.min(x, time);
        }
        return (sum >= time * n);
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour < dist.length - 1)
            return -1;
        long left = 1;
        long right = (int) Math.pow(10, 7);
        long mid = (left + right + 1) / 2;
        while (left < right) {

            if (checkMinSpeed(dist, hour, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right + 1) / 2;

        }
        return (mid <= 10000000) ? (int) mid : -1;


    }

    private boolean checkMinSpeed(int[] dist, double hour, long speed) {
        double curHour = 0;
        for (int i = 0; i < dist.length; i++) {
            int d = dist[i];
            if (i < dist.length - 1)
                curHour += Math.ceil((double) d / speed);
            else
                curHour += (double) d / speed;
            if (curHour > hour)
                return false;


        }
        return true;
    }

    int[] global_nums;

    public boolean PredictTheWinner(int[] nums) {
        global_nums = nums;
        return PredictTheWinnerHelper(0, nums.length - 1, 0, nums.length, 0, 0);

    }

    private boolean PredictTheWinnerHelper(int left, int right, int count, int nums_length, int A, int B) { //can be faster by memorization with array indexed by [left] [right]
        if (count >= nums_length - 1) {
            if (count % 2 == 0) {
                A += global_nums[left];
            } else {
                B += global_nums[left];
            }
            return A >= B;

        }
        if (count % 2 == 0) {
            boolean tmp1 = PredictTheWinnerHelper(left + 1, right, count + 1, nums_length, A + global_nums[left], B);
            if (tmp1)
                return true;
            return PredictTheWinnerHelper(left, right - 1, count + 1, nums_length, A + global_nums[right], B);
        } else {
            boolean tmp1 = PredictTheWinnerHelper(left + 1, right, count + 1, nums_length, A, B + global_nums[left]);
            if (!tmp1)
                return false;
            return PredictTheWinnerHelper(left, right - 1, count + 1, nums_length, A, B + global_nums[right]);
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) { //dumb solution, but it works
        List<ListNode> stackList = new LinkedList<>();
        ListNode curElement = head;
        while (curElement != null) {
            stackList.add(curElement);
            curElement = curElement.next;
        }
        ListNode toremove = stackList.get(stackList.size() - (n));
        ListNode underElement = toremove.next; //can be null
        ListNode aboveElement = null;
        if (stackList.size() - (n + 1) >= 0)
            aboveElement = stackList.get(stackList.size() - (n + 1));
        System.out.println(toremove.val + "" + underElement.val + "" + aboveElement.val);

        if (aboveElement != null) {
            aboveElement.next = underElement;
            //stackList.remove(stackList.size() - (n - 1)); //no need
            return stackList.get(0);
        } else {
            return toremove.next;
        }


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode startL1 = list1;
        ListNode startL2 = list2;
        ListNode rememberList = new ListNode();
        ListNode mergedList = rememberList;
        while (startL1 != null && startL2 != null) {
            if (startL1.val <= startL2.val) {
                mergedList.next = startL1;
                startL1 = startL1.next;
                mergedList = mergedList.next;
            } else {
                mergedList.next = startL2;
                startL2 = startL2.next;
                mergedList = mergedList.next;
            }
        }
        if (startL1 == null) {
            mergedList.next = startL2;
        } else {
            mergedList.next = startL1;
        }
        return rememberList.next; //bla bla


    }

    int[][] minDelSum;
    int useCounter;

    public int minimumDeleteSum(String s1, String s2) {
        minDelSum = new int[s1.length()][s2.length()];
        useCounter = 0;
        int res = minimumDeleteSumHelper(s1, s2, s1.length() - 1, s2.length() - 1);
        System.out.println("Used " + useCounter);
        return res;
    }

    private int minimumDeleteSumHelper(String s1, String s2, int i, int j) {
        if (i < 0 && j < 0)
            return 0;
        if (i < 0) {
            return getAsciValue(s2, j);
        }
        if (j < 0)
            return getAsciValue(s1, i);
        // sind nicht null
        if (minDelSum[i][j] == 0) { //noch nicht berechnet
            if (s1.charAt(i) == s2.charAt(j)) {
                int tmp = minimumDeleteSumHelper(s1, s2, i - 1, j - 1);
                minDelSum[i][j] = tmp;
                return tmp;
            } else {
                int tmp1 = s1.charAt(i) + minimumDeleteSumHelper(s1, s2, i - 1, j);
                int tmp2 = s2.charAt(j) + minimumDeleteSumHelper(s1, s2, i, j - 1);
                int min = Math.min(tmp2, tmp1);
                minDelSum[i][j] = min;
                return min;
            }
        } else {
            useCounter++;
            return minDelSum[i][j];
        }

    }

    private int getAsciValue(String s1, int i) {
        if (i >= s1.length())
            throw new IllegalArgumentException("Digger i´ist größer als die Länge des Strings du Heini");
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            sum += s1.charAt(j);
        }
        return sum;
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int pointer = 2;
        int counter = 0;

        for (int i = 0; i <= n; i++) {
            if (i == 0)
                res[i] = 0;
            else if (i == 1 || i == 2)
                res[i] = 1;
            else if (i == 3)
                res[i] = 2;
            else {
                res[i] = res[pointer] + counter;
                counter++;
                if (counter >= 2) {
                    pointer++;
                    counter = 0;
                }
            }

        }
        return res;

    }

    List<List<Integer>> globalCombineList;

    public List<List<Integer>> combine(int n, int k) {
        globalCombineList = new LinkedList<>();
        combineHelper(n, k, 1, new LinkedList<>(), 1);
        return globalCombineList;

    }

    private void combineHelper(int n, int k, int currentIndex, List<Integer> ListBuilder, int startPoint) {
        if (currentIndex == k) {
            for (int i = startPoint; i <= n; i++) {
                ListBuilder.add(i);
                globalCombineList.add(new ArrayList<>(ListBuilder));
                ListBuilder.remove(ListBuilder.size() - 1);
            }
        } else {
            for (int i = startPoint; i <= n; i++) {
                ListBuilder.add(i);
                combineHelper(n, k, currentIndex + 1, ListBuilder, i + 1);
                ListBuilder.remove(ListBuilder.size() - 1);
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) { // bruh
        Queue<Integer> memory = new ConcurrentLinkedQueue<>();
        int nums2pointer = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (memory.isEmpty() && i >= m) {
                nums1[i] = nums2[nums2pointer];
                nums2pointer++;

            } else {
                if (i < m)
                    memory.add(nums1[i]);
                int n1 = memory.peek();
                int n2 = Integer.MAX_VALUE;
                if (nums2pointer < n)
                    n2 = nums2[nums2pointer];
                if (n1 <= n2) {
                    nums1[i] = n1;
                    memory.poll();
                } else {
                    nums1[i] = n2;
                    nums2pointer++;
                }
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int nums1_index = 0;
        int nums2_index = 0;
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int n1 = Integer.MAX_VALUE;
            if (nums1_index < m)
                n1 = nums1[nums1_index];
            int n2 = Integer.MAX_VALUE;
            if (nums2_index < n)
                n2 = nums2[nums2_index];
            if (n1 <= n2) {
                res[i] = n1;
                nums1_index++;
            } else {
                res[i] = n2;
                nums2_index++;
            }
        }
        nums1 = res;
        System.out.println(Arrays.toString(nums1));
    }

    public String convert(String s, int numRows) {
        int index_counter = 0;
        int row_counter = 0;
        int moduluVal = numRows - 1;
        if (moduluVal == 0)
            return s;
        List<List<Character>> resList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            resList.add(new ArrayList<>());
        }
        while (index_counter < s.length()) {
            if (row_counter % moduluVal == 0) {
                for (int i = 0; i < numRows; i++) {
                    if (index_counter >= s.length())
                        break;
                    resList.get(i).add(s.charAt(index_counter));
                    index_counter++;
                }
            } else {
                int index = (numRows - 1) - row_counter;
                resList.get(index).add(s.charAt(index_counter));
                index_counter++;
            }
            row_counter = (row_counter + 1) % moduluVal;
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> characters : resList) {
            for (Character character : characters) {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    List<List<Integer>> globalPermuteList;

    public List<List<Integer>> permute(int[] nums) {
        globalPermuteList = new LinkedList<>();
        List<Integer> list = new LinkedList<>(Arrays.stream(nums).boxed().toList());
        permuteHelper(list, new LinkedList<>(), 0, nums.length);
        return globalPermuteList;


    }

    private void permuteHelper(List<Integer> nums, List<Integer> resList, int index, int length) {
        if (index >= length - 1) {
            resList.add(nums.get(0));
            globalPermuteList.add(new LinkedList<>(resList));
            resList.remove((resList.size() - 1));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                Integer tmp = nums.get(i);
                resList.add(tmp);
                nums.remove(i);
                permuteHelper(nums, resList, index + 1, length);
                nums.add(i, tmp);
                resList.remove(resList.size() - 1);
            }
        }
    }

    public int singleNumber2(int[] nums) {
        int myBinary = 0;
        for (int x : nums
        ) {
            myBinary = myBinary ^ x;
        }
        return myBinary;

    }

    String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> globalLetterComb;

    public List<String> letterCombinations(String digits) {
        globalLetterComb = new LinkedList<>();
        if (digits.isEmpty()) {
            return globalLetterComb;
        }
        letterCombinationsHelper(digits, 0, "");
        return globalLetterComb;

    }

    private void letterCombinationsHelper(String digits, int index, String currentString) {
        int lookUp = Character.getNumericValue(digits.charAt(index));
        if (index >= digits.length() - 1) {
            for (int i = 0; i < keyboard[lookUp].length(); i++) {
                globalLetterComb.add(currentString + keyboard[lookUp].charAt(i));
            }
        } else {
            for (int i = 0; i < keyboard[lookUp].length(); i++) {
                letterCombinationsHelper(digits, index + 1, currentString + keyboard[lookUp].charAt(i));
            }
        }

    }

    public int reverse(int x) {
        int n = Math.abs(x); // Get the absolute value of x
        int sum = 0;

        while (n > 0) {
            int r = n % 10;
            n = n / 10;

            // Check for integer overflow before updating the sum
            if (sum > (Integer.MAX_VALUE - r) / 10) {
                return 0;
            }

            sum = sum * 10 + r;
        }

        // Restore the sign of the result based on the original number x
        return x < 0 ? -sum : sum;

    }

    public int myAtoi(String s) {
        char[] sArray = s.toCharArray();
        int index = 0;
        long sum = 0;
        if (s.length() == 0)
            return 0;
        while (sArray[index] == ' ') {
            index++;
            if (index >= sArray.length)
                return 0;
        }
        boolean positive = true;
        long moduluVal = Integer.MAX_VALUE;
        if (sArray[index] == '+' || sArray[index] == '-') {
            if (sArray[index] == '-') {
                positive = false;
                moduluVal++;
            }
            index++;
        }
        boolean firstZeros = false;
        while (index < sArray.length && Character.isDigit(sArray[index])) {
            if (!firstZeros) {
                if (sArray[index] == '0') {
                    index++;
                    continue;
                }
                firstZeros = true;
                sum = ((sum * 10) + Character.getNumericValue(sArray[index]));
                if (sum >= moduluVal)
                    return (positive) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                sum = ((sum * 10) + Character.getNumericValue(sArray[index])) % moduluVal;
                if (sum >= moduluVal)
                    return (positive) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }
        return (positive) ? (int) sum : (int) (sum * -1);

    }

    HashSet<Integer> alreadyVisited;

    public boolean wordBreak(String s, List<String> wordDict) {
        alreadyVisited = new HashSet<>();
        return wordBreakHelper(s, wordDict, 0);

    }

    private boolean wordBreakHelper(String s, List<String> wordDict, int index) {
        if (index >= s.length()) //base case
            return true;
        if (alreadyVisited.contains(index)) //use already computed shit
            return false;
        for (String currentS : wordDict) {
            int currentL = currentS.length(); //length of word
            if (index + currentL > s.length()) //if index out of range
                continue;
            if (s.substring(index, index + currentL).equals(currentS)) {
                boolean retVal = wordBreakHelper(s, wordDict, index + currentL);
                if (retVal) //can be broken in Dict Words
                    return true;
            }
        }
        alreadyVisited.add(index); //we computed that right now, and it didn't work with that index xdd
        return false;
    }

    List<TreeNode> globalTrees;

    public List<TreeNode> generateTrees(int n) {
        globalTrees = new ArrayList<>();
        return null;

    }

    private void generateTreesHelper(TreeNode current, int rightVal, int leftVal, boolean inList) {
        int currentVal = current.val;
        List<TreeNode> leftList = new LinkedList<>();
        for (int i = currentVal - 1; i > leftVal; i--) {
            TreeNode left = new TreeNode(i);
            generateTreesHelper(left, currentVal, leftVal, false);
            leftList.add(left);
        }
        List<TreeNode> rightList = new LinkedList<>();
        for (int j = currentVal + 1; j < rightVal; j++) { //includes base case (hopefully xD)
            TreeNode right = new TreeNode(j);
            generateTreesHelper(right, rightVal, currentVal, false);
            rightList.add(right);
        }
        int left_index = 0;
        do {
            current.left = null;
            if (!leftList.isEmpty()) {
                current.left = leftList.get(left_index);
            }
            int right_index = 0;
            do {
                current.right = null;
                if (!rightList.isEmpty()) {
                    current.right = rightList.get(right_index);
                }
                right_index++;
            }
            while (right_index < rightList.size());
            left_index++;
        }
        while (left_index < leftList.size());


    }

    public List<TreeNode> allPossibleBST(int start, int end,
                                         Map<Pair<Integer, Integer>, List<TreeNode>> memo) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) { //das ist real shit
            res.add(null);
            return res;
        }
        if (memo.containsKey(new Pair<>(start, end))) {
            return memo.get(new Pair<>(start, end));
        }
        // Iterate through all values from start to end to construct left and right subtree recursively.
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftSubTrees = allPossibleBST(start, i - 1, memo);
            List<TreeNode> rightSubTrees = allPossibleBST(i + 1, end, memo);

            // Loop through all left and right subtrees and connect them to ith root.
            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }
        memo.put(new Pair<>(start, end), res);
        return res;
    }

    public List<TreeNode> generateTrees2(int n) {
        Map<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
        return allPossibleBST(1, n, memo);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int mid = (start + end) / 2;
        boolean found = false;
        while (start <= end) {
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                found = true;
                break;
            }
            if (target < matrix[(int) mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        if (!found)
            return false;
        int index = mid;
        start = 0;
        end = matrix[index].length - 1;
        mid = (start + end) / 2;
        while (start <= end) {
            if (target == matrix[index][mid]) {
                return true;
            }
            if (target < matrix[index][mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int mid = sb.length() / 2;
        for (int i = 0; i < mid; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i))
                return false;
        }
        return true;
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (nums[mid] == target) //base case
                return mid;
            if (nums[start] > nums[end]) {
                if (target < nums[start]) {// we want to be on the right side
                    if (nums[mid] < target) { // i am on the right side
                        start = mid + 1;
                    } else { // idk where i am.
                        if (nums[start] <= nums[mid]) {  // i am on the left side (dont want to be there)
                            start = mid + 1;
                        } else {
                            end = mid - 1;
                        }
                    }
                } else { // we want to be on the left side
                    if (nums[mid] < target) { //idk where i am
                        if (nums[start] <= nums[mid]) {  // i am on the left side (want to be there)
                            start = mid + 1;
                        } else { // i am on the right side
                            end = mid - 1;
                        }
                    } else { // i am on the right side
                        end = mid - 1;
                    }

                }
            } else { //normales binary search
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
            mid = (start + end) / 2;
        }
        return -1;
    }

    public boolean search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2; //wichtig hier avoids Integer Overflow

            if (nums[mid] == target) {
                return true;
            }

            if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                start++;
                continue;
            }
            // which array does pivot belong to.
            boolean pivotArray = existsInFirst(nums, start, nums[mid]);

            // which array does target belong to.
            boolean targetArray = existsInFirst(nums, start, target);
            if (pivotArray ^ targetArray) { // If pivot and target exist in different sorted arrays, recall that xor is true when both operands are distinct
                if (pivotArray) {
                    start = mid + 1; // pivot in the first, target in the second
                } else {
                    end = mid - 1; // target in the first, pivot in the second
                }
            } else { // If pivot and target exist in same sorted array
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    // returns true if we can reduce the search space in current binary search space
    private boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }

    // returns true if element exists in first array, false if it exists in second
    private boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }

    int globalCount;
    int[] globalCoins;
    HashSet<List<Integer>> dpMapChange;

    public int change(int amount, int[] coins) {
        globalCount = 0;
        dpMapChange = new HashSet<>();
        globalCoins = coins;
        List<Integer> CaroBigL = new ArrayList<>(coins.length);
        for (int i = 0; i < coins.length; i++) {
            CaroBigL.add(i, 0);
        }
        changeHelper(amount, 0, CaroBigL);
        return globalCount;

    }

    private void changeHelper(int amount, int curAmount, List<Integer> curConfig) {
        if (dpMapChange.contains(curConfig)) { //if already computed
            return;
        }
        if (curAmount == amount) {
            globalCount++;//base case
            dpMapChange.add(new ArrayList<>(curConfig));
            return;
        }
        if (curAmount > amount) //abbruch
            return;
        for (int i = 0; i < globalCoins.length; i++) {
            curAmount += globalCoins[i];
            curConfig.set(i, curConfig.get(i) + 1); //increment it
            changeHelper(amount, curAmount, curConfig); //dont do parallel shit
            curAmount -= globalCoins[i]; //reset
            curConfig.set(i, curConfig.get(i) - 1); //reset
        }
        dpMapChange.add(new ArrayList<>(curConfig)); //i computed it right???
    }

    public int[] sort(int nums[]) {
        return sortHelper(nums, 0, nums.length - 1);

    }

    private int[] sortHelper(int[] nums, int begin, int end) {
        if (begin == end) {
            return new int[]{nums[begin]};
        }
        int mid = ((begin + end) / 2);
        int[] tmp1 = sortHelper(nums, begin, mid);
        int[] tmp2 = sortHelper(nums, mid + 1, end);
        return merge3(tmp1, tmp2);
    }

    public int[] merge3(int[] n, int[] m) {
        int[] res = new int[n.length + m.length];
        int npointer = 0;
        int mpointer = 0;
        for (int i = 0; i < res.length; i++) {
            int n_val = Integer.MIN_VALUE;
            int m_val = Integer.MIN_VALUE;
            if (npointer < n.length)
                n_val = n[npointer];
            if (mpointer < m.length)
                m_val = m[mpointer];
            if (n_val > m_val) {
                res[i] = n_val;
                npointer++;
            } else {
                res[i] = m_val;
                mpointer++;
            }
        }
        return res;
    }

    public int findKthLargest(int[] nums, int k) {
        int[] tmp = sort(nums);
        if (k - 1 < tmp.length)
            return tmp[k - 1];
        else {
            throw new IllegalArgumentException("k is bigger then the length of the array wtf");
        }
    }

    public int maxArea(int[] height) {
        long max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int x = right - left;
            int y = Math.min(height[left], height[right]);
            max = Math.max(max, (((long) x * y)));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return (int) max;

    }

    public ListNode partition(ListNode head, int x) { //really dumb solution bruh
        Queue<ListNode> smaller = new ConcurrentLinkedQueue<>();
        Queue<ListNode> greater = new ConcurrentLinkedQueue<>();
        ListNode it = head;
        while (it != null) {
            if (it.val < x)
                smaller.add(it);
            else
                greater.add(it);
            it = it.next;
        }
        ListNode res = smaller.peek();
        ListNode s = smaller.poll();
        ListNode before = null;
        while (s != null) {
            s.next = smaller.peek();
            before = s;
            s = smaller.poll();
        }
        if (res == null) {
            res = greater.peek();
        }
        s = greater.poll();
        if (before != null) {
            before.next = s;
        }
        while (s != null) {
            s.next = greater.peek();
            s = greater.poll();
        }
        return res;
    }

    private static TreeMap<Integer, String> createMap() {
        TreeMap<Integer, String> myMap = new TreeMap<Integer, String>(Comparator.reverseOrder());
        myMap.put(1000, "M");
        myMap.put(900, "CM");
        myMap.put(500, "D");
        myMap.put(400, "CD");
        myMap.put(100, "C");
        myMap.put(90, "XC");
        myMap.put(50, "L");
        myMap.put(40, "XL");
        myMap.put(10, "X");
        myMap.put(9, "IX");
        myMap.put(5, "V");
        myMap.put(4, "IV");
        myMap.put(1, "I");
        return myMap;
    }

    TreeMap<Integer, String> roman = createMap();

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "";
        }
        for (Integer key : roman.keySet()) {
            if (num - key >= 0) {
                sb.append(roman.get(key));
                String t = intToRoman(num - key);
                sb.append(t);
                return sb.toString();
            }
        }
        throw new RuntimeException("Negative Number or some shit idk");

    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] RoadMap = new int[n + 1];
        int[][] allRoads = new int[n + 1][n + 1];
        for (int[] i : roads
        ) {
            if (allRoads[i[0]][i[1]] == 0) {
                RoadMap[i[0]] += 1;
                RoadMap[i[1]] += 1;
                allRoads[i[0]][i[1]] = 1;
                allRoads[i[1]][i[0]] = 1;
            }
        }
        int max = 0;
        for (int i = 0; i < RoadMap.length; i++) {
            for (int j = i + 1; j < RoadMap.length; j++) {
                if (RoadMap[i] + RoadMap[j] > max) {
                    int abzug = 0;
                    if (allRoads[i][j] != 0)
                        abzug = -1;
                    max = Math.max(max, RoadMap[i] + RoadMap[j] + abzug);
                }
            }
        }
        return max;


    }

    public int[][] updateMatrix2(int[][] mat) {
        int miau = 0;
        int[][] dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = findNearestZero(new HashSet<>(), dp, 0, i, j, mat, Integer.MAX_VALUE); // weil es ja das ins dp einträgt riiight?
                }

            }

        }
        return dp;

    }

    private int findNearestZero(HashSet<Pair<Integer, Integer>> visited, int[][] dp, int currentDistance, int i, int j, int[][] mat, int valueToBeat) {
        if (mat[i][j] == 0)
            return currentDistance;
        if (currentDistance > valueToBeat)
            return currentDistance;
        if (dp[i][j] != -1) //already computed
            return dp[i][j] + currentDistance;
        //we need to compute some shit
        visited.add(new Pair<>(i, j));
        int up = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (i - 1 >= 0 && !visited.contains(new Pair<>(i - 1, j)))
            up = findNearestZero(visited, dp, currentDistance + 1, i - 1, j, mat, up);
        if (i + 1 < mat.length && !visited.contains(new Pair<>(i + 1, j)))
            down = findNearestZero(visited, dp, currentDistance + 1, i + 1, j, mat, up);
        int min1 = Math.min(up, down);
        if (j - 1 >= 0 && !visited.contains(new Pair<>(i, j - 1)))
            left = findNearestZero(visited, dp, currentDistance + 1, i, j - 1, mat, min1);
        min1 = Math.min(left, min1);
        if (j + 1 < mat[0].length && !visited.contains(new Pair<>(i, j + 1)))
            right = findNearestZero(visited, dp, currentDistance + 1, i, j + 1, mat, min1);

        min1 = Math.min(right, min1);
        visited.remove(new Pair<>(i, j));
        dp[i][j] = min1 - currentDistance; //des wird hoffentlich übernommen right?
        return min1;
    }

    public int[][] updateMatrix(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        if (A[0][0] != 0) A[0][0] = m + n;
        //Travel top down
        for (int j = 1; j < m; j++) {
            if (A[0][j] != 0) A[0][j] = A[0][j - 1] + 1;
        }
        for (int i = 1; i < n; i++) {
            if (A[i][0] != 0) A[i][0] = A[i - 1][0] + 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A[i][j] != 0) A[i][j] = Math.min(A[i - 1][j], A[i][j - 1]) + 1;
            }
        }
        //Travel up
        for (int j = m - 2; j >= 0; j--) {
            if (A[n - 1][j] != 0) A[n - 1][j] = Math.min(A[n - 1][j], A[n - 1][j + 1] + 1);
        }
        for (int i = n - 2; i >= 0; i--) {
            if (A[i][m - 1] != 0) A[i][m - 1] = Math.min(A[i][m - 1], A[i + 1][m - 1] + 1);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (A[i][j] != 0) A[i][j] = Math.min(A[i][j], Math.min(A[i + 1][j], A[i][j + 1]) + 1);
            }
        }
        return A;
    }

    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int oldindex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sb.isEmpty() || sb.charAt(index) != s.charAt(i)) {
                sb.append(s.charAt(oldindex));
                oldindex++;
                i = oldindex - 1;
                index = 0;
            } else {
                index = (index + 1) % sb.length();
            }
        }
        return (index == 0 && sb.length() < s.length());

    }

    public boolean canPartition(int[] nums) {
        long half = (Arrays.stream(nums).sum());
        if (half % 2 != 0)
            return false;
        half /= 2;
        HashSet<Long> mySet = new HashSet<>(nums.length * nums.length);

        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            Set<Long> aux = mySet.stream().map(v -> v + tmp).collect(Collectors.toSet());
            mySet.addAll(aux);
            mySet.add((long) tmp);
            if (mySet.contains(half)) {
                return true;
            }
            long finalHalf = half;
            mySet.removeIf(v -> (v > finalHalf));
        }
        return false;
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        final int valueA = 'A';
        int num = columnNumber;
        while (num > 0) {
            num--;
            int rest = num % 26;
            num /= 26;
            sb.append((char) (rest + valueA));
        }
        return sb.reverse().toString();

    }

    public int removeElement(int[] nums, int val) {
        int removePointer = 0;
        for (int i : nums
        ) {
            if (i != val) {
                nums[removePointer] = i;
                removePointer++;
            }
        }
        return removePointer;
    }

    public int strStr(String haystack, String needle) { // na ja stupid
        StringBuilder sb = new StringBuilder(needle.length());
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < needle.length(); i++) {
            sb.append(haystack.charAt(i));
        }
        if (sb.toString().equals(needle))
            return 0;
        for (int i = needle.length(); i < haystack.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(haystack.charAt(i));
            if (sb.toString().equals(needle))
                return i - (needle.length() - 1);
        }
        return -1;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int dp[][] = new int[s3.length()][s3.length()];
        if (s1.isEmpty())
            return s2.equals(s3);
        else if (s2.isEmpty()) {
            return s1.equals(s3);
        }
        if (s3.length() != s1.length() + s2.length())
            return false;
        return isInterleaveHelper(dp, s1, s2, s3, 0, 0);

    }

    private boolean isInterleaveHelper(int[][] dp, String s1, String s2, String s3, int index1, int index2) {
        if (index1 + index2 == s3.length() - 1) { //base case
            if (index1 < s1.length()) {
                return s1.charAt(index1) == s3.charAt(index1 + index2) && index1 + index2 == s3.length();
            } else {
                return s2.charAt(index2) == s3.charAt(index1 + index2) && index1 + index2 == s3.length();
            }
        }
        if (dp[index1][index2] != 0) //already computed that shit :-D
            return false;
        if (index1 + index2 >= s3.length()) //cant be equal now xdd :P
            return false;
        //base case shit done
        if (index1 >= s1.length()) {
            return s2.substring(index2).equals(s3.substring(index1 + index2));
        }
        if (index2 >= s2.length()) {
            return s1.substring(index1).equals(s3.substring(index1 + index2));
        }

        if (s1.charAt(index1) != s3.charAt(index1 + index2) && s2.charAt(index2) != s3.charAt(index1 + index2)) {
            dp[index1][index2] = 1;
            return false;
        } else if (s1.charAt(index1) == s3.charAt(index1 + index2) && s2.charAt(index2) != s3.charAt(index1 + index2)) { //you can just use s1 this time
            boolean tmp = isInterleaveHelper(dp, s1, s2, s3, index1 + 1, index2);
            dp[index1 + 1][index2] = 1;
            return tmp;
        } else if (s1.charAt(index1) != s3.charAt(index1 + index2) && s2.charAt(index2) == s3.charAt(index1 + index2)) { //you can just use s2 this time
            boolean tmp = isInterleaveHelper(dp, s1, s2, s3, index1, index2 + 1);
            dp[index1][index2 + 1] = 1;
            return tmp;
        } else { //both are possible
            boolean tmp1 = isInterleaveHelper(dp, s1, s2, s3, index1 + 1, index2);
            dp[index1 + 1][index2] = 1;
            if (tmp1)
                return true;
            boolean tmp = isInterleaveHelper(dp, s1, s2, s3, index1, index2 + 1);
            dp[index1][index2 + 1] = 1;
            return tmp;
        }
    }

    class MyStack {
        LinkedBlockingQueue<Integer> meow;


        public MyStack() {
            meow = new LinkedBlockingQueue<Integer>();
        }

        public void push(int x) {
            meow.offer(x);
        }

        public int pop() {
            if (this.empty())
                return -1;
            for (int i = 0; i < meow.size() - 1; i++) {
                meow.offer(meow.poll());
            }
            return meow.poll(); //will never null point
        }

        public int top() {
            if (this.empty())
                return -1;
            for (int i = 0; i < meow.size() - 1; i++) {
                meow.offer(meow.poll());
            }
            Integer res = meow.peek();
            meow.offer(meow.poll());
            return res;//will never null point

        }

        public boolean empty() {
            return meow.isEmpty();
        }
    }

    class MyQueue {
        Stack<Integer> input;
        Stack<Integer> output;

        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            if (output.empty()) {
                int size = input.size();
                for (int i = 0; i < size; i++) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        public int peek() {
            if (output.empty()) {
                int size = input.size();
                for (int i = 0; i < size; i++) {
                    output.push(input.pop());
                }
            }
            return output.peek();

        }

        public boolean empty() {
            return input.empty() && output.empty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    public int bestClosingTime(String customers) {
        int Ycount = 0;
        int Ncount = 0;
        for (char c: customers.toCharArray()
             ) {
            if (c == 'Y') {
                Ycount++;
            }
        }
        int minPenalty = Ycount;
        int hour = 0;
        for (int i = 0; i < customers.length() ; i++) {
            char c = customers.charAt(i);
            if(c == 'Y'){
                if(minPenalty > Ycount + Ncount){
                    hour = i;
                    minPenalty = Ycount + Ncount;
                }
                Ycount--;
            } else if (c == 'N') {
                if(minPenalty > Ycount + Ncount){
                    hour = i;
                    minPenalty = Ycount + Ncount;
                }
                Ncount++;
            }
        }
        if(minPenalty > Ycount + Ncount){
            hour = customers.length();
            minPenalty = Ycount + Ncount;
        }

        return hour;
    }
    public int threeSumClosest(int[] nums, int target) {

        // Sort the elements
        Arrays.sort(nums);
        int resultSum = nums[0] + nums[1] + nums[2];
        int minDifference = Integer.MAX_VALUE;

        // Now fix the first element and find the other two elements
        for (int i = 0; i < nums.length - 2; i++) {
            // Find other two elements using Two Sum approach
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target)
                    return target;
                if (sum < target)
                    left++;
                else
                    right--;

                int diffToTarget = Math.abs(sum - target);
                if (diffToTarget < minDifference) {
                    // update the result sum
                    resultSum = sum;
                    minDifference = diffToTarget;
                }
            }
        }
        return resultSum;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePathHelper(m, n , dp, 0 , 0);

    }
    private int uniquePathHelper(int m, int n, int[][] dp, int currentm, int currentn){
        if(currentm == m - 1 || currentn == n - 1){
            return 1;
        }
        if(dp[currentm][currentn] != 0)
            return dp[currentm][currentn];
        //base case done?
        int tmp = uniquePathHelper(m, n, dp, currentm + 1, currentn);
        tmp += uniquePathHelper(m, n, dp, currentm, currentn + 1);
        dp[currentm][currentn] = tmp;
        return tmp;
    }
    public int[] sortArrayByParity(int[] nums) {
        int evenPointer = 0;
        int oddPointer = nums.length - 1;
        while(evenPointer < oddPointer){
            if(nums[evenPointer] % 2 == 0){ //do nothing bro its fine :)
                evenPointer++;
            }
            else{ //odd where it doesnt belong
                oddPointer = insertOddEven(nums, evenPointer, oddPointer);
                evenPointer++;
            }
        }
        return nums;
    }
    private int insertOddEven(int[] nums, int evenPointer, int oddPointer){
        if(evenPointer >= oddPointer) //list already done so
            return oddPointer;
        /*if(nums[evenPointer] % 2 == 0) //function call not needed (just to make it safe)
            return oddPointer;*/
        if(nums[oddPointer] % 2 == 0){
            int tmp = nums[evenPointer];
            nums[evenPointer] = nums[oddPointer];
            nums[oddPointer] = tmp;
            return oddPointer - 1;
        }
        else{ //nums[oddPointer] = odd --> repeat it for oddPointer - 1
            return insertOddEven(nums, evenPointer, oddPointer - 1);
        }
    }
    public int[] sortEvenOdd(int[] nums) {
        LinkedList<Integer> evenNumbers = new LinkedList<>();
        LinkedList<Integer> oddNumbers = new LinkedList<>();
        for (int i : nums
             ) {
            if(i % 2 == 0)
                evenNumbers.add(i);
            else
                oddNumbers.add(i);
        }
        Collections.sort(evenNumbers);
        for (int i = 0; i < nums.length; i++) {
            if(true)
                return null;

        }
        return null;



    }
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, List<Integer>> pattern = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            Map<Integer,List<Integer>> lower = pattern.headMap(current);
            Map<Integer,List<Integer>> higher = pattern.tailMap(current + 1);
            if(!(lower.isEmpty() || higher.isEmpty())){
                int min = Integer.MAX_VALUE;
                for(List<Integer> myList : lower.values()){
                    min = Math.min(min, Collections.min(myList)); //if list is sorted take first
                }
                int max = Integer.MIN_VALUE;
                for(List<Integer> myList : higher.values()){
                    max = Math.max(max, Collections.max(myList)); //if sorted take last
                }
                if(min < max)
                    return true;
            }
            if(pattern.containsKey(current)){ //could sort this list , but dont think its worth
                pattern.get(current).add(i);
            }
            else{
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(i);
                pattern.put(current, tmpList);

            }
        }
        return false;

    }
    class MyHashMap {
        ArrayList<LinkedList<Integer>> myMap;

        public MyHashMap() {
            myMap = new ArrayList<>(1000);
            // 1000 because of question restrictions;
            for (int i = 0; i < 1000 ; i++) {
                myMap.add(new LinkedList<Integer>());
            }

        }

        public void put(int key, int value) {
            int index = key % 1000;
            int indexInList = getIndex(key);
            if(indexInList == -1) { //key wasn't already present
                myMap.get(index).add(key);
                myMap.get(index).add(value);
            }
            else{ //key already present --> update key
                myMap.get(index).remove(indexInList);
                myMap.get(index).add(indexInList, value); //hopefully updated
            }

        }

        public int get(int key) {
            int index = key % 1000;
            int indexInList = getIndex(key);
            if(indexInList == -1)
                return -1;
            return myMap.get(index).get(indexInList);
        }
        private int getIndex(int key){
            int index = key % 1000;
            LinkedList<Integer> tmp = myMap.get(index);
            if(tmp.isEmpty())
                return -1;
            for (int i = 0; i < tmp.size(); i+=2) {
                if(tmp.get(i) == key)
                    return i + 1;
            }
            return -1;

        }

        public void remove(int key) {
            int index = key % 1000;
            int indexInList = getIndex(key);
            if(indexInList == -1)
                return;
            myMap.get(index).remove(indexInList - 1);
            myMap.get(index).remove(indexInList - 1);
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
    public int lengthOfLastWord(String s) { //bruh wtf is that
        String[]res = s.split(" ");
        return res[res.length - 1].length();
    }
    public int[] plusOne(int[] digits) {
        if(plusOneHelper(digits, digits.length - 1)){
            int[] new_digits = new int[digits.length + 1];
            System.arraycopy(digits, 1, new_digits, 0, digits.length - 1);
            new_digits[0] = 1;
            return new_digits;
        }
        else{
            return digits;
        }

    }
    private boolean plusOneHelper(int[] digits, int index){
        if(index < 0){; //if i have to expand the Array
            return true;
        }
        int i = digits[index];
        boolean expand = false;
        switch (i){
            case 9:{
                digits[index] = 0;
                expand = plusOneHelper(digits, index  - 1);
                break;
            }
            default:{
                digits[index] = i + 1;
            }
        }
        return expand;
    }
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        String longer = b;
        String shorter = a;
        if(a.length() > b.length()){
            longer = a;
            shorter = b;
        }
        int overflow = 0;
        int indexS = shorter.length() - 1;
        for (int i = longer.length() -1; i >= 0 ; i--) {
            if(indexS < 0){
                int tmp = Character.getNumericValue(longer.charAt(i)) + overflow;
                if(tmp >= 2){
                    overflow = 1;
                    res.append("0");
                }
                else{
                    overflow = 0;
                    res.append(tmp);
                }
            }
            else{
                int tmp = Character.getNumericValue(longer.charAt(i)) + overflow + Character.getNumericValue(shorter.charAt(indexS));
                if(tmp >= 2){
                    overflow = 1;
                }
                else{
                    overflow = 0;
                }
                res.append(tmp % 2);
            }
            indexS--;
        }
        if(overflow == 1)
            res.append("1");
        return res.reverse().toString();
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode before = head;
        if(head == null)
            return null;
        int currentVal = head.val;

        current = current.next;
        int i = 0;
        while(current != null){
            if(current.val != currentVal){
                before.next = current;
                before = current;
                currentVal = current.val;
            }
            current = current.next;
            i++;

        }
        before.next = null;
        return head;
    }
    public List<Integer> getRow(int rowIndex) { //ez Pferd
        if(rowIndex == 0){
            return List.of(1);
        }
        ArrayList<Integer> rowBefore = new ArrayList<>();//use it as Pointer
        rowBefore.add(1);
        for (int i = 1; i <= rowIndex ; i++) {
            ArrayList<Integer> nextList = new ArrayList<>(i + 1);
            for (int j = -1; j < rowBefore.size() ; j++) {
                int left = (j >= 0) ? rowBefore.get(j) : 0;
                int right = (j + 1 < rowBefore.size()) ? rowBefore.get(j + 1) : 0;
                nextList.add(right + left);
            }
            rowBefore = nextList;
        }
        return rowBefore;
    }
    public int removeDuplicates2(int[] nums) {
        int insertPointer = 0;
        if(nums == null){ //safety feature against null Pointer abuser
            return 0;
        }
        int beforeValue = nums[0] - 1;
        for (int i = 0; i < nums.length ; i++) {
            int current = nums[i];
            if(beforeValue != current){
                nums[insertPointer] = current;
                insertPointer++;
            }
            beforeValue = current;
        }
        return insertPointer;
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1); //damn little Bro thinks he's smart xdd
        HashSet<Integer> connectedToRoot = new HashSet<Integer>();
        int Connections = 0;
        for (int i = 0; i < leftChild.length ; i++) {
            if(leftChild[i] == -1)
                continue;
            if(parent[leftChild[i]] != -1){ //maybe falsch
                return false;
            }
            parent[leftChild[i]] = i;
        }
        for (int i = 0; i < rightChild.length ; i++) {
            if(rightChild[i] == -1)
                continue;
            if(parent[rightChild[i]] != -1){ //maybe falsch
                return false; //more than one parent
            }
            parent[rightChild[i]] = i;
        }
        int node = -1;
        int nodeCounter = 0;
        for (int i = 0; i < parent.length ; i++) {
            if(parent[i] == -1){
                if(nodeCounter == 0){
                    nodeCounter++;
                    node = i;
                }
                else{ //more than one note
                    return false;
                }
            }
        }
        if(nodeCounter == 0) // no node
            return false;
        int res = validBTreeNodeConnection(leftChild, rightChild, connectedToRoot, node);
        return (res == n);

    }
    private int validBTreeNodeConnection(int[] leftChild, int[] rightChild, HashSet<Integer> connectedToRoot, int Position){
        if(connectedToRoot.contains(Position)) //Loop oder so --> xdd bye
            return -1;
        /*if(Position < 0 || Position >= leftChild.length){
            throw new RuntimeException("Position out of Range");
        }*/
        connectedToRoot.add(Position);
        //check Left
        int left = leftChild[Position];
        int leftValue = 0;
        if(left != -1){
            leftValue = validBTreeNodeConnection(leftChild, rightChild, connectedToRoot, left);
        }
        if(leftValue == -1) // " Cant be Binary Tree" --> return "false"
            return -1;

        //check right
        int right = rightChild[Position];
        int rightValue = 0;
        if(right != -1){
            rightValue = validBTreeNodeConnection(leftChild, rightChild, connectedToRoot, right);
        }
        if(rightValue == -1){
            return -1;
        }
        return rightValue + leftValue + 1;
    }
    public boolean isPowerOfFour(int n) {
        if(n % 4 != 0 && n > 1)
            return false;
        int left = 0;
        int right = n;
        while(left <= right){
            int mid = (left + right) / 2;
            double current = Math.pow(4, mid);
            if(current == n)
                return true;
            else {
                if(current < n){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }
    public int removeDuplicates3(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int before = nums[0] - 1;
        int beforeThebefore = before;
        int insertPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            nums[insertPointer] = current;
            if(!(current == before && current == beforeThebefore)){ // everything ok, increment insert Pointer
                insertPointer++;
            }
            beforeThebefore = before;
            before = current;
        }
        return insertPointer;
    }
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int element = nums[0] - 1;
        int counter = 0;
        double moreThan = (double) nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if(element != nums[i]){
                counter = 1;
                element = nums[i];
            }
            else{
                counter++;
            }
            if(counter > moreThan)
                return element;
        }
        return -1; // doesn't exist according to Exercise
    }
    public void rotate(int[] nums, int k) {
        int myK = k % nums.length;
        int[] myNums = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int index = nums.length - myK;
            if(myK <= 0)
                index = (-1) * myK;
            nums[i] = myNums[index];
            myK--;
        }
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        largestValuesHelper(0, root, resList);
        return resList;
    }
    private void largestValuesHelper(int currentIndex, TreeNode Node, List<Integer> resList){
        if(Node ==  null)
            return;
        int val = Node.val;
        if(resList.size() <= currentIndex){ //no other value present
            resList.add(currentIndex, val);
        }
        else{ //other value present -> check if new value is larger
            if(resList.get(currentIndex) < val)
                resList.set(currentIndex, val);
        }
        //go left
        TreeNode left = Node.left;
        if(left != null)
            largestValuesHelper(currentIndex + 1, left, resList);
        //go right
        TreeNode right = Node.right;
        if(right != null)
            largestValuesHelper(currentIndex + 1, right, resList);
    }
    public int maxProfit3(int[] prices) {
        if(prices == null)
            return 0;
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int current = prices[i];
            maxProfit = Math.max(maxProfit, current - min);
            if(current < min){
                min = current;
            }
        }
        return maxProfit;
    }
    public int maxProfit4(int[] prices) {
        if(prices == null)
            return 0;
        int Profit = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int sell = prices[i] - min;
            if(sell > 0){
                Profit += sell;
                min = prices[i];
                continue;
            }
            if(min > prices[i])
                min = prices[i];

        }
        return Profit;
    }
    public boolean canJump(int[] nums) {
        return canJumpHelper(nums, 0);
    }
    private boolean canJumpHelper(int[] nums, int index){
        if(index >= nums.length - 1)
            return true;
        int jumpLength = nums[index];
        if(jumpLength == 0)
            return false;
        if(index + jumpLength >= nums.length - 1)
            return true;
        int position = -1;
        int maxJump = -1;
        for (int i = index + 1; i <= index + jumpLength ; i++) {
            if((i - index) + nums[i] > maxJump){
                maxJump = (i - index) + nums[i];
                position = i;
            }
        }
        return canJumpHelper(nums, position);
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> lookUp = new TreeMap<>();
        for (int element : hand) {
            lookUp.merge(element, 1, (oldValue, newValue) -> oldValue + 1);
        }

        while (!lookUp.isEmpty()) {
            Map.Entry<Integer, Integer> firstEntry = lookUp.firstEntry();
            dealWithLookUpRemoval(firstEntry.getKey(), lookUp);
            boolean currentResult = checkNachfolgende(firstEntry.getKey(), lookUp, groupSize);
            if (!currentResult)
                return false;
        }
        return true;


    }

    private void dealWithLookUpRemoval(int key, TreeMap<Integer, Integer> lookUp) {
        if (lookUp.get(key) <= 1)
            lookUp.remove(key);
        else
            lookUp.put(key, lookUp.get(key) - 1);
    }

    private boolean checkNachfolgende(int key, TreeMap<Integer, Integer> lookUp, int groupSize) {
        List<Integer> result = new ArrayList<>();
        for (int i = key + 1; i <= key + groupSize - 1; i++) {
            result.add(i);
        }
        for (int element : result) {
            if (!lookUp.containsKey(element))
                return false;
            dealWithLookUpRemoval(element, lookUp);
        }
        return true;
    }

    public String MEGAreplaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        HashSet<String> hashDic = new HashSet<>(dictionary);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String solutionWord = word;
            ArrayList<StringBuilder> possibleWords = new ArrayList<>(word.length());
            for (int j = 0; j < word.length(); j++) {
                possibleWords.add(j, new StringBuilder());
                char current = word.charAt(j);
                possibleWords.forEach(element -> element.append(current));
                for (int k = possibleWords.size() - 1; k >= 0; k--) {
                    String currentDictWord = possibleWords.get(k).toString();
                    if (hashDic.contains(currentDictWord)) {
                        solutionWord = (currentDictWord.length() < solutionWord.length()) ? currentDictWord : solutionWord;
                        break;
                    }
                }
            }
            words[i] = solutionWord;

        }
        return String.join(" ", words);
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        HashSet<String> hashDic = new HashSet<>(dictionary);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String solutionWord = word;
            StringBuilder possibleWord = new StringBuilder(word.length());
            for (int j = 0; j < word.length(); j++) {
                possibleWord.append(word.charAt(j));
                String currentDicWord = possibleWord.toString();
                if (hashDic.contains(currentDicWord)) {
                    solutionWord = currentDicWord;
                    break;
                }
            }
            words[i] = solutionWord;

        }
        return String.join(" ", words);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sum = new HashMap<>(nums.length);
        sum.put(0, -1);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];
            total += currentElement;
            int reminder = total % k;
            if (!sum.containsKey(reminder))
                sum.put(reminder, i);
            else if (i - sum.get(reminder) > 1) {
                return true;
            }
        }
        return false;

    }public boolean isNStraightHand2(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> lookUp = new TreeMap<>();
        for (int element : hand) {
            lookUp.merge(element, 1, (oldValue, newValue) -> oldValue + 1);
        }

        while (!lookUp.isEmpty()) {
            Map.Entry<Integer, Integer> firstEntry = lookUp.firstEntry();
            dealWithLookUpRemoval(firstEntry.getKey(), lookUp);
            boolean currentResult = checkNachfolgende(firstEntry.getKey(), lookUp, groupSize);
            if (!currentResult)
                return false;
        }
        return true;


    }

    private void dealWithLookUpRemoval2(int key, TreeMap<Integer, Integer> lookUp) {
        if (lookUp.get(key) <= 1)
            lookUp.remove(key);
        else
            lookUp.put(key, lookUp.get(key) - 1);
    }

    private boolean checkNachfolgende2(int key, TreeMap<Integer, Integer> lookUp, int groupSize) {
        List<Integer> result = new ArrayList<>();
        for (int i = key + 1; i <= key + groupSize - 1; i++) {
            result.add(i);
        }
        for (int element : result) {
            if (!lookUp.containsKey(element))
                return false;
            dealWithLookUpRemoval(element, lookUp);
        }
        return true;
    }

    public String MEGAreplaceWords2(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        HashSet<String> hashDic = new HashSet<>(dictionary);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String solutionWord = word;
            ArrayList<StringBuilder> possibleWords = new ArrayList<>(word.length());
            for (int j = 0; j < word.length(); j++) {
                possibleWords.add(j, new StringBuilder());
                char current = word.charAt(j);
                possibleWords.forEach(element -> element.append(current));
                for (int k = possibleWords.size() - 1; k >= 0; k--) {
                    String currentDictWord = possibleWords.get(k).toString();
                    if (hashDic.contains(currentDictWord)) {
                        solutionWord = (currentDictWord.length() < solutionWord.length()) ? currentDictWord : solutionWord;
                        break;
                    }
                }
            }
            words[i] = solutionWord;

        }
        return String.join(" ", words);
    }

    public String replaceWords2(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        HashSet<String> hashDic = new HashSet<>(dictionary);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String solutionWord = word;
            StringBuilder possibleWord = new StringBuilder(word.length());
            for (int j = 0; j < word.length(); j++) {
                possibleWord.append(word.charAt(j));
                String currentDicWord = possibleWord.toString();
                if (hashDic.contains(currentDicWord)) {
                    solutionWord = currentDicWord;
                    break;
                }
            }
            words[i] = solutionWord;

        }
        return String.join(" ", words);
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> sum = new HashMap<>(nums.length);
        sum.put(0, -1);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];
            total += currentElement;
            int reminder = total % k;
            if (!sum.containsKey(reminder))
                sum.put(reminder, i);
            else if (i - sum.get(reminder) > 1) {
                return true;
            }
        }
        return false;

    }

    public int passThePillow(int n, int time) {
        if (time < n)
            return 1 + time;
        int modulued = time % (2 * (n - 1));
        if (modulued < n)
            return modulued + 1;
        return n - (modulued - (n - 1));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int numberOfDrinks = numBottles;
        while (true){
            if (numBottles < numExchange)
                break;
            else {
                numberOfDrinks += numBottles / numExchange;
                numBottles = (numBottles / numExchange) + numBottles % numExchange;
            }
        }
        return numberOfDrinks;
    }

    public int maximumGain(String s, int x, int y) {
        // "ab" = x, "ba" = y
        int result = 0;
        Stack<Character> characterStack = new Stack<>();
        String firstString = (x > y) ? "ab" : "ba";
        String secondString = (x > y) ? "ba" : "ab";


        // first Pass
        for (int i = 0; i < s.length(); i++) {
            result += (checkCanOperate(characterStack, firstString, s.charAt(i))) ? Math.max(x, y) : 0;
        }
        s = stackToString(characterStack);

        //second pass
        characterStack.clear();
        for (int i = 0; i < s.length(); i++) {
            result += (checkCanOperate(characterStack, secondString, s.charAt(i))) ? Math.min(x, y) : 0;
        }

        return result;


    }
    private boolean checkCanOperate(Stack<Character> stack, String toCheck, char currentCharacter){
        if(stack.isEmpty()) {
            stack.push(currentCharacter);
            return false;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(stack.peek());
        builder.append(currentCharacter);
        if(builder.toString().equals(toCheck)) {
            stack.pop();
            return true;
        }
        else{
            stack.push(currentCharacter);
            return false;
        }


    }
    private String stackToString(Stack<Character> stack){
        StringBuilder builder = new StringBuilder();
        for(char c: stack){
            builder.append(c);
        }
        return builder.toString();
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> delete = new HashSet<>(to_delete.length);
        for(int i : to_delete){
            delete.add(i);
        }
        List<TreeNode> result = new ArrayList<>(to_delete.length);
        return delNodesHelper(root, delete, result, true, null);


    }
    private List<TreeNode> delNodesHelper(TreeNode currentRoot, HashSet<Integer> delete, List<TreeNode> result, boolean NewTree, TreeNode parent){
        //Base case
        if (currentRoot == null)
            return result;

        if (delete.contains(currentRoot.val)){
            //delete it from parent
            deleteChildNode(parent, currentRoot);

            // left Side
            delNodesHelper(currentRoot.left, delete, result, true, currentRoot);

            //right Side
            delNodesHelper(currentRoot.right, delete, result, true, currentRoot);

            return result;
        }
        else if (NewTree){
            // add only if New Tree
            result.add(currentRoot);
            deleteChildNode(parent, currentRoot);
        }
            //left Side
            delNodesHelper(currentRoot.left, delete, result, false, currentRoot);

            //right Side
            delNodesHelper(currentRoot.right, delete, result, false, currentRoot);

            return result;

    }
    private void deleteChildNode(TreeNode parent, TreeNode child){
        if(parent == null)
            return;
        if (parent.left != null && parent.left.val == child.val)
            parent.left = null;
        else
            parent.right = null;
    }

    public int minimumCost(int[] nums) {
        if(nums.length < 3)
            return -1;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++){
            if(nums[i] < min1){
               min2 = min1;
               min1 = nums[i];
            }
            else
                min2 = Math.min(min2, nums[i]);
        }
        return nums[0] + min1 + min2;

    }
    public int[] runningSum(int[] nums) {
        int currentSum = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            result[i] = currentSum;
        }
        return result;
    }

    public int[] sortArray(int[] nums) {
        LinkedList<Integer> result = (sortArrayHelper(nums, 0, nums.length -1));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result.poll();
        }
        return nums;
    }

    private LinkedList<Integer> sortArrayHelper(int[] nums, int startIndex, int endIndex){
        // base case
        if (startIndex == endIndex){
            LinkedList<Integer> result = new LinkedList<>();
            result.add(nums[startIndex]);
            return result;
        }
        else{
            int midIndex = ((endIndex - startIndex) / 2) + startIndex;
            LinkedList<Integer> left = sortArrayHelper(nums, startIndex, midIndex);
            LinkedList<Integer> right = sortArrayHelper(nums, midIndex + 1, endIndex);
            return mergeSorted(left, right);
        }
    }

    private LinkedList<Integer> mergeSorted(LinkedList<Integer> left, LinkedList<Integer> right){
        LinkedList<Integer> result = new LinkedList<>();
        while(!left.isEmpty() || !right.isEmpty()){
            if(left.isEmpty()){
                result.addAll(right);
                return result;
            } else if (right.isEmpty()) {
                result.addAll(left);
                return result;
            }
            else{
                if(left.peek() < right.peek())
                    result.add(left.poll());
                else{
                    result.add(right.poll());
                }
            }
        }
        return result;
    }

    public int numTeams(int[] rating) {
        TreeSet<Integer> afterSet = new TreeSet<>();
        TreeSet<Integer> beforeSet = new TreeSet<>();
        int result = 0;

        for (int i: rating){
            afterSet.add(i);
        }

        for (int currentRating : rating) {
            int zwischen_result = 0;
            // danach und größer als current
            zwischen_result += afterSet.tailSet(currentRating +1).size();
            //davor und kleiner
            zwischen_result *= beforeSet.headSet(currentRating).size();

            result += zwischen_result;
            zwischen_result = 0;

            // danach und kleiner als current
            zwischen_result += afterSet.headSet(currentRating).size();
            //davor und größer
            zwischen_result *= beforeSet.tailSet(currentRating + 1).size();

            result += zwischen_result;
            afterSet.remove(currentRating);
            beforeSet.add(currentRating);
        }

        return result;

    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        return minHeightShelvesHelper(books, shelfWidth, books[0][0], 1, new int[books.length],books[0][1]);
    }
    private int minHeightShelvesHelper(int[][] books, int shelfWidth, int currentShelfWidth, int index, int[] dp, int currentMax){
        //base case
        if(index == books.length -1){
            int result;
            if(books[index][0] + currentShelfWidth > shelfWidth){
                result = currentMax + books[index][1];
            }
            else{
                result = Math.max(currentMax, books[index][1]);
            }
            dp[index] = result;

            // na ja
            return result;
        }

        // recursive case
        //add it to bookshelf?
        int withBook = Integer.MAX_VALUE;
        if(currentShelfWidth + books[index][0] <= shelfWidth){
            withBook = minHeightShelvesHelper(books, shelfWidth, currentShelfWidth + books[index][0], index +1, dp, Math.max(currentMax, books[index][1]));
        }

        // not add it to bookshelf?
        int withoutBook = currentMax + minHeightShelvesHelper(books, shelfWidth, 0, index +1, dp, books[index][1]);

        int result = Math.min(withBook, withoutBook);
        dp[index] = result;
        return result;
    }



}








