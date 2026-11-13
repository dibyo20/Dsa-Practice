public class canPlaceFlowers {
    public static boolean canPlace(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
            i++;
        }

        return n <= 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = { 1, 0, 0, 0, 1 };
        int n = 1;
        System.out.println(canPlace(flowerbed, n));
    }
}
