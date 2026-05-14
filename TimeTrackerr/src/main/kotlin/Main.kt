import Models.TaskTracker
import Enums.TaskStatus
import Tasks.DesignTask
import Tasks.ProgrammingTask
import Tasks.WritingTask

fun main() {
    val tracker = TaskTracker()

    tracker.addTask(ProgrammingTask("Kotlin App", "Mobile app", "Kotlin"))
    tracker.addTask(WritingTask("Documentation", "API docs", 500))
    tracker.addTask(DesignTask("UI Design", "App interface", "UI", 10f))

    loop@ while (true) {
        println("\n1. Aktiv olanlara bax  2. Funksiya elave ele  3. Vaxt elave ele  4. Status deyis  5. Funksiyanı yigisdir  6. Cix")
        print("Secildi: ")

        when (readLine()) {
            "1" -> tracker.displayTasks()
            "2" -> {
                print("Hansi cur olsun? (1. Programming, 2. Yazi, 3. Dizayn): ")
                val choice = readLine()?.toIntOrNull() ?: 0

                if (choice !in 1..3) {
                    println("Sehv secme!")
                    continue@loop
                }
                when (choice) {
                    1 -> {
                        print("Ad: "); val name = readLine() ?: ""
                        print("Izah: "); val description = readLine() ?: ""
                        print("Dil: "); val language = readLine() ?: ""
                        tracker.addTask(ProgrammingTask(name, description, language))
                    }
                    2 -> {
                        print("Ad: "); val name = readLine() ?: ""
                        print("Izah: "); val description = readLine() ?: ""
                        print("Soz sayi: ")
                        val wordCount = readLine()?.toIntOrNull() ?: 0
                        tracker.addTask(WritingTask(name, description, wordCount))
                    }
                    3 -> {
                        print("Ad: "); val name = readLine() ?: ""
                        print("Izah: "); val description = readLine() ?: ""
                        print("Dizayn Tipi (UI, UX): "); val designType = readLine() ?: ""
                        print("Esas vaqt (saat): ")
                        val baseTime = readLine()?.toFloatOrNull() ?: 0f
                        tracker.addTask(DesignTask(name, description, designType, baseTime))
                    }
                }
            }
            "3" -> {
                tracker.displayTasks()
                print("Nomre: ")
                val index = (readLine()?.toIntOrNull() ?: 0) - 1
                print("Elave edilecek saatlar: ")
                val hours = readLine()?.toFloatOrNull() ?: 0f
                tracker.addTime(index, hours)
            }
            "4" -> {
                tracker.displayTasks()
                print("Nomre: ")
                val index = (readLine()?.toIntOrNull() ?: 0) - 1
                println("Status sec: 1. Gozleyir  2. Davam edir  3. Tamamlandi  4. Lev edildi")
                val statusChoice = readLine()?.toIntOrNull() ?: 0
                val status = when (statusChoice) {
                    1 -> TaskStatus.PENDING
                    2 -> TaskStatus.IN_PROGRESS
                    3 -> TaskStatus.COMPLETED
                    4 -> TaskStatus.CANCELLED
                    else -> { println("Sehv secme!"); continue@loop }
                }
                tracker.updateStatus(index, status)
            }
            "5" -> {
                tracker.displayTasks()
                print("Silinmeli nomre: ")
                val index = (readLine()?.toIntOrNull() ?: 0) - 1
                tracker.removeTask(index)
            }
            "6" -> break@loop
            else -> println("Sehv!")
        }
    }
}
