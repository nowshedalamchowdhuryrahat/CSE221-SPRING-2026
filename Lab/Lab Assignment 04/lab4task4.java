import java.io.BufferedInputStream;
import java.io.IOException;

public class lab4task4 {

    static class FastInput {
        private final BufferedInputStream inputStream;
        private final byte[] buffer = new byte[1 << 16];
        private int position = 0, length = 0;

        FastInput() {
            inputStream = new BufferedInputStream(System.in);
        }

        private int readByte() throws IOException {
            if (position >= length) {
                length = inputStream.read(buffer);
                position = 0;
                if (length <= 0)
                    return -1;
            }
            return buffer[position++];
        }

        int nextInt() throws IOException {
            int current = readByte();
            while (current <= ' ' && current != -1) {
                current = readByte();
            }

            int sign = 1;
            if (current == '-') {
                sign = -1;
                current = readByte();
            }

            int value = 0;
            while (current > ' ') {
                value = value * 10 + (current - '0');
                current = readByte();
            }
            return value * sign;
        }
    }

    public static void main(String[] args) throws IOException {
        FastInput input = new FastInput();

        int nodeCount = input.nextInt();
        int edgeCount = input.nextInt();

        int[] edgeSources = new int[edgeCount];
        for (int i = 0; i < edgeCount; i++) {
            edgeSources[i] = input.nextInt();
        }

        int[] degree = new int[nodeCount + 1];

        for (int i = 0; i < edgeCount; i++) {
            int destination = input.nextInt();
            int source = edgeSources[i];
            degree[source]++;
            degree[destination]++;
        }

        int oddDegreeCount = 0;
        for (int i = 1; i <= nodeCount; i++) {
            if ((degree[i] & 1) == 1) {
                oddDegreeCount++;
            }
            if (oddDegreeCount > 2) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println((oddDegreeCount == 0 || oddDegreeCount == 2) ? "YES" : "NO");
    }
}
