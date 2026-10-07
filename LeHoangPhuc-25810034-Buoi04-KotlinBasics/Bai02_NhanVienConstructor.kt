//Lê Hoàng Phúc 25810034
class NhanVien(
    maNhanVien: String,
    val ten: String,
    var luongThang: Double
) {
    constructor(ten: String) : this(
        ten = ten,
        maNhanVien = "TAM",
        luongThang = 0.0
    )
}
val nv1 = NhanVien("MUOI", "Kiệt", 1000000.0)
// println(nv1.maNhanVien) // Lỗi vì maNhanVien không có val/var nên không trở thành thuộc tính của class.
println("Tên nhân viên: ${nv1.ten}")
println("Lương tháng: ${nv1.luongThang}")
val nv2 = NhanVien(ten = "Tường")
println("Tên nhân viên: ${nv2.ten}")
println("Lương tháng: ${nv2.luongThang}")