import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Nasabah> nasabah = new ArrayList<Nasabah>();
        ArrayList<Transaksi> logMutasi = new ArrayList<Transaksi>();
        nasabah.add(new Nasabah("0214578","Susi"));
        nasabah.add(new Nasabah("0214577","Budi"));

        int pilihan;
        String yn="y";
        Scanner input = new Scanner(System.in);
        do{
            //cetak menu
            cetakMenu();
            pilihan = input.nextInt();

            //percabangan
            if (pilihan == 0){
                String noRek;
                String nama;
                int saldo;
                input.nextLine();
                System.out.print("Masukkan Nomor Rekening = ");
                noRek = input.nextLine();
                System.out.print("Masukkan Nama = ");
                nama = input.nextLine();
                System.out.print("Masukkan Saldo =");
                saldo = input.nextInt();
                nasabah.add(new Nasabah(noRek, nama, saldo));
            }
            else if(pilihan==1){
                String NoRekTujuan="";
                String NoRekAsal="";
                int nominal;
                input.nextLine();
                //masukkan nomor rekening Asal 
                System.out.print("Masukkan Nomor Rekening Asal :");
                NoRekAsal = input.nextLine();
                //transfer
                //1. masukkan no rek
                System.out.print("Masukkan Nomor Rekening Tujuan :");
                NoRekTujuan = input.nextLine();
                //2. masukkan nominal transfer
                System.out.print("Masukkan Nominal Transfer : ");
                nominal = input.nextInt();
                Nasabah rekAsal, rekTujuan;

                //cek no rek asal
                if(cariNoRek(NoRekAsal, nasabah) >=0){
                    rekAsal = nasabah.get(cariNoRek(NoRekAsal, nasabah));
                }else{
                    System.out.print("Nomor Rek. Tidak Di temukan");
                    continue;
                }


                //3. cek apakah no rek ada/cocok/sesuai
                if(cariNoRek(NoRekTujuan, nasabah) >=0){
                    rekTujuan = nasabah.get(cariNoRek(NoRekTujuan, nasabah));
                        //4. cek apakah no rek 1 punya uang yang cukup
                    if((rekAsal.getSaldo() -100000)>nominal){
                            //jika semua kondisi benar, transfer uang, tulis log mutasi
                            //Pseudocode
                            rekAsal.tambahSaldo(nominal*-1);
                            int tmp = nominal;
                            rekTujuan.tambahSaldo(tmp);
                            System.out.println("Transfer Telah Berhasil, sisa saldo "+ rekAsal.getSaldo());
                            //catat log mutasi

                            //cek log mutasi
                            boolean ditemukan = false;
                            for(Transaksi log : logMutasi){
                                if(log.getNoRek().equals(rekAsal.getNoRek())){
                                    ditemukan = true;
                                }
                            }
                            if(!ditemukan){
                                logMutasi.add(new Transaksi(rekAsal.getNoRek()));
                            }

                            ditemukan = false;
                            for(Transaksi log : logMutasi){
                                if(log.getNoRek().equals(rekTujuan.getNoRek())){
                                    ditemukan = true;
                                }
                            }
                            if(!ditemukan){
                                logMutasi.add(new Transaksi(rekTujuan.getNoRek()));
                            }

                            for (Transaksi log : logMutasi){
                                if (log.getNoRek().equals(rekAsal.getNoRek())){
                                    log.tambahMutasiPengirim(nominal, rekAsal.getNama());
                                }
                                if (log.getNoRek().equals(rekTujuan.getNoRek())){
                                    log.tambahMutasiPenerima(nominal, rekTujuan.getNama());
                                }
                            }

                        //simpan data ke arraylist
                        //cari index rek tujuan cariNoRek(NoRekTujuan, nasabah)
                        
                        nasabah.set(cariNoRek(NoRekAsal, nasabah),rekAsal);
                        nasabah.set(cariNoRek(NoRekTujuan, nasabah),rekTujuan);
                        System.out.println("Transfer Sukses");
                    } 
                }
            }
            else if(pilihan==2){
                //cetak mutasi
                input.nextLine();
                System.out.print("Masukkan Nomor Rekening = ");
                String noRek = input.nextLine();
                boolean ditemukan = false;
                for(Transaksi log : logMutasi){
                    if(log.getNoRek().equals(noRek)){
                        log.cetakMutasi();
                        ditemukan = true;
                    }
                }
                if(!ditemukan){
                    System.out.println("Nomor Rekening tidak ditemukan");
                }
            }
            else if(pilihan==3){
                for (Nasabah nsb : nasabah) {
                    System.out.println("Nama = " + nsb.getNama());
                    System.out.println("Nomor Rekening = " + nsb.getNoRek());
                    System.out.println("Saldo = " + nsb.getSaldo());
                }
            }
            else if(pilihan==4) break;
            else continue;
        }while(yn.equalsIgnoreCase("y"));

    }
    /*Cetak Menu Program */
    public static void cetakMenu(){
        System.out.println("Bank ABCD");
        System.out.println("0. TAMBAH DATA NASABAH");
        System.out.println("1. TRANFER DARI SUSI KE BUDI");
        System.out.println("2. CETAK LOG MUTASI");
        System.out.println("3. Print Data Semua Nasabah");
        System.out.println("4. KELUAR");
        System.out.print("Masukkan pilihan anda ... ");
       
    }
    /*Cetak Menu Program test non static */
    public  void cetakMenu2(){
        System.out.println("Bank ABCD");
        System.out.println("1. TRANFER DARI SUSI KE BUDI");
        System.out.println("2. CETAK LOG MUTASI");
        System.out.println("3. KELUAR");
        System.out.print("Masukkan pilihan anda ... ");
        cetakMenu();
    }

    public static int cariNoRek(String norek,ArrayList<Nasabah> nasabah){
        int idx =0;
        for (Nasabah nsb : nasabah) {
            if(nsb.getNoRek().equalsIgnoreCase(norek)){
              //  System.out.print("Nomor Rek Di temukan pada index ke "+ idx);
                return idx;
            }
            idx+=1;
        }
        return -1;
    }
}