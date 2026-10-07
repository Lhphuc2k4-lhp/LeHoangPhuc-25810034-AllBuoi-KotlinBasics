// Lê Hoàng Phúc - 25810034
fun main() {
    val canNang: Double = 60.0
    val chieuCao: Double = 1.70

    val bmi: Double = canNang / (chieuCao * chieuCao)

    if (bmi < 18.5) {
        println("BMI: $bmi")
        println("Phân loại: Gầy")
    } else if (bmi < 25.0) {
        println("BMI: $bmi")
        println("Phân loại: Bình thường")
    } else if (bmi < 30.0) {
        println("BMI: $bmi")
        println("Phân loại: Thừa cân")
    } else {
        println("BMI: $bmi")
        println("Phân loại: Béo phì")
    }
}
