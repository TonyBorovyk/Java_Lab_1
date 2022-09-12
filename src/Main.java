import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int N = 1000;
        /* Scanner in = new Scanner(System.in);
               System.out.print("Введіть значення N: ");
               int N = in.nextInt(); */
        int [] arr_prime = findPrimeNumbers(generateSomeArray(N));
        int[] zeroCountArr = findZeroCounts(findPrimeNumbers(generateSomeArray(N)));
        showPrimeMax(zeroCountArr,arr_prime,N);

        /*System.out.println(showMax(findMax(arr_prime,zeroCountArr),arr_prime,zeroCountArr)
             +" "+findMax(arr_prime,zeroCountArr));*/

    }


    public static boolean IsPrimeNumber(int number) {
        boolean prime=false;
        if (number>1){
            prime = true;
            for (int j = 2; j <= number / 2; j++) {
                if (number % j == 0) {
                    prime = false;
                    break;
                }
            }
        }
        return prime;
    }
    public static int[] generateSomeArray(int n){
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i-1] = i;
        }
        return array;
    }
    public static int[] findPrimeNumbers(int[] array){ //condition = IsPrimeNumber(array[i-1])
        int[] array_1 = new int[array.length];
        for (int i = 0; i < array.length;i++){
            if(IsPrimeNumber(array[i])){
                array_1[i] = array[i];
            }
        }
        return array_1;
    }
    public static int[] findZeroCounts(int[] primeArray){
        int [] zeroCountArray = new int[primeArray.length];
        double temp = 0;
        for (int i = 0; i<primeArray.length;i++){
            if (primeArray[i]!=0){
                int zeroCount = 0;
                temp = primeArray[i];
                while(temp >= 1) {//(int)Math.ceil floor(9/2)
                    if(temp % 2 == 0){ // == змінити на != щоб знайти к-сть одиниць
                        zeroCount++;}
                    temp = Math.floor(temp/2);
                }
                zeroCountArray[i] = (zeroCount);
            }
        }
        return zeroCountArray;
    }
    public static int findMax(int[]primeArray, int[]zeroCountArray){
        int max = 0;
        int temp = 0;
            for (int j = 0; j<primeArray.length;j++){
                if(primeArray[j]!=0){
                    temp= zeroCountArray[j];
                    if(temp > max){
                        max = temp;
                }
            }
        }
        return max;
    }
    // Допоміжні функції для виведення
    public static ArrayList<Integer> showMax(int max,int[]primeArray, int[]zeroArray){
        ArrayList<Integer> maxList = new ArrayList<>();
        for (int j = 0; j<primeArray.length;j++){
            if(max==zeroArray[j] & max !=0){
                maxList.add(primeArray[j]);
            }
        }
        return maxList;
    }
    public static void showPrimeMax(int[]zeroCountArr,int[]arr_prime,int N){
        System.out.print("Найбільша к-сть нулів в двійковій формі:\n" +"-> "+
                findMax(arr_prime,zeroCountArr)+" в таких чисел:");
        showArr(showMax(findMax(arr_prime,zeroCountArr),arr_prime,zeroCountArr));

        /* Вивести всі прості числа і їхню к-сь нулів в двійковій формі
        for (int i = 0; i < N; i++) {
            if(arr_prime[i]!=0){
                System.out.println(zeroCountArr[i]+" "+arr_prime[i]);}
        }*/
    }
    public static void showArr(ArrayList<Integer> maxList){
        int counter = 0;
        for (Integer integer : maxList) {
            System.out.print(" " + integer);
            counter++;
            if(maxList.size()>counter){
                System.out.print(",");
            }
            else
                System.out.print(".");
        }
    }
}
