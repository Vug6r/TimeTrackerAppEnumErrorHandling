import java.util.Locale
import java.util.Locale.getDefault

class DesignTask(name: String, description: String, val designType: String,
                 private val baseTime: Float) : Task(name, description), TimeEstimator {

    override fun getEstimatedTime(): Float {
        return when (designType.lowercase(getDefault())) {
            "ui" -> baseTime * 1.2f
            "ux" -> baseTime * 1.5f
            else -> baseTime
        }
    }

    override fun displayInfo() {
        println("Dizayn: $name - $designType (${timeSpent}h / ${getEstimatedTime()}h) [${status.displayName()}]")
    }
}