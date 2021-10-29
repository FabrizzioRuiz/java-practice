package kata;

import static org.junit.Assert.*;
import org.junit.Test;

public class KataTest {

    @Test
    public void sampleTests() {
        assertArrayEquals(new int[] {2,2}, Array.arrayDiff(new int [] {1,2,2}, new int[] {1}));
        assertArrayEquals(new int[] {1}, Array.arrayDiff(new int [] {1,2,2}, new int[] {2}));
        assertArrayEquals(new int[] {1,2,2}, Array.arrayDiff(new int [] {1,2,2}, new int[] {}));
        assertArrayEquals(new int[] {}, Array.arrayDiff(new int [] {}, new int[] {1,2}));
    }
}