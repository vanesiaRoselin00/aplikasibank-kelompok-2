import java.util.ArrayList;

public class Transaksi {
    public String noRek;

    ArrayList<String> logTransaksi = new ArrayList<String>();

    public Transaksi(String noRek){
        this.noRek = noRek;
    }

    public void tambahMutasiPenerima(int jumlah, String namaPengirim){
        logTransaksi.add("Anda menerima uang sebesar " + jumlah + " dari " + namaPengirim);
    }
    public void tambahMutasiPengirim(int jumlah, String namaPenerima){
        logTransaksi.add("Anda mengirim uang sebesar " + jumlah + " dari" + namaPenerima);
    }

    public String getNoRek() {
        return this.noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public ArrayList<String> getLogTransaksi() {
        return this.logTransaksi;
    }

    public void setLogTransaksi(ArrayList<String> logTransaksi) {
        this.logTransaksi = logTransaksi;
    }
    public void cetakMutasi(){
        System.out.println("Log Mutasi");
        for(String log : logTransaksi){
            System.out.println(log);
        }
    }
}
