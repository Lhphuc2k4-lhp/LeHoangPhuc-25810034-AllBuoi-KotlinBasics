// Lê Hoàng Phúc - 25810034
fun main() {
    var soTruoc: Int = 0
    var soSau: Int = 1

    for (i in 0..100) {
        if (soTruoc >= 100) {
            break
        }

        println("Vị trí $i: $soTruoc")

        val soTiepTheo: Int = soTruoc + soSau
        soTruoc = soSau
        soSau = soTiepTheo
    }
}

