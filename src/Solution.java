import javax.lang.model.type.NullType;
import java.awt.event.MouseAdapter;
import java.io.*;
import java.sql.Array;
import java.util.*;


public class Solution {
    double minimalCost = Double.POSITIVE_INFINITY;
    public HashMap<Integer, Integer> Tribu = new HashMap<Integer, Integer>();


    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println( Arrays.toString(s.flipAndInvertImage(new int [][]  {{1,1,0},{1,0,1},{0,0,0}}  ) [0]));
        System.out.println(s.maxProfit(new int[]{1,3,2,8,4,9}, 2));
        //[3,1,3,1,1]
        //[1,3,2,8,4,9]
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

    public String replaceWords(List<String> dictionary, String sentence) {
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
        PriorityQueue<int[]> queue = new PriorityQueue<>( ((a,b) -> a[0] - b[0]));
        List<List<Integer>> res = new LinkedList<>();
        Set<String> visited = new HashSet<String>();
        queue.offer(new int[] {nums1[0] + nums2[0], 0, 0});
        visited.add("0,0");
        int n = nums1.length;
        int m = nums2.length;
        k--;
        while (k-- >= 0 && !queue.isEmpty()){
            int[] tmp = queue.poll();
            int firstIndex = tmp[1];
            int secondIndex = tmp[2];
            res.add(List.of(nums1[firstIndex], nums2[secondIndex]));
            if( firstIndex + 1 < n && !visited.contains(Integer.toString(firstIndex + 1) +"," + Integer.toString(secondIndex))){
                queue.offer(new int[] {nums1[firstIndex + 1] + nums2[secondIndex], firstIndex + 1, secondIndex});
                visited.add(Integer.toString(firstIndex + 1) +"," + Integer.toString(secondIndex));
            }
            if( secondIndex+ 1 < m && !visited.contains(Integer.toString(firstIndex) +"," + Integer.toString(secondIndex + 1))){
                queue.offer(new int[] {nums1[firstIndex] + nums2[secondIndex + 1], firstIndex, secondIndex + 1});
                visited.add(Integer.toString(firstIndex) +"," + Integer.toString(secondIndex + 1));
            }

        }
        return res;




    }


}







