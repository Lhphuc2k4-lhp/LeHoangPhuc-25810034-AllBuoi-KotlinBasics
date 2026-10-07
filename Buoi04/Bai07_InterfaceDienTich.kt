interface CoTheTinhDienTich {
    fun tinhDienTich(): Double
}
class HinhVuong(
    val canh: Double
) : CoTheTinhDienTich {
    override fun tinhDienTich(): Double {
        return canh * canh
    }
}
class HinhTron(
    val banKinh: Double
) : CoTheTinhDienTich {

    override fun tinhDienTich(): Double {
        return 3.14 * banKinh * banKinh
    }
}
val hinhVuong = HinhVuong(5.0)
val hinhTron = HinhTron(3.0)
println("Diện tích hình vuông: ${hinhVuong.tinhDienTich()}")
println("Diện tích hình tròn: ${hinhTron.tinhDienTich()}")