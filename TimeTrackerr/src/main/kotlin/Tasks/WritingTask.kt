package Tasks

import Models.Task

class WritingTask(name: String, description: String, val wordCount: Int) :
    Task(name, description) {

    override fun displayInfo() {
        println("Yazı: $name - $wordCount words (${timeSpent}h) [${status.displayName()}]")
    }
}