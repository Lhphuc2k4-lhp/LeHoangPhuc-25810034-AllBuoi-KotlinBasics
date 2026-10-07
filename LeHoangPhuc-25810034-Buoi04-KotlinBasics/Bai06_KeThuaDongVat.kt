open class DongVat(
    val ten: String
) {
    open fun keu(): String {
        return "Động vật đang kêu"
    }
}
class Cho(ten: String) : DongVat(ten) {
    override fun keu(): String {
        return "Gâu gâu"
    }
}
class Meo(ten: String) : DongVat(ten) {
    override fun keu(): String {
        return "Meo meo"
    }
}
val danhSach = listOf(
    Cho("Milu"),
    Meo("Mimi")
)
for (dongVat in danhSach) {
    println("Tên: ${dongVat.ten}, Tiếng kêu: ${dongVat.keu()}")
}