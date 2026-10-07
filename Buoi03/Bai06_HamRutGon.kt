//Lê Hoàng Phúc 25810034
fun binhPhuongFul(a: Int) : Int {
    return  a * a
}
fun binhPhuong(a: Int) : Int = a*a
println("Bình phương đầy đủ: ${binhPhuongFul(5)}")
println("Bình phương rút gọn: ${binhPhuong(5)}")
fun chuViHinhVuongFull(canh: Int) : Int {
    return  canh*4
}
fun chuViHinhVuong(canh: Int) :Int = canh*4
println("Chu vi đầy đủ: ${chuViHinhVuongFull(4)}")
println("Chu vi rút gọn: ${chuViHinhVuong(4)}")
fun kiemTraSoLeFull(so: Int) : Boolean {
    return  so % 2 != 0
}
fun kiemTraSoLe(so: Int) : Boolean = so % 2 !=0
println("Số chẵn đầy đủ: ${kiemTraSoLeFull(6)}")
println("Số chẵn đầy đủ: ${kiemTraSoLe(6)}")