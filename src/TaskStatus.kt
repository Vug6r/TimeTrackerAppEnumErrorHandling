enum class TaskStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED;

    fun displayName(): String {
        return when (this) {
            PENDING -> "Gözləyir"
            IN_PROGRESS -> "Davam edir"
            COMPLETED -> "Tamamlandı"
            CANCELLED -> "Ləğv edildi"
        }
    }
}
