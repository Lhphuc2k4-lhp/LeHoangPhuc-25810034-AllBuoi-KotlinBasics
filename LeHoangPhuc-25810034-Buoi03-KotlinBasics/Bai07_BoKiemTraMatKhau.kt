//Lê Hoàng Phúc 25810034
val kiemTraDoDai: (String) -> Boolean = { chuoi -> chuoi.length >= 8 }
println("123456: ${kiemTraDoDai("123456")}")
println("12345678: ${kiemTraDoDai("12345678")}")
println("matkhau123: ${kiemTraDoDai("matkhau123")}")