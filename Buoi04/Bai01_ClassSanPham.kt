//Lê Hoàng Phúc 25810034
class SanPham(
    val tenSanPham: String,
    val gia: Double,
    val soLuongTonKho: Int = 0
)

val sp1 = SanPham("Dell G15",15000000.0,10)
println("Tên sản phẩm: ${sp1.tenSanPham}, giá: ${sp1.gia}, số lượng tồn kho: ${sp1.soLuongTonKho} ")
val sp2 = SanPham(tenSanPham = "Oppo", gia = 1000000.0, soLuongTonKho = 40)
println("Tên sản phẩm: ${sp2.tenSanPham}, giá: ${sp2.gia}, số lượng tồn kho: ${sp2.soLuongTonKho} ")