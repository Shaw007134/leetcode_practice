class next_greater_element {
    public int findNext(int n){
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        while(i >=0 && a[i + 1] <= a[i]) i--;
        if(i < 0) return -1;

        int j = a.length - 1;
        while(j > i && a[j] <= a[i]) j--;
        swap(a, i ,j);
        reverse(a, i + 1);
        try {
            return Integer.parseInt(new String(a));
        }catch (Exception e){
            return -1;
        }
    }

    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while(i < j){
            swap(a, i++, j--);
        }
    }

    private void swap(char[] a, int i, int j) {
        char m = a[i];
        a[i] = a[j];
        a[j] = m;
    }
}