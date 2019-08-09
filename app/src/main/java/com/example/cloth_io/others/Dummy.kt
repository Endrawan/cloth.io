package com.example.cloth_io.others

import com.example.cloth_io.R
import com.example.cloth_io.models.Konveksi
import com.example.cloth_io.models.Mitra
import com.example.cloth_io.models.Product
import com.example.cloth_io.models.Trivia

class Dummy {
    companion object {
        val mitraList:MutableList<Mitra> = mutableListOf(
            Mitra("3-001", "Awesam", "0857654321", "Jl. SoeHat no.1A , Tidar, Malang", "4.3", "777654321", R.drawable.mitra1),
            Mitra("3-002", "Oyi Sam", "0857654321", "Jl. Kerto no.1B , Dinoyo, Malang", "4.6", "777654321", R.drawable.mitra2),
            Mitra("3-003", "Quicksilver Official", "0857654321", "Jl. SoeHat no.2A , Klojen, Malang", "4.1", "777654321", R.drawable.mitra3),
            Mitra("3-004", "Eiger Official", "0857654321", "Jl. Candi Borobudur no.13 , Lowokwaru, Malang", "4.8", "777654321", R.drawable.mitra4),
            Mitra("3-005", "Inspired27", "0857654321", "Jl. Jakarta no.15A , Sukun, Malang", "4.5", "777654321", R.drawable.mitra5)
        )

        val products:MutableList<Product> = mutableListOf(
            Product("INSPRD - Camouflag Panels", 599000, "Exped Parka 1.0 adalah jaket parka yang dirancang secara spesifik untuk melindungi Anda dari paparan angin saat melakukan aktivitas harian di luar ruangan", R.drawable.product5, mitraList[4]),
            Product("Quicksilver - Noosa Paradise Shirt", 400000, "Flece | higdencity | Woven Label\n" +
                    "\n" +
                    "\u0096 Jacket ini menggunakan kain Fleece sehingga sangat nyaman dipakai dengan tekstur kainnya yang lembut.\n" +
                    "\u0096 Lebih cepat kering dan hangat ketika dipakai.", R.drawable.product2, mitraList[2]),
            Product("OYISAM - OyisamTshirt", 68000, "KAOS RAIN DROP PENDEK\n" +
                    "\n" +
                    "Bahan : Cotton Printing\n" +
                    "Warna : Putih\n" +
                    "\n" +
                    "(Cek gambar. Karena beberapa faktor, akurasi warna hanya sekitar 80-90%)\n" +
                    "\n" +
                    "Model : Unisex (bisa untuk cowok maupun untuk cewek )", R.drawable.product3, mitraList[1]),
            Product("Eiger - Exped Parka", 599000, "- Kemeja bernuansa summer dengan motif bunga \n" +
                    "- Warna navy \n" +
                    "- Detail kerah \n" +
                    "- Unlined \n" +
                    "- Regular fit \n" +
                    "- Material katun tidak transparan, ringan, dan tidak strech \n" +
                    "- Tinggi model 186cm, mengenakan ukuran L ", R.drawable.product4, mitraList[3]),
            Product("Awesam - Kaos strip dominan hitam tosca", 65000, "KAOS POLOS STRIP DOMINAN :\n" +
                    "\n" +
                    "Warna : Hitam Tosca\n" +
                    "(Cek gambar. Karena beberapa faktor, akurasi warna hanya sekitar 80-90%)\n" +
                    "Model : Unisex (bisa untuk cowok maupun untuk cewek )\n" +
                    "Ukuran : S Sampai XL (P x L). Toleransi 2 cm..", R.drawable.product1, mitraList[0])
            )

        val productsSeller:MutableList<Product> = mutableListOf(
            Product("Jaket", 599000, "Exped Parka 1.0 adalah jaket parka yang dirancang secara spesifik untuk melindungi Anda dari paparan angin saat melakukan aktivitas harian di luar ruangan", R.drawable.product5, mitraList[4]),
            Product("Kameja", 400000, "Flece | higdencity | Woven Label\n" +
                    "\n" +
                    "\u0096 Jacket ini menggunakan kain Fleece sehingga sangat nyaman dipakai dengan tekstur kainnya yang lembut.\n" +
                    "\u0096 Lebih cepat kering dan hangat ketika dipakai.", R.drawable.product2, mitraList[2]),
            Product("Kaos", 68000, "KAOS RAIN DROP PENDEK\n" +
                    "\n" +
                    "Bahan : Cotton Printing\n" +
                    "Warna : Putih\n" +
                    "\n" +
                    "(Cek gambar. Karena beberapa faktor, akurasi warna hanya sekitar 80-90%)\n" +
                    "\n" +
                    "Model : Unisex (bisa untuk cowok maupun untuk cewek )", R.drawable.product3, mitraList[1]),
            Product("Parka", 599000, "- Kemeja bernuansa summer dengan motif bunga \n" +
                    "- Warna navy \n" +
                    "- Detail kerah \n" +
                    "- Unlined \n" +
                    "- Regular fit \n" +
                    "- Material katun tidak transparan, ringan, dan tidak strech \n" +
                    "- Tinggi model 186cm, mengenakan ukuran L ", R.drawable.product4, mitraList[3]),
            Product("Sweater", 65000, "KAOS POLOS STRIP DOMINAN :\n" +
                    "\n" +
                    "Warna : Hitam Tosca\n" +
                    "(Cek gambar. Karena beberapa faktor, akurasi warna hanya sekitar 80-90%)\n" +
                    "Model : Unisex (bisa untuk cowok maupun untuk cewek )\n" +
                    "Ukuran : S Sampai XL (P x L). Toleransi 2 cm..", R.drawable.product1, mitraList[0])
        )

        val trivias:MutableList<Trivia> = mutableListOf(
            Trivia("3 TIPS UNTUK MERAWAT KAOS POLOS BERWARNA PUTIH", "Awesam", "Apakah kawan awesam penggemar kaos polos warna putih? Memakai kaos putih memang akan membuat penampilan kita lebih cerah dan aman dipakai dalam momen apa pun. Tidak salah, jika kaos polos warna putih menjadi kaos polos yang wajib dimiliki. Jadikan kaos polos warna putih sebagai fashion item wajib yang harus kita miliki.\n" +
                    "\n" +
                    "Tetapi sayangnya, kaos polos warna putih sangat mudah kotor sehingga perlu perawatan ekstra. Kaos polos warna putih ketika disimpan dalam waktu yang lama juga akan berubah warna menjadi kuning. Mengganggu bukan? Tentu saja, kita tidak ingin penampilan kita berantakan karena warna pakaian yang berubah.\n" +
                    "\n" +
                    "TIPS MENCUCI KAOS WARNA PUTIH\n" +
                    "Kawan Awesam, berikut ini adalah 3 tips mudah melakukan perawatan kaos polos warna putih. Yuk, simak penjelasannya di bawah ini.\n" +
                    "\n" +
                    "1. Manfaatkan Larutan Pemutih\n" +
                    "Yang pertama agar kaos polos warna putih kamu tetap terjaga dengan baik, pastikan saat mencuci kaos polos warna putih kamu menggunakan larutan pemutih pakaian. Pilih larutan pemutih yang aman, karena terlalu sering menggunakan pemutih akan merusak serat kain. Tentu kamu tidak ingin pakaian kesayanganmu rusak bukan?\n" +
                    "\n" +
                    "2. Simpan Dalam Plastik\n" +
                    "Yang ke dua agar pakaian tidak kuning, simpan kaos polos warna putih yang jarang kamu pakai dalam plastik dan tutup rapat. Penyimpanan yang benar akan membantu kaos polos awet dan tidak menimbulkan flek atau noda yang akibat udara.\n" +
                    "\n" +
                    "3. Hindari Menyikat Baju Kotor\n" +
                    "Terkahir yang ke tiga kita mungkin kesal saat baju kesayangan kita kotor. Namun yang perlu kamu ingat, jangan langsung menyikat atau mencuci noda makanan atau debu pada permukaan kaos polos warna putih. Alangkah baiknya rendam terlebih dahulu selama kurang lebih 30 menit dengan air hangat, lalu sikat bagian noda secara perlahan menggunakan sikat berbulu halus supaya pakaian tidak lekas rusak.\n" +
                    "\n" +
                    "Nah, kawan Awesam demikian 3 hal yang perlu kita lakukan untuk merawat pakaian putih kamu agar awet. Semoga informasi ini bermanfaat.", R.drawable.trivia1)
        )

        val konveksliList:MutableList<Konveksi> = mutableListOf(
            Konveksi(1, "Defix", "Jl. UIN Syarif H no.12, Kedungkandang, Malang", "578944456", "021789123456", "555-120499-321", "4.9", R.drawable.konveksi1),
            Konveksi(2, "Akina Konveksi", "Jl. Selorejo, Blimbing, Malang", "578944458", "021789123478", "555-120499-456", "4.5", R.drawable.konveksi2),
            Konveksi(3, "Cheap Convection Malang", "Jl. Baiduri pandan no.17, Tlogomas, Malang", "578944457", "021789123455", "555-120499-320", "4.6", R.drawable.konveksi3),
            Konveksi(4, "NVN Konveksi", "Perum Griya Shanta no.39, Kerto, Malang", "578944459", "021789123451", "555-120499-012", "4.3", R.drawable.konveksi4),
            Konveksi(5, "Senopati Clothing", "Jl. Gajayana no.1, Soekarno-Hatta, Malang", "578944459", "021789123777", "555-120498-000", "4.4", R.drawable.konveksi5)
            )

        val bannerList:MutableList<Int> = mutableListOf(R.drawable.banner, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4)


    }
}