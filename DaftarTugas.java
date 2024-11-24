import java.util.ArrayList;

class DaftarTugas {
    private ArrayList<Task> daftarTugas;

    public DaftarTugas() {
        this.daftarTugas = new ArrayList<>();
    }

    public ArrayList<Task> getDaftarTugas() {
        return this.daftarTugas;
    }

    public void tambahTugas(Task tugas) {
        this.daftarTugas.add(tugas);
    }

    public boolean hapusTugas(String judulTugas) {
        for (int i = 0; i < daftarTugas.size(); i++) {
            if (daftarTugas.get(i).getJudul().equalsIgnoreCase(judulTugas)) {
                daftarTugas.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean isTugasExist(String judulTugas) {
        for (Task tugas : this.getDaftarTugas()) {
            if (tugas.getJudul().equalsIgnoreCase(judulTugas)) {
                return true;
            }
        }
        return false;
    }
}