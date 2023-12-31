import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class ini adalah class yang paling benar setelah direvisi berkali - kali
public class ManajemenSum {
    // Fungsi untuk menambahkan data barang baru ke dalam ArrayList
    public static List<String> tambahBarang (String kategori, String namaBarang) {
        List<String> barang = new ArrayList<>();
        barang.add(kategori);
        barang.add(namaBarang);
        return barang;
    }
    // Fungsi untuk menambahkan data stok baru ke dalam ArrayList
    public static List<String> tambahStok (String namaBarang, String stok) {
        List<String> tambahStok = new ArrayList<>();
        tambahStok.add(namaBarang);
        tambahStok.add(stok);
        return tambahStok;
    }

    public static void main() {
        // Inisialisasi struktur data untuk menyimpan informasi gudang
        List<List<List<String>>> gudang = new ArrayList<>();
        List<List<String>> transaksi = new ArrayList<>();

        // Membuat data sample tambah barang
        gudang.add(new ArrayList<>());
        gudang.get(0).add(tambahBarang("Pakaian", "Baju Tidur"));
        gudang.get(0).add(tambahBarang("Pakaian", "Jaket Palka"));

        gudang.add(new ArrayList<>());
        gudang.get(1).add(tambahBarang("Makanan", "Nasi Merah"));
        gudang.get(1).add(tambahBarang("Makanan", "Donat Aceh"));

        // Membuat data sample tambah stok dari barang diatas
        transaksi.add(tambahStok(gudang.get(0).get(0).get(1).toString(), "20"));
        transaksi.add(tambahStok(gudang.get(0).get(1).get(1).toString(), "30"));
        transaksi.add(tambahStok(gudang.get(1).get(0).get(1).toString(), "25"));
        transaksi.add(tambahStok(gudang.get(1).get(1).get(1).toString(), "20"));
        // Menampilkan pesan selamat datang
        System.out.println("Selamat Datang di Manajemen Gudang Tharissa!");

        // Looping menu utama
        boolean loopingMenu = true;
        Scanner scanner = new Scanner(System.in);
        while (loopingMenu) {
            // Menampilkan menu pilihan kepada pengguna
            tampilkanMenu();
            // Menampilkan input pilihan menu kepada pengguna dengan memanggil fungsi yang sudah dibuat
            int pilihanUser = getPilihanUser(scanner);

            switch (pilihanUser) {
                // Menggunakan switch-case untuk menangani pilihan pengguna
                // Case 1 untuk memilih menu kategori
                case 1 -> {
                    boolean loopingKategori = true;
                    while (loopingKategori) {
                        tampilkanMenuKategori();
                        int pilihanMenuKategori = getPilihanUser(scanner);
                        // Menangani pilihan switch case user dengan switch case
                        switch (pilihanMenuKategori) {
                            case 1 -> {
                                System.out.println("Anda memilih menu untuk menambahkan kategori baru.");
                                tambahKategoriBaru(scanner, gudang, transaksi); // Memanggil fungsi tambah kategori baru dengan menyertakan scanner beserta arrayList nya(data set barang dan stok)
                            }
                            case 2 -> {
                                System.out.println("Anda memilih menu untuk menghapus kategori.");
                                hapusKategori(scanner, gudang); // Memangil fungsi menghapus kategori
                            }
                            case 3 -> {
                                System.out.println("Anda memilih menu untuk mengganti nama kategori.");
                                ubahNamaKategori(scanner, gudang); // Memanggil fungsi ubah nama kategori
                            }
                            case 4 -> {
                                System.out.println("Anda memilih menu untuk melihat kategori yang tersedia.");
                                outputJustCategory(gudang); // Memanggil fungsi lihat kategori
                            }
                            case 0 -> loopingKategori = false; // Loop diberhentikan karena program telah selesai
                            // Dalam scanner next int, bila kita inputkan karakter selain angka, maka hasil yang keluar adalah -1(error)
                            case -1 -> {
                                System.out.println("Maaf! Input pilihan user harus berupa angka! Untuk mencoba lagi, silahkan tekan enter.");
                                scanner.nextLine(); // Fungsinya untuk menghapus buffer
                            }
                            // Menampilkan pesan kesalahan untuk pilihan yang tidak valid misal angka 5 keatas
                            default -> {
                                System.out.println("Maaf menu, tidak tersedia, silahkan tekan enter untuk mencoba lagi.");
                                scanner.nextLine();
                            }
                        }
                    }
                }
                // Case 2 untuk memilih menu barang
                case 2 -> {
                    boolean loopingBarang = true;
                    while (loopingBarang) {
                        tampilkanMenuBarang();
                        int pilihanMenuBarang = getPilihanUser(scanner);
                        switch (pilihanMenuBarang) {
                            case 1 -> {
                                System.out.println("Anda memilih menu untuk menambahkan barang baru.");
                                tambahBarangBaru(scanner, gudang, transaksi); // Memanggil fungsi tambah barang baru
                            }
                            case 2 -> {
                                System.out.println("Anda memilih menu untuk mencari nama barang.");
                                cariBarang(scanner, gudang, transaksi); // Memanggil fungsi mencari nama barang
                            }
                            case 3 -> {
                                System.out.println("Anda memilih menu untuk mengganti nama barang.");
                                ubahNamaBarang(scanner, gudang, transaksi); // Memanggil fungsi ubah nama baarang
                            }
                            case 4 -> {
                                System.out.println("Anda memilih menu untuk melihat barang yang tersedia.");
                                lihatStokBarang(gudang, transaksi); // Memanggil fungsi lihat stok barang
                            }
                            case 0 -> loopingBarang = false;
                            case -1 -> {
                                System.out.println("Maaf! Input pilihan user harus berupa angka! Untuk mencoba lagi, silahkan tekan enter.");
                                scanner.nextLine();
                            }
                            default -> {
                                System.out.println("Maaf menu, tidak tersedia, silahkan tekan enter untuk mencoba lagi.");
                                scanner.nextLine();
                            }
                        }
                    }
                }
                // Case 3 untuk memilih menu stok
                case 3 -> {
                    boolean loopingStok = true;
                    while (loopingStok) {
                        tampilkanMenuStok();
                        int pilihanMenuStok = getPilihanUser(scanner);
                        switch (pilihanMenuStok) {
                            case 1 -> {
                                System.out.println("Anda memilih menu untuk menambahkan stok barang.");
                                penambahanStokBarang(scanner, gudang, transaksi); // Memanggil fungsi penambahan stok
                            }
                            case 2 -> {
                                System.out.println("Anda memilih menu untuk mengurangi stok barang.");
                                penguranganStokBarang(scanner, gudang, transaksi); // Memanggil fungsi pengurangan stok
                            }
                            case 3 -> {
                                System.out.println("Anda memilih menu untuk melihat barang yang tersedia.");
                                lihatStokBarang(gudang, transaksi); // Memanggil fungsi lihat stok barang
                            }
                            case 4 -> {
                                System.out.println("Anda memilih menu untuk melihat history stok barang.");
                                lihatHistoryStokBarang(transaksi); // Memanggil fungsi lihat history stok barang
                            }
                            case 0 -> loopingStok = false;
                            case -1 -> {
                                System.out.println("Maaf! Input pilihan user harus berupa angka! Untuk mencoba lagi, silahkan tekan enter.");
                                scanner.nextLine();
                            }
                            default -> {
                                System.out.println("Maaf menu, tidak tersedia, silahkan tekan enter untuk mencoba lagi.");
                                scanner.nextLine();
                            }
                        }
                    }
                }
                // Keluar dari aplikasi
                case 0 -> {
                    System.out.println("Anda memilih untuk keluar dari aplikasi.");
                    System.out.println("Terimakasih atas waktunya.");
                    System.out.println("==================================================================================================================================");
                    loopingMenu = false;
                }
                case -1 -> {
                    System.out.println("Maaf! Input pilihan user harus berupa angka! Untuk mencoba lagi, silahkan tekan enter.");
                    scanner.nextLine();
                }
                default -> {
                    System.out.println("Maaf menu, tidak tersedia, silahkan tekan enter untuk mencoba lagi.");
                    scanner.nextLine();
                }
            }
        }
        scanner.close(); // Fungsinya untuk menghindari kebocoran sumber daya
    }

    // Fungsi untuk menampilkan menu utama kepada pengguna
    private static  void tampilkanMenu() {
        System.out.println("==================================================================================================================================");
        System.out.println("Berikut adalah beberapa menu tindakan yang tersedia, silahkan pilih sesuai nomor.");
        System.out.println("1. Manajemen Kategori");
        System.out.println("2. Manajemen Barang");
        System.out.println("3. Manajemen Stok");
        System.out.println("0. Keluar dari aplikasi");
        System.out.println("==================================================================================================================================");
        System.out.print("Pilihan Anda (0-3) : ");
    }
    // Fungsi untuk menampilkan menu kategori kepada pengguna
    private static void tampilkanMenuKategori() {
        System.out.println("==================================================================================================================================");
        System.out.println("Berikut adalah beberapa menu manajemen kategori yang tersedia, silahkan pilih sesuai nomor.");
        System.out.println("1. Tambah kategori baru");
        System.out.println("2. Hapus kategori");
        System.out.println("3. Mengganti nama kategori");
        System.out.println("4. Melihat kategori yang tersedia");
        System.out.println("0. Keluar dari menu kategori");
        System.out.println("==================================================================================================================================");
        System.out.print("Pilihan Anda (0-4) : ");
    }
    // Fungsi untuk menampilkan menu barang kepada pengguna
    private static void tampilkanMenuBarang() {
        System.out.println("==================================================================================================================================");
        System.out.println("Berikut adalah beberapa menu manajemen barang yang tersedia, silahkan pilih sesuai nomor.");
        System.out.println("1. Menambah barang baru");
        System.out.println("2. Mencari nama barang");
        System.out.println("3. Mengganti nama barang");
        System.out.println("4. Melihat stok barang yang tersedia");
        System.out.println("0. Keluar dari menu barang");
        System.out.println("==================================================================================================================================");
        System.out.print("Pilihan Anda (0-4) : ");
    }
    // Fungsi untuk menampilkan menu stok kepada pengguna
    private static void tampilkanMenuStok() {
        System.out.println("==================================================================================================================================");
        System.out.println("Berikut adalah beberapa menu manajemen stok yang tersedia, silahkan pilih sesuai nomor.");
        System.out.println("1. Menambah stok barang");
        System.out.println("2. Mengurangi stok barang");
        System.out.println("3. Melihat stok barang yang tersedia");
        System.out.println("4. Melihat histori stok barang");
        System.out.println("0. Keluar dari menu stok");
        System.out.println("==================================================================================================================================");
        System.out.print("Pilihan Anda (0-4) : ");
    }
    // Fungsi untuk mendapatkan pilihan user
    private static int getPilihanUser(Scanner scanner) {
        int pilihanUser;
        // Mengecek inputan pengguna apakah integer atau bukan
        if (scanner.hasNextInt()) {
            pilihanUser = scanner.nextInt();
            scanner.nextLine(); // Untuk membersihkan buffer
        } else {
            scanner.nextLine();
            pilihanUser = -1; // Set untuk nilai yang salah
        }
        return pilihanUser;
    }
    // Fungsi untuk menampilkan data kategori saja
    private static void outputJustCategory(List<List<List<String>>> gudang) {
        if (gudang.size() == 0) {
            System.out.println("Mohon maaf, kategori belum tersedia. Silahkan buat baru di menu tambah kategori. Terimakasih.");
        } else {
            // Looping satu kali untuk menampilkan data kategori
            System.out.println("List Kategori : ");
            for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                String namaKategori = gudang.get(indeksKategori).get(0).get(0);
                System.out.printf("%s - %d\n", namaKategori, indeksKategori);
            }
        }

    }
    // Fungsi untuk mengecek apakah kategori sudah ada atau belum
    private static boolean categoryExisting(List<List<List<String>>> gudang, String kategoriBaru) {
        boolean categoryExists = false;
        for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
            String namaKategori = gudang.get(indeksKategori).get(0).get(0);
            // Dicek berdasarkan nama kategori yang ada di data dengan kategori inputan pengguna
            if (namaKategori.equalsIgnoreCase(kategoriBaru)) {
                // Kalau ada berikan statement categoryExists = true
                categoryExists = true;
                break;
            }
        }
        return categoryExists;
    }
    // Fungsi untuk menambahkan barang baru ke dalam gudang
    private static void tambahKategoriBaru(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
        // Logika untuk menambahkan kategori baru ke dalam gudang
        boolean validKategori = false;
        // Looping bila salah input kategori baru
        while (!validKategori) {
            System.out.println("Berikut list kategori yang tersedia : ");
            outputJustCategory(gudang); // Menampilkan list kategori yang sudah ada
            System.out.print("Silahkan inputkan kategori baru yang ingin ditambahkan : ");
            String kategoriBaru = scanner.nextLine(); // input pengguna untuk kategori baru

            boolean categoryExists = categoryExisting(gudang, kategoriBaru); // Memanggil fungsi untuk mengecek apakah kategori inputan pengguna sudah ada atau belum

            if (!kategoriBaru.equalsIgnoreCase("keluar")) {
                if (categoryExists) { // Jika kategori sudah ada, maka pengguna diminta untuk menginputkan kembali kategori baru
                    System.out.println("Maaf, kategori sudah ada, silahkan buat yang lain. Jika ingin kembali ke menu, silahkan ketik `keluar`");
                    validKategori = false;
                } else {
                    gudang.add(new ArrayList<>()); // Jika kategori tidak ada, maka kategori baru akan ditambahkan
                    int indexCategori = gudang.size() - 1;
                    gudang.get(indexCategori).add(tambahBarang(kategoriBaru, null)); // Dan nama barang dikosongkan terlebih dahulu
                    System.out.println("==================================================================================================================================");
                    System.out.println("Selamat! Anda berhasil menambahkan kategori baru! Berikut update datanya : ");
                    outputJustCategory(gudang); // Menampilkan semua list kategori
                    System.out.print("Apakah Anda ingin sekalian untuk menambahkan barang baru (y/n) ? "); // Menanyakan pengguna apakah ingin menambahkan barang
                    String pilihanPengguna = scanner.nextLine();
                    if (pilihanPengguna.equalsIgnoreCase("y")) {
                        tambahBarangBaru(scanner, gudang, transaksi); // Bila pengguna ingin menambahkan barang, maka pengguna akan diarahkan ke fungsi tambah barang baru
                    }
                    break; // Jika program berhasil, maka loop input kategori akan dihentikan
                }
            } else {
                break;
            }

        }
    }
    // Fungsi untuk menghapuskan kategori
    private static void hapusKategori (Scanner scanner, List<List<List<String>>> gudang) {
        boolean validKategori = false;
        while (!validKategori) {
            System.out.println("Berikut list kategori yang tersedia : ");
            outputJustCategory(gudang);
            System.out.print("Silahkan inputkan kategori barang yang ingin dihapus : ");
            String kategoriDihapus = scanner.nextLine();

            // Jika inputan pengguna adalah keluar, maka program akan dihentikan(kembali ke menu)
            if (kategoriDihapus.equalsIgnoreCase("keluar")) {
                break;
            } else {
                // Cek kategori dan item apakah sudah ada atau belum
                boolean categoryExists = false;
                boolean itemExists = false;
                int indexCategori = -1;
                for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                    String namaKategori = gudang.get(indeksKategori).get(0).get(0);
                    // Cek apakah kategori di data apakah sama dengan inputan pengguna
                    if (namaKategori.equalsIgnoreCase(kategoriDihapus)) {
                        if (gudang.get(indeksKategori).size() > 0) {
                            itemExists = true;
                        }
                        categoryExists = true; // Bila sama akan menampilkan nilai true
                        indexCategori = indeksKategori; // Dan indexing nya diambil sesuai dengan kategori yang ditemukan
                        break;
                    }
                }

                // Jika kategori tidak ada, maka pengguna akan diminta untuk menginputkan ulang kategori yg sudah ada
                if (!categoryExists) {
                    System.out.println("Maaf, kategori tidak ada, silahkan inputkan kategori yang sudah ada. Jika ingin kembali ke menu, silahkan ketik `keluar`");
                    validKategori = false;
                } else {
                    // Jika, didalam kategori ternyata tersedia barang, maka pengguna akan diminta validasi untuk menghapus data kategori
                    if (itemExists) {
                        System.out.print("Di kategori ini terdapat barang, apakah Anda tetap ingin menghapus kategori ini(y/n) ? ");
                        String hapusPaksa = scanner.nextLine();
                        if (hapusPaksa.equalsIgnoreCase("y")) { // Jika pengguna memilih ya, maka kategori akan terhapus
                            gudang.remove(indexCategori); // Fungsi untuk menghapus data dalam array list
                            System.out.println("==================================================================================================================================");
                            System.out.println("Selamat! Anda berhasil menghapus kategori " + kategoriDihapus + "! Berikut update datanya : ");
                            outputJustCategory(gudang);
                        } else {
                            // Jika pengguna memilih tidak menghapus kategori, maka program tidak akan melakukan penghapusan data
                            System.out.println("==================================================================================================================================");
                            System.out.println("Selamat! Kategori " + kategoriDihapus + " tidak terhapus.");
                        }
                        break; // Looping kategori akan dihentikan
                    }

                }
            }
        }
    }
    // Fungsi untuk mengubah nama kategori dalam gudang
    private static void ubahNamaKategori (Scanner scanner, List<List<List<String>>> gudang) {
        boolean validKategori = false;
        while (!validKategori) {
            System.out.println("Berikut list kategori yang tersedia : ");
            outputJustCategory(gudang);
            System.out.print("Silahkan inputkan nama kategori yang ingin dirubah : ");
            String kategoriLama = scanner.nextLine();

            if (kategoriLama.equalsIgnoreCase("keluar")) {
                break;
            } else {
                // Cek kategori sudah ada atau belum
                boolean categoryLamaExists = false;
                for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                    String namaKategori = gudang.get(indeksKategori).get(0).get(0);
                    if (namaKategori.equalsIgnoreCase(kategoriLama)) {
                        categoryLamaExists = true;
                        break;
                    }
                }

                if (!categoryLamaExists) {
                    System.out.println("Maaf, kategori tidak ada, silahkan inputkan kategori yang sudah ada. Jika ingin kembali ke menu, silahkan ketik `keluar`");
                    validKategori = false;
                } else {
                    boolean validKategoriBaru = false;
                    while (!validKategoriBaru) {

                        System.out.print("Silahkan inputkan kategori baru : ");
                        String kategoriBaru = scanner.nextLine();

                        if (kategoriBaru.equalsIgnoreCase("keluar")) {
                            validKategori = true;
                            break;
                        } else {
                            boolean categoryExists = categoryExisting(gudang, kategoriBaru);
                            for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                                String namaKategori = gudang.get(indeksKategori).get(0).get(0);
                                if (namaKategori.equalsIgnoreCase(kategoriLama)) {
                                    if (categoryExists) {
                                        System.out.println("Maaf, nama kategori sudah ada. Silahkan buat baru. Jika ingin kembali ke menu silahkan ketik `keluar`.");
                                        validKategoriBaru = false;
                                    } else {
                                        gudang.get(indeksKategori).get(0).set(0, kategoriBaru); // Merubah data di arrayList dengan mengunakan fungsi set
                                        System.out.println("==================================================================================================================================");
                                        System.out.println("Selamat! Anda berhasil merubah kategori " + kategoriLama + " dengan kategori " + kategoriBaru + ". Berikut update datanya : ");
                                        System.out.printf("Kategori : %s - %d\n", kategoriBaru, indeksKategori);
                                        // Jika semua program berhasil dilakukan, maka akan menghentikan semua looping inputan yang ada
                                        validKategori = true;
                                        validKategoriBaru = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    // Fungsi untuk menambahkan barang baru ke dalam gudang
    private static void tambahBarangBaru(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
        System.out.print("Berikut list barang yang tersedia : ");
        lihatStokBarang(gudang, transaksi);
        System.out.print("Silahkan inputkan kategori barang yang diinginkan : ");
        String kategoriBaru = scanner.nextLine();

        // Cek kategori sudah ada atau belum sesuai dengan inputan pengguna
        int categoryIndex = -1;
        boolean categoryExists = false;
        for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
            String namaKategori = gudang.get(indeksKategori).get(0).get(0);
            if (namaKategori.equalsIgnoreCase(kategoriBaru)) {
                categoryExists = true;
                categoryIndex = indeksKategori;
                break;
            }
        }

        boolean barangValid = false;
        while (!barangValid) {
            System.out.print("Silahkan inputkan nama barang yang diinginkan : ");
            String tambahNamaBarang = scanner.nextLine();
            if (tambahNamaBarang.equalsIgnoreCase("keluar")) {
                break;
            } else {
                // Cek bila barang sudah ada atau belum sesuai dengan inputan pengguna
                boolean itemExists = false;
                for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                    for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                        String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                        if (barangName != null) {
                            if (barangName.equalsIgnoreCase(tambahNamaBarang)) {
                                itemExists = true;
                                break;
                            }
                        }
                    }
                }
                // Bila barang tidak ada, maka datanya akan ditambahkan ke data set
                if (!itemExists) {
                    boolean validStok = false;
                    while (!validStok) {
                        System.out.print("Silahkan inputkan stok barang yang diinginkan : ");
                        String addStokBarang = scanner.nextLine();
                        if (addStokBarang.equalsIgnoreCase("keluar")) {
                            barangValid = true;
                            break;
                        } else {
                            // Cek agar inputan stok hanya berupa angka 0-9
                            if (addStokBarang.matches("^[0-9]+$")) {
                                // Karena sebelumnya input stok berupa string, maka untuk melakukan rumusnya harus dikonversi ke integer terlebih dahulu
                                int tambahStokBarang = Integer.parseInt(addStokBarang);
                                // Pengecekan agar stok tidak boleh diinputkan kurang dari 0
                                if (tambahStokBarang > 0) {
                                    // Fungsinya bila kategori tidak ada, maka akan dibuatkan kategori baru
                                    if (!categoryExists) {
                                        gudang.add(new ArrayList<>());
                                        categoryIndex = gudang.size() - 1;
                                    }
                                    // Menambahkan barang baru pada data set
                                    gudang.get(categoryIndex).add(tambahBarang(kategoriBaru, tambahNamaBarang));
                                    // Menambahkan stok pada data set transaksi
                                    transaksi.add(tambahStok(tambahNamaBarang, String.valueOf(tambahStokBarang)));
                                    System.out.println("==================================================================================================================================");
                                    System.out.print("Selamat! Anda berhasil menambahkan data barang baru! Berikut update datanya : ");
                                    lihatStokBarang(gudang, transaksi);
                                    // Menghentikan looping karena program berhasil dilakukan
                                    barangValid = true;
                                    break;
                                } else {
                                    // Menampilkan pesan kesalahan jika input stok kurang dari 0 dan bukan merupakan angka
                                    System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif! Jika ingin kembali ke menu silahkan ketik `keluar`.");
                                    validStok = false; // Looping kembali inputan stok karena terjadi error input
                                }
                            } else {
                                System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif! Jika ingin kembali ke menu silahkan ketik `keluar`.");
                                validStok = false;
                            }
                        }
                    }
                } else {
                    // Menampilkan pesan kesalahan jika barang sudah ada
                    System.out.print("Mohon maaf, barang tersebut sudah ada. Silahkan lihat stok barang yang tersedia. Dan buat nama barang baru. Jika ingin kembali ke menu silahkan ketik `keluar`.");
                    lihatStokBarang(gudang, transaksi);
                    barangValid = false; // Looping kembali inputan barang, karena inputan pengguna sudah ada di data set
                }
            }
        }

    }
    // Fungsi untuk mengurangi stok barang dalam gudang
    private static void penguranganStokBarang(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
        System.out.print("Berikut list stok barang yang tersedia : ");
        lihatStokBarang(gudang, transaksi); // Memanggil fungsi untuk melihat semua list stok barang
        boolean validKategori = false;
        while (!validKategori) {
            System.out.print("Silahkan inputkan kategori barang yang ingin dirubah : ");
            String kategoriBaru = scanner.nextLine();
            if (kategoriBaru.equalsIgnoreCase("keluar")){
                break;
            } else {
                boolean categoryExists = categoryExisting(gudang, kategoriBaru);
                // Jika kategori ada, maka program akan dilanjutkan
                if (categoryExists) {
                    boolean validBarang = false;
                    while (!validBarang) {
                        System.out.print("Silahkan inputkan nama barang yang diinginkan : ");
                        String tambahNamaBarang = scanner.nextLine();
                        if (tambahNamaBarang.equalsIgnoreCase("keluar")) {
                            validKategori = true;
                            break;
                        } else {
                            // Cek bila barang sudah ada atau belum
                            boolean itemExists = false;
                            for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                                for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                                    String categoryName = gudang.get(indeksKategori).get(indeksBarang).get(0);
                                    String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                                    // Cek apakah nama kategori barang yang diinginkan sesuai dengan kategori inputan pengguna sebelumnya
                                    if (categoryName.equalsIgnoreCase(kategoriBaru)) {
                                        if (barangName != null && barangName.equalsIgnoreCase(tambahNamaBarang)) {
                                            itemExists = true;
                                            break;
                                        }
                                    } else {
                                        validBarang = false;
                                        break;
                                    }
                                }
                            }

                            // Jika barang sudah ada, maka program akan dilanjutkan
                            if (itemExists) {
                                boolean validStok = false;
                                while (!validStok) {
                                    System.out.print("Silahkan inputkan jumlah stok yang ingin dikurangi : ");
                                    String kurangiStokBarang = scanner.nextLine();
                                    if (kurangiStokBarang.equalsIgnoreCase("keluar")) {
                                        validBarang = true;
                                        validKategori = true;
                                        break;
                                    } else {
                                        // Input kurangi stok harus berupa angka
                                        if (kurangiStokBarang.matches("^[0-9]+$")) {
                                            int minusStock = Integer.parseInt(kurangiStokBarang);
                                            // Input kurangi stok harus lebih dari 0
                                            if ((minusStock > 0)) {
                                                for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                                                    for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                                                        String namaKategori = gudang.get(indeksKategori).get(indeksBarang).get(0);
                                                        String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                                                        for (int indeksStok = 0; indeksStok < transaksi.size(); indeksStok++) {
                                                            // Mengecek agar nama barang di transaksi harus sesuai dengan nama barang di gudang
                                                            if (transaksi.get(indeksStok).get(0).equalsIgnoreCase(barangName)) {
                                                                // Bila hasilnya sama, maka akan mengambil jumlah stok nya
                                                                String stok = String.valueOf(sumStok(transaksi, barangName));
                                                                // Mengecek apakah nama baarang di data set sesuai dengan inputan pengguna
                                                                if (barangName != null && barangName.equalsIgnoreCase(tambahNamaBarang)) {
                                                                    int currentStock = Integer.parseInt(stok);
                                                                    String updatedStock = String.valueOf(currentStock - minusStock);
                                                                    // Pengecekan apakah hasil pengurangan adalah bilangan positif atau negatif
                                                                    if (Integer.parseInt(updatedStock) > 0) {
                                                                        String elemenKurang = "--" + kurangiStokBarang;
                                                                        // Menambahkan data transaksi agar stpk bisa diakumulasikan oleh program
                                                                        transaksi.add(tambahStok(barangName, elemenKurang)); // Ini fungsinya untuk pencatatan history
                                                                        transaksi.add(tambahStok(barangName, "-"+kurangiStokBarang)); // Kalau ini untuk penjumlahan stok
                                                                        String stokUpdate = String.valueOf(sumStok(transaksi, barangName)); // Mengambil hasil stok paling update
                                                                        System.out.println("==================================================================================================================================");
                                                                        System.out.println("Selamat! Anda berhasil mengurangi stok barang! Berikut update datanya : ");
                                                                        System.out.println("Kategori\t\t\t\tNama Barang\t\t\t\t\t\t\t\t\t\tStok");
                                                                        System.out.printf("%s - %d\t\t\t\t%s - %d\t\t\t\t\t\t\t\t\t%s\n", namaKategori, indeksKategori, barangName, indeksBarang, stokUpdate);
                                                                        validStok = true;
                                                                        validBarang = true;
                                                                        validKategori = true;
                                                                    } else {
                                                                        String stokUpdate = String.valueOf(sumStok(transaksi, barangName)); // Mengambil hasil stok paling update
                                                                        // Bila hasil pengurangan adalah bilangan negatif, maka pengguna diminta untuk memasukkan angka lebih kecil
                                                                        System.out.println("Maaf, barang tidak bisa dikurangkan dengan " + minusStock + " karena sisa stok di gudang hanya " + stokUpdate + ". Silahkan coba angka yang lebih kecil.");
                                                                        validStok = false;
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                        }

                                                    }
                                                }
                                            } else {
                                                System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif! Silahkan inputkan kembali. Jika ingin kembali ke menu, silahkan ketikkan `keluar`.");
                                                validStok = false;
                                            }
                                        } else {
                                            System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif! Silahkan inputkan kembali. Jika ingin kembali ke menu, silahkan ketikkan `keluar`.");
                                            validStok = false;
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Maaf! Barang di kategori ini tidak ada. Silahkan inputkan kembali dengan barang yang ada. Jika ingin kembali ke menu, silahkan ketikkan `keluar`.");
                                validBarang = false;
                            }
                        }
                    }
                } else {
                    System.out.println("Maaf! Kategori tidak ada. Silahkan inputkan kembali dengan kategori yang sudah ada. Jika ingin kembali ke menu, silahkan ketikkan `keluar`.");
                    validKategori = false;
                }
            }
        }
    }
    // Fungsi untuk menambahkan stok barang dalam gudang
    private static void penambahanStokBarang(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
        System.out.print("Berikut list stok barang yang tersedia : ");
        lihatStokBarang(gudang, transaksi);
        boolean validKategori = false;
        while (!validKategori) {
            System.out.print("Silahkan inputkan kategori barang yang ingin dirubah : ");
            String kategoriBaru = scanner.nextLine();
            if (kategoriBaru.equalsIgnoreCase("keluar")) {
                break;
            } else {
                boolean categoryExists = categoryExisting(gudang, kategoriBaru);
                // Jika kategori ada, maka akan melanjutkan perintah selanjutnya
                if (categoryExists) {
                    boolean validBarang = false;
                    while (!validBarang) {
                        System.out.print("Silahkan inputkan nama barang yang diinginkan : ");
                        String tambahNamaBarang = scanner.nextLine();
                        if (tambahNamaBarang.equalsIgnoreCase("keluar")) {
                            validKategori = true;
                            break;
                        } else {
                            // Cek bila barang sudah ada atau belum
                            boolean itemExists = false;
                            for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                                for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                                    String categoryName = gudang.get(indeksKategori).get(indeksBarang).get(0);
                                    String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                                    if (categoryName.equalsIgnoreCase(kategoriBaru)) {
                                        if (barangName != null && barangName.equalsIgnoreCase(tambahNamaBarang)) {
                                            itemExists = true;
                                            break;
                                        }
                                    } else {
                                        validBarang = false;
                                        break;
                                    }
                                }
                            }
                            // Jika barang sudah ada, maka program/perintah selanjutnya akan dilanjutkan
                            if (itemExists) {
                                boolean validStok = false;
                                while (!validStok) {
                                    System.out.print("Silahkan inputkan jumlah stok yang ingin ditambah : ");
                                    String tambahStok = scanner.nextLine();
                                    if (!tambahStok.equalsIgnoreCase("keluar")) {
                                        // Input stok harus berupa angka
                                        if (tambahStok.matches("^[0-9]+$")) {
                                            int additionalStock = Integer.parseInt(tambahStok);
                                            if ((additionalStock > 0)) { // Input stok harus berupa bilangan positif
                                                for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                                                    for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                                                        String namaKategori = gudang.get(indeksKategori).get(indeksBarang).get(0);
                                                        String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                                                        for (int indeksStok = 0; indeksStok < transaksi.size(); indeksStok++) {
                                                            if (transaksi.get(indeksStok).get(0).equalsIgnoreCase(barangName)) {
                                                                if (barangName != null && barangName.equalsIgnoreCase(tambahNamaBarang)) {
                                                                    String elemenTambah = "++" + tambahStok;
                                                                    transaksi.add(tambahStok(barangName, elemenTambah));
                                                                    transaksi.add(tambahStok(barangName, tambahStok));
                                                                    String stokUpdate = String.valueOf(sumStok(transaksi, barangName));
                                                                    System.out.println("==================================================================================================================================");
                                                                    System.out.println("Selamat! Anda berhasil menambahkan stok barang! Berikut update datanya : ");
                                                                    System.out.println("Kategori\t\t\t\tNama Barang\t\t\t\t\t\t\t\t\t\tStok");
                                                                    System.out.printf("%s - %d\t\t\t\t%s - %d\t\t\t\t\t\t\t\t\t%s\n", namaKategori, indeksKategori, barangName, indeksBarang, stokUpdate);
                                                                    validStok = true;
                                                                    validBarang = true;
                                                                    validKategori = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif! Silahkan inputkan kembali. Jika ingin kembali ke menu, silahkan ketikkan `keluar`.");
                                                validStok = false;
                                            }
                                        } else {
                                            System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif! Silahkan inputkan kembali. Jika ingin kembali ke menu, silahkan ketikkan `keluar`.");
                                            validStok = false;
                                        }
                                    } else {
                                        validBarang = true;
                                        validKategori = true;
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Maaf! Barang di kategori ini tidak ada. Silahkan inputkan kembali dengan barang yang ada. Jika ingin kembali ke menu, silahkan ketikkan `keluar`.");
                                validBarang = false;
                            }
                        }
                    }
                } else {
                    System.out.println("Maaf! Kategori tidak ada. Silahkan inputkan kembali dengan kategori yang sudah ada. Jika ingin kembali ke menu, silahkan ketikkan `keluar`.");
                    validKategori = false;
                }
            }
        }
    }
    // Fungsi untuk mencari barang yang ada
    private static void cariBarang(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
        System.out.print("Silahkan inputkan nama barang yang ingin dicari : ");
        String cariBarang = scanner.nextLine();
        boolean barangDitemukan = false; // Menyimpan status apakah barang ditemukan atau tidak
        // Looping untuk mencari barang yang mendekati dengan inputan pengguna
        for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
            String kategori = gudang.get(indeksKategori).get(0).get(0);
            boolean kategoriTercetak = false; // Menyimpan status apakah informasi kategori sudah tercetak atau tidak
            for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                // Mencari kehadiran barang sesuai dengan inputan pengguna menggunakan fungsi arrayList yaitu contains
                if (barangName != null && barangName.toLowerCase().contains(cariBarang.toLowerCase())) {
                    for (int indeksStok = 0; indeksStok < transaksi.size(); indeksStok++) {
                        String stok = transaksi.get(indeksStok).get(1);
                        if (transaksi.get(indeksStok).get(0).equalsIgnoreCase(barangName)) {
                            if (!barangDitemukan) {
                                System.out.println("==================================================================================================================================");
                                System.out.println("Selamat Anda berhasil menemukan barang yang dicari! Berikut datanya : ");
                                barangDitemukan = true;
                            }
                            if (!kategoriTercetak) {
                                System.out.println("-----------------------------------------------------------------------");
                                System.out.printf("Kategori: %s - %d\n", kategori, indeksKategori);
                                System.out.println("Nama Barang\t\t\t\t\t\t\t\t\t\tStok");
                                kategoriTercetak = true;
                            }
                            System.out.printf("%s - %d\t\t\t\t\t\t\t\t\t%s\n", barangName, indeksBarang, stok);
                            barangDitemukan = true; // Setel menjadi true jika barang ditemukan
                        }
                    }
                }
            }
        }

        if (!barangDitemukan) {
            System.out.println("Mohon maaf, barang " + cariBarang + " tidak ditemukan dalam gudang.");
        }
    }
    // Fungsi untuk mengubah nama barang dalam gudang
    private static void ubahNamaBarang(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
        boolean validKategori = false;
        while (!validKategori) {
            System.out.print("Berikut list stok barang yang tersedia : ");
            lihatStokBarang(gudang, transaksi);
            System.out.print("Silahkan inputkan nama kategori dari nama barang yang ingin diubah : ");
            String kategoriBaru = scanner.nextLine();
            if (kategoriBaru.equalsIgnoreCase("keluar")) {
                break;
            } else {
                boolean categoryExists = categoryExisting(gudang, kategoriBaru);
                if (!categoryExists) {
                    System.out.println("Maaf, kategori tidak ada, silahkan inputkan kategori yang sudah ada. Jika ingin kembali ke menu, silahkan ketik `keluar`");
                    validKategori = false;
                } else {
                    boolean validBarang = false;
                    while (!validBarang) {
                        System.out.print("Silahkan inputkan nama barang yang ingin diubah : ");
                        String barangLama = scanner.nextLine();
                        if (barangLama.equalsIgnoreCase("keluar")) {
                            validKategori = true;
                            break;
                        } else {
                            // FUngsinya untuk mengecek apakah nama barang yang diinputkan pengguna tersedia di database?
                            boolean itemExists = false;
                            for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                                for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                                    String categoryName = gudang.get(indeksKategori).get(indeksBarang).get(0);
                                    String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                                    if (categoryName.equalsIgnoreCase(kategoriBaru)) {
                                        if (barangName != null && barangName.equalsIgnoreCase(barangLama)) {
                                            itemExists = true;
                                            break;
                                        }
                                    } else {
                                        validBarang = false;
                                        break;
                                    }
                                }
                            }
                            // Bila barang lama sudah ada, maka pengguna diminta untuk input nama barang baru
                            if (itemExists) {
                                boolean validBarangBaru = false;
                                while (!validBarangBaru) {
                                    System.out.print("Silahkan inputkan nama barang yang baru : ");
                                    String barangBaru= scanner.nextLine();
                                    if (barangBaru.equalsIgnoreCase("keluar")) {
                                        validBarang = true;
                                        validKategori = true;
                                        break;
                                    } else {
                                        // Fungsinya untuk mengecek apakah inputan barang baru sudah ada di database atau belum
                                        boolean barangBaruExists = false;
                                        for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                                            for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                                                String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                                                if (barangName != null && barangName.equalsIgnoreCase(barangBaru)) {
                                                    barangBaruExists = true;
                                                    break;
                                                }
                                            }
                                        }

                                        for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                                            for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                                                String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                                                // Jika nama barang sudah ada, maka pengguna diminta untuk input kan kembali nama barang
                                                if (barangName != null && barangName.equalsIgnoreCase(barangLama)) {
                                                    if (barangBaruExists) {
                                                        System.out.println("Maaf, nama barang sudah ada. Silahkan buat yang baru. Jika ingin kembali ke menu, silahkan ketikkan `keluar`.");
                                                        validBarangBaru = false;
                                                    } else {
                                                        // Jika nama barang sudah sesuai, maka nama baru akan diganti menggunakan fungsi set
                                                        gudang.get(indeksKategori).get(indeksBarang).set(1, barangBaru);
                                                        for (int indeksTransaksi = 0; indeksTransaksi < transaksi.size(); indeksTransaksi++) {
                                                            if (transaksi.get(indeksTransaksi).get(0).equalsIgnoreCase(barangName)) {
                                                                transaksi.get(indeksTransaksi).set(0, barangBaru);
                                                            }
                                                        }
                                                        System.out.println("==================================================================================================================================");
                                                        System.out.println("Selamat! Anda berhasil merubah barang " + barangLama + " menjadi barang " + barangBaru + ". Berikut update datanya : ");
                                                        lihatStokBarang(gudang, transaksi);
                                                        validBarang = true;
                                                        validBarangBaru = true;
                                                        validKategori = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                // Menampilkan pesan kesalahan jika barang sudah ada
                                System.out.println("Mohon maaf, barang di kategori tersebut tidak ada. Silahkan inputkan barang yang sudah ada. Jika ingin kembali ke menu, silahkan ketikkan `keluar`.");
                            }
                        }
                    }
                }
            }
        }
    }
    // Fungsi untuk melihat history stok barang keluar masuk
    private static void lihatHistoryStokBarang(List<List<String>> transaksi) {
        boolean historyExist = false;
        System.out.println("Berikut data history nya : ");
        System.out.println("Nama Barang\t\t\t\t\t\t\t\t\t\tStok");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        for (int indeksTransaksi = 0; indeksTransaksi < transaksi.size(); indeksTransaksi++) {
            String namaBarang = transaksi.get(indeksTransaksi).get(0);
            String sum = transaksi.get(indeksTransaksi).get(1);

            if (sum.matches("^(\\+\\+|--).*")) {
                String sumFilter = sum.replaceAll("^--", "-").replaceAll("^\\+\\+", "+");
                System.out.printf("%s\t\t\t\t\t\t\t\t\t\t%s\n", namaBarang, sumFilter);
                historyExist = true; // Jika ada minimal satu data yang sesuai, set historyExist menjadi true
            }
        }

        if (!historyExist) {
            System.out.println("Mohon maaf, data history belum tersedia. Silahkan pilih menu tambah atau kurangi stok untuk melihat history.");
        }
    }

    // Fungsi untuk mengakumulasi stok berdasarkan nama yang sama
    private static int sumStok(List<List<String>> transaksi, String barangName){
        int jumlahStok = 0;
        // Looping untuk menghitung semua jumlah stok
        for (int indeksTransaksi = 0; indeksTransaksi < transaksi.size(); indeksTransaksi++) {
            // Fungsinya untuk mengecek apakah nama barang yang dihitung sama atau tidak
            if (barangName != null && transaksi.get(indeksTransaksi).get(0).toLowerCase().contains(barangName.toLowerCase())) {
                // Fungsinya agar data yang dijumlahkan hanya yang depannya angka saja atau - saja
                if (transaksi.get(indeksTransaksi).get(1).matches("^\\d+$") || transaksi.get(indeksTransaksi).get(1).matches("^\\-\\d+$")) {
                    int stok = Integer.parseInt(transaksi.get(indeksTransaksi).get(1)); // Diparsing supaya data bisa dijumlahkan
                    jumlahStok += stok; // Rumua penjumlahan data stok
                }
            }
        }
        return jumlahStok; // Mengembalikan jumlah stok bila program memanggil fungsi ini
    }
    // Fungsi untuk menampilkan stok barang yang ada dalam gudang
    private static void lihatStokBarang(List<List<List<String>>> gudang, List<List<String>> transaksi) {
        boolean barangExist = true;
        // Looping dua kali agar data bisa diambil satu per satu secara berurutan
        for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
            String namaKategori = gudang.get(indeksKategori).get(0).get(0);
            System.out.printf("\nKategori : %s - %d\n", namaKategori, indeksKategori);
            System.out.println("Nama Barang\t\t\t\t\t\t\t\t\t\tStok");
            for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                // Fungsinya untuk mengecek apalah barang tersedia atau tidak
                if (barangName != null) {
                    if (!gudang.get(indeksKategori).get(indeksBarang).isEmpty()) {
                        String stok = String.valueOf(sumStok(transaksi, barangName));
                        System.out.printf("%s - %d\t\t\t\t\t\t\t\t\t%s\n", barangName, indeksBarang, stok);
                    } else {
                        System.out.println("Maaf, barang di kategori ini belum tersedia!");
                    }
                    barangExist = true;
                } else {
                    barangExist = false;
                }
            }
            if(!barangExist) {
                System.out.println("Maaf, barang di kategori ini belum tersedia.");
            }
        }
    }
}