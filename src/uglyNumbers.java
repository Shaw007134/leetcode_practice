class uglyNumbers {
    public int nthUglyNumbers(int n){
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int two = 0;
        int three = 0;
        int five = 0;
        for (int i = 0; i < n; i++) {
            int MultipleOfTwo = 2 * uglyNumbers[two];
            int MultipleOfThree = 3 * uglyNumbers[three];
            int MultipleOfFive = 5 * uglyNumbers[five];
            int min = Math.min(Math.min(MultipleOfTwo, MultipleOfThree), MultipleOfFive);
            uglyNumbers[i] = min;

            if(min == MultipleOfTwo) two++;
            if(min == MultipleOfThree) three++;
            if(min == MultipleOfFive) five++;
        }
        return uglyNumbers[n - 1];
    }
}
