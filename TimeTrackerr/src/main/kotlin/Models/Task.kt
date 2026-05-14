package Models

import Enums.TaskStatus

abstract class Task(
    var name: String,
    var description: String,
    var timeSpent: Float = 0f,
    var status: TaskStatus = TaskStatus.PENDING
) {
    abstract fun displayInfo()
}