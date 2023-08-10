import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class Manajemen {
        // Fungsi untuk menambahkan data barang baru ke dalam ArrayList
        public static List<String> tambahBarang (String kategori, String namaBarang) {
            List<String> barang = new ArrayList<>();
            barang.add(kategori);
            barang.add(namaBarang);
            return barang;
        }

    public static List<String> tambahStok (String namaBarang, String stok) {
        List<String> tambahStok = new ArrayList<>();
        tambahStok.add(namaBarang);
        tambahStok.add(stok);
        return tambahStok;
    }

        public static void main() {
            // Inisialisasi struktur data untuk menyimpan informasi gudang
            List<List<List<String>>> gudang = new ArrayList<>();
            List<String> historyStok = new ArrayList<>();
            List<List<String>> transaksi = new ArrayList<>();

            // Membuat data sample
            gudang.add(new ArrayList<>());
            gudang.get(0).add(tambahBarang("Pakaian", "Baju Tidur"));
            gudang.get(0).add(tambahBarang("Pakaian", "Jaket Palka"));

            gudang.add(new ArrayList<>());
            gudang.get(1).add(tambahBarang("Makanan", "Nasi Merah"));
            gudang.get(1).add(tambahBarang("Makanan", "Donat Aceh"));


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
                    case 1 -> {
                        boolean loopingKategori = true;
                        while (loopingKategori) {
                            tampilkanMenuKategori();
                            // Menampilkan input pilihan menu kepada pengguna dengan memanggil fungsi yang sudah dibuat
                            int pilihanMenuKategori = getPilihanUser(scanner);
                            switch (pilihanMenuKategori) {
                                case 1 -> {
                                    System.out.println("Anda memilih menu untuk menambahkan kategori baru.");
                                    tambahKategoriBaru(scanner, gudang, transaksi); // Memanggil fungsi tambah barang baru dengan menyertakan scanner dan arrayList nya(data set)
                                }
                                case 2 -> {
                                    System.out.println("Anda memilih menu untuk menghapus kategori.");
                                    hapusKategori(scanner, gudang);
                                }
                                case 3 -> {
                                    System.out.println("Anda memilih menu untuk mengganti nama kategori.");
                                    ubahNamaKategori(scanner, gudang);
                                }
                                case 4 -> {
                                    System.out.println("Anda memilih menu untuk melihat kategori yang tersedia.");
                                    outputJustCategory(gudang);
                                }
                                case 0 -> loopingKategori = false; // Loop diberhentikan karena program telah selesai
                                // Menampilkan pesan kesalahan untuk input yang tidak valid semisalnya huruf/simbol
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
                    case 2 -> {
                        boolean loopingBarang = true;
                        while (loopingBarang) {
                            tampilkanMenuBarang();
                            // Menampilkan input pilihan menu kepada pengguna dengan memanggil fungsi yang sudah dibuat
                            int pilihanMenuBarang = getPilihanUser(scanner);
                            switch (pilihanMenuBarang) {
                                case 1 -> {
                                    System.out.println("Anda memilih menu untuk menambahkan barang baru.");
                                    tambahBarangBaru(scanner, gudang, transaksi);
                                }
                                case 2 -> {
                                    System.out.println("Anda memilih menu untuk mencari nama barang.");
                                    cariBarang(scanner, gudang, transaksi);
                                }
                                case 3 -> {
                                    System.out.println("Anda memilih menu untuk mengganti nama barang.");
                                    ubahNamaBarang(scanner, gudang, transaksi);
                                }
                                case 4 -> {
                                    System.out.println("Anda memilih menu untuk melihat barang yang tersedia.");
                                    lihatStokBarang(gudang, transaksi); // Memanggil fungsi lihat stok barang
                                }
                                case 0 -> loopingBarang = false; // Loop diberhentikan karena program telah selesai
                                // Menampilkan pesan kesalahan untuk input yang tidak valid semisalnya huruf/simbol
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
                    case 3 -> {
                        boolean loopingStok = true;
                        while (loopingStok) {
                            tampilkanMenuStok();
                            // Menampilkan input pilihan menu kepada pengguna dengan memanggil fungsi yang sudah dibuat
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
                                    lihatHistoryStokBarang(transaksi); // Memanggil fungsi lihat stok barang
                                }
                                case 0 -> loopingStok = false; // Loop diberhentikan karena program telah selesai
                                // Menampilkan pesan kesalahan untuk input yang tidak valid semisalnya huruf/simbol
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
                    // Keluar dari program
                    case 0 -> {
                        System.out.println("Anda memilih untuk keluar dari aplikasi.");
                        System.out.println("Terimakasih atas waktunya.");
                        System.out.println("==================================================================================================================================");
                        loopingMenu = false; // Loop diberhentikan karena program telah selesai
                    }
                    // Menampilkan pesan kesalahan untuk input yang tidak valid semisalnya huruf/simbol
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
            scanner.close(); // Fungsinya untuk menghindari kebocoran sumber daya
        }

        // Fungsi untuk menampilkan menu kepada pengguna

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
        private static void tampilkanMenuKategori() {
            // Menampilkan menu pilihan yang tersedia
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

        private static void tampilkanMenuBarang() {
            // Menampilkan menu pilihan yang tersedia
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

        private static void tampilkanMenuStok() {
            // Menampilkan menu pilihan yang tersedia
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
            // Mengambil input pilihan user dan mengembalikan nilainya jika benar/terjadi kesalahan input data
            int pilihanUser;
            // Mengecek inputan pengguna apakah integer atau bukan
            if (scanner.hasNextInt()) {
                pilihanUser = scanner.nextInt();
                scanner.nextLine(); // Untuk membersihkan buffer
            } else {
                scanner.nextLine(); // Untuk membersihkan buffer
                pilihanUser = -1; // Set untuk nilai yang salah
            }
            return pilihanUser;
        }

        private static void outputJustCategory(List<List<List<String>>> gudang) {
            // Looping 2 kali agar menampilkan kategori, barang secara keseluruhan
            if (gudang.size() == 0) {
                System.out.println("Kategori belum tersedia.");
            } else {
                for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                    String namaKategori = gudang.get(indeksKategori).get(0).get(0);
                    System.out.printf("Kategori : %s - %d\n", namaKategori, indeksKategori);
                }
            }

        }

        private static boolean categoryExisting(List<List<List<String>>> gudang, String kategoriBaru) {
            // Fungsinya untuk mengecek apakah kategori ada atau tidak
            boolean categoryExists = false;
            for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                String namaKategori = gudang.get(indeksKategori).get(0).get(0);
                if (namaKategori.equalsIgnoreCase(kategoriBaru)) {
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
            while (!validKategori) {
                System.out.println("Berikut list kategori yang tersedia : ");
                outputJustCategory(gudang);
                System.out.print("Silahkan inputkan kategori baru yang ingin ditambahkan : ");
                String kategoriBaru = scanner.nextLine();

                boolean categoryExists = categoryExisting(gudang, kategoriBaru);

                if (categoryExists) {
                    System.out.println("Maaf, kategori sudah ada, silahkan buat baru.");
                    validKategori = false;
                } else {
                    gudang.add(new ArrayList<>());
                    int indexCategori = gudang.size() - 1;
                    gudang.get(indexCategori).add(tambahBarang(kategoriBaru, null));
                    System.out.println("==================================================================================================================================");
                    System.out.println("Selamat! Anda berhasil menambahkan kategori baru! Berikut update datanya : ");
                    outputJustCategory(gudang);
                    System.out.print("Apakah Anda ingin sekalian untuk menambahkan barang baru (y/n) ? ");
                    String pilihanPengguna = scanner.nextLine();
                    if (pilihanPengguna.equalsIgnoreCase("y")) {
                        tambahBarangBaru(scanner, gudang, transaksi);
                    }
                    break;
                }
            }
        }

        private static void hapusKategori (Scanner scanner, List<List<List<String>>> gudang) {
            // Logika untuk menghapus kategori dalam gudang
            boolean validKategori = false;
            while (!validKategori) {
                System.out.println("Berikut list kategori yang tersedia : ");
                outputJustCategory(gudang);
                System.out.print("Silahkan inputkan kategori barang yang ingin dihapus : ");
                String kategoriDihapus = scanner.nextLine();

                if (kategoriDihapus.equalsIgnoreCase("keluar")) {
                    break;
                } else {
                    // Cek kategori sudah ada atau belum
                    boolean categoryExists = false;
                    boolean itemExists = false;
                    int indexCategori = -1;
                    for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                        String namaKategori = gudang.get(indeksKategori).get(0).get(0);
                        if (namaKategori.equalsIgnoreCase(kategoriDihapus)) {
                            if (gudang.get(indeksKategori).size() > 0) {
                                itemExists = true;
                            }
                            categoryExists = true;
                            indexCategori = indeksKategori;
                            break;
                        }
                    }

                    if (!categoryExists) {
                        System.out.println("Maaf, kategori tidak ada, silahkan inputkan kategori yang sudah ada. Jika ingin kembali ke menu, silahkan ketik `keluar`");
                        validKategori = false;
                    } else {
                        if (itemExists) {
                            System.out.print("Di kategori ini terdapat barang, apakah Anda tetap ingin menghapus kategori ini(y/n) ? ");
                            String hapusPaksa = scanner.nextLine();
                            if (hapusPaksa.equalsIgnoreCase("y")) {
                                gudang.remove(indexCategori);
                                System.out.println("==================================================================================================================================");
                                System.out.println("Selamat! Anda berhasil menghapus kategori " + kategoriDihapus + "! Berikut update datanya : ");
                                outputJustCategory(gudang);
                            } else {
                                System.out.println("==================================================================================================================================");
                                System.out.println("Selamat! Kategori " + kategoriDihapus + " tidak terhapus.");
                            }
                            break;
                        }

                    }
                }
            }
        }

        private static void ubahNamaKategori (Scanner scanner, List<List<List<String>>> gudang) {
            // Logika untuk mengubah nama kategori dalam gudang
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

                            boolean categoryExists = categoryExisting(gudang, kategoriBaru);

                            for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                                String namaKategori = gudang.get(indeksKategori).get(0).get(0);
                                if (namaKategori.equalsIgnoreCase(kategoriLama)) {
                                    if (categoryExists) {
                                        System.out.println("Maaf, nama kategori sudah ada. Silahkan buat baru.");
                                        validKategoriBaru = false;
                                    } else {
                                        gudang.get(indeksKategori).get(0).set(0, kategoriBaru);
                                        System.out.println("==================================================================================================================================");
                                        System.out.println("Selamat! Anda berhasil merubah kategori " + kategoriLama + " dengan kategori " + kategoriBaru + ". Berikut update datanya : ");
                                        System.out.printf("Kategori : %s - %d\n", kategoriBaru, indeksKategori);
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

        // Fungsi untuk menambahkan barang baru ke dalam gudang
        private static void tambahBarangBaru(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
            // Logika untuk menambahkan barang baru ke dalam gudang
            System.out.print("Berikut list barang yang tersedia : ");
            lihatStokBarang(gudang, transaksi);
            System.out.print("Silahkan inputkan kategori barang yang diinginkan : ");
            String kategoriBaru = scanner.nextLine();

            // Cek kategori sudah ada atau belum
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
                // Cek bila barang sudah ada
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
                // Bila barang sudah ada, maka datanya tidak akan ditambahkan ke data set
                if (!itemExists) {
                    boolean validStok = false;
                    while (!validStok) {
                        System.out.print("Silahkan inputkan stok barang yang diinginkan : ");
                        String addStokBarang = scanner.nextLine();
                        // Cek agar inputan stok hanya berupa angka 0-9
                        if (addStokBarang.matches("^[0-9]+$")) {
                            // Fungsinya untuk bila kategori tidak ada, maka dibuatkan kategori baru
                            if (!categoryExists) {
                                gudang.add(new ArrayList<>());
                                categoryIndex = gudang.size() - 1;
                            }
                            // Karena sebelumnya input stok berupa string, maka untuk melakukan rumusnya harus dikonversi ke integer terlebih dahulu
                            int tambahStokBarang = Integer.parseInt(addStokBarang);
                            // Pengecekan agar stok tidak boleh diinputkan kurang dari 0
                            if (tambahStokBarang > 0) {
                                // Menambahkan barang baru pada data set
                                gudang.get(categoryIndex).add(tambahBarang(kategoriBaru, tambahNamaBarang));
                                transaksi.add(tambahStok(tambahNamaBarang, String.valueOf(tambahStokBarang)));
                                System.out.println("==================================================================================================================================");
                                System.out.print("Selamat! Anda berhasil menambahkan data barang baru! Berikut update datanya : ");
                                lihatStokBarang(gudang, transaksi);
                                barangValid = true;
                                break;
                            } else {
                                // Menampilkan pesan kesalahan jika input stok kurang dari 0 dan bukan merupakan angka
                                System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif!");
                                validStok = false;
                            }
                        } else {
                            System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif!");
                            validStok = false;
                        }
                    }
                } else {
                    // Menampilkan pesan kesalahan jika barang sudah ada
                    System.out.print("Mohon maaf, barang tersebut sudah ada. Silahkan lihat stok barang yang tersedia. Dan buat nama barang baru.");
                    lihatStokBarang(gudang, transaksi);
                    barangValid = false;
                }
            }

        }

        // Fungsi untuk mengurangi stok barang
        private static void penguranganStokBarang(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
            // Logika untuk mengurangi stok barang dalam gudang
            System.out.print("Berikut list stok barang yang tersedia : ");
            lihatStokBarang(gudang, transaksi);
            boolean validKategori = false;
            while (!validKategori) {
                System.out.print("Silahkan inputkan kategori barang yang ingin dirubah : ");
                String kategoriBaru = scanner.nextLine();

                boolean categoryExists = categoryExisting(gudang, kategoriBaru);
                // Jika kategori ada, maka program akan dilanjutkan
                if (categoryExists) {
                    boolean validBarang = false;
                    while (!validBarang) {
                        System.out.print("Silahkan inputkan nama barang yang diinginkan : ");
                        String tambahNamaBarang = scanner.nextLine();

                        // Cek bila barang sudah ada
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

                        // Jika barang sudah ada, maka program akan dilanjutkan
                        if (itemExists) {
                            boolean validStok = false;
                            while (!validStok) {
                                System.out.print("Silahkan inputkan jumlah stok yang ingin dikurangi : ");
                                String kurangiStokBarang = scanner.nextLine();
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
                                                    if (transaksi.get(indeksStok).get(0).equalsIgnoreCase(barangName)) {
                                                        String stok = transaksi.get(indeksStok).get(1);
                                                        if (barangName != null && barangName.equalsIgnoreCase(tambahNamaBarang)) {
                                                            int currentStock = Integer.parseInt(stok);
                                                            String updatedStock = String.valueOf(currentStock - minusStock);
                                                            if (Integer.parseInt(updatedStock) > 0) {
                                                                String elemenKurang = "-" + kurangiStokBarang;
                                                                transaksi.add(tambahStok(barangName, elemenKurang));
                                                                transaksi.get(indeksStok).set(1, updatedStock);
                                                                System.out.println("==================================================================================================================================");
                                                                System.out.println("Selamat! Anda berhasil mengurangi stok barang! Berikut update datanya : ");
                                                                System.out.println("Kategori\t\t\t\tNama Barang\t\t\t\t\t\t\t\t\t\tStok");
                                                                System.out.printf("%s - %d\t\t\t\t%s - %d\t\t\t\t\t\t\t\t\t%s\n", namaKategori, indeksKategori, barangName, indeksBarang, updatedStock);
                                                                validStok = true;
                                                                validBarang = true;
                                                                validKategori = true;
                                                            } else {
                                                                System.out.println("Maaf, barang tidak bisa dikurangkan dengan " + minusStock + " karena menghasilkan nilai yang tidak valid. Silahkan coba angka yang lebih kecil.");
                                                                validStok = false;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                }

                                            }
                                        }
                                    } else {
                                        System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif! Silahkan inputkan kembali");
                                        validStok = false;
                                    }
                                } else {
                                    System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif! Silahkan inputkan kembali");
                                    validStok = false;
                                }
                            }
                        } else {
                            System.out.println("Maaf! Barang di kategori ini tidak ada. Silahkan inputkan kembali dengan barang yang ada.");
                            validBarang = false;
                        }
                    }
                } else {
                    // Menampilkan pesan kesalahan jika kategori tidak ada
                    System.out.println("Maaf! Kategori tidak ada. Silahkan inputkan kembali dengan kategori yang ada.");
                    validKategori = false;
                }
            }
        }

        // Fungsi untuk menambahkan stok barang
        private static void penambahanStokBarang(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
            // Logika untuk menambahkan stok barang dalam gudang
            System.out.print("Berikut list stok barang yang tersedia : ");
            lihatStokBarang(gudang, transaksi);
            boolean validKategori = false;
            while (!validKategori) {
                System.out.print("Silahkan inputkan kategori barang yang ingin dirubah : ");
                String kategoriBaru = scanner.nextLine();

                boolean categoryExists = categoryExisting(gudang, kategoriBaru);

                // Jika kategori ada, maka akan melanjutkan program/perintah selanjutnya
                if (categoryExists) {
                    boolean validBarang = false;
                    while (!validBarang) {
                        System.out.print("Silahkan inputkan nama barang yang diinginkan : ");
                        String tambahNamaBarang = scanner.nextLine();

                        // Cek bila barang sudah ada
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
                                // Input stok harus berupa angka
                                if (tambahStok.matches("^[0-9]+$")) {
                                    int additionalStock = Integer.parseInt(tambahStok);
                                    if ((additionalStock > 0)) {
                                        for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                                            for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                                                String namaKategori = gudang.get(indeksKategori).get(indeksBarang).get(0);
                                                String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                                                for (int indeksStok = 0; indeksStok < transaksi.size(); indeksStok++) {
                                                    if (transaksi.get(indeksStok).get(0).equalsIgnoreCase(barangName)) {
                                                        String stok = transaksi.get(indeksStok).get(1);
                                                        if (barangName != null && barangName.equalsIgnoreCase(tambahNamaBarang)) {
                                                            int currentStock = Integer.parseInt(stok);
                                                            String updatedStock = String.valueOf(currentStock + additionalStock);
                                                            String elemenTambah = "+" + tambahStok;
                                                            transaksi.add(tambahStok(barangName, elemenTambah));
                                                            transaksi.get(indeksStok).set(1, updatedStock);
                                                            System.out.println("==================================================================================================================================");
                                                            System.out.println("Selamat! Anda berhasil menambahkan stok barang! Berikut update datanya : ");
                                                            System.out.println("Kategori\t\t\t\tNama Barang\t\t\t\t\t\t\t\t\t\tStok");
                                                            System.out.printf("%s - %d\t\t\t\t%s - %d\t\t\t\t\t\t\t\t\t%s\n", namaKategori, indeksKategori, barangName, indeksBarang, updatedStock);
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
                                        System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif! Silahkan inputkan kembali.");
                                        validStok = false;
                                    }
                                } else {
                                    System.out.println("Maaf! Input stok harus berupa angka dan merupakan bilangan positif! Silahkan inputkan kembali.");
                                    validStok = false;
                                }
                            }
                        } else {
                            System.out.println("Maaf! Barang di kategori ini tidak ada. Silahkan inputkan kembali dengan barang yang ada.");
                            validBarang = false;
                        }
                    }
                } else {
                    System.out.println("Maaf! Kategori tidak ada. Silahkan inputkan kembali dengan barang yang ada.");
                    validKategori = false;
                }
            }

        }

        // Fungsi untuk mencari barang yang ada
        private static void cariBarang(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
            System.out.print("Silahkan inputkan nama barang yang ingin dicari : ");
            String cariBarang = scanner.nextLine();

            boolean barangDitemukan = false; // Menyimpan status apakah barang ditemukan atau tidak

            // Looping untuk mencari barang yang mendekati
            for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                String kategori = gudang.get(indeksKategori).get(0).get(0);
                boolean kategoriTercetak = false; // Menyimpan status apakah informasi kategori sudah tercetak atau tidak

                for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                    String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
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


    private static void ubahNamaBarang(Scanner scanner, List<List<List<String>>> gudang, List<List<String>> transaksi) {
            // Logika untuk mengubah nama barang dalam gudang
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

                            // Bila barang sudah ada, maka datanya tidak akan ditambahkan ke data set
                            if (itemExists) {
                                boolean validBarangBaru = false;
                                while (!validBarangBaru) {
                                    System.out.print("Silahkan inputkan nama barang yang baru : ");
                                    String barangBaru= scanner.nextLine();

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
                                            if (barangName != null && barangName.equalsIgnoreCase(barangLama)) {
                                                    if (barangBaruExists) {
                                                        System.out.println("Maaf, nama barang sudah ada. Silahkan buat yang baru.");
                                                        validBarangBaru = false;
                                                    } else {
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
                            } else {
                                // Menampilkan pesan kesalahan jika barang sudah ada
                                System.out.println("Mohon maaf, barang di kategori tersebut tidak ada. Silahkan inputkan barang yang sudah ada.");
                            }
                        }
                    }
                }
            }
        }

        // Fungsi untuk melihat history stok barang
        private static void lihatHistoryStokBarang(List<List<String>> transaksi) {
            System.out.println("Berikut data history nya : ");
            System.out.println("Nama Barang\t\t\t\t\t\t\t\t\t\tStok");
            for (int indeksTransaksi = 0; indeksTransaksi < transaksi.size(); indeksTransaksi++) {
                String namaBarang = transaksi.get(indeksTransaksi).get(0);
                String sum = transaksi.get(indeksTransaksi).get(1);
                if (sum.matches("^[+-].*")) {
                    System.out.printf("%s\t\t\t\t\t\t\t\t\t\t%s\n", namaBarang, sum);
                }
            }
        }

        // Fungsi untuk melihat stok barang yang tersedia
        private static void lihatStokBarang(List<List<List<String>>> gudang, List<List<String>> transaksi) {
            // Menampilkan stok barang yang ada dalam gudang
            for (int indeksKategori = 0; indeksKategori < gudang.size(); indeksKategori++) {
                String namaKategori = gudang.get(indeksKategori).get(0).get(0);
                System.out.printf("\nKategori : %s - %d\n", namaKategori, indeksKategori);
                System.out.println("Nama Barang\t\t\t\t\t\t\t\t\t\tStok");
                for (int indeksBarang = 0; indeksBarang < gudang.get(indeksKategori).size(); indeksBarang++) {
                    String barangName = gudang.get(indeksKategori).get(indeksBarang).get(1);
                    for (int indeksStok = 0; indeksStok < transaksi.size(); indeksStok++) {
                        if (transaksi.get(indeksStok).get(0).equalsIgnoreCase(barangName)) {
                            String stok = transaksi.get(indeksStok).get(1);
                            if (gudang.get(indeksKategori).get(indeksBarang).size() == 0) {
                                System.out.println("Maaf, barang di kategori ini belum tersedia!");
                            } else {
                                if (barangName != null) {
                                    System.out.printf("%s - %d\t\t\t\t\t\t\t\t\t%s\n", barangName, indeksBarang, stok);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }