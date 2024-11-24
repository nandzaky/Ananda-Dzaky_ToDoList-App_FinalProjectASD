import java.util.Scanner;
import java.util.ArrayList;

class AplikasiManajemenTugas {
    private Scanner input;
    private DaftarTugas daftarTugas;
    
    public AplikasiManajemenTugas() {
        input = new Scanner(System.in);
        daftarTugas = new DaftarTugas();
    }

    public void pesan() {
        System.out.println("Selamat datang di Aplikasi Manajemen Tugas!");
    }

    public void perintah() {
        System.out.println("\nMenu Perintah:");
        System.out.println("Ketik '1' untuk menambah tugas baru");
        System.out.println("Ketik '2' untuk menghapus tugas");
        System.out.println("Ketik '3' untuk mengurutkan tugas");
        System.out.println("Ketik '4' untuk melihat daftar tugas");
        System.out.println("Ketik '0' untuk keluar");
    }

    public void run() {
        while (true) {
            perintah();
            System.out.print("\nMasukkan pilihan: ");
            String pilihan = input.nextLine();

            switch (pilihan) {
                case "1":
                    tambahTugas();
                    break;
                case "2":
                    hapusTugas();
                    break;
                case "3":
                    if (daftarTugas.getDaftarTugas().size() < 2) {
                        System.out.println("Minimal harus ada 2 tugas untuk melakukan pengurutan!");
                    } else {
                        urutkanTugas();
                    }
                    break;
                case "4":
                    tampilkanTugas();
                    break;
                case "0":
                    System.out.println("\nTerima kasih telah menggunakan aplikasi ini!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void tambahTugas() {
        System.out.print("\nMasukkan judul tugas: ");
        String judul = input.nextLine();

        if (daftarTugas.isTugasExist(judul)) {
            System.out.println("Tugas dengan judul tersebut sudah ada!");
            return;
        }

        System.out.print("Masukkan deskripsi tugas: ");
        String deskripsi = input.nextLine();

        System.out.print("Masukkan prioritas (Rendah/Sedang/Tinggi): ");
        String prioritas = input.nextLine();

        System.out.print("Masukkan deadline (format: DD/MM/YYYY): ");
        String deadline = input.nextLine();

        Task tugas = new Task(judul, deskripsi, prioritas, deadline);
        daftarTugas.tambahTugas(tugas);
        System.out.println("Tugas berhasil ditambahkan!");
    }

    private void hapusTugas() {
        System.out.print("\nMasukkan judul tugas yang akan dihapus: ");
        String judul = input.nextLine();

        if (daftarTugas.hapusTugas(judul)) {
            System.out.println("Tugas berhasil dihapus!");
        } else {
            System.out.println("Tugas tidak ditemukan!");
        }
    }

    private void urutkanTugas() {
        System.out.println("\nPilih metode pengurutan:");
        System.out.println("1. Bubble Sort (Ascending)");
        System.out.println("2. Quick Sort (Descending)");
        System.out.print("Masukkan pilihan (1/2): ");
        String metode = input.nextLine();

        System.out.println("\nUrutkan berdasarkan:");
        System.out.println("1. Judul");
        System.out.println("2. Prioritas");
        System.out.println("3. Deadline");
        System.out.print("Masukkan pilihan (1/2/3): ");
        String kriteria = input.nextLine();

        String key = "";
        switch (kriteria) {
            case "1": key = "judul"; break;
            case "2": key = "prioritas"; break;
            case "3": key = "deadline"; break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        if (metode.equals("1")) {
            MetodeSort.bubbleSortASC(daftarTugas.getDaftarTugas(), key);
        } else if (metode.equals("2")) {
            MetodeSort.quickSortDESC(daftarTugas.getDaftarTugas(), key);
        } else {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        System.out.println("Daftar tugas berhasil diurutkan!");
        tampilkanTugas();
    }

    private void tampilkanTugas() {
        ArrayList<Task> tasks = daftarTugas.getDaftarTugas();
        if (tasks.isEmpty()) {
            System.out.println("\nDaftar tugas kosong!");
            return;
        }

        System.out.println("\nDaftar Tugas:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println("\nTugas #" + (i+1));
            System.out.println("Judul     : " + task.getJudul());
            System.out.println("Deskripsi : " + task.getDeskripsi());
            System.out.println("Prioritas : " + task.getPrioritas());
            System.out.println("Deadline  : " + task.getDeadline());
        }
    }
}