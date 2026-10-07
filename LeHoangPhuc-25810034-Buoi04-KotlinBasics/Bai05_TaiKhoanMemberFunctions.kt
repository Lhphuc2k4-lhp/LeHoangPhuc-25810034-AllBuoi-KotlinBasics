//Lê Hoàng Phúc 25810034
class TaiKhoanNganHang(
    val soTaiKhoan: String,
    soDuBanDau: Double
) {
    var soDu: Double = soDuBanDau
    fun napTien(soTien: Double) {
        soDu += soTien
    }
    fun rutTien(soTien: Double): Boolean {
        if (soDu >= soTien) {
            soDu -= soTien
            return true
        }
        return false
    }
}
val tk = TaiKhoanNganHang("TK001", 1000000.0)
println("Số dư ban đầu: ${tk.soDu}")
tk.napTien(500000.0)
println("Sau khi nạp tiền: ${tk.soDu}")
val ketQua1 = tk.rutTien(300000.0)
println("Rút 300000: $ketQua1")
println("Số dư: ${tk.soDu}")
val ketQua2 = tk.rutTien(2000000.0)
println("Rút 2000000: $ketQua2")
println("Số dư: ${tk.soDu}")