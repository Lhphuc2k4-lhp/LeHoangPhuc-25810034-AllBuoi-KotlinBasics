//Lê Hoàng Phúc 25810034
fun datBan(tenKhachHang: String,soLuong: Int, loaiBan: String = "Bàn thường") : String{
    return ("Tên khách hàng: $tenKhachHang \n, số lượng: $soLuong \n, loại bàn: $loaiBan ")
}
//Không truyền loại bàn → mặc định là Bàn thường
println(datBan("Phúc", 4))

//Truyền đủ theo thứ tự → tự chọn loại bàn
println(datBan("An", 6, "Bàn VIP"))

//Truyền bằng tên tham số
println(datBan(
    tenKhachHang = "Bình",
    soLuong = 3,
    loaiBan = "Bàn ngoài trời"
))