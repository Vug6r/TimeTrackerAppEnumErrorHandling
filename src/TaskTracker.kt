class TaskTracker {
    val tasks = mutableListOf<Task>()

    fun addTask(task: Task) {
        try {
            require(task.name.isNotBlank()) { "Task adı boş ola bilməz!" }
            tasks.add(task)
            println("Funksiya əlavə edildi: ${task.name}")
        } catch (e: IllegalArgumentException) {
            println("Xəta: ${e.message}")
        }
    }

    fun removeTask(index: Int) {
        try {
            if (index !in tasks.indices) throw IndexOutOfBoundsException("Səhv nömrə: ${index + 1}")
            val removed = tasks.removeAt(index)
            println("Funksiya yığışdırıldı: ${removed.name}")
        } catch (e: IndexOutOfBoundsException) {
            println("Xəta: ${e.message}")
        }
    }

    fun addTime(index: Int, hours: Float) {
        try {
            if (index !in tasks.indices) throw IndexOutOfBoundsException("Səhv nömrə: ${index + 1}")
            require(hours > 0) { "Saat müsbət olmalıdır!" }
            tasks[index].timeSpent += hours
            println("Vaxt əlavə edildi!")
        } catch (e: IllegalArgumentException) {
            println("Xəta: ${e.message}")
        } catch (e: IndexOutOfBoundsException) {
            println("Xəta: ${e.message}")
        }
    }

    fun updateStatus(index: Int, status: TaskStatus) {
        try {
            if (index !in tasks.indices) throw IndexOutOfBoundsException("Səhv nömrə: ${index + 1}")
            tasks[index].status = status
            println("Status yeniləndi: ${status.displayName()}")
        } catch (e: IndexOutOfBoundsException) {
            println("Xəta: ${e.message}")
        }
    }

    fun getTotalTime(): Float {
        return tasks.map { it.timeSpent.toDouble() }.sum().toFloat()
    }

    fun displayTasks() {
        if (tasks.isEmpty()) {
            println("Funksiya yoxdur!")
            return
        }
        println("\nTasks (Total: ${getTotalTime()}h):")
        tasks.forEachIndexed { i, task ->
            print("${i + 1}. ")
            task.displayInfo()
        }
    }
}