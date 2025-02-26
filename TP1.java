import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class TP1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================================================");
        System.out.println("\n  ____             *                 *____         * *      \r\n" +
                " |  * \\           | |               |  *_ \\       | (_)      \r\n" +
                " | |_) |_   * ***| |**   ** ***** *** | |__) |__  __| |_  __ _ \r\n" +
                " |  * <| | | | '*_| '_ \\ / ` | ' \\|  ___/  \\/ ` | |/ _` |\r\n" +
                " | |_) | |_| | |  | | | | (_| | | | | |  |  __/ (_| | | (_| |\r\n" +
                " |____/ \\__,_|_|  |_| |_|\\__,_|_| |_|_|   \\___|\\__,_|_|\\__,_|\r\n" +
                "                                                             \r\n" +
                "                                                             ");
        System.out.println("=============================================================");
        System.out.println("============== Selamat datang di Burhanpedia! ===============");
        System.out.println("=============================================================");
        
        // Inisialisasi variabel (menggunakan String sesuai aturan)
        String stokBarang = "";
        String hargaBarang = "";
        String saldo = "";
        
        // Set tanggal awal ke 1 Februari 2025 (Sabtu)
        LocalDate currentDate = LocalDate.of(2025, 2, 1);
        String tanggalSekarang = currentDate.format(DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", new Locale("id", "ID")));
        
        String kodeVoucher = ""; // Awalnya kosong
        String barangDibeli = "0"; // Untuk melacak jumlah barang yang dibeli
        String statusPengiriman = "Tidak ada barang yang sedang dikirim";
        String totalPendapatan = "0";
        String jumlahTransaksiPendapatan = "0";
        String totalDiskonDiberikan = "0";
        String totalPengeluaran = "0";
        String jumlahTransaksiPengeluaran = "0";
        String totalDiskonDiterima = "0";
        
        // Input awal
        System.out.print("\nMasukkan stok awal: ");
        stokBarang = scanner.nextLine();
        
        System.out.print("Masukkan harga barang: ");
        hargaBarang = scanner.nextLine();
        
        System.out.print("Masukkan saldo awal: ");
        saldo = scanner.nextLine();
        
        // Loop menu utama
        boolean running = true;
        while (running) {
            System.out.println("\nPilih menu");
            System.out.println("1. Penjual");
            System.out.println("2. Pembeli");
            System.out.println("3. Hari Selanjutnya");
            System.out.println("4. Keluar");
            System.out.print("Perintah : ");
            String pilihan = scanner.nextLine();
            
            switch (pilihan) {
                case "1": // Menu Penjual
                    boolean menuPenjual = true;
                    while (menuPenjual) {
                        System.out.println("\n=== MENU PENJUAL ===");
                        System.out.println("1. Cek Stok");
                        System.out.println("2. Cek Harga Barang");
                        System.out.println("3. Tambah Stok");
                        System.out.println("4. Ubah Harga Barang");
                        System.out.println("5. Generate Voucher");
                        System.out.println("6. Kirim Barang");
                        System.out.println("7. Lihat Laporan Pendapatan");
                        System.out.println("8. Kembali ke Menu Utama");
                        System.out.print("Perintah: ");
                        String pilihanPenjual = scanner.nextLine();
                        
                        switch (pilihanPenjual) {
                            case "1": // Cek Stok
                                System.out.println("Stok barang saat ini: " + stokBarang);
                                break;
                                
                            case "2": // Cek Harga Barang
                                System.out.println("Harga barang saat ini: " + hargaBarang);
                                break;
                                
                            case "3": // Tambah Stok
                                System.out.print("Masukkan jumlah stok yang ingin ditambah: ");
                                String tambahStok = scanner.nextLine();
                                stokBarang = tambahString(stokBarang, tambahStok);
                                System.out.println("Stok berhasil ditambahkan. Stok sekarang: " + stokBarang);
                                break;
                                
                            case "4": // Ubah Harga Barang
                                System.out.print("Masukkan harga barang yang baru: ");
                                hargaBarang = scanner.nextLine();
                                System.out.println("Harga barang berhasil diubah.");
                                break;
                                
                            case "5": // Generate Voucher
                                kodeVoucher = "CHU-BET-ABE-TIN-YUK-YID-MFR-MNS-BIL-FER-MAZ"; // Sesuai format yang diberikan
                                System.out.println("Kode voucher baru: " + kodeVoucher);
                                break;
                                
                            case "6": // Kirim Barang
                                if (barangDibeli.equals("0")) {
                                    System.out.println("Tidak ada barang yang bisa dikirim.");
                                } else {
                                    statusPengiriman = "Status pengiriman: Sending";
                                    System.out.println("Barang sedang dalam perjalanan.");
                                    barangDibeli = "0"; // Reset setelah dikirim
                                }
                                break;
                                
                            case "7": // Lihat Laporan Pendapatan
                                System.out.println("\n=== LAPORAN PENDAPATAN ===");
                                System.out.println("Total Pendapatan: " + totalPendapatan);
                                System.out.println("Jumlah Transaksi: " + jumlahTransaksiPendapatan);
                                
                                String rataRataPendapatan = "0";
                                if (!jumlahTransaksiPendapatan.equals("0")) {
                                    rataRataPendapatan = bagiString(totalPendapatan, jumlahTransaksiPendapatan);
                                }
                                
                                System.out.println("Rata-rata Pendapatan: " + rataRataPendapatan);
                                System.out.println("Total Diskon Diberikan: " + totalDiskonDiberikan);
                                break;
                                
                            case "8": // Kembali ke Menu Utama
                                menuPenjual = false;
                                break;
                                
                            default:
                                System.out.println("Pilihan tidak valid.");
                                break;
                        }
                    }
                    break;
                    
                case "2": // Menu Pembeli
                    boolean menuPembeli = true;
                    while (menuPembeli) {
                        System.out.println("\n=== MENU PEMBELI ===");
                        System.out.println("1. Cek Saldo");
                        if (!kodeVoucher.equals("")) {
                            System.out.println(kodeVoucher + " | ");
                        }
                        System.out.println("2. Top Up Saldo");
                        System.out.println("3. Cek Harga Barang");
                        System.out.println("4. Beli Barang");
                        System.out.println("5. Generate Voucher");
                        System.out.println("6. Lacak Barang");
                        System.out.println("7. Lihat Laporan Pengeluaran");
                        System.out.println("8. Kembali ke menu utama");
                        System.out.print("Perintah : ");
                        String pilihanPembeli = scanner.nextLine();
                        
                        switch (pilihanPembeli) {
                            case "1": // Cek Saldo
                                System.out.println("Saldo Anda saat ini: " + saldo);
                                break;
                                
                            case "2": // Top up Saldo
                                System.out.print("Masukkan jumlah saldo yang ingin ditambahkan: ");
                                String tambahSaldo = scanner.nextLine();
                                saldo = tambahString(saldo, tambahSaldo);
                                System.out.println("Saldo berhasil ditambahkan. Saldo sekarang: " + saldo);
                                break;
                                
                            case "3": // Cek Harga Barang
                                System.out.println("Harga barang saat ini: " + hargaBarang);
                                break;
                                
                            case "4": // Beli Barang
                                System.out.print("Masukkan jumlah barang yang ingin dibeli: ");
                                String jumlahBeli = scanner.nextLine();
                                
                                // Check if quantity is 0 or negative
                                if (jumlahBeli.equals("0") || lebihBesar("0", jumlahBeli)) {
                                    System.out.println("Jumlah barang tidak valid");
                                    break;
                                }
                                
                                if (lebihBesar(jumlahBeli, stokBarang)) {
                                    System.out.println("Stok tidak mencukupi. Stok tersedia: " + stokBarang);
                                    break;
                                }
                                
                                // Voucher input
                                System.out.println("Masukkan kode voucher");
                                System.out.println("Jika tidak ada, ketik 'skip'");
                                System.out.println("Jika ingin buat, ketik 'generate'");
                                System.out.print("Kode: ");
                                String inputVoucher = scanner.nextLine();
                                
                                String totalBayar = kaliString(hargaBarang, jumlahBeli);
                                String diskon = "0";
                                
                                if (inputVoucher.equals("generate")) {
                                    kodeVoucher = "CHU-BET-ABE-TIN-YUK-YID-MFR-MNS-BIL-FER-MAZ";
                                    System.out.println("Voucher baru: " + kodeVoucher);
                                    
                                    // Ask again after generating
                                    System.out.println("Masukkan kode voucher");
                                    System.out.println("Jika tidak ada, ketik 'skip'");
                                    System.out.println("Jika ingin buat, ketik 'generate'");
                                    System.out.print("Kode: ");
                                    inputVoucher = scanner.nextLine();
                                }
                                
                                if (!inputVoucher.equals("skip")) {
                                    if (inputVoucher.equals(kodeVoucher)) {
                                        diskon = hitungDiskonVoucher(kodeVoucher);
                                        System.out.println("Voucher valid! Anda mendapatkan diskon " + diskon + "%");
                                        
                                        String nilaiDiskon = kaliString(totalBayar, diskon);
                                        nilaiDiskon = bagiString(nilaiDiskon, "100");
                                        totalBayar = kurangString(totalBayar, nilaiDiskon);
                                        
                                        // Update total diskon
                                        totalDiskonDiberikan = tambahString(totalDiskonDiberikan, nilaiDiskon);
                                        totalDiskonDiterima = tambahString(totalDiskonDiterima, nilaiDiskon);
                                        
                                        // Reset voucher setelah digunakan
                                        kodeVoucher = "";
                                    } else {
                                        System.out.println("Kode voucher tidak valid!");
                                    }
                                }
                                
                                // Tambahkan PPN 5%
                                String ppn = kaliString(totalBayar, "5");
                                ppn = bagiString(ppn, "100");
                                totalBayar = tambahString(totalBayar, ppn);
                                
                                System.out.println("Total pembayaran: " + totalBayar + " (sudah termasuk PPN 5%)");
                                
                                if (lebihBesar(totalBayar, saldo)) {
                                    System.out.println("Saldo tidak mencukupi!");
                                    break;
                                }
                                
                                // Proses transaksi
                                saldo = kurangString(saldo, totalBayar);
                                stokBarang = kurangString(stokBarang, jumlahBeli);
                                barangDibeli = tambahString(barangDibeli, jumlahBeli);
                                
                                // Update laporan transaksi
                                totalPendapatan = tambahString(totalPendapatan, totalBayar);
                                jumlahTransaksiPendapatan = tambahString(jumlahTransaksiPendapatan, "1");
                                
                                totalPengeluaran = tambahString(totalPengeluaran, totalBayar);
                                jumlahTransaksiPengeluaran = tambahString(jumlahTransaksiPengeluaran, "1");
                                
                                System.out.println("Pembelian berhasil! Saldo tersisa: " + saldo);
                                break;
                                
                            case "5": // Generate Voucher
                                kodeVoucher = "CHU-BET-ABE-TIN-YUK-YID-MFR-MNS-BIL-FER-MAZ";
                                System.out.println("Kode voucher baru: " + kodeVoucher);
                                break;
                                
                            case "6": // Lacak Barang
                                System.out.println(statusPengiriman);
                                break;
                                
                            case "7": // Lihat Laporan Pengeluaran
                                System.out.println("\n=== LAPORAN PENGELUARAN ===");
                                System.out.println("Total Pengeluaran: " + totalPengeluaran);
                                System.out.println("Jumlah Transaksi: " + jumlahTransaksiPengeluaran);
                                
                                String rataRataPengeluaran = "0";
                                if (!jumlahTransaksiPengeluaran.equals("0")) {
                                    rataRataPengeluaran = bagiString(totalPengeluaran, jumlahTransaksiPengeluaran);
                                }
                                
                                System.out.println("Rata-rata Pengeluaran: " + rataRataPengeluaran);
                                System.out.println("Total Diskon Diterima: " + totalDiskonDiterima);
                                break;
                                
                            case "8": // Kembali ke Menu Utama
                                menuPembeli = false;
                                break;
                                
                            case "B": // Allow 'B' to return to the main menu
                                menuPembeli = false;
                                break;
                                
                            default:
                                System.out.println("Pilihan tidak valid.");
                                break;
                        }
                    }
                    break;
                    
                case "3": // Hari Selanjutnya
                    // Menambahkan 1 hari pada tanggal sekarang
                    currentDate = currentDate.plusDays(1);
                    tanggalSekarang = currentDate.format(DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", new Locale("id", "ID")));
                    System.out.println("Tanggal sekarang: " + tanggalSekarang);
                    
                    // Reset status pengiriman
                    if (statusPengiriman.equals("Status pengiriman: Sending")) {
                        statusPengiriman = "Tidak ada barang yang sedang dikirim";
                    }
                    break;
                    
                case "4": // Keluar
                    System.out.println("Terima kasih telah menggunakan Burhanpedia!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    // Method untuk menghitung diskon dari kode voucher
    public static String hitungDiskonVoucher(String kodeVoucher) {
        // Implementation using recursive approach
        return hitungDiskonVoucherRekursif(kodeVoucher, "0", 0);
    }
    
    // Method rekursif untuk menghitung diskon
    private static String hitungDiskonVoucherRekursif(String kodeVoucher, String totalDiskon, int posisi) {
        // Base case: jika sudah mencapai akhir (5 pasangan)
        if (posisi >= 5) {
            // Jika diskon > 100%, kembalikan 100
            if (lebihBesar(totalDiskon, "100")) {
                return "100";
            }
            return totalDiskon;
        }
        
        // Terapkan algoritma pairing
        // Ambil karakter dari depan sesuai posisi
        char charDepan = kodeVoucher.charAt(posisi);
        // Ambil karakter dari belakang sesuai posisi
        char charBelakang = kodeVoucher.charAt(kodeVoucher.length() - 1 - posisi);
        
        // Konversi ke nilai angka
        int nilaiDepan = getNilaiKarakter(charDepan);
        int nilaiBelakang = getNilaiKarakter(charBelakang);
        
        // Hitung nilai untuk posisi saat ini
        int nilaiDepanMod = (nilaiDepan * posisi) % 10;
        int nilaiBelakangMod = (nilaiBelakang * (posisi + 1)) % 10;
        
        // Gabungkan hasil
        String hasilPosisi = String.valueOf(nilaiDepanMod + nilaiBelakangMod);
        String diskonBaru = tambahString(totalDiskon, hasilPosisi);
        
        // Lanjutkan ke posisi berikutnya
        return hitungDiskonVoucherRekursif(kodeVoucher, diskonBaru, posisi + 1);
    }
    
    // Method untuk mendapatkan nilai karakter
    private static int getNilaiKarakter(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10; // A=10, B=11, ..., Z=35
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10; // a=10, b=11, ..., z=35
        } else if (c >= '0' && c <= '9') {
            return c - '0'; // 0-9 remain as is
        } else if (c == '-') {
            return 0; // Handle hyphens in the voucher code
        }
        return 0; // Default for other characters
    }
    
    // Operasi matematika dasar dengan String
    
    // Method untuk menambahkan dua string angka
    public static String tambahString(String a, String b) {
        if (a.equals("")) return b;
        if (b.equals("")) return a;
        
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        return String.valueOf(num1 + num2);
    }
    
    // Method untuk mengurangkan dua string angka
    public static String kurangString(String a, String b) {
        if (a.equals("")) return "0";
        if (b.equals("")) return a;
        
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        return String.valueOf(num1 - num2);
    }
    
    // Method untuk mengalikan dua string angka
    public static String kaliString(String a, String b) {
        if (a.equals("") || b.equals("")) return "0";
        
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        return String.valueOf(num1 * num2);
    }
    
    // Method untuk membagi dua string angka
    public static String bagiString(String a, String b) {
        if (a.equals("")) return "0";
        if (b.equals("") || b.equals("0")) return "0"; // Hindari pembagian dengan nol
        
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        return String.valueOf(num1 / num2);
    }
    
    // Method untuk membandingkan dua string angka (true jika a > b)
    public static boolean lebihBesar(String a, String b) {
        if (a.equals("")) a = "0";
        if (b.equals("")) b = "0";
        
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        return num1 > num2;
    }
}