//Lê Hoàng Phúc 25810034
class TaiKhoanNganHang(
    val soTaiKhoan: String,
    soDuBanDau: Double
) {
    var soDu: Double = soDuBanDau

    init {
        if (soDuBanDau < 0) {
            println("So du khong hop le")
        } else {
            println("Tao tai khoan thanh cong, so du ban dau: $soDuBanDau")
        }
    }
}
val tk1 = TaiKhoanNganHang("TK001", 1000000.0)
val tk2 = TaiKhoanNganHang("TK002", -500000.0)