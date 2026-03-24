public class bitmanupulation {
    public static void main(String args[]) {
        // System.out.println((5 & 6)); // bitwise AND
        // System.out.println((5 | 6)); // bitwise OR
        // System.out.println((5 ^ 6)); // bitwise XOR
        // System.out.println((~5)); // give negative value as MSB is 1
        // System.out.println((5 << 2)); // left shift, equivalent to multiplying by 2^2
        // System.out.println((5 >> 2)); // right shift, equivalent to dividing by 2^2

        // evenoddbit(3);
        // evenoddbit(4);
        // evenoddbit(5);

        // System.out.println(getIthBit(10, 2));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearLastIBits(15, 2));
        // System.out.println(clearBitsInRange(10, 2, 4));
        // System.out.println(isPowerOfTwo(16));
        System.out.println(countSetBits(15));

    }

    public static void evenoddbit(int n) {         // check if the number is even or odd using bit manipulation.
        // check if the last bit is set or not     // Note: even numbers have last bit 0 and odd numbers have last bit 1.
        int bitmask = 1;                           // So doing AND operation with 1 will give 0 for even numbers and 1 for odd numbers.
        if ((n & bitmask) == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    public static int getIthBit(int n, int i) {         // get the ith bit of n, i.e. retrun the value of ith bit.
        int bitmask = 1 << i;
        if ((n & bitmask) == 0) {      // if ith bit is 0 so 'AND' with 1 will give 0 and if ith bit is 1 so 'AND' with 1 will give 1.
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {         // set the ith bit of n, i.e. make it 1.
        int bitmask = 1 << i;      
        return n | bitmask;   // 'OR' operation will set the ith bit to 1, wether it is 0 or 1.
    }

    public static int clearIthBit(int n, int i) {         // clear the ith bit of n, i.e. make it 0.
        int bitmask = ~(1 << i);  // negate the bitmask to have 0 at ith position and 1 at all other positions.
        return n & bitmask;  // 'AND' operation will clear the ith bit to 0, wether it is 0 or 1.
    }

    public static int updateIthBit(int n, int i, int newBit) {         // update the ith bit of n to newBit (0 or 1).
        // if(newBit == 0) {
        // return clearIthBit(n, i);         // if newBit is 0, clear the ith bit.
        // } else {
        // return setIthBit(n, i);         // if newBit is 1, set the ith bit.
        // }

        n = clearIthBit(n, i);  // clear the ith bit first.
        int bitmask = newBit << i;  // create a bitmask with newBit at ith position.
        return n | bitmask;  // 'OR' operation will set the ith bit to newBit.
    }

    public static int clearLastIBits(int n, int i) {         // clear the last i bits of n, i.e. make them 0.
        int bitmask = (~0) << i;  // create a bitmask with 0s at last i positions and 1s at all other positions. Eg: i=2 => bitmask=11111100, i.e. left shift of -1(~0) by 2.
        return n & bitmask;  // 'AND' operation will clear the last i bits to 0.  Eg: n=15(1111), i=2 => bitmask=11111100 => result=1111 & 11111100 = 1100(12)
    }

    public static int clearBitsInRange(int n, int i, int j) {         // clear bits from i to j in n, i.e. make them 0. Note: i >= 0 and j >= i
        int a = (~0) << (j + 1);     // create a mask for bits before i, i.e. doing left shift of -1(~0) by (j+1)
        int b = (1 << i) - 1;        // create a mask for bits after j, i.e. doing left shift of 1 by i and subtracting 1, so that all bits before i become 1.
        int bitmask = a | b;         // combine both masks, so that bits from i to j become 0 and all other bits become 1.
        return n & bitmask;          // clear bits in range i to j by doing 'AND' operation with bitmask.
    }

    public static boolean isPowerOfTwo(int n) {         // check if n is a power of 2
        return (n & (n - 1)) == 0;  // if n is a power of 2, then it has only one set bit and n-1 will have all bits after that set bit as 1, so doing 'AND' operation will give 0.
    }

    public static int countSetBits(int n) {         // count the number of set bits in n, i.e. number of 1s in binary representation of n.
        int count = 0;
        while (n > 0) {
            if((n & 1) != 0) {         // check LSB
                count++;
            }        
            n = n>>1;         
        }
        return count;
    }
}
