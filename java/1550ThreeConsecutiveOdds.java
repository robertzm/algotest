class Solutions {
    public boolean threeConsecutiveOdds(int[] arr) {
        int odds = 0;
        for (int i : arr) {
            if (i % 2 == 1) {
                if (++odds == 3) {
                    return true;
                }
            } else {
                odds = 0;
            }
        }
        return false;
    }
}
