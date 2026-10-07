//Lê Hoàng Phúc
class KhachHang(
    var ho: String,
    var ten: String
) {
    var hoTen: String
        get() = "$ho $ten"
        set(value) {
            val danhSach = value.split(" ")
            ten = danhSach.last()
            ho = danhSach.dropLast(1).joinToString(" ")
        }
}
val kh = KhachHang("Nguyễn", "An")
println(kh.hoTen)
kh.ten = "Phúc"
println(kh.hoTen)
kh.hoTen = "Lê Hoàng Phúc"
println("Họ: ${kh.ho}")
println("Tên: ${kh.ten}")