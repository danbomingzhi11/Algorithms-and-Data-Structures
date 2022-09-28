import java.util.Random;

public class StoingHelper {

    public static <E extends Comparable> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);

        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 三路排序
    public static <E extends Comparable> int partition3(E[] arr, int l, int r) {
        int i = l + 1;
        int j = r;
        int lt = i;
        int gt = j + 1;
        while (true) {
            if (i >= gt) {
                break;
            }
            if (arr[i].compareTo(arr[l]) < 0) {
                swap(arr, lt, i);
                lt++;
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                swap(arr, gt - 1, i);
                gt--;
            }else {
                i++;
            }
        }
        swap(arr, l, lt);
        return j;
    }

    // 双路快速排序
    public static <E extends Comparable> int partition2(E[] arr, int l, int r) {
        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, j, l);
        return j;

    }

    // 单路快速排序
    public static <E extends Comparable> int partition(E[] arr, int l, int r) {
        // 生成[l,r] 之间的随机索引
        int p = l + (new Random()).nextInt(r - l + 1);

        // l -> i   i+1 -> j
        int i = l;
        for (int j = i + 1; j <= i; j++) {
            if (arr[j].compareTo(arr[l]) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, i);
        return i;
    }

    public static <E> void swap(E[] arr, int a, int b) {
        E e = arr[a];
        arr[a] = arr[b];
        arr[b] = e;
    }
}
