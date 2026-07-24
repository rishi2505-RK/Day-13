class Fancy {
    private static final long MOD = 1000000007L;

    private ArrayList<Long> values;
    private long add;
    private long mult;

    public Fancy() {
        values = new ArrayList<>();
        add = 0;
        mult = 1;
    }

    public void append(int val) {

        long normalized = ((val - add) % MOD + MOD) % MOD;
        normalized = normalized * modInverse(mult) % MOD;
        values.add(normalized);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mult = (mult * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= values.size()) {
            return -1;
        }

        long result = (values.get(idx) * mult + add) % MOD;
        return (int) result;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }
}