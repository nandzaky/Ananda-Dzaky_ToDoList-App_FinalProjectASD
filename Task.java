class Task {
    private String judul;
    private String deskripsi;
    private String prioritas;
    private String deadline;

    public Task(String judul, String deskripsi, String prioritas, String deadline) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.prioritas = prioritas;
        this.deadline = deadline;
    }

    public String getJudul() { return judul; }
    public String getDeskripsi() { return deskripsi; }
    public String getPrioritas() { return prioritas; }
    public String getDeadline() { return deadline; }
}