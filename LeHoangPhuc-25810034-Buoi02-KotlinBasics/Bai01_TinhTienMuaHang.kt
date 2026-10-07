// Lê Hoàng Phúc - 25810034
fun main() {
    val soLuong: Int = 10
    val donGia: Double = 20000.0

    val tienHang = soLuong.toDouble() * donGia
    val thue = tienHang * 0.08
    val tongTien = tienHang + thue

    println("Tiền hàng: $tienHang, Thuế: $thue, Tổng tiền: $tongTien")
}