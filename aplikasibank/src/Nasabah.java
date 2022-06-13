public class Nasabah {
    private String NoRek;
    private String Nama;
    private int Saldo=500000;

    public Nasabah(){
        this.Nama ="Tanpa Nama";
        this.NoRek ="000000000";
        this.Saldo=0;
    }

    public Nasabah(String NoRek, String Nama) {
        this.NoRek = NoRek;
        this.Nama = Nama;
        this.Saldo = 500000;
    }

    public Nasabah(String NoRek, String Nama, int Saldo) {
        this.NoRek = NoRek;
        this.Nama = Nama;
        this.Saldo = Saldo;
    }

    /*
    Menambahkan saldo 
    */
    public void tambahSaldo(int nominal){
        this.Saldo+=nominal;
    }
    public String getNoRek() {
        return this.NoRek;
    }

    public void setNoRek(String NoRek) {
        this.NoRek = NoRek;
    }

    public String getNama() {
        return this.Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public int getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public static void cetakNomorRekening(){
        System.out.println("nomor rekening");
    }
    public void cetakNama(){
        System.out.println(Nama);
    }


    @Override
    public String toString() {
        return "" +
            "" + getNoRek() + "" +
            "\t" + getNama() + "" +
            "\t" + getSaldo() + "" +
            "";
    }
}
