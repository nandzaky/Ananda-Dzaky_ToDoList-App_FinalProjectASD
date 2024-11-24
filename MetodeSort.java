import java.util.ArrayList;

class MetodeSort {
    // Bubble Sort - Ascending
    public static void bubbleSortASC(ArrayList<Task> daftarTugas, String key) {
        int n = daftarTugas.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                boolean shouldSwap = false;
                switch (key) {
                    case "judul":
                        shouldSwap = daftarTugas.get(j).getJudul().compareToIgnoreCase(daftarTugas.get(j+1).getJudul()) > 0;
                        break;
                    case "prioritas":
                        shouldSwap = daftarTugas.get(j).getPrioritas().compareToIgnoreCase(daftarTugas.get(j+1).getPrioritas()) > 0;
                        break;
                    case "deadline":
                        shouldSwap = daftarTugas.get(j).getDeadline().compareToIgnoreCase(daftarTugas.get(j+1).getDeadline()) > 0;
                        break;
                }
                if (shouldSwap) {
                    Task temp = daftarTugas.get(j);
                    daftarTugas.set(j, daftarTugas.get(j+1));
                    daftarTugas.set(j+1, temp);
                }
            }
        }
    }

    // Quick Sort - Descending
    public static void quickSortDESC(ArrayList<Task> daftarTugas, String key) {
        quickSortDESC(daftarTugas, 0, daftarTugas.size() - 1, key);
    }

    private static void quickSortDESC(ArrayList<Task> daftarTugas, int low, int high, String key) {
        if (low < high) {
            int pi = partitionDESC(daftarTugas, low, high, key);
            quickSortDESC(daftarTugas, low, pi - 1, key);
            quickSortDESC(daftarTugas, pi + 1, high, key);
        }
    }

    private static int partitionDESC(ArrayList<Task> daftarTugas, int low, int high, String key) {
        Task pivot = daftarTugas.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            boolean shouldSwap = false;
            switch (key) {
                case "judul":
                    shouldSwap = daftarTugas.get(j).getJudul().compareToIgnoreCase(pivot.getJudul()) > 0;
                    break;
                case "prioritas":
                    shouldSwap = daftarTugas.get(j).getPrioritas().compareToIgnoreCase(pivot.getPrioritas()) > 0;
                    break;
                case "deadline":
                    shouldSwap = daftarTugas.get(j).getDeadline().compareToIgnoreCase(pivot.getDeadline()) > 0;
                    break;
            }
            if (shouldSwap) {
                i++;
                Task temp = daftarTugas.get(i);
                daftarTugas.set(i, daftarTugas.get(j));
                daftarTugas.set(j, temp);
            }
        }

        Task temp = daftarTugas.get(i + 1);
        daftarTugas.set(i + 1, daftarTugas.get(high));
        daftarTugas.set(high, temp);

        return i + 1;
    }
}